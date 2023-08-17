package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ImgConstant;
import com.sky.ddt.dto.img.request.AddImgRequest;
import com.sky.ddt.dto.img.request.ImgListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Img;
import com.sky.ddt.entity.ImgData;

import java.util.List;

/**
 * @author baixueping
 * @description 图片服务
 * @date 2019/7/23 10:10
 */
public interface IImgService {
    /**
     * @param
     * @return
     * @description 上传图片
     * @author baixueping
     * @date 2019/7/23 10:42
     */
    BaseResponse addImg(AddImgRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 图片列表
     * @author baixueping
     * @date 2019/7/23 11:02
     */
    PageInfo<Img> list(ImgListRequest params);

    /**
     * @param
     * @return
     * @description 删除图片
     * @author baixueping
     * @date 2019/7/23 11:10
     */
    BaseResponse deleteImg(List<Integer> imgIds);

    /**
     * @param
     * @return
     * @description 获取图片信息
     * @author baixueping
     * @date 2019/7/24 8:57
     */
    ImgData getImgDataById(Integer imgId);

    /**
     * @param
     * @return
     * @description 删除图片图片
     * @author baixueping
     * @date 2019/7/24 10:28
     */
    void deleteImgByEntityId(List<Integer> skuIds, ImgConstant.ImgTypeEnum skuImg);

    /**
     * @param
     * @return
     * @description 获取sku图片
     * @author baixueping
     * @date 2020/3/26 14:28
     */
    String getImgUrlBySkuId(Integer skuId);

    /**
     * 返回各个sky的一张图片
     *
     * @param shopSkuIdList
     * @return
     */
    List<Img> listFirstImgUrl(List<Integer> shopSkuIdList);
}
