package com.sky.ddt.dto.shop.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UpdateOrderLastUpdatedAfterRequest {
    Integer shopId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    Date lastUpdatedAfter;
}
