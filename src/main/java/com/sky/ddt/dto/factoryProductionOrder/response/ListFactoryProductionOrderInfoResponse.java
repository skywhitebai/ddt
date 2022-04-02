package com.sky.ddt.dto.factoryProductionOrder.response;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author baixueping
 * @description 查詢店鋪sku生產數量
 * @date 2020/10/15 18:53
 */
@Data
public class ListFactoryProductionOrderInfoResponse {
    String shopParentSku;
    String colour;
    String colourNumber;
    Integer productionQuantityF;
    Integer productionQuantityXS;
    Integer productionQuantityS;
    Integer productionQuantityM;
    Integer productionQuantityL;
    Integer productionQuantityXL;
    Integer productionQuantity2XL;
    Integer productionQuantity3XL;
    Integer productionQuantity4XL;
    Integer productionQuantity5XL;
    Integer productionQuantity6XL;
    Integer productionQuantityUS2;
    Integer productionQuantityUS4;
    Integer productionQuantityUS6;
    Integer productionQuantityUS8;
    Integer productionQuantityUS10;
    Integer productionQuantityUS12;
    Integer productionQuantityUS14;
    Integer productionQuantityUS16;
    Integer productionQuantityUS18;
    Integer productionQuantityUS20;
    Integer productionQuantityUS22;
    Integer productionQuantityUS24;
    Integer productionQuantityUS26;
    Integer productionQuantityUS28;
    Integer productionQuantityUS30;
    Integer productionQuantityUS32;
    Integer productionQuantityUS34;
    Integer productionQuantityUS36;

    String remark;

    public String getColourInfo() {
        String colourInfo=colour;
        if(!StringUtils.isEmpty(colourNumber)){
            if(!StringUtils.isEmpty(colourInfo)){
                colourInfo=colour+"/"+colourNumber;
            }else{
                colourInfo=colourNumber;
            }
        }
        return colourInfo;
    }
}
