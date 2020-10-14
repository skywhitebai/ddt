package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 库存记录变更静态类
 * @date 2020/5/7 16:48
 */
public class InventoryChangeRecordConstant {
    @Getter
    public enum ChangeTypeEnum {
        WAREHOUSING(1,"入库"),
        CHECK(2,"盘点"),
        OUT_BOUND(3,"出库"),
        TRANSFER_FROM(4,"调拨调出"),
        TRANSFER_TO(5,"调拨调入"),;
        Integer changeType;
        String changeTypeName;

        ChangeTypeEnum(Integer changeType, String changeTypeName) {
            this.changeType = changeType;
            this.changeTypeName = changeTypeName;
        }
        public static String getChangeTypeName(Integer status) {
            for (ChangeTypeEnum changeTypeEnum : ChangeTypeEnum.values()) {
                if (changeTypeEnum.getChangeType().equals(status)) {
                    return changeTypeEnum.changeTypeName;
                }
            }
            return null;
        }
    }
}
