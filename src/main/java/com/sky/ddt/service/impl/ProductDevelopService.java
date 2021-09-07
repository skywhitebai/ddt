package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductDevelopConstant;
import com.sky.ddt.dao.custom.CustomProductDevelopMapper;
import com.sky.ddt.dao.custom.CustomProductMapper;
import com.sky.ddt.dto.product.response.ProductListResponse;
import com.sky.ddt.dto.productDevelop.request.ListProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.request.SaveProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.response.ListProductDevelopResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Product;
import com.sky.ddt.entity.ProductDevelop;
import com.sky.ddt.entity.ProductDevelopExample;
import com.sky.ddt.service.IProductDevelopService;
import com.sky.ddt.service.IProductService;
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
    @Autowired
    IProductService productService;
    @Autowired
    CustomProductMapper customProductMapper;

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
        productDevelopUpdate.setUpdateBy(dealUserId);
        productDevelopUpdate.setUpdateTime(new Date());
        if (ProductDevelopConstant.ProductDevelopStatusEnum.CONFIRM_PRODUCTION.getValue().equals(params.getStatus())) {
            //确认生产
            //判断产品编码是否存在
            if(productService.getProductByProductCode(params.getProductCode())!=null){
                return BaseResponse.failMessage("产品表已存在产品编码["+params.getProductCode()+"]，请修改后再确认生产");
            }
            Product product=new Product();
            BeanUtils.copyProperties(productDevelop,product);
            product.setCreateBy(dealUserId);
            product.setCreateTime(new Date());
            customProductMapper.insertSelective(product);
            productDevelopUpdate.setProductId(product.getProductId());
        }
        customProductDevelopMapper.updateByPrimaryKeySelective(productDevelopUpdate);
        if (ProductDevelopConstant.ProductDevelopStatusEnum.CONFIRM_PRODUCTION.getValue().equals(params.getStatus())) {
            return BaseResponse.successMessage("确认生产成功");
        }
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
