package com.sky.ddt.task;

import com.alibaba.fastjson.JSON;
import com.amazon.spapi.api.OrdersV0Api;
import com.amazon.spapi.client.ApiException;
import com.amazon.spapi.model.orders.GetOrdersResponse;
import com.amazon.spapi.model.orders.Order;
import com.amazon.spapi.model.orders.OrdersList;
import com.sky.ddt.dao.custom.CustomAmazonAuthMapper;
import com.sky.ddt.dao.custom.CustomAmazonOrderItemMapper;
import com.sky.ddt.dao.custom.CustomAmazonOrderMapper;
import com.sky.ddt.dao.custom.CustomAmazonSyncInfoMapper;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.entity.*;
import com.sky.ddt.common.enums.AmazonSyncInfoTypeEnum;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.service.amazon.IAmazonAuthService;
import com.sky.ddt.service.amazon.IAmazonSyncInfoService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class OrdersJob {
    @Autowired
    CustomAmazonAuthMapper customAmazonAuthMapper;
    @Autowired
    CustomAmazonOrderMapper customAmazonOrderMapper;
    @Autowired
    IAmazonSyncInfoService amazonSyncInfoService;
    @Autowired
    CustomAmazonSyncInfoMapper customAmazonSyncInfoMapper;
    @Autowired
    CustomAmazonOrderItemMapper customAmazonOrderItemMapper;
    @Autowired
    IAmazonAuthService amazonAuthService;

    @Scheduled(cron = "0 0/10 * * * ?")
    //@Scheduled(cron = "0/2 * * * * ?")
    public void scheduled() {
        //获取获取订单信息
        log.info("{}，获取订单信息", DateUtil.getFormatDateStr(new Date()));
        List<AmazonAuth> amazonAuthList = amazonAuthService.listAmazonAuth();
        //获取店铺信息 遍历店铺信息
        for (AmazonAuth amazonAuth :
                amazonAuthList) {
            if (StringUtils.isEmpty(amazonAuth.getMarketplaceId())) {
                continue;
            }
            log.info("{}，获取店铺{}的订单信息", DateUtil.getFormatDateStr(new Date()),amazonAuth.getMarketplaceId());
            try {
                syncOrderInfo(amazonAuth);
            } catch (ApiException e) {
                if(AmazonConfig.INSTANCE.getLimitErroCode().equals(e.getCode())){
                    log.info("OrdersJob fail,limit max,e:{}",e.getResponseBody());
                    continue;
                }
                log.info("OrdersJob fail,e:{}", JSON.toJSONString(e));
                e.printStackTrace();
                continue;
            }
        }
    }

    private void syncOrderInfo(AmazonAuth amazonAuth) throws ApiException {
        OrdersV0Api ordersV0Api = OrderV0ApiUtil.getOrdersV0Api(amazonAuth);
        AmazonSyncInfo amazonSyncInfo = amazonSyncInfoService.getAmazonSyncInfo(AmazonSyncInfoTypeEnum.ORDER, amazonAuth.getMerchantId());
        GetOrdersResponse response = getOrders(amazonAuth, ordersV0Api, amazonSyncInfo);
        if (response == null) {
            return;
        }
        dealOrderInfo(ordersV0Api, amazonAuth, response.getPayload(), amazonSyncInfo);
    }

    private GetOrdersResponse getOrders(AmazonAuth amazonAuth, OrdersV0Api ordersV0Api, AmazonSyncInfo amazonSyncInfo) throws ApiException {
        GetOrdersResponse response = null;

        List<String> marketplaceIds = new ArrayList<>();
        marketplaceIds.add(amazonAuth.getMarketplaceId());
        String createdAfter = null;
        String createdBefore = null;
        String lastUpdatedAfter = null;
        String nextToken = null;
        if (StringUtils.isEmpty(amazonSyncInfo.getNextToken())) {
            lastUpdatedAfter = DateUtil.dateTimeToUtczStr(amazonSyncInfo.getLastUpdateAfter());
        } else {
            nextToken = amazonSyncInfo.getNextToken();
        }
        String lastUpdatedBefore = null;
        List<String> orderStatuses = null;
        List<String> fulfillmentChannels = null;
        List<String> paymentMethods = null;
        String buyerEmail = null;
        String sellerOrderId = null;
        Integer maxResultsPerPage = null;
        List<String> easyShipShipmentStatuses = null;
        List<String> amazonOrderIds = null;
        response = ordersV0Api.getOrders(marketplaceIds, createdAfter, createdBefore, lastUpdatedAfter, lastUpdatedBefore, orderStatuses, fulfillmentChannels, paymentMethods, buyerEmail, sellerOrderId, maxResultsPerPage, easyShipShipmentStatuses, nextToken, amazonOrderIds);
        return response;
    }

    private void dealOrderInfo(OrdersV0Api ordersV0Api, AmazonAuth amazonAuth, OrdersList ordersList, AmazonSyncInfo amazonSyncInfo) throws ApiException {
        if (CollectionUtils.isEmpty(ordersList.getOrders())) {
            return;
        }
        log.info("dealTime:{},dealOrderInfo orderSize:{},nextToken:{}", DateUtil.getFormatSSS(new Date()), ordersList.getOrders().size(), ordersList.getNextToken());
        ordersList.getOrders().forEach(order -> {
            AmazonOrder amazonOrder = getAmazonOrderByAmazonOrderId(order.getAmazonOrderId());
            if (amazonOrder == null) {
                amazonOrder = new AmazonOrder();
                amazonOrder.setMerchantId(amazonAuth.getMerchantId());
                setAmazonOrderInfo(amazonOrder, order);
                amazonOrder.setCreateTime(new Date());
                amazonOrder.setUpdateTime(new Date());
                customAmazonOrderMapper.insertSelective(amazonOrder);
            } else {
                setAmazonOrderInfo(amazonOrder, order);
                amazonOrder.setUpdateTime(new Date());
                customAmazonOrderMapper.updateByPrimaryKeySelective(amazonOrder);
            }
        });
        if (StringUtils.isEmpty(ordersList.getNextToken())) {
            //没有nextToken表示同步完成
            amazonSyncInfo.setLastUpdateAfter(DateUtil.utczStrToDateTime(ordersList.getLastUpdatedBefore()));
            amazonSyncInfo.setNextToken(null);
            amazonSyncInfo.setUpdateTime(new Date());
            customAmazonSyncInfoMapper.updateByPrimaryKey(amazonSyncInfo);
        } else {
            amazonSyncInfo.setNextToken(ordersList.getNextToken());
            amazonSyncInfo.setUpdateTime(new Date());
            customAmazonSyncInfoMapper.updateByPrimaryKey(amazonSyncInfo);
            //获取下页
            GetOrdersResponse response = getOrders(amazonAuth, ordersV0Api, amazonSyncInfo);
            if (response == null) {
                return;
            }
            dealOrderInfo(ordersV0Api, amazonAuth, response.getPayload(), amazonSyncInfo);
        }
    }


    private void setAmazonOrderInfo(AmazonOrder amazonOrder, Order order) {
        amazonOrder.setMarketplaceId(order.getMarketplaceId());
        amazonOrder.setAmazonOrderId(order.getAmazonOrderId());
        amazonOrder.setSellerOrderId(order.getSellerOrderId());
        amazonOrder.setPurchaseDate(DateUtil.utcStrToDateTime(order.getPurchaseDate()));
        amazonOrder.setLastUpdateDate(DateUtil.utcStrToDateTime(order.getLastUpdateDate()));
        amazonOrder.setOrderDate(DateUtil.dateTimeToDate(amazonOrder.getPurchaseDate()));
        if (order.getOrderStatus() != null) {
            amazonOrder.setOrderStatus(order.getOrderStatus().getValue());
        }
        if (order.getOrderType() != null) {
            amazonOrder.setOrderType(order.getOrderType().getValue());
        }
        if (order.getFulfillmentChannel() != null) {
            amazonOrder.setFulfillmentChannel(order.getFulfillmentChannel().getValue());
        }
        amazonOrder.setSalesChannel(order.getSalesChannel());
        amazonOrder.setOrderChannel(order.getOrderChannel());
        amazonOrder.setShipServiceLevel(order.getShipServiceLevel());
        amazonOrder.setShipmentServiceLevelCategory(order.getShipmentServiceLevelCategory());
        if (order.getOrderTotal() != null) {
            amazonOrder.setCurrency(order.getOrderTotal().getCurrencyCode());
            amazonOrder.setTotalAmount(MathUtil.strToBigDecimal(order.getOrderTotal().getAmount()));
        }
        amazonOrder.setNumberOfItemsShipped(order.getNumberOfItemsShipped());
        amazonOrder.setNumberOfItemsUnshipped(order.getNumberOfItemsUnshipped());
        amazonOrder.setPaymentExecutionDetail(JSON.toJSONString(order.getPaymentExecutionDetail()));
        if (order.getPaymentMethod() != null) {
            amazonOrder.setPaymentMethod(order.getPaymentMethod().getValue());
        }
        amazonOrder.setEasyShipShipmentStatus(order.getEasyShipShipmentStatus());
        amazonOrder.setEarliestShipDate(DateUtil.utcStrToDateTime(order.getEarliestShipDate()));
        amazonOrder.setLatestShipDate(DateUtil.utcStrToDateTime(order.getLatestShipDate()));
        amazonOrder.setEarlyestDeliveryDate(DateUtil.utcStrToDateTime(order.getEarliestDeliveryDate()));
        amazonOrder.setLatestDeliveryDate(DateUtil.utcStrToDateTime(order.getLatestDeliveryDate()));
        amazonOrder.setBusinessOrder(order.isIsBusinessOrder());
        amazonOrder.setPrime(order.isIsPrime());
        amazonOrder.setPremiumOrder(order.isIsPremiumOrder());
        amazonOrder.setGlobalExpressEnabled(order.isIsGlobalExpressEnabled());
        amazonOrder.setReplacementOrder(order.isIsReplacementOrder());
        amazonOrder.setReplacedOrderId(order.getReplacedOrderId());
        amazonOrder.setPromiseResponseDueDate(order.getPromiseResponseDueDate());
        amazonOrder.setEstimatedShipDateSet(order.isIsEstimatedShipDateSet());
        amazonOrder.setSoldByAb(order.isIsSoldByAB());
        if (order.getAssignedShipFromLocationAddress() != null) {
            amazonOrder.setAssignedShipFromLocationAddress(JSON.toJSONString(order.getAssignedShipFromLocationAddress()));
            amazonOrder.setBuyerEmail(order.getAssignedShipFromLocationAddress().getName());
            amazonOrder.setStateOrRegion(order.getAssignedShipFromLocationAddress().getStateOrRegion());
            amazonOrder.setCountryCode(order.getAssignedShipFromLocationAddress().getCountryCode());
            amazonOrder.setPostalCode(order.getAssignedShipFromLocationAddress().getPostalCode());
            amazonOrder.setCity(order.getAssignedShipFromLocationAddress().getCity());
            amazonOrder.setCounty(order.getAssignedShipFromLocationAddress().getCounty());
            amazonOrder.setAddressLine1(order.getAssignedShipFromLocationAddress().getAddressLine1());
        }
        amazonOrder.setSyncTime(new Date());
        amazonOrder.setSyncOrderItemStatus(YesOrNoEnum.NO.getValue());
    }

    private AmazonOrder getAmazonOrderByAmazonOrderId(String amazonOrderId) {
        AmazonOrderExample amazonOrderExample = new AmazonOrderExample();
        amazonOrderExample.createCriteria().andAmazonOrderIdEqualTo(amazonOrderId);
        List<AmazonOrder> list = customAmazonOrderMapper.selectByExample(amazonOrderExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
