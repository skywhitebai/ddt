package com.sky.ddt.dto.amazon.amazonAuth.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author baixueping
 * @description 保存亚马逊token
 * @date 2021/6/24 11:16
 */
@Data
public class SaveAmazonAuthRequest {
    @NotEmpty(message = "sellingPartnerId不能为空")
    String sellingPartnerId;
    @NotEmpty(message = "spapiOauthCode不能为空")
    String spapiOauthCode;
}
