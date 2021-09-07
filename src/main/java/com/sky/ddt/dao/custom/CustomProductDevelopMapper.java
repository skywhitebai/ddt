package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProductDevelopMapper;
import com.sky.ddt.dto.productDevelop.request.ListProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.response.ListProductDevelopResponse;

import java.util.List;

/**
 * @author sky
 * @Description 产品开发
 * @date 2021/9/1 21:42
 */
public interface CustomProductDevelopMapper extends ProductDevelopMapper {
    List<ListProductDevelopResponse> listProductDevelop(ListProductDevelopRequest params);
}
