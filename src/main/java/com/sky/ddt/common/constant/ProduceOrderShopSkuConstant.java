package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku静态类
 * @date 2020/4/2 15:30
 */
public class ProduceOrderShopSkuConstant {

    public static final String PRODUCE_ORDER_ID_EMPTY = "生产单id不能为空";
    public static final String SHOP_SKU_EMPTY = "店铺sku不能为空";
    public static final String PRODUCTION_QUANTITY_EMPTY = "生产数量不能为空";
    public static final String PRODUCTION_QUANTITY_ERRO = "生产数量必须为大于0的整数";
    public static final int REMARK_LENGTH = 200;
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String ID_NOT_EXIST = "生产单店铺skuid不存在";
    public static final String PRODUCE_ORDER_ID_NOT_EXIST = "生产单id不存在";
    public static final String PRODUCE_ORDER_ID_NOT_ALLOW_CHANGE = "生产单id不允许修改";
    public static final String SHOP_SKU_NOT_EXIST = "店铺sku不存在";
    public static final String SHOP_SKU_SHOP_ERRO = "店铺sku必须是生产单店铺的";
    public static final String PRODUCE_ORDER_SHOP_SKU_EXIST = "生产单已经存在此店铺sku";
    public static final String PRODUCE_ORDER_NOT_ALLOW_WAREHOUSING = "只有待入库的生产单允许修改";
    public static final String ID_EMPTY = "生产单店铺skuid不存在";
    public static final String PRODUCE_ORDER_SHOP_SKU_NOT_ALLOW_DELETE = "只有待入库的生产单允许删除店铺sku";
    public static final String PRODUCE_ORDER_SHOP_SKU_STATUS_NOT_ALLOW_DELETE = "只有待入库的生产单允许删除店铺sku";
    public static final String PRODUCE_ORDER_SHOP_SKU_WAREHOUSING_NOT_ALLOW_DELETE = "店铺sku已有对应的入库单不允许删除";
    public static final String SHOP_SKU_SHOP_ID_NOT_SAME = "店铺sku的店铺不一致";
    public static final String SHOP_SKU_REPEAT = "店铺sku不允许重复";
    public static final String PRE_WAREHOUSING_QUANTITY_EMPTY ="预入库数量不能为空" ;
    public static final String PRE_WAREHOUSING_QUANTITY_ERRO ="预入库数量错误" ;
    public static List<ExcelField> exportProduceOrderShopSkuFieldList = new ArrayList<>();

    static {
        exportProduceOrderShopSkuFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportProduceOrderShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportProduceOrderShopSkuFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportProduceOrderShopSkuFieldList.add(new ExcelField("productionQuantity", "生产数量", ExcelField.FieldTypeEnum.NUMBER));
        exportProduceOrderShopSkuFieldList.add(new ExcelField("preWarehousingQuantity", "预入库数量", ExcelField.FieldTypeEnum.NUMBER));
    }
}
