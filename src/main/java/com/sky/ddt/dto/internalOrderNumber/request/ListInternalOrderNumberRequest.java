package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import com.sky.ddt.util.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询内部单号入参
 * @date 2020/6/30 14:22
 */
@Data
public class ListInternalOrderNumberRequest extends DataGridRequest {
    String orderNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
    Integer payAmountStatus;
    String month;
    Integer transportTypeId;

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
            createTimeEnd= DateUtil.plusMonth(1,monthDate);
            createTimeEnd= DateUtil.plusDay(-1,createTimeEnd);
        }
        return createTimeEnd;
    }
}
