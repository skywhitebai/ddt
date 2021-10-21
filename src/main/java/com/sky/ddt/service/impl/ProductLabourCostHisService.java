package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductLabourCostHisConstant;
import com.sky.ddt.dao.custom.CustomProductLabourCostHisMapper;
import com.sky.ddt.dto.productLabourCostHis.request.ListProductLabourCostHisRequest;
import com.sky.ddt.dto.productLabourCostHis.response.ListProductLabourCostHisResponse;
import com.sky.ddt.entity.ProductLabourCostHis;
import com.sky.ddt.service.IProductLabourCostHisService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 产品工价历史
 * @date 2021/10/21 19:04
 */
@Service
public class ProductLabourCostHisService implements IProductLabourCostHisService {
    @Autowired
    CustomProductLabourCostHisMapper customProductLabourCostHisMapper;
    @Override
    public void saveProductLabourCostHis(Integer productId, BigDecimal labourCostBefore, BigDecimal labourCostAfter, ProductLabourCostHisConstant.TypeEnum typeEnum, Integer dealUserId) {
        if (productId == null || typeEnum == null || dealUserId == null) {
            return;
        }
        if (MathUtil.equalBigDecimal(labourCostBefore, labourCostAfter)) {
            return;
        }
        ProductLabourCostHis productLabourCostHis=new ProductLabourCostHis();
        productLabourCostHis.setProductId(productId);
        productLabourCostHis.setLabourCostBefore(labourCostBefore);
        productLabourCostHis.setLabourCostAfter(labourCostAfter);
        productLabourCostHis.setType(typeEnum.getType());
        productLabourCostHis.setCreateBy(dealUserId);
        productLabourCostHis.setCreateTime(new Date());
        customProductLabourCostHisMapper.insertSelective(productLabourCostHis);
    }

    @Override
    public PageInfo<ListProductLabourCostHisResponse> listProductLabourCostHis(ListProductLabourCostHisRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListProductLabourCostHisResponse> list = customProductLabourCostHisMapper.listProductLabourCostHis(params);
        for (ListProductLabourCostHisResponse listProductLabourCostHisResponse :
                list) {
            listProductLabourCostHisResponse.setTypeName(ProductLabourCostHisConstant.TypeEnum.getTypeName(listProductLabourCostHisResponse.getType()));
        }
        PageInfo<ListProductLabourCostHisResponse> page = new PageInfo<ListProductLabourCostHisResponse>(list);
        return page;
    }
}
