package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.*;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderMapper;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderShopSkuMapper;
import com.sky.ddt.dao.custom.CustomShopMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.*;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderInfoResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderShopParentSkuResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ShopSkuProductionQuantityDto;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IFactoryProductionOrderService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.IStockRecordService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    IStockRecordService stockRecordService;
    @Autowired
    CustomShopMapper customShopMapper;


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
        FactoryProductionOrder factoryProductionOrder = new FactoryProductionOrder();
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
    public PageInfo<ListFactoryProductionOrderShopParentSkuResponse> listFactoryProductionOrderShopParentSku(ListFactoryProductionOrderShopParentSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderShopParentSkuResponse> list = customFactoryProductionOrderMapper.listFactoryProductionOrderShopParentSku(params);
        PageInfo<ListFactoryProductionOrderShopParentSkuResponse> page = new PageInfo<>(list);
        return page;
    }

    /**
     * @param params@return
     * @description 获取父sku生产数量
     * @author baixueping
     * @date 2020/10/15 19:04
     */
    @Override
    public PageInfo<ListFactoryProductionOrderInfoResponse> listFactoryProductionOrderInfo(ListFactoryProductionOrderInfoRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderInfoResponse> list = customFactoryProductionOrderMapper.listColourByShopParentSku(params);
        List<ShopSkuProductionQuantityDto> shopSkuProductionQuantityDtoList = customFactoryProductionOrderMapper.listShopSkuProductionQuantity(params);
        for (ListFactoryProductionOrderInfoResponse listFactoryProductionOrderInfoResponse :
                list) {
            listFactoryProductionOrderInfoResponse.setShopParentSku(params.getShopParentSku());
            if (listFactoryProductionOrderInfoResponse.getColour() == null) {
                listFactoryProductionOrderInfoResponse.setRemark("存在颜色为空的产品sku，请完善颜色");
                continue;
            }
            SbErroEntity sbErroEntity = new SbErroEntity(";");
            for (ShopSkuProductionQuantityDto shopSkuProductionQuantityDto : shopSkuProductionQuantityDtoList) {
                if (listFactoryProductionOrderInfoResponse.getColour().equals(shopSkuProductionQuantityDto.getColour())) {
                    if (StringUtils.isEmpty(shopSkuProductionQuantityDto.getSize())) {
                        sbErroEntity.append("店铺sku："+shopSkuProductionQuantityDto.getShopSku()+",尺码为空，请完善尺码");
                        continue;
                    }
                    if(SkuConstant.SkuSizeEnum.S.equals(shopSkuProductionQuantityDto.getSize().toUpperCase())){
                        listFactoryProductionOrderInfoResponse.setProductionQuantityS(shopSkuProductionQuantityDto.getProductionQuantity());
                    }else  if(SkuConstant.SkuSizeEnum.M.equals(shopSkuProductionQuantityDto.getSize().toUpperCase())){
                        listFactoryProductionOrderInfoResponse.setProductionQuantityM(shopSkuProductionQuantityDto.getProductionQuantity());
                    }else  if(SkuConstant.SkuSizeEnum.L.equals(shopSkuProductionQuantityDto.getSize().toUpperCase())){
                        listFactoryProductionOrderInfoResponse.setProductionQuantityL(shopSkuProductionQuantityDto.getProductionQuantity());
                    }else  if(SkuConstant.SkuSizeEnum.XL.equals(shopSkuProductionQuantityDto.getSize().toUpperCase())){
                        listFactoryProductionOrderInfoResponse.setProductionQuantityXL(shopSkuProductionQuantityDto.getProductionQuantity());
                    }else  if(SkuConstant.SkuSizeEnum.XXL.equals(shopSkuProductionQuantityDto.getSize().toUpperCase())){
                        listFactoryProductionOrderInfoResponse.setProductionQuantity2XL(shopSkuProductionQuantityDto.getProductionQuantity());
                    }else  {
                        sbErroEntity.append("店铺sku："+shopSkuProductionQuantityDto.getShopSku()+",尺码错误，请修改尺码");
                    }
                }
            }
        }
        PageInfo<ListFactoryProductionOrderInfoResponse> page = new PageInfo<>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2020/10/15 20:04
     */
    @Override
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer dealUserId) {
        //获取生产单
        FactoryProductionOrder factoryProductionOrder=customFactoryProductionOrderMapper.selectByPrimaryKey(params.getFactoryProductionOrderId());
        if(factoryProductionOrder==null){
            return BaseResponse.failMessage("工厂生产单id不存在");
        }
        List<ShopSku> shopSkuList=shopSkuService.getShopSkuByShopParentSkuAndSize(params.getShopParentSku(),params.getSize(),params.getColour(),factoryProductionOrder.getShopId());
        if(CollectionUtils.isEmpty(shopSkuList)){
            return BaseResponse.failMessage(String.format("店铺父sku：%s,颜色：%s，尺码：%s的店铺sku不存在",params.getShopParentSku(),params.getColour(),params.getSize()));
        }
        if(shopSkuList.size()>1){
            return BaseResponse.failMessage(String.format("店铺父sku：%s,颜色：%s，尺码：%s的店铺sku有多个",params.getShopParentSku(),params.getColour(),params.getSize()));
        }
        ShopSku shopSku=shopSkuList.get(0);
        FactoryProductionOrderShopSku factoryProductionOrderShopSku=getFactoryProductionOrderShopSku(params.getFactoryProductionOrderId(),shopSku.getShopSkuId());
        if(factoryProductionOrderShopSku==null){
            if(params.getProductionQuantity()==0){
                return BaseResponse.success();
            }
            factoryProductionOrderShopSku=new FactoryProductionOrderShopSku();
            factoryProductionOrderShopSku.setFactoryProductionOrderId(params.getFactoryProductionOrderId());
            factoryProductionOrderShopSku.setProductionQuantity(params.getProductionQuantity());
            factoryProductionOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
            factoryProductionOrderShopSku.setCreateBy(dealUserId);
            factoryProductionOrderShopSku.setCreateTime(new Date());
            customFactoryProductionOrderShopSkuMapper.insertSelective(factoryProductionOrderShopSku);
            return BaseResponse.success();
        }else{
            if(params.getProductionQuantity()==0){
                customFactoryProductionOrderShopSkuMapper.deleteByPrimaryKey(factoryProductionOrderShopSku.getId());
                return BaseResponse.success();
            }
            factoryProductionOrderShopSku.setProductionQuantity(params.getProductionQuantity());
            factoryProductionOrderShopSku.setUpdateBy(dealUserId);
            factoryProductionOrderShopSku.setUpdateTime(new Date());
            customFactoryProductionOrderShopSkuMapper.updateByPrimaryKeySelective(factoryProductionOrderShopSku);
            return BaseResponse.success();
        }
    }

    /**
     * @param shopId
     * @param currentUserId
     * @return
     * @description 创建工厂生产单
     * @author baixueping
     * @date 2020/10/28 17:02
     */
    @Override
    public BaseResponse createFactoryProductionOrder(Integer shopId, Integer currentUserId) {
        if (shopId == null) {
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_EMPTY);
        }
        if (!shopUserService.exisShopUser(shopId, currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        List<StockCart> stockCartList = stockRecordService.getStockCartListByShopId(shopId, StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
        if(CollectionUtils.isEmpty(stockCartList)){
            return BaseResponse.failMessage(StockRecordConstant.STOCK_CART_LIST_EMPTY);
        }
        //生成补货记录
        Shop shop=customShopMapper.selectByPrimaryKey(shopId);
        if(shop==null){
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_NOT_EXIST);
        }
        String  title=shop.getShopName()+"工厂生产单"+ DateUtil.getFormatDateStr(new Date());
        FactoryProductionOrder factoryProductionOrder = new FactoryProductionOrder();
        factoryProductionOrder.setStatus(FactoryProductionOrderConstant.StatusEnum.UNCONFIRMED.getStatus());
        factoryProductionOrder.setTitle(title);
        factoryProductionOrder.setShopId(shopId);
        factoryProductionOrder.setCreateBy(currentUserId);
        factoryProductionOrder.setCreateTime(new Date());
        customFactoryProductionOrderMapper.insertSelective(factoryProductionOrder);
        //生成生产单店铺sku
        for (StockCart stockCart : stockCartList) {
            FactoryProductionOrderShopSku factoryProductionOrderShopSku = new FactoryProductionOrderShopSku();
            factoryProductionOrderShopSku.setCreateBy(currentUserId);
            factoryProductionOrderShopSku.setCreateTime(new Date());
            factoryProductionOrderShopSku.setProductionQuantity(stockCart.getProductionQuantity());
            factoryProductionOrderShopSku.setShopSkuId(stockCart.getShopSkuId());
            factoryProductionOrderShopSku.setFactoryProductionOrderId(factoryProductionOrder.getId());
            customFactoryProductionOrderShopSkuMapper.insertSelective(factoryProductionOrderShopSku);
        }
        stockRecordService.deleteStockCartListByShopId(shopId,StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
        return BaseResponse.success();
    }

    /**
     * @param shopParentSku
     * @param response
     * @return
     * @description 下载工厂生产单
     * @author baixueping
     * @date 2020/10/28 19:23
     */
    @Override
    public BaseResponse downFactoryProductionOrderByShopParentSku(String shopParentSku, HttpServletResponse response) {
        return null;
    }

    private FactoryProductionOrderShopSku getFactoryProductionOrderShopSku(Integer factoryProductionOrderId, Integer shopSkuId) {
        FactoryProductionOrderShopSkuExample example=new FactoryProductionOrderShopSkuExample();
        example.createCriteria().andFactoryProductionOrderIdEqualTo(factoryProductionOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<FactoryProductionOrderShopSku> factoryProductionOrderShopSkuList=customFactoryProductionOrderShopSkuMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(factoryProductionOrderShopSkuList)){
            return null;
        }
        return factoryProductionOrderShopSkuList.get(0);
    }
}
