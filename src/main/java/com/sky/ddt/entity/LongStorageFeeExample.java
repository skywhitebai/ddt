package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LongStorageFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LongStorageFeeExample() {
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

        public Criteria andSnapshotDateIsNull() {
            addCriterion("snapshot_date is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateIsNotNull() {
            addCriterion("snapshot_date is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateEqualTo(Date value) {
            addCriterion("snapshot_date =", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateNotEqualTo(Date value) {
            addCriterion("snapshot_date <>", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateGreaterThan(Date value) {
            addCriterion("snapshot_date >", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateGreaterThanOrEqualTo(Date value) {
            addCriterion("snapshot_date >=", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateLessThan(Date value) {
            addCriterion("snapshot_date <", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateLessThanOrEqualTo(Date value) {
            addCriterion("snapshot_date <=", value, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateIn(List<Date> values) {
            addCriterion("snapshot_date in", values, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateNotIn(List<Date> values) {
            addCriterion("snapshot_date not in", values, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateBetween(Date value1, Date value2) {
            addCriterion("snapshot_date between", value1, value2, "snapshotDate");
            return (Criteria) this;
        }

        public Criteria andSnapshotDateNotBetween(Date value1, Date value2) {
            addCriterion("snapshot_date not between", value1, value2, "snapshotDate");
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

        public Criteria andConditionTypeIsNull() {
            addCriterion("condition_type is null");
            return (Criteria) this;
        }

        public Criteria andConditionTypeIsNotNull() {
            addCriterion("condition_type is not null");
            return (Criteria) this;
        }

        public Criteria andConditionTypeEqualTo(String value) {
            addCriterion("condition_type =", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotEqualTo(String value) {
            addCriterion("condition_type <>", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeGreaterThan(String value) {
            addCriterion("condition_type >", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("condition_type >=", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLessThan(String value) {
            addCriterion("condition_type <", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLessThanOrEqualTo(String value) {
            addCriterion("condition_type <=", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLike(String value) {
            addCriterion("condition_type like", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotLike(String value) {
            addCriterion("condition_type not like", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeIn(List<String> values) {
            addCriterion("condition_type in", values, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotIn(List<String> values) {
            addCriterion("condition_type not in", values, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeBetween(String value1, String value2) {
            addCriterion("condition_type between", value1, value2, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotBetween(String value1, String value2) {
            addCriterion("condition_type not between", value1, value2, "conditionType");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeIsNull() {
            addCriterion("qty_charged_12_mo_long_term_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeIsNotNull() {
            addCriterion("qty_charged_12_mo_long_term_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeEqualTo(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee =", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee <>", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee >", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee >=", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeLessThan(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee <", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee <=", value, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeIn(List<BigDecimal> values) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee in", values, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee not in", values, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee between", value1, value2, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged12MoLongTermStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty_charged_12_mo_long_term_storage_fee not between", value1, value2, "qtyCharged12MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIsNull() {
            addCriterion("per_unit_volume is null");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIsNotNull() {
            addCriterion("per_unit_volume is not null");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume =", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume <>", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeGreaterThan(BigDecimal value) {
            addCriterion("per_unit_volume >", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume >=", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeLessThan(BigDecimal value) {
            addCriterion("per_unit_volume <", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_unit_volume <=", value, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeIn(List<BigDecimal> values) {
            addCriterion("per_unit_volume in", values, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotIn(List<BigDecimal> values) {
            addCriterion("per_unit_volume not in", values, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_unit_volume between", value1, value2, "perUnitVolume");
            return (Criteria) this;
        }

        public Criteria andPerUnitVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_unit_volume not between", value1, value2, "perUnitVolume");
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

        public Criteria andMo12LongTermsStorageFeeIsNull() {
            addCriterion("mo_12_long_terms_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeIsNotNull() {
            addCriterion("mo_12_long_terms_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeEqualTo(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee =", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee <>", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee >", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee >=", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeLessThan(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee <", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mo_12_long_terms_storage_fee <=", value, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeIn(List<BigDecimal> values) {
            addCriterion("mo_12_long_terms_storage_fee in", values, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("mo_12_long_terms_storage_fee not in", values, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mo_12_long_terms_storage_fee between", value1, value2, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo12LongTermsStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mo_12_long_terms_storage_fee not between", value1, value2, "mo12LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeIsNull() {
            addCriterion("qty_charged_6_mo_long_term_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeIsNotNull() {
            addCriterion("qty_charged_6_mo_long_term_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeEqualTo(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee =", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee <>", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee >", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee >=", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeLessThan(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee <", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee <=", value, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeIn(List<BigDecimal> values) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee in", values, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee not in", values, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee between", value1, value2, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andQtyCharged6MoLongTermStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty_charged_6_mo_long_term_storage_fee not between", value1, value2, "qtyCharged6MoLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeIsNull() {
            addCriterion("mo_6_long_terms_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeIsNotNull() {
            addCriterion("mo_6_long_terms_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeEqualTo(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee =", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee <>", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee >", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee >=", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeLessThan(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee <", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mo_6_long_terms_storage_fee <=", value, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeIn(List<BigDecimal> values) {
            addCriterion("mo_6_long_terms_storage_fee in", values, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("mo_6_long_terms_storage_fee not in", values, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mo_6_long_terms_storage_fee between", value1, value2, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andMo6LongTermsStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mo_6_long_terms_storage_fee not between", value1, value2, "mo6LongTermsStorageFee");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIsNull() {
            addCriterion("volume_unit is null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIsNotNull() {
            addCriterion("volume_unit is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitEqualTo(String value) {
            addCriterion("volume_unit =", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotEqualTo(String value) {
            addCriterion("volume_unit <>", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitGreaterThan(String value) {
            addCriterion("volume_unit >", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("volume_unit >=", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLessThan(String value) {
            addCriterion("volume_unit <", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLessThanOrEqualTo(String value) {
            addCriterion("volume_unit <=", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLike(String value) {
            addCriterion("volume_unit like", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotLike(String value) {
            addCriterion("volume_unit not like", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIn(List<String> values) {
            addCriterion("volume_unit in", values, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotIn(List<String> values) {
            addCriterion("volume_unit not in", values, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitBetween(String value1, String value2) {
            addCriterion("volume_unit between", value1, value2, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotBetween(String value1, String value2) {
            addCriterion("volume_unit not between", value1, value2, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightIsNull() {
            addCriterion("enrolled_in_small_and_light is null");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightIsNotNull() {
            addCriterion("enrolled_in_small_and_light is not null");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightEqualTo(String value) {
            addCriterion("enrolled_in_small_and_light =", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightNotEqualTo(String value) {
            addCriterion("enrolled_in_small_and_light <>", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightGreaterThan(String value) {
            addCriterion("enrolled_in_small_and_light >", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightGreaterThanOrEqualTo(String value) {
            addCriterion("enrolled_in_small_and_light >=", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightLessThan(String value) {
            addCriterion("enrolled_in_small_and_light <", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightLessThanOrEqualTo(String value) {
            addCriterion("enrolled_in_small_and_light <=", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightLike(String value) {
            addCriterion("enrolled_in_small_and_light like", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightNotLike(String value) {
            addCriterion("enrolled_in_small_and_light not like", value, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightIn(List<String> values) {
            addCriterion("enrolled_in_small_and_light in", values, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightNotIn(List<String> values) {
            addCriterion("enrolled_in_small_and_light not in", values, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightBetween(String value1, String value2) {
            addCriterion("enrolled_in_small_and_light between", value1, value2, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andEnrolledInSmallAndLightNotBetween(String value1, String value2) {
            addCriterion("enrolled_in_small_and_light not between", value1, value2, "enrolledInSmallAndLight");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierIsNull() {
            addCriterion("surcharge_age_tier is null");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierIsNotNull() {
            addCriterion("surcharge_age_tier is not null");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierEqualTo(String value) {
            addCriterion("surcharge_age_tier =", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierNotEqualTo(String value) {
            addCriterion("surcharge_age_tier <>", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierGreaterThan(String value) {
            addCriterion("surcharge_age_tier >", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierGreaterThanOrEqualTo(String value) {
            addCriterion("surcharge_age_tier >=", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierLessThan(String value) {
            addCriterion("surcharge_age_tier <", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierLessThanOrEqualTo(String value) {
            addCriterion("surcharge_age_tier <=", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierLike(String value) {
            addCriterion("surcharge_age_tier like", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierNotLike(String value) {
            addCriterion("surcharge_age_tier not like", value, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierIn(List<String> values) {
            addCriterion("surcharge_age_tier in", values, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierNotIn(List<String> values) {
            addCriterion("surcharge_age_tier not in", values, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierBetween(String value1, String value2) {
            addCriterion("surcharge_age_tier between", value1, value2, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andSurchargeAgeTierNotBetween(String value1, String value2) {
            addCriterion("surcharge_age_tier not between", value1, value2, "surchargeAgeTier");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeIsNull() {
            addCriterion("rate_surcharge is null");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeIsNotNull() {
            addCriterion("rate_surcharge is not null");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeEqualTo(BigDecimal value) {
            addCriterion("rate_surcharge =", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeNotEqualTo(BigDecimal value) {
            addCriterion("rate_surcharge <>", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeGreaterThan(BigDecimal value) {
            addCriterion("rate_surcharge >", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_surcharge >=", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeLessThan(BigDecimal value) {
            addCriterion("rate_surcharge <", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_surcharge <=", value, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeIn(List<BigDecimal> values) {
            addCriterion("rate_surcharge in", values, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeNotIn(List<BigDecimal> values) {
            addCriterion("rate_surcharge not in", values, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_surcharge between", value1, value2, "rateSurcharge");
            return (Criteria) this;
        }

        public Criteria andRateSurchargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_surcharge not between", value1, value2, "rateSurcharge");
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