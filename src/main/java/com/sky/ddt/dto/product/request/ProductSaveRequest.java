package com.sky.ddt.dto.product.request;

import com.sky.ddt.common.constant.ProductConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductSaveRequest {
    private Integer productId;
    @NotBlank(message = ProductConstant.PRODUCTNAME_EMPTY)
    private String productName;

    @NotBlank(message = ProductConstant.PRODUCTCODE_EMPTY)
    private String productCode;
    @Length(max = 500, message = ProductConstant.DESCRIPTION_TOO_LONG)
    private String description;

    private Integer developerUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date developmentTime;

    @Length(max = 500, message = ProductConstant.REMARK_TOO_LONG)
    private String remark;
    @NotBlank(message = ProductConstant.CHINESE_PRODUCT_NAME_EMPTY)
    String chineseProductName;
    @NotBlank(message = ProductConstant.ENGLISH_PRODUCT_NAME_EMPTY)
    String englishProductName;
    @Length(max = 32,message = ProductConstant.HS_CODE_TOO_LONG)
    String hsCode;
    @Min(value = 0,message = "开发等级必须为0-10的数字")
    @Max(value = 10,message = "开发等级必须为0-10的数字")
    private Integer developmentLevel;
    @Min(value = 0,message = "工价必须为0-10000的数字")
    @Max(value = 10000,message = "工价必须为0-10000的数字")
    @Digits(integer = 6, fraction = 2,message ="工价必须为0-10000的两位数字" )
    private BigDecimal labourCost;
}
