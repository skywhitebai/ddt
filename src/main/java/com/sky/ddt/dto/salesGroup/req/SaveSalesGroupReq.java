package com.sky.ddt.dto.salesGroup.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 保存销售分组
 * @date 2022/3/26 23:40
 */
@Data
public class SaveSalesGroupReq {
    private Integer id;

    @NotEmpty(message = "分组名称不能为空")
    private String groupName;

    @NotNull(message = "状态不能为空")
    private Integer status;

    private String remark;
}
