package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockRemarkMapper;
import com.sky.ddt.dto.stockRemark.req.ListStockRemarkReq;
import com.sky.ddt.dto.stockRemark.resp.ListStockRemarkResp;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/10/25 22:02
 */
public interface CustomStockRemarkMapper extends StockRemarkMapper {
    List<ListStockRemarkResp> listStockRemark(ListStockRemarkReq params);
}
