package com.sky.ddt.dto.amazon.amazonAuth.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 修改店铺授权信息
 * @date 2021/6/24 15:51
 */
@Data
public class UpdateAmazonAuthRequest {
    @NotNull(message = "id不能为空")
    Long id;
    @NotNull(message = "店铺id不能为空")
    Integer shopId;
    @Length(max = 50,message = "国家名称长度不能超过50")
    String countryName;
    @Length(max = 100,message = "备注长度不能超过100")
    String remark;
    @NotNull(message = "状态不能为空")
    Integer status;

}
