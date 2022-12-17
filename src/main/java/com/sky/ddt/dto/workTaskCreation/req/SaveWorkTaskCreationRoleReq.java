package com.sky.ddt.dto.workTaskCreation.req;

import lombok.Data;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/10 16:25
 */
@Data
public class SaveWorkTaskCreationRoleReq {
    private Long workTaskCreationId;
    List<Long> roleIds;
}