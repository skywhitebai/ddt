package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FbaPackingListConstant;
import com.sky.ddt.common.constant.OutboundOrderConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.dao.custom.CustomFbaPackingListMapper;
import com.sky.ddt.dao.custom.CustomFbaPackingListShopSkuMapper;
import com.sky.ddt.dao.custom.CustomOutboundOrderMapper;
import com.sky.ddt.dto.deliverGoods.request.InvoiceInfo;
import com.sky.ddt.dto.deliverGoods.request.InvoiceSkuInfo;
import com.sky.ddt.dto.fbaPackingList.request.ListFbaPackingListRequest;
import com.sky.ddt.dto.fbaPackingList.request.ListInvoiceInfoRequest;
import com.sky.ddt.dto.fbaPackingList.response.ListFbaPackingListResponse;
import com.sky.ddt.dto.fbaPackingList.response.ListInvoiceInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuFullProductName;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author baixueping
 * @description fba装箱单服务
 * @date 2020/7/21 17:03
 */
@Service
public class FbaPackingListService implements IFbaPackingListService {
    @Autowired
    CustomFbaPackingListMapper customFbaPackingListMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomFbaPackingListShopSkuMapper customFbaPackingListShopSkuMapper;

    @Autowired
    IOutboundOrderService outboundOrderService;
    @Autowired
    IDeliverGoodsService deliverGoodsService;
    @Autowired
    CustomOutboundOrderMapper customOutboundOrderMapper;


    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入装箱单
     * @author baixueping
     * @date 2020/7/21 17:07
     */
    @Override
    public BaseResponse importFbaPackingList(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        Workbook wb = ExcelUtil.readExcel(file);
        if (wb == null || wb.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel读取失败");
        }
        Sheet sheet = wb.getSheetAt(0);
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("excel内容为空");
        }
        FbaPackingList fbaPackingList = new FbaPackingList();
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
                    fbaPackingList.setShipmentId(cellData1);
                } else if ("Name".equals(cellData0)) {
                    fbaPackingList.setName(cellData1);
                } else if ("Plan ID".equals(cellData0)) {
                    fbaPackingList.setPlanId(cellData1);
                } else if ("Ship To".equals(cellData0)) {
                    fbaPackingList.setShipTo(cellData1);
                } else if ("Total SKUs".equals(cellData0)) {
                    fbaPackingList.setTotalSkus(MathUtil.strToInteger(cellData1));
                } else if ("Total Units".equals(cellData0)) {
                    fbaPackingList.setTotalUnits(MathUtil.strToInteger(cellData1));
                } else if ("Pack list".equals(cellData0)) {
                    fbaPackingList.setPackList(DateUtil.strToDate(cellData1));
                } else if ("Merchant SKU".equals(cellData0)) {
                    rownumTitle = i;
                    break;
                }
            }
        }
        if (StringUtils.isEmpty(fbaPackingList.getShipmentId())) {
            return BaseResponse.failMessage("Shipment ID不能为空");
        } else {
            //判断shipmentId 是否存在
            if (existShipMentId(fbaPackingList.getShipmentId())) {
                return BaseResponse.failMessage(FbaPackingListConstant.SHIPMENT_ID_EXIST);
            }
        }
        if (StringUtils.isEmpty(fbaPackingList.getShipTo())) {
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
        //获取内容
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
        List<FbaPackingListShopSku> fbaPackingListShopSkuList = new ArrayList<>();
        SbErroEntity sbErroEntity = new SbErroEntity(";");
        Integer shopId = null;
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            SbErroEntity sbErroEntityItem = new SbErroEntity();
            Integer shopSkuId = null;
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if (StringUtils.isEmpty(shopSku)) {
                sbErroEntityItem.append("Merchant SKU为空");
            } else {
                ShopSku shopSkuInfo = shopSkuService.getShopSkuByShopSku(shopSku);
                if (shopSkuInfo == null) {
                    sbErroEntityItem.append("Merchant SKU不存在");
                } else {
                    shopSkuId = shopSkuInfo.getShopSkuId();
                    if (shopId == null) {
                        shopId = shopSkuInfo.getShopId();
                    } else if (!shopId.equals(shopSkuInfo.getShopId())) {
                        sbErroEntityItem.append("Merchant SKU的店铺与第" + (rownumTitle + 2) + "行的不一致");
                    }
                }
            }
            //判断sku是否重复
            if (!StringUtils.isEmpty(shopSku)) {
                for (int j = i + 1; j <= rownum; j++) {
                    Row row2 = sheet.getRow(j);
                    if (row2 == null) {
                        continue;
                    }
                    if (shopSku.equals(ExcelUtil.getCellFormatValueString(row2.getCell(0)))) {
                        sbErroEntityItem.append(String.format(FbaPackingListConstant.SHOP_SKU_REPEAT, shopSku));
                    }
                }
            }

            for (int j = 1; j <= colnumTitle; j++) {
                String columnName = columns.get(j);
                if (!columnName.contains("Unit Quantity")) {
                    continue;
                }
                String fbaShipmentId = columnName.split(" ")[0];
                if (!fbaShipmentId.startsWith(fbaPackingList.getShipmentId() + "U")) {
                    sbErroEntityItem.append(columnName + "不符合fbaShipmentId" + fbaPackingList.getShipmentId() + "箱号的命名规则");
                }
                String quantityStr = ExcelUtil.getCellFormatValueString(row.getCell(j));
                if (StringUtils.isEmpty(quantityStr)) {
                    continue;
                }
                Integer quantity = MathUtil.strToInteger(quantityStr);
                if (quantity == null || quantity <= 0) {
                    sbErroEntityItem.append(columnName + "的值必须为大于0的整数");
                    continue;
                }

                FbaPackingListShopSku fbaPackingListShopSku = new FbaPackingListShopSku();
                fbaPackingListShopSku.setShopSkuId(shopSkuId);
                fbaPackingListShopSku.setQuantity(quantity);
                fbaPackingListShopSku.setFbaShipmentId(fbaShipmentId);
                fbaPackingListShopSku.setRemark(shopSku);
                fbaPackingListShopSkuList.add(fbaPackingListShopSku);
            }
            if (sbErroEntityItem.isFail()) {
                sbErroEntity.append("第" + (i + 1) + "行," + sbErroEntityItem.getMessage());
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        if (CollectionUtils.isEmpty(fbaPackingListShopSkuList)) {
            return BaseResponse.failMessage(FbaPackingListConstant.FBA_PACKING_LIST_NO_ENABLE_SHOP_SKU);
        }

        //插入
        fbaPackingList.setShopId(shopId);
        fbaPackingList.setCreateBy(dealUserId);
        fbaPackingList.setCreateTime(new Date());
        customFbaPackingListMapper.insertSelective(fbaPackingList);
        for (FbaPackingListShopSku fbaPackingListShopSku :
                fbaPackingListShopSkuList) {
            fbaPackingListShopSku.setRemark(null);
            fbaPackingListShopSku.setFbaPackingListId(fbaPackingList.getId());
            fbaPackingListShopSku.setCreateBy(dealUserId);
            fbaPackingListShopSku.setCreateTime(new Date());
            customFbaPackingListShopSkuMapper.insertSelective(fbaPackingListShopSku);
        }
        return BaseResponse.success();
    }


    @Override
    public BaseResponse importFbaPackingList2(String fbaShipmentId, MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        if(StringUtils.isEmpty(fbaShipmentId)){
            return BaseResponse.failMessage("fbaShipmentId不能为空");
        }
        Workbook wb = ExcelUtil.readExcel(file);
        if (wb == null || wb.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel读取失败");
        }
        Sheet sheet = wb.getSheetAt(0);
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("excel内容为空");
        }
        if (rownum < 5) {
            return BaseResponse.failMessage("装箱单数据为空");
        }
        FbaPackingList fbaPackingList = new FbaPackingList();

        Row row3 = sheet.getRow(2);
        if (row3 != null) {
            //SKU 总数：7（140 件商品）
            String skuInfo = ExcelUtil.getCellFormatValueString(row3.getCell(0)).replace("(","（").replace("）","）");
            if (!StringUtils.isEmpty(skuInfo)) {
                String []skuInfoArray=skuInfo.split("（");
                if(skuInfoArray.length==2){
                    String totalSkusStr = skuInfoArray[0].replace("SKU 总数：", "").replace(" ", "");
                    Integer totalSkus = MathUtil.strToInteger(totalSkusStr);
                    fbaPackingList.setTotalSkus(totalSkus);
                    String totalUnitStr = skuInfoArray[1].replace("件商品", "").replace(" ", "");
                    Integer totalUnit = MathUtil.strToInteger(totalUnitStr);
                    fbaPackingList.setTotalUnits(totalUnit);
                }
            }
        }
        Integer rownumTitle = 4;
        fbaPackingList.setShipmentId(fbaShipmentId);
        //判断shipmentId 是否存在
        if (existShipMentId(fbaPackingList.getShipmentId())) {
            return BaseResponse.failMessage(FbaPackingListConstant.SHIPMENT_ID_EXIST);
        }
        //获取表头
        List<String> columns = new ArrayList<String>();
        Row rowTitle = sheet.getRow(rownumTitle);
        int colnumTitle = rowTitle.getLastCellNum();
        for (int i = 0; i <= colnumTitle; i++) {
            String cellData = ExcelUtil.getCellFormatValueString(wb,rowTitle.getCell(i));
            columns.add(cellData);
        }
        //获取内容
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
        List<FbaPackingListShopSku> fbaPackingListShopSkuList = new ArrayList<>();
        SbErroEntity sbErroEntity = new SbErroEntity(";");
        Integer shopId = null;
        for (int i = rownumTitle + 1; i <= rownum; i++) {
            SbErroEntity sbErroEntityItem = new SbErroEntity();
            Integer shopSkuId = null;
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if (StringUtils.isEmpty(shopSku)) {
                sbErroEntityItem.append("SKU为空");
            } else {
                ShopSku shopSkuInfo = shopSkuService.getShopSkuByShopSku(shopSku);
                if (shopSkuInfo == null) {
                    sbErroEntityItem.append("SKU不存在");
                } else {
                    shopSkuId = shopSkuInfo.getShopSkuId();
                    if (shopId == null) {
                        shopId = shopSkuInfo.getShopId();
                    } else if (!shopId.equals(shopSkuInfo.getShopId())) {
                        sbErroEntityItem.append("SKU的店铺与第" + (rownumTitle + 2) + "行的不一致");
                    }
                }
            }
            //判断sku是否重复
            if (!StringUtils.isEmpty(shopSku)) {
                for (int j = i + 1; j <= rownum; j++) {
                    Row row2 = sheet.getRow(j);
                    if (row2 == null) {
                        continue;
                    }
                    if (shopSku.equals(ExcelUtil.getCellFormatValueString(row2.getCell(0)))) {
                        sbErroEntityItem.append(String.format(FbaPackingListConstant.SHOP_SKU_REPEAT, shopSku));
                    }
                }
            }
            List<Integer> fbaShipmentIdNumList = new ArrayList<>();
            for (int j = 1; j <= colnumTitle; j++) {
                String columnName = columns.get(j);
                if (!columnName.contains("包装箱")) {
                    continue;
                }
                String quantityStr = ExcelUtil.getCellFormatValueString(row.getCell(j));
                if (StringUtils.isEmpty(quantityStr)) {
                    continue;
                }
                Integer quantity = MathUtil.strToInteger(quantityStr);
                if (quantity == null || quantity < 0) {
                    sbErroEntityItem.append(columnName + "的值必须为大于等于0的整数");
                    continue;
                }
                if (quantity == 0) {
                    continue;
                }
                String fbaShipmentIdNumStr = columnName.replace("包装箱", "").replace("数量", "").replace(" ", "");
                Integer fbaShipmentIdNum = MathUtil.strToInteger(fbaShipmentIdNumStr);
                if (fbaShipmentIdNum == null || fbaShipmentIdNum <= 0) {
                    sbErroEntityItem.append(columnName + "装箱信息错误，必须为类似【包装箱 1 数量】的格式");
                    continue;
                }
                if (fbaShipmentIdNumList.contains(fbaShipmentIdNum)) {
                    sbErroEntityItem.append(columnName + "装箱号重复，请修改后导入");
                    break;
                }
                fbaShipmentIdNumList.add(fbaShipmentIdNum);
                FbaPackingListShopSku fbaPackingListShopSku = new FbaPackingListShopSku();
                fbaPackingListShopSku.setShopSkuId(shopSkuId);
                fbaPackingListShopSku.setQuantity(quantity);
                String fbaShipmentIdNumInfo=fbaShipmentIdNum.toString();
                while (fbaShipmentIdNumInfo.length()<3){
                    fbaShipmentIdNumInfo="0"+fbaShipmentIdNumInfo;
                }
                fbaPackingListShopSku.setFbaShipmentId(fbaShipmentId + "U" + fbaShipmentIdNumInfo);
                fbaPackingListShopSku.setRemark(shopSku);
                fbaPackingListShopSkuList.add(fbaPackingListShopSku);
            }
            if (sbErroEntityItem.isFail()) {
                sbErroEntity.append("第" + (i + 1) + "行," + sbErroEntityItem.getMessage());
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        if (CollectionUtils.isEmpty(fbaPackingListShopSkuList)) {
            return BaseResponse.failMessage(FbaPackingListConstant.FBA_PACKING_LIST_NO_ENABLE_SHOP_SKU);
        }

        //插入
        fbaPackingList.setShopId(shopId);
        fbaPackingList.setCreateBy(dealUserId);
        fbaPackingList.setCreateTime(new Date());
        customFbaPackingListMapper.insertSelective(fbaPackingList);
        for (FbaPackingListShopSku fbaPackingListShopSku :
                fbaPackingListShopSkuList) {
            fbaPackingListShopSku.setRemark(null);
            fbaPackingListShopSku.setFbaPackingListId(fbaPackingList.getId());
            fbaPackingListShopSku.setCreateBy(dealUserId);
            fbaPackingListShopSku.setCreateTime(new Date());
            customFbaPackingListShopSkuMapper.insertSelective(fbaPackingListShopSku);
        }
        return BaseResponse.success();
    }

    private BaseResponse repeatShopSku(List<FbaPackingListShopSku> fbaPackingListShopSkuList) {
        for (int i = 0; i < fbaPackingListShopSkuList.size(); i++) {
            String shopSku = fbaPackingListShopSkuList.get(i).getRemark();
            for (int j = i + 1; j < fbaPackingListShopSkuList.size(); j++) {
                if (shopSku.equals(fbaPackingListShopSkuList.get(j).getRemark())) {
                    return BaseResponse.failMessage(String.format(FbaPackingListConstant.SHOP_SKU_REPEAT, shopSku));
                }
            }
        }
        return BaseResponse.success();
    }

    private boolean existShipMentId(String shipmentId) {
        FbaPackingListExample example = new FbaPackingListExample();
        example.createCriteria().andShipmentIdEqualTo(shipmentId).andStatusEqualTo(YesOrNoEnum.YES.getValue());
        return customFbaPackingListMapper.countByExample(example) > 0;
    }

    /**
     * @param params @return
     * @description 分页查询装箱单数据
     * @author baixueping
     * @date 2020/7/22 11:08
     */
    @Override
    public PageInfo<ListFbaPackingListResponse> listFbaPackingList(ListFbaPackingListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaPackingListResponse> list = customFbaPackingListMapper.listFbaPackingList(params);
        PageInfo<ListFbaPackingListResponse> page = new PageInfo<ListFbaPackingListResponse>(list);
        return page;
    }

    /**
     * @param params @return
     * @description 列表查询发票信息
     * @author baixueping
     * @date 2020/7/23 14:56
     */
    @Override
    public PageInfo<ListInvoiceInfoResponse> listInvoiceInfo(ListInvoiceInfoRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInvoiceInfoResponse> list = customFbaPackingListMapper.listInvoiceInfo(params);
        PageInfo<ListInvoiceInfoResponse> page = new PageInfo<ListInvoiceInfoResponse>(list);
        return page;
    }

    /**
     * @param id         @return
     * @param dealUserId
     * @description 生成入库单
     * @author baixueping
     * @date 2020/8/3 20:15
     */
    @Override
    public BaseResponse generateOutboundOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(FbaPackingListConstant.ID_EMPTY);
        }
        FbaPackingList fbaPackingList = customFbaPackingListMapper.selectByPrimaryKey(id);
        if (fbaPackingList == null) {
            return BaseResponse.failMessage(FbaPackingListConstant.ID_NOT_EXIST);
        }
        if (!YesOrNoEnum.YES.getValue().equals(fbaPackingList.getStatus())) {
            return BaseResponse.failMessage(FbaPackingListConstant.NOT_ALLOW_GENERATE_OUTBOUND_ORDER);
        }
        return outboundOrderService.generateOutboundOrder(fbaPackingList, dealUserId);
    }

    /**
     * @param fbaPackingListId
     * @param orderNumber      @return
     * @param type
     * @param response         @description 导出发票
     * @author baixueping
     * @date 2020/8/12 15:55
     */
    @Override
    public BaseResponse downInvoice(Integer fbaPackingListId, String orderNumber, String type, HttpServletResponse response) {
        if (StringUtils.isEmpty(orderNumber)) {
            return BaseResponse.failMessage(FbaPackingListConstant.ORDER_NUMBER_EMPTY);
        }
        if (fbaPackingListId == null) {
            return BaseResponse.failMessage(FbaPackingListConstant.FBA_PACKING_LIST_ID_EMPTY);
        }
        InvoiceInfo invoiceInfo = new InvoiceInfo();
        FbaPackingList fbaPackingList = customFbaPackingListMapper.selectByPrimaryKey(fbaPackingListId);
        if (fbaPackingList == null) {
            return BaseResponse.failMessage(FbaPackingListConstant.FBA_PACKING_LIST_ID_NOT_EXIST);
        }
        if (StockConsatnt.StockQuantityTypeEnum.getStockQuantityTypeEnum(type) == null) {
            return BaseResponse.failMessage("发票类型错误");
        }
        invoiceInfo.setFbaPackingListId(fbaPackingListId);
        invoiceInfo.setShipmentId(fbaPackingList.getShipmentId());
        invoiceInfo.setShipTo(fbaPackingList.getShipTo());
        invoiceInfo.setFbaNo(orderNumber);
        //根据orderNumber 查询fba装箱单店铺sku数据
        List<InvoiceSkuInfo> invoiceSkuInfoList = customFbaPackingListMapper.listInvoiceSkuInfo(fbaPackingListId, orderNumber);
        BaseResponse updateInvoiceSkuInfoListResponse = updateInvoiceSkuInfoList(invoiceSkuInfoList);
        if (!updateInvoiceSkuInfoListResponse.isSuccess()) {
            return updateInvoiceSkuInfoListResponse;
        }
        return deliverGoodsService.generateInvoice(invoiceInfo, invoiceSkuInfoList, type, response);
    }

    @Override
    public BaseResponse cancelFbaPackingList(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage("id不能为空");
        }
        if (existUncancelOutboundOrder(id)) {
            return BaseResponse.failMessage("请先取消装箱单对应的出库单");
        }
        FbaPackingList fbaPackingListOld = customFbaPackingListMapper.selectByPrimaryKey(id);
        if (fbaPackingListOld == null) {
            return BaseResponse.failMessage(FbaPackingListConstant.ID_NOT_EXIST);
        }
        if (YesOrNoEnum.NO.getValue().equals(fbaPackingListOld.getStatus())) {
            return BaseResponse.success();
        }
        FbaPackingList fbaPackingList = new FbaPackingList();
        fbaPackingList.setId(id);
        fbaPackingList.setUpdateBy(dealUserId);
        fbaPackingList.setUpdateTime(new Date());
        fbaPackingList.setStatus(YesOrNoEnum.NO.getValue());
        customFbaPackingListMapper.updateByPrimaryKeySelective(fbaPackingList);
        return BaseResponse.success();
    }

    private boolean existUncancelOutboundOrder(Integer id) {
        OutboundOrderExample example = new OutboundOrderExample();
        example.createCriteria().andFbaPackingListIdEqualTo(id).andStatusNotEqualTo(OutboundOrderConstant.StatusEnum.CANCEL.getStatus());
        return customOutboundOrderMapper.countByExample(example) > 0;
    }

    /**
     * @param
     * @return
     * @description 更新店铺sku 中英文产品名
     * @author baixueping
     * @date 2020/8/12 16:30
     */
    private BaseResponse updateInvoiceSkuInfoList(List<InvoiceSkuInfo> invoiceSkuInfoList) {
        List<Integer> shopSkuIdList = new ArrayList<>();
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            if (!shopSkuIdList.contains(invoiceSkuInfo.getShopSkuId())) {
                shopSkuIdList.add(invoiceSkuInfo.getShopSkuId());
            }
        }
        List<ShopSkuFullProductName> shopSkuFullProductNameList = shopSkuService.listShopSkuFullProductNameByShopSkuId(shopSkuIdList);
        for (InvoiceSkuInfo invoiceSkuInfo : invoiceSkuInfoList) {
            for (ShopSkuFullProductName shopSkuFullProductName : shopSkuFullProductNameList) {
                if (shopSkuFullProductName.getShopSkuId().equals(invoiceSkuInfo.getShopSkuId())) {
                    invoiceSkuInfo.setShopSku(shopSkuFullProductName.getShopSku());
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
