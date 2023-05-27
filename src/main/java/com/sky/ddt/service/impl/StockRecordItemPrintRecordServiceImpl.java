package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomStockRecordItemMapper;
import com.sky.ddt.dao.custom.CustomStockRecordItemPrintRecordMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.ListStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordRemarkReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.resp.ListStockRecordItemPrintRecordResp;
import com.sky.ddt.entity.StockRecordItem;
import com.sky.ddt.entity.StockRecordItemPrintRecord;
import com.sky.ddt.service.IStockRecordItemPrintRecordService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2023/5/27 15:34
 */
@Service
public class StockRecordItemPrintRecordServiceImpl implements IStockRecordItemPrintRecordService {
    @Autowired
    CustomStockRecordItemPrintRecordMapper customStockRecordItemPrintRecordMapper;
    @Autowired
    CustomStockRecordItemMapper customStockRecordItemMapper;

    @Override
    public BaseResponse saveStockRecordItemPrintRecord(SaveStockRecordItemPrintRecordReq params, Integer dealUserId) {
        StockRecordItem stockRecordItem = customStockRecordItemMapper.selectByPrimaryKey(params.getStockRecordItemId());
        if (stockRecordItem == null) {
            return BaseResponse.failMessage("补货记录StockRecordItemId不存在");
        }
        StockRecordItem stockRecordItemUpdate = new StockRecordItem();
        stockRecordItemUpdate.setId(params.getStockRecordItemId());
        stockRecordItemUpdate.setPrintQuantity(MathUtil.add(stockRecordItem.getPrintQuantity(), stockRecordItem.getStockQuantity()));
        customStockRecordItemMapper.updateByPrimaryKeySelective(stockRecordItemUpdate);

        StockRecordItemPrintRecord stockRecordItemPrintRecord = new StockRecordItemPrintRecord();
        stockRecordItemPrintRecord.setCreateBy(dealUserId);
        stockRecordItemPrintRecord.setCreateTime(new Date());
        stockRecordItemPrintRecord.setPrintQuantity(stockRecordItem.getStockQuantity());
        stockRecordItemPrintRecord.setStockRecordItemId(params.getStockRecordItemId());
        customStockRecordItemPrintRecordMapper.insertSelective(stockRecordItemPrintRecord);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListStockRecordItemPrintRecordResp> listStockRecordItemPrintRecord(ListStockRecordItemPrintRecordReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockRecordItemPrintRecordResp> list = customStockRecordItemPrintRecordMapper.listStockRecordItemPrintRecord(params);

        PageInfo<ListStockRecordItemPrintRecordResp> page = new PageInfo<ListStockRecordItemPrintRecordResp>(list);
        return page;
    }

    @Override
    public BaseResponse saveStockRecordItemPrintRecordRemark(SaveStockRecordItemPrintRecordRemarkReq params) {
        StockRecordItemPrintRecord stockRecordItemPrintRecord = new StockRecordItemPrintRecord();
        stockRecordItemPrintRecord.setId(params.getId());
        stockRecordItemPrintRecord.setRemark(params.getRemark());
        customStockRecordItemPrintRecordMapper.updateByPrimaryKeySelective(stockRecordItemPrintRecord);
        return BaseResponse.success();
    }
}
