package com.sky.ddt.dto.shopSku.request;

import lombok.Data;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/1/16 10:32
 */
@Data
public class BatchSaveShopSkuStorageLocationRequest {
    Integer shopSkuId;
    List<Integer> storageLocationIdList;
    Integer createBy;
}
