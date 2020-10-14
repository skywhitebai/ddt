package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuCostPriceHisConstant;
import com.sky.ddt.dao.custom.CustomSkuCostPriceHisMapper;
import com.sky.ddt.dto.shopSku.response.ListShopSkuResponse;
import com.sky.ddt.dto.skuCostPriceHis.request.ListSkuCostPriceHisRequest;
import com.sky.ddt.dto.skuCostPriceHis.response.ListSkuCostPriceHisResponse;
import com.sky.ddt.entity.SkuCostPriceHis;
import com.sky.ddt.service.ISkuCostPriceHisService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description sky成本价历史
 * @date 2019/12/30 16:36
 */
@Service
public class SkuCostPriceHisService implements ISkuCostPriceHisService {
    @Autowired
    CustomSkuCostPriceHisMapper customSkuCostPriceHisMapper;

    @Override
    public void saveSkuCostPriceHis(Integer skuId, BigDecimal costPriceBefore, BigDecimal costPriceAfter, SkuCostPriceHisConstant.TypeEnum typeEnum, Integer dealUserId) {
        if (skuId == null || typeEnum == null || dealUserId == null) {
            return;
        }

        if (MathUtil.equalBigDecimal(costPriceAfter, costPriceBefore)) {
            return;
        }
        SkuCostPriceHis skuCostPriceHis = new SkuCostPriceHis();
        skuCostPriceHis.setCostPriceBefore(costPriceBefore);
        skuCostPriceHis.setCostPriceAfter(costPriceAfter);
        skuCostPriceHis.setSkuId(skuId);
        skuCostPriceHis.setType(typeEnum.getType());
        skuCostPriceHis.setCreateBy(dealUserId);
        skuCostPriceHis.setCreateTime(new Date());
        customSkuCostPriceHisMapper.insertSelective(skuCostPriceHis);
    }

    /**
     * @param params @return
     * @description 列表显示价格修改记录
     * @author baixueping
     * @date 2019/12/31 9:59
     */
    @Override
    public PageInfo<ListSkuCostPriceHisResponse> list(ListSkuCostPriceHisRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListSkuCostPriceHisResponse> list = customSkuCostPriceHisMapper.list(params);
        for (ListSkuCostPriceHisResponse listSkuCostPriceHisResponse :
                list) {
            listSkuCostPriceHisResponse.setTypeName(getTypeName(listSkuCostPriceHisResponse.getType()));
        }
        PageInfo<ListSkuCostPriceHisResponse> page = new PageInfo<ListSkuCostPriceHisResponse>(list);
        return page;
    }

    private String getTypeName(Integer type) {
        if (type == null) {
            return null;
        }
        SkuCostPriceHisConstant.TypeEnum typeEnum = SkuCostPriceHisConstant.TypeEnum.getTypeEnum(type);
        if (typeEnum == null) {
            return null;
        }
        return typeEnum.getTypeName();
    }
}
