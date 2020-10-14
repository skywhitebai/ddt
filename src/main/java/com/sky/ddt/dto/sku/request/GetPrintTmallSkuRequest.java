package com.sky.ddt.dto.sku.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 获取天猫打印sku
 * @date 2020/4/30 17:06
 */
@Data
public class GetPrintTmallSkuRequest {
    String sku;
    String secondSku;
}
