package com.sky.ddt.dto.finance.response;

import com.sky.ddt.entity.FinancialStatement;
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
    BigDecimal newProductMainBusinessProfit;
    BigDecimal oldProductMainBusinessProfit;
    BigDecimal averageInventoryCost;
    BigDecimal aroi;
    BigDecimal inventoryTurnoverTimes;
    BigDecimal roiAssessmentCoefficient;
}
