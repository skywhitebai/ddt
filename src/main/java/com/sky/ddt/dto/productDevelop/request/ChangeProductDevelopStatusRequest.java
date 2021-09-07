package com.sky.ddt.dto.productDevelop.request;

import com.sky.ddt.common.constant.ProductConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 保存产品开发信息
 * @date 2021/9/1 22:38
 */
@Data
public class ChangeProductDevelopStatusRequest {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotNull(message = "状态不能为空")
    private Integer status;
}
