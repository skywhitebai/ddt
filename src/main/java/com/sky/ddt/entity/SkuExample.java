package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkuExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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

        public Criteria andColourIsNull() {
            addCriterion("colour is null");
            return (Criteria) this;
        }

        public Criteria andColourIsNotNull() {
            addCriterion("colour is not null");
            return (Criteria) this;
        }

        public Criteria andColourEqualTo(String value) {
            addCriterion("colour =", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotEqualTo(String value) {
            addCriterion("colour <>", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThan(String value) {
            addCriterion("colour >", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThanOrEqualTo(String value) {
            addCriterion("colour >=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThan(String value) {
            addCriterion("colour <", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThanOrEqualTo(String value) {
            addCriterion("colour <=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLike(String value) {
            addCriterion("colour like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotLike(String value) {
            addCriterion("colour not like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourIn(List<String> values) {
            addCriterion("colour in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotIn(List<String> values) {
            addCriterion("colour not in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourBetween(String value1, String value2) {
            addCriterion("colour between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotBetween(String value1, String value2) {
            addCriterion("colour not between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNumberIsNull() {
            addCriterion("colour_number is null");
            return (Criteria) this;
        }

        public Criteria andColourNumberIsNotNull() {
            addCriterion("colour_number is not null");
            return (Criteria) this;
        }

        public Criteria andColourNumberEqualTo(String value) {
            addCriterion("colour_number =", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberNotEqualTo(String value) {
            addCriterion("colour_number <>", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberGreaterThan(String value) {
            addCriterion("colour_number >", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberGreaterThanOrEqualTo(String value) {
            addCriterion("colour_number >=", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberLessThan(String value) {
            addCriterion("colour_number <", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberLessThanOrEqualTo(String value) {
            addCriterion("colour_number <=", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberLike(String value) {
            addCriterion("colour_number like", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberNotLike(String value) {
            addCriterion("colour_number not like", value, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberIn(List<String> values) {
            addCriterion("colour_number in", values, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberNotIn(List<String> values) {
            addCriterion("colour_number not in", values, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberBetween(String value1, String value2) {
            addCriterion("colour_number between", value1, value2, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andColourNumberNotBetween(String value1, String value2) {
            addCriterion("colour_number not between", value1, value2, "colourNumber");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
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

        public Criteria andCostPriceIsNull() {
            addCriterion("cost_price is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceEqualTo(BigDecimal value) {
            addCriterion("cost_price =", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("cost_price <>", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThan(BigDecimal value) {
            addCriterion("cost_price >", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price >=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThan(BigDecimal value) {
            addCriterion("cost_price <", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price <=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceIn(List<BigDecimal> values) {
            addCriterion("cost_price in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("cost_price not in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price not between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIsNull() {
            addCriterion("head_trip_cost is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIsNotNull() {
            addCriterion("head_trip_cost is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost =", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost <>", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost >", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost >=", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostLessThan(BigDecimal value) {
            addCriterion("head_trip_cost <", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost <=", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost in", values, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost not in", values, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost between", value1, value2, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost not between", value1, value2, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinIsNull() {
            addCriterion("head_trip_cost_min is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinIsNotNull() {
            addCriterion("head_trip_cost_min is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min =", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min <>", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_min >", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min >=", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_min <", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_min <=", value, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min in", values, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_min not in", values, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min between", value1, value2, "headTripCostMin");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_min not between", value1, value2, "headTripCostMin");
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

        public Criteria andSecondSkuIsNull() {
            addCriterion("second_sku is null");
            return (Criteria) this;
        }

        public Criteria andSecondSkuIsNotNull() {
            addCriterion("second_sku is not null");
            return (Criteria) this;
        }

        public Criteria andSecondSkuEqualTo(String value) {
            addCriterion("second_sku =", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuNotEqualTo(String value) {
            addCriterion("second_sku <>", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuGreaterThan(String value) {
            addCriterion("second_sku >", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuGreaterThanOrEqualTo(String value) {
            addCriterion("second_sku >=", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuLessThan(String value) {
            addCriterion("second_sku <", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuLessThanOrEqualTo(String value) {
            addCriterion("second_sku <=", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuLike(String value) {
            addCriterion("second_sku like", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuNotLike(String value) {
            addCriterion("second_sku not like", value, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuIn(List<String> values) {
            addCriterion("second_sku in", values, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuNotIn(List<String> values) {
            addCriterion("second_sku not in", values, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuBetween(String value1, String value2) {
            addCriterion("second_sku between", value1, value2, "secondSku");
            return (Criteria) this;
        }

        public Criteria andSecondSkuNotBetween(String value1, String value2) {
            addCriterion("second_sku not between", value1, value2, "secondSku");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
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

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardIsNull() {
            addCriterion("executive_standard is null");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardIsNotNull() {
            addCriterion("executive_standard is not null");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardEqualTo(String value) {
            addCriterion("executive_standard =", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardNotEqualTo(String value) {
            addCriterion("executive_standard <>", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardGreaterThan(String value) {
            addCriterion("executive_standard >", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardGreaterThanOrEqualTo(String value) {
            addCriterion("executive_standard >=", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardLessThan(String value) {
            addCriterion("executive_standard <", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardLessThanOrEqualTo(String value) {
            addCriterion("executive_standard <=", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardLike(String value) {
            addCriterion("executive_standard like", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardNotLike(String value) {
            addCriterion("executive_standard not like", value, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardIn(List<String> values) {
            addCriterion("executive_standard in", values, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardNotIn(List<String> values) {
            addCriterion("executive_standard not in", values, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardBetween(String value1, String value2) {
            addCriterion("executive_standard between", value1, value2, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andExecutiveStandardNotBetween(String value1, String value2) {
            addCriterion("executive_standard not between", value1, value2, "executiveStandard");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryIsNull() {
            addCriterion("security_category is null");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryIsNotNull() {
            addCriterion("security_category is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryEqualTo(String value) {
            addCriterion("security_category =", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryNotEqualTo(String value) {
            addCriterion("security_category <>", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryGreaterThan(String value) {
            addCriterion("security_category >", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("security_category >=", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryLessThan(String value) {
            addCriterion("security_category <", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryLessThanOrEqualTo(String value) {
            addCriterion("security_category <=", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryLike(String value) {
            addCriterion("security_category like", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryNotLike(String value) {
            addCriterion("security_category not like", value, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryIn(List<String> values) {
            addCriterion("security_category in", values, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryNotIn(List<String> values) {
            addCriterion("security_category not in", values, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryBetween(String value1, String value2) {
            addCriterion("security_category between", value1, value2, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoryNotBetween(String value1, String value2) {
            addCriterion("security_category not between", value1, value2, "securityCategory");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNull() {
            addCriterion("inspector is null");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNotNull() {
            addCriterion("inspector is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorEqualTo(String value) {
            addCriterion("inspector =", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotEqualTo(String value) {
            addCriterion("inspector <>", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThan(String value) {
            addCriterion("inspector >", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThanOrEqualTo(String value) {
            addCriterion("inspector >=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThan(String value) {
            addCriterion("inspector <", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThanOrEqualTo(String value) {
            addCriterion("inspector <=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLike(String value) {
            addCriterion("inspector like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotLike(String value) {
            addCriterion("inspector not like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorIn(List<String> values) {
            addCriterion("inspector in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotIn(List<String> values) {
            addCriterion("inspector not in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorBetween(String value1, String value2) {
            addCriterion("inspector between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotBetween(String value1, String value2) {
            addCriterion("inspector not between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceIsNull() {
            addCriterion("suggested_retail_price is null");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceIsNotNull() {
            addCriterion("suggested_retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceEqualTo(String value) {
            addCriterion("suggested_retail_price =", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceNotEqualTo(String value) {
            addCriterion("suggested_retail_price <>", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceGreaterThan(String value) {
            addCriterion("suggested_retail_price >", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceGreaterThanOrEqualTo(String value) {
            addCriterion("suggested_retail_price >=", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceLessThan(String value) {
            addCriterion("suggested_retail_price <", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceLessThanOrEqualTo(String value) {
            addCriterion("suggested_retail_price <=", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceLike(String value) {
            addCriterion("suggested_retail_price like", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceNotLike(String value) {
            addCriterion("suggested_retail_price not like", value, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceIn(List<String> values) {
            addCriterion("suggested_retail_price in", values, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceNotIn(List<String> values) {
            addCriterion("suggested_retail_price not in", values, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceBetween(String value1, String value2) {
            addCriterion("suggested_retail_price between", value1, value2, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedRetailPriceNotBetween(String value1, String value2) {
            addCriterion("suggested_retail_price not between", value1, value2, "suggestedRetailPrice");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelIsNull() {
            addCriterion("development_level is null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelIsNotNull() {
            addCriterion("development_level is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelEqualTo(Integer value) {
            addCriterion("development_level =", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotEqualTo(Integer value) {
            addCriterion("development_level <>", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelGreaterThan(Integer value) {
            addCriterion("development_level >", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("development_level >=", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelLessThan(Integer value) {
            addCriterion("development_level <", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("development_level <=", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelIn(List<Integer> values) {
            addCriterion("development_level in", values, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotIn(List<Integer> values) {
            addCriterion("development_level not in", values, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelBetween(Integer value1, Integer value2) {
            addCriterion("development_level between", value1, value2, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("development_level not between", value1, value2, "developmentLevel");
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