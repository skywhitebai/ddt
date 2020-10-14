package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuWeightHisConstant;
import com.sky.ddt.dao.custom.CustomSkuWeightHisMapper;
import com.sky.ddt.dto.skuWeightHis.request.ListSkuWeightHisRequest;
import com.sky.ddt.dto.skuWeightHis.response.ListSkuWeightHisResponse;
import com.sky.ddt.entity.Sku;
import com.sky.ddt.entity.SkuWeightHis;
import com.sky.ddt.service.ISkuWeightHisService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description sku重量历史
 * @date 2020/1/2 10:05
 */
@Service
public class SkuWeightHisService implements ISkuWeightHisService {
    @Autowired
    CustomSkuWeightHisMapper customSkuWeightHisMapper;
    @Override
    public void saveSkuWeightHis(Sku skuOld, Sku skuNew, SkuWeightHisConstant.WeightHisTypeEnum weightHisTypeEnum, Integer dealUserId) {
        if(skuOld==null){
            if(skuNew==null){
                return;
            }
            if(skuNew.getWeight()==null&&skuNew.getHeadTripCost()==null&&skuNew.getHeadTripCostMin()==null){
                return;
            }
        }else{
            if(MathUtil.equalBigDecimal(skuOld.getWeight(),skuNew.getWeight())
                    &&MathUtil.equalBigDecimal(skuOld.getHeadTripCost(),skuNew.getHeadTripCost())
                    &&MathUtil.equalBigDecimal(skuOld.getHeadTripCostMin(),skuNew.getHeadTripCostMin())){
                return;
            }
        }
        SkuWeightHis skuWeightHis=new SkuWeightHis();
        skuWeightHis.setSkuId(skuNew.getSkuId());
        if(skuOld!=null){
            skuWeightHis.setWeightBefore(skuOld.getWeight());
            skuWeightHis.setHeadTripCostBefore(skuOld.getHeadTripCost());
            skuWeightHis.setHeadTripCostMinBefore(skuOld.getHeadTripCostMin());
        }
        skuWeightHis.setWeightAfter(skuNew.getWeight());
        skuWeightHis.setHeadTripCostAfter(skuNew.getHeadTripCost());
        skuWeightHis.setHeadTripCostMinAfter(skuNew.getHeadTripCostMin());
        skuWeightHis.setCreateBy(dealUserId);
        skuWeightHis.setCreateTime(new Date());
        customSkuWeightHisMapper.insertSelective(skuWeightHis);
        return;
    }

    @Override
    public PageInfo<ListSkuWeightHisResponse> list(ListSkuWeightHisRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListSkuWeightHisResponse> list = customSkuWeightHisMapper.list(params);
        for (ListSkuWeightHisResponse listSkuWeightHisResponse:
                list) {
            listSkuWeightHisResponse.setTypeName(getTypeName(listSkuWeightHisResponse.getType()));
        }
        PageInfo<ListSkuWeightHisResponse> page = new PageInfo<ListSkuWeightHisResponse>(list);
        return page;
    }

    private String getTypeName(Integer type) {
        if(type==null){
            return null;
        }
        SkuWeightHisConstant.WeightHisTypeEnum typeEnum=SkuWeightHisConstant.WeightHisTypeEnum.getTypeEnum(type);
        if(typeEnum==null){
            return null;
        }
        return typeEnum.getTypeName();
    }
}
