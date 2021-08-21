package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomProductInventoryQuantityHisMapper;
import com.sky.ddt.entity.ProductInventoryQuantityHisExample;
import com.sky.ddt.service.IProductInventoryQuantityHisService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sky
 * @Description 产品哭粗
 * @date 2021/8/20 23:31
 */
@Service
public class ProductInventoryQuantityHisService implements IProductInventoryQuantityHisService {
    @Autowired
    CustomProductInventoryQuantityHisMapper customProductInventoryQuantityHisMapper;

    @Override
    public void saveProductInventoryQuantityHis() {
        Date month= DateUtil.getMonthFirstDay(new Date());
        //判断当前月份是否已经存在数据
        if(existThisMonth(month)){
            return;
        }
        customProductInventoryQuantityHisMapper.saveProductInventoryQuantityHis(month);
    }

    private boolean existThisMonth(Date month) {
        ProductInventoryQuantityHisExample example=new ProductInventoryQuantityHisExample();
        example.createCriteria().andMonthEqualTo(month);
        return customProductInventoryQuantityHisMapper.countByExample(example)>0;
    }
}
