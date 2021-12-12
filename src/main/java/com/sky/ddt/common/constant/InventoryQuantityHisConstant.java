package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @Description 库存历史
 * @date 2021/12/10 19:39
 */
public class InventoryQuantityHisConstant {
    public static List<ExcelField> exportInventoryQuantityHisFieldList =new ArrayList<>();
    static {
        exportInventoryQuantityHisFieldList.add(new ExcelField("productCode", "产品编码", ExcelField.FieldTypeEnum.STRING));
        exportInventoryQuantityHisFieldList.add(new ExcelField("productName", "产品名称", ExcelField.FieldTypeEnum.STRING));
        exportInventoryQuantityHisFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportInventoryQuantityHisFieldList.add(new ExcelField("inventoryQuantity", "数量", ExcelField.FieldTypeEnum.NUMBER));
        exportInventoryQuantityHisFieldList.add(new ExcelField("month", "年月", ExcelField.FieldTypeEnum.DATE_TIME));
        exportInventoryQuantityHisFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportInventoryQuantityHisFieldList.add(new ExcelField("updateTime", "修改时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportInventoryQuantityHisFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
    }
}
