package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.util.DateUtil;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author sky
 * @Description 生成理论金额
 * @date 2021/9/24 22:49
 */
@Data
public class GenerateTheoreticalAmountRequest {
    @NotEmpty(message = "年月不能为空")
    String month;
    Date createTimeStart;
    Date createTimeEnd;
    Integer dealUserId;

    public Date getCreateTimeStart() {
        if(StringUtils.isEmpty(month)){
            return createTimeStart;
        }
        String monthStr = month + "-01";
        Date monthDate = DateUtil.strToDate(monthStr);
        if (monthDate!= null) {
            createTimeStart=monthDate;
        }
        return createTimeStart;
    }

    public Date getCreateTimeEnd() {
        if(StringUtils.isEmpty(month)){
            return createTimeEnd;
        }
        String monthStr = month + "-01";
        Date monthDate = DateUtil.strToDate(monthStr);
        if (monthDate!= null) {
            createTimeEnd=DateUtil.plusMonth(1,monthDate);
            createTimeEnd= DateUtil.plusDay(-1,createTimeEnd);
        }
        return createTimeEnd;
    }
}
