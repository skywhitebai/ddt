package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.amazonWarehouse.req.ListAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.req.SaveAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.resp.AmazonWarehouseComboxResp;
import com.sky.ddt.dto.amazonWarehouse.resp.ListAmazonWarehouseResp;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sky
 * @Description TODO
 * @date 2022/4/17 23:33
 */
public interface IAmazonWarehouseService {
    PageInfo<ListAmazonWarehouseResp> listAmazonWarehouse(ListAmazonWarehouseReq params);

    BaseResponse saveAmazonWarehouse(SaveAmazonWarehouseReq params, Integer dealUserId);

    List<AmazonWarehouseComboxResp> amazonWarehouseComboboxlist();

    BaseResponse importAmazonWarehouse(MultipartFile file, Integer dealUserId);
}
