package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.skuinfo.request.SkuInfoListRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoSaveRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoTransForm;
import com.sky.ddt.entity.SkuInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.util.List;

public interface ISkuInfoService {
    PageInfo<SkuInfo> list(SkuInfoListRequest params);

    BaseResponse save(SkuInfoSaveRequest params, Integer dealUserId);

    BaseResponse delete(List<Integer> ids);

    BaseResponse importSkuInfo(MultipartFile file, Integer dealUserId);

    BaseResponse<List<SkuInfoTransForm>> transformSkuInfo(MultipartFile file);

    BaseResponse exportTransformSkuInfo(ServletOutputStream out, List<SkuInfoTransForm> list);
}
