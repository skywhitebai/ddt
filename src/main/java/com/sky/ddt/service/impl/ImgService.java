package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ImgConstant;
import com.sky.ddt.dao.custom.CustomImgMapper;
import com.sky.ddt.dao.generate.ImgDataMapper;
import com.sky.ddt.dto.img.request.AddImgRequest;
import com.sky.ddt.dto.img.request.ImgListRequest;
import com.sky.ddt.dto.img.response.OssObjectResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Img;
import com.sky.ddt.entity.ImgData;
import com.sky.ddt.entity.ImgDataExample;
import com.sky.ddt.entity.ImgExample;
import com.sky.ddt.service.IImgService;
import com.sky.ddt.service.IOssService;
import com.sky.ddt.util.FileCheckUtil;
import com.sky.ddt.util.StreamUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 图片服务
 * @date 2019/7/23 10:11
 */
@Service
public class ImgService implements IImgService {
    @Autowired
    CustomImgMapper customImgMapper;
    @Autowired
    ImgDataMapper imgDataMapper;
    @Autowired
    IOssService ossService;

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 上传图片
     * @author baixueping
     * @date 2019/7/23 10:42
     */
    @Override
    public BaseResponse addImg(AddImgRequest params, Integer dealUserId) {
        //判断类型是否正确
        if (!ImgConstant.ImgTypeEnum.contains(params.getImgType())) {
            return BaseResponse.failMessage(ImgConstant.IMG_TYPE_NOT_EXIST);
        }
        //判断文件类型 只能上传图片
        BaseResponse baseResponse = FileCheckUtil.checkPic(params.getImgFile(), ImgConstant.IMG_MAX_SIZE);
        if (!baseResponse.isSuccess()) {
            return baseResponse;
        }
        BaseResponse<OssObjectResponse> imgResponse = ossService.uploadPicFile(params.getImgFile());
        if (!imgResponse.isSuccess()) {
            return imgResponse;
        }
        Img img = new Img();
        img.setImgUrl(imgResponse.getData().getUrl());
        img.setOssKey(imgResponse.getData().getKey());
        img.setEntityId(params.getEntityId());

        img.setImgType(params.getImgType());
        BeanUtils.copyProperties(params, img);
        img.setImgName(params.getImgFile().getOriginalFilename());
        img.setCreateBy(dealUserId);
        img.setCreateTime(new Date());
        customImgMapper.insertSelective(img);
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 图片列表
     * @author baixueping
     * @date 2019/7/23 11:02
     */
    @Override
    public PageInfo<Img> list(ImgListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<Img> imgList = customImgMapper.list(params);
        PageInfo<Img> page = new PageInfo<Img>(imgList);
        return page;
    }

    /**
     * @param imgIds@return
     * @description 删除图片 考虑把oss的图片也删除 避免浪费空间
     * @author baixueping
     * @date 2019/7/23 11:10
     */
    @Override
    public BaseResponse deleteImg(List<Integer> imgIds) {
        if (CollectionUtils.isEmpty(imgIds)) {
            return BaseResponse.success();
        }
        ImgExample example = new ImgExample();
        example.createCriteria().andImgIdIn(imgIds);
        List<Img> imgList = customImgMapper.selectByExample(example);
        for (Img img : imgList) {
            ossService.deleteObjectByKey(img.getOssKey());
        }
        int res = customImgMapper.deleteByExample(example);
        if (res > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.fail();
        }
    }

    /**
     * @param imgId@return
     * @description 获取图片信息
     * @author baixueping
     * @date 2019/7/24 8:57
     */
    @Override
    public ImgData getImgDataById(Integer imgId) {
        if (imgId == null) {
            return null;
        }
        ImgData imgData = imgDataMapper.selectByPrimaryKey(imgId);
        return imgData;
    }

    /**
     * @param entityIds
     * @param imgTypeEnum
     * @return
     * @description 删除图片
     * @author baixueping
     * @date 2019/7/24 10:28
     */
    @Override
    public void deleteImgByEntityId(List<Integer> entityIds, ImgConstant.ImgTypeEnum imgTypeEnum) {
        if (CollectionUtils.isEmpty(entityIds) || imgTypeEnum == null) {
            return;
        }
        ImgExample imgExample = new ImgExample();
        imgExample.createCriteria().andEntityIdIn(entityIds).andImgTypeEqualTo(imgTypeEnum.getImgType());
        List<Img> imgList = customImgMapper.selectByExample(imgExample);
        if (CollectionUtils.isEmpty(imgList)) {
            return;
        }
        List<Integer> imgIds = imgList.stream().map(Img::getImgId).collect(Collectors.toList());
        deleteImg(imgIds);
    }

    /**
     * @param skuId@return
     * @description 获取sku图片
     * @author baixueping
     * @date 2020/3/26 14:28
     */
    @Override
    public String getImgUrlBySkuId(Integer skuId) {
        if(skuId==null){
            return null;
        }
        ImgExample imgExample=new ImgExample();
        imgExample.createCriteria().andEntityIdEqualTo(skuId).andImgTypeEqualTo(ImgConstant.ImgTypeEnum.SKU_IMG.getImgType());
        imgExample.setOrderByClause("img_id asc");
        List<Img> imgList=customImgMapper.selectByExample(imgExample);
        if(CollectionUtils.isEmpty(imgList)){
            return null;
        }
        return imgList.get(0).getImgUrl();
    }

    public void deleteImgByEntityId(Integer entityId, ImgConstant.ImgTypeEnum imgTypeEnum) {
        if (entityId == null || imgTypeEnum == null) {
            return;
        }
        List<Integer> entityIds = new ArrayList<>();
        entityIds.add(entityId);
        deleteImgByEntityId(entityIds, imgTypeEnum);
    }

}
