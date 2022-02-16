package com.sky.ddt.dto.financialDocument.request;

import com.sky.ddt.entity.FinancialDocument;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sky
 * @Description 保存票据
 * @date 2022/2/16 23:07
 */
@Data
public class SaveFinancialDocumentRequest {
    private Integer id;
    @NotNull(message = "日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date financialDate;
    @NotEmpty(message = "名目不能为")
    @Length(max =100,message = "名目长度不能超过100")
    private String title;
    @Length(max =500,message = "明细长度不能超过500")
    private String detailed;

    @NotEmpty(message = "收款方不能为空")
    @Length(max =50,message = "收款方长度不能超过50")
    private String payee;

    @NotEmpty(message = "付款方不能为空")
    @Length(max =50,message = "付款方长度不能超过50")
    private String payer;

    @NotNull(message = "花费用不能为空")
    @DecimalMin(value = "0.01",message = "费用必须大于0")
    private BigDecimal cost;

    @Length(max =100,message = "备注长度不能超过100")
    private String remark;
}
