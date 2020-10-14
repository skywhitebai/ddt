package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InternalOrderNumberTransportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InternalOrderNumberTransportExample() {
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

        public Criteria andInternalOrderNumberIdIsNull() {
            addCriterion("internal_order_number_id is null");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdIsNotNull() {
            addCriterion("internal_order_number_id is not null");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdEqualTo(Integer value) {
            addCriterion("internal_order_number_id =", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdNotEqualTo(Integer value) {
            addCriterion("internal_order_number_id <>", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdGreaterThan(Integer value) {
            addCriterion("internal_order_number_id >", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("internal_order_number_id >=", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdLessThan(Integer value) {
            addCriterion("internal_order_number_id <", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdLessThanOrEqualTo(Integer value) {
            addCriterion("internal_order_number_id <=", value, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdIn(List<Integer> values) {
            addCriterion("internal_order_number_id in", values, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdNotIn(List<Integer> values) {
            addCriterion("internal_order_number_id not in", values, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdBetween(Integer value1, Integer value2) {
            addCriterion("internal_order_number_id between", value1, value2, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andInternalOrderNumberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("internal_order_number_id not between", value1, value2, "internalOrderNumberId");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberIsNull() {
            addCriterion("sub_order_number is null");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberIsNotNull() {
            addCriterion("sub_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberEqualTo(String value) {
            addCriterion("sub_order_number =", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberNotEqualTo(String value) {
            addCriterion("sub_order_number <>", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberGreaterThan(String value) {
            addCriterion("sub_order_number >", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sub_order_number >=", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberLessThan(String value) {
            addCriterion("sub_order_number <", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("sub_order_number <=", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberLike(String value) {
            addCriterion("sub_order_number like", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberNotLike(String value) {
            addCriterion("sub_order_number not like", value, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberIn(List<String> values) {
            addCriterion("sub_order_number in", values, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberNotIn(List<String> values) {
            addCriterion("sub_order_number not in", values, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberBetween(String value1, String value2) {
            addCriterion("sub_order_number between", value1, value2, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSubOrderNumberNotBetween(String value1, String value2) {
            addCriterion("sub_order_number not between", value1, value2, "subOrderNumber");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdIsNull() {
            addCriterion("fba_shipment_id is null");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdIsNotNull() {
            addCriterion("fba_shipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdEqualTo(String value) {
            addCriterion("fba_shipment_id =", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdNotEqualTo(String value) {
            addCriterion("fba_shipment_id <>", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdGreaterThan(String value) {
            addCriterion("fba_shipment_id >", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("fba_shipment_id >=", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdLessThan(String value) {
            addCriterion("fba_shipment_id <", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdLessThanOrEqualTo(String value) {
            addCriterion("fba_shipment_id <=", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdLike(String value) {
            addCriterion("fba_shipment_id like", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdNotLike(String value) {
            addCriterion("fba_shipment_id not like", value, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdIn(List<String> values) {
            addCriterion("fba_shipment_id in", values, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdNotIn(List<String> values) {
            addCriterion("fba_shipment_id not in", values, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdBetween(String value1, String value2) {
            addCriterion("fba_shipment_id between", value1, value2, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdNotBetween(String value1, String value2) {
            addCriterion("fba_shipment_id not between", value1, value2, "fbaShipmentId");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortIsNull() {
            addCriterion("fba_shipment_id_short is null");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortIsNotNull() {
            addCriterion("fba_shipment_id_short is not null");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortEqualTo(String value) {
            addCriterion("fba_shipment_id_short =", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortNotEqualTo(String value) {
            addCriterion("fba_shipment_id_short <>", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortGreaterThan(String value) {
            addCriterion("fba_shipment_id_short >", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortGreaterThanOrEqualTo(String value) {
            addCriterion("fba_shipment_id_short >=", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortLessThan(String value) {
            addCriterion("fba_shipment_id_short <", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortLessThanOrEqualTo(String value) {
            addCriterion("fba_shipment_id_short <=", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortLike(String value) {
            addCriterion("fba_shipment_id_short like", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortNotLike(String value) {
            addCriterion("fba_shipment_id_short not like", value, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortIn(List<String> values) {
            addCriterion("fba_shipment_id_short in", values, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortNotIn(List<String> values) {
            addCriterion("fba_shipment_id_short not in", values, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortBetween(String value1, String value2) {
            addCriterion("fba_shipment_id_short between", value1, value2, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andFbaShipmentIdShortNotBetween(String value1, String value2) {
            addCriterion("fba_shipment_id_short not between", value1, value2, "fbaShipmentIdShort");
            return (Criteria) this;
        }

        public Criteria andShipmentIdIsNull() {
            addCriterion("shipment_id is null");
            return (Criteria) this;
        }

        public Criteria andShipmentIdIsNotNull() {
            addCriterion("shipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentIdEqualTo(String value) {
            addCriterion("shipment_id =", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdNotEqualTo(String value) {
            addCriterion("shipment_id <>", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdGreaterThan(String value) {
            addCriterion("shipment_id >", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("shipment_id >=", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdLessThan(String value) {
            addCriterion("shipment_id <", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdLessThanOrEqualTo(String value) {
            addCriterion("shipment_id <=", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdLike(String value) {
            addCriterion("shipment_id like", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdNotLike(String value) {
            addCriterion("shipment_id not like", value, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdIn(List<String> values) {
            addCriterion("shipment_id in", values, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdNotIn(List<String> values) {
            addCriterion("shipment_id not in", values, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdBetween(String value1, String value2) {
            addCriterion("shipment_id between", value1, value2, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andShipmentIdNotBetween(String value1, String value2) {
            addCriterion("shipment_id not between", value1, value2, "shipmentId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoIsNull() {
            addCriterion("transfer_order_no is null");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoIsNotNull() {
            addCriterion("transfer_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoEqualTo(String value) {
            addCriterion("transfer_order_no =", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoNotEqualTo(String value) {
            addCriterion("transfer_order_no <>", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoGreaterThan(String value) {
            addCriterion("transfer_order_no >", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_order_no >=", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoLessThan(String value) {
            addCriterion("transfer_order_no <", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoLessThanOrEqualTo(String value) {
            addCriterion("transfer_order_no <=", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoLike(String value) {
            addCriterion("transfer_order_no like", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoNotLike(String value) {
            addCriterion("transfer_order_no not like", value, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoIn(List<String> values) {
            addCriterion("transfer_order_no in", values, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoNotIn(List<String> values) {
            addCriterion("transfer_order_no not in", values, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoBetween(String value1, String value2) {
            addCriterion("transfer_order_no between", value1, value2, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferOrderNoNotBetween(String value1, String value2) {
            addCriterion("transfer_order_no not between", value1, value2, "transferOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdIsNull() {
            addCriterion("transport_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdIsNotNull() {
            addCriterion("transport_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdEqualTo(Integer value) {
            addCriterion("transport_type_id =", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdNotEqualTo(Integer value) {
            addCriterion("transport_type_id <>", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdGreaterThan(Integer value) {
            addCriterion("transport_type_id >", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_type_id >=", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdLessThan(Integer value) {
            addCriterion("transport_type_id <", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("transport_type_id <=", value, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdIn(List<Integer> values) {
            addCriterion("transport_type_id in", values, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdNotIn(List<Integer> values) {
            addCriterion("transport_type_id not in", values, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("transport_type_id between", value1, value2, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_type_id not between", value1, value2, "transportTypeId");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateIsNull() {
            addCriterion("head_trip_cost_rate is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateIsNotNull() {
            addCriterion("head_trip_cost_rate is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_rate =", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_rate <>", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_rate >", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_rate >=", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_rate <", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_rate <=", value, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_rate in", values, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_rate not in", values, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_rate between", value1, value2, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_rate not between", value1, value2, "headTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateIsNull() {
            addCriterion("lock_head_trip_cost_rate is null");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateIsNotNull() {
            addCriterion("lock_head_trip_cost_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateEqualTo(Integer value) {
            addCriterion("lock_head_trip_cost_rate =", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateNotEqualTo(Integer value) {
            addCriterion("lock_head_trip_cost_rate <>", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateGreaterThan(Integer value) {
            addCriterion("lock_head_trip_cost_rate >", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_head_trip_cost_rate >=", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateLessThan(Integer value) {
            addCriterion("lock_head_trip_cost_rate <", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateLessThanOrEqualTo(Integer value) {
            addCriterion("lock_head_trip_cost_rate <=", value, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateIn(List<Integer> values) {
            addCriterion("lock_head_trip_cost_rate in", values, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateNotIn(List<Integer> values) {
            addCriterion("lock_head_trip_cost_rate not in", values, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateBetween(Integer value1, Integer value2) {
            addCriterion("lock_head_trip_cost_rate between", value1, value2, "lockHeadTripCostRate");
            return (Criteria) this;
        }

        public Criteria andLockHeadTripCostRateNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_head_trip_cost_rate not between", value1, value2, "lockHeadTripCostRate");
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