package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkuInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkuInfoExample() {
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

        public Criteria andSkuSellerIsNull() {
            addCriterion("sku_seller is null");
            return (Criteria) this;
        }

        public Criteria andSkuSellerIsNotNull() {
            addCriterion("sku_seller is not null");
            return (Criteria) this;
        }

        public Criteria andSkuSellerEqualTo(String value) {
            addCriterion("sku_seller =", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerNotEqualTo(String value) {
            addCriterion("sku_seller <>", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerGreaterThan(String value) {
            addCriterion("sku_seller >", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerGreaterThanOrEqualTo(String value) {
            addCriterion("sku_seller >=", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerLessThan(String value) {
            addCriterion("sku_seller <", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerLessThanOrEqualTo(String value) {
            addCriterion("sku_seller <=", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerLike(String value) {
            addCriterion("sku_seller like", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerNotLike(String value) {
            addCriterion("sku_seller not like", value, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerIn(List<String> values) {
            addCriterion("sku_seller in", values, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerNotIn(List<String> values) {
            addCriterion("sku_seller not in", values, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerBetween(String value1, String value2) {
            addCriterion("sku_seller between", value1, value2, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuSellerNotBetween(String value1, String value2) {
            addCriterion("sku_seller not between", value1, value2, "skuSeller");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseIsNull() {
            addCriterion("sku_warehouse is null");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseIsNotNull() {
            addCriterion("sku_warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseEqualTo(String value) {
            addCriterion("sku_warehouse =", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseNotEqualTo(String value) {
            addCriterion("sku_warehouse <>", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseGreaterThan(String value) {
            addCriterion("sku_warehouse >", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("sku_warehouse >=", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseLessThan(String value) {
            addCriterion("sku_warehouse <", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseLessThanOrEqualTo(String value) {
            addCriterion("sku_warehouse <=", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseLike(String value) {
            addCriterion("sku_warehouse like", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseNotLike(String value) {
            addCriterion("sku_warehouse not like", value, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseIn(List<String> values) {
            addCriterion("sku_warehouse in", values, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseNotIn(List<String> values) {
            addCriterion("sku_warehouse not in", values, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseBetween(String value1, String value2) {
            addCriterion("sku_warehouse between", value1, value2, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuWarehouseNotBetween(String value1, String value2) {
            addCriterion("sku_warehouse not between", value1, value2, "skuWarehouse");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierIsNull() {
            addCriterion("sku_supplier is null");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierIsNotNull() {
            addCriterion("sku_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierEqualTo(String value) {
            addCriterion("sku_supplier =", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierNotEqualTo(String value) {
            addCriterion("sku_supplier <>", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierGreaterThan(String value) {
            addCriterion("sku_supplier >", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("sku_supplier >=", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierLessThan(String value) {
            addCriterion("sku_supplier <", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierLessThanOrEqualTo(String value) {
            addCriterion("sku_supplier <=", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierLike(String value) {
            addCriterion("sku_supplier like", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierNotLike(String value) {
            addCriterion("sku_supplier not like", value, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierIn(List<String> values) {
            addCriterion("sku_supplier in", values, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierNotIn(List<String> values) {
            addCriterion("sku_supplier not in", values, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierBetween(String value1, String value2) {
            addCriterion("sku_supplier between", value1, value2, "skuSupplier");
            return (Criteria) this;
        }

        public Criteria andSkuSupplierNotBetween(String value1, String value2) {
            addCriterion("sku_supplier not between", value1, value2, "skuSupplier");
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