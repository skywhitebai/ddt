package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockRecordItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockRecordItemExample() {
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

        public Criteria andStockRecordIdIsNull() {
            addCriterion("stock_record_id is null");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdIsNotNull() {
            addCriterion("stock_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdEqualTo(Integer value) {
            addCriterion("stock_record_id =", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdNotEqualTo(Integer value) {
            addCriterion("stock_record_id <>", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdGreaterThan(Integer value) {
            addCriterion("stock_record_id >", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_record_id >=", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdLessThan(Integer value) {
            addCriterion("stock_record_id <", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("stock_record_id <=", value, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdIn(List<Integer> values) {
            addCriterion("stock_record_id in", values, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdNotIn(List<Integer> values) {
            addCriterion("stock_record_id not in", values, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("stock_record_id between", value1, value2, "stockRecordId");
            return (Criteria) this;
        }

        public Criteria andStockRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_record_id not between", value1, value2, "stockRecordId");
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

        public Criteria andStockQuantityIsNull() {
            addCriterion("stock_quantity is null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityIsNotNull() {
            addCriterion("stock_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityEqualTo(Integer value) {
            addCriterion("stock_quantity =", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotEqualTo(Integer value) {
            addCriterion("stock_quantity <>", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityGreaterThan(Integer value) {
            addCriterion("stock_quantity >", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity >=", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityLessThan(Integer value) {
            addCriterion("stock_quantity <", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity <=", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityIn(List<Integer> values) {
            addCriterion("stock_quantity in", values, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotIn(List<Integer> values) {
            addCriterion("stock_quantity not in", values, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity between", value1, value2, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity not between", value1, value2, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyIsNull() {
            addCriterion("stock_quantity_ky is null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyIsNotNull() {
            addCriterion("stock_quantity_ky is not null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyEqualTo(Integer value) {
            addCriterion("stock_quantity_ky =", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyNotEqualTo(Integer value) {
            addCriterion("stock_quantity_ky <>", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyGreaterThan(Integer value) {
            addCriterion("stock_quantity_ky >", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_ky >=", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyLessThan(Integer value) {
            addCriterion("stock_quantity_ky <", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyLessThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_ky <=", value, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyIn(List<Integer> values) {
            addCriterion("stock_quantity_ky in", values, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyNotIn(List<Integer> values) {
            addCriterion("stock_quantity_ky not in", values, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_ky between", value1, value2, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKyNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_ky not between", value1, value2, "stockQuantityKy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpIsNull() {
            addCriterion("stock_quantity_kp is null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpIsNotNull() {
            addCriterion("stock_quantity_kp is not null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpEqualTo(Integer value) {
            addCriterion("stock_quantity_kp =", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpNotEqualTo(Integer value) {
            addCriterion("stock_quantity_kp <>", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpGreaterThan(Integer value) {
            addCriterion("stock_quantity_kp >", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_kp >=", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpLessThan(Integer value) {
            addCriterion("stock_quantity_kp <", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpLessThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_kp <=", value, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpIn(List<Integer> values) {
            addCriterion("stock_quantity_kp in", values, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpNotIn(List<Integer> values) {
            addCriterion("stock_quantity_kp not in", values, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_kp between", value1, value2, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityKpNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_kp not between", value1, value2, "stockQuantityKp");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyIsNull() {
            addCriterion("stock_quantity_hy is null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyIsNotNull() {
            addCriterion("stock_quantity_hy is not null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyEqualTo(Integer value) {
            addCriterion("stock_quantity_hy =", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyNotEqualTo(Integer value) {
            addCriterion("stock_quantity_hy <>", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyGreaterThan(Integer value) {
            addCriterion("stock_quantity_hy >", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_hy >=", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyLessThan(Integer value) {
            addCriterion("stock_quantity_hy <", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyLessThanOrEqualTo(Integer value) {
            addCriterion("stock_quantity_hy <=", value, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyIn(List<Integer> values) {
            addCriterion("stock_quantity_hy in", values, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyNotIn(List<Integer> values) {
            addCriterion("stock_quantity_hy not in", values, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_hy between", value1, value2, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andStockQuantityHyNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_quantity_hy not between", value1, value2, "stockQuantityHy");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityIsNull() {
            addCriterion("production_quantity is null");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityIsNotNull() {
            addCriterion("production_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityEqualTo(Integer value) {
            addCriterion("production_quantity =", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityNotEqualTo(Integer value) {
            addCriterion("production_quantity <>", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityGreaterThan(Integer value) {
            addCriterion("production_quantity >", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("production_quantity >=", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityLessThan(Integer value) {
            addCriterion("production_quantity <", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("production_quantity <=", value, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityIn(List<Integer> values) {
            addCriterion("production_quantity in", values, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityNotIn(List<Integer> values) {
            addCriterion("production_quantity not in", values, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityBetween(Integer value1, Integer value2) {
            addCriterion("production_quantity between", value1, value2, "productionQuantity");
            return (Criteria) this;
        }

        public Criteria andProductionQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("production_quantity not between", value1, value2, "productionQuantity");
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