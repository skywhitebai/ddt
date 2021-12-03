package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.controller.CostCalculationController;
import com.sky.ddt.dao.custom.CustomCostCalculationMapper;
import com.sky.ddt.dao.generate.CostCalculationMapper;
import com.sky.ddt.dto.costCalculation.request.ListCostCalculationRequest;
import com.sky.ddt.dto.costCalculation.request.SaveCostCalculationRemarkRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.response.ShopListResponse;
import com.sky.ddt.entity.CostCalculation;
import com.sky.ddt.service.ICostCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 22:42
 */
@Service
public class CostCalculationService implements ICostCalculationService {
    @Autowired
    CustomCostCalculationMapper customCostCalculationMapper;

    @Override
    public PageInfo<CostCalculation> listCostCalculation(ListCostCalculationRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<CostCalculation> list = customCostCalculationMapper.listCostCalculation(params);
        PageInfo<CostCalculation> page = new PageInfo<CostCalculation>(list);
        return page;
    }

    @Override
    public BaseResponse saveCostCalculationRemark(SaveCostCalculationRemarkRequest params) {
        CostCalculation costCalculation=new CostCalculation();
        costCalculation.setId(params.getId());
        costCalculation.setRemark(params.getRemark());
        customCostCalculationMapper.updateByPrimaryKeySelective(costCalculation);
        return BaseResponse.success();
    }
}
