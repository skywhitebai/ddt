package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author sky
 * @Description TODO
 * @date 2021/8/17 23:57
 */
public class WorkTaskConstant {
    @Getter
    public enum StatusEnum {
        WAIT_DEAL(0, "待处理"),
        HAVE_IN_HAND(1, "进行中"),
        COMPLETED(2, "已完成"),
        CANCEL(3, "取消"),;
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (WorkTaskConstant.StatusEnum statusEnum : WorkTaskConstant.StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (WorkTaskConstant.StatusEnum statusEnum : WorkTaskConstant.StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
    @Getter
    public enum DealStatusEnum {
        UN_DEAL(0, "未处理"),
        HANDLER(1, "处理及时"),
        TIMEOUT_HANDLER(2, "处理超时"),;
        Integer dealStatus;
        String statusName;

        DealStatusEnum(Integer dealStatus, String statusName) {
            this.dealStatus = dealStatus;
            this.statusName = statusName;
        }

        public static boolean contains(Integer dealStatus) {
            for (WorkTaskConstant.DealStatusEnum statusEnum : WorkTaskConstant.DealStatusEnum.values()) {
                if (statusEnum.dealStatus.equals(dealStatus)) {
                    return true;
                }
            }
            return false;
        }

        public static String getDealStatusName(Integer dealStatus) {
            for (WorkTaskConstant.DealStatusEnum statusEnum : WorkTaskConstant.DealStatusEnum.values()) {
                if (statusEnum.dealStatus.equals(dealStatus)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
    @Getter
    public enum LevelEnum {
        HURRY(1, "紧急"),
        GENERAL(2, "普通"),
        NO_HURRY(3, "不急"),;
        Integer level;
        String levelName;

        LevelEnum(Integer status, String statusName) {
            this.level = status;
            this.levelName = statusName;
        }

        public static boolean contains(Integer level) {
            for (WorkTaskConstant.LevelEnum statusEnum : WorkTaskConstant.LevelEnum.values()) {
                if (statusEnum.level.equals(level)) {
                    return true;
                }
            }
            return false;
        }

        public static String getLevelName(Integer level) {
            for (WorkTaskConstant.LevelEnum statusEnum : WorkTaskConstant.LevelEnum.values()) {
                if (statusEnum.level.equals(level)) {
                    return statusEnum.levelName;
                }
            }
            return null;
        }
    }
}
