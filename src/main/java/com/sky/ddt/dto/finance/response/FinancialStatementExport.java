package com.sky.ddt.dto.finance.response;

import com.sky.ddt.entity.FinancialStatement;
import com.sky.ddt.util.MathUtil;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sky
 * @Description 导出类
 * @date 2022/5/10 23:06
 */
@Data
public class FinancialStatementExport extends FinancialStatement {
    BigDecimal newProductSellingFees;
    BigDecimal oldProductSellingFees;
    BigDecimal newProductProductSales;
    BigDecimal oldProductProductSales;
    BigDecimal averageInventoryCost;
    BigDecimal monthlySalesValue;
    BigDecimal aroi;
    BigDecimal inventoryTurnoverTimes;
    BigDecimal roiAssessmentCoefficient;
}
