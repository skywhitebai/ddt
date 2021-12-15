package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomCostCalculationSkuMapper;
import com.sky.ddt.dto.costCalculationSku.request.ListCostCalculationSkuRequest;
import com.sky.ddt.entity.CostCalculationSku;
import com.sky.ddt.entity.CostCalculationSkuExample;
import com.sky.ddt.service.ICostCalculationSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author sky
 * @Description TODO
 * @date 2021/11/17 22:50
 */
@Service
public class CostCalculationSkuService implements ICostCalculationSkuService {
    @Autowired
    CustomCostCalculationSkuMapper customCostCalculationSkuMapper;

    @Override
    public PageInfo<CostCalculationSku> listCostCalculationSku(ListCostCalculationSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        CostCalculationSkuExample costCalculationSkuExample=new CostCalculationSkuExample();
        CostCalculationSkuExample.Criteria criteria=costCalculationSkuExample.createCriteria();
        if(params.getCostCalculationId()!=null){
            criteria.andCostCalculationIdEqualTo(params.getCostCalculationId());
        }
        if(!StringUtils.isEmpty(params.getSku())){
            criteria.andSkuLike("%"+params.getSku()+"%");
        }
        costCalculationSkuExample.setOrderByClause("create_time desc,sku asc");
        List<CostCalculationSku> list = customCostCalculationSkuMapper.selectByExample(costCalculationSkuExample);
        PageInfo<CostCalculationSku> page = new PageInfo<CostCalculationSku>(list);
        return page;
    }

    @Override
    public List<CostCalculationSku> listExportCostCalculationSku(ListCostCalculationSkuRequest params) {
        CostCalculationSkuExample costCalculationSkuExample=new CostCalculationSkuExample();
        CostCalculationSkuExample.Criteria criteria=costCalculationSkuExample.createCriteria();
        if(params.getCostCalculationId()!=null){
            criteria.andCostCalculationIdEqualTo(params.getCostCalculationId());
        }
        if(!StringUtils.isEmpty(params.getSku())){
            criteria.andSkuLike(params.getSku());
        }
        costCalculationSkuExample.setOrderByClause("create_time desc,sku asc");
        List<CostCalculationSku> list = customCostCalculationSkuMapper.selectByExample(costCalculationSkuExample);
        return list;
    }
}
