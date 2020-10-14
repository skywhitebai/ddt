package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import com.sky.ddt.entity.LabelPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 标签打印
 * @date 2020/2/28 11:35
 */
public class LabelPrintConstant {
    public static final String SHOP_SKU_EMPTY = "店铺sku不能为空";
    public static final String SHOP_SKU_NOT_EXIST = "店铺sku不存在";
    public static final String QUANTITY_EMPTY = "数量不能为空";
    public static final String QUANTITY_ERRO = "数量必须为大于0的数字";
    public static List<ExcelField> exprotLabelPrintFieldList = new ArrayList<>();

    static {
        exprotLabelPrintFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exprotLabelPrintFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exprotLabelPrintFieldList.add(new ExcelField("fnsku", "fnsku", ExcelField.FieldTypeEnum.STRING));
        exprotLabelPrintFieldList.add(new ExcelField("quantity", "数量", ExcelField.FieldTypeEnum.NUMBER));
        exprotLabelPrintFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
    }
}
