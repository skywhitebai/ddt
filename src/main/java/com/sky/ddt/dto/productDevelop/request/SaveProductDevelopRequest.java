package com.sky.ddt.dto.productDevelop.request;

import com.sky.ddt.common.constant.ProductConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description 保存产品开发信息
 * @date 2021/9/1 22:38
 */
@Data
public class SaveProductDevelopRequest {
    private Integer id;
    @NotBlank(message = "产品名称不能为空")
    private String productName;

    private String productCode;
    @Length(max = 500, message = ProductConstant.DESCRIPTION_TOO_LONG)
    private String description;

    @Length(max = 500, message = ProductConstant.REMARK_TOO_LONG)
    private String remark;
    String chineseProductName;
    String englishProductName;
    private Integer status;
    @Min(value = 1, message = "开发等级必须为1-10")
    @Max(value = 10, message = "开发等级必须为1-10")
    private Integer developmentLevel;
    @Length(max = 200, message = "开发文档链接长度不能超过200")
    private String developmentDocUrl;
    @Length(max = 200, message = "确认文档链接长度不能超过200")
    private String confirmDocUrl;
    @Length(max = 100, message = "原材料长度不能超过100")
    private String rawMaterial;
    @Length(max = 100, message = "生产供应商长度不能超过100")
    private String productionSupplier;
    @Length(max = 200, message = "图片链接长度不能超过200")
    private String imgUrl;

}
