package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FileConstant;
import com.sky.ddt.common.constant.ImgConstant;
import com.sky.ddt.dao.custom.CustomFileMapper;
import com.sky.ddt.dto.file.request.AddFileRequest;
import com.sky.ddt.dto.file.request.FileListRequest;
import com.sky.ddt.dto.img.response.OssObjectResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.File;
import com.sky.ddt.entity.FileExample;
import com.sky.ddt.entity.Img;
import com.sky.ddt.entity.ImgExample;
import com.sky.ddt.service.IFileService;
import com.sky.ddt.service.IOssService;
import com.sky.ddt.util.FileCheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 文件服务
 * @date 2021/9/6 21:47
 */
@Service
public class FileService implements IFileService {
    @Autowired
    CustomFileMapper customFileMapper;
    @Autowired
    IOssService ossService;

    @Override
    public BaseResponse addFile(AddFileRequest params, Integer dealUserId) {
        //判断类型是否正确
        if(!FileConstant.FileTypeEnum.contains(params.getFileType())){
            return BaseResponse.failMessage(FileConstant.FILE_TYPE_NOT_EXIST);
        }
        //判断文件类型 大小
        BaseResponse baseResponse = FileCheckUtil.checkFile(params.getFile(), FileConstant.FILE_MAX_SIZE);
        if (!baseResponse.isSuccess()) {
            return baseResponse;
        }
        BaseResponse<OssObjectResponse> ossResponse = ossService.uploadFile(params.getFile());
        if (!ossResponse.isSuccess()) {
            return ossResponse;
        }
        File file=new File();
        file.setFileUrl(ossResponse.getData().getUrl());
        file.setOssKey(ossResponse.getData().getKey());
        file.setEntityId(params.getEntityId());
        file.setContentType(params.getFile().getContentType());
        file.setFileType(params.getFileType());
        BeanUtils.copyProperties(params, file);
        file.setFileName(params.getFile().getOriginalFilename());
        file.setCreateBy(dealUserId);
        file.setCreateTime(new Date());
        customFileMapper.insertSelective(file);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<File> list(FileListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        FileExample example=new FileExample();
        FileExample.Criteria criteria=example.createCriteria();
        if(params.getEntityId()!=null){
            criteria.andEntityIdEqualTo(params.getEntityId());
        }
        if(!StringUtils.isEmpty(params.getFileType())){
            criteria.andFileTypeEqualTo(params.getFileType());
        }
        example.setOrderByClause(" create_time desc");
        List<File> imgList = customFileMapper.selectByExample(example);
        PageInfo<File> page = new PageInfo<File>(imgList);
        return page;
    }

    @Override
    public BaseResponse deleteFile(List<Integer> fileIds) {
            if (CollectionUtils.isEmpty(fileIds)) {
                return BaseResponse.success();
            }
            FileExample example = new FileExample();
            example.createCriteria().andIdIn(fileIds);
            List<File> fileList = customFileMapper.selectByExample(example);
            for (File file : fileList) {
                ossService.deleteObjectByKey(file.getOssKey());
            }
            int res = customFileMapper.deleteByExample(example);
            if (res > 0) {
                return BaseResponse.success();
            } else {
                return BaseResponse.fail();
            }
    }
}
