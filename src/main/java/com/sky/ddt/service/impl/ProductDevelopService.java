package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductDevelopConstant;
import com.sky.ddt.dao.custom.CustomProductDevelopMapper;
import com.sky.ddt.dto.product.response.ProductListResponse;
import com.sky.ddt.dto.productDevelop.request.ListProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.request.SaveProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.response.ListProductDevelopResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ProductDevelop;
import com.sky.ddt.entity.ProductDevelopExample;
import com.sky.ddt.service.IProductDevelopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 产品开发
 * @date 2021/9/1 21:43
 */
@Service
public class ProductDevelopService implements IProductDevelopService {
    @Autowired
    CustomProductDevelopMapper customProductDevelopMapper;

    @Override
    public PageInfo<ListProductDevelopResponse> listProductDevelop(ListProductDevelopRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListProductDevelopResponse> list = customProductDevelopMapper.listProductDevelop(params);
        PageInfo<ListProductDevelopResponse> page = new PageInfo<ListProductDevelopResponse>(list);
        return page;
    }

    @Override
    public BaseResponse saveProductDevelop(SaveProductDevelopRequest params, Integer dealUserId) {

        if (params.getId() == null) {
            return addProductDevelop(params, dealUserId);
        }
        if (!ProductDevelopConstant.ProductDevelopStatusEnum.contains(params.getStatus())) {
            return BaseResponse.failMessage("产品开发状态错误");
        }
        ProductDevelop productDevelop = customProductDevelopMapper.selectByPrimaryKey(params.getId());
        if (productDevelop == null) {
            return BaseResponse.failMessage("产品开发id不存在");
        }
        ProductDevelopExample example = new ProductDevelopExample();
        example.createCriteria().andProductCodeEqualTo(params.getProductCode()).andIdNotEqualTo(params.getId());
        if (customProductDevelopMapper.countByExample(example) > 0) {
            return BaseResponse.failMessage("产品编码已存在，请修改后保存");
        }
        if (ProductDevelopConstant.ProductDevelopStatusEnum.CONFIRM_PRODUCTION.getValue().equals(productDevelop.getStatus())) {
            return BaseResponse.failMessage("产品已确认生产，不允许修改");
        }
        ProductDevelop productDevelopUpdate=new ProductDevelop();
        BeanUtils.copyProperties(params, productDevelopUpdate);
        productDevelopUpdate.setCreateBy(dealUserId);
        productDevelopUpdate.setCreateTime(new Date());
        customProductDevelopMapper.updateByPrimaryKeySelective(productDevelopUpdate);
        return BaseResponse.success();
    }

    private BaseResponse addProductDevelop(SaveProductDevelopRequest params, Integer dealUserId) {
        if (!StringUtils.isEmpty(params.getProductCode())) {
            ProductDevelopExample example = new ProductDevelopExample();
            example.createCriteria().andProductCodeEqualTo(params.getProductCode());
            if (customProductDevelopMapper.countByExample(example) > 0) {
                return BaseResponse.failMessage("产品编码已存在，请修改后保存");
            }
        }
        ProductDevelop productDevelop = new ProductDevelop();
        BeanUtils.copyProperties(params, productDevelop);
        productDevelop.setDevelopmentTime(new Date());
        productDevelop.setStatus(ProductDevelopConstant.ProductDevelopStatusEnum.UNDER_DEVELOPMENT.getValue());
        productDevelop.setDeveloperUserId(dealUserId);
        productDevelop.setCreateBy(dealUserId);
        productDevelop.setCreateTime(new Date());
        customProductDevelopMapper.insertSelective(productDevelop);
        return BaseResponse.success();
    }
}
