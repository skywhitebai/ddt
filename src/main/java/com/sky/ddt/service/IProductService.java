package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.product.request.ProductListRequest;
import com.sky.ddt.dto.product.request.ProductSaveRequest;
import com.sky.ddt.dto.product.response.ProductExportInfoResponse;
import com.sky.ddt.dto.product.response.ProductListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {
    PageInfo<ProductListResponse> list(ProductListRequest params);

    BaseResponse save(ProductSaveRequest params, Integer dealUserId);

    BaseResponse delete(List<Integer> productIds, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 通过sku获取产品信息
     * @author baixueping
     * @date 2019/5/10 15:28
     */
    Product getProductByProductCode(String sku);

    /**
     * @param
     * @return
     * @description 导入产品
     * @author baixueping
     * @date 2019/5/13 16:18
     */
    BaseResponse importProduct(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取产品导出信息
     * @author baixueping
     * @date 2019/5/13 16:44
     */
    List<ProductExportInfoResponse> listProductExportInfo(ProductListRequest params);

    /**
     * @param
     * @return
     * @description 导入开发人员
     * @author baixueping
     * @date 2020/1/2 17:00
     */
    BaseResponse importDeveloperUser(MultipartFile file, Integer dealUserId);
}
