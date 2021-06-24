package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmazonFbaInventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmazonFbaInventoryExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("merchant_id like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("merchant_id not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
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

        public Criteria andConditionStrIsNull() {
            addCriterion("condition_str is null");
            return (Criteria) this;
        }

        public Criteria andConditionStrIsNotNull() {
            addCriterion("condition_str is not null");
            return (Criteria) this;
        }

        public Criteria andConditionStrEqualTo(String value) {
            addCriterion("condition_str =", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrNotEqualTo(String value) {
            addCriterion("condition_str <>", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrGreaterThan(String value) {
            addCriterion("condition_str >", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrGreaterThanOrEqualTo(String value) {
            addCriterion("condition_str >=", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrLessThan(String value) {
            addCriterion("condition_str <", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrLessThanOrEqualTo(String value) {
            addCriterion("condition_str <=", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrLike(String value) {
            addCriterion("condition_str like", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrNotLike(String value) {
            addCriterion("condition_str not like", value, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrIn(List<String> values) {
            addCriterion("condition_str in", values, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrNotIn(List<String> values) {
            addCriterion("condition_str not in", values, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrBetween(String value1, String value2) {
            addCriterion("condition_str between", value1, value2, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andConditionStrNotBetween(String value1, String value2) {
            addCriterion("condition_str not between", value1, value2, "conditionStr");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityIsNull() {
            addCriterion("fulfillable_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityIsNotNull() {
            addCriterion("fulfillable_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityEqualTo(Integer value) {
            addCriterion("fulfillable_quantity =", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityNotEqualTo(Integer value) {
            addCriterion("fulfillable_quantity <>", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityGreaterThan(Integer value) {
            addCriterion("fulfillable_quantity >", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("fulfillable_quantity >=", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityLessThan(Integer value) {
            addCriterion("fulfillable_quantity <", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("fulfillable_quantity <=", value, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityIn(List<Integer> values) {
            addCriterion("fulfillable_quantity in", values, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityNotIn(List<Integer> values) {
            addCriterion("fulfillable_quantity not in", values, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityBetween(Integer value1, Integer value2) {
            addCriterion("fulfillable_quantity between", value1, value2, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andFulfillableQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("fulfillable_quantity not between", value1, value2, "fulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityIsNull() {
            addCriterion("inbound_working_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityIsNotNull() {
            addCriterion("inbound_working_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityEqualTo(Integer value) {
            addCriterion("inbound_working_quantity =", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityNotEqualTo(Integer value) {
            addCriterion("inbound_working_quantity <>", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityGreaterThan(Integer value) {
            addCriterion("inbound_working_quantity >", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("inbound_working_quantity >=", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityLessThan(Integer value) {
            addCriterion("inbound_working_quantity <", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("inbound_working_quantity <=", value, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityIn(List<Integer> values) {
            addCriterion("inbound_working_quantity in", values, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityNotIn(List<Integer> values) {
            addCriterion("inbound_working_quantity not in", values, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("inbound_working_quantity between", value1, value2, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundWorkingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("inbound_working_quantity not between", value1, value2, "inboundWorkingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityIsNull() {
            addCriterion("inbound_receiving_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityIsNotNull() {
            addCriterion("inbound_receiving_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityEqualTo(Integer value) {
            addCriterion("inbound_receiving_quantity =", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityNotEqualTo(Integer value) {
            addCriterion("inbound_receiving_quantity <>", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityGreaterThan(Integer value) {
            addCriterion("inbound_receiving_quantity >", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("inbound_receiving_quantity >=", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityLessThan(Integer value) {
            addCriterion("inbound_receiving_quantity <", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("inbound_receiving_quantity <=", value, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityIn(List<Integer> values) {
            addCriterion("inbound_receiving_quantity in", values, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityNotIn(List<Integer> values) {
            addCriterion("inbound_receiving_quantity not in", values, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("inbound_receiving_quantity between", value1, value2, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andInboundReceivingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("inbound_receiving_quantity not between", value1, value2, "inboundReceivingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityIsNull() {
            addCriterion("total_reserved_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityIsNotNull() {
            addCriterion("total_reserved_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityEqualTo(Integer value) {
            addCriterion("total_reserved_quantity =", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityNotEqualTo(Integer value) {
            addCriterion("total_reserved_quantity <>", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityGreaterThan(Integer value) {
            addCriterion("total_reserved_quantity >", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_reserved_quantity >=", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityLessThan(Integer value) {
            addCriterion("total_reserved_quantity <", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_reserved_quantity <=", value, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityIn(List<Integer> values) {
            addCriterion("total_reserved_quantity in", values, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityNotIn(List<Integer> values) {
            addCriterion("total_reserved_quantity not in", values, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_reserved_quantity between", value1, value2, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalReservedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_reserved_quantity not between", value1, value2, "totalReservedQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityIsNull() {
            addCriterion("pending_customer_order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityIsNotNull() {
            addCriterion("pending_customer_order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityEqualTo(Integer value) {
            addCriterion("pending_customer_order_quantity =", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityNotEqualTo(Integer value) {
            addCriterion("pending_customer_order_quantity <>", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityGreaterThan(Integer value) {
            addCriterion("pending_customer_order_quantity >", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pending_customer_order_quantity >=", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityLessThan(Integer value) {
            addCriterion("pending_customer_order_quantity <", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("pending_customer_order_quantity <=", value, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityIn(List<Integer> values) {
            addCriterion("pending_customer_order_quantity in", values, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityNotIn(List<Integer> values) {
            addCriterion("pending_customer_order_quantity not in", values, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityBetween(Integer value1, Integer value2) {
            addCriterion("pending_customer_order_quantity between", value1, value2, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingCustomerOrderQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("pending_customer_order_quantity not between", value1, value2, "pendingCustomerOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityIsNull() {
            addCriterion("pending_transshipment_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityIsNotNull() {
            addCriterion("pending_transshipment_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityEqualTo(Integer value) {
            addCriterion("pending_transshipment_quantity =", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityNotEqualTo(Integer value) {
            addCriterion("pending_transshipment_quantity <>", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityGreaterThan(Integer value) {
            addCriterion("pending_transshipment_quantity >", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pending_transshipment_quantity >=", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityLessThan(Integer value) {
            addCriterion("pending_transshipment_quantity <", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("pending_transshipment_quantity <=", value, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityIn(List<Integer> values) {
            addCriterion("pending_transshipment_quantity in", values, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityNotIn(List<Integer> values) {
            addCriterion("pending_transshipment_quantity not in", values, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityBetween(Integer value1, Integer value2) {
            addCriterion("pending_transshipment_quantity between", value1, value2, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andPendingTransshipmentQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("pending_transshipment_quantity not between", value1, value2, "pendingTransshipmentQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityIsNull() {
            addCriterion("fc_processing_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityIsNotNull() {
            addCriterion("fc_processing_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityEqualTo(Integer value) {
            addCriterion("fc_processing_quantity =", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityNotEqualTo(Integer value) {
            addCriterion("fc_processing_quantity <>", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityGreaterThan(Integer value) {
            addCriterion("fc_processing_quantity >", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("fc_processing_quantity >=", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityLessThan(Integer value) {
            addCriterion("fc_processing_quantity <", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("fc_processing_quantity <=", value, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityIn(List<Integer> values) {
            addCriterion("fc_processing_quantity in", values, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityNotIn(List<Integer> values) {
            addCriterion("fc_processing_quantity not in", values, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("fc_processing_quantity between", value1, value2, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andFcProcessingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("fc_processing_quantity not between", value1, value2, "fcProcessingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityIsNull() {
            addCriterion("total_researching_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityIsNotNull() {
            addCriterion("total_researching_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityEqualTo(Integer value) {
            addCriterion("total_researching_quantity =", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityNotEqualTo(Integer value) {
            addCriterion("total_researching_quantity <>", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityGreaterThan(Integer value) {
            addCriterion("total_researching_quantity >", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_researching_quantity >=", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityLessThan(Integer value) {
            addCriterion("total_researching_quantity <", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_researching_quantity <=", value, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityIn(List<Integer> values) {
            addCriterion("total_researching_quantity in", values, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityNotIn(List<Integer> values) {
            addCriterion("total_researching_quantity not in", values, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_researching_quantity between", value1, value2, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalResearchingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_researching_quantity not between", value1, value2, "totalResearchingQuantity");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermIsNull() {
            addCriterion("researching_quantity_in_short_term is null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermIsNotNull() {
            addCriterion("researching_quantity_in_short_term is not null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermEqualTo(Integer value) {
            addCriterion("researching_quantity_in_short_term =", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermNotEqualTo(Integer value) {
            addCriterion("researching_quantity_in_short_term <>", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermGreaterThan(Integer value) {
            addCriterion("researching_quantity_in_short_term >", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_short_term >=", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermLessThan(Integer value) {
            addCriterion("researching_quantity_in_short_term <", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermLessThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_short_term <=", value, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermIn(List<Integer> values) {
            addCriterion("researching_quantity_in_short_term in", values, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermNotIn(List<Integer> values) {
            addCriterion("researching_quantity_in_short_term not in", values, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_short_term between", value1, value2, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInShortTermNotBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_short_term not between", value1, value2, "researchingQuantityInShortTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermIsNull() {
            addCriterion("researching_quantity_in_mid_uerm is null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermIsNotNull() {
            addCriterion("researching_quantity_in_mid_uerm is not null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermEqualTo(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm =", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermNotEqualTo(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm <>", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermGreaterThan(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm >", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermGreaterThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm >=", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermLessThan(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm <", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermLessThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_mid_uerm <=", value, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermIn(List<Integer> values) {
            addCriterion("researching_quantity_in_mid_uerm in", values, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermNotIn(List<Integer> values) {
            addCriterion("researching_quantity_in_mid_uerm not in", values, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_mid_uerm between", value1, value2, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInMidUermNotBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_mid_uerm not between", value1, value2, "researchingQuantityInMidUerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermIsNull() {
            addCriterion("researching_quantity_in_long_term is null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermIsNotNull() {
            addCriterion("researching_quantity_in_long_term is not null");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermEqualTo(Integer value) {
            addCriterion("researching_quantity_in_long_term =", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermNotEqualTo(Integer value) {
            addCriterion("researching_quantity_in_long_term <>", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermGreaterThan(Integer value) {
            addCriterion("researching_quantity_in_long_term >", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_long_term >=", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermLessThan(Integer value) {
            addCriterion("researching_quantity_in_long_term <", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermLessThanOrEqualTo(Integer value) {
            addCriterion("researching_quantity_in_long_term <=", value, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermIn(List<Integer> values) {
            addCriterion("researching_quantity_in_long_term in", values, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermNotIn(List<Integer> values) {
            addCriterion("researching_quantity_in_long_term not in", values, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_long_term between", value1, value2, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andResearchingQuantityInLongTermNotBetween(Integer value1, Integer value2) {
            addCriterion("researching_quantity_in_long_term not between", value1, value2, "researchingQuantityInLongTerm");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityIsNull() {
            addCriterion("unfulfillable_quantity is null");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityIsNotNull() {
            addCriterion("unfulfillable_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityEqualTo(Integer value) {
            addCriterion("unfulfillable_quantity =", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityNotEqualTo(Integer value) {
            addCriterion("unfulfillable_quantity <>", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityGreaterThan(Integer value) {
            addCriterion("unfulfillable_quantity >", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("unfulfillable_quantity >=", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityLessThan(Integer value) {
            addCriterion("unfulfillable_quantity <", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("unfulfillable_quantity <=", value, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityIn(List<Integer> values) {
            addCriterion("unfulfillable_quantity in", values, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityNotIn(List<Integer> values) {
            addCriterion("unfulfillable_quantity not in", values, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityBetween(Integer value1, Integer value2) {
            addCriterion("unfulfillable_quantity between", value1, value2, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andUnfulfillableQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("unfulfillable_quantity not between", value1, value2, "unfulfillableQuantity");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNull() {
            addCriterion("last_updated_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNotNull() {
            addCriterion("last_updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeEqualTo(Date value) {
            addCriterion("last_updated_time =", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotEqualTo(Date value) {
            addCriterion("last_updated_time <>", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThan(Date value) {
            addCriterion("last_updated_time >", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated_time >=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThan(Date value) {
            addCriterion("last_updated_time <", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_updated_time <=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIn(List<Date> values) {
            addCriterion("last_updated_time in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotIn(List<Date> values) {
            addCriterion("last_updated_time not in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("last_updated_time between", value1, value2, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_updated_time not between", value1, value2, "lastUpdatedTime");
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

        public Criteria andTotalQuantityIsNull() {
            addCriterion("total_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityIsNotNull() {
            addCriterion("total_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityEqualTo(Integer value) {
            addCriterion("total_quantity =", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotEqualTo(Integer value) {
            addCriterion("total_quantity <>", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityGreaterThan(Integer value) {
            addCriterion("total_quantity >", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_quantity >=", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityLessThan(Integer value) {
            addCriterion("total_quantity <", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_quantity <=", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityIn(List<Integer> values) {
            addCriterion("total_quantity in", values, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotIn(List<Integer> values) {
            addCriterion("total_quantity not in", values, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_quantity between", value1, value2, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_quantity not between", value1, value2, "totalQuantity");
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