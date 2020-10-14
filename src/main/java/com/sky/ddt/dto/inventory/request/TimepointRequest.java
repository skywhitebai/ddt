package com.sky.ddt.dto.inventory.request;

import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description todo
 * @date 2019/4/22 20:00
 */
@Data
public class TimepointRequest {
    String timepointType;
    Date dateTime;
}
