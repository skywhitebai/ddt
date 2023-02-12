package com.sky.ddt.common.constant;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/22 16:14
 */
public class StockRecordConstant {
    public static final String SHOP_ID_EMPTY = "店铺id不能为空";
    public static final String USER_NO_SHOP_RIGHT = "用户没有店铺操作权限";
    public static final String STOCK_CART_LIST_EMPTY = "没有设置需要补货的数据";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String STOCK_RECORD_ID_EMPTY = "补货单id不能为空";
    public static final String STOCK_RECORD_ID_NOT_EXIST = "补货单id不存在";
    public static final String[] EXPORT_STOCK_RECORD_HEAD = {"店铺名称", "补货单id", "库位", "店铺sku", "产品sku", "fnsku", "补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_KY = {"店铺名称", "补货单id", "库位", "店铺sku", "产品sku", "fnsku", "空运补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_KP = {"店铺名称", "补货单id", "库位", "店铺sku", "产品sku", "fnsku", "空派补货数量"};
    public static final String[] EXPORT_STOCK_RECORD_HEAD_HY = {"店铺名称", "补货单id", "库位", "店铺sku", "产品sku", "fnsku", "海运补货数量"};
    public static final String[] EXPORT_PRODUCTION_HEAD = {"店铺名称", "补货单id", "库位", "店铺sku", "产品sku", "fnsku", "生产数量"};
    public static final String STOCK_QUANTITY_KY_ERROR = "空运补货必须为大于等于0的数字";
    public static final String STOCK_QUANTITY_KP_ERROR = "空派补货必须为大于等于0的数字";
    public static final String STOCK_QUANTITY_HY_ERROR = "海运补货必须为大于等于0的数字";
    public static final String PRODUCTION_QUANTITY_ERROR = "实际生产数量必须为大于等于0的数字";
}
