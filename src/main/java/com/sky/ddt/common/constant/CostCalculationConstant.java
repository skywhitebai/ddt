package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/18 0:12
 */
public class CostCalculationConstant {
    public static List<ExcelField> exportCostCalculationSkuFieldList=new ArrayList<>();
    static {
        exportCostCalculationSkuFieldList.add(new ExcelField("month", "月份", ExcelField.FieldTypeEnum.DATE_TIME));
        exportCostCalculationSkuFieldList.add(new ExcelField("sku", "sku", ExcelField.FieldTypeEnum.STRING));
        exportCostCalculationSkuFieldList.add(new ExcelField("labourCost", "工价", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("costPriceBefore", "修改前成本", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("inventoryQuantity", "库存", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("productionQuantity", "生产数量", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("productionCostTotal", "生产总成本", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("productionCostPrice", "生产单价", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("costPriceAfter", "修改后成本", ExcelField.FieldTypeEnum.NUMBER));
        exportCostCalculationSkuFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }
}
