package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopSkuHeadTripCostHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopSkuHeadTripCostHisExample() {
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

        public Criteria andShopHeadTripCostIdIsNull() {
            addCriterion("shop_head_trip_cost_id is null");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdIsNotNull() {
            addCriterion("shop_head_trip_cost_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdEqualTo(Integer value) {
            addCriterion("shop_head_trip_cost_id =", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdNotEqualTo(Integer value) {
            addCriterion("shop_head_trip_cost_id <>", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdGreaterThan(Integer value) {
            addCriterion("shop_head_trip_cost_id >", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_head_trip_cost_id >=", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdLessThan(Integer value) {
            addCriterion("shop_head_trip_cost_id <", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_head_trip_cost_id <=", value, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdIn(List<Integer> values) {
            addCriterion("shop_head_trip_cost_id in", values, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdNotIn(List<Integer> values) {
            addCriterion("shop_head_trip_cost_id not in", values, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_head_trip_cost_id between", value1, value2, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andShopHeadTripCostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_head_trip_cost_id not between", value1, value2, "shopHeadTripCostId");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIsNull() {
            addCriterion("head_trip_cost_before is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIsNotNull() {
            addCriterion("head_trip_cost_before is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before =", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before <>", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_before >", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before >=", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_before <", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_before <=", value, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_before in", values, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_before not in", values, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_before between", value1, value2, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_before not between", value1, value2, "headTripCostBefore");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIsNull() {
            addCriterion("head_trip_cost_after is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIsNotNull() {
            addCriterion("head_trip_cost_after is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after =", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after <>", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost_after >", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after >=", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterLessThan(BigDecimal value) {
            addCriterion("head_trip_cost_after <", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost_after <=", value, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_after in", values, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost_after not in", values, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_after between", value1, value2, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost_after not between", value1, value2, "headTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityIsNull() {
            addCriterion("inventory_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityIsNotNull() {
            addCriterion("inventory_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityEqualTo(Integer value) {
            addCriterion("inventory_quantity =", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityNotEqualTo(Integer value) {
            addCriterion("inventory_quantity <>", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityGreaterThan(Integer value) {
            addCriterion("inventory_quantity >", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory_quantity >=", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityLessThan(Integer value) {
            addCriterion("inventory_quantity <", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("inventory_quantity <=", value, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityIn(List<Integer> values) {
            addCriterion("inventory_quantity in", values, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityNotIn(List<Integer> values) {
            addCriterion("inventory_quantity not in", values, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityBetween(Integer value1, Integer value2) {
            addCriterion("inventory_quantity between", value1, value2, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andInventoryQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory_quantity not between", value1, value2, "inventoryQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityIsNull() {
            addCriterion("fba_send_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityIsNotNull() {
            addCriterion("fba_send_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityEqualTo(Integer value) {
            addCriterion("fba_send_quantity =", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityNotEqualTo(Integer value) {
            addCriterion("fba_send_quantity <>", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityGreaterThan(Integer value) {
            addCriterion("fba_send_quantity >", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("fba_send_quantity >=", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityLessThan(Integer value) {
            addCriterion("fba_send_quantity <", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("fba_send_quantity <=", value, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityIn(List<Integer> values) {
            addCriterion("fba_send_quantity in", values, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityNotIn(List<Integer> values) {
            addCriterion("fba_send_quantity not in", values, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityBetween(Integer value1, Integer value2) {
            addCriterion("fba_send_quantity between", value1, value2, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaSendQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("fba_send_quantity not between", value1, value2, "fbaSendQuantity");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostIsNull() {
            addCriterion("fba_head_trip_cost is null");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostIsNotNull() {
            addCriterion("fba_head_trip_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostEqualTo(BigDecimal value) {
            addCriterion("fba_head_trip_cost =", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostNotEqualTo(BigDecimal value) {
            addCriterion("fba_head_trip_cost <>", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostGreaterThan(BigDecimal value) {
            addCriterion("fba_head_trip_cost >", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_head_trip_cost >=", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostLessThan(BigDecimal value) {
            addCriterion("fba_head_trip_cost <", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_head_trip_cost <=", value, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostIn(List<BigDecimal> values) {
            addCriterion("fba_head_trip_cost in", values, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostNotIn(List<BigDecimal> values) {
            addCriterion("fba_head_trip_cost not in", values, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_head_trip_cost between", value1, value2, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andFbaHeadTripCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_head_trip_cost not between", value1, value2, "fbaHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostIsNull() {
            addCriterion("total_head_trip_cost is null");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostIsNotNull() {
            addCriterion("total_head_trip_cost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostEqualTo(BigDecimal value) {
            addCriterion("total_head_trip_cost =", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostNotEqualTo(BigDecimal value) {
            addCriterion("total_head_trip_cost <>", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostGreaterThan(BigDecimal value) {
            addCriterion("total_head_trip_cost >", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_head_trip_cost >=", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostLessThan(BigDecimal value) {
            addCriterion("total_head_trip_cost <", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_head_trip_cost <=", value, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostIn(List<BigDecimal> values) {
            addCriterion("total_head_trip_cost in", values, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostNotIn(List<BigDecimal> values) {
            addCriterion("total_head_trip_cost not in", values, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_head_trip_cost between", value1, value2, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andTotalHeadTripCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_head_trip_cost not between", value1, value2, "totalHeadTripCost");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkIsNull() {
            addCriterion("create_remark is null");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkIsNotNull() {
            addCriterion("create_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkEqualTo(String value) {
            addCriterion("create_remark =", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkNotEqualTo(String value) {
            addCriterion("create_remark <>", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkGreaterThan(String value) {
            addCriterion("create_remark >", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("create_remark >=", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkLessThan(String value) {
            addCriterion("create_remark <", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkLessThanOrEqualTo(String value) {
            addCriterion("create_remark <=", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkLike(String value) {
            addCriterion("create_remark like", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkNotLike(String value) {
            addCriterion("create_remark not like", value, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkIn(List<String> values) {
            addCriterion("create_remark in", values, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkNotIn(List<String> values) {
            addCriterion("create_remark not in", values, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkBetween(String value1, String value2) {
            addCriterion("create_remark between", value1, value2, "createRemark");
            return (Criteria) this;
        }

        public Criteria andCreateRemarkNotBetween(String value1, String value2) {
            addCriterion("create_remark not between", value1, value2, "createRemark");
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