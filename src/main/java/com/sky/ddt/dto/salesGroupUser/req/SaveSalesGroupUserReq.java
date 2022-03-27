package com.sky.ddt.dto.salesGroupUser.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description
 * @date 2022/3/27 13:50
 */
@Data
public class SaveSalesGroupUserReq {
    Integer id;
    @NotNull(message = "分组ID不能为空")
    Integer salesGroupId;
    @NotNull(message = "用户ID不能为空")
    Integer userId;

}
