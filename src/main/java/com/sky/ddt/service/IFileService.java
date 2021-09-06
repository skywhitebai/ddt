package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.file.request.AddFileRequest;
import com.sky.ddt.dto.file.request.FileListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.File;

import java.util.List;

/**
 * @author sky
 * @Description 文件服务
 * @date 2021/9/6 21:47
 */
public interface IFileService {
    BaseResponse addFile(AddFileRequest params, Integer dealUserId);

    PageInfo<File> list(FileListRequest params);

    BaseResponse deleteFile(List<Integer> fileIds);
}
