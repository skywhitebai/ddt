package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FbaPackingListRemarkHisMapper;
import com.sky.ddt.dto.fbaPackingListRemarkHis.req.ListFbaPackingListRemarkHisReq;
import com.sky.ddt.dto.fbaPackingListRemarkHis.resp.ListFbaPackingListRemarkHisResp;

import java.util.List;

/**
 * @author sky
 * @Description CustomFbaPackingListRemarkHisMapper
 * @date 2023/3/16 22:48
 */
public interface CustomFbaPackingListRemarkHisMapper extends FbaPackingListRemarkHisMapper {
    List<ListFbaPackingListRemarkHisResp> listFbaPackingListRemarkHis(ListFbaPackingListRemarkHisReq params);
}
