package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRemark.req.ListStockRemarkReq;
import com.sky.ddt.dto.stockRemark.req.SaveStockRemarkReq;
import com.sky.ddt.dto.stockRemark.resp.ListStockRemarkResp;

/**
 * @author sky
 * @Description 补货备注
 * @date 2022/10/25 22:01
 */
public interface IStockRemarkService {
    BaseResponse saveStockRemark(SaveStockRemarkReq req, Integer currentUserId);

    PageInfo<ListStockRemarkResp> listStockRemark(ListStockRemarkReq req);
}
