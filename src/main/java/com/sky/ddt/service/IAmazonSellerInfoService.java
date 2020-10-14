package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 亚马逊销售数据统计
 *
 * @author baixueping
 * @date 2018/12/26
 */
public interface IAmazonSellerInfoService {

    BaseResponse countSellerInfoAll(MultipartFile file, HttpServletRequest request, HttpServletResponse response);

    /**
     * 订单数据下载
     * @param file
     * @param request
     * @param response
     * @return
     */
    BaseResponse orderExport(MultipartFile file, HttpServletRequest request, HttpServletResponse response);
}
