package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ResponseConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.ShopConstant;
import com.sky.ddt.common.constant.ShopHeadTripCostConstant;
import com.sky.ddt.dao.custom.CustomShopHeadTripCostMapper;
import com.sky.ddt.dao.custom.CustomShopSkuHeadTripCostHisMapper;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.request.CreateShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.ListShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.SaveShopHeadTripCostRemarkRequest;
import com.sky.ddt.dto.shopHeadTripCost.response.FbaShopSkuHeadTripCostInfo;
import com.sky.ddt.dto.shopHeadTripCost.response.ListShopHeadTripCostResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuHeadTripCostInfo;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuInventoryDetails;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IInventoryDetailsService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺头程费服务类
 * @date 2020/8/13 18:29
 */
@Service
public class ShopHeadTripCostService implements IShopHeadTripCostService {
    @Autowired
    CustomShopHeadTripCostMapper customShopHeadTripCostMapper;
    @Autowired
    IShopService shopService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    IInternalOrderNumberTransportService internalOrderNumberTransportService;
    @Autowired
    IInventoryDetailsService inventoryDetailsService;
    @Autowired
    IFbaPackingListShopSkuService fbaPackingListShopSkuService;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;
    @Autowired
    CustomShopSkuHeadTripCostHisMapper customShopSkuHeadTripCostHisMapper;
    @Autowired
    IShopUserService shopUserService;

    /**
     * @param params@return
     * @description 分页查询店铺头程费
     * @author baixueping
     * @date 2020/8/13 19:09
     */
    @Override
    public PageInfo<ListShopHeadTripCostResponse> listShopHeadTripCost(ListShopHeadTripCostRequest params) {
        if (!StringUtils.isEmpty(params.getMonth())) {
            Date monthDate = DateUtil.strMonthToDate(params.getMonth());
            if (monthDate != null) {
                params.setMonthDate(monthDate);
            }
        }
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListShopHeadTripCostResponse> list = customShopHeadTripCostMapper.listShopHeadTripCost(params);
        PageInfo<ListShopHeadTripCostResponse> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveShopHeadTripCostRemark(SaveShopHeadTripCostRemarkRequest params, Integer dealUserId) {
        ShopHeadTripCost shopHeadTripCost = new ShopHeadTripCost();
        shopHeadTripCost.setId(params.getId());
        shopHeadTripCost.setRemark(params.getRemark());
        customShopHeadTripCostMapper.updateByPrimaryKeySelective(shopHeadTripCost);
        return BaseResponse.success();
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 创建店铺头程费信息
     * @author baixueping
     * @date 2020/8/14 13:00
     */
    @Override
    public BaseResponse createShopHeadTripCost(CreateShopHeadTripCostRequest params, Integer dealUserId) {
        //校验参数
        if (params.getShopId() == null) {
            return BaseResponse.failMessage(ShopHeadTripCostConstant.SHOP_ID_EMPTY);
        } else {
            Shop shop = shopService.getShop(params.getShopId());
            if (shop == null) {
                return BaseResponse.failMessage(ShopHeadTripCostConstant.SHOP_ID_NOT_EXIST);
            }else if(!shopUserService.exisShopUser(shop.getShopId(),dealUserId)){
                return BaseResponse.failMessage(ShopConstant.USER_NO_SHOP_RIGHT);
            }
        }
        if (params.getType() == null) {
            return BaseResponse.failMessage(ShopHeadTripCostConstant.TYPE_EMPTY);
        }
        if (StringUtils.isEmpty(params.getMonth())) {
            return BaseResponse.failMessage(ShopHeadTripCostConstant.MONTH_EMPTY);
        } else {
            Date monthDate = DateUtil.strMonthToDate(params.getMonth());
            if (monthDate != null) {
                params.setMonthDate(monthDate);
                Date monthNow = DateUtil.getMonthFirstDay(new Date());
                if (!monthDate.before(monthNow)) {
                    return BaseResponse.failMessage(ShopHeadTripCostConstant.MONTH_MUST_BEFORE_MONTH_NOW);
                }
            } else {
                return BaseResponse.failMessage(ShopHeadTripCostConstant.MONTH_ERRO);
            }
        }
        //校验是否已生成
        ShopHeadTripCostExample example = new ShopHeadTripCostExample();
        example.createCriteria().andShopIdEqualTo(params.getShopId()).andMonthEqualTo(params.getMonthDate());
        if (customShopHeadTripCostMapper.countByExample(example) > 0) {
            return BaseResponse.failMessage(ShopHeadTripCostConstant.SHOP_HEAD_TRIP_COST_EXIST);
        }
        Date lastMonthDate = DateUtil.plusMonth(-1, params.getMonthDate());
        Finance finance = financeService.getFinance(params.getShopId(), lastMonthDate);
        //校验数据是否完整
        if (!ShopHeadTripCostConstant.CreateTypeEnum.UN_CHECK.getType().equals(params.getType())) {
            // 店铺所有sku的头程费
            SbErroEntity sbErroEntity = new SbErroEntity();
            if (shopSkuService.existWithoutHeadTripCostShopSku(params.getShopId())) {
                sbErroEntity.append(ShopHeadTripCostConstant.EXIST_WITHOUT_HEAD_TRIP_COST_SHOP_SKU);
            }
            if (shopSkuService.existWithoutWeightShopSku(params.getShopId())) {
                sbErroEntity.append(ShopHeadTripCostConstant.EXIST_WITHOUT_WEIGHT_SHOP_SKU);
            }
            // 店铺上个月的库存明细
            if (finance == null || !finance.getInventoryDetails()) {
                sbErroEntity.append(String.format(ShopHeadTripCostConstant.LAST_MONTH_INVENTORY_DETAILS_NOT_EXIST, DateUtil.getFormatYearMonth(lastMonthDate)));
            }
            // 店铺当月fba出库单的头程费率
            if (internalOrderNumberTransportService.existHeadTripCostRateNull(params.getShopId(), params.getMonthDate())) {
                sbErroEntity.append(ShopHeadTripCostConstant.EXIST_HEAD_TRIP_COST_RATE_NULL);
            }
            if (sbErroEntity.isFail()) {
                return BaseResponse.fail("301", sbErroEntity.getMessage()+",请完善信息后再生成店铺头程费");
            }
        }
        //添加店铺头程费信息
        ShopHeadTripCost shopHeadTripCost = addShopHeadTripCost(params, dealUserId);
        List<ShopSkuInventoryDetails> shopSkuInventoryDetailsList = new ArrayList<>();
        if (finance != null) {
            shopSkuInventoryDetailsList = inventoryDetailsService.listShopSkuInventoryDetails(finance.getId());
        }
        List<FbaShopSkuHeadTripCostInfo> fbaShopSkuHeadTripCostInfoList = fbaPackingListShopSkuService.listFbaShopSkuHeadTripCostInfo(params.getShopId(), params.getMonthDate());
        //循环获取店铺sku
        List<ShopSkuHeadTripCostInfo> shopSkuList = shopSkuService.listNotExistShopSkuHeadTripCost(params.getShopId(), params.getMonthDate());
        while (!CollectionUtils.isEmpty(shopSkuList)) {
            //循环计算头程费
            for (ShopSkuHeadTripCostInfo shopSkuHeadTripCostInfo :
                    shopSkuList) {
                //获取上个月库存
                BaseResponse<Integer> quantityResponse = getQuantity(shopSkuHeadTripCostInfo.getShopSkuId(), shopSkuInventoryDetailsList, lastMonthDate);
                Integer quantity = 0;
                SbErroEntity sbErroEntity = new SbErroEntity();
                if (shopSkuHeadTripCostInfo.getHeadTripCost() == null) {
                    sbErroEntity.append(ShopHeadTripCostConstant.SHOP_SKU_WITHOUT_HEAD_TRIP_COST);
                }
                if (shopSkuHeadTripCostInfo.getWeight() == null) {
                    sbErroEntity.append(ShopHeadTripCostConstant.SHOP_SKU_WEIGHT_NULL);
                }
                if (quantityResponse.isSuccess()) {
                    quantity = quantityResponse.getData();
                } else {
                    sbErroEntity.append(quantityResponse.getMessage());
                }
                //获取fba出库头程费信息
                BaseResponse<List<FbaShopSkuHeadTripCostInfo>> fbaShopSkuHeadTripCostInfoResponse = getfbaShopSkuHeadTripCostInfo(shopSkuHeadTripCostInfo.getShopSkuId(), fbaShopSkuHeadTripCostInfoList);
                if (!StringUtils.isEmpty(fbaShopSkuHeadTripCostInfoResponse.getMessage())
                        &&!fbaShopSkuHeadTripCostInfoResponse.getMessage().equals(ResponseConstant.SUCCESS_MESSAGE)) {
                    sbErroEntity.append(fbaShopSkuHeadTripCostInfoResponse.getMessage());
                }
                ShopSkuHeadTripCostHis shopSkuHeadTripCostHis = new ShopSkuHeadTripCostHis();
                shopSkuHeadTripCostHis.setCreateBy(dealUserId);
                shopSkuHeadTripCostHis.setCreateTime(new Date());
                shopSkuHeadTripCostHis.setHeadTripCostBefore(shopSkuHeadTripCostInfo.getHeadTripCost());
                shopSkuHeadTripCostHis.setShopHeadTripCostId(shopHeadTripCost.getId());
                shopSkuHeadTripCostHis.setShopSkuId(shopSkuHeadTripCostInfo.getShopSkuId());
                shopSkuHeadTripCostHis.setCreateRemark(sbErroEntity.getMessage());
                //计算头程费
                setHeadTripCost(shopSkuHeadTripCostHis, quantity, shopSkuHeadTripCostInfo, fbaShopSkuHeadTripCostInfoResponse.getData());
                //将头程费写入shopsku
                ShopSku shopSkuUpdate = new ShopSku();
                shopSkuUpdate.setShopSkuId(shopSkuHeadTripCostHis.getShopSkuId());
                shopSkuUpdate.setHeadTripCost(shopSkuHeadTripCostHis.getHeadTripCostAfter());
                shopSkuUpdate.setUpdateBy(dealUserId);
                shopSkuUpdate.setUpdateTime(new Date());
                customShopSkuMapper.updateByPrimaryKeySelective(shopSkuUpdate);
                //将头程费保存进入头程费历史表
                customShopSkuHeadTripCostHisMapper.insertSelective(shopSkuHeadTripCostHis);
            }
            shopSkuList = shopSkuService.listNotExistShopSkuHeadTripCost(params.getShopId(), params.getMonthDate());
        }
        //生成数据后要锁定发货信息的头程费率
        internalOrderNumberTransportService.lockHeadTripCostRate(params.getShopId(), params.getMonthDate());
        return BaseResponse.success();
    }

    private void setHeadTripCost(ShopSkuHeadTripCostHis shopSkuHeadTripCostHis, Integer quantity, ShopSkuHeadTripCostInfo shopSkuHeadTripCostInfo, List<FbaShopSkuHeadTripCostInfo> data) {
        BigDecimal totalHeadTripCost = BigDecimal.ZERO;
        BigDecimal fbaHeadTripCost = BigDecimal.ZERO;
        Integer totalQuantity = 0;
        Integer fbaSendQuantity = 0;
        if (quantity != null && quantity != 0) {
            totalQuantity += quantity;
            if (shopSkuHeadTripCostInfo.getHeadTripCost() != null) {
                totalHeadTripCost=totalHeadTripCost.add(shopSkuHeadTripCostInfo.getHeadTripCost().multiply(new BigDecimal(quantity)));
            }
        }
        if (!CollectionUtils.isEmpty(data) && shopSkuHeadTripCostInfo.getWeight() != null) {
            for (FbaShopSkuHeadTripCostInfo fbaShopSkuHeadTripCostInfo : data) {
                fbaSendQuantity += fbaShopSkuHeadTripCostInfo.getQuantity();
                fbaHeadTripCost=fbaHeadTripCost.add(fbaShopSkuHeadTripCostInfo.getHeadTripCostRate().multiply(shopSkuHeadTripCostInfo.getWeight()).multiply(new BigDecimal(fbaShopSkuHeadTripCostInfo.getQuantity())));
            }
        }
        totalHeadTripCost=totalHeadTripCost.add(fbaHeadTripCost);
        totalQuantity=totalQuantity+fbaSendQuantity;
        BigDecimal headTripCost = BigDecimal.ZERO;


        //如果所有库存都为0，则返回原来的数量
        if (totalQuantity==0) {
            headTripCost = shopSkuHeadTripCostInfo.getHeadTripCost();
        } else {
            headTripCost = totalHeadTripCost.divide(new BigDecimal(totalQuantity), 2, RoundingMode.HALF_UP);
        }
        shopSkuHeadTripCostHis.setHeadTripCostAfter(headTripCost);
        shopSkuHeadTripCostHis.setTotalHeadTripCost(totalHeadTripCost);
        shopSkuHeadTripCostHis.setInventoryQuantity(quantity);
        shopSkuHeadTripCostHis.setFbaSendQuantity(fbaSendQuantity);
        shopSkuHeadTripCostHis.setFbaHeadTripCost(fbaHeadTripCost);
    }

    private BaseResponse<List<FbaShopSkuHeadTripCostInfo>> getfbaShopSkuHeadTripCostInfo(Integer shopSkuId, List<FbaShopSkuHeadTripCostInfo> fbaShopSkuHeadTripCostInfoList) {
        List<FbaShopSkuHeadTripCostInfo> fbaShopSkuHeadTripCostInfos = new ArrayList<>();
        Boolean existHeadTripCostRateNull = false;
        if (CollectionUtils.isEmpty(fbaShopSkuHeadTripCostInfoList)) {
            return BaseResponse.successData(fbaShopSkuHeadTripCostInfos);
        }
        for (FbaShopSkuHeadTripCostInfo fbaShopSkuHeadTripCostInfo :
                fbaShopSkuHeadTripCostInfoList) {
            if (fbaShopSkuHeadTripCostInfo.getShopSkuId().equals(shopSkuId)) {
                if (fbaShopSkuHeadTripCostInfo.getHeadTripCostRate() != null) {
                    fbaShopSkuHeadTripCostInfos.add(fbaShopSkuHeadTripCostInfo);
                } else {
                    existHeadTripCostRateNull = true;
                }
            } else if (fbaShopSkuHeadTripCostInfo.getShopSkuId() > shopSkuId) {
                break;
            }
        }
        BaseResponse baseResponse = BaseResponse.successData(fbaShopSkuHeadTripCostInfos);
        if (existHeadTripCostRateNull) {
            baseResponse.setMessage(ShopHeadTripCostConstant.SHOP_SKU_HEAD_TRIP_COST_RATE_NULL);
        }
        return baseResponse;
    }

    //快速获取
    private BaseResponse<Integer> getQuantity(Integer shopSkuId, List<ShopSkuInventoryDetails> shopSkuInventoryDetailsList, Date lastMonthDate) {
        if (CollectionUtils.isEmpty(shopSkuInventoryDetailsList)) {
            return BaseResponse.failMessage(String.format(ShopHeadTripCostConstant.LAST_MONTH_SHOP_SKU_INVENTORY_DETAILS_NOT_EXIST, DateUtil.getFormatYearMonth(lastMonthDate)));
        }
        //已排序，可以简单来
        for (ShopSkuInventoryDetails shopSkuInventoryDetails : shopSkuInventoryDetailsList) {
            if (shopSkuInventoryDetails.getShopSkuId().equals(shopSkuId)) {
                shopSkuInventoryDetailsList.remove(shopSkuInventoryDetails);
                return BaseResponse.successData(shopSkuInventoryDetails.getQuantity());
            } else if (shopSkuInventoryDetails.getShopSkuId() > shopSkuId) {
                return BaseResponse.failMessage(String.format(ShopHeadTripCostConstant.LAST_MONTH_SHOP_SKU_INVENTORY_DETAILS_NOT_EXIST, DateUtil.getFormatYearMonth(lastMonthDate)));
            }
        }
        return BaseResponse.failMessage(String.format(ShopHeadTripCostConstant.LAST_MONTH_SHOP_SKU_INVENTORY_DETAILS_NOT_EXIST, DateUtil.getFormatYearMonth(lastMonthDate)));
    }

    private ShopHeadTripCost addShopHeadTripCost(CreateShopHeadTripCostRequest params, Integer dealUserId) {
        ShopHeadTripCost shopHeadTripCost = new ShopHeadTripCost();
        shopHeadTripCost.setCreateBy(dealUserId);
        shopHeadTripCost.setCreateRemark(params.getCreateRemark());
        shopHeadTripCost.setCreateTime(new Date());
        shopHeadTripCost.setMonth(params.getMonthDate());
        shopHeadTripCost.setShopId(params.getShopId());
        customShopHeadTripCostMapper.insertSelective(shopHeadTripCost);
        return shopHeadTripCost;
    }

}
