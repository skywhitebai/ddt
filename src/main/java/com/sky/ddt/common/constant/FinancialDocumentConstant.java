package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author sky
 * @Description TODO
 * @date 2022/2/16 23:19
 */
public class FinancialDocumentConstant {
    @Getter
    public enum StatusEnum {
        WAIIT_AUDIT(1, "待审核"),
        PASS(2, "审核通过"),
        UN_PASS(3, "审核不通过"),;
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
}
