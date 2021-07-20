package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

public class ProductConstant {
    public static final String PRODUCTNAME_EMPTY = "产品名不能为空";
    public static final String PRODUCTCODE_EMPTY = "产品编码不能为空";
    public static final String SKU_EMPTY = "SKU不能为空";
    public static final String COLOUR_EMPTY = "颜色不能为空";
    public static final String SIZE_EMPTY = "尺码不能为空";
    public static final String SKU_EXIST = "SKU已经存在";
    public static final String PRODUCTID_NOT_EXIST = "产品ID不存在";
    public static final String DESCRIPTION_TOO_LONG = "产品描述长度不能超过500";

    public static final String[] EXPORT_PRODUCT_HEAD = {"产品名", "产品编码","中文报关名","英文报关名","开发等级",  "产品描述", "备注"};
    public static final String REMARK_TOO_LONG = "备注长度不能超过500";
    public static final String PRODUCTCODE_EXIST ="产品编码已存在" ;
    public static final String DEVELOPER_USER_ID_NOT_EXIST ="开发人员不存在" ;
    public static final String CHINESE_PRODUCT_NAME_EMPTY = "中文报关名不能为空";
    public static final String ENGLISH_PRODUCT_NAME_EMPTY = "英文报关名不能为空";
    public static final String PRODUCTCODE_NOT_EXIST ="产品编码不存在" ;
    public static final String DEVELOPER_USERNAME_EMPTY ="开发人员用户名不能为空" ;
    public static final String DEVELOPER_USERNAME_NOT_EXIST ="开发人员用户名不存在" ;
    public static final String DEVELOPMENT_LEVEL_EMPTY ="开发等级不能为空";
    public static final String DEVELOPMENT_LEVEL_ERRO ="开发等级必续为0-10的数字";
    public static List<ExcelField> exportProductFieldList=new ArrayList<>();
    static {
        exportProductFieldList.add(new ExcelField("productName", "产品名", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("productCode", "产品编码", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("chineseProductName", "中文报关名", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("englishProductName", "英文报关名", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("developerUserName", "开发人员", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("developmentLevel", "开发等级", ExcelField.FieldTypeEnum.STRING));
        exportProductFieldList.add(new ExcelField("developmentTime", "开发时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportProductFieldList.add(new ExcelField("costPriceMin", "成本价最小值", ExcelField.FieldTypeEnum.NUMBER));
        exportProductFieldList.add(new ExcelField("costPriceMax", "成本价最大值", ExcelField.FieldTypeEnum.NUMBER));
        exportProductFieldList.add(new ExcelField("headTripCostMin", "头程费用最小值", ExcelField.FieldTypeEnum.NUMBER));
        exportProductFieldList.add(new ExcelField("headTripCostMax", "头程费用最大值", ExcelField.FieldTypeEnum.NUMBER));
        exportProductFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportProductFieldList.add(new ExcelField("updateTime", "修改时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportProductFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
    }
}
