package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MonthlyAdvertisingFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthlyAdvertisingFeeExample() {
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andAdMixNameIsNull() {
            addCriterion("ad_mix_name is null");
            return (Criteria) this;
        }

        public Criteria andAdMixNameIsNotNull() {
            addCriterion("ad_mix_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdMixNameEqualTo(String value) {
            addCriterion("ad_mix_name =", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameNotEqualTo(String value) {
            addCriterion("ad_mix_name <>", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameGreaterThan(String value) {
            addCriterion("ad_mix_name >", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_mix_name >=", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameLessThan(String value) {
            addCriterion("ad_mix_name <", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameLessThanOrEqualTo(String value) {
            addCriterion("ad_mix_name <=", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameLike(String value) {
            addCriterion("ad_mix_name like", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameNotLike(String value) {
            addCriterion("ad_mix_name not like", value, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameIn(List<String> values) {
            addCriterion("ad_mix_name in", values, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameNotIn(List<String> values) {
            addCriterion("ad_mix_name not in", values, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameBetween(String value1, String value2) {
            addCriterion("ad_mix_name between", value1, value2, "adMixName");
            return (Criteria) this;
        }

        public Criteria andAdMixNameNotBetween(String value1, String value2) {
            addCriterion("ad_mix_name not between", value1, value2, "adMixName");
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

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameIsNull() {
            addCriterion("ad_group_name is null");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameIsNotNull() {
            addCriterion("ad_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameEqualTo(String value) {
            addCriterion("ad_group_name =", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameNotEqualTo(String value) {
            addCriterion("ad_group_name <>", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameGreaterThan(String value) {
            addCriterion("ad_group_name >", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_group_name >=", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameLessThan(String value) {
            addCriterion("ad_group_name <", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameLessThanOrEqualTo(String value) {
            addCriterion("ad_group_name <=", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameLike(String value) {
            addCriterion("ad_group_name like", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameNotLike(String value) {
            addCriterion("ad_group_name not like", value, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameIn(List<String> values) {
            addCriterion("ad_group_name in", values, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameNotIn(List<String> values) {
            addCriterion("ad_group_name not in", values, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameBetween(String value1, String value2) {
            addCriterion("ad_group_name between", value1, value2, "adGroupName");
            return (Criteria) this;
        }

        public Criteria andAdGroupNameNotBetween(String value1, String value2) {
            addCriterion("ad_group_name not between", value1, value2, "adGroupName");
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

        public Criteria andDisplayQuantityIsNull() {
            addCriterion("display_quantity is null");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityIsNotNull() {
            addCriterion("display_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityEqualTo(Integer value) {
            addCriterion("display_quantity =", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityNotEqualTo(Integer value) {
            addCriterion("display_quantity <>", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityGreaterThan(Integer value) {
            addCriterion("display_quantity >", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_quantity >=", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityLessThan(Integer value) {
            addCriterion("display_quantity <", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("display_quantity <=", value, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityIn(List<Integer> values) {
            addCriterion("display_quantity in", values, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityNotIn(List<Integer> values) {
            addCriterion("display_quantity not in", values, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityBetween(Integer value1, Integer value2) {
            addCriterion("display_quantity between", value1, value2, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andDisplayQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("display_quantity not between", value1, value2, "displayQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityIsNull() {
            addCriterion("click_quantity is null");
            return (Criteria) this;
        }

        public Criteria andClickQuantityIsNotNull() {
            addCriterion("click_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andClickQuantityEqualTo(Integer value) {
            addCriterion("click_quantity =", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityNotEqualTo(Integer value) {
            addCriterion("click_quantity <>", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityGreaterThan(Integer value) {
            addCriterion("click_quantity >", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_quantity >=", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityLessThan(Integer value) {
            addCriterion("click_quantity <", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("click_quantity <=", value, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityIn(List<Integer> values) {
            addCriterion("click_quantity in", values, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityNotIn(List<Integer> values) {
            addCriterion("click_quantity not in", values, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityBetween(Integer value1, Integer value2) {
            addCriterion("click_quantity between", value1, value2, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("click_quantity not between", value1, value2, "clickQuantity");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateIsNull() {
            addCriterion("click_through_rate is null");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateIsNotNull() {
            addCriterion("click_through_rate is not null");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateEqualTo(BigDecimal value) {
            addCriterion("click_through_rate =", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateNotEqualTo(BigDecimal value) {
            addCriterion("click_through_rate <>", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateGreaterThan(BigDecimal value) {
            addCriterion("click_through_rate >", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("click_through_rate >=", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateLessThan(BigDecimal value) {
            addCriterion("click_through_rate <", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("click_through_rate <=", value, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateIn(List<BigDecimal> values) {
            addCriterion("click_through_rate in", values, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateNotIn(List<BigDecimal> values) {
            addCriterion("click_through_rate not in", values, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("click_through_rate between", value1, value2, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andClickThroughRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("click_through_rate not between", value1, value2, "clickThroughRate");
            return (Criteria) this;
        }

        public Criteria andCostPerClickIsNull() {
            addCriterion("cost_per_click is null");
            return (Criteria) this;
        }

        public Criteria andCostPerClickIsNotNull() {
            addCriterion("cost_per_click is not null");
            return (Criteria) this;
        }

        public Criteria andCostPerClickEqualTo(BigDecimal value) {
            addCriterion("cost_per_click =", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickNotEqualTo(BigDecimal value) {
            addCriterion("cost_per_click <>", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickGreaterThan(BigDecimal value) {
            addCriterion("cost_per_click >", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_per_click >=", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickLessThan(BigDecimal value) {
            addCriterion("cost_per_click <", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_per_click <=", value, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickIn(List<BigDecimal> values) {
            addCriterion("cost_per_click in", values, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickNotIn(List<BigDecimal> values) {
            addCriterion("cost_per_click not in", values, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_per_click between", value1, value2, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostPerClickNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_per_click not between", value1, value2, "costPerClick");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysIsNull() {
            addCriterion("total_sales_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysIsNotNull() {
            addCriterion("total_sales_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysEqualTo(BigDecimal value) {
            addCriterion("total_sales_in_7_days =", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysNotEqualTo(BigDecimal value) {
            addCriterion("total_sales_in_7_days <>", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysGreaterThan(BigDecimal value) {
            addCriterion("total_sales_in_7_days >", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_in_7_days >=", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysLessThan(BigDecimal value) {
            addCriterion("total_sales_in_7_days <", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_in_7_days <=", value, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysIn(List<BigDecimal> values) {
            addCriterion("total_sales_in_7_days in", values, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysNotIn(List<BigDecimal> values) {
            addCriterion("total_sales_in_7_days not in", values, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_in_7_days between", value1, value2, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesIn7DaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_in_7_days not between", value1, value2, "totalSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioIsNull() {
            addCriterion("advertising_cost_sales_ratio is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioIsNotNull() {
            addCriterion("advertising_cost_sales_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioEqualTo(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio =", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioNotEqualTo(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio <>", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioGreaterThan(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio >", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio >=", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioLessThan(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio <", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("advertising_cost_sales_ratio <=", value, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioIn(List<BigDecimal> values) {
            addCriterion("advertising_cost_sales_ratio in", values, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioNotIn(List<BigDecimal> values) {
            addCriterion("advertising_cost_sales_ratio not in", values, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advertising_cost_sales_ratio between", value1, value2, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andAdvertisingCostSalesRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advertising_cost_sales_ratio not between", value1, value2, "advertisingCostSalesRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioIsNull() {
            addCriterion("input_output_ratio is null");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioIsNotNull() {
            addCriterion("input_output_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioEqualTo(BigDecimal value) {
            addCriterion("input_output_ratio =", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioNotEqualTo(BigDecimal value) {
            addCriterion("input_output_ratio <>", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioGreaterThan(BigDecimal value) {
            addCriterion("input_output_ratio >", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("input_output_ratio >=", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioLessThan(BigDecimal value) {
            addCriterion("input_output_ratio <", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("input_output_ratio <=", value, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioIn(List<BigDecimal> values) {
            addCriterion("input_output_ratio in", values, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioNotIn(List<BigDecimal> values) {
            addCriterion("input_output_ratio not in", values, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("input_output_ratio between", value1, value2, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andInputOutputRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("input_output_ratio not between", value1, value2, "inputOutputRatio");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysIsNull() {
            addCriterion("total_orders_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysIsNotNull() {
            addCriterion("total_orders_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysEqualTo(Integer value) {
            addCriterion("total_orders_in_7_days =", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysNotEqualTo(Integer value) {
            addCriterion("total_orders_in_7_days <>", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysGreaterThan(Integer value) {
            addCriterion("total_orders_in_7_days >", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_orders_in_7_days >=", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysLessThan(Integer value) {
            addCriterion("total_orders_in_7_days <", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysLessThanOrEqualTo(Integer value) {
            addCriterion("total_orders_in_7_days <=", value, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysIn(List<Integer> values) {
            addCriterion("total_orders_in_7_days in", values, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysNotIn(List<Integer> values) {
            addCriterion("total_orders_in_7_days not in", values, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysBetween(Integer value1, Integer value2) {
            addCriterion("total_orders_in_7_days between", value1, value2, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersIn7DaysNotBetween(Integer value1, Integer value2) {
            addCriterion("total_orders_in_7_days not between", value1, value2, "totalOrdersIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysIsNull() {
            addCriterion("total_sales_quantity_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysIsNotNull() {
            addCriterion("total_sales_quantity_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysEqualTo(Integer value) {
            addCriterion("total_sales_quantity_in_7_days =", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysNotEqualTo(Integer value) {
            addCriterion("total_sales_quantity_in_7_days <>", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysGreaterThan(Integer value) {
            addCriterion("total_sales_quantity_in_7_days >", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_sales_quantity_in_7_days >=", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysLessThan(Integer value) {
            addCriterion("total_sales_quantity_in_7_days <", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysLessThanOrEqualTo(Integer value) {
            addCriterion("total_sales_quantity_in_7_days <=", value, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysIn(List<Integer> values) {
            addCriterion("total_sales_quantity_in_7_days in", values, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysNotIn(List<Integer> values) {
            addCriterion("total_sales_quantity_in_7_days not in", values, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysBetween(Integer value1, Integer value2) {
            addCriterion("total_sales_quantity_in_7_days between", value1, value2, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andTotalSalesQuantityIn7DaysNotBetween(Integer value1, Integer value2) {
            addCriterion("total_sales_quantity_in_7_days not between", value1, value2, "totalSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysIsNull() {
            addCriterion("conversion_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysIsNotNull() {
            addCriterion("conversion_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysEqualTo(BigDecimal value) {
            addCriterion("conversion_in_7_days =", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysNotEqualTo(BigDecimal value) {
            addCriterion("conversion_in_7_days <>", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysGreaterThan(BigDecimal value) {
            addCriterion("conversion_in_7_days >", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("conversion_in_7_days >=", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysLessThan(BigDecimal value) {
            addCriterion("conversion_in_7_days <", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("conversion_in_7_days <=", value, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysIn(List<BigDecimal> values) {
            addCriterion("conversion_in_7_days in", values, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysNotIn(List<BigDecimal> values) {
            addCriterion("conversion_in_7_days not in", values, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("conversion_in_7_days between", value1, value2, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andConversionIn7DaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("conversion_in_7_days not between", value1, value2, "conversionIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysIsNull() {
            addCriterion("ad_sku_sales_quantity_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysIsNotNull() {
            addCriterion("ad_sku_sales_quantity_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysEqualTo(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days =", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysNotEqualTo(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days <>", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysGreaterThan(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days >", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days >=", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysLessThan(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days <", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysLessThanOrEqualTo(Integer value) {
            addCriterion("ad_sku_sales_quantity_in_7_days <=", value, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysIn(List<Integer> values) {
            addCriterion("ad_sku_sales_quantity_in_7_days in", values, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysNotIn(List<Integer> values) {
            addCriterion("ad_sku_sales_quantity_in_7_days not in", values, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysBetween(Integer value1, Integer value2) {
            addCriterion("ad_sku_sales_quantity_in_7_days between", value1, value2, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesQuantityIn7DaysNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_sku_sales_quantity_in_7_days not between", value1, value2, "adSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysIsNull() {
            addCriterion("other_sku_sales_quantity_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysIsNotNull() {
            addCriterion("other_sku_sales_quantity_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysEqualTo(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days =", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysNotEqualTo(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days <>", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysGreaterThan(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days >", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days >=", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysLessThan(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days <", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysLessThanOrEqualTo(Integer value) {
            addCriterion("other_sku_sales_quantity_in_7_days <=", value, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysIn(List<Integer> values) {
            addCriterion("other_sku_sales_quantity_in_7_days in", values, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysNotIn(List<Integer> values) {
            addCriterion("other_sku_sales_quantity_in_7_days not in", values, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysBetween(Integer value1, Integer value2) {
            addCriterion("other_sku_sales_quantity_in_7_days between", value1, value2, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesQuantityIn7DaysNotBetween(Integer value1, Integer value2) {
            addCriterion("other_sku_sales_quantity_in_7_days not between", value1, value2, "otherSkuSalesQuantityIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysIsNull() {
            addCriterion("ad_sku_sales_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysIsNotNull() {
            addCriterion("ad_sku_sales_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysEqualTo(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days =", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysNotEqualTo(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days <>", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysGreaterThan(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days >", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days >=", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysLessThan(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days <", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ad_sku_sales_in_7_days <=", value, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysIn(List<BigDecimal> values) {
            addCriterion("ad_sku_sales_in_7_days in", values, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysNotIn(List<BigDecimal> values) {
            addCriterion("ad_sku_sales_in_7_days not in", values, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ad_sku_sales_in_7_days between", value1, value2, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andAdSkuSalesIn7DaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ad_sku_sales_in_7_days not between", value1, value2, "adSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysIsNull() {
            addCriterion("other_sku_sales_in_7_days is null");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysIsNotNull() {
            addCriterion("other_sku_sales_in_7_days is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysEqualTo(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days =", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysNotEqualTo(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days <>", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysGreaterThan(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days >", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days >=", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysLessThan(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days <", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_sku_sales_in_7_days <=", value, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysIn(List<BigDecimal> values) {
            addCriterion("other_sku_sales_in_7_days in", values, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysNotIn(List<BigDecimal> values) {
            addCriterion("other_sku_sales_in_7_days not in", values, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_sku_sales_in_7_days between", value1, value2, "otherSkuSalesIn7Days");
            return (Criteria) this;
        }

        public Criteria andOtherSkuSalesIn7DaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_sku_sales_in_7_days not between", value1, value2, "otherSkuSalesIn7Days");
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