package com.sky.ddt.dto.amazonWarehouse.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author sky
 * @Description
 * @date 2022/4/18 22:52
 */
@Data
public class SaveAmazonWarehouseReq {
    Integer id;
    @NotEmpty(message = "仓库id不能为空")
    @Length(max = 32,message = "仓库id长度不能超过32")
    private String fulfillmentCenterId;
    @Length(max = 32,message = "州长度不能超过32")
    private String state;
    @Length(max = 200,message = "备注长度不能超过200")
    private String remark;
}
