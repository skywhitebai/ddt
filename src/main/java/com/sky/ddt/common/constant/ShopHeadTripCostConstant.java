package com.sky.ddt.common.constant;


import com.sky.ddt.common.excel.ExcelField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺头程费静态类
 * @date 2020/8/14 14:13
 */
public class ShopHeadTripCostConstant {
    public static final String SHOP_ID_EMPTY = "店铺id不能为空";
    public static final String MONTH_EMPTY = "月份不能为空";
    public static final String MONTH_ERRO = "月份必须为YYYY-MM格式";
    public static final String SHOP_HEAD_TRIP_COST_EXIST = "该店铺这个月的头程费已更新，不允许重复更新";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String MONTH_MUST_BEFORE_MONTH_NOW = "月份必须早于本月";
    public static final String EXIST_WITHOUT_HEAD_TRIP_COST_SHOP_SKU = "存在没有头程费的店铺sku";
    public static final String TYPE_EMPTY ="类型不能为空" ;
    public static final String LAST_MONTH_INVENTORY_DETAILS_NOT_EXIST ="[%s]的库存明细不存在" ;
    public static final String EXIST_HEAD_TRIP_COST_RATE_NULL ="存在创建时间是生成月份且头程费为空的内部单号发货记录" ;
    public static final String LAST_MONTH_SHOP_SKU_INVENTORY_DETAILS_NOT_EXIST ="店铺sku[%s]的库存明细不存在" ;
    public static final String SHOP_SKU_WITHOUT_HEAD_TRIP_COST ="店铺sku头程费为空" ;
    public static final String SHOP_SKU_HEAD_TRIP_COST_RATE_NULL ="店铺sku存在头程费率为空的发货记录" ;
    public static final String SHOP_SKU_WEIGHT_NULL ="店铺sku重量为空" ;
    public static final String EXIST_WITHOUT_WEIGHT_SHOP_SKU ="存在没有重量的店铺sku";
    public static List<ExcelField> exportShopSkuHeadTripCostHisFieldList=new ArrayList<>();
    static {
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("headTripCostBefore", "旧头程费", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("headTripCostAfter", "新头程费", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("inventoryQuantity", "上个月库存", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("fbaSendQuantity", "fba发货数", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("fbaHeadTripCost", "fba发货头程费", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("totalHeadTripCost", "总头程费", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("createRemark", "创建时备注", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuHeadTripCostHisFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }
    @Getter
    public enum CreateTypeEnum {
        CHECK(1, "校验需要的数据"),
        UN_CHECK(2, "不校验需要的数据"),;
        Integer type;
        String typeName;

        CreateTypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }
    }
}
