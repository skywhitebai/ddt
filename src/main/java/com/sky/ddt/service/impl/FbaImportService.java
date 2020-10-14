package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FbaImportConstant;
import com.sky.ddt.dao.custom.CustomFbaImportMapper;
import com.sky.ddt.dto.fbaImport.request.ListFbaImportRequest;
import com.sky.ddt.dto.fbaImport.response.ListFbaImportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaImport;
import com.sky.ddt.entity.FbaImportExample;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IFbaImportService;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description FBA服务
 * @date 2019/8/15 10:12
 */
@Service
public class FbaImportService implements IFbaImportService {
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomFbaImportMapper customFbaImportMapper;
    @Autowired
    IShopService shopService;
    /**
     * @param file
     * @param userId
     * @return
     * @description fba导入
     * @author baixueping
     * @date 2019/8/15 10:23
     */
    @Override
    public BaseResponse importFba(MultipartFile file, Integer userId) {
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
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(FbaImportConstant.SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(FbaImportConstant.SKU_NOT_EXIST);
                } else{
                    if (!shopIdList.contains(shopSku.getShopId())) {
                        sbErroItem.append(",").append(FbaImportConstant.SKU_NOT_USER_SHOP);
                    }else{
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                        map.put("shopId", shopSku.getShopId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("fnsku"))) {
                sbErroItem.append(",").append(FbaImportConstant.FNSKU_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("asin"))) {
                sbErroItem.append(",").append(FbaImportConstant.ASIN_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("product-name"))) {
                sbErroItem.append(",").append(FbaImportConstant.PRODUCT_NAME_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("your-price"))) {
                sbErroItem.append(",").append(FbaImportConstant.YOUR_PRICE_EMPTY);
            } else {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("your-price"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(FbaImportConstant.YOUR_PRICE_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("mfn-listing-exists"))) {
                if (!map.get("mfn-listing-exists").equals("Yes") && !map.get("mfn-listing-exists").equalsIgnoreCase("No")) {
                    sbErroItem.append(",").append(FbaImportConstant.MFN_LISTING_EXISTS_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("mfn-fulfillable-quantity"))) {
                Integer quantity = MathUtil.strToInteger(map.get("mfn-fulfillable-quantity"));
                if (quantity == null || quantity <= 0) {
                    sbErroItem.append(",").append(FbaImportConstant.MFN_FULFILLABLE_QUANTITY_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("afn-listing-exists"))) {
                if (!map.get("afn-listing-exists").equalsIgnoreCase("Yes") && !map.get("afn-listing-exists").equalsIgnoreCase("No")) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_LISTING_EXISTS_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-warehouse-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_WAREHOUSE_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-warehouse-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_WAREHOUSE_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-fulfillable-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_FULFILLABLE_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-fulfillable-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_FULFILLABLE_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-unsellable-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_UNSELLABLE_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-unsellable-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_UNSELLABLE_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-reserved-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_RESERVED_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-reserved-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_RESERVED_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-total-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_TOTAL_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-total-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_TOTAL_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("per-unit-volume"))) {
                sbErroItem.append(",").append(FbaImportConstant.PER_UNIT_VOLUME_EMPTY);
            } else {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("per-unit-volume"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.PER_UNIT_VOLUME_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-inbound-working-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_WORKING_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-inbound-working-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_WORKING_QUANTITY_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("afn-inbound-shipped-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_SHIPPED_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-inbound-shipped-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_SHIPPED_QUANTITY_ERRO);
                }
            } if (StringUtils.isEmpty(map.get("afn-inbound-receiving-quantity"))) {
                sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_RECEIVING_QUANTITY_EMPTY);
            } else {
                Integer integer = MathUtil.strToInteger(map.get("afn-inbound-receiving-quantity"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append(FbaImportConstant.AFN_INBOUND_RECEIVING_QUANTITY_ERRO);
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
            FbaImport fbaImport=getFbaImport(map.get("sku"));
            if (fbaImport != null) {
                setFbaImportByMap(fbaImport, map);
                fbaImport.setUpdateBy(userId);
                fbaImport.setUpdateTime(new Date());
                customFbaImportMapper.updateByPrimaryKeySelective(fbaImport);
            } else {
                fbaImport = new FbaImport();
                setFbaImportByMap(fbaImport, map);
                fbaImport.setCreateBy(userId);
                fbaImport.setCreateTime(new Date());
                customFbaImportMapper.insertSelective(fbaImport);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 分页查询fba信息
     * @author baixueping
     * @date 2019/8/15 13:01
     */
    @Override
    public PageInfo<ListFbaImportResponse> listFbaImport(ListFbaImportRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaImportResponse> list = customFbaImportMapper.listFbaImport(params);
        PageInfo<ListFbaImportResponse> page = new PageInfo<ListFbaImportResponse>(list);
        return page;
    }

    private void setFbaImportByMap(FbaImport fbaImport, Map<String, String> map) {
        if (fbaImport == null || map == null) {
            return;
        }
        fbaImport.setShopId(MathUtil.strToInteger(map.get("shopId")));
        fbaImport.setSku(map.get("sku"));
        fbaImport.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
        fbaImport.setFnsku(map.get("fnsku"));
        fbaImport.setAsin(map.get("asin"));
        fbaImport.setProductName(map.get("product-name"));
        fbaImport.setConditions(map.get("condition"));
        fbaImport.setYourPrice(MathUtil.strToBigDecimal(map.get("your-price")));
        fbaImport.setMfnListingExists(map.get("mfn-listing-exists"));
        fbaImport.setMfnFulfillableQuantity(MathUtil.strToInteger(map.get("mfn-fulfillable-quantity")));
        fbaImport.setAfnListingExists(map.get("afn-listing-exists"));
        fbaImport.setAfnWarehouseQuantity(MathUtil.strToInteger(map.get("afn-warehouse-quantity")));
        fbaImport.setAfnFulfillableQuantity(MathUtil.strToInteger(map.get("afn-fulfillable-quantity")));
        fbaImport.setAfnUnsellableQuantity(MathUtil.strToInteger(map.get("afn-unsellable-quantity")));
        fbaImport.setAfnReservedQuantity(MathUtil.strToInteger(map.get("afn-reserved-quantity")));
        fbaImport.setAfnTotalQuantity(MathUtil.strToInteger(map.get("afn-total-quantity")));
        fbaImport.setPerUnitVolume(MathUtil.strToInteger(map.get("per-unit-volume")));
        fbaImport.setAfnInboundWorkingQuantity(MathUtil.strToInteger(map.get("afn-inbound-working-quantity")));
        fbaImport.setAfnInboundShippedQuantity(MathUtil.strToInteger(map.get("afn-inbound-shipped-quantity")));
        fbaImport.setAfnInboundReceivingQuantity(MathUtil.strToInteger(map.get("afn-inbound-receiving-quantity")));
    }

    private FbaImport getFbaImport(String sku) {
        if(StringUtils.isEmpty(sku)){
            return null;
        }
        FbaImportExample fbaImportExample=new FbaImportExample();
        fbaImportExample.createCriteria().andSkuEqualTo(sku);
        List<FbaImport> list=customFbaImportMapper.selectByExample(fbaImportExample);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
