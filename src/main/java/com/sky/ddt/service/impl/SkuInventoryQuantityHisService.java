package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomSkuInventoryQuantityHisMapper;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;
import com.sky.ddt.entity.SkuInventoryQuantityHisExample;
import com.sky.ddt.service.ISkuInventoryQuantityHisService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description sku库存
 * @date 2021/8/20 23:32
 */
@Service
public class SkuInventoryQuantityHisService implements ISkuInventoryQuantityHisService {
    @Autowired
    CustomSkuInventoryQuantityHisMapper customSkuInventoryQuantityHisMapper;

    @Override
    public void saveSkuInventoryQuantityHis() {
        Date month= DateUtil.getMonthFirstDay(new Date());
        //判断当前月份是否已经存在数据
        if(existThisMonth(month)){
            return;
        }
        customSkuInventoryQuantityHisMapper.saveSkuInventoryQuantityHis(month);
    }

    @Override
    public PageInfo<ListInventoryQuantityHisResponse> listSkuInventoryQuantityHis(ListInventoryQuantityHisRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInventoryQuantityHisResponse> list = customSkuInventoryQuantityHisMapper.listSkuInventoryQuantityHis(params);
        PageInfo<ListInventoryQuantityHisResponse> page = new PageInfo<ListInventoryQuantityHisResponse>(list);
        return page;
    }

    @Override
    public List<ListInventoryQuantityHisResponse> listExportSkuInventoryQuantityHis(ListInventoryQuantityHisRequest params) {
        return customSkuInventoryQuantityHisMapper.listSkuInventoryQuantityHis(params);
    }

    private boolean existThisMonth(Date month) {
        SkuInventoryQuantityHisExample example=new SkuInventoryQuantityHisExample();
        example.createCriteria().andMonthEqualTo(month);
        return customSkuInventoryQuantityHisMapper.countByExample(example)>0;
    }
}
