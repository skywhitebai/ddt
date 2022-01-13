package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceExample() {
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

        public Criteria andMonthlySalesIsNull() {
            addCriterion("monthly_sales is null");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesIsNotNull() {
            addCriterion("monthly_sales is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesEqualTo(Boolean value) {
            addCriterion("monthly_sales =", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesNotEqualTo(Boolean value) {
            addCriterion("monthly_sales <>", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesGreaterThan(Boolean value) {
            addCriterion("monthly_sales >", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("monthly_sales >=", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesLessThan(Boolean value) {
            addCriterion("monthly_sales <", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesLessThanOrEqualTo(Boolean value) {
            addCriterion("monthly_sales <=", value, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesIn(List<Boolean> values) {
            addCriterion("monthly_sales in", values, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesNotIn(List<Boolean> values) {
            addCriterion("monthly_sales not in", values, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_sales between", value1, value2, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andMonthlySalesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_sales not between", value1, value2, "monthlySales");
            return (Criteria) this;
        }

        public Criteria andLightingDealIsNull() {
            addCriterion("lighting_deal is null");
            return (Criteria) this;
        }

        public Criteria andLightingDealIsNotNull() {
            addCriterion("lighting_deal is not null");
            return (Criteria) this;
        }

        public Criteria andLightingDealEqualTo(Boolean value) {
            addCriterion("lighting_deal =", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealNotEqualTo(Boolean value) {
            addCriterion("lighting_deal <>", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealGreaterThan(Boolean value) {
            addCriterion("lighting_deal >", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealGreaterThanOrEqualTo(Boolean value) {
            addCriterion("lighting_deal >=", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealLessThan(Boolean value) {
            addCriterion("lighting_deal <", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealLessThanOrEqualTo(Boolean value) {
            addCriterion("lighting_deal <=", value, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealIn(List<Boolean> values) {
            addCriterion("lighting_deal in", values, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealNotIn(List<Boolean> values) {
            addCriterion("lighting_deal not in", values, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealBetween(Boolean value1, Boolean value2) {
            addCriterion("lighting_deal between", value1, value2, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andLightingDealNotBetween(Boolean value1, Boolean value2) {
            addCriterion("lighting_deal not between", value1, value2, "lightingDeal");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeIsNull() {
            addCriterion("monthly_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeIsNotNull() {
            addCriterion("monthly_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeEqualTo(Boolean value) {
            addCriterion("monthly_storage_fee =", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeNotEqualTo(Boolean value) {
            addCriterion("monthly_storage_fee <>", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeGreaterThan(Boolean value) {
            addCriterion("monthly_storage_fee >", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("monthly_storage_fee >=", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeLessThan(Boolean value) {
            addCriterion("monthly_storage_fee <", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("monthly_storage_fee <=", value, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeIn(List<Boolean> values) {
            addCriterion("monthly_storage_fee in", values, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeNotIn(List<Boolean> values) {
            addCriterion("monthly_storage_fee not in", values, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_storage_fee between", value1, value2, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyStorageFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_storage_fee not between", value1, value2, "monthlyStorageFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeIsNull() {
            addCriterion("monthly_advertising_fee is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeIsNotNull() {
            addCriterion("monthly_advertising_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeEqualTo(Boolean value) {
            addCriterion("monthly_advertising_fee =", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeNotEqualTo(Boolean value) {
            addCriterion("monthly_advertising_fee <>", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeGreaterThan(Boolean value) {
            addCriterion("monthly_advertising_fee >", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("monthly_advertising_fee >=", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeLessThan(Boolean value) {
            addCriterion("monthly_advertising_fee <", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("monthly_advertising_fee <=", value, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeIn(List<Boolean> values) {
            addCriterion("monthly_advertising_fee in", values, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeNotIn(List<Boolean> values) {
            addCriterion("monthly_advertising_fee not in", values, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_advertising_fee between", value1, value2, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyAdvertisingFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("monthly_advertising_fee not between", value1, value2, "monthlyAdvertisingFee");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingIsNull() {
            addCriterion("display_advertising is null");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingIsNotNull() {
            addCriterion("display_advertising is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingEqualTo(Boolean value) {
            addCriterion("display_advertising =", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotEqualTo(Boolean value) {
            addCriterion("display_advertising <>", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingGreaterThan(Boolean value) {
            addCriterion("display_advertising >", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display_advertising >=", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingLessThan(Boolean value) {
            addCriterion("display_advertising <", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingLessThanOrEqualTo(Boolean value) {
            addCriterion("display_advertising <=", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingIn(List<Boolean> values) {
            addCriterion("display_advertising in", values, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotIn(List<Boolean> values) {
            addCriterion("display_advertising not in", values, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingBetween(Boolean value1, Boolean value2) {
            addCriterion("display_advertising between", value1, value2, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display_advertising not between", value1, value2, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingIsNull() {
            addCriterion("brand_advertising is null");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingIsNotNull() {
            addCriterion("brand_advertising is not null");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingEqualTo(Boolean value) {
            addCriterion("brand_advertising =", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotEqualTo(Boolean value) {
            addCriterion("brand_advertising <>", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingGreaterThan(Boolean value) {
            addCriterion("brand_advertising >", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("brand_advertising >=", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingLessThan(Boolean value) {
            addCriterion("brand_advertising <", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingLessThanOrEqualTo(Boolean value) {
            addCriterion("brand_advertising <=", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingIn(List<Boolean> values) {
            addCriterion("brand_advertising in", values, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotIn(List<Boolean> values) {
            addCriterion("brand_advertising not in", values, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingBetween(Boolean value1, Boolean value2) {
            addCriterion("brand_advertising between", value1, value2, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("brand_advertising not between", value1, value2, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersIsNull() {
            addCriterion("remove_orders is null");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersIsNotNull() {
            addCriterion("remove_orders is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersEqualTo(Boolean value) {
            addCriterion("remove_orders =", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersNotEqualTo(Boolean value) {
            addCriterion("remove_orders <>", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersGreaterThan(Boolean value) {
            addCriterion("remove_orders >", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersGreaterThanOrEqualTo(Boolean value) {
            addCriterion("remove_orders >=", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersLessThan(Boolean value) {
            addCriterion("remove_orders <", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersLessThanOrEqualTo(Boolean value) {
            addCriterion("remove_orders <=", value, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersIn(List<Boolean> values) {
            addCriterion("remove_orders in", values, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersNotIn(List<Boolean> values) {
            addCriterion("remove_orders not in", values, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersBetween(Boolean value1, Boolean value2) {
            addCriterion("remove_orders between", value1, value2, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andRemoveOrdersNotBetween(Boolean value1, Boolean value2) {
            addCriterion("remove_orders not between", value1, value2, "removeOrders");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeIsNull() {
            addCriterion("destruction_fee is null");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeIsNotNull() {
            addCriterion("destruction_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeEqualTo(Boolean value) {
            addCriterion("destruction_fee =", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeNotEqualTo(Boolean value) {
            addCriterion("destruction_fee <>", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeGreaterThan(Boolean value) {
            addCriterion("destruction_fee >", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("destruction_fee >=", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeLessThan(Boolean value) {
            addCriterion("destruction_fee <", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("destruction_fee <=", value, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeIn(List<Boolean> values) {
            addCriterion("destruction_fee in", values, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeNotIn(List<Boolean> values) {
            addCriterion("destruction_fee not in", values, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("destruction_fee between", value1, value2, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("destruction_fee not between", value1, value2, "destructionFee");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsIsNull() {
            addCriterion("destruction_details is null");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsIsNotNull() {
            addCriterion("destruction_details is not null");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsEqualTo(Boolean value) {
            addCriterion("destruction_details =", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsNotEqualTo(Boolean value) {
            addCriterion("destruction_details <>", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsGreaterThan(Boolean value) {
            addCriterion("destruction_details >", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("destruction_details >=", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsLessThan(Boolean value) {
            addCriterion("destruction_details <", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsLessThanOrEqualTo(Boolean value) {
            addCriterion("destruction_details <=", value, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsIn(List<Boolean> values) {
            addCriterion("destruction_details in", values, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsNotIn(List<Boolean> values) {
            addCriterion("destruction_details not in", values, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsBetween(Boolean value1, Boolean value2) {
            addCriterion("destruction_details between", value1, value2, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andDestructionDetailsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("destruction_details not between", value1, value2, "destructionDetails");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeIsNull() {
            addCriterion("fba_customer_return_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeIsNotNull() {
            addCriterion("fba_customer_return_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeEqualTo(Boolean value) {
            addCriterion("fba_customer_return_fee =", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeNotEqualTo(Boolean value) {
            addCriterion("fba_customer_return_fee <>", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeGreaterThan(Boolean value) {
            addCriterion("fba_customer_return_fee >", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fba_customer_return_fee >=", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeLessThan(Boolean value) {
            addCriterion("fba_customer_return_fee <", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("fba_customer_return_fee <=", value, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeIn(List<Boolean> values) {
            addCriterion("fba_customer_return_fee in", values, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeNotIn(List<Boolean> values) {
            addCriterion("fba_customer_return_fee not in", values, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("fba_customer_return_fee between", value1, value2, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fba_customer_return_fee not between", value1, value2, "fbaCustomerReturnFee");
            return (Criteria) this;
        }

        public Criteria andCouponIsNull() {
            addCriterion("coupon is null");
            return (Criteria) this;
        }

        public Criteria andCouponIsNotNull() {
            addCriterion("coupon is not null");
            return (Criteria) this;
        }

        public Criteria andCouponEqualTo(Boolean value) {
            addCriterion("coupon =", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotEqualTo(Boolean value) {
            addCriterion("coupon <>", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponGreaterThan(Boolean value) {
            addCriterion("coupon >", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponGreaterThanOrEqualTo(Boolean value) {
            addCriterion("coupon >=", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponLessThan(Boolean value) {
            addCriterion("coupon <", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponLessThanOrEqualTo(Boolean value) {
            addCriterion("coupon <=", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponIn(List<Boolean> values) {
            addCriterion("coupon in", values, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotIn(List<Boolean> values) {
            addCriterion("coupon not in", values, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponBetween(Boolean value1, Boolean value2) {
            addCriterion("coupon between", value1, value2, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotBetween(Boolean value1, Boolean value2) {
            addCriterion("coupon not between", value1, value2, "coupon");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeIsNull() {
            addCriterion("early_reviewer_program_fee is null");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeIsNotNull() {
            addCriterion("early_reviewer_program_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeEqualTo(Boolean value) {
            addCriterion("early_reviewer_program_fee =", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotEqualTo(Boolean value) {
            addCriterion("early_reviewer_program_fee <>", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeGreaterThan(Boolean value) {
            addCriterion("early_reviewer_program_fee >", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("early_reviewer_program_fee >=", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeLessThan(Boolean value) {
            addCriterion("early_reviewer_program_fee <", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("early_reviewer_program_fee <=", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeIn(List<Boolean> values) {
            addCriterion("early_reviewer_program_fee in", values, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotIn(List<Boolean> values) {
            addCriterion("early_reviewer_program_fee not in", values, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("early_reviewer_program_fee between", value1, value2, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("early_reviewer_program_fee not between", value1, value2, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeIsNull() {
            addCriterion("long_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeIsNotNull() {
            addCriterion("long_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeEqualTo(Boolean value) {
            addCriterion("long_storage_fee =", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeNotEqualTo(Boolean value) {
            addCriterion("long_storage_fee <>", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeGreaterThan(Boolean value) {
            addCriterion("long_storage_fee >", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("long_storage_fee >=", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeLessThan(Boolean value) {
            addCriterion("long_storage_fee <", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("long_storage_fee <=", value, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeIn(List<Boolean> values) {
            addCriterion("long_storage_fee in", values, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeNotIn(List<Boolean> values) {
            addCriterion("long_storage_fee not in", values, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("long_storage_fee between", value1, value2, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andLongStorageFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("long_storage_fee not between", value1, value2, "longStorageFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeIsNull() {
            addCriterion("refund_operation_fee is null");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeIsNotNull() {
            addCriterion("refund_operation_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeEqualTo(Boolean value) {
            addCriterion("refund_operation_fee =", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeNotEqualTo(Boolean value) {
            addCriterion("refund_operation_fee <>", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeGreaterThan(Boolean value) {
            addCriterion("refund_operation_fee >", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("refund_operation_fee >=", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeLessThan(Boolean value) {
            addCriterion("refund_operation_fee <", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("refund_operation_fee <=", value, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeIn(List<Boolean> values) {
            addCriterion("refund_operation_fee in", values, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeNotIn(List<Boolean> values) {
            addCriterion("refund_operation_fee not in", values, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("refund_operation_fee between", value1, value2, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andRefundOperationFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("refund_operation_fee not between", value1, value2, "refundOperationFee");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsIsNull() {
            addCriterion("inventory_details is null");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsIsNotNull() {
            addCriterion("inventory_details is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsEqualTo(Boolean value) {
            addCriterion("inventory_details =", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsNotEqualTo(Boolean value) {
            addCriterion("inventory_details <>", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsGreaterThan(Boolean value) {
            addCriterion("inventory_details >", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inventory_details >=", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsLessThan(Boolean value) {
            addCriterion("inventory_details <", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsLessThanOrEqualTo(Boolean value) {
            addCriterion("inventory_details <=", value, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsIn(List<Boolean> values) {
            addCriterion("inventory_details in", values, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsNotIn(List<Boolean> values) {
            addCriterion("inventory_details not in", values, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsBetween(Boolean value1, Boolean value2) {
            addCriterion("inventory_details between", value1, value2, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andInventoryDetailsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inventory_details not between", value1, value2, "inventoryDetails");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionIsNull() {
            addCriterion("head_deduction is null");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionIsNotNull() {
            addCriterion("head_deduction is not null");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionEqualTo(Boolean value) {
            addCriterion("head_deduction =", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionNotEqualTo(Boolean value) {
            addCriterion("head_deduction <>", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionGreaterThan(Boolean value) {
            addCriterion("head_deduction >", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("head_deduction >=", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionLessThan(Boolean value) {
            addCriterion("head_deduction <", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionLessThanOrEqualTo(Boolean value) {
            addCriterion("head_deduction <=", value, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionIn(List<Boolean> values) {
            addCriterion("head_deduction in", values, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionNotIn(List<Boolean> values) {
            addCriterion("head_deduction not in", values, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionBetween(Boolean value1, Boolean value2) {
            addCriterion("head_deduction between", value1, value2, "headDeduction");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("head_deduction not between", value1, value2, "headDeduction");
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

        public Criteria andManualAdjustmentEqualTo(Boolean value) {
            addCriterion("manual_adjustment =", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotEqualTo(Boolean value) {
            addCriterion("manual_adjustment <>", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentGreaterThan(Boolean value) {
            addCriterion("manual_adjustment >", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("manual_adjustment >=", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentLessThan(Boolean value) {
            addCriterion("manual_adjustment <", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentLessThanOrEqualTo(Boolean value) {
            addCriterion("manual_adjustment <=", value, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentIn(List<Boolean> values) {
            addCriterion("manual_adjustment in", values, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotIn(List<Boolean> values) {
            addCriterion("manual_adjustment not in", values, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentBetween(Boolean value1, Boolean value2) {
            addCriterion("manual_adjustment between", value1, value2, "manualAdjustment");
            return (Criteria) this;
        }

        public Criteria andManualAdjustmentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("manual_adjustment not between", value1, value2, "manualAdjustment");
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

        public Criteria andRateOfDollarExchangeRmbIsNull() {
            addCriterion("rate_of_dollar_exchange_rmb is null");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbIsNotNull() {
            addCriterion("rate_of_dollar_exchange_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbEqualTo(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb =", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbNotEqualTo(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb <>", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbGreaterThan(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb >", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb >=", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbLessThan(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb <", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_of_dollar_exchange_rmb <=", value, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbIn(List<BigDecimal> values) {
            addCriterion("rate_of_dollar_exchange_rmb in", values, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbNotIn(List<BigDecimal> values) {
            addCriterion("rate_of_dollar_exchange_rmb not in", values, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_of_dollar_exchange_rmb between", value1, value2, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andRateOfDollarExchangeRmbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_of_dollar_exchange_rmb not between", value1, value2, "rateOfDollarExchangeRmb");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusIsNull() {
            addCriterion("statistic_status is null");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusIsNotNull() {
            addCriterion("statistic_status is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusEqualTo(Integer value) {
            addCriterion("statistic_status =", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusNotEqualTo(Integer value) {
            addCriterion("statistic_status <>", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusGreaterThan(Integer value) {
            addCriterion("statistic_status >", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistic_status >=", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusLessThan(Integer value) {
            addCriterion("statistic_status <", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusLessThanOrEqualTo(Integer value) {
            addCriterion("statistic_status <=", value, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusIn(List<Integer> values) {
            addCriterion("statistic_status in", values, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusNotIn(List<Integer> values) {
            addCriterion("statistic_status not in", values, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusBetween(Integer value1, Integer value2) {
            addCriterion("statistic_status between", value1, value2, "statisticStatus");
            return (Criteria) this;
        }

        public Criteria andStatisticStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("statistic_status not between", value1, value2, "statisticStatus");
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