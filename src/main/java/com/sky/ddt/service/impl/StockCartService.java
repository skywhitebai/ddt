package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.common.constant.StockRecordConstant;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dao.custom.CustomStockCartMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.stock.request.SaveStockQuantityRequest;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.StockCart;
import com.sky.ddt.entity.StockCartExample;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.IStockCartService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 备货购物车
 * @date 2019/8/21 8:48
 */
@Service
public class StockCartService implements IStockCartService {
    @Autowired
    CustomStockCartMapper customStockCartMapper;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;
    @Autowired
    IShopUserService shopUserService;

    /**
     * @param params
     * @return
     * @description 查询备货信息
     * @author baixueping
     * @date 2019/8/21 12:33
     */
    @Override
    public PageInfo<ListStockResponse> listStock(ListStockRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockResponse> list = customStockCartMapper.listStock(params);
        setListStock(list);
        PageInfo<ListStockResponse> page = new PageInfo<ListStockResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 保存补货数据
     * @author baixueping
     * @date 2019/8/22 14:58
     */
    @Override
    public BaseResponse saveStockQuantity(SaveStockQuantityRequest params, Integer currentUserId) {
        if (!StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(params.getType())
                && !StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(params.getType())
                && !StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(params.getType())) {
            return BaseResponse.failMessage(StockConsatnt.TYPE_EERO);
        }
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(params.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage(StockConsatnt.SHOP_SKU_ID_NOT_EXIST);
        }
        if (!shopUserService.exisShopUser(shopSku.getShopId(), currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        StockCart stockCart = getStockCartByShopSkuId(params.getShopSkuId(),StockConsatnt.TypeEnum.REPLENISHMENT.getType());
        if (stockCart == null) {
            if (params.getStockQuantity() == 0) {
                return BaseResponse.success();
            }
            stockCart = new StockCart();
            stockCart.setCreateBy(currentUserId);
            stockCart.setType(StockConsatnt.TypeEnum.REPLENISHMENT.getType());
            stockCart.setCreateTime(new Date());
            stockCart.setShopId(shopSku.getShopId());
            stockCart.setShopSkuId(params.getShopSkuId());
            stockCart.setStockQuantity(params.getStockQuantity());
            if (StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(params.getType())) {
                stockCart.setStockQuantityKy(params.getStockQuantity());
            } else if (StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(params.getType())) {
                stockCart.setStockQuantityKp(params.getStockQuantity());
            } else if (StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(params.getType())) {
                stockCart.setStockQuantityHy(params.getStockQuantity());
            }
            customStockCartMapper.insertSelective(stockCart);
        } else {
            stockCart.setUpdateBy(currentUserId);
            stockCart.setUpdateTime(new Date());
            if (StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(params.getType())) {
                stockCart.setStockQuantityKy(params.getStockQuantity());
            } else if (StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(params.getType())) {
                stockCart.setStockQuantityKp(params.getStockQuantity());
            } else if (StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(params.getType())) {
                stockCart.setStockQuantityHy(params.getStockQuantity());
            }
            stockCart.setStockQuantity(stockCart.getStockQuantityKy() + stockCart.getStockQuantityKp() + stockCart.getStockQuantityHy());
            if(stockCart.getStockQuantity()==0){
                customStockCartMapper.deleteByPrimaryKey(stockCart.getId());
            }else{
                customStockCartMapper.updateByPrimaryKeySelective(stockCart);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2019/9/3 10:36
     */
    @Override
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer currentUserId) {
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(params.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage(StockConsatnt.SHOP_SKU_ID_NOT_EXIST);
        }
        if (!shopUserService.exisShopUser(shopSku.getShopId(), currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        StockCart stockCart = getStockCartByShopSkuId(params.getShopSkuId(),StockConsatnt.TypeEnum.REPLENISHMENT.getType());
        if (stockCart == null) {
            if (params.getProductionQuantity() == 0) {
                return BaseResponse.success();
            }
            stockCart = new StockCart();
            stockCart.setCreateBy(currentUserId);
            stockCart.setCreateTime(new Date());
            stockCart.setType(StockConsatnt.TypeEnum.REPLENISHMENT.getType());
            stockCart.setShopId(shopSku.getShopId());
            stockCart.setShopSkuId(params.getShopSkuId());
            stockCart.setProductionQuantity(params.getProductionQuantity());
            customStockCartMapper.insertSelective(stockCart);
        } else {
            stockCart.setUpdateBy(currentUserId);
            stockCart.setUpdateTime(new Date());
            stockCart.setProductionQuantity(params.getProductionQuantity());
            if(stockCart.getProductionQuantity()==0){
                customStockCartMapper.deleteByPrimaryKey(stockCart.getId());
            }else{
                customStockCartMapper.updateByPrimaryKeySelective(stockCart);
            }
        }
        return BaseResponse.success();
    }

    private StockCart getStockCartByShopSkuId(Integer shopSkuId,Integer type) {
        StockCartExample example = new StockCartExample();
        example.createCriteria().andShopSkuIdEqualTo(shopSkuId).andTypeEqualTo(type);
        List<StockCart> list = customStockCartMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public void setListStock(List<ListStockResponse> listStock) {
        if (CollectionUtils.isEmpty(listStock)) {
            return;
        }
        for (ListStockResponse listStockResponse : listStock) {
            Double estimateAverageDailySales = MathUtil.setScale((listStockResponse.getSalesForTheLast7Days() / 7.00
                    + listStockResponse.getSalesForTheLast14Days() / 14.00
                    + listStockResponse.getSalesForTheLast21Days() / 21.00
                    + listStockResponse.getSalesForTheLast28Days() / 28.00
                    + listStockResponse.getSalesForTheLast35Days() / 35.00) / 5, 2);
            listStockResponse.setEstimateAverageDailySales(estimateAverageDailySales);
            Integer estimateSales14Days = MathUtil.setScale(estimateAverageDailySales * 14, 0).intValue();
            Integer estimateSales28Days = MathUtil.setScale(estimateAverageDailySales * 28, 0).intValue();
            Integer estimateSales42Days = MathUtil.setScale(estimateAverageDailySales * 42, 0).intValue();
            Integer estimateSales56Days = MathUtil.setScale(estimateAverageDailySales * 56, 0).intValue();
            Integer estimateSales90Days = MathUtil.setScale(estimateAverageDailySales * 90, 0).intValue();
            listStockResponse.setEstimateSales14Days(estimateSales14Days);
            listStockResponse.setEstimateSales28Days(estimateSales28Days);
            listStockResponse.setEstimateSales42Days(estimateSales42Days);
            listStockResponse.setEstimateSales56Days(estimateSales56Days);
            listStockResponse.setEstimateSales90Days(estimateSales90Days);
            listStockResponse.setEstimateCanSaleDay(getCanSaleDay(listStockResponse.getFbaTotalCanSaleQuantity(), estimateAverageDailySales));
            Integer replenishQuantity28Days = estimateSales28Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity42Days = estimateSales42Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity56Days = estimateSales56Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity90Days = estimateSales90Days - listStockResponse.getFbaTotalCanSaleQuantity();
            listStockResponse.setReplenishQuantity28Days(replenishQuantity28Days);
            listStockResponse.setReplenishQuantity42Days(replenishQuantity42Days);
            listStockResponse.setReplenishQuantity56Days(replenishQuantity56Days);
            listStockResponse.setReplenishQuantity90Days(replenishQuantity90Days);
            listStockResponse.setAbleCanSaleDay(getCanSaleDay(listStockResponse.getAfnFulfillableQuantity(), estimateAverageDailySales));
            listStockResponse.setOnTheWayQuantityCanSaleDay(getCanSaleDay(listStockResponse.getOnTheWayQuantity(), estimateAverageDailySales));
            listStockResponse.setStockQuantityCanSaleDay(getCanSaleDay(listStockResponse.getStockQuantity(), estimateAverageDailySales));
            listStockResponse.setEstimateProductionQuantity(listStockResponse.getStockQuantity()-listStockResponse.getInventoryQuantity());
        }
    }

    /**
     * @param
     * @return
     * @description 获取可以销售天数
     * @author baixueping
     * @date 2019/8/27 9:52
     */
    Double getCanSaleDay(Integer quantity, Double estimateAverageDailySales) {
        Double canSaleDay = null;
        if (estimateAverageDailySales == 0) {
            if (quantity > 0) {
                canSaleDay = 365.00;
            } else {
                canSaleDay = 0.00;
            }
        } else {
            canSaleDay = MathUtil.setScale((quantity / estimateAverageDailySales), 2);
        }
        return canSaleDay;
    }
}
