package com.sky.ddt.dto.dailyReport.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description
 * @date 2022/3/23 23:08
 */
@Data
public class UserListDailyReportReq extends DataGridRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportDayStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportDayEnd;
    private Integer userId;
}
