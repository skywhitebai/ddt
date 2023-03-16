package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaPackingListRemarkHis.req.ListFbaPackingListRemarkHisReq;
import com.sky.ddt.dto.fbaPackingListRemarkHis.resp.ListFbaPackingListRemarkHisResp;

/**
 * @author sky
 * @Description IFbaPackingListRemarkHisService
 * @date 2023/3/16 22:34
 */
public interface IFbaPackingListRemarkHisService {
    PageInfo<ListFbaPackingListRemarkHisResp> listFbaPackingListRemarkHis(ListFbaPackingListRemarkHisReq params);
}
