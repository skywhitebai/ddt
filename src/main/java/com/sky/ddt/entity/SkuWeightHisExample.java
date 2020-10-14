package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkuWeightHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkuWeightHisExample() {
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

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeIsNull() {
            addCriterion("weight_before is null");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeIsNotNull() {
            addCriterion("weight_before is not null");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeEqualTo(BigDecimal value) {
            addCriterion("weight_before =", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeNotEqualTo(BigDecimal value) {
            addCriterion("weight_before <>", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeGreaterThan(BigDecimal value) {
            addCriterion("weight_before >", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_before >=", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeLessThan(BigDecimal value) {
            addCriterion("weight_before <", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_before <=", value, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeIn(List<BigDecimal> values) {
            addCriterion("weight_before in", values, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeNotIn(List<BigDecimal> values) {
            addCriterion("weight_before not in", values, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_before between", value1, value2, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_before not between", value1, value2, "weightBefore");
            return (Criteria) this;
        }

        public Criteria andWeightAfterIsNull() {
            addCriterion("weight_after is null");
            return (Criteria) this;
        }

        public Criteria andWeightAfterIsNotNull() {
            addCriterion("weight_after is not null");
            return (Criteria) this;
        }

        public Criteria andWeightAfterEqualTo(BigDecimal value) {
            addCriterion("weight_after =", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterNotEqualTo(BigDecimal value) {
            addCriterion("weight_after <>", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterGreaterThan(BigDecimal value) {
            addCriterion("weight_after >", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_after >=", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterLessThan(BigDecimal value) {
            addCriterion("weight_after <", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_after <=", value, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterIn(List<BigDecimal> values) {
            addCriterion("weight_after in", values, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterNotIn(List<BigDecimal> values) {
            addCriterion("weight_after not in", values, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_after between", value1, value2, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andWeightAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_after not between", value1, value2, "weightAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIsNull() {
            addCriterion("head_trip_cost_before is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIsNotNull() {
            addCriterion("head_trip_cost_before is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before =", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before <>", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_before >", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before >=", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_before <", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before <=", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_before in", values, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_before not in", values, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_before between", value1, value2, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_before not between", value1, value2, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIsNull() {
            addCriterion("head_trip_cost_after is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIsNotNull() {
            addCriterion("head_trip_cost_after is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after =", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after <>", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_after >", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after >=", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_after <", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after <=", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_after in", values, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_after not in", values, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_after between", value1, value2, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_after not between", value1, value2, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeIsNull() {
            addCriterion("head_trip_cost_min_before is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeIsNotNull() {
            addCriterion("head_trip_cost_min_before is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_before =", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_before <>", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_min_before >", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_before >=", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_min_before <", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_before <=", value, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min_before in", values, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min_before not in", values, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min_before between", value1, value2, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min_before not between", value1, value2, "headTripCostMinBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterIsNull() {
            addCriterion("head_trip_cost_min_after is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterIsNotNull() {
            addCriterion("head_trip_cost_min_after is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_after =", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_after <>", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_min_after >", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_after >=", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_min_after <", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min_after <=", value, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min_after in", values, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min_after not in", values, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min_after between", value1, value2, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min_after not between", value1, value2, "headTripCostMinAfter");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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