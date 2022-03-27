package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroup.req.SaveSalesGroupReq;
import com.sky.ddt.dto.salesGroup.resp.ListSalesGroupResp;

/**
 * @author sky
 * @Description 销售分组
 * @date 2022/3/26 23:32
 */
public interface ISalesGroupService {
    PageInfo<ListSalesGroupResp> listSalesGroup(ListSalesGroupReq req);

    BaseResponse saveSalesGroup(SaveSalesGroupReq req, Integer currentUserId);

    BaseResponse deleteSalesGroup(Integer id, Integer currentUserId);
}
