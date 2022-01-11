package com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sky
 * @Description 保存入库单sk库位入参
 * @date 2022/1/8 11:48
 */
@Data
public class BatchSaveWarehousingOrderShopSkuStorageLocationRequest {
    @NotNull(message = "仓库skuid不能为空")
    Integer warehousingOrderShopSkuId;
    @NotNull(message = "库位id不能为空")
    List<Integer> storageLocationIdList;
    @Length(max = 200,message = "备注长度不能大于200")
    String remark;
    Integer createBy;
}
