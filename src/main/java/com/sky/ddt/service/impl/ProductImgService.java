package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductImgConstant;
import com.sky.ddt.dao.generate.ProductImgMapper;
import com.sky.ddt.dao.generate.ProductMapper;
import com.sky.ddt.dto.productimg.request.ProductImgAddRequest;
import com.sky.ddt.dto.productimg.request.ProductImgListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Product;
import com.sky.ddt.entity.ProductImg;
import com.sky.ddt.entity.ProductImgExample;
import com.sky.ddt.service.IProductImgService;
import com.sky.ddt.util.StreamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductImgService implements IProductImgService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductImgMapper productImgMapper;
    @Override
    public BaseResponse addProductImg(ProductImgAddRequest params, Integer dealUserId) {
        StringBuilder sbErro=new StringBuilder();
        if(StringUtils.isEmpty(params.getProductId())){
            sbErro.append(",").append(ProductImgConstant.PRODUCT_ID_EMPTY);
        }
        if(StringUtils.isEmpty(params.getImgFile())){
            sbErro.append(",").append(ProductImgConstant.IMG_FILE_EMPTY);
        }
        if(sbErro.length()>0){
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //判断文件类型 只能上传图片
        if(params.getImgFile().getSize()>ProductImgConstant.IMG_MAX_SIZE){
            return  BaseResponse.failMessage(ProductImgConstant.IMG_MAX_ERRO);
        }
        Product product=productMapper.selectByPrimaryKey(params.getProductId());
        if(product==null){
            return  BaseResponse.failMessage(ProductImgConstant.PRODUCT_ID_NOT_EXIST);
        }
        ProductImg productImg=new ProductImg();
        try {
            byte[] imgData=StreamUtil.input2byte(params.getImgFile().getInputStream());
            productImg.setImgData(imgData);
        } catch (IOException e) {
            e.printStackTrace();
            return  BaseResponse.failMessage(ProductImgConstant.IMG_READ_FAIL);
        }
        productImg.setImgName(params.getImgFile().getOriginalFilename());
        productImg.setProductId(params.getProductId());
        productImg.setCreateBy(dealUserId);
        productImg.setCreateTime(new Date());
       int res= productImgMapper.insert(productImg);
       if(res>0){
           return  BaseResponse.success();
       }else{
           return  BaseResponse.fail();
       }
    }

    @Override
    public BaseResponse getProductImg(Integer productId) {
        if(StringUtils.isEmpty(productId)){
            return BaseResponse.failMessage(ProductImgConstant.PRODUCT_ID_EMPTY);
        }
        ProductImgExample productImgExample=new ProductImgExample();
        productImgExample.createCriteria().andProductIdEqualTo(productId);
        List<ProductImg> productImgList=productImgMapper.selectByExampleWithBLOBs(productImgExample);
        return BaseResponse.successData(productImgList);
    }

    @Override
    public PageInfo<ProductImg> list(ProductImgListRequest params) {
        PageHelper.startPage(params.getPage(),params.getRows(),true);
        List<ProductImg> productImgList=new ArrayList<ProductImg>();
        if(!StringUtils.isEmpty(params.getProductId())){
            ProductImgExample productImgExample=new ProductImgExample();
            productImgExample.createCriteria().andProductIdEqualTo(params.getProductId());
            productImgExample.setOrderByClause(" create_time desc");
            productImgList=productImgMapper.selectByExample(productImgExample);
        }
        PageInfo<ProductImg> page=new PageInfo<ProductImg>(productImgList);
        return page;
    }

    @Override
    public BaseResponse delete(List<Integer> ids) {
        if(ids==null||ids.size()==0){
            return BaseResponse.success();
        }
        ProductImgExample example=new ProductImgExample();
        example.createCriteria().andIdIn(ids);
        int res=  productImgMapper.deleteByExample(example);
        if(res>0){
            return BaseResponse.success();
        }else{
            return BaseResponse.fail();
        }
    }

    @Override
    public ProductImg getProductImgById(Integer id) {
        if(id==null){
            return null;
        }
        return productImgMapper.selectByPrimaryKey(id);
    }

}
