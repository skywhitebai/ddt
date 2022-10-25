package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomStockRemarkMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.dto.stockRemark.req.ListStockRemarkReq;
import com.sky.ddt.dto.stockRemark.req.SaveStockRemarkReq;
import com.sky.ddt.dto.stockRemark.resp.ListStockRemarkResp;
import com.sky.ddt.entity.StockRemark;
import com.sky.ddt.entity.StockRemarkExample;
import com.sky.ddt.service.IStockRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/10/25 22:01
 */
@Service
public class StockRemarkService implements IStockRemarkService {
    @Autowired
    CustomStockRemarkMapper customStockRemarkMapper;

    @Override
    public BaseResponse saveStockRemark(SaveStockRemarkReq req, Integer currentUserId) {
        //获取现有的备注
        StockRemark stockRemarkEnable = getStockRemarkEnable(req.getShopSkuId());
        if (stockRemarkEnable != null) {
            //判断备注是否一致  如果一直则返回
            if (stockRemarkEnable.getRemark().equals(req.getRemark())) {
                return BaseResponse.success();
            } else {
                //不一致，更新为失效
                stockRemarkEnable.setStatus(0);
                stockRemarkEnable.setUpdateBy(currentUserId);
                stockRemarkEnable.setUpdateTime(new Date());
                customStockRemarkMapper.updateByPrimaryKey(stockRemarkEnable);
            }
        }
        //添加新备注
        StockRemark stockRemark = new StockRemark();
        stockRemark.setStatus(1);
        stockRemark.setShopSkuId(req.getShopSkuId());
        stockRemark.setRemark(req.getRemark());
        stockRemark.setCreateBy(currentUserId);
        stockRemark.setCreateTime(new Date());
        stockRemark.setUpdateBy(currentUserId);
        stockRemark.setUpdateTime(stockRemark.getCreateTime());
        customStockRemarkMapper.insertSelective(stockRemark);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListStockRemarkResp> listStockRemark(ListStockRemarkReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockRemarkResp> list = customStockRemarkMapper.listStockRemark(params);
        PageInfo<ListStockRemarkResp> page = new PageInfo<ListStockRemarkResp>(list);
        return page;
    }

    private StockRemark getStockRemarkEnable(Integer shopSkuId) {
        StockRemarkExample example = new StockRemarkExample();
        example.createCriteria().andShopSkuIdEqualTo(shopSkuId).andStatusEqualTo(1);
        List<StockRemark> list = customStockRemarkMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
