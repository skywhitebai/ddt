package com.sky.ddt.service.impl;

import com.sky.ddt.common.constant.DeliverGoodsConstant;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.dto.deliverGoods.request.*;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuFullProductName;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.entity.ShopSenderAddress;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.Sku;
import com.sky.ddt.service.IDeliverGoodsService;
import com.sky.ddt.service.IShopSenderAddressService;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import com.sky.ddt.util.RegexUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 发货服务
 * @date 2019/9/9 15:43
 */
@Service
public class DeliverGoodsService implements IDeliverGoodsService {
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IShopSenderAddressService shopSenderAddressService;
    @Autowired
    IShopService shopService;
    final static String material = "混棉/Mixed cotton缎纹80%涤纶，10%氨纶，10%棉";
    final static String chineseMaterial = "混棉";
    final static String englishMaterial = "Mixed cotton";

    /**
     * @param file     @return
     * @param response
     * @description 生成仓库装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    @Override
    public BaseResponse generateDeliveryPlan(MultipartFile file, HttpServletResponse response) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (CollectionUtils.isEmpty(list)) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息 数据校验
        StringBuilder sbErro = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("店铺sku"))) {
                sbErroItem.append(",").append(DeliverGoodsConstant.SHOP_SKU_EMPTY);
            }
            String quantityStr = null;
            if (map.containsKey("补货数量")) {
                quantityStr = map.get("补货数量");
            } else if (map.containsKey("空运补货数量")) {
                quantityStr = map.get("空运补货数量");
            } else if (map.containsKey("空派补货数量")) {
                quantityStr = map.get("空派补货数量");
            } else if (map.containsKey("海运补货数量")) {
                quantityStr = map.get("海运补货数量");
            }
            if (StringUtils.isEmpty(quantityStr)) {
                sbErroItem.append(",").append(DeliverGoodsConstant.QUANTITY_ERRO);
            } else {
                Integer quantity = MathUtil.strToInteger(quantityStr);
                if (quantity == null || quantity < 0) {
                    sbErroItem.append(",").append(DeliverGoodsConstant.QUANTITY_ERRO);
                } else {
                    map.put("quantity", quantityStr);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        List<DeliverPlanRequest> deliverPlanRequestList = new ArrayList<>();
        for (Map<String, String> map : list) {
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            DeliverPlanRequest deliverPlanRequest = getDeliverPlanRequest(map.get("店铺sku"), map.get("quantity"));
            deliverPlanRequestList.add(deliverPlanRequest);
        }
        if (CollectionUtils.isEmpty(deliverPlanRequestList)) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //获取店铺地址信息
        ShopSku shopSku = shopSkuService.getShopSkuByShopSku(deliverPlanRequestList.get(0).getShopSku());
        if (shopSku == null) {
            return BaseResponse.failMessage("店铺sku：" + deliverPlanRequestList.get(0).getShopSku() + ",不存在");
        }
        Shop shop = shopService.getShop(shopSku.getShopId());
        if (shop == null) {
            return BaseResponse.failMessage("店铺sku：" + deliverPlanRequestList.get(0).getShopSku() + "的店铺不存在");
        }
        BaseResponse<ShopSenderAddress> shopSenderAddressResponse = shopSenderAddressService.getShopSenderAddress(shopSku.getShopId());
        if (!shopSenderAddressResponse.isSuccess() || shopSenderAddressResponse.getData() == null) {
            return BaseResponse.failMessage("店铺的发货地址不存在");
        }
        //生成excel
        return exportDeliveryPlanExcel(shopSenderAddressResponse.getData(), deliverPlanRequestList, shop, response);
    }

    /**
     * @param
     * @param shop
     * @param response @return
     * @description 下载发货计划excel
     * @author baixueping
     * @date 2019/9/9 17:40
     */
    private BaseResponse exportDeliveryPlanExcel(ShopSenderAddress shopSenderAddress, List<DeliverPlanRequest> deliverPlanRequestList, Shop shop, HttpServletResponse response) {
        String palnName = shop.getShopName() + "-" + DateUtil.getFormatStrMonthDayTime(new Date());
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "deliveryPlan";
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        createRow(sheet, 0, "PlanName", palnName);
        createRow(sheet, 1, "ShipToCountry", shopSenderAddress.getShipToCountry());
        createRow(sheet, 2, "AddressName", shopSenderAddress.getAddressName());
        createRow(sheet, 3, "AddressFieldOne", shopSenderAddress.getAddressFieldOne());
        createRow(sheet, 4, "AddressFieldTwo", shopSenderAddress.getAddressFieldTwo());
        createRow(sheet, 5, "AddressCity", shopSenderAddress.getAddressCity());
        createRow(sheet, 6, "AddressCountryCode", shopSenderAddress.getAddressCountryCode());
        createRow(sheet, 7, "AddressStateOrRegion", shopSenderAddress.getAddressStateOrRegion());
        createRow(sheet, 8, "AddressPostalCode", shopSenderAddress.getAddressPostalCode());
        createRow(sheet, 9, "AddressDistrict", shopSenderAddress.getAddressDistrict());
        createRow(sheet, 10, null, null);
        createRow(sheet, 11, "MerchantSKU", "Quantity");
        for (int i = 0; i < deliverPlanRequestList.size(); i++) {
            Integer rowNum = 12 + i;
            createRow(sheet, rowNum, deliverPlanRequestList.get(i).getShopSku(), MathUtil.integerToStr(deliverPlanRequestList.get(i).getQuantity()));
        }
        return exportExcel(response, workbook, palnName);
    }

    private void createRow(XSSFSheet sheet, Integer rowNum, String cellValue0, String cellValue1) {
        XSSFRow row = sheet.createRow(rowNum);
        XSSFCell cell0 = row.createCell(0);
        cell0.setCellValue(cellValue0);
        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue(cellValue1);
    }

    private DeliverPlanRequest getDeliverPlanRequest(String shopSku, String quantity) {
        DeliverPlanRequest deliverPlanRequest = new DeliverPlanRequest();
        deliverPlanRequest.setShopSku(shopSku);
        deliverPlanRequest.setQuantity(MathUtil.strToInteger(quantity));
        return deliverPlanRequest;
    }

    /**
     * @param file     @return
     * @param response
     * @description 生成仓库装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    @Override
    public BaseResponse generateWarehousePackingList(MultipartFile file, HttpServletResponse response) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        Workbook wb = ExcelUtil.readExcel(file);
        if (wb == null || wb.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel读取失败");
        }
        Sheet sheet = wb.getSheetAt(0);

        //遍历sku信息获取仓库sku信息
        List<WarehousePackingInfo> warehousePackingInfoList = new ArrayList<>();
        BaseResponse<Integer> getWarehousePackingListResponse = getWarehousePackingList(sheet, warehousePackingInfoList);
        if (!getWarehousePackingListResponse.isSuccess()) {
            return getWarehousePackingListResponse;
        }
        Integer rownumTitle = getWarehousePackingListResponse.getData();
        //根据装箱单信息和sku信息生成仓库装箱单
        for (WarehousePackingInfo warehousePackingInfo : warehousePackingInfoList) {
            if (StringUtils.isEmpty(warehousePackingInfo.getShopSku())) {
                continue;
            }
            Sku sku = shopSkuService.getSkuByShopSku(warehousePackingInfo.getShopSku());
            if (sku != null) {
                warehousePackingInfo.setSku(sku.getSku());
            }
        }
        //生成excel
        return exportWarehousePackingListExcel(file.getOriginalFilename(), wb, rownumTitle, warehousePackingInfoList, response);
    }

    private BaseResponse exportWarehousePackingListExcel(String originalFilename, Workbook wb, Integer rownumTitle, List<WarehousePackingInfo> warehousePackingInfoList, HttpServletResponse response) {
        Sheet sheet = wb.getSheetAt(0);
        String extString = originalFilename.substring(originalFilename.lastIndexOf("."));
        createRowWithCellDatas(sheet, rownumTitle, "卖家 SKU", "仓库sku", "已发货");
        for (int i = 0; i < warehousePackingInfoList.size(); i++) {
            createRowWithCellDatas(sheet, rownumTitle + 1 + i, warehousePackingInfoList.get(i).getShopSku(), warehousePackingInfoList.get(i).getSku(), warehousePackingInfoList.get(i).getQuantity());
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("仓库装箱单", "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + extString);//默认Excel名称
            wb.write(outputStream);
            ByteArrayInputStream tempIn = new ByteArrayInputStream(outputStream.toByteArray());
            response.setHeader("Content-Length", String.valueOf(tempIn.available()));
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int a;
            while ((a = tempIn.read(buffer)) != -1) {
                out.write(buffer, 0, a);
            }
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }

    private void createRowWithCellDatas(Sheet sheet, Integer rowNum, String... cellDatas) {
        Row row = sheet.createRow(rowNum);
        for (int i = 0; i < cellDatas.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(cellDatas[i]);
        }
    }

    private BaseResponse getWarehousePackingList(Sheet sheet, List<WarehousePackingInfo> warehousePackingInfoList) {
        //获取最大行数
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("excel内容为空");
        }
        Integer rownumTitle = null;
        //遍历获取货件信息
        for (int i = 0; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            int colnum = row.getLastCellNum();
            if (colnum >= 1) {
                String cellData0 = ExcelUtil.getCellFormatValueString(row.getCell(0));
                if ("卖家 SKU".equals(cellData0)) {
                    rownumTitle = i;
                    break;
                }
            }
        }
        if (rownumTitle == null) {
            return BaseResponse.failMessage("未找到【卖家 SKU】字段");
        }
        Row rowTitle = sheet.getRow(rownumTitle);
        int colnumTitle = rowTitle.getLastCellNum();
        Integer colnumShopSku = 1;
        Integer colnumQuantity = null;
        for (int i = 1; i <= colnumTitle; i++) {
            String cellData = ExcelUtil.getCellFormatValueString(rowTitle.getCell(i));
            if ("已发货".equals(cellData)) {
                colnumQuantity = i;
                break;
            }
        }
        if (colnumQuantity == null) {
            return BaseResponse.failMessage("没有【已发货】字段");
        }
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(0));
            String quantity = ExcelUtil.getCellFormatValueString(row.getCell(colnumQuantity));
            WarehousePackingInfo warehousePackingInfo = new WarehousePackingInfo();
            warehousePackingInfo.setQuantity(quantity);
            warehousePackingInfo.setShopSku(shopSku);
            warehousePackingInfoList.add(warehousePackingInfo);
        }
        //删除数据
        for (int i = rownum; i >= rownumTitle; i--) {
            Row row = sheet.getRow(i);
            sheet.removeRow(row);
        }
        return BaseResponse.successData(rownumTitle);
    }


    /**
     * @param file
     * @param numberOfBoxes
     * @param response
     * @return
     * @description 生成亚马逊装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    @Override
    public BaseResponse generateAmazonPackingList(MultipartFile file, Integer numberOfBoxes, HttpServletResponse response) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        if (numberOfBoxes == null || numberOfBoxes <= 0) {
            return BaseResponse.failMessage("箱数必须大于0");
        }
        Workbook wb = ExcelUtil.readExcel(file);
        if (wb == null || wb.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel读取失败");
        }
        Sheet sheet = wb.getSheetAt(0);
        List<AmazonPackingListInfo> amazonPackingListInfoList = new ArrayList<>();
        BaseResponse<Integer> getAmazonPackingListInfoResponse = getAmazonPackingListInfoList(sheet, amazonPackingListInfoList);
        if (!getAmazonPackingListInfoResponse.isSuccess()) {
            return getAmazonPackingListInfoResponse;
        }
        Integer rownumTitle = getAmazonPackingListInfoResponse.getData();
        return exportAmazonPackingListExcel(file.getOriginalFilename(), wb, rownumTitle, numberOfBoxes, amazonPackingListInfoList, response);
    }

    private BaseResponse exportAmazonPackingListExcel(String originalFilename, Workbook wb, Integer rownumTitle, Integer numberOfBoxes, List<AmazonPackingListInfo> amazonPackingListInfoList, HttpServletResponse response) {
        Sheet sheet = wb.getSheetAt(0);
        String fbaNo = ExcelUtil.getCellFormatValueString(sheet.getRow(0).getCell(1));
        String extString = originalFilename.substring(originalFilename.lastIndexOf("."));
        createRowAmazonPackingListTitle(sheet, rownumTitle, fbaNo, numberOfBoxes);
        for (int i = 0; i < amazonPackingListInfoList.size(); i++) {
            createRowAmazonPackingList(sheet, rownumTitle + 1 + i, amazonPackingListInfoList.get(i), numberOfBoxes);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("亚马逊装箱单", "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + extString);//默认Excel名称
            wb.write(outputStream);
            ByteArrayInputStream tempIn = new ByteArrayInputStream(outputStream.toByteArray());
            response.setHeader("Content-Length", String.valueOf(tempIn.available()));
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int a;
            while ((a = tempIn.read(buffer)) != -1) {
                out.write(buffer, 0, a);
            }
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }

    }

    private void createRowAmazonPackingList(Sheet sheet, Integer rowNum, AmazonPackingListInfo amazonPackingListInfo, Integer numberOfBoxes) {
        Integer arratLength = 10 + 2 * numberOfBoxes;
        String[] cellDatas = new String[arratLength];
        cellDatas[0] = amazonPackingListInfo.getMerchantSku();
        cellDatas[1] = amazonPackingListInfo.getTitle();
        cellDatas[2] = amazonPackingListInfo.getAsin();
        cellDatas[3] = amazonPackingListInfo.getAsin();
        cellDatas[9] = amazonPackingListInfo.getShipped();
        for (int i = 0; i < numberOfBoxes; i++) {
            cellDatas[11 + 2 * i] = "Not Needed";
        }
        createRowWithCellDatas(sheet, rowNum, cellDatas);
    }

    private void createRowAmazonPackingListTitle(Sheet sheet, Integer rowNum, String fbaNo, Integer numberOfBoxes) {
        Integer arratLength = 10 + 2 * numberOfBoxes;
        String[] cellDatas = new String[arratLength];
        cellDatas[0] = "Merchant SKU";
        cellDatas[1] = "Title";
        cellDatas[2] = "ASIN";
        cellDatas[3] = "FNSKU";
        cellDatas[4] = "external-id";
        cellDatas[5] = "Condition";
        cellDatas[6] = "Who Will Prep?";
        cellDatas[7] = "Prep Type";
        cellDatas[8] = "Who Will Label?";
        cellDatas[9] = "Shipped";
        for (int i = 0; i < numberOfBoxes; i++) {
            String uName = fbaNo + "U" + to3str(i + 1);
            cellDatas[10 + 2 * i] = uName + " - Unit Quantity";
            cellDatas[11 + 2 * i] = uName + " Expiration Date (mm/dd/yy)";
        }
        createRowWithCellDatas(sheet, rowNum, cellDatas);
    }

    String to3str(Integer num) {
        if (num < 10) {
            return "00" + num;
        } else if (num < 100) {
            return "0" + num;
        } else {
            return num.toString();
        }
    }

    private BaseResponse<Integer> getAmazonPackingListInfoList(Sheet sheet, List<AmazonPackingListInfo> amazonPackingListInfoList) {
//获取最大行数
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("excel内容为空");
        }
        Integer rownumTitle = null;
        //遍历获取货件信息
        for (int i = 0; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            int colnum = row.getLastCellNum();
            if (colnum >= 1) {
                String cellData0 = ExcelUtil.getCellFormatValueString(row.getCell(0));
                if ("卖家 SKU".equals(cellData0)) {
                    rownumTitle = i;
                    break;
                }
            }
        }
        if (rownumTitle == null) {
            return BaseResponse.failMessage("未找到【卖家 SKU】字段");
        }
        Row rowTitle = sheet.getRow(rownumTitle);
        int colnumTitle = rowTitle.getLastCellNum();
        Integer colnumShopSku = 0;
        Integer colnumQuantity = null;
        Integer colnumTitleStr = null;
        Integer colnumAsin = null;
        Integer colnumFnsku = null;
        for (int i = 1; i <= colnumTitle; i++) {
            String cellData = ExcelUtil.getCellFormatValueString(rowTitle.getCell(i));
            if ("标题".equals(cellData)) {
                colnumTitleStr = i;
            } else if ("ASIN".equals(cellData)) {
                colnumAsin = i;
            } else if ("FNSKU".equals(cellData)) {
                colnumFnsku = i;
            } else if ("已发货".equals(cellData)) {
                colnumQuantity = i;
            }
        }
        if (colnumTitleStr == null) {
            return BaseResponse.failMessage("没有【标题】字段");
        }
        if (colnumTitleStr == null) {
            return BaseResponse.failMessage("没有【ASIN】字段");
        }
        if (colnumAsin == null) {
            return BaseResponse.failMessage("没有【FNSKU】字段");
        }
        if (colnumFnsku == null) {
            return BaseResponse.failMessage("没有【已发货】字段");
        }
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(colnumShopSku));
            String title = ExcelUtil.getCellFormatValueString(row.getCell(colnumTitleStr));
            String asin = ExcelUtil.getCellFormatValueString(row.getCell(colnumAsin));
            String fnsku = ExcelUtil.getCellFormatValueString(row.getCell(colnumFnsku));
            String quantity = ExcelUtil.getCellFormatValueString(row.getCell(colnumQuantity));
            AmazonPackingListInfo amazonPackingListInfo = new AmazonPackingListInfo();
            amazonPackingListInfo.setMerchantSku(shopSku);
            amazonPackingListInfo.setTitle(title);
            amazonPackingListInfo.setAsin(asin);
            amazonPackingListInfo.setFnsku(fnsku);
            amazonPackingListInfo.setShipped(quantity);
            amazonPackingListInfoList.add(amazonPackingListInfo);
        }
        //删除数据
        for (int i = rownum; i >= rownumTitle; i--) {
            Row row = sheet.getRow(i);
            sheet.removeRow(row);
        }
        return BaseResponse.successData(rownumTitle);
    }

    /**
     * @param file     @return
     * @param type
     * @param fbaNo
     * @param response @description 生成发票
     * @author baixueping
     * @date 2019/9/9 15:47
     */
    @Override
    public BaseResponse generateInvoice(MultipartFile file, String type, String fbaNo, HttpServletResponse response) {
        if (StockConsatnt.StockQuantityTypeEnum.getStockQuantityTypeEnum(type) == null) {
            return BaseResponse.failMessage(DeliverGoodsConstant.INVOICE_TYPE_ERRO);
        }
        /*if (StringUtils.isEmpty(fbaNo)) {
            return BaseResponse.failMessage(DeliverGoodsConstant.FBA_NO_EMPTY);
        }*/
        if (StockConsatnt.StockQuantityTypeEnum.getStockQuantityTypeEnum(type) == null) {
            return BaseResponse.failMessage("发票类型错误");
        }
        //读取数据
        BaseResponse<InvoiceInfo> invoiceInfoBaseResponse = getInvoiceInfo(file);
        if (!invoiceInfoBaseResponse.isSuccess()) {
            return invoiceInfoBaseResponse;
        }
        InvoiceInfo invoiceInfo = invoiceInfoBaseResponse.getData();
        if (StringUtils.isEmpty(invoiceInfo.getShipmentId())) {
            return BaseResponse.failMessage(DeliverGoodsConstant.SHIPMENT_ID_EMPTY);
        }
        //FBA单号对应 shipment id
        invoiceInfo.setFbaNo(invoiceInfo.getShipmentId());
        return generateInvoiceByType(invoiceInfo, type, response);
    }

    BaseResponse generateInvoiceByType(InvoiceInfo invoiceInfo, String type, HttpServletResponse response) {
        if (StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(type)) {
            return generateInvoiceKy(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(type)) {
            return generateInvoiceKp(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(type)) {
            return generateInvoiceHy(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.HY2.getType().equals(type)) {
            return generateInvoiceHy2(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.DL.getType().equals(type)) {
            return generateInvoiceDl(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.DLX.getType().equals(type)) {
            return generateInvoiceDlx(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.AMHY.getType().equals(type)) {
            return generateInvoiceAmhy(invoiceInfo, response);
        } else if (StockConsatnt.StockQuantityTypeEnum.AMTY.getType().equals(type)) {
            return generateInvoiceAmty(invoiceInfo, response);
        }
        return BaseResponse.failMessage("暂未实现");
    }

    /**
     * @param invoiceInfo
     * @param invoiceSkuInfoList
     * @param type
     * @param response           @return
     * @description 生成发票
     * @author baixueping
     * @date 2020/8/12 16:59
     */
    @Override
    public BaseResponse generateInvoice(InvoiceInfo invoiceInfo, List<InvoiceSkuInfo> invoiceSkuInfoList, String type, HttpServletResponse response) {
        invoiceInfo = getInvoiceInfo(invoiceInfo, invoiceSkuInfoList);
        return generateInvoiceByType(invoiceInfo, type, response);
    }


    private BaseResponse generateInvoiceDlx(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateDeLiXun.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceDlx(sheetInovice, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱德立讯发票";
        return exportExcel(response, wb, fileName);
    }

    private void updateSheetInoviceDlx(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        sheetInovice.getRow(4).getCell(3).setCellValue(invoiceInfo.getShipmentId());
        sheetInovice.getRow(12).getCell(3).setCellValue(invoiceInfo.getShipTo());
        sheetInovice.getRow(14).getCell(3).setCellValue(getPostalCode(invoiceInfo.getShipTo()));
        Double totalWeight = 0.00;
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(25 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            Double weight = invoicePackingInfo.getWeight() * invoicePackingInfo.getQuantity();
            rowGoodsInfo.createCell(1).setCellValue(weight);
            rowGoodsInfo.createCell(3).setCellValue(invoicePackingInfo.getLength());
            rowGoodsInfo.createCell(4).setCellValue(invoicePackingInfo.getWidth());
            rowGoodsInfo.createCell(5).setCellValue(invoicePackingInfo.getHeight());
            rowGoodsInfo.createCell(6).setCellValue(invoicePackingInfo.getChineseProductName());
            rowGoodsInfo.createCell(7).setCellValue(invoicePackingInfo.getEnglishProductName());
            rowGoodsInfo.createCell(8).setCellValue("USD");
            rowGoodsInfo.createCell(9).setCellValue(invoicePackingInfo.getUnitPrice());
            rowGoodsInfo.createCell(10).setCellValue(invoicePackingInfo.getHsCode());
            rowGoodsInfo.createCell(11).setCellValue(invoicePackingInfo.getBrand());
            rowGoodsInfo.createCell(13).setCellValue(invoicePackingInfo.getMaterial());
            rowGoodsInfo.createCell(14).setCellValue(invoicePackingInfo.getPurpose());
            rowGoodsInfo.createCell(15).setCellValue("N");
            rowGoodsInfo.createCell(16).setCellValue("N");
            rowGoodsInfo.createCell(17).setCellValue(invoicePackingInfo.getWeight());
            rowGoodsInfo.createCell(18).setCellValue(invoicePackingInfo.getQuantity());
            totalWeight += weight;
        }
        sheetInovice.getRow(2).getCell(3).setCellValue(totalWeight);
    }

    private BaseResponse generateInvoiceDl(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateDl.xlsx").getPath();
        updateInvoiceInfoPackageMax(invoiceInfo);

        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        Sheet sheetPacking = wb.getSheetAt(1);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceDl(sheetInovice, invoiceInfo, priceStyle);
        updateSheetPackingDl(sheetPacking, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱DL海运发票";
        return exportExcel(response, wb, fileName);
    }

    /**
     * @param
     * @return
     * @description 分箱操作
     * @author baixueping
     * @date 2021/1/8 15:47
     */
    private void updateInvoiceInfoPackageMax(InvoiceInfo invoiceInfo) {
        updateInvoiceInfoPackageInfoList(invoiceInfo);
        List<InvoiceGoodsInfo> invoiceGoodsInfoList = getInvoiceGoodsInfoList(invoiceInfo.getInvoicePackingInfoList(), invoiceInfo.getUnitPrice());
        invoiceInfo.setInvoiceGoodsInfoList(invoiceGoodsInfoList);
    }

    private void updateInvoiceInfoPackageInfoList(InvoiceInfo invoiceInfo) {
        List<InvoicePackingInfo> invoicePackingInfoList = new ArrayList<>();
        Map<String, InvoicePackingInfo> invoicePackingInfoMap = invoiceInfo.getInvoicePackingInfoList().parallelStream().collect(Collectors.groupingBy(InvoicePackingInfo::getContainerNo, Collectors.collectingAndThen(Collectors.reducing((c1, c2) -> c1.getQuantity() >= c2.getQuantity() ? c1 : c2), Optional::get)));
        for (String containerNo : invoicePackingInfoMap.keySet()) {
            InvoicePackingInfo invoicePackingInfo = invoicePackingInfoMap.get(containerNo);
            Integer quantity = invoiceInfo.getInvoicePackingInfoList().parallelStream().filter(item -> item.getContainerNo().equals(containerNo)).mapToInt(InvoicePackingInfo::getQuantity).sum();
            invoicePackingInfo.setQuantity(quantity);
            invoicePackingInfoList.add(invoicePackingInfo);
        }
        invoicePackingInfoList.sort((c1, c2) -> c1.getContainerNo().compareTo(c2.getContainerNo()));
        invoiceInfo.setInvoicePackingInfoList(invoicePackingInfoList);
    }

    private void updateSheetPackingDl(Sheet sheetPacking, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetPacking.createRow(5 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(1).setCellValue(invoicePackingInfo.getGoodsName());
            rowGoodsInfo.createCell(2).setCellValue(1);
            rowGoodsInfo.createCell(3).setCellValue(invoicePackingInfo.getQuantity());

            Double totalWeight = invoicePackingInfo.getWeight() * invoicePackingInfo.getQuantity();
            Double weight = invoicePackingInfo.getWeight();
            if (totalWeight > 21) {
                totalWeight = 21.0;
                weight = MathUtil.divide(totalWeight, invoicePackingInfo.getQuantity(), 2);
            }
            rowGoodsInfo.createCell(4).setCellValue(weight);
            rowGoodsInfo.createCell(5).setCellValue(weight);
            rowGoodsInfo.createCell(6).setCellValue(totalWeight);
            rowGoodsInfo.createCell(7).setCellValue(totalWeight);

            rowGoodsInfo.createCell(8).setCellValue("37x52x54");
        }
    }

    private void updateSheetInoviceDl(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置客户订单号
        Row rowFbaNo = sheetInovice.getRow(2);
        rowFbaNo.getCell(1).setCellValue("FBA 号： " + invoiceInfo.getFbaNo());
        //设置地址
        Row rowShippingAddress = sheetInovice.getRow(5);
        rowShippingAddress.getCell(1).setCellValue("Consignee（complete name and address)    收货人公司名地址，电话\n" + invoiceInfo.getShipTo());
        //设置产品信息
        int contentIndex = 8;
        for (int i = 0; i < invoiceInfo.getInvoiceGoodsInfoList().size(); i++) {
            if (i >= 2) {
                sheetInovice.shiftRows(contentIndex + i, sheetInovice.getLastRowNum(), 1, true, false);
            }
            Row rowGoodsInfo = sheetInovice.getRow(contentIndex + i);
            if (rowGoodsInfo == null) {
                rowGoodsInfo = sheetInovice.createRow(contentIndex + i);
            }
            InvoiceGoodsInfo invoiceGoodsInfo = invoiceInfo.getInvoiceGoodsInfoList().get(i);
            rowGoodsInfo.createCell(2).setCellValue(invoiceGoodsInfo.getHsCode());
            rowGoodsInfo.createCell(3).setCellValue(invoiceGoodsInfo.getGoodsName());
            rowGoodsInfo.createCell(4).setCellValue("无");
            rowGoodsInfo.createCell(5).setCellValue("无");
            rowGoodsInfo.createCell(6).setCellValue(invoiceGoodsInfo.getMaterial());
            rowGoodsInfo.createCell(7).setCellValue(invoiceGoodsInfo.getPurpose());
            rowGoodsInfo.createCell(8).setCellValue(invoiceGoodsInfo.getNumberOfBoxes());
            rowGoodsInfo.createCell(9).setCellValue(invoiceGoodsInfo.getQuantity());
            rowGoodsInfo.createCell(10).setCellValue(invoiceGoodsInfo.getWeight() + "kg");
            rowGoodsInfo.createCell(11).setCellValue(invoiceGoodsInfo.getUnitPrice());
            rowGoodsInfo.getCell(11).setCellStyle(priceStyle);
        }
    }

    private BaseResponse generateInvoiceHy2(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateHy2.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceHy2(sheetInovice, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱海运红单发票";
        return exportExcel(response, wb, fileName);
    }

    private BaseResponse generateInvoiceAmhy(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateAmhy.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceAmhy(sheetInovice, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱阿玛海运发票";
        return exportExcel(response, wb, fileName);
    }


    private BaseResponse generateInvoiceAmty(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateAmty.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceAmty(sheetInovice, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱阿玛海运发票";
        return exportExcel(response, wb, fileName);
    }

    private void updateSheetInoviceAmty(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置总箱数
        Row row11 = sheetInovice.getRow(10);
        row11.getCell(5).setCellValue(invoiceInfo.getNumberOfBoxes());
        //设置重量
        Row rowWeight = sheetInovice.getRow(11);
        //设置客户订单号
        Row row3 = sheetInovice.getRow(2);
        row3.getCell(1).setCellValue(invoiceInfo.getFbaNo() + "-" + invoiceInfo.getShipmentId() + "-" + invoiceInfo.getNumberOfBoxes());
        //设置FBANO
        Row rowFbaNo = sheetInovice.getRow(3);
        rowFbaNo.getCell(1).setCellValue(invoiceInfo.getFbaNo());
        //设置Shipment ID
        Row rowShipmentID = sheetInovice.getRow(4);
        rowShipmentID.getCell(1).setCellValue(invoiceInfo.getShipmentId());
        //ReferenceId*
        Row rowReferenceId = sheetInovice.getRow(5);
        rowReferenceId.getCell(1).setCellValue(invoiceInfo.getReferenceId());
        //设置地址
        Row rowAddress = sheetInovice.getRow(12);
        rowAddress.getCell(1).setCellValue(invoiceInfo.getShipTo());
        //设置邮编
        Row rowPostalCode = sheetInovice.getRow(14);
        rowPostalCode.getCell(1).setCellValue(getPostalCode(invoiceInfo.getShipTo()));
        Double totalWeight = 0.0;
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(18 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(1).setCellValue(invoicePackingInfo.getChineseProductName());
            rowGoodsInfo.createCell(2).setCellValue(invoicePackingInfo.getEnglishProductName());
            rowGoodsInfo.createCell(3).setCellValue(invoicePackingInfo.getChineseMaterial());//中文材质
            rowGoodsInfo.createCell(4).setCellValue(invoicePackingInfo.getEnglishMaterial());//英文材质
            rowGoodsInfo.createCell(5).setCellValue("穿");//中文用途
            rowGoodsInfo.createCell(6).setCellValue("Wear");//英文用途
            rowGoodsInfo.createCell(7).setCellValue(invoicePackingInfo.getHsCode());// 海关编码
            rowGoodsInfo.createCell(8).setCellValue(invoicePackingInfo.getQuantity());
            rowGoodsInfo.createCell(9).setCellValue(invoicePackingInfo.getCostPrice());
            rowGoodsInfo.createCell(10).setCellValue(invoicePackingInfo.getTotalCostPrice());
            rowGoodsInfo.createCell(11).setCellValue(1);//箱数
            rowGoodsInfo.createCell(12).setCellValue("不带电不带磁");//是否带电或带磁
            rowGoodsInfo.createCell(13).setCellValue(invoicePackingInfo.getBrand());
            //rowGoodsInfo.createCell(14).setCellValue();//Model（型号
            rowGoodsInfo.createCell(15).setCellValue(invoicePackingInfo.getTotalWeight());
            if (invoicePackingInfo.getTotalWeight() != null) {
                totalWeight += invoicePackingInfo.getTotalWeight();
            }
            rowGoodsInfo.createCell(16).setCellValue(invoicePackingInfo.getWeight());
            rowGoodsInfo.createCell(17).setCellValue(invoicePackingInfo.getLength());
            rowGoodsInfo.createCell(18).setCellValue(invoicePackingInfo.getWidth());
            rowGoodsInfo.createCell(19).setCellValue(invoicePackingInfo.getHeight());

            rowGoodsInfo.createCell(22).setCellValue("无");
            rowGoodsInfo.createCell(23).setCellValue("不享受");
        }
        rowWeight.getCell(5).setCellValue(totalWeight);
    }

    private void updateSheetInoviceHy2(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置客户订单号
        Row rowFbaNo = sheetInovice.getRow(1);
        rowFbaNo.getCell(3).setCellValue(invoiceInfo.getFbaNo());
        //设置重量
        Row rowWeight = sheetInovice.getRow(2);
        rowWeight.getCell(3).setCellValue(50);
        //设置Shipment ID
        Row rowShipmentID = sheetInovice.getRow(3);
        rowShipmentID.getCell(3).setCellValue(invoiceInfo.getShipmentId());
        //设置地址
        Row rowAddress = sheetInovice.getRow(10);
        rowAddress.getCell(3).setCellValue(invoiceInfo.getShipTo());
        //设置邮编
        Row rowPostalCode = sheetInovice.getRow(12);
        rowPostalCode.getCell(3).setCellValue(getPostalCode(invoiceInfo.getShipTo()));
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(16 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(1).setCellValue(23);

            rowGoodsInfo.createCell(3).setCellValue(50);
            rowGoodsInfo.createCell(4).setCellValue(35);
            rowGoodsInfo.createCell(5).setCellValue(50);
            rowGoodsInfo.createCell(6).setCellValue("否");
            rowGoodsInfo.createCell(7).setCellValue(invoicePackingInfo.getEnglishProductName());
            rowGoodsInfo.createCell(8).setCellValue(invoicePackingInfo.getChineseProductName());
            //rowGoodsInfo.createCell(9).setCellValue(); 毛重
            rowGoodsInfo.createCell(10).setCellValue(invoicePackingInfo.getQuantity());
            rowGoodsInfo.createCell(11).setCellValue(invoicePackingInfo.getUnitPrice());
            rowGoodsInfo.createCell(12).setCellValue(invoicePackingInfo.getHsCode());// 海关编码
            rowGoodsInfo.createCell(13).setCellValue(invoicePackingInfo.getBrand());
            //rowGoodsInfo.createCell(14).setCellValue(); 型号
            rowGoodsInfo.createCell(15).setCellValue(invoicePackingInfo.getMaterial());
            rowGoodsInfo.createCell(16).setCellValue(invoicePackingInfo.getPurpose());
        }
    }

    private void updateSheetInoviceAmhy(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置客户订单号
        Row rowFbaNo = sheetInovice.getRow(1);
        rowFbaNo.getCell(3).setCellValue(invoiceInfo.getFbaNo() + "-" + invoiceInfo.getShipmentId() + "-" + invoiceInfo.getNumberOfBoxes());
        //设置重量
        Row rowWeight = sheetInovice.getRow(2);
        rowWeight.getCell(3).setCellValue(invoiceInfo.getNumberOfBoxes() * 20);
        //设置Shipment ID
        Row rowShipmentID = sheetInovice.getRow(4);
        rowShipmentID.getCell(3).setCellValue(invoiceInfo.getShipmentId());
        //ReferenceId*
        Row rowReferenceId = sheetInovice.getRow(5);
        rowReferenceId.getCell(3).setCellValue(invoiceInfo.getReferenceId());
        //设置地址
        Row rowAddress = sheetInovice.getRow(12);
        rowAddress.getCell(3).setCellValue(invoiceInfo.getShipTo());
        //设置邮编
        Row rowPostalCode = sheetInovice.getRow(14);
        rowPostalCode.getCell(3).setCellValue(getPostalCode(invoiceInfo.getShipTo()));
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(25 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(1).setCellValue(23);

            rowGoodsInfo.createCell(3).setCellValue(50);
            rowGoodsInfo.createCell(4).setCellValue(35);
            rowGoodsInfo.createCell(5).setCellValue(50);
            rowGoodsInfo.createCell(6).setCellValue("否");
            rowGoodsInfo.createCell(7).setCellValue(invoicePackingInfo.getEnglishProductName());
            rowGoodsInfo.createCell(8).setCellValue(invoicePackingInfo.getChineseProductName());
            //rowGoodsInfo.createCell(9).setCellValue(); 毛重
            rowGoodsInfo.createCell(10).setCellValue(invoicePackingInfo.getQuantity());
            rowGoodsInfo.createCell(11).setCellValue(invoicePackingInfo.getUnitPrice());
            rowGoodsInfo.createCell(12).setCellValue(invoicePackingInfo.getHsCode());// 海关编码
            rowGoodsInfo.createCell(13).setCellValue("无");
            rowGoodsInfo.createCell(14).setCellValue("无"); //型号
            rowGoodsInfo.createCell(15).setCellValue(invoicePackingInfo.getMaterial());
            rowGoodsInfo.createCell(16).setCellValue(invoicePackingInfo.getPurpose());
            rowGoodsInfo.createCell(17).setCellValue("USD");
            rowGoodsInfo.createCell(18).setCellValue("CN");
            rowGoodsInfo.createCell(19).setCellValue("N");
            //总申报
            rowGoodsInfo.createCell(20).setCellValue(invoicePackingInfo.getTotalPrice());
            rowGoodsInfo.createCell(23).setCellValue("无");
            rowGoodsInfo.createCell(24).setCellValue("不享受");
            //图片
            rowGoodsInfo.createCell(28).setCellValue(invoicePackingInfo.getUnitPrice());
        }
    }

    private BaseResponse generateInvoiceHy(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateHy.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        Sheet sheetPacking = wb.getSheetAt(1);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceHy(sheetInovice, invoiceInfo, priceStyle);
        updateSheetPackingKp(sheetPacking, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱海运红单发票";
        return exportExcel(response, wb, fileName);
    }

    private void updateSheetInoviceHy(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置日期 FBA单号
        Row rowFbaNo = sheetInovice.getRow(1);
        rowFbaNo.getCell(1).setCellValue(DateUtil.getFormatDateStr(invoiceInfo.getDate(), "yyyy/MM/dd"));
        rowFbaNo.getCell(4).setCellValue(invoiceInfo.getFbaNo());
        //设置地址
        Row rowAddress = sheetInovice.getRow(3);
        rowAddress.getCell(3).setCellValue(invoiceInfo.getShipTo());
        //设置产品信息
        for (int i = 0; i < invoiceInfo.getInvoiceGoodsInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(5 + i);
            InvoiceGoodsInfo invoiceGoodsInfo = invoiceInfo.getInvoiceGoodsInfoList().get(i);
            rowGoodsInfo.createCell(1).setCellValue(invoiceGoodsInfo.getGoodsName());
            rowGoodsInfo.createCell(2).setCellValue(invoiceGoodsInfo.getHsCode());
            rowGoodsInfo.createCell(3).setCellValue(invoiceGoodsInfo.getMaterial());
            rowGoodsInfo.createCell(4).setCellValue(invoiceGoodsInfo.getPurpose());
            rowGoodsInfo.createCell(5).setCellValue(invoiceGoodsInfo.getQuantity());
            rowGoodsInfo.createCell(6).setCellValue(invoiceGoodsInfo.getUnitPrice());
            rowGoodsInfo.getCell(6).setCellStyle(priceStyle);
            rowGoodsInfo.createCell(7).setCellValue(invoiceGoodsInfo.getTotalPrice());
            rowGoodsInfo.getCell(7).setCellStyle(priceStyle);
        }
        //设置箱数
        Row rowGoodsInfoFirst = sheetInovice.getRow(5);
        rowGoodsInfoFirst.createCell(0).setCellValue(invoiceInfo.getNumberOfBoxes());
        if (invoiceInfo.getInvoiceGoodsInfoList().size() > 1) {
            CellRangeAddress region = new CellRangeAddress(5, 4 + invoiceInfo.getInvoiceGoodsInfoList().size(), 0, 0);
            sheetInovice.addMergedRegion(region);
        }
        //设置总价
        Row rowTotalPrice = sheetInovice.createRow(5 + invoiceInfo.getInvoiceGoodsInfoList().size());
        rowTotalPrice.createCell(0).setCellValue("TOTAL:");
        rowTotalPrice.createCell(5).setCellValue(invoiceInfo.getTotalQuantity());
        rowTotalPrice.createCell(7).setCellValue(invoiceInfo.getTotalPrice());
        rowTotalPrice.getCell(7).setCellStyle(priceStyle);
    }

    /**
     * @param
     * @return
     * @description 生成空派发票
     * @author baixueping
     * @date 2019/9/23 9:02
     */
    private BaseResponse generateInvoiceKp(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateKp.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        Sheet sheetPacking = wb.getSheetAt(1);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceKp(sheetInovice, invoiceInfo, priceStyle);
        updateSheetPackingKp(sheetPacking, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱空派发票";
        return exportExcel(response, wb, fileName);
    }

    private void updateSheetPackingKp(Sheet sheetPacking, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetPacking.createRow(3 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(0).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(1).setCellValue("不带电不带磁");
            rowGoodsInfo.createCell(2).setCellValue(invoicePackingInfo.getChineseProductName());
            rowGoodsInfo.createCell(3).setCellValue(invoicePackingInfo.getEnglishProductName());
            rowGoodsInfo.createCell(4).setCellValue(invoicePackingInfo.getHsCode());
            rowGoodsInfo.createCell(4).setCellValue(invoicePackingInfo.getHsCode());
            rowGoodsInfo.createCell(5).setCellValue(invoicePackingInfo.getQuantity());
            rowGoodsInfo.createCell(6).setCellValue(1);
            rowGoodsInfo.createCell(7).setCellValue(50);
            rowGoodsInfo.createCell(8).setCellValue(35);
            rowGoodsInfo.createCell(9).setCellValue(50);
            rowGoodsInfo.createCell(10).setCellValue(21);
            rowGoodsInfo.createCell(12).setCellValue("无");
            rowGoodsInfo.createCell(13).setCellValue("无");
            rowGoodsInfo.createCell(14).setCellValue(invoicePackingInfo.getMaterial());
            rowGoodsInfo.createCell(15).setCellValue(invoicePackingInfo.getPurpose());
        }
    }

    private void updateSheetInoviceKp(Sheet sheetInovice, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置日期 FBA单号
        Row rowFbaNo = sheetInovice.getRow(1);
        rowFbaNo.getCell(1).setCellValue(DateUtil.getFormatDateStr(invoiceInfo.getDate(), "yyyy/MM/dd"));
        rowFbaNo.getCell(3).setCellValue("FBA No.: " + invoiceInfo.getShipmentId());
        //设置地址
        Row rowAddress = sheetInovice.getRow(3);
        rowAddress.getCell(3).setCellValue(invoiceInfo.getShipTo());
        //设置产品信息
        for (int i = 0; i < invoiceInfo.getInvoiceGoodsInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.createRow(5 + i);
            InvoiceGoodsInfo invoiceGoodsInfo = invoiceInfo.getInvoiceGoodsInfoList().get(i);
            rowGoodsInfo.createCell(1).setCellValue(invoiceGoodsInfo.getGoodsName());
            rowGoodsInfo.createCell(2).setCellValue(invoiceGoodsInfo.getHsCode());
            rowGoodsInfo.createCell(3).setCellValue(invoiceGoodsInfo.getMaterial());
            rowGoodsInfo.createCell(4).setCellValue(invoiceGoodsInfo.getPurpose());
            rowGoodsInfo.createCell(5).setCellValue(invoiceGoodsInfo.getQuantity());
            rowGoodsInfo.createCell(6).setCellValue(invoiceGoodsInfo.getUnitPrice());
            rowGoodsInfo.getCell(6).setCellStyle(priceStyle);
            rowGoodsInfo.createCell(7).setCellValue(invoiceGoodsInfo.getTotalPrice());
            rowGoodsInfo.getCell(7).setCellStyle(priceStyle);
        } //设置箱数
        Row rowGoodsInfoFirst = sheetInovice.getRow(5);
        rowGoodsInfoFirst.createCell(0).setCellValue(invoiceInfo.getNumberOfBoxes());
        if (invoiceInfo.getInvoiceGoodsInfoList().size() > 1) {
            CellRangeAddress region = new CellRangeAddress(5, 4 + invoiceInfo.getInvoiceGoodsInfoList().size(), 0, 0);
            sheetInovice.addMergedRegion(region);
        }
        //设置总价
        Row rowTotalPrice = sheetInovice.createRow(5 + invoiceInfo.getInvoiceGoodsInfoList().size());
        rowTotalPrice.createCell(0).setCellValue("TOTAL:");
        rowTotalPrice.createCell(5).setCellValue(invoiceInfo.getTotalQuantity());
        rowTotalPrice.createCell(7).setCellValue(invoiceInfo.getTotalPrice());
        rowTotalPrice.getCell(7).setCellStyle(priceStyle);
    }

    /**
     * @param
     * @param response
     * @return
     * @description 生成空运发票
     * @author baixueping
     * @date 2019/9/18 9:28
     */
    private BaseResponse generateInvoiceKy(InvoiceInfo invoiceInfo, HttpServletResponse response) {
        //读取模板
        String path = DeliverGoodsService.class.getClassLoader().getResource("template/invoice/invoiceTemplateKy.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheetInovice = wb.getSheetAt(0);
        Sheet sheetPacking = wb.getSheetAt(1);
        CellStyle priceStyle = getPriceStyle(wb);
        updateSheetInoviceKy(sheetInovice, invoiceInfo);
        updateSheetPackingKy(sheetPacking, invoiceInfo, priceStyle);
        //导出
        String fileName = invoiceInfo.getShopName() + "-" + invoiceInfo.getFbaNo() + "-" + invoiceInfo.getNumberOfBoxes() + "箱美国FBA快递发票（ups fedex dhl）";
        return exportExcel(response, wb, fileName);
    }

    private CellStyle getPriceStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("$#,##0.00"));
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);
        return cellStyle;
    }

    private BaseResponse exportExcel(HttpServletResponse response, Workbook wb, String fileName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
            wb.write(outputStream);
            ByteArrayInputStream tempIn = new ByteArrayInputStream(outputStream.toByteArray());
            response.setHeader("Content-Length", String.valueOf(tempIn.available()));
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int a;
            while ((a = tempIn.read(buffer)) != -1) {
                out.write(buffer, 0, a);
            }
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }

    /**
     * @param
     * @param
     * @return
     * @description 设置空运发票信息
     * @author baixueping
     * @date 2019/9/18 16:02
     */
    private void updateSheetInoviceKy(Sheet sheetInovice, InvoiceInfo invoiceInfo) {
        //设置FBA单号
        Row rowFbaNo = sheetInovice.getRow(3);
        rowFbaNo.getCell(1).setCellValue(invoiceInfo.getFbaNo());
        //设置地址
        Row rowAddress = sheetInovice.getRow(7);
        rowAddress.getCell(1).setCellValue(invoiceInfo.getShipTo());
        //设置邮编
        Row rowPostalCode = sheetInovice.getRow(9);
        rowPostalCode.getCell(6).setCellValue(getPostalCode(invoiceInfo.getShipTo()));
        //设置产品信息
        for (int i = 0; i < invoiceInfo.getInvoiceGoodsInfoList().size(); i++) {
            Row rowGoodsInfo = sheetInovice.getRow(14 + i);
            InvoiceGoodsInfo invoiceGoodsInfo = invoiceInfo.getInvoiceGoodsInfoList().get(i);
            rowGoodsInfo.getCell(0).setCellValue(invoiceGoodsInfo.getGoodsName());
            rowGoodsInfo.getCell(1).setCellValue(invoiceGoodsInfo.getMaterial());
            rowGoodsInfo.getCell(2).setCellValue(invoiceGoodsInfo.getPurpose());
            rowGoodsInfo.getCell(3).setCellValue(invoiceGoodsInfo.getBrand());
            rowGoodsInfo.getCell(4).setCellValue(invoiceGoodsInfo.getHsCode());
            rowGoodsInfo.getCell(6).setCellValue(invoiceGoodsInfo.getQuantity());
            rowGoodsInfo.getCell(7).setCellValue(invoiceGoodsInfo.getUnitPrice());
            rowGoodsInfo.getCell(8).setCellValue(invoiceGoodsInfo.getTotalPrice());
        }
        //设置箱数
        Row rowGoodsInfoFirst = sheetInovice.getRow(14);
        rowGoodsInfoFirst.getCell(5).setCellValue(invoiceInfo.getNumberOfBoxes());
        if (invoiceInfo.getInvoiceGoodsInfoList().size() > 1) {
            CellRangeAddress region = new CellRangeAddress(14, 13 + invoiceInfo.getInvoiceGoodsInfoList().size(), 5, 5);
            sheetInovice.addMergedRegion(region);
        }
        //设置总价
        Row rowTotalPrice = sheetInovice.getRow(24);
        rowTotalPrice.getCell(8).setCellValue(invoiceInfo.getTotalPrice());
        //设置日期
        Row rowDate = sheetInovice.getRow(28);
        rowDate.getCell(8).setCellValue(DateUtil.getFormatDateStr(invoiceInfo.getDate(), "yyyy.MM.dd"));
    }

    private String getPostalCode(String shipTo) {
        if (StringUtils.isEmpty(shipTo)) {
            return "";
        }
        return RegexUtil.getFirstStr(shipTo, "[0-9]+[-][0-9]+");
    }

    /**
     * @param
     * @param
     * @param priceStyle
     * @return
     * @description 设置空运装箱单信息
     * @author baixueping
     * @date 2019/9/18 16:02
     */
    private void updateSheetPackingKy(Sheet sheetPacking, InvoiceInfo invoiceInfo, CellStyle priceStyle) {
        //设置shipId
        Row rowFirst = sheetPacking.getRow(0);
        rowFirst.getCell(3).setCellValue(invoiceInfo.getFbaNo());
        rowFirst.getCell(7).setCellValue(invoiceInfo.getNumberOfBoxes());
        //设置每箱信息
        for (int i = 0; i < invoiceInfo.getInvoicePackingInfoList().size(); i++) {
            Row rowGoodsInfo = sheetPacking.createRow(6 + i);
            InvoicePackingInfo invoicePackingInfo = invoiceInfo.getInvoicePackingInfoList().get(i);
            rowGoodsInfo.createCell(1).setCellValue(invoicePackingInfo.getContainerNo());
            rowGoodsInfo.createCell(2).setCellValue(23);
            rowGoodsInfo.createCell(3).setCellValue(invoicePackingInfo.getGoodsName());
            rowGoodsInfo.createCell(4).setCellValue(invoicePackingInfo.getQuantity());
            rowGoodsInfo.createCell(5).setCellValue("USD");
            rowGoodsInfo.createCell(6).setCellValue(invoicePackingInfo.getUnitPrice());
            rowGoodsInfo.getCell(6).setCellStyle(priceStyle);
            rowGoodsInfo.createCell(7).setCellValue(invoicePackingInfo.getTotalPrice());
            rowGoodsInfo.getCell(7).setCellStyle(priceStyle);
            rowGoodsInfo.createCell(8).setCellValue(invoicePackingInfo.getHsCode());
        }
    }


    /**
     * @param
     * @return
     * @description 获取发票基础信息
     * @author baixueping
     * @date 2019/9/17 16:00
     */
    private BaseResponse<InvoiceInfo> getInvoiceInfo(MultipartFile file) {
        Workbook wb = ExcelUtil.readExcel(file);
        if (wb == null || wb.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel读取失败");
        }
        Sheet sheet = wb.getSheetAt(0);
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("excel内容为空");
        }
        InvoiceInfo invoiceInfo = new InvoiceInfo();
        Integer rownumTitle = null;
        //遍历获取基础信息和标题行号
        for (int i = 0; i < rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            int colnum = row.getLastCellNum();
            if (colnum >= 1) {
                String cellData0 = ExcelUtil.getCellFormatValueString(row.getCell(0));
                String cellData1 = ExcelUtil.getCellFormatValueString(row.getCell(1));
                if ("Shipment ID".equals(cellData0)) {
                    invoiceInfo.setShipmentId(cellData1);
                } else if ("Ship To".equals(cellData0)) {
                    invoiceInfo.setShipTo(cellData1);
                } else if ("ReferenceId*".equals(cellData0)) {
                    invoiceInfo.setReferenceId(cellData1);
                } else if ("Merchant SKU".equals(cellData0)) {
                    rownumTitle = i;
                    break;
                }
            }
        }
        if (StringUtils.isEmpty(invoiceInfo.getShipmentId())) {
            return BaseResponse.failMessage("Shipment ID不能为空");
        }
        if (StringUtils.isEmpty(invoiceInfo.getShipTo())) {
            return BaseResponse.failMessage("Ship To不能为空");
        }
        if (rownumTitle == null) {
            return BaseResponse.failMessage("未找到【Merchant SKU】字段");
        }
        //获取表头
        List<String> columns = new ArrayList<String>();
        Row rowTitle = sheet.getRow(rownumTitle);
        int colnumTitle = rowTitle.getLastCellNum();
        for (int i = 0; i <= colnumTitle; i++) {
            String cellData = ExcelUtil.getCellFormatValueString(rowTitle.getCell(i));
            columns.add(cellData);
        }
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            Map<String, String> map = new LinkedHashMap<String, String>();
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j <= colnumTitle; j++) {
                    String cellData = ExcelUtil.getCellFormatValueString(row.getCell(j));
                    map.put(columns.get(j), cellData);
                }
            }
            list.add(map);
        }
        List<InvoiceSkuInfo> invoiceSkuInfoList = new ArrayList<>();
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if (StringUtils.isEmpty(shopSku)) {
                return BaseResponse.failMessage("第" + (i + 1) + "行，Merchant SKU为空");
            }
            for (int j = 1; j <= colnumTitle; j++) {
                String columnName = columns.get(j);
                if (columnName.contains("Unit Quantity")) {
                    String quantityStr = ExcelUtil.getCellFormatValueString(row.getCell(j));
                    Integer quantity = MathUtil.strToInteger(quantityStr);
                    if (quantity != null && quantity > 0) {
                        InvoiceSkuInfo invoiceSkuInfo = new InvoiceSkuInfo();
                        invoiceSkuInfo.setShopSku(shopSku);
                        invoiceSkuInfo.setContainerNo(getContainerNo(columnName));
                        invoiceSkuInfo.setQuantity(quantity);
                        invoiceSkuInfoList.add(invoiceSkuInfo);
                    }
                }
            }
        }

        if (CollectionUtils.isEmpty(invoiceSkuInfoList)) {
            return BaseResponse.failMessage("装箱单没有有效数量的商品");
        }
        BaseResponse updateInvoiceSkuInfoListResponse = updateInvoiceSkuInfoList(invoiceSkuInfoList);
        if (!updateInvoiceSkuInfoListResponse.isSuccess()) {
            return updateInvoiceSkuInfoListResponse;
        }
        invoiceInfo = getInvoiceInfo(invoiceInfo, invoiceSkuInfoList);
        return BaseResponse.successData(invoiceInfo);
    }

    private InvoiceInfo getInvoiceInfo(InvoiceInfo invoiceInfo, List<InvoiceSkuInfo> invoiceSkuInfoList) {
        setNumberOfBoxesAndTotalQuantityAndTotalPrice(invoiceInfo, invoiceSkuInfoList);
        List<InvoicePackingInfo> invoicePackingInfoList = getInvoicePackingInfoList(invoiceSkuInfoList, invoiceInfo.getUnitPrice());
        invoiceInfo.setInvoicePackingInfoList(invoicePackingInfoList);
        List<InvoiceGoodsInfo> invoiceGoodsInfoList = getInvoiceGoodsInfoList(invoicePackingInfoList, invoiceInfo.getUnitPrice());
        invoiceInfo.setInvoiceGoodsInfoList(invoiceGoodsInfoList);
        invoiceInfo.setDate(new Date());
        //设置店铺名称
        updateShopName(invoiceInfo, invoiceSkuInfoList);
        return invoiceInfo;
    }

    private String getContainerNo(String columnName) {
        String containerNo = columnName.split(" ")[0];
        String containerNoUno = RegexUtil.getFirstStr(containerNo, "U[0-9]{3}$");
        if (!StringUtils.isEmpty(containerNoUno)) {
            return containerNo.replace(containerNoUno, containerNoUno.replace("U", "U000"));
        }
        return containerNo;
    }

    private List<InvoiceGoodsInfo> getInvoiceGoodsInfoList(List<InvoicePackingInfo> invoicePackingInfoList, Double unitPrice) {
        List<InvoiceGoodsInfo> invoiceGoodsInfoList = new ArrayList<>();
        Map<String, Set<String>> mapContainerNo = new HashMap<>();
        for (InvoicePackingInfo invoicePackingInfo : invoicePackingInfoList) {
            InvoiceGoodsInfo invoiceGoodsInfo = getInvoiceGoodsInfo(invoiceGoodsInfoList, invoicePackingInfo.getGoodsName());
            Set<String> containerNoSet = mapContainerNo.get(invoicePackingInfo.getGoodsName());
            if (containerNoSet == null) {
                containerNoSet = new HashSet<>();
            }
            containerNoSet.add(invoicePackingInfo.getContainerNo());
            mapContainerNo.put(invoicePackingInfo.getGoodsName(), containerNoSet);
            if (invoiceGoodsInfo == null) {
                invoiceGoodsInfo = new InvoiceGoodsInfo();
                invoiceGoodsInfo.setGoodsName(invoicePackingInfo.getGoodsName());
                invoiceGoodsInfo.setMaterial(material);
                invoiceGoodsInfo.setPurpose("穿/Wear");
                invoiceGoodsInfo.setBrand("无");
                invoiceGoodsInfo.setHsCode(invoicePackingInfo.getHsCode());
                invoiceGoodsInfo.setWeight(invoicePackingInfo.getWeight());
                invoiceGoodsInfo.setQuantity(invoicePackingInfo.getQuantity());
                invoiceGoodsInfo.setUnitPrice(unitPrice);
                invoiceGoodsInfo.setTotalPrice(invoiceGoodsInfo.getQuantity() * unitPrice);
                invoiceGoodsInfoList.add(invoiceGoodsInfo);
            } else {
                invoiceGoodsInfo.setQuantity(invoiceGoodsInfo.getQuantity() + invoicePackingInfo.getQuantity());
                invoiceGoodsInfo.setTotalPrice(invoiceGoodsInfo.getQuantity() * unitPrice);
            }
            invoiceGoodsInfo.setNumberOfBoxes(containerNoSet.size());
        }
        return invoiceGoodsInfoList;
    }

    private InvoiceGoodsInfo getInvoiceGoodsInfo(List<InvoiceGoodsInfo> invoiceGoodsInfoList, String goodName) {
        for (InvoiceGoodsInfo invoiceGoodsInfo : invoiceGoodsInfoList) {
            if (invoiceGoodsInfo.getGoodsName().equals(goodName)) {
                return invoiceGoodsInfo;
            }
        }
        return null;
    }

    /**
     * @param
     * @return
     * @description 更新店铺名
     * @author baixueping
     * @date 2019/9/18 16:59
     */
    private void updateShopName(InvoiceInfo invoiceInfo, List<InvoiceSkuInfo> invoiceSkuInfoList) {
        String shopSku = invoiceSkuInfoList.get(0).getShopSku();
        String shopName = shopSkuService.getShopNameByShopSku(shopSku);
        invoiceInfo.setShopName(shopName);
    }

    /**
     * @param
     * @return
     * @description 获取装箱单信息
     * @author baixueping
     * @date 2019/9/17 18:23
     */
    private List<InvoicePackingInfo> getInvoicePackingInfoList(List<InvoiceSkuInfo> invoiceSkuInfoList, Double unitPrice) {
        List<InvoicePackingInfo> invoicePackingInfoList = new ArrayList<>();
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            InvoicePackingInfo invoicePackingInfo = getInvoicePackingInfo(invoicePackingInfoList, invoiceSkuInfo);
            if (invoicePackingInfo == null) {
                invoicePackingInfo = new InvoicePackingInfo();
                invoicePackingInfo.setContainerNo(invoiceSkuInfo.getContainerNo());
                invoicePackingInfo.setChineseProductName(invoiceSkuInfo.getChineseProductName());
                invoicePackingInfo.setEnglishProductName(invoiceSkuInfo.getEnglishProductName());
                invoicePackingInfo.setHsCode(invoiceSkuInfo.getHsCode());
                invoicePackingInfo.setGoodsName(invoiceSkuInfo.getEnglishProductName() + " " + invoiceSkuInfo.getChineseProductName());
                invoicePackingInfo.setQuantity(invoiceSkuInfo.getQuantity());
                invoicePackingInfo.setLength(50.0);
                invoicePackingInfo.setWidth(35.0);
                invoicePackingInfo.setHeight(50.0);
                //invoicePackingInfo.setWeight(invoiceSkuInfo.getWeight());
                invoicePackingInfo.setTotalWeight(invoiceSkuInfo.getTotalWeight());
                invoicePackingInfo.setMaterial(material);
                invoicePackingInfo.setChineseMaterial(chineseMaterial);
                invoicePackingInfo.setEnglishMaterial(englishMaterial);
                invoicePackingInfo.setPurpose("穿/Wear");
                invoicePackingInfo.setUnitPrice(unitPrice);
                //invoicePackingInfo.setTotalPrice(invoicePackingInfo.getQuantity() * unitPrice);
                //invoicePackingInfo.setCostPrice(invoiceSkuInfo.getCostPrice());
                invoicePackingInfo.setTotalCostPrice(invoiceSkuInfo.getTotalCostPrice());
                invoicePackingInfoList.add(invoicePackingInfo);
            } else {
                invoicePackingInfo.setQuantity(invoicePackingInfo.getQuantity() + invoiceSkuInfo.getQuantity());
                invoicePackingInfo.setTotalPrice(invoicePackingInfo.getQuantity() * unitPrice);
                invoicePackingInfo.setTotalWeight(
                        MathUtil.add(invoicePackingInfo.getTotalWeight(), invoiceSkuInfo.getTotalWeight()));
                invoicePackingInfo.setTotalCostPrice(MathUtil.add(invoiceSkuInfo.getTotalCostPrice(), invoicePackingInfo.getTotalCostPrice()));
            }
        }
        for (InvoicePackingInfo invoicePackingInfo :
                invoicePackingInfoList) {
            invoicePackingInfo.setWeight(MathUtil.divide(invoicePackingInfo.getTotalWeight(), invoicePackingInfo.getQuantity(), 2));
            invoicePackingInfo.setTotalPrice(invoicePackingInfo.getQuantity() * unitPrice);
            invoicePackingInfo.setCostPrice(MathUtil.divide(invoicePackingInfo.getTotalCostPrice(), invoicePackingInfo.getQuantity(), 2));
        }
        Collections.sort(invoicePackingInfoList, new Comparator<InvoicePackingInfo>() {
            @Override
            public int compare(InvoicePackingInfo o1, InvoicePackingInfo o2) {
                return o1.getContainerNo().compareTo(o2.getContainerNo());
            }
        });
        return invoicePackingInfoList;
    }

    private InvoicePackingInfo getInvoicePackingInfo(List<InvoicePackingInfo> invoicePackingInfoList, InvoiceSkuInfo invoiceSkuInfo) {
        for (InvoicePackingInfo invoicePackingInfo : invoicePackingInfoList) {
            if (invoicePackingInfo.getContainerNo().equals(invoiceSkuInfo.getContainerNo())
                    && invoicePackingInfo.getChineseProductName().equals(invoiceSkuInfo.getChineseProductName())
                    && invoicePackingInfo.getEnglishProductName().equals(invoiceSkuInfo.getEnglishProductName())) {
                return invoicePackingInfo;
            }
        }
        return null;
    }

    /**
     * @param
     * @return
     * @description 设置箱数数量总价
     * @author baixueping
     * @date 2019/9/17 18:09
     */
    private void setNumberOfBoxesAndTotalQuantityAndTotalPrice(InvoiceInfo invoiceInfo, List<InvoiceSkuInfo> invoiceSkuInfoList) {
        List<String> containerNoList = new ArrayList<>();
        Integer totalQuantity = 0;
        Double unitPrice = 0.0;
        Double totalPrice = getTitalPrice(invoiceInfo.getFbaPackingListId());
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            if (!containerNoList.contains(invoiceSkuInfo.getContainerNo())) {
                containerNoList.add(invoiceSkuInfo.getContainerNo());
            }
            totalQuantity += invoiceSkuInfo.getQuantity();
        }
        unitPrice = MathUtil.divide(totalPrice, totalQuantity, 2);
        totalPrice = totalQuantity * unitPrice;
        invoiceInfo.setNumberOfBoxes(containerNoList.size());
        invoiceInfo.setTotalQuantity(totalQuantity);
        invoiceInfo.setTotalPrice(totalPrice);
        invoiceInfo.setUnitPrice(unitPrice);
    }

    private Double getTitalPrice(Integer fbaPackingListId) {
        Random r = new Random(fbaPackingListId);
        Integer res = r.nextInt(200) + 400;
        return res.doubleValue();
    }

    /**
     * @param
     * @return
     * @description 补充中英文报关名
     * @author baixueping
     * @date 2019/9/17 18:00
     */
    private BaseResponse updateInvoiceSkuInfoList(List<InvoiceSkuInfo> invoiceSkuInfoList) {
        List<String> shopSkuList = new ArrayList<>();
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            if (!shopSkuList.contains(invoiceSkuInfo.getShopSku())) {
                shopSkuList.add(invoiceSkuInfo.getShopSku());
            }
        }
        List<ShopSkuFullProductName> shopSkuFullProductNameList = shopSkuService.listShopSkuFullProductName(shopSkuList);
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            for (ShopSkuFullProductName shopSkuFullProductName : shopSkuFullProductNameList) {
                if (shopSkuFullProductName.getShopSku().equals(invoiceSkuInfo.getShopSku())) {
                    invoiceSkuInfo.setChineseProductName(shopSkuFullProductName.getChineseProductName());
                    invoiceSkuInfo.setEnglishProductName(shopSkuFullProductName.getEnglishProductName());
                    invoiceSkuInfo.setWeight(shopSkuFullProductName.getWeight());
                }
            }
            if (StringUtils.isEmpty(invoiceSkuInfo.getChineseProductName()) || StringUtils.isEmpty(invoiceSkuInfo.getEnglishProductName())) {
                return BaseResponse.failMessage(invoiceSkuInfo.getShopSku() + "的店铺sku信息不存在，或者对应产品的中英文报关名为空");
            }
        }
        return BaseResponse.success();
    }


}
