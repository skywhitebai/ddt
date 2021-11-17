package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostCalculationSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostCalculationSkuExample() {
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

        public Criteria andCostCalculationIdIsNull() {
            addCriterion("cost_calculation_id is null");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdIsNotNull() {
            addCriterion("cost_calculation_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdEqualTo(Integer value) {
            addCriterion("cost_calculation_id =", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdNotEqualTo(Integer value) {
            addCriterion("cost_calculation_id <>", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdGreaterThan(Integer value) {
            addCriterion("cost_calculation_id >", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_calculation_id >=", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdLessThan(Integer value) {
            addCriterion("cost_calculation_id <", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdLessThanOrEqualTo(Integer value) {
            addCriterion("cost_calculation_id <=", value, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdIn(List<Integer> values) {
            addCriterion("cost_calculation_id in", values, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdNotIn(List<Integer> values) {
            addCriterion("cost_calculation_id not in", values, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdBetween(Integer value1, Integer value2) {
            addCriterion("cost_calculation_id between", value1, value2, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andCostCalculationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_calculation_id not between", value1, value2, "costCalculationId");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Date value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Date value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Date value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Date value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Date value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Date value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Date> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Date> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Date value1, Date value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Date value1, Date value2) {
            addCriterion("month not between", value1, value2, "month");
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

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andLabourCostIsNull() {
            addCriterion("labour_cost is null");
            return (Criteria) this;
        }

        public Criteria andLabourCostIsNotNull() {
            addCriterion("labour_cost is not null");
            return (Criteria) this;
        }

        public Criteria andLabourCostEqualTo(BigDecimal value) {
            addCriterion("labour_cost =", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostNotEqualTo(BigDecimal value) {
            addCriterion("labour_cost <>", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostGreaterThan(BigDecimal value) {
            addCriterion("labour_cost >", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("labour_cost >=", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostLessThan(BigDecimal value) {
            addCriterion("labour_cost <", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("labour_cost <=", value, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostIn(List<BigDecimal> values) {
            addCriterion("labour_cost in", values, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostNotIn(List<BigDecimal> values) {
            addCriterion("labour_cost not in", values, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labour_cost between", value1, value2, "labourCost");
            return (Criteria) this;
        }

        public Criteria andLabourCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labour_cost not between", value1, value2, "labourCost");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeIsNull() {
            addCriterion("cost_price_before is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeIsNotNull() {
            addCriterion("cost_price_before is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeEqualTo(BigDecimal value) {
            addCriterion("cost_price_before =", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeNotEqualTo(BigDecimal value) {
            addCriterion("cost_price_before <>", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeGreaterThan(BigDecimal value) {
            addCriterion("cost_price_before >", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price_before >=", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeLessThan(BigDecimal value) {
            addCriterion("cost_price_before <", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price_before <=", value, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeIn(List<BigDecimal> values) {
            addCriterion("cost_price_before in", values, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeNotIn(List<BigDecimal> values) {
            addCriterion("cost_price_before not in", values, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price_before between", value1, value2, "costPriceBefore");
            return (Criteria) this;
        }

        public Criteria andCostPriceBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price_before not between", value1, value2, "costPriceBefore");
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

        public Criteria andProductionCostTotalIsNull() {
            addCriterion("production_cost_total is null");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalIsNotNull() {
            addCriterion("production_cost_total is not null");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalEqualTo(BigDecimal value) {
            addCriterion("production_cost_total =", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalNotEqualTo(BigDecimal value) {
            addCriterion("production_cost_total <>", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalGreaterThan(BigDecimal value) {
            addCriterion("production_cost_total >", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("production_cost_total >=", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalLessThan(BigDecimal value) {
            addCriterion("production_cost_total <", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("production_cost_total <=", value, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalIn(List<BigDecimal> values) {
            addCriterion("production_cost_total in", values, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalNotIn(List<BigDecimal> values) {
            addCriterion("production_cost_total not in", values, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("production_cost_total between", value1, value2, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("production_cost_total not between", value1, value2, "productionCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceIsNull() {
            addCriterion("production_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceIsNotNull() {
            addCriterion("production_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceEqualTo(BigDecimal value) {
            addCriterion("production_cost_price =", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("production_cost_price <>", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceGreaterThan(BigDecimal value) {
            addCriterion("production_cost_price >", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("production_cost_price >=", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceLessThan(BigDecimal value) {
            addCriterion("production_cost_price <", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("production_cost_price <=", value, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceIn(List<BigDecimal> values) {
            addCriterion("production_cost_price in", values, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("production_cost_price not in", values, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("production_cost_price between", value1, value2, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductionCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("production_cost_price not between", value1, value2, "productionCostPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterIsNull() {
            addCriterion("cost_price_after is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterIsNotNull() {
            addCriterion("cost_price_after is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterEqualTo(BigDecimal value) {
            addCriterion("cost_price_after =", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterNotEqualTo(BigDecimal value) {
            addCriterion("cost_price_after <>", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterGreaterThan(BigDecimal value) {
            addCriterion("cost_price_after >", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price_after >=", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterLessThan(BigDecimal value) {
            addCriterion("cost_price_after <", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price_after <=", value, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterIn(List<BigDecimal> values) {
            addCriterion("cost_price_after in", values, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterNotIn(List<BigDecimal> values) {
            addCriterion("cost_price_after not in", values, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price_after between", value1, value2, "costPriceAfter");
            return (Criteria) this;
        }

        public Criteria andCostPriceAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price_after not between", value1, value2, "costPriceAfter");
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