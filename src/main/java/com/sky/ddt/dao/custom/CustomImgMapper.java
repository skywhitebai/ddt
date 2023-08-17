package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ImgMapper;
import com.sky.ddt.dto.img.request.ImgListRequest;
import com.sky.ddt.entity.Img;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 图片
 * @date 2019/7/23 10:57
 */
public interface CustomImgMapper extends ImgMapper {
    List<Img> list(ImgListRequest params);

    List<Img> listFirstImgUrl(@Param("shopSkuIdList") List<Integer> shopSkuIdList, @Param("imgType") String imgType);
}
