package com.sky.ddt.dto.workTask.resp;

import com.sky.ddt.entity.WorkTaskLog;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 22:01
 */
@Data
public class ListWorkTaskLogResp extends WorkTaskLog {
    String dealUserRealName;
}
