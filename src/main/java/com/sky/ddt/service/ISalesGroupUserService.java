package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroupUser.req.ListSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.req.SaveSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.resp.ListSalesGroupUserResp;

/**
 * @author sky
 * @Description 销售分组用户服务
 * @date 2022/3/27 13:39
 */
public interface ISalesGroupUserService {
    PageInfo<ListSalesGroupUserResp> listSalesGroupUser(ListSalesGroupUserReq req);

    BaseResponse saveSalesGroupUser(SaveSalesGroupUserReq req, Integer currentUserId);

    BaseResponse deleteSalesGroupUser(Integer id, Integer currentUserId);
}
