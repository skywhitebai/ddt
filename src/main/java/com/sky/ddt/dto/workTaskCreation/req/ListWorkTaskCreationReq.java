package com.sky.ddt.dto.workTaskCreation.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/9/10 16:25
 */
@Data
public class ListWorkTaskCreationReq extends DataGridRequest {
    private String title;
    private Integer status;
    private Integer dealUserId;
}