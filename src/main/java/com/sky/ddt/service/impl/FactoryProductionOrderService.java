package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FactoryProductionOrderConstant;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderMapper;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderShopSkuMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderPrdocutRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.SaveFactoryProductionOrderRemark;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderPrdocutResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FactoryProductionOrder;
import com.sky.ddt.entity.FactoryProductionOrderShopSku;
import com.sky.ddt.entity.StockCart;
import com.sky.ddt.service.IFactoryProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 工厂生产单服务
 * @date 2020/10/10 10:38
 */
@Service
public class FactoryProductionOrderService implements IFactoryProductionOrderService {
    @Autowired
    CustomFactoryProductionOrderMapper customFactoryProductionOrderMapper;
    @Autowired
    CustomFactoryProductionOrderShopSkuMapper customFactoryProductionOrderShopSkuMapper;
    /**
     * @param stockCartList 店铺sku及数量
     * @param stockRecordId 补货记录id
     * @param shopId
     * @param title
     * @param currentUserId @return  @description 生成工厂生产单
     * @author baixueping
     * @date 2020/10/10 14:32
     */
    @Override
    public void createFactoryProductionOrder(List<StockCart> stockCartList, Integer stockRecordId, Integer shopId, String title, Integer currentUserId) {
        FactoryProductionOrder factoryProductionOrder=new FactoryProductionOrder();
        factoryProductionOrder.setStatus(FactoryProductionOrderConstant.StatusEnum.UNCONFIRMED.getStatus());
        factoryProductionOrder.setTitle(title);
        factoryProductionOrder.setShopId(shopId);
        factoryProductionOrder.setCreateBy(currentUserId);
        factoryProductionOrder.setCreateTime(new Date());
        customFactoryProductionOrderMapper.insertSelective(factoryProductionOrder);
        //生成生产单店铺sku
        for(StockCart stockCart:stockCartList){
            FactoryProductionOrderShopSku factoryProductionOrderShopSku=new FactoryProductionOrderShopSku();
            factoryProductionOrderShopSku.setCreateBy(currentUserId);
            factoryProductionOrderShopSku.setCreateTime(new Date());
            factoryProductionOrderShopSku.setProductionQuantity(stockCart.getProductionQuantity());
            factoryProductionOrderShopSku.setShopSkuId(stockCart.getShopSkuId());
            factoryProductionOrderShopSku.setFactoryProductionOrderId(factoryProductionOrder.getId());
            customFactoryProductionOrderShopSkuMapper.insertSelective(factoryProductionOrderShopSku);
        }
    }

    /**
     * @param params@return
     * @description 分页查询工厂生产单数据
     * @author baixueping
     * @date 2020/10/12 15:07
     */
    @Override
    public PageInfo<ListFactoryProductionOrderResponse> listFactoryProductionOrder(ListFactoryProductionOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderResponse> list = customFactoryProductionOrderMapper.listFactoryProductionOrder(params);
        PageInfo<ListFactoryProductionOrderResponse> page = new PageInfo<ListFactoryProductionOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存备注
     * @author baixueping
     * @date 2020/10/12 16:34
     */
    @Override
    public BaseResponse saveFactoryProductionOrderRemark(SaveFactoryProductionOrderRemark params, Integer dealUserId) {
        FactoryProductionOrder factoryProductionOrder=new FactoryProductionOrder();
        factoryProductionOrder.setId(params.getId());
        factoryProductionOrder.setRemark(params.getRemark());
        factoryProductionOrder.setUpdateBy(dealUserId);
        factoryProductionOrder.setUpdateTime(new Date());
        customFactoryProductionOrderMapper.updateByPrimaryKeySelective(factoryProductionOrder);
        return BaseResponse.success();
    }

    /**
     * @param params @return
     * @description 获取工厂生产单产品信息
     * @author baixueping
     * @date 2020/10/15 16:46
     */
    @Override
    public PageInfo<ListFactoryProductionOrderPrdocutResponse> listFactoryProductionOrderPrdocut(ListFactoryProductionOrderPrdocutRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderPrdocutResponse> list = customFactoryProductionOrderMapper.listFactoryProductionOrderPrdocut(params);
        PageInfo<ListFactoryProductionOrderPrdocutResponse> page = new PageInfo<>(list);
        return page;
    }
}
