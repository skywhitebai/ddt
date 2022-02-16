package com.sky.ddt.dto.financialDocument.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 修改状态
 * @date 2022/2/16 23:36
 */
@Data
public class ChangeFinancialDocumentStatusRequest {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotNull(message = "状态不能为空")
    private Integer status;
}
