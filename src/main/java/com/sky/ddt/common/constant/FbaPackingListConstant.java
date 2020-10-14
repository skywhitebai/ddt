package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 装箱单静态类
 * @date 2020/7/22 15:10
 */
public class FbaPackingListConstant {
    public static final String SHIPMENT_ID_EXIST ="Shipment ID已存在" ;
    public static final String FBA_PACKING_LIST_NO_ENABLE_SHOP_SKU ="装箱单没有有效数量的商品" ;
    public static final String SHOP_SKU_REPEAT ="Merchant SKU[%s]存在重复的" ;
    public static final String ID_EMPTY ="id不能为空" ;
    public static final String ID_NOT_EXIST ="id不存在" ;
    public static final String SHOP_SKU_EMPTY ="fba装箱单没有店铺sku" ;
    public static final String ORDER_NUMBER_EMPTY ="orderNumber不能为空" ;
    public static final String FBA_PACKING_LIST_ID_EMPTY ="fbaPackingListId不能为空" ;
    public static final String FBA_PACKING_LIST_ID_NOT_EXIST = "fbaPackingListId不存在" ;

    @Getter
    public enum ProduceOrderStatusEnum {
        TO_BE_GENERATED(0,"待生成"),
        GENERATED(1,"已生成");
        Integer produceOrderStatus;
        String produceOrderStatusName;

        ProduceOrderStatusEnum(Integer produceOrderStatus, String produceOrderStatusName) {
            this.produceOrderStatus = produceOrderStatus;
            this.produceOrderStatusName = produceOrderStatusName;
        }
        public boolean contains(Integer produceOrderStatus){
            if(produceOrderStatus==null){
                return false;
            }
            for (ProduceOrderStatusEnum produceOrderStatusEnum :
                    ProduceOrderStatusEnum.values() ) {
                if(produceOrderStatusEnum.getProduceOrderStatus().equals(produceOrderStatus)){
                    return true;
                }
            }
            return false;
        }
    }
}
