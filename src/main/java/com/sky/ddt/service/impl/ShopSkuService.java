package com.sky.ddt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.*;
import com.sky.ddt.common.exception.NoticeException;
import com.sky.ddt.dao.custom.CustomOrderImportMapper;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dao.custom.CustomShopUserMapper;
import com.sky.ddt.dto.inventoryChangeRecord.request.AddInventoryChangeRecordRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuHeadTripCostInfo;
import com.sky.ddt.dto.shopSku.request.*;
import com.sky.ddt.dto.shopSku.response.*;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 店铺sku
 * @date 2019/7/26 17:56
 */
@Service
public class ShopSkuService implements IShopSkuService {
    @Autowired
    CustomShopUserMapper customShopUserMapper;
    @Autowired
    IShopService shopService;
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    ISkuService skuService;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;
    @Autowired
    CustomOrderImportMapper customOrderImportMapper;
    @Autowired
    IUserService userService;
    @Autowired
    IImgService imgService;
    @Autowired
    IInventoryChangeRecordService inventoryChangeRecordService;
    @Autowired
    IStorageLocationService storageLocationService;
    @Autowired
    IShopSkuStorageLocationService shopSkuStorageLocationService;

    /**
     * @param file
     * @param userId
     * @return
     * @description 导入店铺sku
     * @author baixueping
     * @date 2019/7/29 9:57
     */
    @Override
    public BaseResponse importShopSku(MultipartFile file, Integer userId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        List<Shop> shopList = shopUserService.listUserShop(userId);
        if (CollectionUtils.isEmpty(shopList)) {
            return BaseResponse.failMessage("用户只能上传自己管理的店铺sku");
        }
        List<Integer> shopIdList = shopList.stream().map(Shop::getShopId).collect(Collectors.toList());
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        List<String> shopNameList = new ArrayList<>();
        List<Sku> skuList = new ArrayList<>();
        BaseResponse repeatShopSku = checkRepeat(list, "店铺sku");
        if (!repeatShopSku.isSuccess()) {
            return repeatShopSku;
        }
        BaseResponse repeatFnsku = checkRepeat(list, "FNSKU");
        if (!repeatFnsku.isSuccess()) {
            return repeatFnsku;
        }
        BaseResponse repeatAsin = checkRepeat(list, "ASIN");
        if (!repeatAsin.isSuccess()) {
            return repeatAsin;
        }
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
            String shopName = map.get("店铺名");
            if (StringUtils.isEmpty(shopName)) {
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_NAME_EMPTY);
            } else {
                Integer shopId = getShopId(shopList, map.get("店铺名"));
                if (shopId == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_NAME_NOT_EXIST_OR_NOT_USER_SHOP);
                } else {
                    map.put("shopId", shopId.toString());
                }
            }
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(ShopSkuConstant.SKU_EMPTY);
            } else {
                Sku sku = skuService.getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(String.format(ShopSkuConstant.SKU_NOT_EXIST, map.get("产品sku")));
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                    skuList.add(sku);
                }
            }
            if (StringUtils.isEmpty(map.get("店铺sku"))) {
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("FNSKU"))) {
                sbErroItem.append(",").append(ShopSkuConstant.FNSKU_EMPTY);
            } else if (existOtherFnskuByShopSku(map.get("店铺sku"), map.get("FNSKU"))) {
                sbErroItem.append(",").append(ShopSkuConstant.FNSKU_EXIST);
            } else if (!map.get("FNSKU").substring(0, 1).equals("X")) {
                sbErroItem.append(",").append(ShopSkuConstant.FNSKU_ERRO);
            }
            if (StringUtils.isEmpty(map.get("ASIN"))) {
                sbErroItem.append(",").append(ShopSkuConstant.ASIN_EMPTY);
            } else if (existOtherAsinByShopSku(map.get("店铺sku"), map.get("ASIN"))) {
                sbErroItem.append(",").append(ShopSkuConstant.ASIN_EXIST);
            }
            if (StringUtils.isEmpty(map.get("标题"))) {
                sbErroItem.append(",").append(ShopSkuConstant.TITLE_EMPTY);
            }
            if (!StringUtils.isEmpty(map.get("库位")) && map.get("库位").length() > 200) {
                sbErroItem.append(",").append(ShopSkuConstant.STORAGE_LOCATION_TOO_LONG);
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
            if (shopSku != null) {
                if (!shopIdList.contains(shopSku.getShopId())) {
                    return BaseResponse.failMessage(String.format(ShopSkuConstant.SHOP_SKU_UPDATE_NO_RIGHT, shopSku.getShopSku()));
                }
                setShopSkuByMap(map, shopSku);
                shopSku.setUpdateBy(userId);
                shopSku.setUpdateTime(new Date());
                customShopSkuMapper.updateByPrimaryKeySelective(shopSku);
            } else {
                shopSku = new ShopSku();
                setShopSkuByMap(map, shopSku);
                shopSku.setCreateBy(userId);
                shopSku.setCreateTime(new Date());
                BigDecimal headTripCost = getHeadTripCost(shopSku.getSkuId(), skuList);
                shopSku.setHeadTripCost(headTripCost);
                customShopSkuMapper.insertSelective(shopSku);
            }
        }
        return BaseResponse.success();
    }

    private BaseResponse checkRepeat(List<Map<String, String>> list, String type) {
        if (CollectionUtils.isEmpty(list)) {
            return BaseResponse.success();
        }
        List<String> repeatList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            String value = map.get(type);
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            if (repeatList.contains(value)) {
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (value.equals(list.get(j).get(type))) {
                    repeatList.add(value);
                    break;
                }
            }
        }
        if (repeatList.size() == 0) {
            return BaseResponse.success();
        }
        SbErroEntity sbErroEntity = new SbErroEntity();
        sbErroEntity.append(type).append("存在重复数据：" + String.join(",", repeatList));
        return sbErroEntity.getResponse();
    }

    private BigDecimal getHeadTripCost(Integer skuId, List<Sku> skuList) {
        for (Sku sku :
                skuList) {
            if (sku.getSkuId().equals(skuId)) {

                skuList.remove(sku);
                if (sku.getWeight() != null) {
                    BigDecimal headTripCost = SkuConstant.HEAD_TRIP_COST_RATE.multiply(sku.getWeight());
                    return headTripCost;
                }
                return null;
            }
        }
        return null;
    }

    private boolean existOtherAsinByShopSku(String shopSku, String asin) {
        if (StringUtils.isEmpty(shopSku) || StringUtils.isEmpty(asin)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andAsinEqualTo(asin).andShopSkuNotEqualTo(shopSku);
        return customShopSkuMapper.countByExample(example) > 0;
    }

    private boolean existOtherFnskuByShopSku(String shopSku, String fnsku) {
        if (StringUtils.isEmpty(shopSku) || StringUtils.isEmpty(fnsku)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andFnskuEqualTo(fnsku).andShopSkuNotEqualTo(shopSku);
        return customShopSkuMapper.countByExample(example) > 0;
    }

    /**
     * @param params@return
     * @description 获取店铺sku
     * @author baixueping
     * @date 2019/7/29 15:37
     */
    @Override
    public PageInfo<ListShopSkuResponse> listShopSku(ListShopSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListShopSkuResponse> list = customShopSkuMapper.listShopSku(params);
        for (ListShopSkuResponse listShopSkuResponse :
                list) {
            String imgUrl = imgService.getImgUrlBySkuId(listShopSkuResponse.getSkuId());
            if (!StringUtils.isEmpty(imgUrl)) {
                listShopSkuResponse.setImgUrl(imgUrl);
            }
        }
        PageInfo<ListShopSkuResponse> page = new PageInfo<ListShopSkuResponse>(list);
        return page;
    }

    /**
     * @param params@return
     * @description 修改店铺sku
     * @author baixueping
     * @date 2019/7/30 10:58
     */
    @Override
    public BaseResponse saveShopSku(SaveShopSkuRequest params) {
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(params.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage(ShopSkuConstant.SHOP_SKU_ID_NOT_EXIST);
        }
        if (existOtherShopSku(params.getShopSkuId(), params.getShopSku())) {
            return BaseResponse.failMessage(ShopSkuConstant.SHOP_SKU_EXIST);
        }
        if (existOtherAsin(params.getShopSkuId(), params.getAsin())) {
            return BaseResponse.failMessage(ShopSkuConstant.ASIN_EXIST);
        }
        if (existOtherFnsku(params.getShopSkuId(), params.getFnsku())) {
            return BaseResponse.failMessage(ShopSkuConstant.FNSKU_EXIST);
        }
        if (params.getSalesmanUserId() != null) {
            if (!userService.exist(params.getSalesmanUserId())) {
                return BaseResponse.failMessage(ShopSkuConstant.SALESMAN_USER_ID_NOT_EXIST);
            }
        }
        setShopSku(shopSku, params);
        customShopSkuMapper.updateByPrimaryKey(shopSku);
        return BaseResponse.success();
    }

    private boolean existOtherFnsku(Integer shopSkuId, String fnsku) {
        if (StringUtils.isEmpty(fnsku)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        if (shopSkuId == null) {
            example.createCriteria().andFnskuEqualTo(fnsku);
        } else {
            example.createCriteria().andFnskuEqualTo(fnsku).andShopSkuIdNotEqualTo(shopSkuId);
        }
        return customShopSkuMapper.countByExample(example) > 0;
    }

    private boolean existOtherAsin(Integer shopSkuId, String asin) {
        if (StringUtils.isEmpty(asin)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        if (shopSkuId == null) {
            example.createCriteria().andAsinEqualTo(asin);
        } else {
            example.createCriteria().andAsinEqualTo(asin).andShopSkuIdNotEqualTo(shopSkuId);
        }
        return customShopSkuMapper.countByExample(example) > 0;
    }

    /**
     * @param shopSkuIds@return
     * @description 删除店铺sku
     * @author baixueping
     * @date 2019/7/30 11:24
     */
    @Override
    public BaseResponse deleteShopSku(List<Integer> shopSkuIds) {
        if (CollectionUtils.isEmpty(shopSkuIds)) {
            return BaseResponse.success();
        }
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andShopSkuIdIn(shopSkuIds);
        customShopSkuMapper.deleteByExample(example);
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 查询导出的店铺sku数据
     * @author baixueping
     * @date 2019/7/30 14:10
     */
    @Override
    public List<ExportShopSkuResponse> listExportShopSku(ListShopSkuRequest params) {
        return customShopSkuMapper.listExportShopSku(params);
    }

    /**
     * @param file
     * @param request
     * @param response
     * @return
     * @description 店铺sku转换
     * @author baixueping
     * @date 2019/8/5 9:11
     */
    @Override
    public BaseResponse transformShopSkuInfo(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        if (file == null || file.isEmpty()) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        ;
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        if (!".xls".equals(extName) && !".xlsx".equals(extName)) {
            return BaseResponse.failMessage("文件格式错误，必须上传excel");
        }
        //先识别为workBook
        Workbook workbook = ExcelUtil.readExcel(file);
        if (workbook == null) {
            return BaseResponse.failMessage("excel识别失败");
        }
        if (workbook.getNumberOfSheets() == 0) {
            return BaseResponse.failMessage("excel为空");
        }
        Sheet sheet = workbook.getSheetAt(0);
        //找到标题行
        Integer titleRowNum = null;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            String cellData = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if ("卖家 SKU".equals(cellData)) {
                titleRowNum = i;
                break;
            }
        }
        if (titleRowNum == null) {
            return BaseResponse.failMessage("模板错误,第一列找不到标题【卖家 SKU】");
        }
        Row titleRow = sheet.getRow(titleRowNum);
        Integer sendCountCellNum = null;
        for (int i = 0; i < titleRow.getLastCellNum(); i++) {
            String cellData = ExcelUtil.getCellFormatValueString(titleRow.getCell(i));
            if ("已发货".equals(cellData)) {
                sendCountCellNum = i;
            }
        }
        if (sendCountCellNum == null) {
            return BaseResponse.failMessage("模板错误,第" + (titleRowNum + 1) + "行标题行找不到标题【已发货】");
        }
        StringBuilder sbErro = new StringBuilder();
        //如果导入模板只有店铺sku和已发货，则需要补全四列
        if (titleRow.getCell(1) == null) {
            titleRow.createCell(1);
        }
        if (titleRow.getCell(2) == null) {
            titleRow.createCell(2);
        }
        if (titleRow.getCell(3) == null) {
            titleRow.createCell(3);
        }
        //校验数据是否完整 并获取所有sku
        List<String> shopSkuList = new ArrayList<>();
        for (int i = titleRowNum + 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            //[忽略空行
            Boolean isEmpty = true;
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (!StringUtils.isEmpty(ExcelUtil.getCellFormatValueString(row.getCell(0)))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            //忽略空行]
            String skuSeller = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if (StringUtils.isEmpty(skuSeller)) {
                sbErro.append(",第").append(i + 2).append("行【卖家 SKU】数据为空");
            } else {
                if (!shopSkuList.contains(skuSeller)) {
                    shopSkuList.add(skuSeller);
                }
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //获取所有sku信息
        List<TranformShopSkuInfoResponse> tranformShopSkuInfoResponseList = null;
        if (CollectionUtils.isEmpty(shopSkuList)) {
            tranformShopSkuInfoResponseList = new ArrayList<>();
        } else {
            tranformShopSkuInfoResponseList = customShopSkuMapper.selectByShopSku(shopSkuList);
        }
        titleRow.getCell(1).setCellValue("仓库SKU");
        titleRow.getCell(2).setCellValue("供应商SKU");
        titleRow.getCell(3).setCellValue("已发货");
        //四列后面的赋值为空字符串
        for (int i = 4; i < titleRow.getLastCellNum(); i++) {
            titleRow.getCell(i).setCellValue("");
        }
        for (int i = titleRowNum + 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            //[忽略空行
            if (row == null) {
                continue;
            }
            Boolean isEmpty = true;
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (!StringUtils.isEmpty(ExcelUtil.getCellFormatValueString(row.getCell(0)))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            //忽略空行]
            if (row.getCell(1) == null) {
                row.createCell(1);
            }
            if (row.getCell(2) == null) {
                row.createCell(2);
            }
            if (row.getCell(3) == null) {
                row.createCell(3);
            }
            String shopSku = ExcelUtil.getCellFormatValueString(row.getCell(0));
            String sendCount = ExcelUtil.getCellFormatValueString(row.getCell(sendCountCellNum));
            row.getCell(3).setCellValue(sendCount);
            TranformShopSkuInfoResponse tranformShopSkuInfoResponse = getSkuInfo(tranformShopSkuInfoResponseList, shopSku);
            if (tranformShopSkuInfoResponse != null) {
                row.getCell(1).setCellValue(tranformShopSkuInfoResponse.getSku());
                row.getCell(2).setCellValue(tranformShopSkuInfoResponse.getProductCode());
            }
            for (int j = 4; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    row.getCell(j).setCellValue("");
                }
            }
        }

        // 第七步，将文件存到指定位置
        try {
            response.setContentType("application/octet-stream");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String fileName = "sku信息" + sdf.format(new Date());
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");//默认Excel名称
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseResponse.fail();
    }

    /**
     * @param params@return
     * @description 获取店铺sku信息
     * @author baixueping
     * @date 2019/8/12 15:33
     */
    @Override
    public BaseResponse getPrintShopSku(GetPrintShopSkuRequest params) {
        if (StringUtils.isEmpty(params.getShopSku()) && StringUtils.isEmpty(params.getFnsku())) {
            return BaseResponse.failMessage(ShopSkuConstant.SHOP_SKU_FNSKU_EMPTY);
        }
        GetPrintShopSkuResponse getPrintShopSkuResponse = customShopSkuMapper.getPrintShopSkuResponse(params);
        if (getPrintShopSkuResponse == null) {
            return BaseResponse.failMessage(ShopSkuConstant.SHOP_SKU_FNSKU_NOT_EXIST);
        }
        return BaseResponse.successData(getPrintShopSkuResponse);
    }

    /**
     * @param shopSku
     * @return
     * @description 获取店铺sku信息
     * @author baixueping
     * @date 2019/8/14 11:14
     */
    @Override
    public ShopSku getShopSkuByShopSku(String shopSku) {
        if (StringUtils.isEmpty(shopSku)) {
            return null;
        }
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andShopSkuEqualTo(shopSku);
        List<ShopSku> existList = customShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(existList)) {
            return null;
        }
        return existList.get(0);
    }

    /**
     * @param file
     * @param userId
     * @return
     * @description 导入店铺父sku
     * @author baixueping
     * @date 2019/8/19 9:44
     */
    @Override
    public BaseResponse importShopParentSku(MultipartFile file, Integer userId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        List<Shop> shopList = shopUserService.listUserShop(userId);
        if (CollectionUtils.isEmpty(shopList)) {
            return BaseResponse.failMessage("用户只能上传自己管理的店铺sku");
        }
        List<Integer> shopIdList = shopList.stream().map(Shop::getShopId).collect(Collectors.toList());
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        List<String> shopNameList = new ArrayList<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopIdList.contains(shopSku.getShopId())) {
                        sbErroItem.append(",").append(ShopSkuConstant.SKU_NOT_USER_SHOP);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("店铺父sku"))) {
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_PARENT_SKU_EMPTY);
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            ShopSku shopSku = new ShopSku();
            shopSku.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            shopSku.setShopParentSku(map.get("店铺父sku"));
            shopSku.setUpdateTime(new Date());
            customShopSkuMapper.updateByPrimaryKeySelective(shopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param params @return
     * @description 查询销售数据
     * @author baixueping
     * @date 2019/8/30 14:27
     */
    @Override
    public JSONObject salesCount(SalesCountRequest params) {
        //根据入参 分页查询店铺sku
        PageInfo<SalesCountResponse> page = listSelectSalesCountShopSku(params);
        //根据sku 查询销售数据
        StringBuilder sbJson = new StringBuilder();
        sbJson.append("{\"total\":").append(page.getTotal());
        sbJson.append(",\"rows\":[");
        if (!CollectionUtils.isEmpty(page.getList())) {
            String salesInfo = null;
            if ("shopParentSku".equals(params.getSearchType())) {
                salesInfo = getSalesInfoShopParentSku(page.getList(), params);
            } else {
                salesInfo = getSalesInfo(page.getList(), params);
            }
            sbJson.append(salesInfo);
        }
        sbJson.append("]}");
        return JSONObject.parseObject(sbJson.toString());
    }

    /**
     * @param shopSku@return
     * @description 根据shopSku获取sku信息
     * @author baixueping
     * @date 2019/9/11 10:00
     */
    @Override
    public Sku getSkuByShopSku(String shopSku) {
        if (StringUtils.isEmpty(shopSku)) {
            return null;
        }
        ShopSku shopSkuInfo = getShopSkuByShopSku(shopSku);
        if (shopSkuInfo == null) {
            return null;
        }
        return skuService.getSku(shopSkuInfo.getSkuId());
    }

    /**
     * @param shopSkuList@return
     * @description 根据shopSku查询报关信息
     * @author baixueping
     * @date 2019/9/17 17:49
     */
    @Override
    public List<ShopSkuFullProductName> listShopSkuFullProductName(List<String> shopSkuList) {
        if (CollectionUtils.isEmpty(shopSkuList)) {
            return null;
        }
        return customShopSkuMapper.listShopSkuFullProductName(shopSkuList);
    }

    /**
     * @param shopSku@return
     * @description 通过shopSku获取shopName
     * @author baixueping
     * @date 2019/9/18 16:56
     */
    @Override
    public String getShopNameByShopSku(String shopSku) {
        Shop shop = getShopByShopSku(shopSku);
        if (shop == null) {
            return null;
        }
        return shop.getShopName();
    }

    /**
     * @param file
     * @param userId
     * @return
     * @description 导入店铺sku状态
     * @author baixueping
     * @date 2019/10/23 15:07
     */
    @Override
    public BaseResponse importShopSkuStatus(MultipartFile file, Integer userId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        List<Shop> shopList = shopUserService.listUserShop(userId);
        if (CollectionUtils.isEmpty(shopList)) {
            return BaseResponse.failMessage("用户只能上传自己管理的店铺sku");
        }
        List<Integer> shopIdList = shopList.stream().map(Shop::getShopId).collect(Collectors.toList());
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        List<String> shopNameList = new ArrayList<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopIdList.contains(shopSku.getShopId())) {
                        sbErroItem.append(",").append(ShopSkuConstant.SKU_NOT_USER_SHOP);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("状态"))) {
                sbErroItem.append(",").append(ShopSkuConstant.STATUS_EMPTY);
            } else if (ShopSkuConstant.ShopSkuStatusEnum.getShopSkuStatusEnumByStatusName(map.get("状态")) == null) {
                sbErroItem.append(",").append(ShopSkuConstant.STATUS_ERRO);
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            ShopSku shopSku = new ShopSku();
            shopSku.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            shopSku.setStatus(ShopSkuConstant.ShopSkuStatusEnum.getShopSkuStatusEnumByStatusName(map.get("状态")).getStatus());
            shopSku.setUpdateTime(new Date());
            customShopSkuMapper.updateByPrimaryKeySelective(shopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 折线图显示某父sku子sku销售数量
     * @author baixueping
     * @date 2019/11/4 11:41
     */
    @Override
    public BaseResponse salesCountChart(SalesCountRequest params) {
        //判断参数是否完整
        StringBuilder sbErro = new StringBuilder();
        if (params.getShopParentSku() == null) {
            sbErro.append(",店铺父sku不能为空");
        }
        if (params.getPurchaseDateStart() == null) {
            sbErro.append(",开始时间不能为空");
        }
        if (params.getPurchaseDateEnd() == null) {
            sbErro.append(",结束时间不能为空");
        }
        if (params.getPurchaseDateStart() != null
                && params.getPurchaseDateEnd() != null
                && params.getPurchaseDateStart().after(params.getPurchaseDateEnd())) {
            sbErro.append(",开始时间必须大于结束时间");
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        BaseResponse res;
        if ("shopParentSku".equals(params.getSearchType())) {
            return getShopParentSkuRes(params);
        } else {
            res = getShopSkuRes(params);
        }
        return res;
    }

    private BaseResponse getShopParentSkuRes(SalesCountRequest params) {
        //获取子sku
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andShopParentSkuEqualTo(params.getShopParentSku());
        long count = customShopSkuMapper.countByExample(shopSkuExample);
        if (count == 0) {
            return BaseResponse.failMessage("店铺父sku不存在");
        }
        //组装子skuid
        List<String> shopParentSkuList = new ArrayList<>();
        shopParentSkuList.add(params.getShopParentSku());
        params.setShopParentSkuList(shopParentSkuList);
        //统计子sku销售数量
        List<SalesCountDayResponse> salesCountDayResponseList = customOrderImportMapper.listSalesCountDayShopParentSkuResponse(params);
        List<SalesPriceDayResponse> salesPriceDayResponseList = customOrderImportMapper.listSalesPriceDayShopParentSkuResponse(params);
        String categories = getSalesCountChartCategories(params);


        StringBuilder sbSeries = new StringBuilder();
        sbSeries.append("[");
        for (int i = 0; i < shopParentSkuList.size(); i++) {
            if (i == 0) {
                sbSeries.append("{");
            } else {
                sbSeries.append(",{");
            }
            sbSeries.append("\"name\":\"" + shopParentSkuList.get(i) + "(销量)\",\"yAxis\": 0,\"data\":[");
            Date dateTime = params.getPurchaseDateStart();
            while (!dateTime.after(params.getPurchaseDateEnd())) {
                Integer saleCount = getSaleCountShopParentSku(shopParentSkuList.get(i), salesCountDayResponseList, dateTime);
                if (!dateTime.equals(params.getPurchaseDateStart())) {
                    sbSeries.append(",");
                }
                sbSeries.append(saleCount);
                dateTime = DateUtil.plusDay(1, dateTime);
            }
            sbSeries.append("]}");
        }
        StringBuilder seriesShopParentSkuPrice = getSeriesShopParentSkuPrice(shopParentSkuList, params, salesPriceDayResponseList);
        sbSeries.append(seriesShopParentSkuPrice);
        sbSeries.append("]");
        String res = "{\"categories\":" + categories + ",\"series\":" + sbSeries.toString() + "}";
        return BaseResponse.successData(res);
    }

    private StringBuilder getSeriesShopParentSkuPrice(List<String> shopParentSkuList, SalesCountRequest params, List<SalesPriceDayResponse> salesPriceDayResponseList) {
        StringBuilder sbSeries = new StringBuilder();
        for (int i = 0; i < shopParentSkuList.size(); i++) {
            sbSeries.append(",{\"name\":\"" + shopParentSkuList.get(i) + "(价格)\",\"yAxis\": 1,\"data\":[");
            Date dateTime = params.getPurchaseDateStart();
            while (!dateTime.after(params.getPurchaseDateEnd())) {
                BigDecimal salePrice = getSalePriceShopParentSku(shopParentSkuList.get(i), salesPriceDayResponseList, dateTime);
                if (!dateTime.equals(params.getPurchaseDateStart())) {
                    sbSeries.append(",");
                }
                sbSeries.append(salePrice);
                dateTime = DateUtil.plusDay(1, dateTime);
            }
            sbSeries.append("]}");
        }
        return sbSeries;
    }

    private BigDecimal getSalePriceShopParentSku(String shopParentSku, List<SalesPriceDayResponse> salesPriceDayResponseList, Date dateTime) {
        for (SalesPriceDayResponse salesPriceDayResponse : salesPriceDayResponseList) {
            if (shopParentSku.equals(salesPriceDayResponse.getShopParentSku())
                    && DateUtil.getFormatDateStrYMD(dateTime).equals(salesPriceDayResponse.getPurchaseDate())) {
                BigDecimal salePrice = salesPriceDayResponse.getPrice();
                salesPriceDayResponseList.remove(salesPriceDayResponse);
                return salePrice;
            }
        }
        return null;
    }

    private BaseResponse getShopSkuRes(SalesCountRequest params) {
        //获取子sku
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andShopParentSkuEqualTo(params.getShopParentSku());
        shopSkuExample.setOrderByClause(" shop_sku asc");
        List<ShopSku> shopSkuList = customShopSkuMapper.selectByExample(shopSkuExample);
        if (CollectionUtils.isEmpty(shopSkuList)) {
            return BaseResponse.failMessage("店铺父sku不存在");
        }
        //组装子skuid
        List<Integer> shopSkuIdList = shopSkuList.stream().map(ShopSku::getShopSkuId).collect(Collectors.toList());
        params.setShopSkuIdList(shopSkuIdList);
        //统计子sku销售数量
        List<SalesCountDayResponse> salesCountDayResponseList = customOrderImportMapper.listSalesCountDayResponse(params);
        List<SalesPriceDayResponse> salesPriceDayResponseList = customOrderImportMapper.listSalesPriceDayResponse(params);
        String categories = getSalesCountChartCategories(params);
        StringBuilder sbSeries = new StringBuilder();
        sbSeries.append("[");
        for (int i = 0; i < shopSkuList.size(); i++) {
            if (i == 0) {
                sbSeries.append("{");
            } else {
                sbSeries.append(",{");
            }
            sbSeries.append("\"name\":\"" + shopSkuList.get(i).getShopSku() + "(销量)\",\"yAxis\": 0,\"data\":[");
            Date dateTime = params.getPurchaseDateStart();
            while (!dateTime.after(params.getPurchaseDateEnd())) {
                Integer saleCount = getSaleCount(shopSkuList.get(i).getShopSkuId(), salesCountDayResponseList, dateTime);
                if (!dateTime.equals(params.getPurchaseDateStart())) {
                    sbSeries.append(",");
                }
                sbSeries.append(saleCount);
                dateTime = DateUtil.plusDay(1, dateTime);
            }
            sbSeries.append("]}");
        }
        StringBuilder seriesShopSkuPrice = getSeriesShopSkuPrice(shopSkuList, params, salesPriceDayResponseList);
        sbSeries.append(seriesShopSkuPrice);
        sbSeries.append("]");


        String res = "{\"categories\":" + categories + ",\"series\":" + sbSeries.toString() + "}";
        return BaseResponse.successData(res);
    }

    private StringBuilder getSeriesShopSkuPrice(List<ShopSku> shopSkuList, SalesCountRequest params, List<SalesPriceDayResponse> salesPriceDayResponseList) {
        StringBuilder sbSeries = new StringBuilder();
        for (int i = 0; i < shopSkuList.size(); i++) {
            sbSeries.append(",{\"name\":\"" + shopSkuList.get(i).getShopSku() + "(价格)\",\"yAxis\": 1,\"data\":[");
            Date dateTime = params.getPurchaseDateStart();
            while (!dateTime.after(params.getPurchaseDateEnd())) {
                BigDecimal salePrice = getSalePrice(shopSkuList.get(i).getShopSkuId(), salesPriceDayResponseList, dateTime);
                if (!dateTime.equals(params.getPurchaseDateStart())) {
                    sbSeries.append(",");
                }
                sbSeries.append(salePrice);
                dateTime = DateUtil.plusDay(1, dateTime);
            }
            sbSeries.append("]}");
        }
        return sbSeries;
    }

    private BigDecimal getSalePrice(Integer shopSkuId, List<SalesPriceDayResponse> salesPriceDayResponseList, Date dateTime) {
        for (SalesPriceDayResponse salesPriceDayResponse : salesPriceDayResponseList) {
            if (shopSkuId.equals(salesPriceDayResponse.getShopSkuId())
                    && DateUtil.getFormatDateStrYMD(dateTime).equals(salesPriceDayResponse.getPurchaseDate())) {
                BigDecimal salePrice = salesPriceDayResponse.getPrice();
                salesPriceDayResponseList.remove(salesPriceDayResponse);
                return salePrice;
            }
        }
        return null;
    }

    /**
     * @param asin@return
     * @description 通过asin获取shopSku
     * @author baixueping
     * @date 2019/12/2 9:51
     */
    @Override
    public ShopSku getShopSkuByAsin(String asin) {
        if (StringUtils.isEmpty(asin)) {
            return null;
        }
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andAsinEqualTo(asin);
        List<ShopSku> list = customShopSkuMapper.selectByExample(shopSkuExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }


    @Override
    public ShopSku getShopSkuByFnsku(String fnsku) {
        if (StringUtils.isEmpty(fnsku)) {
            return null;
        }
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andFnskuEqualTo(fnsku);
        List<ShopSku> list = customShopSkuMapper.selectByExample(shopSkuExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public BaseResponse importProduceStatus(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, User> userMap = new HashMap<>();
        List<String> userNameNotExistList = new ArrayList<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("生产状态"))) {
                sbErroItem.append(",").append(ShopSkuConstant.PRODUCE_STATUS_EMPTY);
            } else {
                ShopSkuConstant.ShopSkuProduceStatusEnum shopSkuProduceStatusEnum = ShopSkuConstant.ShopSkuProduceStatusEnum.getShopSkuProduceStatusEnumByStatusName(map.get("生产状态"));
                if (shopSkuProduceStatusEnum == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.PRODUCE_STATUS_ERROE);
                } else {
                    map.put("produceStatus", shopSkuProduceStatusEnum.getStatus().toString());
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            ShopSku shopSkuUpdate = new ShopSku();
            shopSkuUpdate.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            shopSkuUpdate.setProduceStatus(MathUtil.strToInteger(map.get("produceStatus")));
            shopSkuUpdate.setUpdateBy(dealUserId);
            shopSkuUpdate.setUpdateTime(new Date());
            customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse importShopSkuStorageLocation(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, List<Integer>> locationMap = new HashMap<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                }
            }
            if (!StringUtils.isEmpty(map.get("库位"))) {
                List<Integer> locationIdList = new ArrayList<>();
                String locationNos = map.get("库位").replace("，", ",");
                List<String> locationNoList = Arrays.asList(locationNos.split(","));
                List<StorageLocation> storageLocationList = storageLocationService.listStorageLocationByLocationNoList(locationNoList);
                for (String locationNo : locationNoList) {
                    Optional<StorageLocation> optionalStorageLocation = storageLocationList.stream().filter(item -> item.getLocationNo().equals(locationNo)).findFirst();
                    if (optionalStorageLocation.isPresent()) {
                        locationIdList.add(optionalStorageLocation.get().getId());
                    } else {
                        sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.LOCATION_NO_NOT_EXIST);
                        break;
                    }

                }
                locationMap.put(map.get("店铺sku"),locationIdList);
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            List<Integer> storageLocationList=locationMap.get(map.get("店铺sku"));
            if(!CollectionUtils.isEmpty(storageLocationList)){
                BatchSaveShopSkuStorageLocationRequest batchSaveShopSkuStorageLocationRequest=new BatchSaveShopSkuStorageLocationRequest();
                batchSaveShopSkuStorageLocationRequest.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
                batchSaveShopSkuStorageLocationRequest.setStorageLocationIdList(storageLocationList);
                batchSaveShopSkuStorageLocationRequest.setCreateBy(dealUserId);
                shopSkuStorageLocationService.batchSaveShopSkuStorageLocation(batchSaveShopSkuStorageLocationRequest);
            }
        }
        return BaseResponse.success();
    }

    @Override
    public List<ListOutboundShopSkuResponse> listOutboundShopSku(ListOutboundShopSkuRequest listOutboundShopSkuRequest) {
        return customShopSkuMapper.listOutboundShopSku(listOutboundShopSkuRequest);
    }

    @Override
    public List<ShopSku> getShopSkuListByShpSkuOrFnsku(List<String> skuList) {
        if(CollectionUtils.isEmpty(skuList)){
            return new ArrayList<>();
        }
        ShopSkuExample shopSkuExample=new ShopSkuExample();
        shopSkuExample.createCriteria().andShopSkuIn(skuList);
        shopSkuExample.or().andFnskuIn(skuList);
        return customShopSkuMapper.selectByExample(shopSkuExample);
    }

    @Override
    public List<ShopSku> getShopSkuListByShopSku(List<String> shopSkuList) {
        if(CollectionUtils.isEmpty(shopSkuList)){
            return new ArrayList<>();
        }
        ShopSkuExample shopSkuExample=new ShopSkuExample();
        shopSkuExample.createCriteria().andShopSkuIn(shopSkuList);
        return customShopSkuMapper.selectByExample(shopSkuExample);
    }

    @Override
    public List<ShopSku> getShopSkuListByAsin(List<String> asinList) {
        if(CollectionUtils.isEmpty(asinList)){
            return new ArrayList<>();
        }
        ShopSkuExample shopSkuExample=new ShopSkuExample();
        shopSkuExample.createCriteria().andAsinIn(asinList);
        return customShopSkuMapper.selectByExample(shopSkuExample);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入sku销售人员
     * @author baixueping
     * @date 2020/1/3 16:02
     */
    @Override
    public BaseResponse importSalesmanUser(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, User> userMap = new HashMap<>();
        List<String> userNameNotExistList = new ArrayList<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                ShopSku shopSku = getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("销售人员用户名"))) {
                sbErroItem.append(",").append(ShopSkuConstant.SALESMAN_USERNAME_EMPTY);
            } else {
                User user = userMap.get(map.get("销售人员用户名"));
                if (user == null) {
                    if (!userNameNotExistList.contains(map.get("销售人员用户名"))) {
                        user = userService.getUserByUserName(map.get("销售人员用户名"));
                        if (user == null) {
                            userNameNotExistList.add(map.get("销售人员用户名"));
                        } else {
                            userMap.put(map.get("销售人员用户名"), user);
                        }
                    }
                }
                if (user == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SALESMAN_USERNAME_NOT_EXIST);
                } else {
                    map.put("salesmanUserId", user.getUserId().toString());
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            ShopSku shopSkuUpdate = new ShopSku();
            shopSkuUpdate.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            shopSkuUpdate.setSalesmanUserId(MathUtil.strToInteger(map.get("salesmanUserId")));
            shopSkuUpdate.setUpdateBy(dealUserId);
            shopSkuUpdate.setUpdateTime(new Date());
            customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
        }
        return BaseResponse.success();
    }

    /**
     * @param shopSkuId@return
     * @description 根据shopSkuId获取shopsku
     * @author baixueping
     * @date 2020/5/7 16:17
     */
    @Override
    public ShopSku getShopSku(Integer shopSkuId) {
        if (shopSkuId == null) {
            return null;
        }
        return customShopSkuMapper.selectByPrimaryKey(shopSkuId);
    }

    /**
     * @param params@return
     * @description 修改库存
     * @author baixueping
     * @date 2020/5/7 16:56
     */
    @Override
    public void updateInventoryQuantity(UpdateShopSkuInventoryQuantityRequest params) {
        ShopSku shopSku = null;
        if (params.getShopSkuInfo() != null) {
            shopSku = params.getShopSkuInfo();
        } else {
            shopSku = getShopSku(params.getShopSkuId());
        }
        if (shopSku == null) {
            throw new NoticeException(String.format(WarehousingOrderConstant.SHOP_SKU_ID_NOT_EXIST, params.getShopSkuId()));
        }
        Integer inventoryQuantity = null;
        Integer modifiedQuantity = null;
        if (InventoryChangeRecordConstant.ChangeTypeEnum.CHECK.equals(params.getChangeTypeEnum())) {
            inventoryQuantity = params.getQuantity();
            modifiedQuantity = MathUtil.subtractInteger(inventoryQuantity, shopSku.getInventoryQuantity());
        } else if (InventoryChangeRecordConstant.ChangeTypeEnum.OUT_BOUND.equals(params.getChangeTypeEnum())) {
            inventoryQuantity = MathUtil.subtractInteger(shopSku.getInventoryQuantity(), params.getQuantity());
            if (inventoryQuantity < 0) {
                throw new NoticeException(String.format("出库失败，店铺sku[%s]库存不足", shopSku.getShopSku()));
            }
            modifiedQuantity = -params.getQuantity();
        } else if (InventoryChangeRecordConstant.ChangeTypeEnum.WAREHOUSING.equals(params.getChangeTypeEnum())) {
            inventoryQuantity = MathUtil.addInteger(shopSku.getInventoryQuantity(), params.getQuantity());
            modifiedQuantity = params.getQuantity();
        } else if (InventoryChangeRecordConstant.ChangeTypeEnum.TRANSFER_FROM.equals(params.getChangeTypeEnum())) {
            inventoryQuantity = MathUtil.subtractInteger(shopSku.getInventoryQuantity(), params.getQuantity());
            if (inventoryQuantity < 0) {
                throw new NoticeException(String.format("调拨失败，店铺sku[%s]库存不足", shopSku.getShopSku()));
            }
            modifiedQuantity = -params.getQuantity();
        } else if (InventoryChangeRecordConstant.ChangeTypeEnum.TRANSFER_TO.equals(params.getChangeTypeEnum())) {
            inventoryQuantity = MathUtil.addInteger(shopSku.getInventoryQuantity(), params.getQuantity());
            modifiedQuantity = params.getQuantity();
        }
        ShopSku shopSkuUpdate = new ShopSku();
        shopSkuUpdate.setShopSkuId(params.getShopSkuId());
        shopSkuUpdate.setInventoryQuantity(inventoryQuantity);
        shopSkuUpdate.setUpdateTime(new Date());
        shopSkuUpdate.setUpdateBy(params.getDealUserId());
        customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
        AddInventoryChangeRecordRequest addInventoryChangeRecordRequest = new AddInventoryChangeRecordRequest();
        addInventoryChangeRecordRequest.setShopSkuId(params.getShopSkuId());
        addInventoryChangeRecordRequest.setChangeType(params.getChangeTypeEnum().getChangeType());
        addInventoryChangeRecordRequest.setEntityId(params.getEntityId());
        addInventoryChangeRecordRequest.setMainEntityId(params.getMainEntityId());
        addInventoryChangeRecordRequest.setInventoryQuantityNew(inventoryQuantity);
        addInventoryChangeRecordRequest.setInventoryQuantityOld(shopSku.getInventoryQuantity());
        addInventoryChangeRecordRequest.setModifiedQuantity(modifiedQuantity);
        addInventoryChangeRecordRequest.setCreateBy(params.getDealUserId());
        inventoryChangeRecordService.addInventoryChangeRecord(addInventoryChangeRecordRequest);
    }

    /**
     * @param skuId@return
     * @description 获取库存
     * @author baixueping
     * @date 2020/5/9 10:11
     */
    @Override
    public Integer getSkuInventoryQuantity(Integer skuId) {
        Integer inventoryQuantity = customShopSkuMapper.getSkuInventoryQuantity(skuId);
        if (inventoryQuantity == null) {
            return 0;
        }
        return inventoryQuantity;
    }

    @Override
    public List<ShopSkuFullProductName> listShopSkuFullProductNameByShopSkuId(List<Integer> shopSkuIdList) {
        if (CollectionUtils.isEmpty(shopSkuIdList)) {
            return null;
        }
        return customShopSkuMapper.listShopSkuFullProductNameByShopSkuId(shopSkuIdList);
    }

    /**
     * @param shopId
     * @return
     * @description 判断是否存在没有头程费的店铺sku
     * @author baixueping
     * @date 2020/8/14 15:34
     */
    @Override
    public boolean existWithoutHeadTripCostShopSku(Integer shopId) {
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andShopIdEqualTo(shopId).andHeadTripCostIsNull();
        return customShopSkuMapper.countByExample(example) > 0;
    }

    /**
     * @param shopId
     * @param month
     * @return
     * @description
     * @author baixueping
     * @date 2020/8/17 17:06
     */
    @Override
    public List<ShopSkuHeadTripCostInfo> listNotExistShopSkuHeadTripCost(Integer shopId, Date month) {

        return customShopSkuMapper.listNotExistShopSkuHeadTripCost(shopId, month);
    }

    @Override
    public boolean existWithoutWeightShopSku(Integer shopId) {
        return customShopSkuMapper.existWithoutWeightShopSku(shopId) > 0;
    }

    @Override
    public List<ShopSku> listShopSku(List<Integer> shopSkuIdList) {
        if (CollectionUtils.isEmpty(shopSkuIdList)) {
            return null;
        }
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andShopSkuIdIn(shopSkuIdList);
        return customShopSkuMapper.selectByExample(shopSkuExample);
    }

    @Override
    public ShopSku getShopSkuBySkuIdShopId(Integer shopId, Integer skuId) {
        if (shopId == null || skuId == null) {
            return null;
        }
        ShopSkuExample shopSkuExample = new ShopSkuExample();
        shopSkuExample.createCriteria().andShopIdEqualTo(shopId).andSkuIdEqualTo(skuId);
        List<ShopSku> list = customShopSkuMapper.selectByExample(shopSkuExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public ShopSku getShopSkuBySkuShopId(Integer shopId, String sku) {
        if (shopId == null || StringUtils.isEmpty(sku)) {
            return null;
        }
        return customShopSkuMapper.getShopSkuBySkuShopId(shopId, sku);
    }

    @Override
    public boolean existShopSku(List<Integer> skuIds) {
        if (CollectionUtils.isEmpty(skuIds)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        example.createCriteria().andSkuIdIn(skuIds);
        return customShopSkuMapper.countByExample(example) > 0;
    }

    @Override
    public List<ShopSku> getShopSkuByShopParentSkuAndSize(GetShopSkuByShopParentSkuAndSizeRequest getShopSkuByShopParentSkuAndSizeRequest) {
        return customShopSkuMapper.getShopSkuByShopParentSkuAndSize(getShopSkuByShopParentSkuAndSizeRequest);
    }

    /**
     * @param params@return
     * @description 查询其他店铺库存信息
     * @author baixueping
     * @date 2021/3/30 14:43
     */
    @Override
    public PageInfo<ListInventoryQuantityResponse> listInventoryQuantity(ListInventoryQuantityRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInventoryQuantityResponse> list = customShopSkuMapper.listInventoryQuantity(params);
        PageInfo<ListInventoryQuantityResponse> page = new PageInfo<ListInventoryQuantityResponse>(list);
        return page;
    }

    @Override
    public BaseResponse stopShopSku(Integer shopSkuId, Integer currentUserId) {
        if (shopSkuId == null) {
            return BaseResponse.failMessage("shopSkuId不能为空");
        }
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(shopSkuId);
        if (shopSku == null) {
            return BaseResponse.failMessage("shopSkuId不存在");
        }
        ShopSku shopSkuUpdate = new ShopSku();
        shopSkuUpdate.setShopSkuId(shopSkuId);
        shopSkuUpdate.setStatus(ShopSkuConstant.ShopSkuStatusEnum.UNAVAILABLE.getStatus());
        shopSkuUpdate.setUpdateTime(new Date());
        shopSkuUpdate.setUpdateBy(currentUserId);
        customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse setShopSkuProduceStatus(SetProduceStatusRequest params, Integer currentUserId) {
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(params.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage("shopSkuId不存在");
        }
        if (ShopSkuConstant.ShopSkuProduceStatusEnum.getShopSkuProduceStatusEnumByStatus(params.getProduceStatus()) == null) {
            return BaseResponse.failMessage("生产状态produceStatus错误");
        }
        ShopSku shopSkuUpdate = new ShopSku();
        shopSkuUpdate.setShopSkuId(params.getShopSkuId());
        shopSkuUpdate.setProduceStatus(params.getProduceStatus());
        shopSkuUpdate.setUpdateTime(new Date());
        shopSkuUpdate.setUpdateBy(currentUserId);
        customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
        return BaseResponse.success();
    }

    /**
     * @param
     * @return
     * @description 获取销售数量
     * @author baixueping
     * @date 2019/11/4 16:07
     */
    private Integer getSaleCount(Integer shopSkuId, List<SalesCountDayResponse> salesCountDayResponseList, Date dateTime) {
        for (SalesCountDayResponse salesCountDayResponse : salesCountDayResponseList) {
            if (shopSkuId.equals(salesCountDayResponse.getShopSkuId())
                    && DateUtil.getFormatDateStrYMD(dateTime).equals(salesCountDayResponse.getPurchaseDate())) {
                Integer saleCount = salesCountDayResponse.getQuantity();
                salesCountDayResponseList.remove(salesCountDayResponse);
                return saleCount;
            }
        }
        return 0;
    }


    private Integer getSaleCountShopParentSku(String shopParentSku, List<SalesCountDayResponse> salesCountDayResponseList, Date dateTime) {
        for (SalesCountDayResponse salesCountDayResponse : salesCountDayResponseList) {
            if (shopParentSku.equals(salesCountDayResponse.getShopParentSku())
                    && DateUtil.getFormatDateStrYMD(dateTime).equals(salesCountDayResponse.getPurchaseDate())) {
                Integer saleCount = salesCountDayResponse.getQuantity();
                salesCountDayResponseList.remove(salesCountDayResponse);
                return saleCount;
            }
        }
        return 0;
    }

    /**
     * @param
     * @return
     * @description 获取横坐标
     * @author baixueping
     * @date 2019/11/4 15:57
     */
    private String getSalesCountChartCategories(SalesCountRequest params) {
        StringBuilder sb = new StringBuilder();
        Date dateTime = params.getPurchaseDateStart();
        sb.append("[");
        while (!dateTime.after(params.getPurchaseDateEnd())) {
            if (!dateTime.equals(params.getPurchaseDateStart())) {
                sb.append(",");
            }
            sb.append("\"").append(DateUtil.getFormatDateStrYMD(dateTime)).append("\"");
            dateTime = DateUtil.plusDay(1, dateTime);
        }
        sb.append("]");
        return sb.toString();
    }

    private Shop getShopByShopSku(String shopSku) {
        if (StringUtils.isEmpty(shopSku)) {
            return null;
        }
        ShopSku shopSkuInfo = getShopSkuByShopSku(shopSku);
        if (shopSkuInfo == null) {
            return null;
        }
        Shop shop = shopService.getShop(shopSkuInfo.getShopId());
        if (shop == null) {
            return null;
        }
        return shop;
    }


    private String getSalesInfoShopParentSku(List<SalesCountResponse> list, SalesCountRequest params) {
        StringBuilder sbItems = new StringBuilder();
        List<String> shopParentSkuList = list.stream().map(SalesCountResponse::getShopParentSku).collect(Collectors.toList());
        params.setShopParentSkuList(shopParentSkuList);
        List<SalesCountDayResponse> salesCountDayResponseList = customOrderImportMapper.listSalesCountDayShopParentSkuResponse(params);
        List<String> dateList = getDateList(params);
        for (SalesCountResponse salesCountResponse : list) {
            sbItems.append(",{");
            sbItems.append("\"shopName\":\"" + salesCountResponse.getShopName() + "\",");
            sbItems.append("\"shopSku\":\"" + salesCountResponse.getShopSku() + "\",");
            sbItems.append("\"shopSkuId\":\"" + salesCountResponse.getShopSkuId() + "\",");
            sbItems.append("\"shopParentSku\":\"" + salesCountResponse.getShopParentSku() + "\",");
            sbItems.append("\"productCode\":\"" + salesCountResponse.getProductCode() + "\",");
            sbItems.append("\"productName\":\"" + salesCountResponse.getProductName() + "\",");
            Integer total = 0;
            for (SalesCountDayResponse salesCountDayResponse : salesCountDayResponseList) {
                if (salesCountDayResponse.getShopParentSku().equals(salesCountResponse.getShopParentSku())) {
                    total = total + salesCountDayResponse.getQuantity();
                    sbItems.append("\"day" + salesCountDayResponse.getPurchaseDate() + "\":" + salesCountDayResponse.getQuantity() + ",");
                }
            }
            sbItems.append("\"total\":" + total + "}");
        }
        return sbItems.substring(1);
    }

    private String getSalesInfo(List<SalesCountResponse> list, SalesCountRequest params) {
        StringBuilder sbItems = new StringBuilder();
        List<Integer> shopSkuIdList = list.stream().map(SalesCountResponse::getShopSkuId).collect(Collectors.toList());
        params.setShopSkuIdList(shopSkuIdList);
        List<SalesCountDayResponse> salesCountDayResponseList = customOrderImportMapper.listSalesCountDayResponse(params);
        List<String> dateList = getDateList(params);
        for (SalesCountResponse salesCountResponse : list) {
            sbItems.append(",{");
            sbItems.append("\"shopName\":\"" + salesCountResponse.getShopName() + "\",");
            sbItems.append("\"shopSku\":\"" + salesCountResponse.getShopSku() + "\",");
            sbItems.append("\"shopSkuId\":\"" + salesCountResponse.getShopSkuId() + "\",");
            sbItems.append("\"shopParentSku\":\"" + salesCountResponse.getShopParentSku() + "\",");
            sbItems.append("\"productCode\":\"" + salesCountResponse.getProductCode() + "\",");
            sbItems.append("\"productName\":\"" + salesCountResponse.getProductName() + "\",");
            Integer total = 0;
            for (SalesCountDayResponse salesCountDayResponse : salesCountDayResponseList) {
                if (salesCountDayResponse.getShopSkuId().equals(salesCountResponse.getShopSkuId())) {
                    total = total + salesCountDayResponse.getQuantity();
                    sbItems.append("\"day" + salesCountDayResponse.getPurchaseDate() + "\":" + salesCountDayResponse.getQuantity() + ",");
                }
            }
            sbItems.append("\"total\":" + total + "}");
        }
        return sbItems.substring(1);
    }

    private List<String> getDateList(SalesCountRequest params) {
        return null;
    }

    public PageInfo<SalesCountResponse> listSelectSalesCountShopSku(SalesCountRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<SalesCountResponse> list = customShopSkuMapper.listSelectSalesCountShopSku(params);
        PageInfo<SalesCountResponse> page = new PageInfo<SalesCountResponse>(list);
        return page;
    }

    private TranformShopSkuInfoResponse getSkuInfo(List<TranformShopSkuInfoResponse> tranformShopSkuInfoResponseList, String shopSku) {
        if (CollectionUtils.isEmpty(tranformShopSkuInfoResponseList) || StringUtils.isEmpty(shopSku)) {
            return null;
        }
        for (TranformShopSkuInfoResponse tranformShopSkuInfoResponse : tranformShopSkuInfoResponseList) {
            if (shopSku.equals(tranformShopSkuInfoResponse.getShopSku())) {
                return tranformShopSkuInfoResponse;
            }
        }
        return null;
    }

    private boolean existOtherShopSku(Integer shopSkuId, String shopSku) {
        if (StringUtils.isEmpty(shopSku)) {
            return false;
        }
        ShopSkuExample example = new ShopSkuExample();
        if (shopSkuId == null) {
            example.createCriteria().andShopSkuEqualTo(shopSku);
        } else {
            example.createCriteria().andShopSkuEqualTo(shopSku).andShopSkuIdNotEqualTo(shopSkuId);
        }
        return customShopSkuMapper.countByExample(example) > 0;
    }

    private void setShopSku(ShopSku shopSku, SaveShopSkuRequest params) {
        if (shopSku == null || params == null) {
            return;
        }
        shopSku.setShopSku(params.getShopSku());
        shopSku.setFnsku(params.getFnsku());
        shopSku.setSalesmanUserId(params.getSalesmanUserId());
        shopSku.setRemark(params.getRemark());
        shopSku.setTitle(params.getTitle());
        shopSku.setShopParentSku(params.getShopParentSku());
        shopSku.setUpdateBy(params.getUserId());
        shopSku.setUpdateTime(new Date());
        shopSku.setAsin(params.getAsin());
        shopSku.setStatus(params.getStatus());
        shopSku.setParentAsin(params.getParentAsin());
        shopSku.setStorageLocation(params.getStorageLocation());
    }

    private Integer getShopId(List<Shop> shopList, String shopName) {
        if (CollectionUtils.isEmpty(shopList) || StringUtils.isEmpty(shopName)) {
            return null;
        }
        for (Shop shop : shopList) {
            if (shopName.equals(shop.getShopName())) {
                return shop.getShopId();
            }
        }
        return null;
    }

    private void setShopSkuByMap(Map<String, String> map, ShopSku shopSku) {
        shopSku.setShopId(MathUtil.strToInteger(map.get("shopId")));
        shopSku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
        shopSku.setShopSku(map.get("店铺sku"));
        shopSku.setShopParentSku(map.get("店铺父sku"));
        shopSku.setParentAsin(map.get("店铺父ASIN"));
        shopSku.setFnsku(map.get("FNSKU"));
        shopSku.setAsin(map.get("ASIN"));
        shopSku.setTitle(map.get("标题"));
        shopSku.setRemark(map.get("备注"));
    }
}
