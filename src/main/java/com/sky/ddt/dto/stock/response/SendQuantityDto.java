package com.sky.ddt.dto.stock.response;

import lombok.Data;

/**
 * @author sky
 * @Description 发送数量
 * @date 2022/10/16 0:41
 */
@Data
public class SendQuantityDto {
    String shopSkuId;
    Integer sendQuantity;
}
