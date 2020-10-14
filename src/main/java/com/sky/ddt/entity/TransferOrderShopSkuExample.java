package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferOrderShopSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferOrderShopSkuExample() {
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

        public Criteria andTransferOrderIdIsNull() {
            addCriterion("transfer_order_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdIsNotNull() {
            addCriterion("transfer_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdEqualTo(Integer value) {
            addCriterion("transfer_order_id =", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdNotEqualTo(Integer value) {
            addCriterion("transfer_order_id <>", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdGreaterThan(Integer value) {
            addCriterion("transfer_order_id >", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_order_id >=", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdLessThan(Integer value) {
            addCriterion("transfer_order_id <", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_order_id <=", value, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdIn(List<Integer> values) {
            addCriterion("transfer_order_id in", values, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdNotIn(List<Integer> values) {
            addCriterion("transfer_order_id not in", values, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("transfer_order_id between", value1, value2, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andTransferOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_order_id not between", value1, value2, "transferOrderId");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromIsNull() {
            addCriterion("shop_sku_id_from is null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromIsNotNull() {
            addCriterion("shop_sku_id_from is not null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromEqualTo(Integer value) {
            addCriterion("shop_sku_id_from =", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromNotEqualTo(Integer value) {
            addCriterion("shop_sku_id_from <>", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromGreaterThan(Integer value) {
            addCriterion("shop_sku_id_from >", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id_from >=", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromLessThan(Integer value) {
            addCriterion("shop_sku_id_from <", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromLessThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id_from <=", value, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromIn(List<Integer> values) {
            addCriterion("shop_sku_id_from in", values, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromNotIn(List<Integer> values) {
            addCriterion("shop_sku_id_from not in", values, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id_from between", value1, value2, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdFromNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id_from not between", value1, value2, "shopSkuIdFrom");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToIsNull() {
            addCriterion("shop_sku_id_to is null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToIsNotNull() {
            addCriterion("shop_sku_id_to is not null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToEqualTo(Integer value) {
            addCriterion("shop_sku_id_to =", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToNotEqualTo(Integer value) {
            addCriterion("shop_sku_id_to <>", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToGreaterThan(Integer value) {
            addCriterion("shop_sku_id_to >", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id_to >=", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToLessThan(Integer value) {
            addCriterion("shop_sku_id_to <", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToLessThanOrEqualTo(Integer value) {
            addCriterion("shop_sku_id_to <=", value, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToIn(List<Integer> values) {
            addCriterion("shop_sku_id_to in", values, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToNotIn(List<Integer> values) {
            addCriterion("shop_sku_id_to not in", values, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id_to between", value1, value2, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andShopSkuIdToNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_sku_id_to not between", value1, value2, "shopSkuIdTo");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityIsNull() {
            addCriterion("transfer_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityIsNotNull() {
            addCriterion("transfer_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityEqualTo(Integer value) {
            addCriterion("transfer_quantity =", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityNotEqualTo(Integer value) {
            addCriterion("transfer_quantity <>", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityGreaterThan(Integer value) {
            addCriterion("transfer_quantity >", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_quantity >=", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityLessThan(Integer value) {
            addCriterion("transfer_quantity <", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_quantity <=", value, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityIn(List<Integer> values) {
            addCriterion("transfer_quantity in", values, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityNotIn(List<Integer> values) {
            addCriterion("transfer_quantity not in", values, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityBetween(Integer value1, Integer value2) {
            addCriterion("transfer_quantity between", value1, value2, "transferQuantity");
            return (Criteria) this;
        }

        public Criteria andTransferQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_quantity not between", value1, value2, "transferQuantity");
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