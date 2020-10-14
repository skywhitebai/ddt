package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.productimg.request.ProductImgAddRequest;
import com.sky.ddt.dto.productimg.request.ProductImgListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ProductImg;

import java.util.List;

public interface IProductImgService {
    BaseResponse addProductImg(ProductImgAddRequest params, Integer dealUserId);

    BaseResponse getProductImg(Integer productId);

    PageInfo<ProductImg> list(ProductImgListRequest params);

    BaseResponse delete(List<Integer> ids);

    ProductImg getProductImgById(Integer id);
}
