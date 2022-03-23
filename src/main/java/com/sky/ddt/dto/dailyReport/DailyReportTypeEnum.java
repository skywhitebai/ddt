package com.sky.ddt.dto.dailyReport;

/**
 * @author sky
 * @Description
 * @date 2022/3/23 23:01
 */
public enum DailyReportTypeEnum {
    NORMAL((byte)1, "正常"),
    SUPPLEMENT((byte)2, "补写"),;
    Byte type;
    String typeName;

    DailyReportTypeEnum(Byte type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public Byte getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }
}
