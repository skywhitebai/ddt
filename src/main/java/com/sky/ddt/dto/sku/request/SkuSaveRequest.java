package com.sky.ddt.dto.sku.request;

import com.sky.ddt.common.constant.SkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description sku保存类
 * @date 2019/5/13 10:39
 */
@Data
public class SkuSaveRequest {
    @NotNull(message = "skuId不能为空")
    private Integer skuId;

    @NotBlank(message = SkuConstant.SKU_EMPTY)
    @Length(max = 50, message = "sku长度超过50")
    private String sku;
    @NotBlank(message = SkuConstant.COLOR_EMPTY)
    @Length(max = 50, message = "颜色长度超过50")
    private String colour;
    @Length(max = 50, message = "色号长度超过50")
    private String colourNumber;
    @NotBlank(message = SkuConstant.SIZE_EMPTY)
    @Length(max = 50, message = "尺码长度超过50")
    private String size;

    @NotNull(message = SkuConstant.WEIGHT_EMPTY)
    @DecimalMin(value = "0.01", message = "重量必须为大于0的两位小数数字")
    @Digits(integer = 10,fraction = 2,message = "重量必须为大于0的两位小数数字")
    private BigDecimal weight;

    @Min(value = 0, message = "库存数量必须为大于等于0的数字")
    private Integer inventoryQuantity;
    @NotNull
    @DecimalMin(value = "0.01", message = "成本价必须为大于0的两位小数数字")
    @Digits(integer = 10,fraction = 2,message = "成本价必须为大于0的两位小数数字")
    private BigDecimal costPrice;

    @DecimalMin(value = "0.01", message = "头程费用必须为大于0的两位小数数字")
    @Digits(integer = 10,fraction = 2,message = "头程费用必须为大于0的两位小数数字")
    private BigDecimal headTripCost;
    @Length(max = 50, message = "副sku长度超过50")
    private String secondSku;
    @Length(max = 100, message = "品名长度超过100")
    private String productName;
    @Length(max = 100, message = "品牌长度超过100")
    private String brand;
    @Length(max = 100, message = "面料长度超过100")
    private String material;
    @Length(max = 50, message = "等级长度超过50")
    private String grade;
    @Length(max = 50, message = "执行标准长度超过50")
    private String executiveStandard;
    @Length(max = 50, message = "安全类别长度超过50")
    private String securityCategory;
    @Length(max = 50, message = "检验员长度超过50")
    private String inspector;
    @Length(max = 50, message = "建议零售价长度超过50")
    private String suggestedRetailPrice;
    @Min(value = 0,message = "开发等级必须为0-10的数字")
    @Max(value = 10,message = "开发等级必须为0-10的数字")
    private Integer developmentLevel;
    private String remark;
}
