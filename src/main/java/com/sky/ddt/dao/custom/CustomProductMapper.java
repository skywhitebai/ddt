package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProductMapper;
import com.sky.ddt.dto.product.request.ProductListRequest;
import com.sky.ddt.dto.product.response.ProductExportInfoResponse;
import com.sky.ddt.dto.product.response.ProductListResponse;

import java.util.List;

public interface CustomProductMapper extends ProductMapper {
    List<ProductListResponse> listProduct(ProductListRequest params);

    List<ProductExportInfoResponse> listProductExportInfo(ProductListRequest params);
}
