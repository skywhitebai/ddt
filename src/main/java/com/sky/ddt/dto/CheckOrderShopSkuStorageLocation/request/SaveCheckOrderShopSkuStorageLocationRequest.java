package com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 保存入库单sk库位入参
 * @date 2022/1/8 11:48
 */
@Data
public class SaveCheckOrderShopSkuStorageLocationRequest {
    Integer id;
    @NotNull(message = "仓库盘点单信息不能为空")
    Integer checkOrderShopSkuId;
    @NotNull(message = "库位id不能为空")
    Integer storageLocationId;
    @Length(max = 200,message = "备注长度不能大于200")
    String remark;
}
