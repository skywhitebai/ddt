package com.sky.ddt.common.excel;

import lombok.Data;
import lombok.Getter;

/**
 * @author baixueping
 * @description excel字段
 * @date 2020/4/20 14:57
 */
@Data
public class ExcelField {
    String fieldName;
    String title;
    FieldTypeEnum fieldType;

    public ExcelField(String fieldName, String title) {
        this.fieldName = fieldName;
        this.title = title;
    }

    public ExcelField(String fieldName, String title, FieldTypeEnum fieldType) {
        this.fieldName = fieldName;
        this.title = title;
        this.fieldType = fieldType;
    }

    @Getter
    public enum FieldTypeEnum {
        STRING("文本"),
        NUMBER("数字"),
        IMG_URL("图片链接"),
        DATE_TIME("时间"),
        NUMBER_RATE("比例"),
        NUMBER_RATE_NEED_MULTIPLY_100("比例需要乘以100显示百分数"),;
        String fieldTypeName;

        FieldTypeEnum(java.lang.String fieldTypeName) {
            this.fieldTypeName = fieldTypeName;
        }
    }
}
