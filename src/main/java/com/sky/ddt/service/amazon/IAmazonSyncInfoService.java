package com.sky.ddt.service.amazon;

import com.sky.ddt.common.enums.AmazonSyncInfoTypeEnum;
import com.sky.ddt.entity.AmazonSyncInfo;

/**
 * @author baixueping
 * @description 亚马逊同步信息
 * @date 2021/6/25 10:24
 */
public interface IAmazonSyncInfoService {
    AmazonSyncInfo getAmazonSyncInfo(AmazonSyncInfoTypeEnum fbaInventory, String merchantId);
}
