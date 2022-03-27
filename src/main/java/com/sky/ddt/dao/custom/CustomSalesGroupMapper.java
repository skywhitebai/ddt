package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SalesGroupMapper;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroup.resp.ListSalesGroupResp;

import java.util.List;

/**
 * @author sky
 * @Description 销售分组
 * @date 2022/3/26 23:31
 */
public interface CustomSalesGroupMapper extends SalesGroupMapper {
    List<ListSalesGroupResp> listSalesGroup(ListSalesGroupReq req);
}
