package com.sky.ddt.dto.test;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 时间测试入参
 * @date 2019/4/30 14:22
 */
@Data
public class DateTestRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date time1;
    Date time2;
    Date time3;
}
