package com.sky.ddt.dto.product.request;

import com.sky.ddt.common.constant.ProductConstant;
import com.sky.ddt.common.constant.ShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 0,message = "开发等级必须为0-10的数字")
    @Max(value = 10,message = "开发等级必须为0-10的数字")
    private Integer developmentLevel;
}
