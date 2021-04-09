package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import com.sky.ddt.dto.shopSku.response.ExportShopSkuResponse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku
 * @date 2019/7/29 11:39
 */
public class ShopSkuConstant {
    public static final String SHOP_NAME_EMPTY = "店铺名不能为空";
    public static final String SKU_EMPTY = "产品sku不能为空";
    public static final String SHOP_SKU_EMPTY = "店铺sku不能为空";
    public static final String SKU_NOT_EXIST = "产品sku：%s不存在";
    public static final String SHOP_NAME_NOT_EXIST_OR_NOT_USER_SHOP = "店铺名不存在，或者不是用户店铺";
    public static final String SHOP_SKU_ID_EMPTY = "店铺skuId不能为空";
    public static final String FNSKU_EMPTY = "FNSKU不能为空";
    public static final String SHOP_SKU_ID_NOT_EXIST = "店铺sku不存在";
    public static final String SHOP_SKU_EXIST = "店铺sku已存在，不允许重复添加";
    public static final String SALESMAN_USER_ID_NOT_EXIST = "销售人员id不存在";
    public static final String SHOP_SKU_UPDATE_NO_RIGHT = "店铺sku：%s已存在其它店铺，不允许导入";
    public static final String TITLE_EMPTY = "标题不能为空";
    public static final String SHOP_SKU_FNSKU_EMPTY = "请填写店铺sku或者FNSKU";
    public static final String SHOP_SKU_FNSKU_NOT_EXIST = "sku信息不存在，请重新查询";
    public static final String SHOP_SKU_FNSKU_NOT_ONE = "sku信息存在重复信息，请联系管理员";
    public static final String SHOP_SKU_NOT_EXIST = "店铺sku不存在";
    public static final String SKU_NOT_USER_SHOP = "sku不是用户管理的店铺的";
    public static final String SHOP_PARENT_SKU_EMPTY = "店铺父sku不能为空";
    public static final String PURCHASE_DATE_START_EMPTY = "创建订单开始时间不能为空";
    public static final String PURCHASE_DATE_END_EMPTY = "创建订单结束时间不能为空";
    public static final String ASIN_EMPTY = "ASIN不能为空";
    public static final String STATUS_EMPTY = "状态不能为空";
    public static final String STATUS_ERRO = "状态必须为启用或者停用";
    public static final String ASIN_EXIST = "ASIN已存在，不允许重复添加";
    public static final String FNSKU_EXIST = "FNSKU已存在，不允许重复添加";
    public static final String SALESMAN_USERNAME_EMPTY = "销售人员用户名不能为空";
    public static final String SALESMAN_USERNAME_NOT_EXIST = "销售人员用户名不存在";
    public static final String FNSKU_ERRO ="FNSKU必须以X开头" ;
    public static final String STORAGE_LOCATION_TOO_LONG ="库位长度不能超过200" ;
    public static List<ExcelField> exportShopSkuFieldList=new ArrayList<>();
    static {
        exportShopSkuFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("shopParentSku", "店铺父sku", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("fnsku", "FNSKU", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("asin", "ASIN", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("parentAsin", "店铺父ASIN", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("title", "标题", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("status", "状态", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("inventoryQuantity", "库存", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuFieldList.add(new ExcelField("storageLocation", "库位", ExcelField.FieldTypeEnum.STRING));
        exportShopSkuFieldList.add(new ExcelField("weight", "重量", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuFieldList.add(new ExcelField("costPrice", "成本价", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuFieldList.add(new ExcelField("headTripCost", "头程费", ExcelField.FieldTypeEnum.NUMBER));
        exportShopSkuFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
    }
    @Getter
    public enum ShopSkuStatusEnum {
        AVAILABLE(1, "启用"),
        UNAVAILABLE(0, "停用");

        private Integer status;
        private String statusName;

        ShopSkuStatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static ShopSkuStatusEnum getShopSkuStatusEnumByStatus(Integer status) {
            for (ShopSkuStatusEnum shopSkuStatusEnum : ShopSkuStatusEnum.values()) {
                if (shopSkuStatusEnum.getStatus().equals(status)) {
                    return shopSkuStatusEnum;
                }
            }
            return null;
        }

        public static ShopSkuStatusEnum getShopSkuStatusEnumByStatusName(String statusName) {
            for (ShopSkuStatusEnum shopSkuStatusEnum : ShopSkuStatusEnum.values()) {
                if (shopSkuStatusEnum.getStatusName().equals(statusName)) {
                    return shopSkuStatusEnum;
                }
            }
            return null;
        }
    }

}
