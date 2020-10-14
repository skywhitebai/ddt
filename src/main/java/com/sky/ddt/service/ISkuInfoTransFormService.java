package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISkuInfoTransFormService {
    BaseResponse exportTransformSkuInfoStream(MultipartFile file, HttpServletRequest request, HttpServletResponse response);
}
