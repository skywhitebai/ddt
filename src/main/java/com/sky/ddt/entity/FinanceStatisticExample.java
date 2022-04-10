package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceStatisticExample() {
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostIsNull() {
            addCriterion("initial_inventory_cost is null");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostIsNotNull() {
            addCriterion("initial_inventory_cost is not null");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostEqualTo(BigDecimal value) {
            addCriterion("initial_inventory_cost =", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostNotEqualTo(BigDecimal value) {
            addCriterion("initial_inventory_cost <>", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostGreaterThan(BigDecimal value) {
            addCriterion("initial_inventory_cost >", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_inventory_cost >=", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostLessThan(BigDecimal value) {
            addCriterion("initial_inventory_cost <", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_inventory_cost <=", value, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostIn(List<BigDecimal> values) {
            addCriterion("initial_inventory_cost in", values, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostNotIn(List<BigDecimal> values) {
            addCriterion("initial_inventory_cost not in", values, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_inventory_cost between", value1, value2, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andInitialInventoryCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_inventory_cost not between", value1, value2, "initialInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostIsNull() {
            addCriterion("final_inventory_cost is null");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostIsNotNull() {
            addCriterion("final_inventory_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostEqualTo(BigDecimal value) {
            addCriterion("final_inventory_cost =", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostNotEqualTo(BigDecimal value) {
            addCriterion("final_inventory_cost <>", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostGreaterThan(BigDecimal value) {
            addCriterion("final_inventory_cost >", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_inventory_cost >=", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostLessThan(BigDecimal value) {
            addCriterion("final_inventory_cost <", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_inventory_cost <=", value, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostIn(List<BigDecimal> values) {
            addCriterion("final_inventory_cost in", values, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostNotIn(List<BigDecimal> values) {
            addCriterion("final_inventory_cost not in", values, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_inventory_cost between", value1, value2, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andFinalInventoryCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_inventory_cost not between", value1, value2, "finalInventoryCost");
            return (Criteria) this;
        }

        public Criteria andSendCostIsNull() {
            addCriterion("send_cost is null");
            return (Criteria) this;
        }

        public Criteria andSendCostIsNotNull() {
            addCriterion("send_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSendCostEqualTo(BigDecimal value) {
            addCriterion("send_cost =", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostNotEqualTo(BigDecimal value) {
            addCriterion("send_cost <>", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostGreaterThan(BigDecimal value) {
            addCriterion("send_cost >", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("send_cost >=", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostLessThan(BigDecimal value) {
            addCriterion("send_cost <", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("send_cost <=", value, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostIn(List<BigDecimal> values) {
            addCriterion("send_cost in", values, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostNotIn(List<BigDecimal> values) {
            addCriterion("send_cost not in", values, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_cost between", value1, value2, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_cost not between", value1, value2, "sendCost");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceIsNull() {
            addCriterion("send_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceIsNotNull() {
            addCriterion("send_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceEqualTo(BigDecimal value) {
            addCriterion("send_cost_price =", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("send_cost_price <>", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceGreaterThan(BigDecimal value) {
            addCriterion("send_cost_price >", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("send_cost_price >=", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceLessThan(BigDecimal value) {
            addCriterion("send_cost_price <", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("send_cost_price <=", value, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceIn(List<BigDecimal> values) {
            addCriterion("send_cost_price in", values, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("send_cost_price not in", values, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_cost_price between", value1, value2, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_cost_price not between", value1, value2, "sendCostPrice");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterIsNull() {
            addCriterion("send_head_trip_cost_after is null");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterIsNotNull() {
            addCriterion("send_head_trip_cost_after is not null");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterEqualTo(BigDecimal value) {
            addCriterion("send_head_trip_cost_after =", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterNotEqualTo(BigDecimal value) {
            addCriterion("send_head_trip_cost_after <>", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterGreaterThan(BigDecimal value) {
            addCriterion("send_head_trip_cost_after >", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("send_head_trip_cost_after >=", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterLessThan(BigDecimal value) {
            addCriterion("send_head_trip_cost_after <", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("send_head_trip_cost_after <=", value, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterIn(List<BigDecimal> values) {
            addCriterion("send_head_trip_cost_after in", values, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterNotIn(List<BigDecimal> values) {
            addCriterion("send_head_trip_cost_after not in", values, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_head_trip_cost_after between", value1, value2, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSendHeadTripCostAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("send_head_trip_cost_after not between", value1, value2, "sendHeadTripCostAfter");
            return (Criteria) this;
        }

        public Criteria andSaleCostIsNull() {
            addCriterion("sale_cost is null");
            return (Criteria) this;
        }

        public Criteria andSaleCostIsNotNull() {
            addCriterion("sale_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCostEqualTo(BigDecimal value) {
            addCriterion("sale_cost =", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotEqualTo(BigDecimal value) {
            addCriterion("sale_cost <>", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostGreaterThan(BigDecimal value) {
            addCriterion("sale_cost >", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_cost >=", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostLessThan(BigDecimal value) {
            addCriterion("sale_cost <", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_cost <=", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostIn(List<BigDecimal> values) {
            addCriterion("sale_cost in", values, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotIn(List<BigDecimal> values) {
            addCriterion("sale_cost not in", values, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_cost between", value1, value2, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_cost not between", value1, value2, "saleCost");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeIsNull() {
            addCriterion("main_business_income is null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeIsNotNull() {
            addCriterion("main_business_income is not null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeEqualTo(BigDecimal value) {
            addCriterion("main_business_income =", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeNotEqualTo(BigDecimal value) {
            addCriterion("main_business_income <>", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeGreaterThan(BigDecimal value) {
            addCriterion("main_business_income >", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("main_business_income >=", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeLessThan(BigDecimal value) {
            addCriterion("main_business_income <", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("main_business_income <=", value, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeIn(List<BigDecimal> values) {
            addCriterion("main_business_income in", values, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeNotIn(List<BigDecimal> values) {
            addCriterion("main_business_income not in", values, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("main_business_income between", value1, value2, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("main_business_income not between", value1, value2, "mainBusinessIncome");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentIsNull() {
            addCriterion("manual_adjustment is null");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentIsNotNull() {
            addCriterion("manual_adjustment is not null");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentEqualTo(BigDecimal value) {
            addCriterion("manual_adjustment =", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotEqualTo(BigDecimal value) {
            addCriterion("manual_adjustment <>", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentGreaterThan(BigDecimal value) {
            addCriterion("manual_adjustment >", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manual_adjustment >=", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentLessThan(BigDecimal value) {
            addCriterion("manual_adjustment <", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manual_adjustment <=", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentIn(List<BigDecimal> values) {
            addCriterion("manual_adjustment in", values, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotIn(List<BigDecimal> values) {
            addCriterion("manual_adjustment not in", values, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manual_adjustment between", value1, value2, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manual_adjustment not between", value1, value2, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNull() {
            addCriterion("net_income is null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNotNull() {
            addCriterion("net_income is not null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeEqualTo(BigDecimal value) {
            addCriterion("net_income =", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotEqualTo(BigDecimal value) {
            addCriterion("net_income <>", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThan(BigDecimal value) {
            addCriterion("net_income >", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_income >=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThan(BigDecimal value) {
            addCriterion("net_income <", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_income <=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIn(List<BigDecimal> values) {
            addCriterion("net_income in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotIn(List<BigDecimal> values) {
            addCriterion("net_income not in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_income between", value1, value2, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_income not between", value1, value2, "netIncome");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitIsNull() {
            addCriterion("main_business_profit is null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitIsNotNull() {
            addCriterion("main_business_profit is not null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitEqualTo(BigDecimal value) {
            addCriterion("main_business_profit =", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitNotEqualTo(BigDecimal value) {
            addCriterion("main_business_profit <>", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitGreaterThan(BigDecimal value) {
            addCriterion("main_business_profit >", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("main_business_profit >=", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitLessThan(BigDecimal value) {
            addCriterion("main_business_profit <", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("main_business_profit <=", value, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitIn(List<BigDecimal> values) {
            addCriterion("main_business_profit in", values, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitNotIn(List<BigDecimal> values) {
            addCriterion("main_business_profit not in", values, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("main_business_profit between", value1, value2, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andMainBusinessProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("main_business_profit not between", value1, value2, "mainBusinessProfit");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityIsNull() {
            addCriterion("sale_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityIsNotNull() {
            addCriterion("sale_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityEqualTo(Integer value) {
            addCriterion("sale_quantity =", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityNotEqualTo(Integer value) {
            addCriterion("sale_quantity <>", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityGreaterThan(Integer value) {
            addCriterion("sale_quantity >", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_quantity >=", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityLessThan(Integer value) {
            addCriterion("sale_quantity <", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("sale_quantity <=", value, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityIn(List<Integer> values) {
            addCriterion("sale_quantity in", values, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityNotIn(List<Integer> values) {
            addCriterion("sale_quantity not in", values, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityBetween(Integer value1, Integer value2) {
            addCriterion("sale_quantity between", value1, value2, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andSaleQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_quantity not between", value1, value2, "saleQuantity");
            return (Criteria) this;
        }

        public Criteria andProductSalesIsNull() {
            addCriterion("product_sales is null");
            return (Criteria) this;
        }

        public Criteria andProductSalesIsNotNull() {
            addCriterion("product_sales is not null");
            return (Criteria) this;
        }

        public Criteria andProductSalesEqualTo(BigDecimal value) {
            addCriterion("product_sales =", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotEqualTo(BigDecimal value) {
            addCriterion("product_sales <>", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesGreaterThan(BigDecimal value) {
            addCriterion("product_sales >", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales >=", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesLessThan(BigDecimal value) {
            addCriterion("product_sales <", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales <=", value, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesIn(List<BigDecimal> values) {
            addCriterion("product_sales in", values, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotIn(List<BigDecimal> values) {
            addCriterion("product_sales not in", values, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales between", value1, value2, "productSales");
            return (Criteria) this;
        }

        public Criteria andProductSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales not between", value1, value2, "productSales");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateIsNull() {
            addCriterion("money_back_rate is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateIsNotNull() {
            addCriterion("money_back_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateEqualTo(BigDecimal value) {
            addCriterion("money_back_rate =", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateNotEqualTo(BigDecimal value) {
            addCriterion("money_back_rate <>", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateGreaterThan(BigDecimal value) {
            addCriterion("money_back_rate >", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_back_rate >=", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateLessThan(BigDecimal value) {
            addCriterion("money_back_rate <", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_back_rate <=", value, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateIn(List<BigDecimal> values) {
            addCriterion("money_back_rate in", values, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateNotIn(List<BigDecimal> values) {
            addCriterion("money_back_rate not in", values, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_back_rate between", value1, value2, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBackRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_back_rate not between", value1, value2, "moneyBackRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNull() {
            addCriterion("refund_rate is null");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNotNull() {
            addCriterion("refund_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRateEqualTo(BigDecimal value) {
            addCriterion("refund_rate =", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotEqualTo(BigDecimal value) {
            addCriterion("refund_rate <>", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThan(BigDecimal value) {
            addCriterion("refund_rate >", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_rate >=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThan(BigDecimal value) {
            addCriterion("refund_rate <", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_rate <=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateIn(List<BigDecimal> values) {
            addCriterion("refund_rate in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotIn(List<BigDecimal> values) {
            addCriterion("refund_rate not in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_rate between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_rate not between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageIsNull() {
            addCriterion("advertising_sales_percentage is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageIsNotNull() {
            addCriterion("advertising_sales_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageEqualTo(BigDecimal value) {
            addCriterion("advertising_sales_percentage =", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageNotEqualTo(BigDecimal value) {
            addCriterion("advertising_sales_percentage <>", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageGreaterThan(BigDecimal value) {
            addCriterion("advertising_sales_percentage >", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("advertising_sales_percentage >=", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageLessThan(BigDecimal value) {
            addCriterion("advertising_sales_percentage <", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("advertising_sales_percentage <=", value, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageIn(List<BigDecimal> values) {
            addCriterion("advertising_sales_percentage in", values, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageNotIn(List<BigDecimal> values) {
            addCriterion("advertising_sales_percentage not in", values, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advertising_sales_percentage between", value1, value2, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andAdvertisingSalesPercentageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advertising_sales_percentage not between", value1, value2, "advertisingSalesPercentage");
            return (Criteria) this;
        }

        public Criteria andRoiIsNull() {
            addCriterion("roi is null");
            return (Criteria) this;
        }

        public Criteria andRoiIsNotNull() {
            addCriterion("roi is not null");
            return (Criteria) this;
        }

        public Criteria andRoiEqualTo(BigDecimal value) {
            addCriterion("roi =", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiNotEqualTo(BigDecimal value) {
            addCriterion("roi <>", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiGreaterThan(BigDecimal value) {
            addCriterion("roi >", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("roi >=", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiLessThan(BigDecimal value) {
            addCriterion("roi <", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("roi <=", value, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiIn(List<BigDecimal> values) {
            addCriterion("roi in", values, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiNotIn(List<BigDecimal> values) {
            addCriterion("roi not in", values, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("roi between", value1, value2, "roi");
            return (Criteria) this;
        }

        public Criteria andRoiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("roi not between", value1, value2, "roi");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverIsNull() {
            addCriterion("inventory_turnover is null");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverIsNotNull() {
            addCriterion("inventory_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverEqualTo(BigDecimal value) {
            addCriterion("inventory_turnover =", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverNotEqualTo(BigDecimal value) {
            addCriterion("inventory_turnover <>", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverGreaterThan(BigDecimal value) {
            addCriterion("inventory_turnover >", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inventory_turnover >=", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverLessThan(BigDecimal value) {
            addCriterion("inventory_turnover <", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inventory_turnover <=", value, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverIn(List<BigDecimal> values) {
            addCriterion("inventory_turnover in", values, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverNotIn(List<BigDecimal> values) {
            addCriterion("inventory_turnover not in", values, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inventory_turnover between", value1, value2, "inventoryTurnover");
            return (Criteria) this;
        }

        public Criteria andInventoryTurnoverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inventory_turnover not between", value1, value2, "inventoryTurnover");
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