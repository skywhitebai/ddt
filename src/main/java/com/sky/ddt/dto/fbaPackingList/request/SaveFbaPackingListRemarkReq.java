package com.sky.ddt.dto.fbaPackingList.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 修改备注
 * @date 2022/7/29 23:10
 */
@Data
public class SaveFbaPackingListRemarkReq {
    @NotNull(message = "fba装箱单id不能为空")
    Integer id;
    String remark;
}
