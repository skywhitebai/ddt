package com.sky.ddt.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author baixueping
 * @description
 * @date 2021/7/1 14:46
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        super();
        // 设置date类型转换
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 反序列化忽视不存在属性
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(LocalDateTime.class,LocalDateTimeToStringSerializer.instance);
        registerModule(simpleModule);

    }
}