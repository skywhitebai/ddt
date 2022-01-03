package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.storageLocation.request.ListStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.request.SaveStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.response.ListStorageLocationResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description 库位管理
 * @date 2022/1/3 20:35
 */
public interface IStorageLocationService {
    PageInfo<ListStorageLocationResponse> listStorageLocation(ListStorageLocationRequest params);

    BaseResponse saveStorageLocation(SaveStorageLocationRequest params, Integer dealUserId);

    BaseResponse importStorageLocation(MultipartFile file, Integer dealUserId);
}
