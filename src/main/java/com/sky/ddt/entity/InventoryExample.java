package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryExample() {
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

        public Criteria andSellerSkuIsNull() {
            addCriterion("seller_sku is null");
            return (Criteria) this;
        }

        public Criteria andSellerSkuIsNotNull() {
            addCriterion("seller_sku is not null");
            return (Criteria) this;
        }

        public Criteria andSellerSkuEqualTo(String value) {
            addCriterion("seller_sku =", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotEqualTo(String value) {
            addCriterion("seller_sku <>", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuGreaterThan(String value) {
            addCriterion("seller_sku >", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuGreaterThanOrEqualTo(String value) {
            addCriterion("seller_sku >=", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLessThan(String value) {
            addCriterion("seller_sku <", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLessThanOrEqualTo(String value) {
            addCriterion("seller_sku <=", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuLike(String value) {
            addCriterion("seller_sku like", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotLike(String value) {
            addCriterion("seller_sku not like", value, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuIn(List<String> values) {
            addCriterion("seller_sku in", values, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotIn(List<String> values) {
            addCriterion("seller_sku not in", values, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuBetween(String value1, String value2) {
            addCriterion("seller_sku between", value1, value2, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andSellerSkuNotBetween(String value1, String value2) {
            addCriterion("seller_sku not between", value1, value2, "sellerSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuIsNull() {
            addCriterion("fn_sku is null");
            return (Criteria) this;
        }

        public Criteria andFnSkuIsNotNull() {
            addCriterion("fn_sku is not null");
            return (Criteria) this;
        }

        public Criteria andFnSkuEqualTo(String value) {
            addCriterion("fn_sku =", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuNotEqualTo(String value) {
            addCriterion("fn_sku <>", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuGreaterThan(String value) {
            addCriterion("fn_sku >", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuGreaterThanOrEqualTo(String value) {
            addCriterion("fn_sku >=", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuLessThan(String value) {
            addCriterion("fn_sku <", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuLessThanOrEqualTo(String value) {
            addCriterion("fn_sku <=", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuLike(String value) {
            addCriterion("fn_sku like", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuNotLike(String value) {
            addCriterion("fn_sku not like", value, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuIn(List<String> values) {
            addCriterion("fn_sku in", values, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuNotIn(List<String> values) {
            addCriterion("fn_sku not in", values, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuBetween(String value1, String value2) {
            addCriterion("fn_sku between", value1, value2, "fnSku");
            return (Criteria) this;
        }

        public Criteria andFnSkuNotBetween(String value1, String value2) {
            addCriterion("fn_sku not between", value1, value2, "fnSku");
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

        public Criteria andProductConditionIsNull() {
            addCriterion("product_condition is null");
            return (Criteria) this;
        }

        public Criteria andProductConditionIsNotNull() {
            addCriterion("product_condition is not null");
            return (Criteria) this;
        }

        public Criteria andProductConditionEqualTo(String value) {
            addCriterion("product_condition =", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionNotEqualTo(String value) {
            addCriterion("product_condition <>", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionGreaterThan(String value) {
            addCriterion("product_condition >", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionGreaterThanOrEqualTo(String value) {
            addCriterion("product_condition >=", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionLessThan(String value) {
            addCriterion("product_condition <", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionLessThanOrEqualTo(String value) {
            addCriterion("product_condition <=", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionLike(String value) {
            addCriterion("product_condition like", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionNotLike(String value) {
            addCriterion("product_condition not like", value, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionIn(List<String> values) {
            addCriterion("product_condition in", values, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionNotIn(List<String> values) {
            addCriterion("product_condition not in", values, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionBetween(String value1, String value2) {
            addCriterion("product_condition between", value1, value2, "productCondition");
            return (Criteria) this;
        }

        public Criteria andProductConditionNotBetween(String value1, String value2) {
            addCriterion("product_condition not between", value1, value2, "productCondition");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityIsNull() {
            addCriterion("total_supply_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityIsNotNull() {
            addCriterion("total_supply_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityEqualTo(Integer value) {
            addCriterion("total_supply_quantity =", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityNotEqualTo(Integer value) {
            addCriterion("total_supply_quantity <>", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityGreaterThan(Integer value) {
            addCriterion("total_supply_quantity >", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_supply_quantity >=", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityLessThan(Integer value) {
            addCriterion("total_supply_quantity <", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_supply_quantity <=", value, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityIn(List<Integer> values) {
            addCriterion("total_supply_quantity in", values, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityNotIn(List<Integer> values) {
            addCriterion("total_supply_quantity not in", values, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_supply_quantity between", value1, value2, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSupplyQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_supply_quantity not between", value1, value2, "totalSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityIsNull() {
            addCriterion("in_stock_supply_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityIsNotNull() {
            addCriterion("in_stock_supply_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityEqualTo(Integer value) {
            addCriterion("in_stock_supply_quantity =", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityNotEqualTo(Integer value) {
            addCriterion("in_stock_supply_quantity <>", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityGreaterThan(Integer value) {
            addCriterion("in_stock_supply_quantity >", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_stock_supply_quantity >=", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityLessThan(Integer value) {
            addCriterion("in_stock_supply_quantity <", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("in_stock_supply_quantity <=", value, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityIn(List<Integer> values) {
            addCriterion("in_stock_supply_quantity in", values, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityNotIn(List<Integer> values) {
            addCriterion("in_stock_supply_quantity not in", values, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityBetween(Integer value1, Integer value2) {
            addCriterion("in_stock_supply_quantity between", value1, value2, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andInStockSupplyQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("in_stock_supply_quantity not between", value1, value2, "inStockSupplyQuantity");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeIsNull() {
            addCriterion("earliest_availability_timepoint_type is null");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeIsNotNull() {
            addCriterion("earliest_availability_timepoint_type is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeEqualTo(String value) {
            addCriterion("earliest_availability_timepoint_type =", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeNotEqualTo(String value) {
            addCriterion("earliest_availability_timepoint_type <>", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeGreaterThan(String value) {
            addCriterion("earliest_availability_timepoint_type >", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeGreaterThanOrEqualTo(String value) {
            addCriterion("earliest_availability_timepoint_type >=", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeLessThan(String value) {
            addCriterion("earliest_availability_timepoint_type <", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeLessThanOrEqualTo(String value) {
            addCriterion("earliest_availability_timepoint_type <=", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeLike(String value) {
            addCriterion("earliest_availability_timepoint_type like", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeNotLike(String value) {
            addCriterion("earliest_availability_timepoint_type not like", value, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeIn(List<String> values) {
            addCriterion("earliest_availability_timepoint_type in", values, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeNotIn(List<String> values) {
            addCriterion("earliest_availability_timepoint_type not in", values, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeBetween(String value1, String value2) {
            addCriterion("earliest_availability_timepoint_type between", value1, value2, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityTimepointTypeNotBetween(String value1, String value2) {
            addCriterion("earliest_availability_timepoint_type not between", value1, value2, "earliestAvailabilityTimepointType");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeIsNull() {
            addCriterion("earliest_availability_datetime is null");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeIsNotNull() {
            addCriterion("earliest_availability_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeEqualTo(Date value) {
            addCriterion("earliest_availability_datetime =", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeNotEqualTo(Date value) {
            addCriterion("earliest_availability_datetime <>", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeGreaterThan(Date value) {
            addCriterion("earliest_availability_datetime >", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("earliest_availability_datetime >=", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeLessThan(Date value) {
            addCriterion("earliest_availability_datetime <", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("earliest_availability_datetime <=", value, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeIn(List<Date> values) {
            addCriterion("earliest_availability_datetime in", values, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeNotIn(List<Date> values) {
            addCriterion("earliest_availability_datetime not in", values, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeBetween(Date value1, Date value2) {
            addCriterion("earliest_availability_datetime between", value1, value2, "earliestAvailabilityDatetime");
            return (Criteria) this;
        }

        public Criteria andEarliestAvailabilityDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("earliest_availability_datetime not between", value1, value2, "earliestAvailabilityDatetime");
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