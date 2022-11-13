package com.sky.ddt.dto.amazonReservedInventory.resp;

import com.sky.ddt.entity.AmazonReservedInventory;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/11/7 21:15
 */
@Data
public class ListAmazonReservedInventoryResp extends AmazonReservedInventory {
    String shopName;
}
