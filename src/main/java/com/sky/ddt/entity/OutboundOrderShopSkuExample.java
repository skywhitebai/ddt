package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutboundOrderShopSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutboundOrderShopSkuExample() {
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

        public Criteria andOutboundOrderIdIsNull() {
            addCriterion("outbound_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdIsNotNull() {
            addCriterion("outbound_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdEqualTo(Integer value) {
            addCriterion("outbound_order_id =", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdNotEqualTo(Integer value) {
            addCriterion("outbound_order_id <>", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdGreaterThan(Integer value) {
            addCriterion("outbound_order_id >", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("outbound_order_id >=", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdLessThan(Integer value) {
            addCriterion("outbound_order_id <", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("outbound_order_id <=", value, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdIn(List<Integer> values) {
            addCriterion("outbound_order_id in", values, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdNotIn(List<Integer> values) {
            addCriterion("outbound_order_id not in", values, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("outbound_order_id between", value1, value2, "outboundOrderId");
            return (Criteria) this;
        }

        public Criteria andOutboundOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("outbound_order_id not between", value1, value2, "outboundOrderId");
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

        public Criteria andOutboundQuantityIsNull() {
            addCriterion("outbound_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityIsNotNull() {
            addCriterion("outbound_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityEqualTo(Integer value) {
            addCriterion("outbound_quantity =", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityNotEqualTo(Integer value) {
            addCriterion("outbound_quantity <>", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityGreaterThan(Integer value) {
            addCriterion("outbound_quantity >", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("outbound_quantity >=", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityLessThan(Integer value) {
            addCriterion("outbound_quantity <", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("outbound_quantity <=", value, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityIn(List<Integer> values) {
            addCriterion("outbound_quantity in", values, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityNotIn(List<Integer> values) {
            addCriterion("outbound_quantity not in", values, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityBetween(Integer value1, Integer value2) {
            addCriterion("outbound_quantity between", value1, value2, "outboundQuantity");
            return (Criteria) this;
        }

        public Criteria andOutboundQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("outbound_quantity not between", value1, value2, "outboundQuantity");
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