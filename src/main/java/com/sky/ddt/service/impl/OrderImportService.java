package com.sky.ddt.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.OrderImportConstant;
import com.sky.ddt.dao.custom.CustomOrderImportMapper;
import com.sky.ddt.dto.config.OrderPurchaseDateConfig;
import com.sky.ddt.dto.orderImport.request.ListOrderImportRequest;
import com.sky.ddt.dto.orderImport.response.ListOrderImportResponse;
import com.sky.ddt.dto.orderImport.response.OrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IOrderImportService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.ISysConfigService;
import com.sky.ddt.util.BaseResponseUtils;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author baixueping
 * @description 导入订单管理
 * @date 2019/8/14 9:49
 */
@Service
public class OrderImportService implements IOrderImportService {
    Logger logger = LoggerFactory.getLogger(OrderImportService.class);
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomOrderImportMapper customOrderImportMapper;
    @Autowired
    ISysConfigService sysConfigService;

    /**
     * @param file
     * @param userId
     * @return
     * @description 导入订单
     * @author baixueping
     * @date 2019/8/14 9:54
     */
    @Override
    public BaseResponse importOrder(MultipartFile file, Integer userId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        List<Shop> shopList = shopUserService.listUserShop(userId);
        if (CollectionUtils.isEmpty(shopList)) {
            return BaseResponse.failMessage("用户只能上传自己管理的店铺sku");
        }
        Map<Integer, Shop> shopMap = getShopMap(shopList);
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
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

            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(OrderImportConstant.SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(OrderImportConstant.SKU_NOT_EXIST);
                } else {
                    if (!shopMap.containsKey(shopSku.getShopId())) {
                        sbErroItem.append(",").append(OrderImportConstant.SKU_NOT_USER_SHOP);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                        map.put("shopId", shopSku.getShopId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("amazon-order-id"))) {
                sbErroItem.append(",").append(OrderImportConstant.AMAZON_ORDER_ID_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("purchase-date"))) {
                sbErroItem.append(",").append(OrderImportConstant.PURCHASE_DATE_EMPTY);
            } else {
                Date date = DateUtil.UtcStrToDateTime(map.get("purchase-date"));
                if (date == null) {
                    sbErroItem.append(",").append(OrderImportConstant.PURCHASE_DATE_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("last-updated-date"))) {
                Date date = DateUtil.UtcStrToDateTime(map.get("last-updated-date"));
                if (date == null) {
                    sbErroItem.append(",").append(OrderImportConstant.LAST_UPDATED_DATE_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("order-status"))) {
                sbErroItem.append(",").append(OrderImportConstant.ORDER_STATUS_EMPTY);
            }

            if (StringUtils.isEmpty(map.get("asin"))) {
                sbErroItem.append(",").append(OrderImportConstant.ASIN_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("item-status"))) {
                sbErroItem.append(",").append(OrderImportConstant.ITEM_STATUS_EMPTY);
            }
            if (!StringUtils.isEmpty(map.get("quantity"))) {
                Integer quantity = MathUtil.strToInteger(map.get("quantity"));
                if (quantity == null || quantity < 0) {
                    sbErroItem.append(",").append(OrderImportConstant.QUANTITY_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("item-price"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("item-price"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                    sbErroItem.append(",").append(OrderImportConstant.ITEM_PRICE_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("item-tax"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("item-tax"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.ITEM_TAX_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("shipping-price"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("shipping-price"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.SHIPPING_PRICE_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("shipping-tax"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("shipping-tax"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.SHIPPING_TAX_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("gift-wrap-price"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("gift-wrap-price"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.GIFT_WRAP_PRICE_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("gift-wrap-tax"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("gift-wrap-tax"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.GIFT_WRAP_TAX_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("item-promotion-discount"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("item-promotion-discount"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.ITEM_PROMOTION_DISCOUNT_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("ship-promotion-discount"))) {
                BigDecimal bigDecimal = MathUtil.strToBigDecimal(map.get("ship-promotion-discount"));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(OrderImportConstant.SHIP_PROMOTION_DISCOUNT_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("is-business-order"))) {
                if (!map.get("is-business-order").equalsIgnoreCase("true") && !map.get("is-business-order").equalsIgnoreCase("false")) {
                    sbErroItem.append(",").append(OrderImportConstant.IS_BUSINESS_ORDER_ERRO);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        Map<Integer, Integer> orderPurchaseDateConfigMap = getOrderPurchaseDateConfigMap();
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
            OrderImport orderImport = getOrderImport(map.get("amazon-order-id"), map.get("sku"));
            if (orderImport != null) {
                setOrderImportByMap(orderImport, map,orderPurchaseDateConfigMap,shopMap);
                orderImport.setUpdateBy(userId);
                orderImport.setUpdateTime(new Date());
                customOrderImportMapper.updateByPrimaryKeySelective(orderImport);
            } else {
                orderImport = new OrderImport();
                setOrderImportByMap(orderImport, map,orderPurchaseDateConfigMap,shopMap);
                orderImport.setCreateBy(userId);
                orderImport.setCreateTime(new Date());
                customOrderImportMapper.insertSelective(orderImport);
            }
        }
        return BaseResponse.success();
    }

    private Map<Integer, Integer> getOrderPurchaseDateConfigMap() {
        Map<Integer, Integer> map = new HashMap<>();
        //获取配置信息
        BaseResponse<SysConfig> baseResponse = sysConfigService.getConfigByKey("orderPurchaseDate");
        if (BaseResponseUtils.isFailOrEmpty(baseResponse)) {
            return map;
        }
        String jsonStr = baseResponse.getData().getKeyValue();
        List<OrderPurchaseDateConfig> orderPurchaseDateConfigList = new ArrayList<>();
        try {
            orderPurchaseDateConfigList = JSON.parseArray(jsonStr, OrderPurchaseDateConfig.class);
        } catch (Exception ex) {
            logger.error("getOrderPurchaseDateConfigMap fail,exception：" + ex.getMessage());
            ex.printStackTrace();
            return map;
        }
        for (OrderPurchaseDateConfig orderPurchaseDateConfig :
                orderPurchaseDateConfigList) {
            if (Boolean.TRUE.equals(orderPurchaseDateConfig.getEnable())) {
                //重复自己判断 程序简单化处理
                map.put(orderPurchaseDateConfig.getCountryId(), orderPurchaseDateConfig.getDateAddSecond());
            }
        }
        return map;
    }

    private Map<Integer, Shop> getShopMap(List<Shop> shopList) {
        Map<Integer, Shop> map = new HashMap<>();
        for (Shop shop :
                shopList) {
            map.put(shop.getShopId(), shop);
        }
        return map;
    }

    /**
     * @param params@return
     * @description 分页查询导入订单信息
     * @author baixueping
     * @date 2019/8/14 12:44
     */
    @Override
    public PageInfo<ListOrderImportResponse> listOrderImport(ListOrderImportRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListOrderImportResponse> list = customOrderImportMapper.listOrderImport(params);
        PageInfo<ListOrderImportResponse> page = new PageInfo<ListOrderImportResponse>(list);
        return page;
    }

    /**
     * @param file
     * @return
     * @description 亚马逊订单号获取店铺sku
     * @author baixueping
     * @date 2019/9/19 15:58
     */
    @Override
    public BaseResponse<List<OrderShopSkuResponse>> listGetShopSku(MultipartFile file) {
        if (file == null) {
            return BaseResponse.failMessage("请选择文件");
        }
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        List<String> amazonOrderIdList = new ArrayList<>();
        for (Map<String, String> map : list) {
            String amazonOrderId = map.get("亚马逊订单号");
            if (!StringUtils.isEmpty(amazonOrderId)) {
                if (!amazonOrderIdList.contains(amazonOrderId)) {
                    amazonOrderIdList.add(amazonOrderId);
                }
            }
        }
        if (CollectionUtils.isEmpty(amazonOrderIdList)) {
            return BaseResponse.failMessage("请填写亚马逊订单号");
        }
        OrderImportExample example = new OrderImportExample();
        example.createCriteria().andAmazonOrderIdIn(amazonOrderIdList);
        example.setOrderByClause("amazon_order_id asc,sku asc");
        List<OrderImport> orderImportList = customOrderImportMapper.selectByExample(example);
        List<OrderShopSkuResponse> orderShopSkuResponseList = new ArrayList<>();
        for (OrderImport orderImport : orderImportList) {
            OrderShopSkuResponse orderShopSkuResponse = new OrderShopSkuResponse();
            orderShopSkuResponse.setAmazonOrderId(orderImport.getAmazonOrderId());
            orderShopSkuResponse.setSku(orderImport.getSku());
            orderShopSkuResponseList.add(orderShopSkuResponse);
        }
        return BaseResponse.successData(orderShopSkuResponseList);
    }

    private void setOrderImportByMap(OrderImport orderImport, Map<String, String> map, Map<Integer, Integer> orderPurchaseDateConfigMap, Map<Integer, Shop> shopMap) {
        if (orderImport == null || map == null) {
            return;
        }
        orderImport.setShopId(MathUtil.strToInteger(map.get("shopId")));
        orderImport.setAmazonOrderId(map.get("amazon-order-id"));
        orderImport.setMerchantOrderId(map.get("merchant-order-id"));
        orderImport.setPurchaseDateReal(DateUtil.UtcStrToDateTime(map.get("purchase-date")));
        Integer countryId=shopMap.get(orderImport.getShopId()).getCountryId();
        if(countryId!=null&&orderPurchaseDateConfigMap.containsKey(countryId)){
            orderImport.setPurchaseDate(DateUtil.plusSecond(orderPurchaseDateConfigMap.get(countryId),orderImport.getPurchaseDateReal()));
        }else{
            orderImport.setPurchaseDate(orderImport.getPurchaseDateReal());
        }
        orderImport.setLastUpdatedDateReal(DateUtil.UtcStrToDateTime(map.get("last-updated-date")));
        if(countryId!=null&&orderPurchaseDateConfigMap.containsKey(countryId)){
            orderImport.setLastUpdatedDate(DateUtil.plusSecond(orderPurchaseDateConfigMap.get(countryId),orderImport.getLastUpdatedDateReal()));
        }else{
            orderImport.setLastUpdatedDate(orderImport.getLastUpdatedDateReal());
        }
        orderImport.setOrderStatus(map.get("order-status"));
        orderImport.setFulfillmentChannel(map.get("fulfillment-channel"));
        orderImport.setSalesChannel(map.get("sales-channel"));
        orderImport.setOrderChannel(map.get("order-channel"));
        orderImport.setUrl(map.get("url"));
        orderImport.setShipServiceLevel(map.get("ship-service-level"));
        orderImport.setProductName(map.get("product-name"));
        orderImport.setSku(map.get("sku"));
        orderImport.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
        orderImport.setAsin(map.get("asin"));
        orderImport.setItemStatus(map.get("item-status"));
        orderImport.setQuantity(MathUtil.strToInteger(map.get("quantity")));
        orderImport.setCurrency(map.get("currency"));
        orderImport.setItemPrice(MathUtil.strToBigDecimal(map.get("item-price")));
        orderImport.setItemTax(MathUtil.strToBigDecimal(map.get("item-tax")));
        orderImport.setShippingPrice(MathUtil.strToBigDecimal(map.get("shipping-price")));
        orderImport.setShippingTax(MathUtil.strToBigDecimal(map.get("shipping-tax")));
        orderImport.setGiftWrapPrice(MathUtil.strToBigDecimal(map.get("gift-wrap-price")));
        orderImport.setGiftWrapTax(MathUtil.strToBigDecimal(map.get("gift-wrap-tax")));
        orderImport.setItemPromotionDiscount(MathUtil.strToBigDecimal(map.get("item-promotion-discount")));
        orderImport.setShipPromotionDiscount(MathUtil.strToBigDecimal(map.get("ship-promotion-discount")));
        orderImport.setShipCity(map.get("ship-city"));
        orderImport.setShipState(map.get("ship-state"));
        orderImport.setShipPostalCode(map.get("ship-postal-code"));
        orderImport.setShipCountry(map.get("ship-country"));
        orderImport.setPromotionIds(map.get("promotion-ids"));
        orderImport.setIsBusinessOrder(map.get("is-business-order"));
        orderImport.setPurchaseOrderNumber(MathUtil.strToInteger(map.get("purchase-order-number")));
        orderImport.setPriceDesignation(map.get("price-designation"));
    }

    private OrderImport getOrderImport(String amazonOrderId, String sku) {
        OrderImportExample orderImportExample = new OrderImportExample();
        orderImportExample.createCriteria().andAmazonOrderIdEqualTo(amazonOrderId).andSkuEqualTo(sku);
        List<OrderImport> list = customOrderImportMapper.selectByExample(orderImportExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
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
}
