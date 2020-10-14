package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderImportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderImportExample() {
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

        public Criteria andMerchantOrderIdIsNull() {
            addCriterion("merchant_order_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdIsNotNull() {
            addCriterion("merchant_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdEqualTo(String value) {
            addCriterion("merchant_order_id =", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdNotEqualTo(String value) {
            addCriterion("merchant_order_id <>", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdGreaterThan(String value) {
            addCriterion("merchant_order_id >", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_order_id >=", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdLessThan(String value) {
            addCriterion("merchant_order_id <", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_order_id <=", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdLike(String value) {
            addCriterion("merchant_order_id like", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdNotLike(String value) {
            addCriterion("merchant_order_id not like", value, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdIn(List<String> values) {
            addCriterion("merchant_order_id in", values, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdNotIn(List<String> values) {
            addCriterion("merchant_order_id not in", values, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdBetween(String value1, String value2) {
            addCriterion("merchant_order_id between", value1, value2, "merchantOrderId");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderIdNotBetween(String value1, String value2) {
            addCriterion("merchant_order_id not between", value1, value2, "merchantOrderId");
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

        public Criteria andLastUpdatedDateIsNull() {
            addCriterion("last_updated_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateIsNotNull() {
            addCriterion("last_updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateEqualTo(Date value) {
            addCriterion("last_updated_date =", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotEqualTo(Date value) {
            addCriterion("last_updated_date <>", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateGreaterThan(Date value) {
            addCriterion("last_updated_date >", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated_date >=", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateLessThan(Date value) {
            addCriterion("last_updated_date <", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("last_updated_date <=", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateIn(List<Date> values) {
            addCriterion("last_updated_date in", values, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotIn(List<Date> values) {
            addCriterion("last_updated_date not in", values, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("last_updated_date between", value1, value2, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("last_updated_date not between", value1, value2, "lastUpdatedDate");
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdIsNull() {
            addCriterion("shop_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdIsNotNull() {
            addCriterion("shop_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdEqualTo(Integer value) {
            addCriterion("shop_sku_id =", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdNotEqualTo(Integer value) {
            addCriterion("shop_sku_id <>", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdGreaterThan(Integer value) {
            addCriterion("shop_sku_id >", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id >=", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdLessThan(Integer value) {
            addCriterion("shop_sku_id <", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id <=", value, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdIn(List<Integer> values) {
            addCriterion("shop_sku_id in", values, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdNotIn(List<Integer> values) {
            addCriterion("shop_sku_id not in", values, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id between", value1, value2, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id not between", value1, value2, "shopSkuId");
            return (Criteria) this;
        }

        public Criteria andAsinIsNull() {
            addCriterion("asin is null");
            return (Criteria) this;
        }

        public Criteria andAsinIsNotNull() {
            addCriterion("asin is not null");
            return (Criteria) this;
        }

        public Criteria andAsinEqualTo(String value) {
            addCriterion("asin =", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotEqualTo(String value) {
            addCriterion("asin <>", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThan(String value) {
            addCriterion("asin >", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThanOrEqualTo(String value) {
            addCriterion("asin >=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThan(String value) {
            addCriterion("asin <", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThanOrEqualTo(String value) {
            addCriterion("asin <=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLike(String value) {
            addCriterion("asin like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotLike(String value) {
            addCriterion("asin not like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinIn(List<String> values) {
            addCriterion("asin in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotIn(List<String> values) {
            addCriterion("asin not in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinBetween(String value1, String value2) {
            addCriterion("asin between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotBetween(String value1, String value2) {
            addCriterion("asin not between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNull() {
            addCriterion("item_status is null");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNotNull() {
            addCriterion("item_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatusEqualTo(String value) {
            addCriterion("item_status =", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotEqualTo(String value) {
            addCriterion("item_status <>", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThan(String value) {
            addCriterion("item_status >", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("item_status >=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThan(String value) {
            addCriterion("item_status <", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThanOrEqualTo(String value) {
            addCriterion("item_status <=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLike(String value) {
            addCriterion("item_status like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotLike(String value) {
            addCriterion("item_status not like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusIn(List<String> values) {
            addCriterion("item_status in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotIn(List<String> values) {
            addCriterion("item_status not in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusBetween(String value1, String value2) {
            addCriterion("item_status between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotBetween(String value1, String value2) {
            addCriterion("item_status not between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(BigDecimal value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(BigDecimal value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(BigDecimal value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(BigDecimal value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<BigDecimal> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<BigDecimal> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemTaxIsNull() {
            addCriterion("item_tax is null");
            return (Criteria) this;
        }

        public Criteria andItemTaxIsNotNull() {
            addCriterion("item_tax is not null");
            return (Criteria) this;
        }

        public Criteria andItemTaxEqualTo(BigDecimal value) {
            addCriterion("item_tax =", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxNotEqualTo(BigDecimal value) {
            addCriterion("item_tax <>", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxGreaterThan(BigDecimal value) {
            addCriterion("item_tax >", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_tax >=", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxLessThan(BigDecimal value) {
            addCriterion("item_tax <", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_tax <=", value, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxIn(List<BigDecimal> values) {
            addCriterion("item_tax in", values, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxNotIn(List<BigDecimal> values) {
            addCriterion("item_tax not in", values, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_tax between", value1, value2, "itemTax");
            return (Criteria) this;
        }

        public Criteria andItemTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_tax not between", value1, value2, "itemTax");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIsNull() {
            addCriterion("shipping_price is null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIsNotNull() {
            addCriterion("shipping_price is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceEqualTo(BigDecimal value) {
            addCriterion("shipping_price =", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotEqualTo(BigDecimal value) {
            addCriterion("shipping_price <>", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceGreaterThan(BigDecimal value) {
            addCriterion("shipping_price >", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_price >=", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceLessThan(BigDecimal value) {
            addCriterion("shipping_price <", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_price <=", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIn(List<BigDecimal> values) {
            addCriterion("shipping_price in", values, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotIn(List<BigDecimal> values) {
            addCriterion("shipping_price not in", values, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_price between", value1, value2, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_price not between", value1, value2, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingTaxIsNull() {
            addCriterion("shipping_tax is null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxIsNotNull() {
            addCriterion("shipping_tax is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxEqualTo(BigDecimal value) {
            addCriterion("shipping_tax =", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxNotEqualTo(BigDecimal value) {
            addCriterion("shipping_tax <>", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxGreaterThan(BigDecimal value) {
            addCriterion("shipping_tax >", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_tax >=", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxLessThan(BigDecimal value) {
            addCriterion("shipping_tax <", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_tax <=", value, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxIn(List<BigDecimal> values) {
            addCriterion("shipping_tax in", values, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxNotIn(List<BigDecimal> values) {
            addCriterion("shipping_tax not in", values, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_tax between", value1, value2, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andShippingTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_tax not between", value1, value2, "shippingTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceIsNull() {
            addCriterion("gift_wrap_price is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceIsNotNull() {
            addCriterion("gift_wrap_price is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price =", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price <>", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_price >", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price >=", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceLessThan(BigDecimal value) {
            addCriterion("gift_wrap_price <", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price <=", value, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_price in", values, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_price not in", values, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_price between", value1, value2, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_price not between", value1, value2, "giftWrapPrice");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxIsNull() {
            addCriterion("gift_wrap_tax is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxIsNotNull() {
            addCriterion("gift_wrap_tax is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax =", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax <>", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_tax >", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax >=", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxLessThan(BigDecimal value) {
            addCriterion("gift_wrap_tax <", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax <=", value, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_tax in", values, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_tax not in", values, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_tax between", value1, value2, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_tax not between", value1, value2, "giftWrapTax");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountIsNull() {
            addCriterion("item_promotion_discount is null");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountIsNotNull() {
            addCriterion("item_promotion_discount is not null");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountEqualTo(BigDecimal value) {
            addCriterion("item_promotion_discount =", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountNotEqualTo(BigDecimal value) {
            addCriterion("item_promotion_discount <>", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountGreaterThan(BigDecimal value) {
            addCriterion("item_promotion_discount >", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_promotion_discount >=", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountLessThan(BigDecimal value) {
            addCriterion("item_promotion_discount <", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_promotion_discount <=", value, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountIn(List<BigDecimal> values) {
            addCriterion("item_promotion_discount in", values, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountNotIn(List<BigDecimal> values) {
            addCriterion("item_promotion_discount not in", values, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_promotion_discount between", value1, value2, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andItemPromotionDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_promotion_discount not between", value1, value2, "itemPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountIsNull() {
            addCriterion("ship_promotion_discount is null");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountIsNotNull() {
            addCriterion("ship_promotion_discount is not null");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountEqualTo(BigDecimal value) {
            addCriterion("ship_promotion_discount =", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountNotEqualTo(BigDecimal value) {
            addCriterion("ship_promotion_discount <>", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountGreaterThan(BigDecimal value) {
            addCriterion("ship_promotion_discount >", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_promotion_discount >=", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountLessThan(BigDecimal value) {
            addCriterion("ship_promotion_discount <", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_promotion_discount <=", value, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountIn(List<BigDecimal> values) {
            addCriterion("ship_promotion_discount in", values, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountNotIn(List<BigDecimal> values) {
            addCriterion("ship_promotion_discount not in", values, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_promotion_discount between", value1, value2, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipPromotionDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_promotion_discount not between", value1, value2, "shipPromotionDiscount");
            return (Criteria) this;
        }

        public Criteria andShipCityIsNull() {
            addCriterion("ship_city is null");
            return (Criteria) this;
        }

        public Criteria andShipCityIsNotNull() {
            addCriterion("ship_city is not null");
            return (Criteria) this;
        }

        public Criteria andShipCityEqualTo(String value) {
            addCriterion("ship_city =", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityNotEqualTo(String value) {
            addCriterion("ship_city <>", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityGreaterThan(String value) {
            addCriterion("ship_city >", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityGreaterThanOrEqualTo(String value) {
            addCriterion("ship_city >=", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityLessThan(String value) {
            addCriterion("ship_city <", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityLessThanOrEqualTo(String value) {
            addCriterion("ship_city <=", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityLike(String value) {
            addCriterion("ship_city like", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityNotLike(String value) {
            addCriterion("ship_city not like", value, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityIn(List<String> values) {
            addCriterion("ship_city in", values, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityNotIn(List<String> values) {
            addCriterion("ship_city not in", values, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityBetween(String value1, String value2) {
            addCriterion("ship_city between", value1, value2, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipCityNotBetween(String value1, String value2) {
            addCriterion("ship_city not between", value1, value2, "shipCity");
            return (Criteria) this;
        }

        public Criteria andShipStateIsNull() {
            addCriterion("ship_state is null");
            return (Criteria) this;
        }

        public Criteria andShipStateIsNotNull() {
            addCriterion("ship_state is not null");
            return (Criteria) this;
        }

        public Criteria andShipStateEqualTo(String value) {
            addCriterion("ship_state =", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateNotEqualTo(String value) {
            addCriterion("ship_state <>", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateGreaterThan(String value) {
            addCriterion("ship_state >", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateGreaterThanOrEqualTo(String value) {
            addCriterion("ship_state >=", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateLessThan(String value) {
            addCriterion("ship_state <", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateLessThanOrEqualTo(String value) {
            addCriterion("ship_state <=", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateLike(String value) {
            addCriterion("ship_state like", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateNotLike(String value) {
            addCriterion("ship_state not like", value, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateIn(List<String> values) {
            addCriterion("ship_state in", values, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateNotIn(List<String> values) {
            addCriterion("ship_state not in", values, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateBetween(String value1, String value2) {
            addCriterion("ship_state between", value1, value2, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipStateNotBetween(String value1, String value2) {
            addCriterion("ship_state not between", value1, value2, "shipState");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeIsNull() {
            addCriterion("ship_postal_code is null");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeIsNotNull() {
            addCriterion("ship_postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeEqualTo(String value) {
            addCriterion("ship_postal_code =", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeNotEqualTo(String value) {
            addCriterion("ship_postal_code <>", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeGreaterThan(String value) {
            addCriterion("ship_postal_code >", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ship_postal_code >=", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeLessThan(String value) {
            addCriterion("ship_postal_code <", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("ship_postal_code <=", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeLike(String value) {
            addCriterion("ship_postal_code like", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeNotLike(String value) {
            addCriterion("ship_postal_code not like", value, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeIn(List<String> values) {
            addCriterion("ship_postal_code in", values, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeNotIn(List<String> values) {
            addCriterion("ship_postal_code not in", values, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeBetween(String value1, String value2) {
            addCriterion("ship_postal_code between", value1, value2, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipPostalCodeNotBetween(String value1, String value2) {
            addCriterion("ship_postal_code not between", value1, value2, "shipPostalCode");
            return (Criteria) this;
        }

        public Criteria andShipCountryIsNull() {
            addCriterion("ship_country is null");
            return (Criteria) this;
        }

        public Criteria andShipCountryIsNotNull() {
            addCriterion("ship_country is not null");
            return (Criteria) this;
        }

        public Criteria andShipCountryEqualTo(String value) {
            addCriterion("ship_country =", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryNotEqualTo(String value) {
            addCriterion("ship_country <>", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryGreaterThan(String value) {
            addCriterion("ship_country >", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryGreaterThanOrEqualTo(String value) {
            addCriterion("ship_country >=", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryLessThan(String value) {
            addCriterion("ship_country <", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryLessThanOrEqualTo(String value) {
            addCriterion("ship_country <=", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryLike(String value) {
            addCriterion("ship_country like", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryNotLike(String value) {
            addCriterion("ship_country not like", value, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryIn(List<String> values) {
            addCriterion("ship_country in", values, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryNotIn(List<String> values) {
            addCriterion("ship_country not in", values, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryBetween(String value1, String value2) {
            addCriterion("ship_country between", value1, value2, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andShipCountryNotBetween(String value1, String value2) {
            addCriterion("ship_country not between", value1, value2, "shipCountry");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsIsNull() {
            addCriterion("promotion_ids is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsIsNotNull() {
            addCriterion("promotion_ids is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsEqualTo(String value) {
            addCriterion("promotion_ids =", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsNotEqualTo(String value) {
            addCriterion("promotion_ids <>", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsGreaterThan(String value) {
            addCriterion("promotion_ids >", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_ids >=", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsLessThan(String value) {
            addCriterion("promotion_ids <", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsLessThanOrEqualTo(String value) {
            addCriterion("promotion_ids <=", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsLike(String value) {
            addCriterion("promotion_ids like", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsNotLike(String value) {
            addCriterion("promotion_ids not like", value, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsIn(List<String> values) {
            addCriterion("promotion_ids in", values, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsNotIn(List<String> values) {
            addCriterion("promotion_ids not in", values, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsBetween(String value1, String value2) {
            addCriterion("promotion_ids between", value1, value2, "promotionIds");
            return (Criteria) this;
        }

        public Criteria andPromotionIdsNotBetween(String value1, String value2) {
            addCriterion("promotion_ids not between", value1, value2, "promotionIds");
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

        public Criteria andIsBusinessOrderEqualTo(String value) {
            addCriterion("is_business_order =", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotEqualTo(String value) {
            addCriterion("is_business_order <>", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderGreaterThan(String value) {
            addCriterion("is_business_order >", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderGreaterThanOrEqualTo(String value) {
            addCriterion("is_business_order >=", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderLessThan(String value) {
            addCriterion("is_business_order <", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderLessThanOrEqualTo(String value) {
            addCriterion("is_business_order <=", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderLike(String value) {
            addCriterion("is_business_order like", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotLike(String value) {
            addCriterion("is_business_order not like", value, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderIn(List<String> values) {
            addCriterion("is_business_order in", values, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotIn(List<String> values) {
            addCriterion("is_business_order not in", values, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderBetween(String value1, String value2) {
            addCriterion("is_business_order between", value1, value2, "isBusinessOrder");
            return (Criteria) this;
        }

        public Criteria andIsBusinessOrderNotBetween(String value1, String value2) {
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

        public Criteria andPurchaseOrderNumberEqualTo(Integer value) {
            addCriterion("purchase_order_number =", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotEqualTo(Integer value) {
            addCriterion("purchase_order_number <>", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThan(Integer value) {
            addCriterion("purchase_order_number >", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_order_number >=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThan(Integer value) {
            addCriterion("purchase_order_number <", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_order_number <=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIn(List<Integer> values) {
            addCriterion("purchase_order_number in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotIn(List<Integer> values) {
            addCriterion("purchase_order_number not in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("purchase_order_number between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_order_number not between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationIsNull() {
            addCriterion("price_designation is null");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationIsNotNull() {
            addCriterion("price_designation is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationEqualTo(String value) {
            addCriterion("price_designation =", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationNotEqualTo(String value) {
            addCriterion("price_designation <>", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationGreaterThan(String value) {
            addCriterion("price_designation >", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationGreaterThanOrEqualTo(String value) {
            addCriterion("price_designation >=", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationLessThan(String value) {
            addCriterion("price_designation <", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationLessThanOrEqualTo(String value) {
            addCriterion("price_designation <=", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationLike(String value) {
            addCriterion("price_designation like", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationNotLike(String value) {
            addCriterion("price_designation not like", value, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationIn(List<String> values) {
            addCriterion("price_designation in", values, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationNotIn(List<String> values) {
            addCriterion("price_designation not in", values, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationBetween(String value1, String value2) {
            addCriterion("price_designation between", value1, value2, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andPriceDesignationNotBetween(String value1, String value2) {
            addCriterion("price_designation not between", value1, value2, "priceDesignation");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
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

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
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