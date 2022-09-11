package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author sky
 * @Description TODO
 * @date 2021/8/17 23:57
 */
public class WorkTaskCreationConstant {
    @Getter
    public enum StatusEnum {
        CANCEL(0, "取消"),
        ENABLE(1, "进行中");
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (WorkTaskCreationConstant.StatusEnum statusEnum : WorkTaskCreationConstant.StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (WorkTaskCreationConstant.StatusEnum statusEnum : WorkTaskCreationConstant.StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }

    @Getter
    public enum TypeEnum {
        DAY(1, "每天"),
        WEEK(2, "每周"),
        MONTH(3, "每月"),;
        Integer level;
        String levelName;

        TypeEnum(Integer status, String statusName) {
            this.level = status;
            this.levelName = statusName;
        }

        public static boolean contains(Integer level) {
            for (TypeEnum statusEnum : TypeEnum.values()) {
                if (statusEnum.level.equals(level)) {
                    return true;
                }
            }
            return false;
        }

        public static String getLevelName(Integer level) {
            for (TypeEnum statusEnum : TypeEnum.values()) {
                if (statusEnum.level.equals(level)) {
                    return statusEnum.levelName;
                }
            }
            return null;
        }
    }
    @Getter
    public enum NeedAuditEnum {
        NO_NEED(0, "不需要"),
        NEED(1, "需要");
        Integer status;
        String statusName;

        NeedAuditEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (WorkTaskCreationConstant.NeedAuditEnum statusEnum : WorkTaskCreationConstant.NeedAuditEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (WorkTaskCreationConstant.NeedAuditEnum statusEnum : WorkTaskCreationConstant.NeedAuditEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
}
