package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopSkuExample() {
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

        public Criteria andShopSkuIsNull() {
            addCriterion("shop_sku is null");
            return (Criteria) this;
        }

        public Criteria andShopSkuIsNotNull() {
            addCriterion("shop_sku is not null");
            return (Criteria) this;
        }

        public Criteria andShopSkuEqualTo(String value) {
            addCriterion("shop_sku =", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuNotEqualTo(String value) {
            addCriterion("shop_sku <>", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuGreaterThan(String value) {
            addCriterion("shop_sku >", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuGreaterThanOrEqualTo(String value) {
            addCriterion("shop_sku >=", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuLessThan(String value) {
            addCriterion("shop_sku <", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuLessThanOrEqualTo(String value) {
            addCriterion("shop_sku <=", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuLike(String value) {
            addCriterion("shop_sku like", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuNotLike(String value) {
            addCriterion("shop_sku not like", value, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuIn(List<String> values) {
            addCriterion("shop_sku in", values, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuNotIn(List<String> values) {
            addCriterion("shop_sku not in", values, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuBetween(String value1, String value2) {
            addCriterion("shop_sku between", value1, value2, "shopSku");
            return (Criteria) this;
        }

        public Criteria andShopSkuNotBetween(String value1, String value2) {
            addCriterion("shop_sku not between", value1, value2, "shopSku");
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

        public Criteria andSalesmanUserIdIsNull() {
            addCriterion("salesman_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdIsNotNull() {
            addCriterion("salesman_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdEqualTo(Integer value) {
            addCriterion("salesman_user_id =", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdNotEqualTo(Integer value) {
            addCriterion("salesman_user_id <>", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdGreaterThan(Integer value) {
            addCriterion("salesman_user_id >", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesman_user_id >=", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdLessThan(Integer value) {
            addCriterion("salesman_user_id <", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("salesman_user_id <=", value, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdIn(List<Integer> values) {
            addCriterion("salesman_user_id in", values, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdNotIn(List<Integer> values) {
            addCriterion("salesman_user_id not in", values, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdBetween(Integer value1, Integer value2) {
            addCriterion("salesman_user_id between", value1, value2, "salesmanUserId");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("salesman_user_id not between", value1, value2, "salesmanUserId");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andStorageLocationIsNull() {
            addCriterion("storage_location is null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationIsNotNull() {
            addCriterion("storage_location is not null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationEqualTo(String value) {
            addCriterion("storage_location =", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotEqualTo(String value) {
            addCriterion("storage_location <>", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationGreaterThan(String value) {
            addCriterion("storage_location >", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationGreaterThanOrEqualTo(String value) {
            addCriterion("storage_location >=", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationLessThan(String value) {
            addCriterion("storage_location <", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationLessThanOrEqualTo(String value) {
            addCriterion("storage_location <=", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationLike(String value) {
            addCriterion("storage_location like", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotLike(String value) {
            addCriterion("storage_location not like", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationIn(List<String> values) {
            addCriterion("storage_location in", values, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotIn(List<String> values) {
            addCriterion("storage_location not in", values, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBetween(String value1, String value2) {
            addCriterion("storage_location between", value1, value2, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotBetween(String value1, String value2) {
            addCriterion("storage_location not between", value1, value2, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIsNull() {
            addCriterion("head_trip_cost is null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIsNotNull() {
            addCriterion("head_trip_cost is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost =", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost <>", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostGreaterThan(BigDecimal value) {
            addCriterion("head_trip_cost >", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost >=", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostLessThan(BigDecimal value) {
            addCriterion("head_trip_cost <", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_trip_cost <=", value, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost in", values, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotIn(List<BigDecimal> values) {
            addCriterion("head_trip_cost not in", values, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost between", value1, value2, "headTripCost");
            return (Criteria) this;
        }

        public Criteria andHeadTripCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_trip_cost not between", value1, value2, "headTripCost");
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

        public Criteria andProduceStatusIsNull() {
            addCriterion("produce_status is null");
            return (Criteria) this;
        }

        public Criteria andProduceStatusIsNotNull() {
            addCriterion("produce_status is not null");
            return (Criteria) this;
        }

        public Criteria andProduceStatusEqualTo(Integer value) {
            addCriterion("produce_status =", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusNotEqualTo(Integer value) {
            addCriterion("produce_status <>", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusGreaterThan(Integer value) {
            addCriterion("produce_status >", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("produce_status >=", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusLessThan(Integer value) {
            addCriterion("produce_status <", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("produce_status <=", value, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusIn(List<Integer> values) {
            addCriterion("produce_status in", values, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusNotIn(List<Integer> values) {
            addCriterion("produce_status not in", values, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusBetween(Integer value1, Integer value2) {
            addCriterion("produce_status between", value1, value2, "produceStatus");
            return (Criteria) this;
        }

        public Criteria andProduceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("produce_status not between", value1, value2, "produceStatus");
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

        public Criteria andShopParentSkuIsNull() {
            addCriterion("shop_parent_sku is null");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuIsNotNull() {
            addCriterion("shop_parent_sku is not null");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuEqualTo(String value) {
            addCriterion("shop_parent_sku =", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuNotEqualTo(String value) {
            addCriterion("shop_parent_sku <>", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuGreaterThan(String value) {
            addCriterion("shop_parent_sku >", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuGreaterThanOrEqualTo(String value) {
            addCriterion("shop_parent_sku >=", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuLessThan(String value) {
            addCriterion("shop_parent_sku <", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuLessThanOrEqualTo(String value) {
            addCriterion("shop_parent_sku <=", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuLike(String value) {
            addCriterion("shop_parent_sku like", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuNotLike(String value) {
            addCriterion("shop_parent_sku not like", value, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuIn(List<String> values) {
            addCriterion("shop_parent_sku in", values, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuNotIn(List<String> values) {
            addCriterion("shop_parent_sku not in", values, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuBetween(String value1, String value2) {
            addCriterion("shop_parent_sku between", value1, value2, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andShopParentSkuNotBetween(String value1, String value2) {
            addCriterion("shop_parent_sku not between", value1, value2, "shopParentSku");
            return (Criteria) this;
        }

        public Criteria andParentAsinIsNull() {
            addCriterion("parent_asin is null");
            return (Criteria) this;
        }

        public Criteria andParentAsinIsNotNull() {
            addCriterion("parent_asin is not null");
            return (Criteria) this;
        }

        public Criteria andParentAsinEqualTo(String value) {
            addCriterion("parent_asin =", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinNotEqualTo(String value) {
            addCriterion("parent_asin <>", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinGreaterThan(String value) {
            addCriterion("parent_asin >", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinGreaterThanOrEqualTo(String value) {
            addCriterion("parent_asin >=", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinLessThan(String value) {
            addCriterion("parent_asin <", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinLessThanOrEqualTo(String value) {
            addCriterion("parent_asin <=", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinLike(String value) {
            addCriterion("parent_asin like", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinNotLike(String value) {
            addCriterion("parent_asin not like", value, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinIn(List<String> values) {
            addCriterion("parent_asin in", values, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinNotIn(List<String> values) {
            addCriterion("parent_asin not in", values, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinBetween(String value1, String value2) {
            addCriterion("parent_asin between", value1, value2, "parentAsin");
            return (Criteria) this;
        }

        public Criteria andParentAsinNotBetween(String value1, String value2) {
            addCriterion("parent_asin not between", value1, value2, "parentAsin");
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