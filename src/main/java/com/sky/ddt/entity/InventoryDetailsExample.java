package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryDetailsExample() {
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

        public Criteria andFinanceIdIsNull() {
            addCriterion("finance_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Integer value) {
            addCriterion("finance_id =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Integer value) {
            addCriterion("finance_id <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Integer value) {
            addCriterion("finance_id >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_id >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Integer value) {
            addCriterion("finance_id <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("finance_id <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Integer> values) {
            addCriterion("finance_id in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Integer> values) {
            addCriterion("finance_id not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Integer value1, Integer value2) {
            addCriterion("finance_id between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_id not between", value1, value2, "financeId");
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

        public Criteria andFnskuIsNull() {
            addCriterion("fnsku is null");
            return (Criteria) this;
        }

        public Criteria andFnskuIsNotNull() {
            addCriterion("fnsku is not null");
            return (Criteria) this;
        }

        public Criteria andFnskuEqualTo(String value) {
            addCriterion("fnsku =", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotEqualTo(String value) {
            addCriterion("fnsku <>", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuGreaterThan(String value) {
            addCriterion("fnsku >", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuGreaterThanOrEqualTo(String value) {
            addCriterion("fnsku >=", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLessThan(String value) {
            addCriterion("fnsku <", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLessThanOrEqualTo(String value) {
            addCriterion("fnsku <=", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLike(String value) {
            addCriterion("fnsku like", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotLike(String value) {
            addCriterion("fnsku not like", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuIn(List<String> values) {
            addCriterion("fnsku in", values, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotIn(List<String> values) {
            addCriterion("fnsku not in", values, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuBetween(String value1, String value2) {
            addCriterion("fnsku between", value1, value2, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotBetween(String value1, String value2) {
            addCriterion("fnsku not between", value1, value2, "fnsku");
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

        public Criteria andYourPriceIsNull() {
            addCriterion("your_price is null");
            return (Criteria) this;
        }

        public Criteria andYourPriceIsNotNull() {
            addCriterion("your_price is not null");
            return (Criteria) this;
        }

        public Criteria andYourPriceEqualTo(BigDecimal value) {
            addCriterion("your_price =", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceNotEqualTo(BigDecimal value) {
            addCriterion("your_price <>", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceGreaterThan(BigDecimal value) {
            addCriterion("your_price >", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("your_price >=", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceLessThan(BigDecimal value) {
            addCriterion("your_price <", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("your_price <=", value, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceIn(List<BigDecimal> values) {
            addCriterion("your_price in", values, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceNotIn(List<BigDecimal> values) {
            addCriterion("your_price not in", values, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("your_price between", value1, value2, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andYourPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("your_price not between", value1, value2, "yourPrice");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsIsNull() {
            addCriterion("mfn_listing_exists is null");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsIsNotNull() {
            addCriterion("mfn_listing_exists is not null");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsEqualTo(String value) {
            addCriterion("mfn_listing_exists =", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsNotEqualTo(String value) {
            addCriterion("mfn_listing_exists <>", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsGreaterThan(String value) {
            addCriterion("mfn_listing_exists >", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsGreaterThanOrEqualTo(String value) {
            addCriterion("mfn_listing_exists >=", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsLessThan(String value) {
            addCriterion("mfn_listing_exists <", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsLessThanOrEqualTo(String value) {
            addCriterion("mfn_listing_exists <=", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsLike(String value) {
            addCriterion("mfn_listing_exists like", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsNotLike(String value) {
            addCriterion("mfn_listing_exists not like", value, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsIn(List<String> values) {
            addCriterion("mfn_listing_exists in", values, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsNotIn(List<String> values) {
            addCriterion("mfn_listing_exists not in", values, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsBetween(String value1, String value2) {
            addCriterion("mfn_listing_exists between", value1, value2, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnListingExistsNotBetween(String value1, String value2) {
            addCriterion("mfn_listing_exists not between", value1, value2, "mfnListingExists");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityIsNull() {
            addCriterion("mfn_fulfillable_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityIsNotNull() {
            addCriterion("mfn_fulfillable_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityEqualTo(Integer value) {
            addCriterion("mfn_fulfillable_quantity =", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityNotEqualTo(Integer value) {
            addCriterion("mfn_fulfillable_quantity <>", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityGreaterThan(Integer value) {
            addCriterion("mfn_fulfillable_quantity >", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("mfn_fulfillable_quantity >=", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityLessThan(Integer value) {
            addCriterion("mfn_fulfillable_quantity <", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("mfn_fulfillable_quantity <=", value, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityIn(List<Integer> values) {
            addCriterion("mfn_fulfillable_quantity in", values, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityNotIn(List<Integer> values) {
            addCriterion("mfn_fulfillable_quantity not in", values, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityBetween(Integer value1, Integer value2) {
            addCriterion("mfn_fulfillable_quantity between", value1, value2, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andMfnFulfillableQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("mfn_fulfillable_quantity not between", value1, value2, "mfnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsIsNull() {
            addCriterion("afn_listing_exists is null");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsIsNotNull() {
            addCriterion("afn_listing_exists is not null");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsEqualTo(String value) {
            addCriterion("afn_listing_exists =", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsNotEqualTo(String value) {
            addCriterion("afn_listing_exists <>", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsGreaterThan(String value) {
            addCriterion("afn_listing_exists >", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsGreaterThanOrEqualTo(String value) {
            addCriterion("afn_listing_exists >=", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsLessThan(String value) {
            addCriterion("afn_listing_exists <", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsLessThanOrEqualTo(String value) {
            addCriterion("afn_listing_exists <=", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsLike(String value) {
            addCriterion("afn_listing_exists like", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsNotLike(String value) {
            addCriterion("afn_listing_exists not like", value, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsIn(List<String> values) {
            addCriterion("afn_listing_exists in", values, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsNotIn(List<String> values) {
            addCriterion("afn_listing_exists not in", values, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsBetween(String value1, String value2) {
            addCriterion("afn_listing_exists between", value1, value2, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnListingExistsNotBetween(String value1, String value2) {
            addCriterion("afn_listing_exists not between", value1, value2, "afnListingExists");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityIsNull() {
            addCriterion("afn_warehouse_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityIsNotNull() {
            addCriterion("afn_warehouse_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityEqualTo(Integer value) {
            addCriterion("afn_warehouse_quantity =", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityNotEqualTo(Integer value) {
            addCriterion("afn_warehouse_quantity <>", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityGreaterThan(Integer value) {
            addCriterion("afn_warehouse_quantity >", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_warehouse_quantity >=", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityLessThan(Integer value) {
            addCriterion("afn_warehouse_quantity <", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_warehouse_quantity <=", value, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityIn(List<Integer> values) {
            addCriterion("afn_warehouse_quantity in", values, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityNotIn(List<Integer> values) {
            addCriterion("afn_warehouse_quantity not in", values, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_warehouse_quantity between", value1, value2, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnWarehouseQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_warehouse_quantity not between", value1, value2, "afnWarehouseQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityIsNull() {
            addCriterion("afn_fulfillable_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityIsNotNull() {
            addCriterion("afn_fulfillable_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityEqualTo(Integer value) {
            addCriterion("afn_fulfillable_quantity =", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityNotEqualTo(Integer value) {
            addCriterion("afn_fulfillable_quantity <>", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityGreaterThan(Integer value) {
            addCriterion("afn_fulfillable_quantity >", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_fulfillable_quantity >=", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityLessThan(Integer value) {
            addCriterion("afn_fulfillable_quantity <", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_fulfillable_quantity <=", value, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityIn(List<Integer> values) {
            addCriterion("afn_fulfillable_quantity in", values, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityNotIn(List<Integer> values) {
            addCriterion("afn_fulfillable_quantity not in", values, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_fulfillable_quantity between", value1, value2, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnFulfillableQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_fulfillable_quantity not between", value1, value2, "afnFulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityIsNull() {
            addCriterion("afn_unsellable_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityIsNotNull() {
            addCriterion("afn_unsellable_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityEqualTo(Integer value) {
            addCriterion("afn_unsellable_quantity =", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityNotEqualTo(Integer value) {
            addCriterion("afn_unsellable_quantity <>", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityGreaterThan(Integer value) {
            addCriterion("afn_unsellable_quantity >", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_unsellable_quantity >=", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityLessThan(Integer value) {
            addCriterion("afn_unsellable_quantity <", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_unsellable_quantity <=", value, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityIn(List<Integer> values) {
            addCriterion("afn_unsellable_quantity in", values, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityNotIn(List<Integer> values) {
            addCriterion("afn_unsellable_quantity not in", values, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_unsellable_quantity between", value1, value2, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnUnsellableQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_unsellable_quantity not between", value1, value2, "afnUnsellableQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityIsNull() {
            addCriterion("afn_reserved_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityIsNotNull() {
            addCriterion("afn_reserved_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityEqualTo(Integer value) {
            addCriterion("afn_reserved_quantity =", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityNotEqualTo(Integer value) {
            addCriterion("afn_reserved_quantity <>", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityGreaterThan(Integer value) {
            addCriterion("afn_reserved_quantity >", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_reserved_quantity >=", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityLessThan(Integer value) {
            addCriterion("afn_reserved_quantity <", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_reserved_quantity <=", value, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityIn(List<Integer> values) {
            addCriterion("afn_reserved_quantity in", values, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityNotIn(List<Integer> values) {
            addCriterion("afn_reserved_quantity not in", values, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_reserved_quantity between", value1, value2, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_reserved_quantity not between", value1, value2, "afnReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityIsNull() {
            addCriterion("afn_total_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityIsNotNull() {
            addCriterion("afn_total_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityEqualTo(Integer value) {
            addCriterion("afn_total_quantity =", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityNotEqualTo(Integer value) {
            addCriterion("afn_total_quantity <>", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityGreaterThan(Integer value) {
            addCriterion("afn_total_quantity >", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_total_quantity >=", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityLessThan(Integer value) {
            addCriterion("afn_total_quantity <", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_total_quantity <=", value, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityIn(List<Integer> values) {
            addCriterion("afn_total_quantity in", values, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityNotIn(List<Integer> values) {
            addCriterion("afn_total_quantity not in", values, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_total_quantity between", value1, value2, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnTotalQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_total_quantity not between", value1, value2, "afnTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIsNull() {
            addCriterion("per_unit_volume is null");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIsNotNull() {
            addCriterion("per_unit_volume is not null");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume =", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume <>", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeGreaterThan(BigDecimal value) {
            addCriterion("per_unit_volume >", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume >=", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeLessThan(BigDecimal value) {
            addCriterion("per_unit_volume <", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume <=", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIn(List<BigDecimal> values) {
            addCriterion("per_unit_volume in", values, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotIn(List<BigDecimal> values) {
            addCriterion("per_unit_volume not in", values, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_unit_volume between", value1, value2, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_unit_volume not between", value1, value2, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityIsNull() {
            addCriterion("afn_inbound_working_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityIsNotNull() {
            addCriterion("afn_inbound_working_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityEqualTo(Integer value) {
            addCriterion("afn_inbound_working_quantity =", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityNotEqualTo(Integer value) {
            addCriterion("afn_inbound_working_quantity <>", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityGreaterThan(Integer value) {
            addCriterion("afn_inbound_working_quantity >", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_working_quantity >=", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityLessThan(Integer value) {
            addCriterion("afn_inbound_working_quantity <", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_working_quantity <=", value, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityIn(List<Integer> values) {
            addCriterion("afn_inbound_working_quantity in", values, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityNotIn(List<Integer> values) {
            addCriterion("afn_inbound_working_quantity not in", values, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_working_quantity between", value1, value2, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundWorkingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_working_quantity not between", value1, value2, "afnInboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityIsNull() {
            addCriterion("afn_inbound_shipped_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityIsNotNull() {
            addCriterion("afn_inbound_shipped_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityEqualTo(Integer value) {
            addCriterion("afn_inbound_shipped_quantity =", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityNotEqualTo(Integer value) {
            addCriterion("afn_inbound_shipped_quantity <>", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityGreaterThan(Integer value) {
            addCriterion("afn_inbound_shipped_quantity >", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_shipped_quantity >=", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityLessThan(Integer value) {
            addCriterion("afn_inbound_shipped_quantity <", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_shipped_quantity <=", value, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityIn(List<Integer> values) {
            addCriterion("afn_inbound_shipped_quantity in", values, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityNotIn(List<Integer> values) {
            addCriterion("afn_inbound_shipped_quantity not in", values, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_shipped_quantity between", value1, value2, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundShippedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_shipped_quantity not between", value1, value2, "afnInboundShippedQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityIsNull() {
            addCriterion("afn_inbound_receiving_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityIsNotNull() {
            addCriterion("afn_inbound_receiving_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityEqualTo(Integer value) {
            addCriterion("afn_inbound_receiving_quantity =", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityNotEqualTo(Integer value) {
            addCriterion("afn_inbound_receiving_quantity <>", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityGreaterThan(Integer value) {
            addCriterion("afn_inbound_receiving_quantity >", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_receiving_quantity >=", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityLessThan(Integer value) {
            addCriterion("afn_inbound_receiving_quantity <", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_inbound_receiving_quantity <=", value, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityIn(List<Integer> values) {
            addCriterion("afn_inbound_receiving_quantity in", values, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityNotIn(List<Integer> values) {
            addCriterion("afn_inbound_receiving_quantity not in", values, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_receiving_quantity between", value1, value2, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnInboundReceivingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_inbound_receiving_quantity not between", value1, value2, "afnInboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityIsNull() {
            addCriterion("afn_researching_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityIsNotNull() {
            addCriterion("afn_researching_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityEqualTo(Integer value) {
            addCriterion("afn_researching_quantity =", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityNotEqualTo(Integer value) {
            addCriterion("afn_researching_quantity <>", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityGreaterThan(Integer value) {
            addCriterion("afn_researching_quantity >", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_researching_quantity >=", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityLessThan(Integer value) {
            addCriterion("afn_researching_quantity <", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("afn_researching_quantity <=", value, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityIn(List<Integer> values) {
            addCriterion("afn_researching_quantity in", values, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityNotIn(List<Integer> values) {
            addCriterion("afn_researching_quantity not in", values, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("afn_researching_quantity between", value1, value2, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnResearchingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_researching_quantity not between", value1, value2, "afnResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyIsNull() {
            addCriterion("afn_reserved_future_supply is null");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyIsNotNull() {
            addCriterion("afn_reserved_future_supply is not null");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyEqualTo(Integer value) {
            addCriterion("afn_reserved_future_supply =", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyNotEqualTo(Integer value) {
            addCriterion("afn_reserved_future_supply <>", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyGreaterThan(Integer value) {
            addCriterion("afn_reserved_future_supply >", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_reserved_future_supply >=", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyLessThan(Integer value) {
            addCriterion("afn_reserved_future_supply <", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyLessThanOrEqualTo(Integer value) {
            addCriterion("afn_reserved_future_supply <=", value, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyIn(List<Integer> values) {
            addCriterion("afn_reserved_future_supply in", values, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyNotIn(List<Integer> values) {
            addCriterion("afn_reserved_future_supply not in", values, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyBetween(Integer value1, Integer value2) {
            addCriterion("afn_reserved_future_supply between", value1, value2, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnReservedFutureSupplyNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_reserved_future_supply not between", value1, value2, "afnReservedFutureSupply");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableIsNull() {
            addCriterion("afn_future_supply_buyable is null");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableIsNotNull() {
            addCriterion("afn_future_supply_buyable is not null");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableEqualTo(Integer value) {
            addCriterion("afn_future_supply_buyable =", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableNotEqualTo(Integer value) {
            addCriterion("afn_future_supply_buyable <>", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableGreaterThan(Integer value) {
            addCriterion("afn_future_supply_buyable >", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableGreaterThanOrEqualTo(Integer value) {
            addCriterion("afn_future_supply_buyable >=", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableLessThan(Integer value) {
            addCriterion("afn_future_supply_buyable <", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableLessThanOrEqualTo(Integer value) {
            addCriterion("afn_future_supply_buyable <=", value, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableIn(List<Integer> values) {
            addCriterion("afn_future_supply_buyable in", values, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableNotIn(List<Integer> values) {
            addCriterion("afn_future_supply_buyable not in", values, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableBetween(Integer value1, Integer value2) {
            addCriterion("afn_future_supply_buyable between", value1, value2, "afnFutureSupplyBuyable");
            return (Criteria) this;
        }

        public Criteria andAfnFutureSupplyBuyableNotBetween(Integer value1, Integer value2) {
            addCriterion("afn_future_supply_buyable not between", value1, value2, "afnFutureSupplyBuyable");
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