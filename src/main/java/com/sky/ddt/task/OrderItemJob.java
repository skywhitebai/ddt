package com.sky.ddt.task;

import com.alibaba.fastjson.JSON;
import com.amazon.spapi.api.OrdersV0Api;
import com.amazon.spapi.client.ApiException;
import com.amazon.spapi.model.orders.GetOrderItemsResponse;
import com.amazon.spapi.model.orders.OrderItem;
import com.amazon.spapi.model.orders.OrderItemList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomAmazonOrderItemMapper;
import com.sky.ddt.dao.custom.CustomAmazonOrderMapper;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.entity.*;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.service.amazon.IAmazonAuthService;
import com.sky.ddt.service.amazon.IAmazonSyncInfoService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class OrderItemJob {
    @Autowired
    IAmazonAuthService amazonAuthService;
    @Autowired
    IAmazonSyncInfoService amazonSyncInfoService;
    @Autowired
    CustomAmazonOrderMapper customAmazonOrderMapper;
    @Autowired
    CustomAmazonOrderItemMapper customAmazonOrderItemMapper;
    //@Scheduled(cron = "0 0/10 * * * ?")
    public void scheduled() {
        //获取获取订单信息
        log.info("{}，获取订单商品信息", DateUtil.getFormatDateStr(new Date()));
        List<AmazonAuth> amazonAuthList = amazonAuthService.listAmazonAuth();
        //获取店铺信息 遍历店铺信息
        for (AmazonAuth amazonAuth:
                amazonAuthList) {
            if (StringUtils.isEmpty(amazonAuth.getMarketplaceId())) {
                continue;
            }
            log.info("{}，获取店铺{}的订单商品信息", DateUtil.getFormatDateStr(new Date()),amazonAuth.getMerchantId());
            try {
                syncOrderItemInfo(amazonAuth);
            } catch (ApiException e) {
                if(AmazonConfig.INSTANCE.getLimitErroCode().equals(e.getCode())){
                    log.info("OrderItemJob fail,limit max,e:{}",e.getResponseBody());
                    continue;
                }
                log.info("OrderItemJob fail,e:{}", JSON.toJSONString(e));
                e.printStackTrace();
                continue;
            }
        }
    }

    private void syncOrderItemInfo(AmazonAuth amazonAuth) throws ApiException {
        OrdersV0Api ordersV0Api = OrderV0ApiUtil.getOrdersV0Api(amazonAuth);
        //获取一批需要同步的订单信息
        PageInfo<AmazonOrder> amazonOrderPage=getAmazonOrderPage(amazonAuth);
        if (amazonOrderPage.getTotal()==0) {
            return;
        }
        dealOrderItemInfo(ordersV0Api, amazonAuth, amazonOrderPage);
    }

    private void dealOrderItemInfo(OrdersV0Api ordersV0Api, AmazonAuth amazonAuth, PageInfo<AmazonOrder> amazonOrderPage) throws ApiException {
        for (AmazonOrder amazonOrder :amazonOrderPage.getList()) {
            saveOrderItemsInfo(ordersV0Api,amazonOrder.getAmazonOrderId(),"");
            //修改状态为已同步
            AmazonOrder amazonOrderUpdate=new AmazonOrder();
            amazonOrderUpdate.setId(amazonOrder.getId());
            amazonOrderUpdate.setSyncOrderItemStatus(YesOrNoEnum.YES.getValue());
            customAmazonOrderMapper.updateByPrimaryKeySelective(amazonOrderUpdate);
        }
        if(amazonOrderPage.isHasNextPage()){
            dealOrderItemInfo(ordersV0Api, amazonAuth, amazonOrderPage);
        }
    }

    private void saveOrderItemsInfo(OrdersV0Api ordersV0Api, String amazonOrderId, String nextToken) throws ApiException {
        GetOrderItemsResponse response = ordersV0Api.getOrderItems(amazonOrderId, nextToken);
        OrderItemList orderItems = response.getPayload().getOrderItems();
        if (CollectionUtils.isEmpty(orderItems)) {
            return;
        }
        orderItems.forEach(orderItem -> {
            AmazonOrderItem amazonOrderItem=getAmazonOrderItem(amazonOrderId,orderItem.getOrderItemId());
            if(amazonOrderItem==null){
                amazonOrderItem=new AmazonOrderItem();
                setAmazonOrderItem(orderItem,amazonOrderItem);
                amazonOrderItem.setAmazonOrderId(amazonOrderId);
                amazonOrderItem.setCreateTime(new Date());
                customAmazonOrderItemMapper.insertSelective(amazonOrderItem);
            }else{
                setAmazonOrderItem(orderItem,amazonOrderItem);
                amazonOrderItem.setUpdateTime(new Date());
                customAmazonOrderItemMapper.updateByPrimaryKeySelective(amazonOrderItem);
            }
        });
        if (response.getPayload().getNextToken() == null) {
            return;
        }
        saveOrderItemsInfo(ordersV0Api, amazonOrderId, nextToken);
    }
    private AmazonOrderItem getAmazonOrderItem(String amazonOrderId, String orderItemId) {
        AmazonOrderItemExample example=new AmazonOrderItemExample();
        example.createCriteria().andAmazonOrderIdEqualTo(amazonOrderId).andOrderItemIdEqualTo(orderItemId);
        List<AmazonOrderItem> orderItemList=customAmazonOrderItemMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(orderItemList)){
            return null;
        }
        return orderItemList.get(0);
    }
    private PageInfo<AmazonOrder> getAmazonOrderPage(AmazonAuth amazonSyncInfo) {
        PageHelper.startPage(1, 25);
        AmazonOrderExample example=new AmazonOrderExample();
        AmazonOrderExample.Criteria criteria=example.createCriteria();
        criteria.andMerchantIdEqualTo(amazonSyncInfo.getMerchantId()).andSyncOrderItemStatusEqualTo(YesOrNoEnum.NO.getValue());
        example.setOrderByClause("sync_time asc");
        List<AmazonOrder> amazonOrderList=customAmazonOrderMapper.selectByExample(example);
        PageInfo<AmazonOrder> pageInfo = new PageInfo<>(amazonOrderList);
        return pageInfo;
    }
    private void setAmazonOrderItem(OrderItem orderItem, AmazonOrderItem amazonOrderItem) {
        BeanUtils.copyProperties(orderItem,amazonOrderItem);
        amazonOrderItem.setSellerSku(orderItem.getSellerSKU());
        amazonOrderItem.setAsin(orderItem.getASIN());
        if(orderItem.getProductInfo()!=null){
            amazonOrderItem.setNumberOfItems(orderItem.getProductInfo().getNumberOfItems());
        }
        if(orderItem.getPointsGranted()!=null){
            amazonOrderItem.setPointsNumber(orderItem.getPointsGranted().getPointsNumber());
        }
        if(orderItem.getItemPrice()!=null){
            amazonOrderItem.setItemPriceAmount(MathUtil.strToBigDecimal(orderItem.getItemPrice().getAmount()));
            amazonOrderItem.setItemPriceCurrencyCode(orderItem.getItemPrice().getCurrencyCode());
        }
        if(orderItem.getShippingPrice()!=null){
            amazonOrderItem.setShippingPriceAmount(MathUtil.strToBigDecimal(orderItem.getShippingPrice().getAmount()));
            amazonOrderItem.setShippingPriceCurrencyCode(orderItem.getShippingPrice().getCurrencyCode());
        }
        if(orderItem.getItemTax()!=null){
            amazonOrderItem.setItemTaxAmount(MathUtil.strToBigDecimal(orderItem.getItemTax().getAmount()));
            amazonOrderItem.setItemTaxCurrencyCode(orderItem.getItemTax().getCurrencyCode());
        }
        if(orderItem.getShippingTax()!=null){
            amazonOrderItem.setShippingTaxAmount(MathUtil.strToBigDecimal(orderItem.getShippingTax().getAmount()));
            amazonOrderItem.setShippingTaxCurrencyCode(orderItem.getShippingTax().getCurrencyCode());
        }
        if(orderItem.getShippingDiscount()!=null){
            amazonOrderItem.setShippingDiscountAmount(MathUtil.strToBigDecimal(orderItem.getShippingDiscount().getAmount()));
            amazonOrderItem.setShippingDiscountCurrencyCode(orderItem.getShippingDiscount().getCurrencyCode());
        }
        if(orderItem.getShippingDiscountTax()!=null){
            amazonOrderItem.setShippingDiscountTaxAmount(MathUtil.strToBigDecimal(orderItem.getShippingDiscountTax().getAmount()));
            amazonOrderItem.setShippingDiscountTaxCurrencyCode(orderItem.getShippingDiscountTax().getCurrencyCode());
        }
        if(orderItem.getPromotionDiscount()!=null){
            amazonOrderItem.setPromotionDiscountAmount(MathUtil.strToBigDecimal(orderItem.getPromotionDiscount().getAmount()));
            amazonOrderItem.setPromotionDiscountCurrencyCode(orderItem.getPromotionDiscount().getCurrencyCode());
        }
        if(orderItem.getPromotionDiscountTax()!=null){
            amazonOrderItem.setPromotionDiscountTaxAmount(MathUtil.strToBigDecimal(orderItem.getPromotionDiscountTax().getAmount()));
            amazonOrderItem.setPromotionDiscountTaxCurrencyCode(orderItem.getPromotionDiscountTax().getCurrencyCode());
        }
        if(!CollectionUtils.isEmpty(orderItem.getPromotionIds())){
            amazonOrderItem.setPromotionIdList(String.join(",",orderItem.getPromotionIds()));
        }
        if(orderItem.getCoDFee()!=null){
            amazonOrderItem.setCoDFeeAmount(MathUtil.strToBigDecimal(orderItem.getCoDFee().getAmount()));
            amazonOrderItem.setCoDFeeCurrencyCode(orderItem.getCoDFee().getCurrencyCode());
        }
        if(orderItem.getCoDFeeDiscount()!=null){
            amazonOrderItem.setCoDFeeDiscountAmount(MathUtil.strToBigDecimal(orderItem.getCoDFeeDiscount().getAmount()));
            amazonOrderItem.setCoDFeeDiscountCurrencyCode(orderItem.getCoDFeeDiscount().getCurrencyCode());
        }
        amazonOrderItem.setIsGift(orderItem.isIsGift());
        if(orderItem.getTaxCollection()!=null){
            amazonOrderItem.setTaxCollectionModel(orderItem.getTaxCollection().getModel().getValue());
            amazonOrderItem.setTaxCollectionResponsibleParty(orderItem.getTaxCollection().getResponsibleParty().getValue());
        }
        amazonOrderItem.setSerialNumberRequired(orderItem.isSerialNumberRequired());
        amazonOrderItem.setIsTransparency(orderItem.isIsTransparency());
        amazonOrderItem.setIossNumber(orderItem.getIossNumber());
        if(orderItem.getItemPrice()!=null){
            amazonOrderItem.setItemPriceAmount(MathUtil.strToBigDecimal(orderItem.getItemPrice().getAmount()));
            amazonOrderItem.setItemPriceCurrencyCode(orderItem.getItemPrice().getCurrencyCode());
        }

     }
}
