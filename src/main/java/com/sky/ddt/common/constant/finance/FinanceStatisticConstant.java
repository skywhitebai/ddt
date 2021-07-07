package com.sky.ddt.common.constant.finance;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description
 * @date 2021/7/6 16:30
 */
public class FinanceStatisticConstant {
    public static List<ExcelField> exportFinanceStatisticFieldList=new ArrayList<>();
    static {
        exportFinanceStatisticFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportFinanceStatisticFieldList.add(new ExcelField("monthStr", "年月", ExcelField.FieldTypeEnum.STRING));
        exportFinanceStatisticFieldList.add(new ExcelField("initialInventoryCost", "期初价值", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("finalInventoryCost", "期末价值", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("sendCost", "当月发送价值", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("saleCost", "当月销售价值", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("mainBusinessIncome", "当月回款", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("manualAdjustment", "账外调整", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("netIncome", "当月净入", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("mainBusinessProfit", "毛利润", ExcelField.FieldTypeEnum.NUMBER));
        exportFinanceStatisticFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportFinanceStatisticFieldList.add(new ExcelField("updateTime", "修改时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }
}
