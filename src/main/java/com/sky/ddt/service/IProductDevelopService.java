package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.productDevelop.request.ChangeProductDevelopStatusRequest;
import com.sky.ddt.dto.productDevelop.request.ListProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.request.SaveProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.response.ListProductDevelopResponse;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author sky
 * @Description 产品开发
 * @date 2021/9/1 21:42
 */
public interface IProductDevelopService {
    PageInfo<ListProductDevelopResponse> listProductDevelop(ListProductDevelopRequest params);

    BaseResponse saveProductDevelop(SaveProductDevelopRequest params, Integer dealUserId);

    BaseResponse changeProductDevelopStatus(ChangeProductDevelopStatusRequest params, Integer dealUserId);
}
