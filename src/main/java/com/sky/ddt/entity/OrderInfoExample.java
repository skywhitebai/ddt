package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdIsNull() {
            addCriterion("amazon_order_id is null");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdIsNotNull() {
            addCriterion("amazon_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdEqualTo(String value) {
            addCriterion("amazon_order_id =", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdNotEqualTo(String value) {
            addCriterion("amazon_order_id <>", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdGreaterThan(String value) {
            addCriterion("amazon_order_id >", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("amazon_order_id >=", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdLessThan(String value) {
            addCriterion("amazon_order_id <", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdLessThanOrEqualTo(String value) {
            addCriterion("amazon_order_id <=", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdLike(String value) {
            addCriterion("amazon_order_id like", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdNotLike(String value) {
            addCriterion("amazon_order_id not like", value, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdIn(List<String> values) {
            addCriterion("amazon_order_id in", values, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdNotIn(List<String> values) {
            addCriterion("amazon_order_id not in", values, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdBetween(String value1, String value2) {
            addCriterion("amazon_order_id between", value1, value2, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andAmazonOrderIdNotBetween(String value1, String value2) {
            addCriterion("amazon_order_id not between", value1, value2, "amazonOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdIsNull() {
            addCriterion("seller_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdIsNotNull() {
            addCriterion("seller_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdEqualTo(String value) {
            addCriterion("seller_order_id =", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdNotEqualTo(String value) {
            addCriterion("seller_order_id <>", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdGreaterThan(String value) {
            addCriterion("seller_order_id >", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_order_id >=", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdLessThan(String value) {
            addCriterion("seller_order_id <", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdLessThanOrEqualTo(String value) {
            addCriterion("seller_order_id <=", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdLike(String value) {
            addCriterion("seller_order_id like", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdNotLike(String value) {
            addCriterion("seller_order_id not like", value, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdIn(List<String> values) {
            addCriterion("seller_order_id in", values, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdNotIn(List<String> values) {
            addCriterion("seller_order_id not in", values, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdBetween(String value1, String value2) {
            addCriterion("seller_order_id between", value1, value2, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andSellerOrderIdNotBetween(String value1, String value2) {
            addCriterion("seller_order_id not between", value1, value2, "sellerOrderId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNull() {
            addCriterion("purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNotNull() {
            addCriterion("purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateEqualTo(Date value) {
            addCriterion("purchase_date =", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotEqualTo(Date value) {
            addCriterion("purchase_date <>", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThan(Date value) {
            addCriterion("purchase_date >", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_date >=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThan(Date value) {
            addCriterion("purchase_date <", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("purchase_date <=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIn(List<Date> values) {
            addCriterion("purchase_date in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotIn(List<Date> values) {
            addCriterion("purchase_date not in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateBetween(Date value1, Date value2) {
            addCriterion("purchase_date between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("purchase_date not between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("last_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("last_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("last_update_date =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("last_update_date <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("last_update_date >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_date >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("last_update_date <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_date <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("last_update_date in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("last_update_date not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("last_update_date between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_date not between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelIsNull() {
            addCriterion("fulfillment_channel is null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelIsNotNull() {
            addCriterion("fulfillment_channel is not null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelEqualTo(String value) {
            addCriterion("fulfillment_channel =", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelNotEqualTo(String value) {
            addCriterion("fulfillment_channel <>", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelGreaterThan(String value) {
            addCriterion("fulfillment_channel >", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelGreaterThanOrEqualTo(String value) {
            addCriterion("fulfillment_channel >=", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelLessThan(String value) {
            addCriterion("fulfillment_channel <", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelLessThanOrEqualTo(String value) {
            addCriterion("fulfillment_channel <=", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelLike(String value) {
            addCriterion("fulfillment_channel like", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelNotLike(String value) {
            addCriterion("fulfillment_channel not like", value, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelIn(List<String> values) {
            addCriterion("fulfillment_channel in", values, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelNotIn(List<String> values) {
            addCriterion("fulfillment_channel not in", values, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelBetween(String value1, String value2) {
            addCriterion("fulfillment_channel between", value1, value2, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andFulfillmentChannelNotBetween(String value1, String value2) {
            addCriterion("fulfillment_channel not between", value1, value2, "fulfillmentChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIsNull() {
            addCriterion("sales_channel is null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIsNotNull() {
            addCriterion("sales_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelEqualTo(String value) {
            addCriterion("sales_channel =", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotEqualTo(String value) {
            addCriterion("sales_channel <>", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThan(String value) {
            addCriterion("sales_channel >", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThanOrEqualTo(String value) {
            addCriterion("sales_channel >=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThan(String value) {
            addCriterion("sales_channel <", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThanOrEqualTo(String value) {
            addCriterion("sales_channel <=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLike(String value) {
            addCriterion("sales_channel like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotLike(String value) {
            addCriterion("sales_channel not like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIn(List<String> values) {
            addCriterion("sales_channel in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotIn(List<String> values) {
            addCriterion("sales_channel not in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelBetween(String value1, String value2) {
            addCriterion("sales_channel between", value1, value2, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotBetween(String value1, String value2) {
            addCriterion("sales_channel not between", value1, value2, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNull() {
            addCriterion("order_channel is null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNotNull() {
            addCriterion("order_channel is not null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelEqualTo(String value) {
            addCriterion("order_channel =", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotEqualTo(String value) {
            addCriterion("order_channel <>", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThan(String value) {
            addCriterion("order_channel >", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThanOrEqualTo(String value) {
            addCriterion("order_channel >=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThan(String value) {
            addCriterion("order_channel <", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThanOrEqualTo(String value) {
            addCriterion("order_channel <=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLike(String value) {
            addCriterion("order_channel like", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotLike(String value) {
            addCriterion("order_channel not like", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIn(List<String> values) {
            addCriterion("order_channel in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotIn(List<String> values) {
            addCriterion("order_channel not in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelBetween(String value1, String value2) {
            addCriterion("order_channel between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotBetween(String value1, String value2) {
            addCriterion("order_channel not between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelIsNull() {
            addCriterion("ship_service_level is null");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelIsNotNull() {
            addCriterion("ship_service_level is not null");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelEqualTo(String value) {
            addCriterion("ship_service_level =", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelNotEqualTo(String value) {
            addCriterion("ship_service_level <>", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelGreaterThan(String value) {
            addCriterion("ship_service_level >", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ship_service_level >=", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelLessThan(String value) {
            addCriterion("ship_service_level <", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelLessThanOrEqualTo(String value) {
            addCriterion("ship_service_level <=", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelLike(String value) {
            addCriterion("ship_service_level like", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelNotLike(String value) {
            addCriterion("ship_service_level not like", value, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelIn(List<String> values) {
            addCriterion("ship_service_level in", values, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelNotIn(List<String> values) {
            addCriterion("ship_service_level not in", values, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelBetween(String value1, String value2) {
            addCriterion("ship_service_level between", value1, value2, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andShipServiceLevelNotBetween(String value1, String value2) {
            addCriterion("ship_service_level not between", value1, value2, "shipServiceLevel");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeIsNull() {
            addCriterion("order_total_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeIsNotNull() {
            addCriterion("order_total_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeEqualTo(String value) {
            addCriterion("order_total_currency_code =", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeNotEqualTo(String value) {
            addCriterion("order_total_currency_code <>", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeGreaterThan(String value) {
            addCriterion("order_total_currency_code >", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_total_currency_code >=", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeLessThan(String value) {
            addCriterion("order_total_currency_code <", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("order_total_currency_code <=", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeLike(String value) {
            addCriterion("order_total_currency_code like", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeNotLike(String value) {
            addCriterion("order_total_currency_code not like", value, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeIn(List<String> values) {
            addCriterion("order_total_currency_code in", values, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeNotIn(List<String> values) {
            addCriterion("order_total_currency_code not in", values, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeBetween(String value1, String value2) {
            addCriterion("order_total_currency_code between", value1, value2, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("order_total_currency_code not between", value1, value2, "orderTotalCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIsNull() {
            addCriterion("order_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIsNotNull() {
            addCriterion("order_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountEqualTo(BigDecimal value) {
            addCriterion("order_total_amount =", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_total_amount <>", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("order_total_amount >", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_amount >=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThan(BigDecimal value) {
            addCriterion("order_total_amount <", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_amount <=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIn(List<BigDecimal> values) {
            addCriterion("order_total_amount in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_total_amount not in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_amount between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_amount not between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedIsNull() {
            addCriterion("number_of_items_shipped is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedIsNotNull() {
            addCriterion("number_of_items_shipped is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedEqualTo(Integer value) {
            addCriterion("number_of_items_shipped =", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedNotEqualTo(Integer value) {
            addCriterion("number_of_items_shipped <>", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedGreaterThan(Integer value) {
            addCriterion("number_of_items_shipped >", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_items_shipped >=", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedLessThan(Integer value) {
            addCriterion("number_of_items_shipped <", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_items_shipped <=", value, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedIn(List<Integer> values) {
            addCriterion("number_of_items_shipped in", values, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedNotIn(List<Integer> values) {
            addCriterion("number_of_items_shipped not in", values, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedBetween(Integer value1, Integer value2) {
            addCriterion("number_of_items_shipped between", value1, value2, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsShippedNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_items_shipped not between", value1, value2, "numberOfItemsShipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedIsNull() {
            addCriterion("number_of_items_unshipped is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedIsNotNull() {
            addCriterion("number_of_items_unshipped is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedEqualTo(Integer value) {
            addCriterion("number_of_items_unshipped =", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedNotEqualTo(Integer value) {
            addCriterion("number_of_items_unshipped <>", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedGreaterThan(Integer value) {
            addCriterion("number_of_items_unshipped >", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_items_unshipped >=", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedLessThan(Integer value) {
            addCriterion("number_of_items_unshipped <", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_items_unshipped <=", value, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedIn(List<Integer> values) {
            addCriterion("number_of_items_unshipped in", values, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedNotIn(List<Integer> values) {
            addCriterion("number_of_items_unshipped not in", values, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedBetween(Integer value1, Integer value2) {
            addCriterion("number_of_items_unshipped between", value1, value2, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andNumberOfItemsUnshippedNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_items_unshipped not between", value1, value2, "numberOfItemsUnshipped");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsIsNull() {
            addCriterion("payment_method_details is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsIsNotNull() {
            addCriterion("payment_method_details is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsEqualTo(String value) {
            addCriterion("payment_method_details =", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsNotEqualTo(String value) {
            addCriterion("payment_method_details <>", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsGreaterThan(String value) {
            addCriterion("payment_method_details >", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method_details >=", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsLessThan(String value) {
            addCriterion("payment_method_details <", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsLessThanOrEqualTo(String value) {
            addCriterion("payment_method_details <=", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsLike(String value) {
            addCriterion("payment_method_details like", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsNotLike(String value) {
            addCriterion("payment_method_details not like", value, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsIn(List<String> values) {
            addCriterion("payment_method_details in", values, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsNotIn(List<String> values) {
            addCriterion("payment_method_details not in", values, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsBetween(String value1, String value2) {
            addCriterion("payment_method_details between", value1, value2, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodDetailsNotBetween(String value1, String value2) {
            addCriterion("payment_method_details not between", value1, value2, "paymentMethodDetails");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdIsNull() {
            addCriterion("marketplace_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdIsNotNull() {
            addCriterion("marketplace_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdEqualTo(String value) {
            addCriterion("marketplace_id =", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdNotEqualTo(String value) {
            addCriterion("marketplace_id <>", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdGreaterThan(String value) {
            addCriterion("marketplace_id >", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("marketplace_id >=", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdLessThan(String value) {
            addCriterion("marketplace_id <", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdLessThanOrEqualTo(String value) {
            addCriterion("marketplace_id <=", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdLike(String value) {
            addCriterion("marketplace_id like", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdNotLike(String value) {
            addCriterion("marketplace_id not like", value, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdIn(List<String> values) {
            addCriterion("marketplace_id in", values, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdNotIn(List<String> values) {
            addCriterion("marketplace_id not in", values, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdBetween(String value1, String value2) {
            addCriterion("marketplace_id between", value1, value2, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIdNotBetween(String value1, String value2) {
            addCriterion("marketplace_id not between", value1, value2, "marketplaceId");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailIsNull() {
            addCriterion("buyer_email is null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailIsNotNull() {
            addCriterion("buyer_email is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailEqualTo(String value) {
            addCriterion("buyer_email =", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotEqualTo(String value) {
            addCriterion("buyer_email <>", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailGreaterThan(String value) {
            addCriterion("buyer_email >", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_email >=", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLessThan(String value) {
            addCriterion("buyer_email <", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLessThanOrEqualTo(String value) {
            addCriterion("buyer_email <=", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLike(String value) {
            addCriterion("buyer_email like", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotLike(String value) {
            addCriterion("buyer_email not like", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailIn(List<String> values) {
            addCriterion("buyer_email in", values, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotIn(List<String> values) {
            addCriterion("buyer_email not in", values, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailBetween(String value1, String value2) {
            addCriterion("buyer_email between", value1, value2, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotBetween(String value1, String value2) {
            addCriterion("buyer_email not between", value1, value2, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNull() {
            addCriterion("buyer_name is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNotNull() {
            addCriterion("buyer_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameEqualTo(String value) {
            addCriterion("buyer_name =", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            addCriterion("buyer_name <>", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            addCriterion("buyer_name >", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_name >=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThan(String value) {
            addCriterion("buyer_name <", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            addCriterion("buyer_name <=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLike(String value) {
            addCriterion("buyer_name like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotLike(String value) {
            addCriterion("buyer_name not like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIn(List<String> values) {
            addCriterion("buyer_name in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            addCriterion("buyer_name not in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            addCriterion("buyer_name between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            addCriterion("buyer_name not between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyIsNull() {
            addCriterion("buyer_county is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyIsNotNull() {
            addCriterion("buyer_county is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyEqualTo(String value) {
            addCriterion("buyer_county =", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyNotEqualTo(String value) {
            addCriterion("buyer_county <>", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyGreaterThan(String value) {
            addCriterion("buyer_county >", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_county >=", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyLessThan(String value) {
            addCriterion("buyer_county <", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyLessThanOrEqualTo(String value) {
            addCriterion("buyer_county <=", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyLike(String value) {
            addCriterion("buyer_county like", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyNotLike(String value) {
            addCriterion("buyer_county not like", value, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyIn(List<String> values) {
            addCriterion("buyer_county in", values, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyNotIn(List<String> values) {
            addCriterion("buyer_county not in", values, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyBetween(String value1, String value2) {
            addCriterion("buyer_county between", value1, value2, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andBuyerCountyNotBetween(String value1, String value2) {
            addCriterion("buyer_county not between", value1, value2, "buyerCounty");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryIsNull() {
            addCriterion("shipment_service_level_category is null");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryIsNotNull() {
            addCriterion("shipment_service_level_category is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryEqualTo(String value) {
            addCriterion("shipment_service_level_category =", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryNotEqualTo(String value) {
            addCriterion("shipment_service_level_category <>", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryGreaterThan(String value) {
            addCriterion("shipment_service_level_category >", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("shipment_service_level_category >=", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryLessThan(String value) {
            addCriterion("shipment_service_level_category <", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryLessThanOrEqualTo(String value) {
            addCriterion("shipment_service_level_category <=", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryLike(String value) {
            addCriterion("shipment_service_level_category like", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryNotLike(String value) {
            addCriterion("shipment_service_level_category not like", value, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryIn(List<String> values) {
            addCriterion("shipment_service_level_category in", values, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryNotIn(List<String> values) {
            addCriterion("shipment_service_level_category not in", values, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryBetween(String value1, String value2) {
            addCriterion("shipment_service_level_category between", value1, value2, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShipmentServiceLevelCategoryNotBetween(String value1, String value2) {
            addCriterion("shipment_service_level_category not between", value1, value2, "shipmentServiceLevelCategory");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmIsNull() {
            addCriterion("shipped_by_amazon_TFM is null");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmIsNotNull() {
            addCriterion("shipped_by_amazon_TFM is not null");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmEqualTo(Boolean value) {
            addCriterion("shipped_by_amazon_TFM =", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmNotEqualTo(Boolean value) {
            addCriterion("shipped_by_amazon_TFM <>", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmGreaterThan(Boolean value) {
            addCriterion("shipped_by_amazon_TFM >", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shipped_by_amazon_TFM >=", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmLessThan(Boolean value) {
            addCriterion("shipped_by_amazon_TFM <", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmLessThanOrEqualTo(Boolean value) {
            addCriterion("shipped_by_amazon_TFM <=", value, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmIn(List<Boolean> values) {
            addCriterion("shipped_by_amazon_TFM in", values, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmNotIn(List<Boolean> values) {
            addCriterion("shipped_by_amazon_TFM not in", values, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmBetween(Boolean value1, Boolean value2) {
            addCriterion("shipped_by_amazon_TFM between", value1, value2, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andShippedByAmazonTfmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shipped_by_amazon_TFM not between", value1, value2, "shippedByAmazonTfm");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusIsNull() {
            addCriterion("tfm_shipment_status is null");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusIsNotNull() {
            addCriterion("tfm_shipment_status is not null");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusEqualTo(String value) {
            addCriterion("tfm_shipment_status =", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusNotEqualTo(String value) {
            addCriterion("tfm_shipment_status <>", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusGreaterThan(String value) {
            addCriterion("tfm_shipment_status >", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("tfm_shipment_status >=", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusLessThan(String value) {
            addCriterion("tfm_shipment_status <", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusLessThanOrEqualTo(String value) {
            addCriterion("tfm_shipment_status <=", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusLike(String value) {
            addCriterion("tfm_shipment_status like", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusNotLike(String value) {
            addCriterion("tfm_shipment_status not like", value, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusIn(List<String> values) {
            addCriterion("tfm_shipment_status in", values, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusNotIn(List<String> values) {
            addCriterion("tfm_shipment_status not in", values, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusBetween(String value1, String value2) {
            addCriterion("tfm_shipment_status between", value1, value2, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andTfmShipmentStatusNotBetween(String value1, String value2) {
            addCriterion("tfm_shipment_status not between", value1, value2, "tfmShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusIsNull() {
            addCriterion("easy_ship_shipment_status is null");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusIsNotNull() {
            addCriterion("easy_ship_shipment_status is not null");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusEqualTo(String value) {
            addCriterion("easy_ship_shipment_status =", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusNotEqualTo(String value) {
            addCriterion("easy_ship_shipment_status <>", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusGreaterThan(String value) {
            addCriterion("easy_ship_shipment_status >", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("easy_ship_shipment_status >=", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusLessThan(String value) {
            addCriterion("easy_ship_shipment_status <", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusLessThanOrEqualTo(String value) {
            addCriterion("easy_ship_shipment_status <=", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusLike(String value) {
            addCriterion("easy_ship_shipment_status like", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusNotLike(String value) {
            addCriterion("easy_ship_shipment_status not like", value, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusIn(List<String> values) {
            addCriterion("easy_ship_shipment_status in", values, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusNotIn(List<String> values) {
            addCriterion("easy_ship_shipment_status not in", values, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusBetween(String value1, String value2) {
            addCriterion("easy_ship_shipment_status between", value1, value2, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEasyShipShipmentStatusNotBetween(String value1, String value2) {
            addCriterion("easy_ship_shipment_status not between", value1, value2, "easyShipShipmentStatus");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelIsNull() {
            addCriterion("cba_displayable_shipping_label is null");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelIsNotNull() {
            addCriterion("cba_displayable_shipping_label is not null");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelEqualTo(String value) {
            addCriterion("cba_displayable_shipping_label =", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelNotEqualTo(String value) {
            addCriterion("cba_displayable_shipping_label <>", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelGreaterThan(String value) {
            addCriterion("cba_displayable_shipping_label >", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelGreaterThanOrEqualTo(String value) {
            addCriterion("cba_displayable_shipping_label >=", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelLessThan(String value) {
            addCriterion("cba_displayable_shipping_label <", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelLessThanOrEqualTo(String value) {
            addCriterion("cba_displayable_shipping_label <=", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelLike(String value) {
            addCriterion("cba_displayable_shipping_label like", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelNotLike(String value) {
            addCriterion("cba_displayable_shipping_label not like", value, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelIn(List<String> values) {
            addCriterion("cba_displayable_shipping_label in", values, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelNotIn(List<String> values) {
            addCriterion("cba_displayable_shipping_label not in", values, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelBetween(String value1, String value2) {
            addCriterion("cba_displayable_shipping_label between", value1, value2, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andCbaDisplayableShippingLabelNotBetween(String value1, String value2) {
            addCriterion("cba_displayable_shipping_label not between", value1, value2, "cbaDisplayableShippingLabel");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateIsNull() {
            addCriterion("earliest_ship_date is null");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateIsNotNull() {
            addCriterion("earliest_ship_date is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateEqualTo(Date value) {
            addCriterion("earliest_ship_date =", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateNotEqualTo(Date value) {
            addCriterion("earliest_ship_date <>", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateGreaterThan(Date value) {
            addCriterion("earliest_ship_date >", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateGreaterThanOrEqualTo(Date value) {
            addCriterion("earliest_ship_date >=", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateLessThan(Date value) {
            addCriterion("earliest_ship_date <", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateLessThanOrEqualTo(Date value) {
            addCriterion("earliest_ship_date <=", value, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateIn(List<Date> values) {
            addCriterion("earliest_ship_date in", values, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateNotIn(List<Date> values) {
            addCriterion("earliest_ship_date not in", values, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateBetween(Date value1, Date value2) {
            addCriterion("earliest_ship_date between", value1, value2, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestShipDateNotBetween(Date value1, Date value2) {
            addCriterion("earliest_ship_date not between", value1, value2, "earliestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateIsNull() {
            addCriterion("latest_ship_date is null");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateIsNotNull() {
            addCriterion("latest_ship_date is not null");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateEqualTo(Date value) {
            addCriterion("latest_ship_date =", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateNotEqualTo(Date value) {
            addCriterion("latest_ship_date <>", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateGreaterThan(Date value) {
            addCriterion("latest_ship_date >", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateGreaterThanOrEqualTo(Date value) {
            addCriterion("latest_ship_date >=", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateLessThan(Date value) {
            addCriterion("latest_ship_date <", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateLessThanOrEqualTo(Date value) {
            addCriterion("latest_ship_date <=", value, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateIn(List<Date> values) {
            addCriterion("latest_ship_date in", values, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateNotIn(List<Date> values) {
            addCriterion("latest_ship_date not in", values, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateBetween(Date value1, Date value2) {
            addCriterion("latest_ship_date between", value1, value2, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andLatestShipDateNotBetween(Date value1, Date value2) {
            addCriterion("latest_ship_date not between", value1, value2, "latestShipDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateIsNull() {
            addCriterion("earliest_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateIsNotNull() {
            addCriterion("earliest_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateEqualTo(Date value) {
            addCriterion("earliest_delivery_date =", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateNotEqualTo(Date value) {
            addCriterion("earliest_delivery_date <>", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateGreaterThan(Date value) {
            addCriterion("earliest_delivery_date >", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("earliest_delivery_date >=", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateLessThan(Date value) {
            addCriterion("earliest_delivery_date <", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("earliest_delivery_date <=", value, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateIn(List<Date> values) {
            addCriterion("earliest_delivery_date in", values, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateNotIn(List<Date> values) {
            addCriterion("earliest_delivery_date not in", values, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("earliest_delivery_date between", value1, value2, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("earliest_delivery_date not between", value1, value2, "earliestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIsNull() {
            addCriterion("latest_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIsNotNull() {
            addCriterion("latest_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateEqualTo(Date value) {
            addCriterion("latest_delivery_date =", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotEqualTo(Date value) {
            addCriterion("latest_delivery_date <>", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateGreaterThan(Date value) {
            addCriterion("latest_delivery_date >", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("latest_delivery_date >=", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateLessThan(Date value) {
            addCriterion("latest_delivery_date <", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("latest_delivery_date <=", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIn(List<Date> values) {
            addCriterion("latest_delivery_date in", values, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotIn(List<Date> values) {
            addCriterion("latest_delivery_date not in", values, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("latest_delivery_date between", value1, value2, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("latest_delivery_date not between", value1, value2, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderIsNull() {
            addCriterion("is_business_order is null");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderIsNotNull() {
            addCriterion("is_business_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderEqualTo(Boolean value) {
            addCriterion("is_business_order =", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotEqualTo(Boolean value) {
            addCriterion("is_business_order <>", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderGreaterThan(Boolean value) {
            addCriterion("is_business_order >", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_business_order >=", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderLessThan(Boolean value) {
            addCriterion("is_business_order <", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_business_order <=", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderIn(List<Boolean> values) {
            addCriterion("is_business_order in", values, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotIn(List<Boolean> values) {
            addCriterion("is_business_order not in", values, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_business_order between", value1, value2, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_business_order not between", value1, value2, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIsNull() {
            addCriterion("purchase_order_number is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIsNotNull() {
            addCriterion("purchase_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberEqualTo(String value) {
            addCriterion("purchase_order_number =", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotEqualTo(String value) {
            addCriterion("purchase_order_number <>", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThan(String value) {
            addCriterion("purchase_order_number >", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_order_number >=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThan(String value) {
            addCriterion("purchase_order_number <", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("purchase_order_number <=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLike(String value) {
            addCriterion("purchase_order_number like", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotLike(String value) {
            addCriterion("purchase_order_number not like", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIn(List<String> values) {
            addCriterion("purchase_order_number in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotIn(List<String> values) {
            addCriterion("purchase_order_number not in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberBetween(String value1, String value2) {
            addCriterion("purchase_order_number between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotBetween(String value1, String value2) {
            addCriterion("purchase_order_number not between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andIsPrimeIsNull() {
            addCriterion("is_prime is null");
            return (Criteria) this;
        }

        public Criteria andIsPrimeIsNotNull() {
            addCriterion("is_prime is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrimeEqualTo(Boolean value) {
            addCriterion("is_prime =", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeNotEqualTo(Boolean value) {
            addCriterion("is_prime <>", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeGreaterThan(Boolean value) {
            addCriterion("is_prime >", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prime >=", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeLessThan(Boolean value) {
            addCriterion("is_prime <", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prime <=", value, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeIn(List<Boolean> values) {
            addCriterion("is_prime in", values, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeNotIn(List<Boolean> values) {
            addCriterion("is_prime not in", values, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prime between", value1, value2, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPrimeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prime not between", value1, value2, "isPrime");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderIsNull() {
            addCriterion("is_premium_order is null");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderIsNotNull() {
            addCriterion("is_premium_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderEqualTo(Boolean value) {
            addCriterion("is_premium_order =", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderNotEqualTo(Boolean value) {
            addCriterion("is_premium_order <>", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderGreaterThan(Boolean value) {
            addCriterion("is_premium_order >", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_premium_order >=", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderLessThan(Boolean value) {
            addCriterion("is_premium_order <", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_premium_order <=", value, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderIn(List<Boolean> values) {
            addCriterion("is_premium_order in", values, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderNotIn(List<Boolean> values) {
            addCriterion("is_premium_order not in", values, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_premium_order between", value1, value2, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andIsPremiumOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_premium_order not between", value1, value2, "isPremiumOrder");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdIsNull() {
            addCriterion("replaced_order_id is null");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdIsNotNull() {
            addCriterion("replaced_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdEqualTo(String value) {
            addCriterion("replaced_order_id =", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdNotEqualTo(String value) {
            addCriterion("replaced_order_id <>", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdGreaterThan(String value) {
            addCriterion("replaced_order_id >", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("replaced_order_id >=", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdLessThan(String value) {
            addCriterion("replaced_order_id <", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdLessThanOrEqualTo(String value) {
            addCriterion("replaced_order_id <=", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdLike(String value) {
            addCriterion("replaced_order_id like", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdNotLike(String value) {
            addCriterion("replaced_order_id not like", value, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdIn(List<String> values) {
            addCriterion("replaced_order_id in", values, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdNotIn(List<String> values) {
            addCriterion("replaced_order_id not in", values, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdBetween(String value1, String value2) {
            addCriterion("replaced_order_id between", value1, value2, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andReplacedOrderIdNotBetween(String value1, String value2) {
            addCriterion("replaced_order_id not between", value1, value2, "replacedOrderId");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderIsNull() {
            addCriterion("is_replacement_order is null");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderIsNotNull() {
            addCriterion("is_replacement_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderEqualTo(Boolean value) {
            addCriterion("is_replacement_order =", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderNotEqualTo(Boolean value) {
            addCriterion("is_replacement_order <>", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderGreaterThan(Boolean value) {
            addCriterion("is_replacement_order >", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_replacement_order >=", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderLessThan(Boolean value) {
            addCriterion("is_replacement_order <", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_replacement_order <=", value, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderIn(List<Boolean> values) {
            addCriterion("is_replacement_order in", values, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderNotIn(List<Boolean> values) {
            addCriterion("is_replacement_order not in", values, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_replacement_order between", value1, value2, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andIsReplacementOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_replacement_order not between", value1, value2, "isReplacementOrder");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateIsNull() {
            addCriterion("promise_response_due_date is null");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateIsNotNull() {
            addCriterion("promise_response_due_date is not null");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateEqualTo(Date value) {
            addCriterion("promise_response_due_date =", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotEqualTo(Date value) {
            addCriterion("promise_response_due_date <>", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateGreaterThan(Date value) {
            addCriterion("promise_response_due_date >", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("promise_response_due_date >=", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateLessThan(Date value) {
            addCriterion("promise_response_due_date <", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateLessThanOrEqualTo(Date value) {
            addCriterion("promise_response_due_date <=", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateIn(List<Date> values) {
            addCriterion("promise_response_due_date in", values, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotIn(List<Date> values) {
            addCriterion("promise_response_due_date not in", values, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateBetween(Date value1, Date value2) {
            addCriterion("promise_response_due_date between", value1, value2, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotBetween(Date value1, Date value2) {
            addCriterion("promise_response_due_date not between", value1, value2, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetIsNull() {
            addCriterion("is_estimated_ship_date_set is null");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetIsNotNull() {
            addCriterion("is_estimated_ship_date_set is not null");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetEqualTo(Boolean value) {
            addCriterion("is_estimated_ship_date_set =", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetNotEqualTo(Boolean value) {
            addCriterion("is_estimated_ship_date_set <>", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetGreaterThan(Boolean value) {
            addCriterion("is_estimated_ship_date_set >", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_estimated_ship_date_set >=", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetLessThan(Boolean value) {
            addCriterion("is_estimated_ship_date_set <", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetLessThanOrEqualTo(Boolean value) {
            addCriterion("is_estimated_ship_date_set <=", value, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetIn(List<Boolean> values) {
            addCriterion("is_estimated_ship_date_set in", values, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetNotIn(List<Boolean> values) {
            addCriterion("is_estimated_ship_date_set not in", values, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetBetween(Boolean value1, Boolean value2) {
            addCriterion("is_estimated_ship_date_set between", value1, value2, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andIsEstimatedShipDateSetNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_estimated_ship_date_set not between", value1, value2, "isEstimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}