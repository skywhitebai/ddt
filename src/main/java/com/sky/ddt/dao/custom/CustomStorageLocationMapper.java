package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StorageLocationMapper;
import com.sky.ddt.dto.storageLocation.request.ListStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.response.ListStorageLocationResponse;
import com.sky.ddt.dto.storageLocation.response.StorageLocationCmoboboxResponse;

import java.util.List;

/**
 * @author sky
 * @Description 库位
 * @date 2022/1/3 20:33
 */
public interface CustomStorageLocationMapper extends StorageLocationMapper {
    List<ListStorageLocationResponse> listStorageLocation(ListStorageLocationRequest params);

    List<StorageLocationCmoboboxResponse> comboboxlist();
}
