package com.sky.ddt.common.constant;

/**
 * @author baixueping
 * @description 订单导入
 * @date 2019/8/14 10:06
 */
public class OrderImportConstant {
    public static final String SHOP_NAME_EMPTY = "店铺名不能为空";
    public static final String SHOP_NAME_NOT_EXIST_OR_NOT_USER_SHOP ="店铺名不存在，或者不是用户店铺";
    public static final String AMAZON_ORDER_ID_EMPTY ="amazon-order-id不能为空" ;
    public static final String PURCHASE_DATE_EMPTY ="purchase-date不能为空" ;
    public static final String PURCHASE_DATE_ERRO = "purchase-date时间格式错误" ;
    public static final String LAST_UPDATED_DATE_ERRO ="last-updated-date时间格式错误" ;
    public static final String ORDER_STATUS_EMPTY ="order-status不能为空" ;
    public static final String SKU_EMPTY ="sku不能为空" ;
    public static final String SKU_NOT_EXIST ="店铺sku不存在" ;
    public static final String SKU_NOT_THIS_SHOP ="店铺sku不是这个店铺的" ;
    public static final String ASIN_EMPTY ="asin不能为空" ;
    public static final String ITEM_STATUS_EMPTY ="item-status不能为空" ;
    public static final String QUANTITY_EMPTY ="quantity不能为空" ;
    public static final String QUANTITY_ERRO ="quantity必须为大于等于0的整数" ;
    public static final String ITEM_PRICE_EMPTY ="item-price不能为空" ;
    public static final String ITEM_PRICE_ERRO ="item-price必须为大于等于0的数字" ;
    public static final String ITEM_TAX_ERRO ="item-tax必须为大于0的数字" ;
    public static final String SHIPPING_PRICE_ERRO ="shipping-price必须为大于0的数字" ;
    public static final String SHIPPING_TAX_ERRO ="shipping-tax必须为大于0的数字" ;
    public static final String GIFT_WRAP_PRICE_ERRO ="gift-wrap-price必须为大于0的数字" ;
    public static final String GIFT_WRAP_TAX_ERRO ="gift-wrap-tax必须为大于0的数字" ;
    public static final String ITEM_PROMOTION_DISCOUNT_ERRO ="item-promotion-discount必须为大于0的数字" ;
    public static final String SHIP_PROMOTION_DISCOUNT_ERRO ="ship-promotion-discount必须为大于0的数字" ;
    public static final String IS_BUSINESS_ORDER_ERRO ="is-business-order必须为true或false";
    public static final String SKU_NOT_USER_SHOP ="sku不是用户管理的店铺的" ;
    public static final String[] GET_SHOP_SKU_HEAD = {"亚马逊订单号","sku"};
}
