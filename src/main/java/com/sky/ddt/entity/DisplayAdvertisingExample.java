package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DisplayAdvertisingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisplayAdvertisingExample() {
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

        public Criteria andCampaignNameIsNull() {
            addCriterion("campaign_name is null");
            return (Criteria) this;
        }

        public Criteria andCampaignNameIsNotNull() {
            addCriterion("campaign_name is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignNameEqualTo(String value) {
            addCriterion("campaign_name =", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotEqualTo(String value) {
            addCriterion("campaign_name <>", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameGreaterThan(String value) {
            addCriterion("campaign_name >", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_name >=", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLessThan(String value) {
            addCriterion("campaign_name <", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLessThanOrEqualTo(String value) {
            addCriterion("campaign_name <=", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLike(String value) {
            addCriterion("campaign_name like", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotLike(String value) {
            addCriterion("campaign_name not like", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameIn(List<String> values) {
            addCriterion("campaign_name in", values, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotIn(List<String> values) {
            addCriterion("campaign_name not in", values, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameBetween(String value1, String value2) {
            addCriterion("campaign_name between", value1, value2, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotBetween(String value1, String value2) {
            addCriterion("campaign_name not between", value1, value2, "campaignName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameIsNull() {
            addCriterion("portfolio_name is null");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameIsNotNull() {
            addCriterion("portfolio_name is not null");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameEqualTo(String value) {
            addCriterion("portfolio_name =", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameNotEqualTo(String value) {
            addCriterion("portfolio_name <>", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameGreaterThan(String value) {
            addCriterion("portfolio_name >", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameGreaterThanOrEqualTo(String value) {
            addCriterion("portfolio_name >=", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameLessThan(String value) {
            addCriterion("portfolio_name <", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameLessThanOrEqualTo(String value) {
            addCriterion("portfolio_name <=", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameLike(String value) {
            addCriterion("portfolio_name like", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameNotLike(String value) {
            addCriterion("portfolio_name not like", value, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameIn(List<String> values) {
            addCriterion("portfolio_name in", values, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameNotIn(List<String> values) {
            addCriterion("portfolio_name not in", values, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameBetween(String value1, String value2) {
            addCriterion("portfolio_name between", value1, value2, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andPortfolioNameNotBetween(String value1, String value2) {
            addCriterion("portfolio_name not between", value1, value2, "portfolioName");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNull() {
            addCriterion("cost_type is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("cost_type is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(String value) {
            addCriterion("cost_type =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(String value) {
            addCriterion("cost_type <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(String value) {
            addCriterion("cost_type >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cost_type >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(String value) {
            addCriterion("cost_type <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(String value) {
            addCriterion("cost_type <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLike(String value) {
            addCriterion("cost_type like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotLike(String value) {
            addCriterion("cost_type not like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<String> values) {
            addCriterion("cost_type in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<String> values) {
            addCriterion("cost_type not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(String value1, String value2) {
            addCriterion("cost_type between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(String value1, String value2) {
            addCriterion("cost_type not between", value1, value2, "costType");
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

        public Criteria andBidOptimizationIsNull() {
            addCriterion("bid_optimization is null");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationIsNotNull() {
            addCriterion("bid_optimization is not null");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationEqualTo(String value) {
            addCriterion("bid_optimization =", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationNotEqualTo(String value) {
            addCriterion("bid_optimization <>", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationGreaterThan(String value) {
            addCriterion("bid_optimization >", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationGreaterThanOrEqualTo(String value) {
            addCriterion("bid_optimization >=", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationLessThan(String value) {
            addCriterion("bid_optimization <", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationLessThanOrEqualTo(String value) {
            addCriterion("bid_optimization <=", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationLike(String value) {
            addCriterion("bid_optimization like", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationNotLike(String value) {
            addCriterion("bid_optimization not like", value, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationIn(List<String> values) {
            addCriterion("bid_optimization in", values, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationNotIn(List<String> values) {
            addCriterion("bid_optimization not in", values, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationBetween(String value1, String value2) {
            addCriterion("bid_optimization between", value1, value2, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andBidOptimizationNotBetween(String value1, String value2) {
            addCriterion("bid_optimization not between", value1, value2, "bidOptimization");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuIsNull() {
            addCriterion("advertised_sku is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuIsNotNull() {
            addCriterion("advertised_sku is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuEqualTo(String value) {
            addCriterion("advertised_sku =", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuNotEqualTo(String value) {
            addCriterion("advertised_sku <>", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuGreaterThan(String value) {
            addCriterion("advertised_sku >", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuGreaterThanOrEqualTo(String value) {
            addCriterion("advertised_sku >=", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuLessThan(String value) {
            addCriterion("advertised_sku <", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuLessThanOrEqualTo(String value) {
            addCriterion("advertised_sku <=", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuLike(String value) {
            addCriterion("advertised_sku like", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuNotLike(String value) {
            addCriterion("advertised_sku not like", value, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuIn(List<String> values) {
            addCriterion("advertised_sku in", values, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuNotIn(List<String> values) {
            addCriterion("advertised_sku not in", values, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuBetween(String value1, String value2) {
            addCriterion("advertised_sku between", value1, value2, "advertisedSku");
            return (Criteria) this;
        }

        public Criteria andAdvertisedSkuNotBetween(String value1, String value2) {
            addCriterion("advertised_sku not between", value1, value2, "advertisedSku");
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

        public Criteria andAdvertisedAsinIsNull() {
            addCriterion("advertised_asin is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinIsNotNull() {
            addCriterion("advertised_asin is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinEqualTo(String value) {
            addCriterion("advertised_asin =", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinNotEqualTo(String value) {
            addCriterion("advertised_asin <>", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinGreaterThan(String value) {
            addCriterion("advertised_asin >", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinGreaterThanOrEqualTo(String value) {
            addCriterion("advertised_asin >=", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinLessThan(String value) {
            addCriterion("advertised_asin <", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinLessThanOrEqualTo(String value) {
            addCriterion("advertised_asin <=", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinLike(String value) {
            addCriterion("advertised_asin like", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinNotLike(String value) {
            addCriterion("advertised_asin not like", value, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinIn(List<String> values) {
            addCriterion("advertised_asin in", values, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinNotIn(List<String> values) {
            addCriterion("advertised_asin not in", values, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinBetween(String value1, String value2) {
            addCriterion("advertised_asin between", value1, value2, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andAdvertisedAsinNotBetween(String value1, String value2) {
            addCriterion("advertised_asin not between", value1, value2, "advertisedAsin");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNull() {
            addCriterion("impressions is null");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNotNull() {
            addCriterion("impressions is not null");
            return (Criteria) this;
        }

        public Criteria andImpressionsEqualTo(Integer value) {
            addCriterion("impressions =", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotEqualTo(Integer value) {
            addCriterion("impressions <>", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThan(Integer value) {
            addCriterion("impressions >", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("impressions >=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThan(Integer value) {
            addCriterion("impressions <", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThanOrEqualTo(Integer value) {
            addCriterion("impressions <=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsIn(List<Integer> values) {
            addCriterion("impressions in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotIn(List<Integer> values) {
            addCriterion("impressions not in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsBetween(Integer value1, Integer value2) {
            addCriterion("impressions between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotBetween(Integer value1, Integer value2) {
            addCriterion("impressions not between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsIsNull() {
            addCriterion("viewable_impressions is null");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsIsNotNull() {
            addCriterion("viewable_impressions is not null");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsEqualTo(Integer value) {
            addCriterion("viewable_impressions =", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsNotEqualTo(Integer value) {
            addCriterion("viewable_impressions <>", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsGreaterThan(Integer value) {
            addCriterion("viewable_impressions >", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("viewable_impressions >=", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsLessThan(Integer value) {
            addCriterion("viewable_impressions <", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsLessThanOrEqualTo(Integer value) {
            addCriterion("viewable_impressions <=", value, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsIn(List<Integer> values) {
            addCriterion("viewable_impressions in", values, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsNotIn(List<Integer> values) {
            addCriterion("viewable_impressions not in", values, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsBetween(Integer value1, Integer value2) {
            addCriterion("viewable_impressions between", value1, value2, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andViewableImpressionsNotBetween(Integer value1, Integer value2) {
            addCriterion("viewable_impressions not between", value1, value2, "viewableImpressions");
            return (Criteria) this;
        }

        public Criteria andClicksIsNull() {
            addCriterion("clicks is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("clicks is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(Integer value) {
            addCriterion("clicks =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(Integer value) {
            addCriterion("clicks <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(Integer value) {
            addCriterion("clicks >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicks >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(Integer value) {
            addCriterion("clicks <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(Integer value) {
            addCriterion("clicks <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<Integer> values) {
            addCriterion("clicks in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<Integer> values) {
            addCriterion("clicks not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(Integer value1, Integer value2) {
            addCriterion("clicks between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("clicks not between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClickThruRateIsNull() {
            addCriterion("click_thru_rate is null");
            return (Criteria) this;
        }

        public Criteria andClickThruRateIsNotNull() {
            addCriterion("click_thru_rate is not null");
            return (Criteria) this;
        }

        public Criteria andClickThruRateEqualTo(BigDecimal value) {
            addCriterion("click_thru_rate =", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateNotEqualTo(BigDecimal value) {
            addCriterion("click_thru_rate <>", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateGreaterThan(BigDecimal value) {
            addCriterion("click_thru_rate >", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("click_thru_rate >=", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateLessThan(BigDecimal value) {
            addCriterion("click_thru_rate <", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("click_thru_rate <=", value, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateIn(List<BigDecimal> values) {
            addCriterion("click_thru_rate in", values, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateNotIn(List<BigDecimal> values) {
            addCriterion("click_thru_rate not in", values, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("click_thru_rate between", value1, value2, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andClickThruRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("click_thru_rate not between", value1, value2, "clickThruRate");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14IsNull() {
            addCriterion("page_views_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14IsNotNull() {
            addCriterion("page_views_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14EqualTo(Integer value) {
            addCriterion("page_views_day_14 =", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14NotEqualTo(Integer value) {
            addCriterion("page_views_day_14 <>", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14GreaterThan(Integer value) {
            addCriterion("page_views_day_14 >", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("page_views_day_14 >=", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14LessThan(Integer value) {
            addCriterion("page_views_day_14 <", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14LessThanOrEqualTo(Integer value) {
            addCriterion("page_views_day_14 <=", value, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14In(List<Integer> values) {
            addCriterion("page_views_day_14 in", values, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14NotIn(List<Integer> values) {
            addCriterion("page_views_day_14 not in", values, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14Between(Integer value1, Integer value2) {
            addCriterion("page_views_day_14 between", value1, value2, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andPageViewsDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("page_views_day_14 not between", value1, value2, "pageViewsDay14");
            return (Criteria) this;
        }

        public Criteria andSpendIsNull() {
            addCriterion("spend is null");
            return (Criteria) this;
        }

        public Criteria andSpendIsNotNull() {
            addCriterion("spend is not null");
            return (Criteria) this;
        }

        public Criteria andSpendEqualTo(BigDecimal value) {
            addCriterion("spend =", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotEqualTo(BigDecimal value) {
            addCriterion("spend <>", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendGreaterThan(BigDecimal value) {
            addCriterion("spend >", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spend >=", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendLessThan(BigDecimal value) {
            addCriterion("spend <", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spend <=", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendIn(List<BigDecimal> values) {
            addCriterion("spend in", values, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotIn(List<BigDecimal> values) {
            addCriterion("spend not in", values, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spend between", value1, value2, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spend not between", value1, value2, "spend");
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

        public Criteria andCostPer1000ViewableImpressionsIsNull() {
            addCriterion("cost_per_1000_viewable_impressions is null");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsIsNotNull() {
            addCriterion("cost_per_1000_viewable_impressions is not null");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsEqualTo(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions =", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsNotEqualTo(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions <>", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsGreaterThan(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions >", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions >=", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsLessThan(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions <", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsLessThanOrEqualTo(Integer value) {
            addCriterion("cost_per_1000_viewable_impressions <=", value, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsIn(List<Integer> values) {
            addCriterion("cost_per_1000_viewable_impressions in", values, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsNotIn(List<Integer> values) {
            addCriterion("cost_per_1000_viewable_impressions not in", values, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsBetween(Integer value1, Integer value2) {
            addCriterion("cost_per_1000_viewable_impressions between", value1, value2, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andCostPer1000ViewableImpressionsNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_per_1000_viewable_impressions not between", value1, value2, "costPer1000ViewableImpressions");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesIsNull() {
            addCriterion("total_advertising_cost_of_sales is null");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesIsNotNull() {
            addCriterion("total_advertising_cost_of_sales is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesEqualTo(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales =", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesNotEqualTo(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales <>", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesGreaterThan(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales >", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales >=", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesLessThan(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales <", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_advertising_cost_of_sales <=", value, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesIn(List<BigDecimal> values) {
            addCriterion("total_advertising_cost_of_sales in", values, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesNotIn(List<BigDecimal> values) {
            addCriterion("total_advertising_cost_of_sales not in", values, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_advertising_cost_of_sales between", value1, value2, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdvertisingCostOfSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_advertising_cost_of_sales not between", value1, value2, "totalAdvertisingCostOfSales");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendIsNull() {
            addCriterion("total_return_on_advertising_spend is null");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendIsNotNull() {
            addCriterion("total_return_on_advertising_spend is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendEqualTo(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend =", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendNotEqualTo(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend <>", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendGreaterThan(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend >", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend >=", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendLessThan(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend <", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_return_on_advertising_spend <=", value, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendIn(List<BigDecimal> values) {
            addCriterion("total_return_on_advertising_spend in", values, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendNotIn(List<BigDecimal> values) {
            addCriterion("total_return_on_advertising_spend not in", values, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_return_on_advertising_spend between", value1, value2, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalReturnOnAdvertisingSpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_return_on_advertising_spend not between", value1, value2, "totalReturnOnAdvertisingSpend");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14IsNull() {
            addCriterion("total_orders_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14IsNotNull() {
            addCriterion("total_orders_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14EqualTo(Integer value) {
            addCriterion("total_orders_day_14 =", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14NotEqualTo(Integer value) {
            addCriterion("total_orders_day_14 <>", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14GreaterThan(Integer value) {
            addCriterion("total_orders_day_14 >", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("total_orders_day_14 >=", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14LessThan(Integer value) {
            addCriterion("total_orders_day_14 <", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14LessThanOrEqualTo(Integer value) {
            addCriterion("total_orders_day_14 <=", value, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14In(List<Integer> values) {
            addCriterion("total_orders_day_14 in", values, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14NotIn(List<Integer> values) {
            addCriterion("total_orders_day_14 not in", values, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14Between(Integer value1, Integer value2) {
            addCriterion("total_orders_day_14 between", value1, value2, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalOrdersDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("total_orders_day_14 not between", value1, value2, "totalOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14IsNull() {
            addCriterion("total_units_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14IsNotNull() {
            addCriterion("total_units_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14EqualTo(Integer value) {
            addCriterion("total_units_day_14 =", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14NotEqualTo(Integer value) {
            addCriterion("total_units_day_14 <>", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14GreaterThan(Integer value) {
            addCriterion("total_units_day_14 >", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("total_units_day_14 >=", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14LessThan(Integer value) {
            addCriterion("total_units_day_14 <", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14LessThanOrEqualTo(Integer value) {
            addCriterion("total_units_day_14 <=", value, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14In(List<Integer> values) {
            addCriterion("total_units_day_14 in", values, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14NotIn(List<Integer> values) {
            addCriterion("total_units_day_14 not in", values, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14Between(Integer value1, Integer value2) {
            addCriterion("total_units_day_14 between", value1, value2, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("total_units_day_14 not between", value1, value2, "totalUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14IsNull() {
            addCriterion("total_sales_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14IsNotNull() {
            addCriterion("total_sales_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14EqualTo(BigDecimal value) {
            addCriterion("total_sales_day_14 =", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14NotEqualTo(BigDecimal value) {
            addCriterion("total_sales_day_14 <>", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14GreaterThan(BigDecimal value) {
            addCriterion("total_sales_day_14 >", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_day_14 >=", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14LessThan(BigDecimal value) {
            addCriterion("total_sales_day_14 <", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_day_14 <=", value, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14In(List<BigDecimal> values) {
            addCriterion("total_sales_day_14 in", values, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14NotIn(List<BigDecimal> values) {
            addCriterion("total_sales_day_14 not in", values, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_day_14 between", value1, value2, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andTotalSalesDay14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_day_14 not between", value1, value2, "totalSalesDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14IsNull() {
            addCriterion("conversion_rate_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14IsNotNull() {
            addCriterion("conversion_rate_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14EqualTo(BigDecimal value) {
            addCriterion("conversion_rate_day_14 =", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14NotEqualTo(BigDecimal value) {
            addCriterion("conversion_rate_day_14 <>", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14GreaterThan(BigDecimal value) {
            addCriterion("conversion_rate_day_14 >", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("conversion_rate_day_14 >=", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14LessThan(BigDecimal value) {
            addCriterion("conversion_rate_day_14 <", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("conversion_rate_day_14 <=", value, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14In(List<BigDecimal> values) {
            addCriterion("conversion_rate_day_14 in", values, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14NotIn(List<BigDecimal> values) {
            addCriterion("conversion_rate_day_14 not in", values, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("conversion_rate_day_14 between", value1, value2, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andConversionRateDay14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("conversion_rate_day_14 not between", value1, value2, "conversionRateDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14IsNull() {
            addCriterion("new_to_brand_orders_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14IsNotNull() {
            addCriterion("new_to_brand_orders_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14EqualTo(Integer value) {
            addCriterion("new_to_brand_orders_day_14 =", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14NotEqualTo(Integer value) {
            addCriterion("new_to_brand_orders_day_14 <>", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14GreaterThan(Integer value) {
            addCriterion("new_to_brand_orders_day_14 >", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("new_to_brand_orders_day_14 >=", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14LessThan(Integer value) {
            addCriterion("new_to_brand_orders_day_14 <", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14LessThanOrEqualTo(Integer value) {
            addCriterion("new_to_brand_orders_day_14 <=", value, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14In(List<Integer> values) {
            addCriterion("new_to_brand_orders_day_14 in", values, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14NotIn(List<Integer> values) {
            addCriterion("new_to_brand_orders_day_14 not in", values, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14Between(Integer value1, Integer value2) {
            addCriterion("new_to_brand_orders_day_14 between", value1, value2, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandOrdersDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("new_to_brand_orders_day_14 not between", value1, value2, "newToBrandOrdersDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14IsNull() {
            addCriterion("new_to_brand_sales_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14IsNotNull() {
            addCriterion("new_to_brand_sales_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14EqualTo(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 =", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14NotEqualTo(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 <>", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14GreaterThan(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 >", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 >=", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14LessThan(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 <", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_to_brand_sales_day_14 <=", value, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14In(List<BigDecimal> values) {
            addCriterion("new_to_brand_sales_day_14 in", values, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14NotIn(List<BigDecimal> values) {
            addCriterion("new_to_brand_sales_day_14 not in", values, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_to_brand_sales_day_14 between", value1, value2, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandSalesDay14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_to_brand_sales_day_14 not between", value1, value2, "newToBrandSalesDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14IsNull() {
            addCriterion("new_to_brand_units_day_14 is null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14IsNotNull() {
            addCriterion("new_to_brand_units_day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14EqualTo(Integer value) {
            addCriterion("new_to_brand_units_day_14 =", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14NotEqualTo(Integer value) {
            addCriterion("new_to_brand_units_day_14 <>", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14GreaterThan(Integer value) {
            addCriterion("new_to_brand_units_day_14 >", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("new_to_brand_units_day_14 >=", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14LessThan(Integer value) {
            addCriterion("new_to_brand_units_day_14 <", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14LessThanOrEqualTo(Integer value) {
            addCriterion("new_to_brand_units_day_14 <=", value, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14In(List<Integer> values) {
            addCriterion("new_to_brand_units_day_14 in", values, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14NotIn(List<Integer> values) {
            addCriterion("new_to_brand_units_day_14 not in", values, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14Between(Integer value1, Integer value2) {
            addCriterion("new_to_brand_units_day_14 between", value1, value2, "newToBrandUnitsDay14");
            return (Criteria) this;
        }

        public Criteria andNewToBrandUnitsDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("new_to_brand_units_day_14 not between", value1, value2, "newToBrandUnitsDay14");
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