package com.sky.ddt.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryConstant;
import com.sky.ddt.common.constant.OrderConstant;
import com.sky.ddt.dao.custom.CustomInventoryMapper;
import com.sky.ddt.dto.inventory.request.InventoryListRequest;
import com.sky.ddt.dto.inventory.request.SaveInventoryRequest;
import com.sky.ddt.dto.inventory.response.InventoryListResponse;
import com.sky.ddt.dto.inventory.response.ShopInventoryInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Inventory;
import com.sky.ddt.entity.InventoryExample;
import com.sky.ddt.service.IInventoryService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 库存服务类
 * @date 2019/4/22 18:15
 */
@Service
public class InventoryService implements IInventoryService {
    @Autowired
    CustomInventoryMapper customInventoryMapper;

    /**
     * @param dealUserId
     * @param shopId
     * @param inventoryJson @return
     * @description 保存库存信息
     * @author baixueping
     * @date 2019/4/22 18:17
     */
    @Override
    public BaseResponse saveInventory(Integer dealUserId, Integer shopId, String inventoryJson) {
        if (StringUtils.isEmpty(inventoryJson)) {
            return BaseResponse.failMessage(InventoryConstant.INVENTORY_JSON_EMPTY);
        }
        if (shopId == null) {
            return BaseResponse.failMessage(OrderConstant.SHOP_ID_EMPTY);
        }
        List<SaveInventoryRequest> inventoryList = new ArrayList<>();
        try {
            inventoryList = JSON.parseArray(inventoryJson, SaveInventoryRequest.class);
        } catch (Exception ex) {
            return BaseResponse.failMessage(InventoryConstant.INVENTORY_JSON_ERRO);
        }
        dealInventory(dealUserId, shopId, inventoryList);
        return BaseResponse.success();
    }

    /**
     * @param params
     * @return
     * @description 库存列表查询
     * @author baixueping
     * @date 2019/4/23 9:13
     */
    @Override
    public PageInfo<InventoryListResponse> list(InventoryListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<InventoryListResponse> list = customInventoryMapper.inventoryList(params);
        PageInfo<InventoryListResponse> page = new PageInfo<InventoryListResponse>(list);
        return page;
    }

    /**
     * @param params@return
     * @description 获取店铺库存详情
     * @author baixueping
     * @date 2019/4/24 9:37
     */
    @Override
    public List<ShopInventoryInfoResponse> listShopInventoryInfo(InventoryListRequest params) {
        List<ShopInventoryInfoResponse> list = customInventoryMapper.listShopInventoryInfo(params);

        for (ShopInventoryInfoResponse shopInventoryInfoResponse :
                list) {
            Double averageDailySales=0.00;
            if(shopInventoryInfoResponse.getSalesForTheLast28Days()>0){
                Double averageDailySales7 = MathUtil.divide(shopInventoryInfoResponse.getSalesForTheLast7Days(), 7.00, 2);
                Double averageDailySales14 = MathUtil.divide(shopInventoryInfoResponse.getSalesForTheLast14Days(), 14.00, 2);
                Double averageDailySales21 = MathUtil.divide(shopInventoryInfoResponse.getSalesForTheLast21Days(), 21.00, 2);
                Double averageDailySales28 = MathUtil.divide(shopInventoryInfoResponse.getSalesForTheLast28Days(), 28.00, 2);
                averageDailySales=(averageDailySales7+averageDailySales14+averageDailySales21+averageDailySales28)/4;
            }
            if (averageDailySales==0) {
                shopInventoryInfoResponse.setReferenceSales30Days(0);
                shopInventoryInfoResponse.setReferenceSales45Days(0);
                shopInventoryInfoResponse.setReferenceSales60Days(0);
                shopInventoryInfoResponse.setReferenceSales90Days(0);
                shopInventoryInfoResponse.setRecommendedInboundQuantity30Days(0);
                shopInventoryInfoResponse.setRecommendedInboundQuantity45Days(0);
                shopInventoryInfoResponse.setRecommendedInboundQuantity60Days(0);
                shopInventoryInfoResponse.setRecommendedInboundQuantity90Days(0);
                if(shopInventoryInfoResponse.getTotalSupplyQuantity()>0){
                    shopInventoryInfoResponse.setDaysUntilStockRunsOut(365);
                }else{
                    shopInventoryInfoResponse.setDaysUntilStockRunsOut(0);
                }
                continue;
            }
            shopInventoryInfoResponse.setReferenceSales30Days(MathUtil.multiply(averageDailySales,30.00));
            shopInventoryInfoResponse.setReferenceSales45Days(MathUtil.multiply(averageDailySales,45.00));
            shopInventoryInfoResponse.setReferenceSales60Days(MathUtil.multiply(averageDailySales,60.00));
            shopInventoryInfoResponse.setReferenceSales90Days(MathUtil.multiply(averageDailySales,90.00));
            shopInventoryInfoResponse.setDaysUntilStockRunsOut(MathUtil.divide(shopInventoryInfoResponse.getTotalSupplyQuantity(), averageDailySales, 0).intValue());
            shopInventoryInfoResponse.setRecommendedInboundQuantity30Days(getRecommend(shopInventoryInfoResponse.getReferenceSales30Days(),shopInventoryInfoResponse.getTotalSupplyQuantity()));
            shopInventoryInfoResponse.setRecommendedInboundQuantity45Days(getRecommend(shopInventoryInfoResponse.getReferenceSales45Days(),shopInventoryInfoResponse.getTotalSupplyQuantity()));
            shopInventoryInfoResponse.setRecommendedInboundQuantity60Days(getRecommend(shopInventoryInfoResponse.getReferenceSales60Days(),shopInventoryInfoResponse.getTotalSupplyQuantity()));
            shopInventoryInfoResponse.setRecommendedInboundQuantity90Days(getRecommend(shopInventoryInfoResponse.getReferenceSales90Days(),shopInventoryInfoResponse.getTotalSupplyQuantity()));
        }
        return list;
    }

    private Integer getRecommend(Integer referenceSales, Integer totalSupplyQuantity) {
        if(referenceSales<=totalSupplyQuantity){
            return 0;
        }
        return referenceSales-totalSupplyQuantity;
    }

    private void dealInventory(Integer dealUserId, Integer shopId, List<SaveInventoryRequest> inventoryList) {
        for (SaveInventoryRequest saveInventoryRequest :
                inventoryList) {
            Inventory saveInventory = getInventory(shopId, saveInventoryRequest.getSellerSku());
            if (saveInventory == null) {
                saveInventory = new Inventory();
            }
            saveInventory.setShopId(shopId);
            saveInventory.setSellerSku(saveInventoryRequest.getSellerSku());
            saveInventory.setAsin(saveInventoryRequest.getAsin());
            saveInventory.setProductCondition(saveInventoryRequest.getCondition());
            saveInventory.setFnSku(saveInventoryRequest.getFnSku());
            saveInventory.setInStockSupplyQuantity(saveInventoryRequest.getInStockSupplyQuantity());
            saveInventory.setTotalSupplyQuantity(saveInventoryRequest.getTotalSupplyQuantity());
            if (saveInventoryRequest.getEarliestAvailability() != null) {
                saveInventory.setEarliestAvailabilityTimepointType(saveInventoryRequest.getEarliestAvailability().getTimepointType());
                saveInventory.setEarliestAvailabilityDatetime(saveInventoryRequest.getEarliestAvailability().getDateTime());
            }

            if (saveInventory.getId() != null) {
                saveInventory.setUpdateBy(dealUserId);
                saveInventory.setUpdateTime(new Date());
                customInventoryMapper.updateByPrimaryKey(saveInventory);
            } else {
                saveInventory.setCreateBy(dealUserId);
                customInventoryMapper.insertSelective(saveInventory);
            }
        }
    }

    Inventory getInventory(Integer shopId, String sellerSku) {
        InventoryExample example = new InventoryExample();
        example.createCriteria().andShopIdEqualTo(shopId).andSellerSkuEqualTo(sellerSku);
        List<Inventory> list = customInventoryMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
