package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.request.SaveInternalOrderNumberFinancialRemarkRequest;
import com.sky.ddt.dto.internalOrderNumber.request.SaveInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.InternalOrderNumber;

import javax.servlet.http.HttpServletResponse;

/**
 * @author baixueping
 * @description 内部单号
 * @date 2020/6/30 10:42
 */
public interface IInternalOrderNumberService {
    /**
     * @param
     * @return
     * @description 分页查询内部单号
     * @author baixueping
     * @date 2020/6/30 14:43
     */
    PageInfo<ListInternalOrderNumberResponse> listInternalOrderNumber(ListInternalOrderNumberRequest params);

    /**
     * @param
     * @param dealUserId
     * @return
     * @description 保存内部单号
     * @author baixueping
     * @date 2020/6/30 15:16
     */
    BaseResponse saveInternalOrderNumber(SaveInternalOrderNumberRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 下载pdf
     * @author baixueping
     * @date 2020/7/1 10:38
     */
    BaseResponse downPDF(Integer id, HttpServletResponse response);

    /**
     * @param
     * @return
     * @description 获取内部单号
     * @author baixueping
     * @date 2020/7/7 16:32
     */
    InternalOrderNumber getInternalOrderNumberByOrderNumber(String orderNumber);

    BaseResponse saveFinancialRemark(SaveInternalOrderNumberFinancialRemarkRequest params, Integer dealUserId);
}
