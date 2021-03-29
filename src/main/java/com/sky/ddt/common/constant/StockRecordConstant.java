package com.sky.ddt.common.constant;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/22 16:14
 */
public class StockRecordConstant {
    public static final String SHOP_ID_EMPTY ="店铺id不能为空" ;
    public static final String USER_NO_SHOP_RIGHT ="用户没有店铺操作权限" ;
    public static final String STOCK_CART_LIST_EMPTY ="没有设置需要补货的数据" ;
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String STOCK_RECORD_ID_EMPTY ="补货单id不能为空" ;
    public static final String STOCK_RECORD_ID_NOT_EXIST = "补货单id不存在" ;
    public static final String []EXPORT_STOCK_RECORD_HEAD ={"店铺sku","产品sku","fnsku","补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_KY = {"店铺sku","产品sku","fnsku","空运补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_KP = {"店铺sku","产品sku","fnsku","空派补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_HY = {"店铺sku","产品sku","fnsku","海运补货数量"};
    public static String[] EXPORT_PRODUCTION_HEAD = {"店铺sku","产品sku","fnsku","生产数量"};
}
