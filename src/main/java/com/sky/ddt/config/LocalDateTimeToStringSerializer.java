package com.sky.ddt.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author baixueping
 * @description
 * @date 2021/6/30 16:49
 */
public class LocalDateTimeToStringSerializer extends StdSerializer<LocalDateTime> {
    public static final LocalDateTimeToStringSerializer instance = new LocalDateTimeToStringSerializer();

    private LocalDateTimeToStringSerializer() {
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (dateTime == null) {
            jsonGenerator.writeNull();
        } else {

            jsonGenerator.writeString(getFormatStr(dateTime));
        }
    }

    private String getFormatStr(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = dateTime.format(formatter);
        return str;
    }
}
