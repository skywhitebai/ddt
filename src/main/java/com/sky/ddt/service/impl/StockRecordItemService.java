package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomStockRecordItemMapper;
import com.sky.ddt.dto.stockRecordItem.request.ListStockRecordItemRequest;
import com.sky.ddt.dto.stockRecordItem.response.ListStockRecordItemResponse;
import com.sky.ddt.service.IImgService;
import com.sky.ddt.service.IStockRecordItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author baixueping
 * @description 备货记录内容
 * @date 2019/8/21 8:51
 */
@Service
public class StockRecordItemService implements IStockRecordItemService{
    @Autowired
    CustomStockRecordItemMapper customStockRecordItemMapper;
    @Autowired
    IImgService imgService;
    /**
     * @param params@return
     * @description 发货单明细查询
     * @author baixueping
     * @date 2019/8/23 10:35
     */
    @Override
    public PageInfo<ListStockRecordItemResponse> listStockRecordItem(ListStockRecordItemRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockRecordItemResponse> list = customStockRecordItemMapper.listStockRecordItem(params);
        for (ListStockRecordItemResponse listStockRecordItemResponse:
                list) {
            String imgUrl = imgService.getImgUrlBySkuId(listStockRecordItemResponse.getSkuId());
            if (!StringUtils.isEmpty(imgUrl)) {
                listStockRecordItemResponse.setImgUrl(imgUrl);
            }
        }
        PageInfo<ListStockRecordItemResponse> page = new PageInfo<ListStockRecordItemResponse>(list);
        return page;
    }
}
