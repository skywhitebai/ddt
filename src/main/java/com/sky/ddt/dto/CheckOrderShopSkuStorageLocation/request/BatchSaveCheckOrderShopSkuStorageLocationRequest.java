package com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sky
 * @Description 保存盘点单sk库位入参
 * @date 2022/1/8 11:48
 */
@Data
public class BatchSaveCheckOrderShopSkuStorageLocationRequest {
    @NotNull(message = "盘点单skuid不能为空")
    Integer checkOrderShopSkuId;
    @NotNull(message = "库位id不能为空")
    List<Integer> storageLocationIdList;
    @Length(max = 200,message = "备注长度不能大于200")
    String remark;
    Integer createBy;
}
