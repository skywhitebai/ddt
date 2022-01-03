package com.sky.ddt.dto.storageLocation.request;

import com.sky.ddt.common.constant.TransportTypeConstant;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 查询库位入仓
 * @date 2022/1/3 21:10
 */
@Data
public class SaveStorageLocationRequest extends DataGridRequest {
    Integer id;
    @NotBlank(message = "库位编号不能为空")
    @Length(max = 20, message = "库位编号长度不能超过20")
    String locationNo;
    @NotNull(message = "店铺id不能为空")
    Integer shopId;
    @Length(max = 200, message = "备注不能超过20")
    String remark;
}
