package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DestructionFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DestructionFeeExample() {
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

        public Criteria andRequestDateIsNull() {
            addCriterion("request_date is null");
            return (Criteria) this;
        }

        public Criteria andRequestDateIsNotNull() {
            addCriterion("request_date is not null");
            return (Criteria) this;
        }

        public Criteria andRequestDateEqualTo(Date value) {
            addCriterion("request_date =", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotEqualTo(Date value) {
            addCriterion("request_date <>", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateGreaterThan(Date value) {
            addCriterion("request_date >", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateGreaterThanOrEqualTo(Date value) {
            addCriterion("request_date >=", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateLessThan(Date value) {
            addCriterion("request_date <", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateLessThanOrEqualTo(Date value) {
            addCriterion("request_date <=", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateIn(List<Date> values) {
            addCriterion("request_date in", values, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotIn(List<Date> values) {
            addCriterion("request_date not in", values, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateBetween(Date value1, Date value2) {
            addCriterion("request_date between", value1, value2, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotBetween(Date value1, Date value2) {
            addCriterion("request_date not between", value1, value2, "requestDate");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andDispositionIsNull() {
            addCriterion("disposition is null");
            return (Criteria) this;
        }

        public Criteria andDispositionIsNotNull() {
            addCriterion("disposition is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionEqualTo(String value) {
            addCriterion("disposition =", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotEqualTo(String value) {
            addCriterion("disposition <>", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionGreaterThan(String value) {
            addCriterion("disposition >", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionGreaterThanOrEqualTo(String value) {
            addCriterion("disposition >=", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLessThan(String value) {
            addCriterion("disposition <", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLessThanOrEqualTo(String value) {
            addCriterion("disposition <=", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLike(String value) {
            addCriterion("disposition like", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotLike(String value) {
            addCriterion("disposition not like", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionIn(List<String> values) {
            addCriterion("disposition in", values, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotIn(List<String> values) {
            addCriterion("disposition not in", values, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionBetween(String value1, String value2) {
            addCriterion("disposition between", value1, value2, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotBetween(String value1, String value2) {
            addCriterion("disposition not between", value1, value2, "disposition");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityIsNull() {
            addCriterion("requested_quantity is null");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityIsNotNull() {
            addCriterion("requested_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityEqualTo(Integer value) {
            addCriterion("requested_quantity =", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityNotEqualTo(Integer value) {
            addCriterion("requested_quantity <>", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityGreaterThan(Integer value) {
            addCriterion("requested_quantity >", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("requested_quantity >=", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityLessThan(Integer value) {
            addCriterion("requested_quantity <", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("requested_quantity <=", value, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityIn(List<Integer> values) {
            addCriterion("requested_quantity in", values, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityNotIn(List<Integer> values) {
            addCriterion("requested_quantity not in", values, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("requested_quantity between", value1, value2, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andRequestedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("requested_quantity not between", value1, value2, "requestedQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityIsNull() {
            addCriterion("cancelled_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityIsNotNull() {
            addCriterion("cancelled_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityEqualTo(Integer value) {
            addCriterion("cancelled_quantity =", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityNotEqualTo(Integer value) {
            addCriterion("cancelled_quantity <>", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityGreaterThan(Integer value) {
            addCriterion("cancelled_quantity >", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancelled_quantity >=", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityLessThan(Integer value) {
            addCriterion("cancelled_quantity <", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("cancelled_quantity <=", value, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityIn(List<Integer> values) {
            addCriterion("cancelled_quantity in", values, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityNotIn(List<Integer> values) {
            addCriterion("cancelled_quantity not in", values, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityBetween(Integer value1, Integer value2) {
            addCriterion("cancelled_quantity between", value1, value2, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andCancelledQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("cancelled_quantity not between", value1, value2, "cancelledQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityIsNull() {
            addCriterion("disposed_quantity is null");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityIsNotNull() {
            addCriterion("disposed_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityEqualTo(Integer value) {
            addCriterion("disposed_quantity =", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityNotEqualTo(Integer value) {
            addCriterion("disposed_quantity <>", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityGreaterThan(Integer value) {
            addCriterion("disposed_quantity >", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposed_quantity >=", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityLessThan(Integer value) {
            addCriterion("disposed_quantity <", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("disposed_quantity <=", value, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityIn(List<Integer> values) {
            addCriterion("disposed_quantity in", values, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityNotIn(List<Integer> values) {
            addCriterion("disposed_quantity not in", values, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("disposed_quantity between", value1, value2, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andDisposedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("disposed_quantity not between", value1, value2, "disposedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityIsNull() {
            addCriterion("shipped_quantity is null");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityIsNotNull() {
            addCriterion("shipped_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityEqualTo(Integer value) {
            addCriterion("shipped_quantity =", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityNotEqualTo(Integer value) {
            addCriterion("shipped_quantity <>", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityGreaterThan(Integer value) {
            addCriterion("shipped_quantity >", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipped_quantity >=", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityLessThan(Integer value) {
            addCriterion("shipped_quantity <", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("shipped_quantity <=", value, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityIn(List<Integer> values) {
            addCriterion("shipped_quantity in", values, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityNotIn(List<Integer> values) {
            addCriterion("shipped_quantity not in", values, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("shipped_quantity between", value1, value2, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andShippedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("shipped_quantity not between", value1, value2, "shippedQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityIsNull() {
            addCriterion("in_process_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityIsNotNull() {
            addCriterion("in_process_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityEqualTo(Integer value) {
            addCriterion("in_process_quantity =", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityNotEqualTo(Integer value) {
            addCriterion("in_process_quantity <>", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityGreaterThan(Integer value) {
            addCriterion("in_process_quantity >", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_process_quantity >=", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityLessThan(Integer value) {
            addCriterion("in_process_quantity <", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("in_process_quantity <=", value, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityIn(List<Integer> values) {
            addCriterion("in_process_quantity in", values, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityNotIn(List<Integer> values) {
            addCriterion("in_process_quantity not in", values, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityBetween(Integer value1, Integer value2) {
            addCriterion("in_process_quantity between", value1, value2, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andInProcessQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("in_process_quantity not between", value1, value2, "inProcessQuantity");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeIsNull() {
            addCriterion("removal_fee is null");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeIsNotNull() {
            addCriterion("removal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeEqualTo(BigDecimal value) {
            addCriterion("removal_fee =", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeNotEqualTo(BigDecimal value) {
            addCriterion("removal_fee <>", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeGreaterThan(BigDecimal value) {
            addCriterion("removal_fee >", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("removal_fee >=", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeLessThan(BigDecimal value) {
            addCriterion("removal_fee <", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("removal_fee <=", value, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeIn(List<BigDecimal> values) {
            addCriterion("removal_fee in", values, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeNotIn(List<BigDecimal> values) {
            addCriterion("removal_fee not in", values, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("removal_fee between", value1, value2, "removalFee");
            return (Criteria) this;
        }

        public Criteria andRemovalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("removal_fee not between", value1, value2, "removalFee");
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