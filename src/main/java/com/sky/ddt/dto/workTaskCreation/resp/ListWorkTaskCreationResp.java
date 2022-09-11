package com.sky.ddt.dto.workTaskCreation.resp;

import com.sky.ddt.entity.WorkTaskCreation;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/9/10 16:27
 */
@Data
public class ListWorkTaskCreationResp extends WorkTaskCreation {
    String chargeUserRealNames;
}
