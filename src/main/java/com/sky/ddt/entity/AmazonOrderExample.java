package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AmazonOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmazonOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("merchant_id like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("merchant_id not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
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

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(Date value) {
            addCriterionForJDBCDate("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(Date value) {
            addCriterionForJDBCDate("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(Date value) {
            addCriterionForJDBCDate("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<Date> values) {
            addCriterionForJDBCDate("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_date not between", value1, value2, "orderDate");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountIsNull() {
            addCriterion("rate_amount is null");
            return (Criteria) this;
        }

        public Criteria andRateAmountIsNotNull() {
            addCriterion("rate_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRateAmountEqualTo(BigDecimal value) {
            addCriterion("rate_amount =", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountNotEqualTo(BigDecimal value) {
            addCriterion("rate_amount <>", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountGreaterThan(BigDecimal value) {
            addCriterion("rate_amount >", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_amount >=", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountLessThan(BigDecimal value) {
            addCriterion("rate_amount <", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_amount <=", value, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountIn(List<BigDecimal> values) {
            addCriterion("rate_amount in", values, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountNotIn(List<BigDecimal> values) {
            addCriterion("rate_amount not in", values, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_amount between", value1, value2, "rateAmount");
            return (Criteria) this;
        }

        public Criteria andRateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_amount not between", value1, value2, "rateAmount");
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

        public Criteria andPaymentExecutionDetailIsNull() {
            addCriterion("payment_execution_detail is null");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailIsNotNull() {
            addCriterion("payment_execution_detail is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailEqualTo(String value) {
            addCriterion("payment_execution_detail =", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailNotEqualTo(String value) {
            addCriterion("payment_execution_detail <>", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailGreaterThan(String value) {
            addCriterion("payment_execution_detail >", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailGreaterThanOrEqualTo(String value) {
            addCriterion("payment_execution_detail >=", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailLessThan(String value) {
            addCriterion("payment_execution_detail <", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailLessThanOrEqualTo(String value) {
            addCriterion("payment_execution_detail <=", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailLike(String value) {
            addCriterion("payment_execution_detail like", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailNotLike(String value) {
            addCriterion("payment_execution_detail not like", value, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailIn(List<String> values) {
            addCriterion("payment_execution_detail in", values, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailNotIn(List<String> values) {
            addCriterion("payment_execution_detail not in", values, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailBetween(String value1, String value2) {
            addCriterion("payment_execution_detail between", value1, value2, "paymentExecutionDetail");
            return (Criteria) this;
        }

        public Criteria andPaymentExecutionDetailNotBetween(String value1, String value2) {
            addCriterion("payment_execution_detail not between", value1, value2, "paymentExecutionDetail");
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

        public Criteria andEarlyestDeliveryDateIsNull() {
            addCriterion("earlyest_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateIsNotNull() {
            addCriterion("earlyest_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateEqualTo(Date value) {
            addCriterion("earlyest_delivery_date =", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateNotEqualTo(Date value) {
            addCriterion("earlyest_delivery_date <>", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateGreaterThan(Date value) {
            addCriterion("earlyest_delivery_date >", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("earlyest_delivery_date >=", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateLessThan(Date value) {
            addCriterion("earlyest_delivery_date <", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("earlyest_delivery_date <=", value, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateIn(List<Date> values) {
            addCriterion("earlyest_delivery_date in", values, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateNotIn(List<Date> values) {
            addCriterion("earlyest_delivery_date not in", values, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("earlyest_delivery_date between", value1, value2, "earlyestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEarlyestDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("earlyest_delivery_date not between", value1, value2, "earlyestDeliveryDate");
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

        public Criteria andBusinessOrderIsNull() {
            addCriterion("business_order is null");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderIsNotNull() {
            addCriterion("business_order is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderEqualTo(Boolean value) {
            addCriterion("business_order =", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderNotEqualTo(Boolean value) {
            addCriterion("business_order <>", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderGreaterThan(Boolean value) {
            addCriterion("business_order >", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("business_order >=", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderLessThan(Boolean value) {
            addCriterion("business_order <", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("business_order <=", value, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderIn(List<Boolean> values) {
            addCriterion("business_order in", values, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderNotIn(List<Boolean> values) {
            addCriterion("business_order not in", values, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("business_order between", value1, value2, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andBusinessOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("business_order not between", value1, value2, "businessOrder");
            return (Criteria) this;
        }

        public Criteria andPrimeIsNull() {
            addCriterion("prime is null");
            return (Criteria) this;
        }

        public Criteria andPrimeIsNotNull() {
            addCriterion("prime is not null");
            return (Criteria) this;
        }

        public Criteria andPrimeEqualTo(Boolean value) {
            addCriterion("prime =", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeNotEqualTo(Boolean value) {
            addCriterion("prime <>", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeGreaterThan(Boolean value) {
            addCriterion("prime >", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("prime >=", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeLessThan(Boolean value) {
            addCriterion("prime <", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeLessThanOrEqualTo(Boolean value) {
            addCriterion("prime <=", value, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeIn(List<Boolean> values) {
            addCriterion("prime in", values, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeNotIn(List<Boolean> values) {
            addCriterion("prime not in", values, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeBetween(Boolean value1, Boolean value2) {
            addCriterion("prime between", value1, value2, "prime");
            return (Criteria) this;
        }

        public Criteria andPrimeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("prime not between", value1, value2, "prime");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderIsNull() {
            addCriterion("premium_order is null");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderIsNotNull() {
            addCriterion("premium_order is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderEqualTo(Boolean value) {
            addCriterion("premium_order =", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderNotEqualTo(Boolean value) {
            addCriterion("premium_order <>", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderGreaterThan(Boolean value) {
            addCriterion("premium_order >", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("premium_order >=", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderLessThan(Boolean value) {
            addCriterion("premium_order <", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("premium_order <=", value, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderIn(List<Boolean> values) {
            addCriterion("premium_order in", values, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderNotIn(List<Boolean> values) {
            addCriterion("premium_order not in", values, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("premium_order between", value1, value2, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andPremiumOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("premium_order not between", value1, value2, "premiumOrder");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledIsNull() {
            addCriterion("global_express_enabled is null");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledIsNotNull() {
            addCriterion("global_express_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledEqualTo(Boolean value) {
            addCriterion("global_express_enabled =", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledNotEqualTo(Boolean value) {
            addCriterion("global_express_enabled <>", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledGreaterThan(Boolean value) {
            addCriterion("global_express_enabled >", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("global_express_enabled >=", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledLessThan(Boolean value) {
            addCriterion("global_express_enabled <", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("global_express_enabled <=", value, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledIn(List<Boolean> values) {
            addCriterion("global_express_enabled in", values, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledNotIn(List<Boolean> values) {
            addCriterion("global_express_enabled not in", values, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("global_express_enabled between", value1, value2, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andGlobalExpressEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("global_express_enabled not between", value1, value2, "globalExpressEnabled");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderIsNull() {
            addCriterion("replacement_order is null");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderIsNotNull() {
            addCriterion("replacement_order is not null");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderEqualTo(Boolean value) {
            addCriterion("replacement_order =", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderNotEqualTo(Boolean value) {
            addCriterion("replacement_order <>", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderGreaterThan(Boolean value) {
            addCriterion("replacement_order >", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("replacement_order >=", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderLessThan(Boolean value) {
            addCriterion("replacement_order <", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("replacement_order <=", value, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderIn(List<Boolean> values) {
            addCriterion("replacement_order in", values, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderNotIn(List<Boolean> values) {
            addCriterion("replacement_order not in", values, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("replacement_order between", value1, value2, "replacementOrder");
            return (Criteria) this;
        }

        public Criteria andReplacementOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("replacement_order not between", value1, value2, "replacementOrder");
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

        public Criteria andPromiseResponseDueDateIsNull() {
            addCriterion("promise_response_due_date is null");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateIsNotNull() {
            addCriterion("promise_response_due_date is not null");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateEqualTo(String value) {
            addCriterion("promise_response_due_date =", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotEqualTo(String value) {
            addCriterion("promise_response_due_date <>", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateGreaterThan(String value) {
            addCriterion("promise_response_due_date >", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateGreaterThanOrEqualTo(String value) {
            addCriterion("promise_response_due_date >=", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateLessThan(String value) {
            addCriterion("promise_response_due_date <", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateLessThanOrEqualTo(String value) {
            addCriterion("promise_response_due_date <=", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateLike(String value) {
            addCriterion("promise_response_due_date like", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotLike(String value) {
            addCriterion("promise_response_due_date not like", value, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateIn(List<String> values) {
            addCriterion("promise_response_due_date in", values, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotIn(List<String> values) {
            addCriterion("promise_response_due_date not in", values, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateBetween(String value1, String value2) {
            addCriterion("promise_response_due_date between", value1, value2, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andPromiseResponseDueDateNotBetween(String value1, String value2) {
            addCriterion("promise_response_due_date not between", value1, value2, "promiseResponseDueDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetIsNull() {
            addCriterion("estimated_ship_date_set is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetIsNotNull() {
            addCriterion("estimated_ship_date_set is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetEqualTo(Boolean value) {
            addCriterion("estimated_ship_date_set =", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetNotEqualTo(Boolean value) {
            addCriterion("estimated_ship_date_set <>", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetGreaterThan(Boolean value) {
            addCriterion("estimated_ship_date_set >", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetGreaterThanOrEqualTo(Boolean value) {
            addCriterion("estimated_ship_date_set >=", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetLessThan(Boolean value) {
            addCriterion("estimated_ship_date_set <", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetLessThanOrEqualTo(Boolean value) {
            addCriterion("estimated_ship_date_set <=", value, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetIn(List<Boolean> values) {
            addCriterion("estimated_ship_date_set in", values, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetNotIn(List<Boolean> values) {
            addCriterion("estimated_ship_date_set not in", values, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetBetween(Boolean value1, Boolean value2) {
            addCriterion("estimated_ship_date_set between", value1, value2, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andEstimatedShipDateSetNotBetween(Boolean value1, Boolean value2) {
            addCriterion("estimated_ship_date_set not between", value1, value2, "estimatedShipDateSet");
            return (Criteria) this;
        }

        public Criteria andSoldByAbIsNull() {
            addCriterion("sold_by_ab is null");
            return (Criteria) this;
        }

        public Criteria andSoldByAbIsNotNull() {
            addCriterion("sold_by_ab is not null");
            return (Criteria) this;
        }

        public Criteria andSoldByAbEqualTo(Boolean value) {
            addCriterion("sold_by_ab =", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbNotEqualTo(Boolean value) {
            addCriterion("sold_by_ab <>", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbGreaterThan(Boolean value) {
            addCriterion("sold_by_ab >", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sold_by_ab >=", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbLessThan(Boolean value) {
            addCriterion("sold_by_ab <", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbLessThanOrEqualTo(Boolean value) {
            addCriterion("sold_by_ab <=", value, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbIn(List<Boolean> values) {
            addCriterion("sold_by_ab in", values, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbNotIn(List<Boolean> values) {
            addCriterion("sold_by_ab not in", values, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbBetween(Boolean value1, Boolean value2) {
            addCriterion("sold_by_ab between", value1, value2, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andSoldByAbNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sold_by_ab not between", value1, value2, "soldByAb");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressIsNull() {
            addCriterion("assigned_ship_from_location_address is null");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressIsNotNull() {
            addCriterion("assigned_ship_from_location_address is not null");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressEqualTo(String value) {
            addCriterion("assigned_ship_from_location_address =", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressNotEqualTo(String value) {
            addCriterion("assigned_ship_from_location_address <>", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressGreaterThan(String value) {
            addCriterion("assigned_ship_from_location_address >", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("assigned_ship_from_location_address >=", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressLessThan(String value) {
            addCriterion("assigned_ship_from_location_address <", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressLessThanOrEqualTo(String value) {
            addCriterion("assigned_ship_from_location_address <=", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressLike(String value) {
            addCriterion("assigned_ship_from_location_address like", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressNotLike(String value) {
            addCriterion("assigned_ship_from_location_address not like", value, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressIn(List<String> values) {
            addCriterion("assigned_ship_from_location_address in", values, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressNotIn(List<String> values) {
            addCriterion("assigned_ship_from_location_address not in", values, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressBetween(String value1, String value2) {
            addCriterion("assigned_ship_from_location_address between", value1, value2, "assignedShipFromLocationAddress");
            return (Criteria) this;
        }

        public Criteria andAssignedShipFromLocationAddressNotBetween(String value1, String value2) {
            addCriterion("assigned_ship_from_location_address not between", value1, value2, "assignedShipFromLocationAddress");
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

        public Criteria andStateOrRegionIsNull() {
            addCriterion("state_or_region is null");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionIsNotNull() {
            addCriterion("state_or_region is not null");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionEqualTo(String value) {
            addCriterion("state_or_region =", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionNotEqualTo(String value) {
            addCriterion("state_or_region <>", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionGreaterThan(String value) {
            addCriterion("state_or_region >", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionGreaterThanOrEqualTo(String value) {
            addCriterion("state_or_region >=", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionLessThan(String value) {
            addCriterion("state_or_region <", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionLessThanOrEqualTo(String value) {
            addCriterion("state_or_region <=", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionLike(String value) {
            addCriterion("state_or_region like", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionNotLike(String value) {
            addCriterion("state_or_region not like", value, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionIn(List<String> values) {
            addCriterion("state_or_region in", values, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionNotIn(List<String> values) {
            addCriterion("state_or_region not in", values, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionBetween(String value1, String value2) {
            addCriterion("state_or_region between", value1, value2, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andStateOrRegionNotBetween(String value1, String value2) {
            addCriterion("state_or_region not between", value1, value2, "stateOrRegion");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNull() {
            addCriterion("postal_code is null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNotNull() {
            addCriterion("postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeEqualTo(String value) {
            addCriterion("postal_code =", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotEqualTo(String value) {
            addCriterion("postal_code <>", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThan(String value) {
            addCriterion("postal_code >", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("postal_code >=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThan(String value) {
            addCriterion("postal_code <", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("postal_code <=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLike(String value) {
            addCriterion("postal_code like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotLike(String value) {
            addCriterion("postal_code not like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIn(List<String> values) {
            addCriterion("postal_code in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotIn(List<String> values) {
            addCriterion("postal_code not in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeBetween(String value1, String value2) {
            addCriterion("postal_code between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotBetween(String value1, String value2) {
            addCriterion("postal_code not between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andAddressLine1IsNull() {
            addCriterion("address_line1 is null");
            return (Criteria) this;
        }

        public Criteria andAddressLine1IsNotNull() {
            addCriterion("address_line1 is not null");
            return (Criteria) this;
        }

        public Criteria andAddressLine1EqualTo(String value) {
            addCriterion("address_line1 =", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotEqualTo(String value) {
            addCriterion("address_line1 <>", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1GreaterThan(String value) {
            addCriterion("address_line1 >", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1GreaterThanOrEqualTo(String value) {
            addCriterion("address_line1 >=", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1LessThan(String value) {
            addCriterion("address_line1 <", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1LessThanOrEqualTo(String value) {
            addCriterion("address_line1 <=", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1Like(String value) {
            addCriterion("address_line1 like", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotLike(String value) {
            addCriterion("address_line1 not like", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1In(List<String> values) {
            addCriterion("address_line1 in", values, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotIn(List<String> values) {
            addCriterion("address_line1 not in", values, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1Between(String value1, String value2) {
            addCriterion("address_line1 between", value1, value2, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotBetween(String value1, String value2) {
            addCriterion("address_line1 not between", value1, value2, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusIsNull() {
            addCriterion("sync_order_item_status is null");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusIsNotNull() {
            addCriterion("sync_order_item_status is not null");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusEqualTo(Integer value) {
            addCriterion("sync_order_item_status =", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusNotEqualTo(Integer value) {
            addCriterion("sync_order_item_status <>", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusGreaterThan(Integer value) {
            addCriterion("sync_order_item_status >", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sync_order_item_status >=", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusLessThan(Integer value) {
            addCriterion("sync_order_item_status <", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sync_order_item_status <=", value, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusIn(List<Integer> values) {
            addCriterion("sync_order_item_status in", values, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusNotIn(List<Integer> values) {
            addCriterion("sync_order_item_status not in", values, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusBetween(Integer value1, Integer value2) {
            addCriterion("sync_order_item_status between", value1, value2, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncOrderItemStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sync_order_item_status not between", value1, value2, "syncOrderItemStatus");
            return (Criteria) this;
        }

        public Criteria andSyncTimeIsNull() {
            addCriterion("sync_time is null");
            return (Criteria) this;
        }

        public Criteria andSyncTimeIsNotNull() {
            addCriterion("sync_time is not null");
            return (Criteria) this;
        }

        public Criteria andSyncTimeEqualTo(Date value) {
            addCriterion("sync_time =", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotEqualTo(Date value) {
            addCriterion("sync_time <>", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeGreaterThan(Date value) {
            addCriterion("sync_time >", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sync_time >=", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeLessThan(Date value) {
            addCriterion("sync_time <", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeLessThanOrEqualTo(Date value) {
            addCriterion("sync_time <=", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeIn(List<Date> values) {
            addCriterion("sync_time in", values, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotIn(List<Date> values) {
            addCriterion("sync_time not in", values, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeBetween(Date value1, Date value2) {
            addCriterion("sync_time between", value1, value2, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotBetween(Date value1, Date value2) {
            addCriterion("sync_time not between", value1, value2, "syncTime");
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