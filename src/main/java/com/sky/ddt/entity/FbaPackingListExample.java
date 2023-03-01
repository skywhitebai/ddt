package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FbaPackingListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbaPackingListExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("plan_id like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("plan_id not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andShipToIsNull() {
            addCriterion("ship_to is null");
            return (Criteria) this;
        }

        public Criteria andShipToIsNotNull() {
            addCriterion("ship_to is not null");
            return (Criteria) this;
        }

        public Criteria andShipToEqualTo(String value) {
            addCriterion("ship_to =", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotEqualTo(String value) {
            addCriterion("ship_to <>", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThan(String value) {
            addCriterion("ship_to >", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThanOrEqualTo(String value) {
            addCriterion("ship_to >=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThan(String value) {
            addCriterion("ship_to <", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThanOrEqualTo(String value) {
            addCriterion("ship_to <=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLike(String value) {
            addCriterion("ship_to like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotLike(String value) {
            addCriterion("ship_to not like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToIn(List<String> values) {
            addCriterion("ship_to in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotIn(List<String> values) {
            addCriterion("ship_to not in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToBetween(String value1, String value2) {
            addCriterion("ship_to between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotBetween(String value1, String value2) {
            addCriterion("ship_to not between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIsNull() {
            addCriterion("reference_id is null");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIsNotNull() {
            addCriterion("reference_id is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceIdEqualTo(String value) {
            addCriterion("reference_id =", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotEqualTo(String value) {
            addCriterion("reference_id <>", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdGreaterThan(String value) {
            addCriterion("reference_id >", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdGreaterThanOrEqualTo(String value) {
            addCriterion("reference_id >=", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdLessThan(String value) {
            addCriterion("reference_id <", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdLessThanOrEqualTo(String value) {
            addCriterion("reference_id <=", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdLike(String value) {
            addCriterion("reference_id like", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotLike(String value) {
            addCriterion("reference_id not like", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIn(List<String> values) {
            addCriterion("reference_id in", values, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotIn(List<String> values) {
            addCriterion("reference_id not in", values, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdBetween(String value1, String value2) {
            addCriterion("reference_id between", value1, value2, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotBetween(String value1, String value2) {
            addCriterion("reference_id not between", value1, value2, "referenceId");
            return (Criteria) this;
        }

        public Criteria andTotalSkusIsNull() {
            addCriterion("total_skus is null");
            return (Criteria) this;
        }

        public Criteria andTotalSkusIsNotNull() {
            addCriterion("total_skus is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSkusEqualTo(Integer value) {
            addCriterion("total_skus =", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusNotEqualTo(Integer value) {
            addCriterion("total_skus <>", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusGreaterThan(Integer value) {
            addCriterion("total_skus >", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_skus >=", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusLessThan(Integer value) {
            addCriterion("total_skus <", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusLessThanOrEqualTo(Integer value) {
            addCriterion("total_skus <=", value, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusIn(List<Integer> values) {
            addCriterion("total_skus in", values, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusNotIn(List<Integer> values) {
            addCriterion("total_skus not in", values, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusBetween(Integer value1, Integer value2) {
            addCriterion("total_skus between", value1, value2, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalSkusNotBetween(Integer value1, Integer value2) {
            addCriterion("total_skus not between", value1, value2, "totalSkus");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsIsNull() {
            addCriterion("total_units is null");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsIsNotNull() {
            addCriterion("total_units is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsEqualTo(Integer value) {
            addCriterion("total_units =", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsNotEqualTo(Integer value) {
            addCriterion("total_units <>", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsGreaterThan(Integer value) {
            addCriterion("total_units >", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_units >=", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsLessThan(Integer value) {
            addCriterion("total_units <", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsLessThanOrEqualTo(Integer value) {
            addCriterion("total_units <=", value, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsIn(List<Integer> values) {
            addCriterion("total_units in", values, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsNotIn(List<Integer> values) {
            addCriterion("total_units not in", values, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsBetween(Integer value1, Integer value2) {
            addCriterion("total_units between", value1, value2, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andTotalUnitsNotBetween(Integer value1, Integer value2) {
            addCriterion("total_units not between", value1, value2, "totalUnits");
            return (Criteria) this;
        }

        public Criteria andPackListIsNull() {
            addCriterion("pack_list is null");
            return (Criteria) this;
        }

        public Criteria andPackListIsNotNull() {
            addCriterion("pack_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackListEqualTo(Date value) {
            addCriterion("pack_list =", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListNotEqualTo(Date value) {
            addCriterion("pack_list <>", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListGreaterThan(Date value) {
            addCriterion("pack_list >", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListGreaterThanOrEqualTo(Date value) {
            addCriterion("pack_list >=", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListLessThan(Date value) {
            addCriterion("pack_list <", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListLessThanOrEqualTo(Date value) {
            addCriterion("pack_list <=", value, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListIn(List<Date> values) {
            addCriterion("pack_list in", values, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListNotIn(List<Date> values) {
            addCriterion("pack_list not in", values, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListBetween(Date value1, Date value2) {
            addCriterion("pack_list between", value1, value2, "packList");
            return (Criteria) this;
        }

        public Criteria andPackListNotBetween(Date value1, Date value2) {
            addCriterion("pack_list not between", value1, value2, "packList");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andBoxNumberIsNull() {
            addCriterion("box_number is null");
            return (Criteria) this;
        }

        public Criteria andBoxNumberIsNotNull() {
            addCriterion("box_number is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNumberEqualTo(Integer value) {
            addCriterion("box_number =", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberNotEqualTo(Integer value) {
            addCriterion("box_number <>", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberGreaterThan(Integer value) {
            addCriterion("box_number >", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_number >=", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberLessThan(Integer value) {
            addCriterion("box_number <", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberLessThanOrEqualTo(Integer value) {
            addCriterion("box_number <=", value, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberIn(List<Integer> values) {
            addCriterion("box_number in", values, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberNotIn(List<Integer> values) {
            addCriterion("box_number not in", values, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberBetween(Integer value1, Integer value2) {
            addCriterion("box_number between", value1, value2, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("box_number not between", value1, value2, "boxNumber");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNull() {
            addCriterion("box_name is null");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNotNull() {
            addCriterion("box_name is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNameEqualTo(String value) {
            addCriterion("box_name =", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotEqualTo(String value) {
            addCriterion("box_name <>", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThan(String value) {
            addCriterion("box_name >", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThanOrEqualTo(String value) {
            addCriterion("box_name >=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThan(String value) {
            addCriterion("box_name <", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThanOrEqualTo(String value) {
            addCriterion("box_name <=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLike(String value) {
            addCriterion("box_name like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotLike(String value) {
            addCriterion("box_name not like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameIn(List<String> values) {
            addCriterion("box_name in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotIn(List<String> values) {
            addCriterion("box_name not in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameBetween(String value1, String value2) {
            addCriterion("box_name between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotBetween(String value1, String value2) {
            addCriterion("box_name not between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrIsNull() {
            addCriterion("address_abbr is null");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrIsNotNull() {
            addCriterion("address_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrEqualTo(String value) {
            addCriterion("address_abbr =", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrNotEqualTo(String value) {
            addCriterion("address_abbr <>", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrGreaterThan(String value) {
            addCriterion("address_abbr >", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("address_abbr >=", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrLessThan(String value) {
            addCriterion("address_abbr <", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrLessThanOrEqualTo(String value) {
            addCriterion("address_abbr <=", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrLike(String value) {
            addCriterion("address_abbr like", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrNotLike(String value) {
            addCriterion("address_abbr not like", value, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrIn(List<String> values) {
            addCriterion("address_abbr in", values, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrNotIn(List<String> values) {
            addCriterion("address_abbr not in", values, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrBetween(String value1, String value2) {
            addCriterion("address_abbr between", value1, value2, "addressAbbr");
            return (Criteria) this;
        }

        public Criteria andAddressAbbrNotBetween(String value1, String value2) {
            addCriterion("address_abbr not between", value1, value2, "addressAbbr");
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