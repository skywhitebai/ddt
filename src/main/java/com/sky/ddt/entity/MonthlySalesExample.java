package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthlySalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthlySalesExample() {
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

        public Criteria andDateTimeIsNull() {
            addCriterion("date_time is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("date_time is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(Date value) {
            addCriterion("date_time =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(Date value) {
            addCriterion("date_time <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(Date value) {
            addCriterion("date_time >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("date_time >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(Date value) {
            addCriterion("date_time <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("date_time <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<Date> values) {
            addCriterion("date_time in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<Date> values) {
            addCriterion("date_time not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(Date value1, Date value2) {
            addCriterion("date_time between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("date_time not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andSettlementIdIsNull() {
            addCriterion("settlement_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementIdIsNotNull() {
            addCriterion("settlement_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementIdEqualTo(Long value) {
            addCriterion("settlement_id =", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotEqualTo(Long value) {
            addCriterion("settlement_id <>", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdGreaterThan(Long value) {
            addCriterion("settlement_id >", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("settlement_id >=", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdLessThan(Long value) {
            addCriterion("settlement_id <", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdLessThanOrEqualTo(Long value) {
            addCriterion("settlement_id <=", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdIn(List<Long> values) {
            addCriterion("settlement_id in", values, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotIn(List<Long> values) {
            addCriterion("settlement_id not in", values, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdBetween(Long value1, Long value2) {
            addCriterion("settlement_id between", value1, value2, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotBetween(Long value1, Long value2) {
            addCriterion("settlement_id not between", value1, value2, "settlementId");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIsNull() {
            addCriterion("marketplace is null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIsNotNull() {
            addCriterion("marketplace is not null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceEqualTo(String value) {
            addCriterion("marketplace =", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceNotEqualTo(String value) {
            addCriterion("marketplace <>", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceGreaterThan(String value) {
            addCriterion("marketplace >", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceGreaterThanOrEqualTo(String value) {
            addCriterion("marketplace >=", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceLessThan(String value) {
            addCriterion("marketplace <", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceLessThanOrEqualTo(String value) {
            addCriterion("marketplace <=", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceLike(String value) {
            addCriterion("marketplace like", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceNotLike(String value) {
            addCriterion("marketplace not like", value, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceIn(List<String> values) {
            addCriterion("marketplace in", values, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceNotIn(List<String> values) {
            addCriterion("marketplace not in", values, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceBetween(String value1, String value2) {
            addCriterion("marketplace between", value1, value2, "marketplace");
            return (Criteria) this;
        }

        public Criteria andMarketplaceNotBetween(String value1, String value2) {
            addCriterion("marketplace not between", value1, value2, "marketplace");
            return (Criteria) this;
        }

        public Criteria andFulfillmentIsNull() {
            addCriterion("fulfillment is null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentIsNotNull() {
            addCriterion("fulfillment is not null");
            return (Criteria) this;
        }

        public Criteria andFulfillmentEqualTo(String value) {
            addCriterion("fulfillment =", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentNotEqualTo(String value) {
            addCriterion("fulfillment <>", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentGreaterThan(String value) {
            addCriterion("fulfillment >", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentGreaterThanOrEqualTo(String value) {
            addCriterion("fulfillment >=", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentLessThan(String value) {
            addCriterion("fulfillment <", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentLessThanOrEqualTo(String value) {
            addCriterion("fulfillment <=", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentLike(String value) {
            addCriterion("fulfillment like", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentNotLike(String value) {
            addCriterion("fulfillment not like", value, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentIn(List<String> values) {
            addCriterion("fulfillment in", values, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentNotIn(List<String> values) {
            addCriterion("fulfillment not in", values, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentBetween(String value1, String value2) {
            addCriterion("fulfillment between", value1, value2, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andFulfillmentNotBetween(String value1, String value2) {
            addCriterion("fulfillment not between", value1, value2, "fulfillment");
            return (Criteria) this;
        }

        public Criteria andOrderCityIsNull() {
            addCriterion("order_city is null");
            return (Criteria) this;
        }

        public Criteria andOrderCityIsNotNull() {
            addCriterion("order_city is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCityEqualTo(String value) {
            addCriterion("order_city =", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotEqualTo(String value) {
            addCriterion("order_city <>", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityGreaterThan(String value) {
            addCriterion("order_city >", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityGreaterThanOrEqualTo(String value) {
            addCriterion("order_city >=", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLessThan(String value) {
            addCriterion("order_city <", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLessThanOrEqualTo(String value) {
            addCriterion("order_city <=", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLike(String value) {
            addCriterion("order_city like", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotLike(String value) {
            addCriterion("order_city not like", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityIn(List<String> values) {
            addCriterion("order_city in", values, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotIn(List<String> values) {
            addCriterion("order_city not in", values, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityBetween(String value1, String value2) {
            addCriterion("order_city between", value1, value2, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotBetween(String value1, String value2) {
            addCriterion("order_city not between", value1, value2, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("order_state like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("order_state not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderPostalIsNull() {
            addCriterion("order_postal is null");
            return (Criteria) this;
        }

        public Criteria andOrderPostalIsNotNull() {
            addCriterion("order_postal is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPostalEqualTo(String value) {
            addCriterion("order_postal =", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalNotEqualTo(String value) {
            addCriterion("order_postal <>", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalGreaterThan(String value) {
            addCriterion("order_postal >", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalGreaterThanOrEqualTo(String value) {
            addCriterion("order_postal >=", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalLessThan(String value) {
            addCriterion("order_postal <", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalLessThanOrEqualTo(String value) {
            addCriterion("order_postal <=", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalLike(String value) {
            addCriterion("order_postal like", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalNotLike(String value) {
            addCriterion("order_postal not like", value, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalIn(List<String> values) {
            addCriterion("order_postal in", values, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalNotIn(List<String> values) {
            addCriterion("order_postal not in", values, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalBetween(String value1, String value2) {
            addCriterion("order_postal between", value1, value2, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andOrderPostalNotBetween(String value1, String value2) {
            addCriterion("order_postal not between", value1, value2, "orderPostal");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelIsNull() {
            addCriterion("tax_collection_model is null");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelIsNotNull() {
            addCriterion("tax_collection_model is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelEqualTo(String value) {
            addCriterion("tax_collection_model =", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelNotEqualTo(String value) {
            addCriterion("tax_collection_model <>", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelGreaterThan(String value) {
            addCriterion("tax_collection_model >", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelGreaterThanOrEqualTo(String value) {
            addCriterion("tax_collection_model >=", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelLessThan(String value) {
            addCriterion("tax_collection_model <", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelLessThanOrEqualTo(String value) {
            addCriterion("tax_collection_model <=", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelLike(String value) {
            addCriterion("tax_collection_model like", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelNotLike(String value) {
            addCriterion("tax_collection_model not like", value, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelIn(List<String> values) {
            addCriterion("tax_collection_model in", values, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelNotIn(List<String> values) {
            addCriterion("tax_collection_model not in", values, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelBetween(String value1, String value2) {
            addCriterion("tax_collection_model between", value1, value2, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andTaxCollectionModelNotBetween(String value1, String value2) {
            addCriterion("tax_collection_model not between", value1, value2, "taxCollectionModel");
            return (Criteria) this;
        }

        public Criteria andProductSalesIsNull() {
            addCriterion("product_sales is null");
            return (Criteria) this;
        }

        public Criteria andProductSalesIsNotNull() {
            addCriterion("product_sales is not null");
            return (Criteria) this;
        }

        public Criteria andProductSalesEqualTo(BigDecimal value) {
            addCriterion("product_sales =", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotEqualTo(BigDecimal value) {
            addCriterion("product_sales <>", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesGreaterThan(BigDecimal value) {
            addCriterion("product_sales >", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales >=", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesLessThan(BigDecimal value) {
            addCriterion("product_sales <", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales <=", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesIn(List<BigDecimal> values) {
            addCriterion("product_sales in", values, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotIn(List<BigDecimal> values) {
            addCriterion("product_sales not in", values, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales between", value1, value2, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales not between", value1, value2, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxIsNull() {
            addCriterion("product_sales_tax is null");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxIsNotNull() {
            addCriterion("product_sales_tax is not null");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax =", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax <>", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxGreaterThan(BigDecimal value) {
            addCriterion("product_sales_tax >", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax >=", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxLessThan(BigDecimal value) {
            addCriterion("product_sales_tax <", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax <=", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxIn(List<BigDecimal> values) {
            addCriterion("product_sales_tax in", values, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotIn(List<BigDecimal> values) {
            addCriterion("product_sales_tax not in", values, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales_tax between", value1, value2, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales_tax not between", value1, value2, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIsNull() {
            addCriterion("shipping_credits is null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIsNotNull() {
            addCriterion("shipping_credits is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsEqualTo(BigDecimal value) {
            addCriterion("shipping_credits =", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotEqualTo(BigDecimal value) {
            addCriterion("shipping_credits <>", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsGreaterThan(BigDecimal value) {
            addCriterion("shipping_credits >", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits >=", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsLessThan(BigDecimal value) {
            addCriterion("shipping_credits <", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits <=", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIn(List<BigDecimal> values) {
            addCriterion("shipping_credits in", values, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotIn(List<BigDecimal> values) {
            addCriterion("shipping_credits not in", values, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits between", value1, value2, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits not between", value1, value2, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIsNull() {
            addCriterion("shipping_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIsNotNull() {
            addCriterion("shipping_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax =", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax <>", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("shipping_credits_tax >", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax >=", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxLessThan(BigDecimal value) {
            addCriterion("shipping_credits_tax <", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax <=", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("shipping_credits_tax in", values, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("shipping_credits_tax not in", values, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits_tax between", value1, value2, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits_tax not between", value1, value2, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIsNull() {
            addCriterion("gift_wrap_credits is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIsNotNull() {
            addCriterion("gift_wrap_credits is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits =", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits <>", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_credits >", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits >=", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsLessThan(BigDecimal value) {
            addCriterion("gift_wrap_credits <", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits <=", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits in", values, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits not in", values, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits between", value1, value2, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits not between", value1, value2, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxIsNull() {
            addCriterion("giftwrap_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxIsNotNull() {
            addCriterion("giftwrap_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("giftwrap_credits_tax =", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("giftwrap_credits_tax <>", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("giftwrap_credits_tax >", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("giftwrap_credits_tax >=", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxLessThan(BigDecimal value) {
            addCriterion("giftwrap_credits_tax <", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("giftwrap_credits_tax <=", value, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("giftwrap_credits_tax in", values, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("giftwrap_credits_tax not in", values, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("giftwrap_credits_tax between", value1, value2, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftwrapCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("giftwrap_credits_tax not between", value1, value2, "giftwrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIsNull() {
            addCriterion("promotional_rebates is null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIsNotNull() {
            addCriterion("promotional_rebates is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates =", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates <>", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesGreaterThan(BigDecimal value) {
            addCriterion("promotional_rebates >", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates >=", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesLessThan(BigDecimal value) {
            addCriterion("promotional_rebates <", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates <=", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates in", values, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates not in", values, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates between", value1, value2, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates not between", value1, value2, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIsNull() {
            addCriterion("promotional_rebates_tax is null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIsNotNull() {
            addCriterion("promotional_rebates_tax is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax =", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax <>", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxGreaterThan(BigDecimal value) {
            addCriterion("promotional_rebates_tax >", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax >=", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxLessThan(BigDecimal value) {
            addCriterion("promotional_rebates_tax <", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax <=", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates_tax in", values, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates_tax not in", values, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates_tax between", value1, value2, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates_tax not between", value1, value2, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIsNull() {
            addCriterion("marketplace_withheld_tax is null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIsNotNull() {
            addCriterion("marketplace_withheld_tax is not null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax =", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <>", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxGreaterThan(BigDecimal value) {
            addCriterion("marketplace_withheld_tax >", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax >=", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxLessThan(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <=", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIn(List<BigDecimal> values) {
            addCriterion("marketplace_withheld_tax in", values, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotIn(List<BigDecimal> values) {
            addCriterion("marketplace_withheld_tax not in", values, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketplace_withheld_tax between", value1, value2, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketplace_withheld_tax not between", value1, value2, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIsNull() {
            addCriterion("selling_fees is null");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIsNotNull() {
            addCriterion("selling_fees is not null");
            return (Criteria) this;
        }

        public Criteria andSellingFeesEqualTo(BigDecimal value) {
            addCriterion("selling_fees =", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotEqualTo(BigDecimal value) {
            addCriterion("selling_fees <>", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesGreaterThan(BigDecimal value) {
            addCriterion("selling_fees >", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("selling_fees >=", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesLessThan(BigDecimal value) {
            addCriterion("selling_fees <", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("selling_fees <=", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIn(List<BigDecimal> values) {
            addCriterion("selling_fees in", values, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotIn(List<BigDecimal> values) {
            addCriterion("selling_fees not in", values, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("selling_fees between", value1, value2, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("selling_fees not between", value1, value2, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIsNull() {
            addCriterion("fba_fees is null");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIsNotNull() {
            addCriterion("fba_fees is not null");
            return (Criteria) this;
        }

        public Criteria andFbaFeesEqualTo(BigDecimal value) {
            addCriterion("fba_fees =", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotEqualTo(BigDecimal value) {
            addCriterion("fba_fees <>", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesGreaterThan(BigDecimal value) {
            addCriterion("fba_fees >", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_fees >=", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesLessThan(BigDecimal value) {
            addCriterion("fba_fees <", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_fees <=", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIn(List<BigDecimal> values) {
            addCriterion("fba_fees in", values, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotIn(List<BigDecimal> values) {
            addCriterion("fba_fees not in", values, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_fees between", value1, value2, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_fees not between", value1, value2, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIsNull() {
            addCriterion("other_transaction_fees is null");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIsNotNull() {
            addCriterion("other_transaction_fees is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees =", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees <>", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesGreaterThan(BigDecimal value) {
            addCriterion("other_transaction_fees >", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees >=", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesLessThan(BigDecimal value) {
            addCriterion("other_transaction_fees <", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees <=", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIn(List<BigDecimal> values) {
            addCriterion("other_transaction_fees in", values, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotIn(List<BigDecimal> values) {
            addCriterion("other_transaction_fees not in", values, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_transaction_fees between", value1, value2, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_transaction_fees not between", value1, value2, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(BigDecimal value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(BigDecimal value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(BigDecimal value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(BigDecimal value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<BigDecimal> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<BigDecimal> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total not between", value1, value2, "total");
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