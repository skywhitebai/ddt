package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.storageLocation.request.ListStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.request.SaveStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.response.ListStorageLocationResponse;
import com.sky.ddt.dto.storageLocation.response.StorageLocationCmoboboxResponse;
import com.sky.ddt.entity.StorageLocation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sky
 * @Description 库位管理
 * @date 2022/1/3 20:35
 */
public interface IStorageLocationService {
    PageInfo<ListStorageLocationResponse> listStorageLocation(ListStorageLocationRequest params);

    BaseResponse saveStorageLocation(SaveStorageLocationRequest params, Integer dealUserId);

    BaseResponse importStorageLocation(MultipartFile file, Integer dealUserId);

    StorageLocation getStorageLocation(Integer storageLocationId);

    List<StorageLocationCmoboboxResponse> comboboxlist();
}
