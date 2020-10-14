package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 亚马逊装箱单信息
 * @date 2019/9/11 16:52
 */
@Data
public class AmazonPackingListInfo {
    String merchantSku;
    String title;
    String asin;
    String fnsku;
    String externalId;
    String condition;
    String whoWillPrep;
    String prepType;
    String whoWillLabel;
    String shipped;


}
