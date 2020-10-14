package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthlyStorageFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthlyStorageFeeExample() {
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

        public Criteria andFulfillmentCenterIsNull() {
            addCriterion("fulfillment_center is null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterIsNotNull() {
            addCriterion("fulfillment_center is not null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterEqualTo(String value) {
            addCriterion("fulfillment_center =", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterNotEqualTo(String value) {
            addCriterion("fulfillment_center <>", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterGreaterThan(String value) {
            addCriterion("fulfillment_center >", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterGreaterThanOrEqualTo(String value) {
            addCriterion("fulfillment_center >=", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterLessThan(String value) {
            addCriterion("fulfillment_center <", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterLessThanOrEqualTo(String value) {
            addCriterion("fulfillment_center <=", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterLike(String value) {
            addCriterion("fulfillment_center like", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterNotLike(String value) {
            addCriterion("fulfillment_center not like", value, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterIn(List<String> values) {
            addCriterion("fulfillment_center in", values, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterNotIn(List<String> values) {
            addCriterion("fulfillment_center not in", values, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterBetween(String value1, String value2) {
            addCriterion("fulfillment_center between", value1, value2, "fulfillmentCenter");
            return (Criteria) this;
        }

        public Criteria andFulfillmentCenterNotBetween(String value1, String value2) {
            addCriterion("fulfillment_center not between", value1, value2, "fulfillmentCenter");
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

        public Criteria andLongestSideIsNull() {
            addCriterion("longest_side is null");
            return (Criteria) this;
        }

        public Criteria andLongestSideIsNotNull() {
            addCriterion("longest_side is not null");
            return (Criteria) this;
        }

        public Criteria andLongestSideEqualTo(BigDecimal value) {
            addCriterion("longest_side =", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideNotEqualTo(BigDecimal value) {
            addCriterion("longest_side <>", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideGreaterThan(BigDecimal value) {
            addCriterion("longest_side >", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longest_side >=", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideLessThan(BigDecimal value) {
            addCriterion("longest_side <", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longest_side <=", value, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideIn(List<BigDecimal> values) {
            addCriterion("longest_side in", values, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideNotIn(List<BigDecimal> values) {
            addCriterion("longest_side not in", values, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longest_side between", value1, value2, "longestSide");
            return (Criteria) this;
        }

        public Criteria andLongestSideNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longest_side not between", value1, value2, "longestSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideIsNull() {
            addCriterion("median_side is null");
            return (Criteria) this;
        }

        public Criteria andMedianSideIsNotNull() {
            addCriterion("median_side is not null");
            return (Criteria) this;
        }

        public Criteria andMedianSideEqualTo(BigDecimal value) {
            addCriterion("median_side =", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideNotEqualTo(BigDecimal value) {
            addCriterion("median_side <>", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideGreaterThan(BigDecimal value) {
            addCriterion("median_side >", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("median_side >=", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideLessThan(BigDecimal value) {
            addCriterion("median_side <", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideLessThanOrEqualTo(BigDecimal value) {
            addCriterion("median_side <=", value, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideIn(List<BigDecimal> values) {
            addCriterion("median_side in", values, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideNotIn(List<BigDecimal> values) {
            addCriterion("median_side not in", values, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("median_side between", value1, value2, "medianSide");
            return (Criteria) this;
        }

        public Criteria andMedianSideNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("median_side not between", value1, value2, "medianSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideIsNull() {
            addCriterion("shortest_side is null");
            return (Criteria) this;
        }

        public Criteria andShortestSideIsNotNull() {
            addCriterion("shortest_side is not null");
            return (Criteria) this;
        }

        public Criteria andShortestSideEqualTo(BigDecimal value) {
            addCriterion("shortest_side =", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideNotEqualTo(BigDecimal value) {
            addCriterion("shortest_side <>", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideGreaterThan(BigDecimal value) {
            addCriterion("shortest_side >", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shortest_side >=", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideLessThan(BigDecimal value) {
            addCriterion("shortest_side <", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shortest_side <=", value, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideIn(List<BigDecimal> values) {
            addCriterion("shortest_side in", values, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideNotIn(List<BigDecimal> values) {
            addCriterion("shortest_side not in", values, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shortest_side between", value1, value2, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andShortestSideNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shortest_side not between", value1, value2, "shortestSide");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsIsNull() {
            addCriterion("measurement_units is null");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsIsNotNull() {
            addCriterion("measurement_units is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsEqualTo(String value) {
            addCriterion("measurement_units =", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsNotEqualTo(String value) {
            addCriterion("measurement_units <>", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsGreaterThan(String value) {
            addCriterion("measurement_units >", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("measurement_units >=", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsLessThan(String value) {
            addCriterion("measurement_units <", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsLessThanOrEqualTo(String value) {
            addCriterion("measurement_units <=", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsLike(String value) {
            addCriterion("measurement_units like", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsNotLike(String value) {
            addCriterion("measurement_units not like", value, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsIn(List<String> values) {
            addCriterion("measurement_units in", values, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsNotIn(List<String> values) {
            addCriterion("measurement_units not in", values, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsBetween(String value1, String value2) {
            addCriterion("measurement_units between", value1, value2, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andMeasurementUnitsNotBetween(String value1, String value2) {
            addCriterion("measurement_units not between", value1, value2, "measurementUnits");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNull() {
            addCriterion("weight_units is null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNotNull() {
            addCriterion("weight_units is not null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsEqualTo(String value) {
            addCriterion("weight_units =", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotEqualTo(String value) {
            addCriterion("weight_units <>", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThan(String value) {
            addCriterion("weight_units >", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("weight_units >=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThan(String value) {
            addCriterion("weight_units <", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThanOrEqualTo(String value) {
            addCriterion("weight_units <=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLike(String value) {
            addCriterion("weight_units like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotLike(String value) {
            addCriterion("weight_units not like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIn(List<String> values) {
            addCriterion("weight_units in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotIn(List<String> values) {
            addCriterion("weight_units not in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsBetween(String value1, String value2) {
            addCriterion("weight_units between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotBetween(String value1, String value2) {
            addCriterion("weight_units not between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andItemVolumeIsNull() {
            addCriterion("item_volume is null");
            return (Criteria) this;
        }

        public Criteria andItemVolumeIsNotNull() {
            addCriterion("item_volume is not null");
            return (Criteria) this;
        }

        public Criteria andItemVolumeEqualTo(BigDecimal value) {
            addCriterion("item_volume =", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeNotEqualTo(BigDecimal value) {
            addCriterion("item_volume <>", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeGreaterThan(BigDecimal value) {
            addCriterion("item_volume >", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_volume >=", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeLessThan(BigDecimal value) {
            addCriterion("item_volume <", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_volume <=", value, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeIn(List<BigDecimal> values) {
            addCriterion("item_volume in", values, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeNotIn(List<BigDecimal> values) {
            addCriterion("item_volume not in", values, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_volume between", value1, value2, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andItemVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_volume not between", value1, value2, "itemVolume");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsIsNull() {
            addCriterion("volume_units is null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsIsNotNull() {
            addCriterion("volume_units is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsEqualTo(String value) {
            addCriterion("volume_units =", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsNotEqualTo(String value) {
            addCriterion("volume_units <>", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsGreaterThan(String value) {
            addCriterion("volume_units >", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("volume_units >=", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsLessThan(String value) {
            addCriterion("volume_units <", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsLessThanOrEqualTo(String value) {
            addCriterion("volume_units <=", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsLike(String value) {
            addCriterion("volume_units like", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsNotLike(String value) {
            addCriterion("volume_units not like", value, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsIn(List<String> values) {
            addCriterion("volume_units in", values, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsNotIn(List<String> values) {
            addCriterion("volume_units not in", values, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsBetween(String value1, String value2) {
            addCriterion("volume_units between", value1, value2, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitsNotBetween(String value1, String value2) {
            addCriterion("volume_units not between", value1, value2, "volumeUnits");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierIsNull() {
            addCriterion("product_size_tier is null");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierIsNotNull() {
            addCriterion("product_size_tier is not null");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierEqualTo(String value) {
            addCriterion("product_size_tier =", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierNotEqualTo(String value) {
            addCriterion("product_size_tier <>", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierGreaterThan(String value) {
            addCriterion("product_size_tier >", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierGreaterThanOrEqualTo(String value) {
            addCriterion("product_size_tier >=", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierLessThan(String value) {
            addCriterion("product_size_tier <", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierLessThanOrEqualTo(String value) {
            addCriterion("product_size_tier <=", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierLike(String value) {
            addCriterion("product_size_tier like", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierNotLike(String value) {
            addCriterion("product_size_tier not like", value, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierIn(List<String> values) {
            addCriterion("product_size_tier in", values, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierNotIn(List<String> values) {
            addCriterion("product_size_tier not in", values, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierBetween(String value1, String value2) {
            addCriterion("product_size_tier between", value1, value2, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andProductSizeTierNotBetween(String value1, String value2) {
            addCriterion("product_size_tier not between", value1, value2, "productSizeTier");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandIsNull() {
            addCriterion("average_quantity_on_hand is null");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandIsNotNull() {
            addCriterion("average_quantity_on_hand is not null");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandEqualTo(BigDecimal value) {
            addCriterion("average_quantity_on_hand =", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandNotEqualTo(BigDecimal value) {
            addCriterion("average_quantity_on_hand <>", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandGreaterThan(BigDecimal value) {
            addCriterion("average_quantity_on_hand >", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average_quantity_on_hand >=", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandLessThan(BigDecimal value) {
            addCriterion("average_quantity_on_hand <", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average_quantity_on_hand <=", value, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandIn(List<BigDecimal> values) {
            addCriterion("average_quantity_on_hand in", values, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandNotIn(List<BigDecimal> values) {
            addCriterion("average_quantity_on_hand not in", values, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_quantity_on_hand between", value1, value2, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityOnHandNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_quantity_on_hand not between", value1, value2, "averageQuantityOnHand");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalIsNull() {
            addCriterion("average_quantity_pending_removal is null");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalIsNotNull() {
            addCriterion("average_quantity_pending_removal is not null");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalEqualTo(BigDecimal value) {
            addCriterion("average_quantity_pending_removal =", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalNotEqualTo(BigDecimal value) {
            addCriterion("average_quantity_pending_removal <>", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalGreaterThan(BigDecimal value) {
            addCriterion("average_quantity_pending_removal >", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average_quantity_pending_removal >=", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalLessThan(BigDecimal value) {
            addCriterion("average_quantity_pending_removal <", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average_quantity_pending_removal <=", value, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalIn(List<BigDecimal> values) {
            addCriterion("average_quantity_pending_removal in", values, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalNotIn(List<BigDecimal> values) {
            addCriterion("average_quantity_pending_removal not in", values, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_quantity_pending_removal between", value1, value2, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andAverageQuantityPendingRemovalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_quantity_pending_removal not between", value1, value2, "averageQuantityPendingRemoval");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeIsNull() {
            addCriterion("estimated_total_item_volume is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeIsNotNull() {
            addCriterion("estimated_total_item_volume is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeEqualTo(BigDecimal value) {
            addCriterion("estimated_total_item_volume =", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeNotEqualTo(BigDecimal value) {
            addCriterion("estimated_total_item_volume <>", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeGreaterThan(BigDecimal value) {
            addCriterion("estimated_total_item_volume >", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("estimated_total_item_volume >=", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeLessThan(BigDecimal value) {
            addCriterion("estimated_total_item_volume <", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("estimated_total_item_volume <=", value, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeIn(List<BigDecimal> values) {
            addCriterion("estimated_total_item_volume in", values, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeNotIn(List<BigDecimal> values) {
            addCriterion("estimated_total_item_volume not in", values, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimated_total_item_volume between", value1, value2, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andEstimatedTotalItemVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimated_total_item_volume not between", value1, value2, "estimatedTotalItemVolume");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeIsNull() {
            addCriterion("month_of_charge is null");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeIsNotNull() {
            addCriterion("month_of_charge is not null");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeEqualTo(String value) {
            addCriterion("month_of_charge =", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeNotEqualTo(String value) {
            addCriterion("month_of_charge <>", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeGreaterThan(String value) {
            addCriterion("month_of_charge >", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeGreaterThanOrEqualTo(String value) {
            addCriterion("month_of_charge >=", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeLessThan(String value) {
            addCriterion("month_of_charge <", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeLessThanOrEqualTo(String value) {
            addCriterion("month_of_charge <=", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeLike(String value) {
            addCriterion("month_of_charge like", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeNotLike(String value) {
            addCriterion("month_of_charge not like", value, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeIn(List<String> values) {
            addCriterion("month_of_charge in", values, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeNotIn(List<String> values) {
            addCriterion("month_of_charge not in", values, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeBetween(String value1, String value2) {
            addCriterion("month_of_charge between", value1, value2, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andMonthOfChargeNotBetween(String value1, String value2) {
            addCriterion("month_of_charge not between", value1, value2, "monthOfCharge");
            return (Criteria) this;
        }

        public Criteria andStorageRateIsNull() {
            addCriterion("storage_rate is null");
            return (Criteria) this;
        }

        public Criteria andStorageRateIsNotNull() {
            addCriterion("storage_rate is not null");
            return (Criteria) this;
        }

        public Criteria andStorageRateEqualTo(BigDecimal value) {
            addCriterion("storage_rate =", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateNotEqualTo(BigDecimal value) {
            addCriterion("storage_rate <>", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateGreaterThan(BigDecimal value) {
            addCriterion("storage_rate >", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("storage_rate >=", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateLessThan(BigDecimal value) {
            addCriterion("storage_rate <", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("storage_rate <=", value, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateIn(List<BigDecimal> values) {
            addCriterion("storage_rate in", values, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateNotIn(List<BigDecimal> values) {
            addCriterion("storage_rate not in", values, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("storage_rate between", value1, value2, "storageRate");
            return (Criteria) this;
        }

        public Criteria andStorageRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("storage_rate not between", value1, value2, "storageRate");
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

        public Criteria andEstimatedMonthlyStorageFeeIsNull() {
            addCriterion("estimated_monthly_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeIsNotNull() {
            addCriterion("estimated_monthly_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeEqualTo(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee =", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee <>", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee >", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee >=", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeLessThan(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee <", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("estimated_monthly_storage_fee <=", value, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeIn(List<BigDecimal> values) {
            addCriterion("estimated_monthly_storage_fee in", values, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("estimated_monthly_storage_fee not in", values, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimated_monthly_storage_fee between", value1, value2, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andEstimatedMonthlyStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimated_monthly_storage_fee not between", value1, value2, "estimatedMonthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeIsNull() {
            addCriterion("dangerous_goods_storage_type is null");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeIsNotNull() {
            addCriterion("dangerous_goods_storage_type is not null");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeEqualTo(String value) {
            addCriterion("dangerous_goods_storage_type =", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeNotEqualTo(String value) {
            addCriterion("dangerous_goods_storage_type <>", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeGreaterThan(String value) {
            addCriterion("dangerous_goods_storage_type >", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dangerous_goods_storage_type >=", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeLessThan(String value) {
            addCriterion("dangerous_goods_storage_type <", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeLessThanOrEqualTo(String value) {
            addCriterion("dangerous_goods_storage_type <=", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeLike(String value) {
            addCriterion("dangerous_goods_storage_type like", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeNotLike(String value) {
            addCriterion("dangerous_goods_storage_type not like", value, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeIn(List<String> values) {
            addCriterion("dangerous_goods_storage_type in", values, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeNotIn(List<String> values) {
            addCriterion("dangerous_goods_storage_type not in", values, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeBetween(String value1, String value2) {
            addCriterion("dangerous_goods_storage_type between", value1, value2, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andDangerousGoodsStorageTypeNotBetween(String value1, String value2) {
            addCriterion("dangerous_goods_storage_type not between", value1, value2, "dangerousGoodsStorageType");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountIsNull() {
            addCriterion("eligible_for_inventory_discount is null");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountIsNotNull() {
            addCriterion("eligible_for_inventory_discount is not null");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountEqualTo(Boolean value) {
            addCriterion("eligible_for_inventory_discount =", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountNotEqualTo(Boolean value) {
            addCriterion("eligible_for_inventory_discount <>", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountGreaterThan(Boolean value) {
            addCriterion("eligible_for_inventory_discount >", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountGreaterThanOrEqualTo(Boolean value) {
            addCriterion("eligible_for_inventory_discount >=", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountLessThan(Boolean value) {
            addCriterion("eligible_for_inventory_discount <", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountLessThanOrEqualTo(Boolean value) {
            addCriterion("eligible_for_inventory_discount <=", value, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountIn(List<Boolean> values) {
            addCriterion("eligible_for_inventory_discount in", values, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountNotIn(List<Boolean> values) {
            addCriterion("eligible_for_inventory_discount not in", values, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountBetween(Boolean value1, Boolean value2) {
            addCriterion("eligible_for_inventory_discount between", value1, value2, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andEligibleForInventoryDiscountNotBetween(Boolean value1, Boolean value2) {
            addCriterion("eligible_for_inventory_discount not between", value1, value2, "eligibleForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountIsNull() {
            addCriterion("qualifies_for_inventory_discount is null");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountIsNotNull() {
            addCriterion("qualifies_for_inventory_discount is not null");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountEqualTo(Boolean value) {
            addCriterion("qualifies_for_inventory_discount =", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountNotEqualTo(Boolean value) {
            addCriterion("qualifies_for_inventory_discount <>", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountGreaterThan(Boolean value) {
            addCriterion("qualifies_for_inventory_discount >", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountGreaterThanOrEqualTo(Boolean value) {
            addCriterion("qualifies_for_inventory_discount >=", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountLessThan(Boolean value) {
            addCriterion("qualifies_for_inventory_discount <", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountLessThanOrEqualTo(Boolean value) {
            addCriterion("qualifies_for_inventory_discount <=", value, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountIn(List<Boolean> values) {
            addCriterion("qualifies_for_inventory_discount in", values, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountNotIn(List<Boolean> values) {
            addCriterion("qualifies_for_inventory_discount not in", values, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountBetween(Boolean value1, Boolean value2) {
            addCriterion("qualifies_for_inventory_discount between", value1, value2, "qualifiesForInventoryDiscount");
            return (Criteria) this;
        }

        public Criteria andQualifiesForInventoryDiscountNotBetween(Boolean value1, Boolean value2) {
            addCriterion("qualifies_for_inventory_discount not between", value1, value2, "qualifiesForInventoryDiscount");
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