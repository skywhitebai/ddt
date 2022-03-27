package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SalesGroupUserMapper;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroupUser.req.ListSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.resp.ListSalesGroupUserResp;

import java.util.List;

/**
 * @author sky
 * @Description 销售用户分组
 * @date 2022/3/27 13:33
 */
public interface CustomSalesGroupUserMapper extends SalesGroupUserMapper {
    List<ListSalesGroupUserResp> listSalesGroupUser(ListSalesGroupUserReq req);
}
