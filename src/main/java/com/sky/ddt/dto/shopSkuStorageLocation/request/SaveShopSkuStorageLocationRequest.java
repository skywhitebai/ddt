package com.sky.ddt.dto.shopSkuStorageLocation.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 保存仓库sk库位入参
 * @date 2022/1/8 11:48
 */
@Data
public class SaveShopSkuStorageLocationRequest {
    Integer id;
    @NotNull(message = "仓库skuid不能为空")
    Integer shopSkuId;
    @NotNull(message = "库位id不能为空")
    Integer storageLocationId;
    @Length(max = 200,message = "备注长度不能大于200")
    String remark;
}