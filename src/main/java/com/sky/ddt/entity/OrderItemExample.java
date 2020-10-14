package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
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

        public Criteria andSellerSkuIsNull() {
            addCriterion("seller_SKU is null");
            return (Criteria) this;
        }

        public Criteria andSellerSkuIsNotNull() {
            addCriterion("seller_SKU is not null");
            return (Criteria) this;
        }

        public Criteria andSellerSkuEqualTo(String value) {
            addCriterion("seller_SKU =", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotEqualTo(String value) {
            addCriterion("seller_SKU <>", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuGreaterThan(String value) {
            addCriterion("seller_SKU >", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuGreaterThanOrEqualTo(String value) {
            addCriterion("seller_SKU >=", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLessThan(String value) {
            addCriterion("seller_SKU <", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLessThanOrEqualTo(String value) {
            addCriterion("seller_SKU <=", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLike(String value) {
            addCriterion("seller_SKU like", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotLike(String value) {
            addCriterion("seller_SKU not like", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuIn(List<String> values) {
            addCriterion("seller_SKU in", values, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotIn(List<String> values) {
            addCriterion("seller_SKU not in", values, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuBetween(String value1, String value2) {
            addCriterion("seller_SKU between", value1, value2, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotBetween(String value1, String value2) {
            addCriterion("seller_SKU not between", value1, value2, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNull() {
            addCriterion("order_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNotNull() {
            addCriterion("order_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdEqualTo(String value) {
            addCriterion("order_item_id =", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotEqualTo(String value) {
            addCriterion("order_item_id <>", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThan(String value) {
            addCriterion("order_item_id >", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_item_id >=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThan(String value) {
            addCriterion("order_item_id <", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThanOrEqualTo(String value) {
            addCriterion("order_item_id <=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLike(String value) {
            addCriterion("order_item_id like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotLike(String value) {
            addCriterion("order_item_id not like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIn(List<String> values) {
            addCriterion("order_item_id in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotIn(List<String> values) {
            addCriterion("order_item_id not in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdBetween(String value1, String value2) {
            addCriterion("order_item_id between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotBetween(String value1, String value2) {
            addCriterion("order_item_id not between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedIsNull() {
            addCriterion("quantity_ordered is null");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedIsNotNull() {
            addCriterion("quantity_ordered is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedEqualTo(Integer value) {
            addCriterion("quantity_ordered =", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedNotEqualTo(Integer value) {
            addCriterion("quantity_ordered <>", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedGreaterThan(Integer value) {
            addCriterion("quantity_ordered >", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity_ordered >=", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedLessThan(Integer value) {
            addCriterion("quantity_ordered <", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedLessThanOrEqualTo(Integer value) {
            addCriterion("quantity_ordered <=", value, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedIn(List<Integer> values) {
            addCriterion("quantity_ordered in", values, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedNotIn(List<Integer> values) {
            addCriterion("quantity_ordered not in", values, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedBetween(Integer value1, Integer value2) {
            addCriterion("quantity_ordered between", value1, value2, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityOrderedNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity_ordered not between", value1, value2, "quantityOrdered");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedIsNull() {
            addCriterion("quantity_shipped is null");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedIsNotNull() {
            addCriterion("quantity_shipped is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedEqualTo(Integer value) {
            addCriterion("quantity_shipped =", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedNotEqualTo(Integer value) {
            addCriterion("quantity_shipped <>", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedGreaterThan(Integer value) {
            addCriterion("quantity_shipped >", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity_shipped >=", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedLessThan(Integer value) {
            addCriterion("quantity_shipped <", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedLessThanOrEqualTo(Integer value) {
            addCriterion("quantity_shipped <=", value, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedIn(List<Integer> values) {
            addCriterion("quantity_shipped in", values, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedNotIn(List<Integer> values) {
            addCriterion("quantity_shipped not in", values, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedBetween(Integer value1, Integer value2) {
            addCriterion("quantity_shipped between", value1, value2, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andQuantityShippedNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity_shipped not between", value1, value2, "quantityShipped");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeIsNull() {
            addCriterion("item_price_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeIsNotNull() {
            addCriterion("item_price_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeEqualTo(String value) {
            addCriterion("item_price_currency_code =", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeNotEqualTo(String value) {
            addCriterion("item_price_currency_code <>", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeGreaterThan(String value) {
            addCriterion("item_price_currency_code >", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_price_currency_code >=", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeLessThan(String value) {
            addCriterion("item_price_currency_code <", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("item_price_currency_code <=", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeLike(String value) {
            addCriterion("item_price_currency_code like", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeNotLike(String value) {
            addCriterion("item_price_currency_code not like", value, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeIn(List<String> values) {
            addCriterion("item_price_currency_code in", values, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeNotIn(List<String> values) {
            addCriterion("item_price_currency_code not in", values, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeBetween(String value1, String value2) {
            addCriterion("item_price_currency_code between", value1, value2, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("item_price_currency_code not between", value1, value2, "itemPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountIsNull() {
            addCriterion("item_price_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountIsNotNull() {
            addCriterion("item_price_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountEqualTo(BigDecimal value) {
            addCriterion("item_price_amount =", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_price_amount <>", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountGreaterThan(BigDecimal value) {
            addCriterion("item_price_amount >", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price_amount >=", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountLessThan(BigDecimal value) {
            addCriterion("item_price_amount <", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price_amount <=", value, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountIn(List<BigDecimal> values) {
            addCriterion("item_price_amount in", values, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_price_amount not in", values, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price_amount between", value1, value2, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemPriceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price_amount not between", value1, value2, "itemPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeIsNull() {
            addCriterion("shipping_price_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeIsNotNull() {
            addCriterion("shipping_price_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeEqualTo(String value) {
            addCriterion("shipping_price_currency_code =", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeNotEqualTo(String value) {
            addCriterion("shipping_price_currency_code <>", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeGreaterThan(String value) {
            addCriterion("shipping_price_currency_code >", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_price_currency_code >=", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeLessThan(String value) {
            addCriterion("shipping_price_currency_code <", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("shipping_price_currency_code <=", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeLike(String value) {
            addCriterion("shipping_price_currency_code like", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeNotLike(String value) {
            addCriterion("shipping_price_currency_code not like", value, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeIn(List<String> values) {
            addCriterion("shipping_price_currency_code in", values, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeNotIn(List<String> values) {
            addCriterion("shipping_price_currency_code not in", values, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeBetween(String value1, String value2) {
            addCriterion("shipping_price_currency_code between", value1, value2, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("shipping_price_currency_code not between", value1, value2, "shippingPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountIsNull() {
            addCriterion("shipping_price_amount is null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountIsNotNull() {
            addCriterion("shipping_price_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountEqualTo(BigDecimal value) {
            addCriterion("shipping_price_amount =", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountNotEqualTo(BigDecimal value) {
            addCriterion("shipping_price_amount <>", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountGreaterThan(BigDecimal value) {
            addCriterion("shipping_price_amount >", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_price_amount >=", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountLessThan(BigDecimal value) {
            addCriterion("shipping_price_amount <", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_price_amount <=", value, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountIn(List<BigDecimal> values) {
            addCriterion("shipping_price_amount in", values, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountNotIn(List<BigDecimal> values) {
            addCriterion("shipping_price_amount not in", values, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_price_amount between", value1, value2, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andShippingPriceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_price_amount not between", value1, value2, "shippingPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeIsNull() {
            addCriterion("gift_wrap_price_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeIsNotNull() {
            addCriterion("gift_wrap_price_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeEqualTo(String value) {
            addCriterion("gift_wrap_price_currency_code =", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeNotEqualTo(String value) {
            addCriterion("gift_wrap_price_currency_code <>", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeGreaterThan(String value) {
            addCriterion("gift_wrap_price_currency_code >", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("gift_wrap_price_currency_code >=", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeLessThan(String value) {
            addCriterion("gift_wrap_price_currency_code <", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("gift_wrap_price_currency_code <=", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeLike(String value) {
            addCriterion("gift_wrap_price_currency_code like", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeNotLike(String value) {
            addCriterion("gift_wrap_price_currency_code not like", value, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeIn(List<String> values) {
            addCriterion("gift_wrap_price_currency_code in", values, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeNotIn(List<String> values) {
            addCriterion("gift_wrap_price_currency_code not in", values, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeBetween(String value1, String value2) {
            addCriterion("gift_wrap_price_currency_code between", value1, value2, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("gift_wrap_price_currency_code not between", value1, value2, "giftWrapPriceCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountIsNull() {
            addCriterion("gift_wrap_price_amount is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountIsNotNull() {
            addCriterion("gift_wrap_price_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price_amount =", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price_amount <>", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_price_amount >", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price_amount >=", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountLessThan(BigDecimal value) {
            addCriterion("gift_wrap_price_amount <", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_price_amount <=", value, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_price_amount in", values, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_price_amount not in", values, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_price_amount between", value1, value2, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapPriceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_price_amount not between", value1, value2, "giftWrapPriceAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeIsNull() {
            addCriterion("item_tax_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeIsNotNull() {
            addCriterion("item_tax_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeEqualTo(String value) {
            addCriterion("item_tax_currency_code =", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeNotEqualTo(String value) {
            addCriterion("item_tax_currency_code <>", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeGreaterThan(String value) {
            addCriterion("item_tax_currency_code >", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_tax_currency_code >=", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeLessThan(String value) {
            addCriterion("item_tax_currency_code <", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("item_tax_currency_code <=", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeLike(String value) {
            addCriterion("item_tax_currency_code like", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeNotLike(String value) {
            addCriterion("item_tax_currency_code not like", value, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeIn(List<String> values) {
            addCriterion("item_tax_currency_code in", values, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeNotIn(List<String> values) {
            addCriterion("item_tax_currency_code not in", values, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeBetween(String value1, String value2) {
            addCriterion("item_tax_currency_code between", value1, value2, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("item_tax_currency_code not between", value1, value2, "itemTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountIsNull() {
            addCriterion("item_tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountIsNotNull() {
            addCriterion("item_tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountEqualTo(BigDecimal value) {
            addCriterion("item_tax_amount =", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_tax_amount <>", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("item_tax_amount >", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_tax_amount >=", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountLessThan(BigDecimal value) {
            addCriterion("item_tax_amount <", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_tax_amount <=", value, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountIn(List<BigDecimal> values) {
            addCriterion("item_tax_amount in", values, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_tax_amount not in", values, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_tax_amount between", value1, value2, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andItemTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_tax_amount not between", value1, value2, "itemTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeIsNull() {
            addCriterion("shipping_tax_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeIsNotNull() {
            addCriterion("shipping_tax_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeEqualTo(String value) {
            addCriterion("shipping_tax_currency_code =", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeNotEqualTo(String value) {
            addCriterion("shipping_tax_currency_code <>", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeGreaterThan(String value) {
            addCriterion("shipping_tax_currency_code >", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_tax_currency_code >=", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeLessThan(String value) {
            addCriterion("shipping_tax_currency_code <", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("shipping_tax_currency_code <=", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeLike(String value) {
            addCriterion("shipping_tax_currency_code like", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeNotLike(String value) {
            addCriterion("shipping_tax_currency_code not like", value, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeIn(List<String> values) {
            addCriterion("shipping_tax_currency_code in", values, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeNotIn(List<String> values) {
            addCriterion("shipping_tax_currency_code not in", values, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeBetween(String value1, String value2) {
            addCriterion("shipping_tax_currency_code between", value1, value2, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("shipping_tax_currency_code not between", value1, value2, "shippingTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountIsNull() {
            addCriterion("shipping_tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountIsNotNull() {
            addCriterion("shipping_tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountEqualTo(BigDecimal value) {
            addCriterion("shipping_tax_amount =", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("shipping_tax_amount <>", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("shipping_tax_amount >", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_tax_amount >=", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountLessThan(BigDecimal value) {
            addCriterion("shipping_tax_amount <", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_tax_amount <=", value, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountIn(List<BigDecimal> values) {
            addCriterion("shipping_tax_amount in", values, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("shipping_tax_amount not in", values, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_tax_amount between", value1, value2, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_tax_amount not between", value1, value2, "shippingTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeIsNull() {
            addCriterion("gift_wrap_tax_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeIsNotNull() {
            addCriterion("gift_wrap_tax_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeEqualTo(String value) {
            addCriterion("gift_wrap_tax_currency_code =", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeNotEqualTo(String value) {
            addCriterion("gift_wrap_tax_currency_code <>", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeGreaterThan(String value) {
            addCriterion("gift_wrap_tax_currency_code >", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("gift_wrap_tax_currency_code >=", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeLessThan(String value) {
            addCriterion("gift_wrap_tax_currency_code <", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("gift_wrap_tax_currency_code <=", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeLike(String value) {
            addCriterion("gift_wrap_tax_currency_code like", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeNotLike(String value) {
            addCriterion("gift_wrap_tax_currency_code not like", value, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeIn(List<String> values) {
            addCriterion("gift_wrap_tax_currency_code in", values, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeNotIn(List<String> values) {
            addCriterion("gift_wrap_tax_currency_code not in", values, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeBetween(String value1, String value2) {
            addCriterion("gift_wrap_tax_currency_code between", value1, value2, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("gift_wrap_tax_currency_code not between", value1, value2, "giftWrapTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountIsNull() {
            addCriterion("gift_wrap_tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountIsNotNull() {
            addCriterion("gift_wrap_tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount =", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount <>", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount >", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount >=", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountLessThan(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount <", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_tax_amount <=", value, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_tax_amount in", values, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_tax_amount not in", values, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_tax_amount between", value1, value2, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andGiftWrapTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_tax_amount not between", value1, value2, "giftWrapTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeIsNull() {
            addCriterion("shipping_discount_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeIsNotNull() {
            addCriterion("shipping_discount_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeEqualTo(String value) {
            addCriterion("shipping_discount_currency_code =", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeNotEqualTo(String value) {
            addCriterion("shipping_discount_currency_code <>", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeGreaterThan(String value) {
            addCriterion("shipping_discount_currency_code >", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_discount_currency_code >=", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeLessThan(String value) {
            addCriterion("shipping_discount_currency_code <", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("shipping_discount_currency_code <=", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeLike(String value) {
            addCriterion("shipping_discount_currency_code like", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeNotLike(String value) {
            addCriterion("shipping_discount_currency_code not like", value, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeIn(List<String> values) {
            addCriterion("shipping_discount_currency_code in", values, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeNotIn(List<String> values) {
            addCriterion("shipping_discount_currency_code not in", values, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeBetween(String value1, String value2) {
            addCriterion("shipping_discount_currency_code between", value1, value2, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("shipping_discount_currency_code not between", value1, value2, "shippingDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountIsNull() {
            addCriterion("shipping_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountIsNotNull() {
            addCriterion("shipping_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_amount =", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_amount <>", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("shipping_discount_amount >", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_amount >=", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountLessThan(BigDecimal value) {
            addCriterion("shipping_discount_amount <", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_amount <=", value, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("shipping_discount_amount in", values, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("shipping_discount_amount not in", values, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_discount_amount between", value1, value2, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_discount_amount not between", value1, value2, "shippingDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeIsNull() {
            addCriterion("shipping_discount_tax_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeIsNotNull() {
            addCriterion("shipping_discount_tax_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeEqualTo(String value) {
            addCriterion("shipping_discount_tax_currency_code =", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeNotEqualTo(String value) {
            addCriterion("shipping_discount_tax_currency_code <>", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeGreaterThan(String value) {
            addCriterion("shipping_discount_tax_currency_code >", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_discount_tax_currency_code >=", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeLessThan(String value) {
            addCriterion("shipping_discount_tax_currency_code <", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("shipping_discount_tax_currency_code <=", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeLike(String value) {
            addCriterion("shipping_discount_tax_currency_code like", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeNotLike(String value) {
            addCriterion("shipping_discount_tax_currency_code not like", value, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeIn(List<String> values) {
            addCriterion("shipping_discount_tax_currency_code in", values, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeNotIn(List<String> values) {
            addCriterion("shipping_discount_tax_currency_code not in", values, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeBetween(String value1, String value2) {
            addCriterion("shipping_discount_tax_currency_code between", value1, value2, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("shipping_discount_tax_currency_code not between", value1, value2, "shippingDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountIsNull() {
            addCriterion("shipping_discount_tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountIsNotNull() {
            addCriterion("shipping_discount_tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount =", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount <>", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount >", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount >=", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountLessThan(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount <", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_discount_tax_amount <=", value, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountIn(List<BigDecimal> values) {
            addCriterion("shipping_discount_tax_amount in", values, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("shipping_discount_tax_amount not in", values, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_discount_tax_amount between", value1, value2, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andShippingDiscountTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_discount_tax_amount not between", value1, value2, "shippingDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeIsNull() {
            addCriterion("promotion_discount_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeIsNotNull() {
            addCriterion("promotion_discount_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeEqualTo(String value) {
            addCriterion("promotion_discount_currency_code =", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeNotEqualTo(String value) {
            addCriterion("promotion_discount_currency_code <>", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeGreaterThan(String value) {
            addCriterion("promotion_discount_currency_code >", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_discount_currency_code >=", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeLessThan(String value) {
            addCriterion("promotion_discount_currency_code <", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("promotion_discount_currency_code <=", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeLike(String value) {
            addCriterion("promotion_discount_currency_code like", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeNotLike(String value) {
            addCriterion("promotion_discount_currency_code not like", value, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeIn(List<String> values) {
            addCriterion("promotion_discount_currency_code in", values, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeNotIn(List<String> values) {
            addCriterion("promotion_discount_currency_code not in", values, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeBetween(String value1, String value2) {
            addCriterion("promotion_discount_currency_code between", value1, value2, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("promotion_discount_currency_code not between", value1, value2, "promotionDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountIsNull() {
            addCriterion("promotion_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountIsNotNull() {
            addCriterion("promotion_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_amount =", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_amount <>", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_discount_amount >", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_amount >=", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountLessThan(BigDecimal value) {
            addCriterion("promotion_discount_amount <", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_amount <=", value, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_discount_amount in", values, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_discount_amount not in", values, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_discount_amount between", value1, value2, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_discount_amount not between", value1, value2, "promotionDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeIsNull() {
            addCriterion("promotion_discount_tax_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeIsNotNull() {
            addCriterion("promotion_discount_tax_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeEqualTo(String value) {
            addCriterion("promotion_discount_tax_currency_code =", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeNotEqualTo(String value) {
            addCriterion("promotion_discount_tax_currency_code <>", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeGreaterThan(String value) {
            addCriterion("promotion_discount_tax_currency_code >", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_discount_tax_currency_code >=", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeLessThan(String value) {
            addCriterion("promotion_discount_tax_currency_code <", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("promotion_discount_tax_currency_code <=", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeLike(String value) {
            addCriterion("promotion_discount_tax_currency_code like", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeNotLike(String value) {
            addCriterion("promotion_discount_tax_currency_code not like", value, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeIn(List<String> values) {
            addCriterion("promotion_discount_tax_currency_code in", values, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeNotIn(List<String> values) {
            addCriterion("promotion_discount_tax_currency_code not in", values, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeBetween(String value1, String value2) {
            addCriterion("promotion_discount_tax_currency_code between", value1, value2, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("promotion_discount_tax_currency_code not between", value1, value2, "promotionDiscountTaxCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountIsNull() {
            addCriterion("promotion_discount_tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountIsNotNull() {
            addCriterion("promotion_discount_tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount =", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount <>", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount >", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount >=", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountLessThan(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount <", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_discount_tax_amount <=", value, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_discount_tax_amount in", values, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_discount_tax_amount not in", values, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_discount_tax_amount between", value1, value2, "promotionDiscountTaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionDiscountTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_discount_tax_amount not between", value1, value2, "promotionDiscountTaxAmount");
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

        public Criteria andIsGiftIsNull() {
            addCriterion("is_gift is null");
            return (Criteria) this;
        }

        public Criteria andIsGiftIsNotNull() {
            addCriterion("is_gift is not null");
            return (Criteria) this;
        }

        public Criteria andIsGiftEqualTo(Boolean value) {
            addCriterion("is_gift =", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftNotEqualTo(Boolean value) {
            addCriterion("is_gift <>", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftGreaterThan(Boolean value) {
            addCriterion("is_gift >", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_gift >=", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftLessThan(Boolean value) {
            addCriterion("is_gift <", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftLessThanOrEqualTo(Boolean value) {
            addCriterion("is_gift <=", value, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftIn(List<Boolean> values) {
            addCriterion("is_gift in", values, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftNotIn(List<Boolean> values) {
            addCriterion("is_gift not in", values, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftBetween(Boolean value1, Boolean value2) {
            addCriterion("is_gift between", value1, value2, "isGift");
            return (Criteria) this;
        }

        public Criteria andIsGiftNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_gift not between", value1, value2, "isGift");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextIsNull() {
            addCriterion("gift_message_text is null");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextIsNotNull() {
            addCriterion("gift_message_text is not null");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextEqualTo(String value) {
            addCriterion("gift_message_text =", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextNotEqualTo(String value) {
            addCriterion("gift_message_text <>", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextGreaterThan(String value) {
            addCriterion("gift_message_text >", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextGreaterThanOrEqualTo(String value) {
            addCriterion("gift_message_text >=", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextLessThan(String value) {
            addCriterion("gift_message_text <", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextLessThanOrEqualTo(String value) {
            addCriterion("gift_message_text <=", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextLike(String value) {
            addCriterion("gift_message_text like", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextNotLike(String value) {
            addCriterion("gift_message_text not like", value, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextIn(List<String> values) {
            addCriterion("gift_message_text in", values, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextNotIn(List<String> values) {
            addCriterion("gift_message_text not in", values, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextBetween(String value1, String value2) {
            addCriterion("gift_message_text between", value1, value2, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftMessageTextNotBetween(String value1, String value2) {
            addCriterion("gift_message_text not between", value1, value2, "giftMessageText");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelIsNull() {
            addCriterion("gift_wrap_level is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelIsNotNull() {
            addCriterion("gift_wrap_level is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelEqualTo(String value) {
            addCriterion("gift_wrap_level =", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelNotEqualTo(String value) {
            addCriterion("gift_wrap_level <>", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelGreaterThan(String value) {
            addCriterion("gift_wrap_level >", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelGreaterThanOrEqualTo(String value) {
            addCriterion("gift_wrap_level >=", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelLessThan(String value) {
            addCriterion("gift_wrap_level <", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelLessThanOrEqualTo(String value) {
            addCriterion("gift_wrap_level <=", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelLike(String value) {
            addCriterion("gift_wrap_level like", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelNotLike(String value) {
            addCriterion("gift_wrap_level not like", value, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelIn(List<String> values) {
            addCriterion("gift_wrap_level in", values, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelNotIn(List<String> values) {
            addCriterion("gift_wrap_level not in", values, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelBetween(String value1, String value2) {
            addCriterion("gift_wrap_level between", value1, value2, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andGiftWrapLevelNotBetween(String value1, String value2) {
            addCriterion("gift_wrap_level not between", value1, value2, "giftWrapLevel");
            return (Criteria) this;
        }

        public Criteria andConditionNoteIsNull() {
            addCriterion("condition_note is null");
            return (Criteria) this;
        }

        public Criteria andConditionNoteIsNotNull() {
            addCriterion("condition_note is not null");
            return (Criteria) this;
        }

        public Criteria andConditionNoteEqualTo(String value) {
            addCriterion("condition_note =", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteNotEqualTo(String value) {
            addCriterion("condition_note <>", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteGreaterThan(String value) {
            addCriterion("condition_note >", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteGreaterThanOrEqualTo(String value) {
            addCriterion("condition_note >=", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteLessThan(String value) {
            addCriterion("condition_note <", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteLessThanOrEqualTo(String value) {
            addCriterion("condition_note <=", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteLike(String value) {
            addCriterion("condition_note like", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteNotLike(String value) {
            addCriterion("condition_note not like", value, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteIn(List<String> values) {
            addCriterion("condition_note in", values, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteNotIn(List<String> values) {
            addCriterion("condition_note not in", values, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteBetween(String value1, String value2) {
            addCriterion("condition_note between", value1, value2, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionNoteNotBetween(String value1, String value2) {
            addCriterion("condition_note not between", value1, value2, "conditionNote");
            return (Criteria) this;
        }

        public Criteria andConditionIdIsNull() {
            addCriterion("condition_id is null");
            return (Criteria) this;
        }

        public Criteria andConditionIdIsNotNull() {
            addCriterion("condition_id is not null");
            return (Criteria) this;
        }

        public Criteria andConditionIdEqualTo(String value) {
            addCriterion("condition_id =", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotEqualTo(String value) {
            addCriterion("condition_id <>", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdGreaterThan(String value) {
            addCriterion("condition_id >", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdGreaterThanOrEqualTo(String value) {
            addCriterion("condition_id >=", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdLessThan(String value) {
            addCriterion("condition_id <", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdLessThanOrEqualTo(String value) {
            addCriterion("condition_id <=", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdLike(String value) {
            addCriterion("condition_id like", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotLike(String value) {
            addCriterion("condition_id not like", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdIn(List<String> values) {
            addCriterion("condition_id in", values, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotIn(List<String> values) {
            addCriterion("condition_id not in", values, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdBetween(String value1, String value2) {
            addCriterion("condition_id between", value1, value2, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotBetween(String value1, String value2) {
            addCriterion("condition_id not between", value1, value2, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdIsNull() {
            addCriterion("condition_subtype_id is null");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdIsNotNull() {
            addCriterion("condition_subtype_id is not null");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdEqualTo(String value) {
            addCriterion("condition_subtype_id =", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdNotEqualTo(String value) {
            addCriterion("condition_subtype_id <>", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdGreaterThan(String value) {
            addCriterion("condition_subtype_id >", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("condition_subtype_id >=", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdLessThan(String value) {
            addCriterion("condition_subtype_id <", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdLessThanOrEqualTo(String value) {
            addCriterion("condition_subtype_id <=", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdLike(String value) {
            addCriterion("condition_subtype_id like", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdNotLike(String value) {
            addCriterion("condition_subtype_id not like", value, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdIn(List<String> values) {
            addCriterion("condition_subtype_id in", values, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdNotIn(List<String> values) {
            addCriterion("condition_subtype_id not in", values, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdBetween(String value1, String value2) {
            addCriterion("condition_subtype_id between", value1, value2, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andConditionSubtypeIdNotBetween(String value1, String value2) {
            addCriterion("condition_subtype_id not between", value1, value2, "conditionSubtypeId");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateIsNull() {
            addCriterion("scheduled_delivery_start_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateIsNotNull() {
            addCriterion("scheduled_delivery_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateEqualTo(String value) {
            addCriterion("scheduled_delivery_start_date =", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateNotEqualTo(String value) {
            addCriterion("scheduled_delivery_start_date <>", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateGreaterThan(String value) {
            addCriterion("scheduled_delivery_start_date >", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("scheduled_delivery_start_date >=", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateLessThan(String value) {
            addCriterion("scheduled_delivery_start_date <", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateLessThanOrEqualTo(String value) {
            addCriterion("scheduled_delivery_start_date <=", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateLike(String value) {
            addCriterion("scheduled_delivery_start_date like", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateNotLike(String value) {
            addCriterion("scheduled_delivery_start_date not like", value, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateIn(List<String> values) {
            addCriterion("scheduled_delivery_start_date in", values, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateNotIn(List<String> values) {
            addCriterion("scheduled_delivery_start_date not in", values, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateBetween(String value1, String value2) {
            addCriterion("scheduled_delivery_start_date between", value1, value2, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryStartDateNotBetween(String value1, String value2) {
            addCriterion("scheduled_delivery_start_date not between", value1, value2, "scheduledDeliveryStartDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateIsNull() {
            addCriterion("scheduled_delivery_end_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateIsNotNull() {
            addCriterion("scheduled_delivery_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateEqualTo(String value) {
            addCriterion("scheduled_delivery_end_date =", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateNotEqualTo(String value) {
            addCriterion("scheduled_delivery_end_date <>", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateGreaterThan(String value) {
            addCriterion("scheduled_delivery_end_date >", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("scheduled_delivery_end_date >=", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateLessThan(String value) {
            addCriterion("scheduled_delivery_end_date <", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateLessThanOrEqualTo(String value) {
            addCriterion("scheduled_delivery_end_date <=", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateLike(String value) {
            addCriterion("scheduled_delivery_end_date like", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateNotLike(String value) {
            addCriterion("scheduled_delivery_end_date not like", value, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateIn(List<String> values) {
            addCriterion("scheduled_delivery_end_date in", values, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateNotIn(List<String> values) {
            addCriterion("scheduled_delivery_end_date not in", values, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateBetween(String value1, String value2) {
            addCriterion("scheduled_delivery_end_date between", value1, value2, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andScheduledDeliveryEndDateNotBetween(String value1, String value2) {
            addCriterion("scheduled_delivery_end_date not between", value1, value2, "scheduledDeliveryEndDate");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredIsNull() {
            addCriterion("serial_number_required is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredIsNotNull() {
            addCriterion("serial_number_required is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredEqualTo(Boolean value) {
            addCriterion("serial_number_required =", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredNotEqualTo(Boolean value) {
            addCriterion("serial_number_required <>", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredGreaterThan(Boolean value) {
            addCriterion("serial_number_required >", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("serial_number_required >=", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredLessThan(Boolean value) {
            addCriterion("serial_number_required <", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("serial_number_required <=", value, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredIn(List<Boolean> values) {
            addCriterion("serial_number_required in", values, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredNotIn(List<Boolean> values) {
            addCriterion("serial_number_required not in", values, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("serial_number_required between", value1, value2, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andSerialNumberRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("serial_number_required not between", value1, value2, "serialNumberRequired");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyIsNull() {
            addCriterion("is_rransparency is null");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyIsNotNull() {
            addCriterion("is_rransparency is not null");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyEqualTo(Boolean value) {
            addCriterion("is_rransparency =", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyNotEqualTo(Boolean value) {
            addCriterion("is_rransparency <>", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyGreaterThan(Boolean value) {
            addCriterion("is_rransparency >", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_rransparency >=", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyLessThan(Boolean value) {
            addCriterion("is_rransparency <", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_rransparency <=", value, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyIn(List<Boolean> values) {
            addCriterion("is_rransparency in", values, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyNotIn(List<Boolean> values) {
            addCriterion("is_rransparency not in", values, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_rransparency between", value1, value2, "isRransparency");
            return (Criteria) this;
        }

        public Criteria andIsRransparencyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_rransparency not between", value1, value2, "isRransparency");
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

        public Criteria andCeateByIsNull() {
            addCriterion("ceate_by is null");
            return (Criteria) this;
        }

        public Criteria andCeateByIsNotNull() {
            addCriterion("ceate_by is not null");
            return (Criteria) this;
        }

        public Criteria andCeateByEqualTo(Integer value) {
            addCriterion("ceate_by =", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByNotEqualTo(Integer value) {
            addCriterion("ceate_by <>", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByGreaterThan(Integer value) {
            addCriterion("ceate_by >", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("ceate_by >=", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByLessThan(Integer value) {
            addCriterion("ceate_by <", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByLessThanOrEqualTo(Integer value) {
            addCriterion("ceate_by <=", value, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByIn(List<Integer> values) {
            addCriterion("ceate_by in", values, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByNotIn(List<Integer> values) {
            addCriterion("ceate_by not in", values, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByBetween(Integer value1, Integer value2) {
            addCriterion("ceate_by between", value1, value2, "ceateBy");
            return (Criteria) this;
        }

        public Criteria andCeateByNotBetween(Integer value1, Integer value2) {
            addCriterion("ceate_by not between", value1, value2, "ceateBy");
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

        public Criteria andCodFeeCurrencyCodeIsNull() {
            addCriterion("cod_fee_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeIsNotNull() {
            addCriterion("cod_fee_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeEqualTo(String value) {
            addCriterion("cod_fee_currency_code =", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeNotEqualTo(String value) {
            addCriterion("cod_fee_currency_code <>", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeGreaterThan(String value) {
            addCriterion("cod_fee_currency_code >", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cod_fee_currency_code >=", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeLessThan(String value) {
            addCriterion("cod_fee_currency_code <", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("cod_fee_currency_code <=", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeLike(String value) {
            addCriterion("cod_fee_currency_code like", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeNotLike(String value) {
            addCriterion("cod_fee_currency_code not like", value, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeIn(List<String> values) {
            addCriterion("cod_fee_currency_code in", values, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeNotIn(List<String> values) {
            addCriterion("cod_fee_currency_code not in", values, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeBetween(String value1, String value2) {
            addCriterion("cod_fee_currency_code between", value1, value2, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("cod_fee_currency_code not between", value1, value2, "codFeeCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountIsNull() {
            addCriterion("cod_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountIsNotNull() {
            addCriterion("cod_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountEqualTo(BigDecimal value) {
            addCriterion("cod_fee_amount =", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("cod_fee_amount <>", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("cod_fee_amount >", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cod_fee_amount >=", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountLessThan(BigDecimal value) {
            addCriterion("cod_fee_amount <", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cod_fee_amount <=", value, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountIn(List<BigDecimal> values) {
            addCriterion("cod_fee_amount in", values, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("cod_fee_amount not in", values, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cod_fee_amount between", value1, value2, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cod_fee_amount not between", value1, value2, "codFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeIsNull() {
            addCriterion("cod_fee_discount_currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeIsNotNull() {
            addCriterion("cod_fee_discount_currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeEqualTo(String value) {
            addCriterion("cod_fee_discount_currency_code =", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeNotEqualTo(String value) {
            addCriterion("cod_fee_discount_currency_code <>", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeGreaterThan(String value) {
            addCriterion("cod_fee_discount_currency_code >", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cod_fee_discount_currency_code >=", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeLessThan(String value) {
            addCriterion("cod_fee_discount_currency_code <", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("cod_fee_discount_currency_code <=", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeLike(String value) {
            addCriterion("cod_fee_discount_currency_code like", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeNotLike(String value) {
            addCriterion("cod_fee_discount_currency_code not like", value, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeIn(List<String> values) {
            addCriterion("cod_fee_discount_currency_code in", values, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeNotIn(List<String> values) {
            addCriterion("cod_fee_discount_currency_code not in", values, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeBetween(String value1, String value2) {
            addCriterion("cod_fee_discount_currency_code between", value1, value2, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("cod_fee_discount_currency_code not between", value1, value2, "codFeeDiscountCurrencyCode");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountIsNull() {
            addCriterion("cod_fee_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountIsNotNull() {
            addCriterion("cod_fee_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("cod_fee_discount_amount =", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("cod_fee_discount_amount <>", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("cod_fee_discount_amount >", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cod_fee_discount_amount >=", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountLessThan(BigDecimal value) {
            addCriterion("cod_fee_discount_amount <", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cod_fee_discount_amount <=", value, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("cod_fee_discount_amount in", values, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("cod_fee_discount_amount not in", values, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cod_fee_discount_amount between", value1, value2, "codFeeDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andCodFeeDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cod_fee_discount_amount not between", value1, value2, "codFeeDiscountAmount");
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