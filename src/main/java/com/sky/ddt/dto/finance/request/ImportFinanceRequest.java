package com.sky.ddt.dto.finance.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author baixueping
 * @description 导入财务信息
 * @date 2019/11/22 10:21
 */
@Data
public class ImportFinanceRequest {
    MultipartFile file;
    String type;
    String month;
    Date monthDate;
}
