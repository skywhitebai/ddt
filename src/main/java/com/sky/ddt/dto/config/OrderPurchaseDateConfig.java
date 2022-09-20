package com.sky.ddt.dto.config;

import lombok.Data;

/**
 * @author sky
 * @Description 订单时间转换
 * @date 2022/9/15 20:48
 */
@Data
public class OrderPurchaseDateConfig {
    Integer countryId;
    String countryName;
    Integer dateAddSecond;
    Boolean enable;
    String remark;
}
