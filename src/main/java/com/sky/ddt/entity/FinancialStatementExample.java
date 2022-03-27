package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancialStatementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialStatementExample() {
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

        public Criteria andDeveloperUserIdIsNull() {
            addCriterion("developer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdIsNotNull() {
            addCriterion("developer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdEqualTo(Integer value) {
            addCriterion("developer_user_id =", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdNotEqualTo(Integer value) {
            addCriterion("developer_user_id <>", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdGreaterThan(Integer value) {
            addCriterion("developer_user_id >", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("developer_user_id >=", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdLessThan(Integer value) {
            addCriterion("developer_user_id <", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("developer_user_id <=", value, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdIn(List<Integer> values) {
            addCriterion("developer_user_id in", values, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdNotIn(List<Integer> values) {
            addCriterion("developer_user_id not in", values, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdBetween(Integer value1, Integer value2) {
            addCriterion("developer_user_id between", value1, value2, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("developer_user_id not between", value1, value2, "developerUserId");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameIsNull() {
            addCriterion("developer_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameIsNotNull() {
            addCriterion("developer_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameEqualTo(String value) {
            addCriterion("developer_user_name =", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameNotEqualTo(String value) {
            addCriterion("developer_user_name <>", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameGreaterThan(String value) {
            addCriterion("developer_user_name >", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("developer_user_name >=", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameLessThan(String value) {
            addCriterion("developer_user_name <", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameLessThanOrEqualTo(String value) {
            addCriterion("developer_user_name <=", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameLike(String value) {
            addCriterion("developer_user_name like", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameNotLike(String value) {
            addCriterion("developer_user_name not like", value, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameIn(List<String> values) {
            addCriterion("developer_user_name in", values, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameNotIn(List<String> values) {
            addCriterion("developer_user_name not in", values, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameBetween(String value1, String value2) {
            addCriterion("developer_user_name between", value1, value2, "developerUserName");
            return (Criteria) this;
        }

        public Criteria andDeveloperUserNameNotBetween(String value1, String value2) {
            addCriterion("developer_user_name not between", value1, value2, "developerUserName");
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

        public Criteria andSalesmanUserNameIsNull() {
            addCriterion("salesman_user_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameIsNotNull() {
            addCriterion("salesman_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameEqualTo(String value) {
            addCriterion("salesman_user_name =", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameNotEqualTo(String value) {
            addCriterion("salesman_user_name <>", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameGreaterThan(String value) {
            addCriterion("salesman_user_name >", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_user_name >=", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameLessThan(String value) {
            addCriterion("salesman_user_name <", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameLessThanOrEqualTo(String value) {
            addCriterion("salesman_user_name <=", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameLike(String value) {
            addCriterion("salesman_user_name like", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameNotLike(String value) {
            addCriterion("salesman_user_name not like", value, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameIn(List<String> values) {
            addCriterion("salesman_user_name in", values, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameNotIn(List<String> values) {
            addCriterion("salesman_user_name not in", values, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameBetween(String value1, String value2) {
            addCriterion("salesman_user_name between", value1, value2, "salesmanUserName");
            return (Criteria) this;
        }

        public Criteria andSalesmanUserNameNotBetween(String value1, String value2) {
            addCriterion("salesman_user_name not between", value1, value2, "salesmanUserName");
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

        public Criteria andSalesGroupIdIsNull() {
            addCriterion("sales_group_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdIsNotNull() {
            addCriterion("sales_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdEqualTo(Integer value) {
            addCriterion("sales_group_id =", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdNotEqualTo(Integer value) {
            addCriterion("sales_group_id <>", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdGreaterThan(Integer value) {
            addCriterion("sales_group_id >", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_group_id >=", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdLessThan(Integer value) {
            addCriterion("sales_group_id <", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("sales_group_id <=", value, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdIn(List<Integer> values) {
            addCriterion("sales_group_id in", values, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdNotIn(List<Integer> values) {
            addCriterion("sales_group_id not in", values, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("sales_group_id between", value1, value2, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_group_id not between", value1, value2, "salesGroupId");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameIsNull() {
            addCriterion("sales_group_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameIsNotNull() {
            addCriterion("sales_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameEqualTo(String value) {
            addCriterion("sales_group_name =", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameNotEqualTo(String value) {
            addCriterion("sales_group_name <>", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameGreaterThan(String value) {
            addCriterion("sales_group_name >", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("sales_group_name >=", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameLessThan(String value) {
            addCriterion("sales_group_name <", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameLessThanOrEqualTo(String value) {
            addCriterion("sales_group_name <=", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameLike(String value) {
            addCriterion("sales_group_name like", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameNotLike(String value) {
            addCriterion("sales_group_name not like", value, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameIn(List<String> values) {
            addCriterion("sales_group_name in", values, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameNotIn(List<String> values) {
            addCriterion("sales_group_name not in", values, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameBetween(String value1, String value2) {
            addCriterion("sales_group_name between", value1, value2, "salesGroupName");
            return (Criteria) this;
        }

        public Criteria andSalesGroupNameNotBetween(String value1, String value2) {
            addCriterion("sales_group_name not between", value1, value2, "salesGroupName");
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

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
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

        public Criteria andProductSalesTaxIsNull() {
            addCriterion("product_sales_tax is null");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxIsNotNull() {
            addCriterion("product_sales_tax is not null");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax =", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax <>", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxGreaterThan(BigDecimal value) {
            addCriterion("product_sales_tax >", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax >=", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxLessThan(BigDecimal value) {
            addCriterion("product_sales_tax <", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sales_tax <=", value, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxIn(List<BigDecimal> values) {
            addCriterion("product_sales_tax in", values, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotIn(List<BigDecimal> values) {
            addCriterion("product_sales_tax not in", values, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales_tax between", value1, value2, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andProductSalesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sales_tax not between", value1, value2, "productSalesTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIsNull() {
            addCriterion("shipping_credits is null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIsNotNull() {
            addCriterion("shipping_credits is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsEqualTo(BigDecimal value) {
            addCriterion("shipping_credits =", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotEqualTo(BigDecimal value) {
            addCriterion("shipping_credits <>", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsGreaterThan(BigDecimal value) {
            addCriterion("shipping_credits >", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits >=", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsLessThan(BigDecimal value) {
            addCriterion("shipping_credits <", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits <=", value, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsIn(List<BigDecimal> values) {
            addCriterion("shipping_credits in", values, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotIn(List<BigDecimal> values) {
            addCriterion("shipping_credits not in", values, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits between", value1, value2, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits not between", value1, value2, "shippingCredits");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIsNull() {
            addCriterion("shipping_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIsNotNull() {
            addCriterion("shipping_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax =", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax <>", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("shipping_credits_tax >", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax >=", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxLessThan(BigDecimal value) {
            addCriterion("shipping_credits_tax <", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_credits_tax <=", value, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("shipping_credits_tax in", values, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("shipping_credits_tax not in", values, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits_tax between", value1, value2, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andShippingCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_credits_tax not between", value1, value2, "shippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIsNull() {
            addCriterion("gift_wrap_credits is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIsNotNull() {
            addCriterion("gift_wrap_credits is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits =", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits <>", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_credits >", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits >=", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsLessThan(BigDecimal value) {
            addCriterion("gift_wrap_credits <", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits <=", value, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits in", values, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits not in", values, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits between", value1, value2, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits not between", value1, value2, "giftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxIsNull() {
            addCriterion("gift_wrap_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxIsNotNull() {
            addCriterion("gift_wrap_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax =", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax <>", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax >", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax >=", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxLessThan(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax <", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gift_wrap_credits_tax <=", value, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits_tax in", values, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("gift_wrap_credits_tax not in", values, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits_tax between", value1, value2, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andGiftWrapCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gift_wrap_credits_tax not between", value1, value2, "giftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIsNull() {
            addCriterion("promotional_rebates is null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIsNotNull() {
            addCriterion("promotional_rebates is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates =", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates <>", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesGreaterThan(BigDecimal value) {
            addCriterion("promotional_rebates >", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates >=", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesLessThan(BigDecimal value) {
            addCriterion("promotional_rebates <", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates <=", value, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates in", values, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates not in", values, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates between", value1, value2, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates not between", value1, value2, "promotionalRebates");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIsNull() {
            addCriterion("promotional_rebates_tax is null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIsNotNull() {
            addCriterion("promotional_rebates_tax is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax =", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax <>", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxGreaterThan(BigDecimal value) {
            addCriterion("promotional_rebates_tax >", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax >=", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxLessThan(BigDecimal value) {
            addCriterion("promotional_rebates_tax <", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_rebates_tax <=", value, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates_tax in", values, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotIn(List<BigDecimal> values) {
            addCriterion("promotional_rebates_tax not in", values, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates_tax between", value1, value2, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andPromotionalRebatesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_rebates_tax not between", value1, value2, "promotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIsNull() {
            addCriterion("marketplace_withheld_tax is null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIsNotNull() {
            addCriterion("marketplace_withheld_tax is not null");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax =", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <>", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxGreaterThan(BigDecimal value) {
            addCriterion("marketplace_withheld_tax >", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax >=", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxLessThan(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("marketplace_withheld_tax <=", value, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxIn(List<BigDecimal> values) {
            addCriterion("marketplace_withheld_tax in", values, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotIn(List<BigDecimal> values) {
            addCriterion("marketplace_withheld_tax not in", values, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketplace_withheld_tax between", value1, value2, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andMarketplaceWithheldTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketplace_withheld_tax not between", value1, value2, "marketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIsNull() {
            addCriterion("selling_fees is null");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIsNotNull() {
            addCriterion("selling_fees is not null");
            return (Criteria) this;
        }

        public Criteria andSellingFeesEqualTo(BigDecimal value) {
            addCriterion("selling_fees =", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotEqualTo(BigDecimal value) {
            addCriterion("selling_fees <>", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesGreaterThan(BigDecimal value) {
            addCriterion("selling_fees >", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("selling_fees >=", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesLessThan(BigDecimal value) {
            addCriterion("selling_fees <", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("selling_fees <=", value, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesIn(List<BigDecimal> values) {
            addCriterion("selling_fees in", values, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotIn(List<BigDecimal> values) {
            addCriterion("selling_fees not in", values, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("selling_fees between", value1, value2, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andSellingFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("selling_fees not between", value1, value2, "sellingFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIsNull() {
            addCriterion("fba_fees is null");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIsNotNull() {
            addCriterion("fba_fees is not null");
            return (Criteria) this;
        }

        public Criteria andFbaFeesEqualTo(BigDecimal value) {
            addCriterion("fba_fees =", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotEqualTo(BigDecimal value) {
            addCriterion("fba_fees <>", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesGreaterThan(BigDecimal value) {
            addCriterion("fba_fees >", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_fees >=", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesLessThan(BigDecimal value) {
            addCriterion("fba_fees <", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_fees <=", value, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesIn(List<BigDecimal> values) {
            addCriterion("fba_fees in", values, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotIn(List<BigDecimal> values) {
            addCriterion("fba_fees not in", values, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_fees between", value1, value2, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andFbaFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_fees not between", value1, value2, "fbaFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIsNull() {
            addCriterion("other_transaction_fees is null");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIsNotNull() {
            addCriterion("other_transaction_fees is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees =", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees <>", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesGreaterThan(BigDecimal value) {
            addCriterion("other_transaction_fees >", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees >=", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesLessThan(BigDecimal value) {
            addCriterion("other_transaction_fees <", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_transaction_fees <=", value, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesIn(List<BigDecimal> values) {
            addCriterion("other_transaction_fees in", values, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotIn(List<BigDecimal> values) {
            addCriterion("other_transaction_fees not in", values, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_transaction_fees between", value1, value2, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherTransactionFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_transaction_fees not between", value1, value2, "otherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(BigDecimal value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(BigDecimal value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(BigDecimal value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(BigDecimal value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<BigDecimal> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<BigDecimal> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityIsNull() {
            addCriterion("refund_sale_quantity is null");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityIsNotNull() {
            addCriterion("refund_sale_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityEqualTo(Integer value) {
            addCriterion("refund_sale_quantity =", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityNotEqualTo(Integer value) {
            addCriterion("refund_sale_quantity <>", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityGreaterThan(Integer value) {
            addCriterion("refund_sale_quantity >", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_sale_quantity >=", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityLessThan(Integer value) {
            addCriterion("refund_sale_quantity <", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("refund_sale_quantity <=", value, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityIn(List<Integer> values) {
            addCriterion("refund_sale_quantity in", values, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityNotIn(List<Integer> values) {
            addCriterion("refund_sale_quantity not in", values, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityBetween(Integer value1, Integer value2) {
            addCriterion("refund_sale_quantity between", value1, value2, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundSaleQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_sale_quantity not between", value1, value2, "refundSaleQuantity");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesIsNull() {
            addCriterion("refund_product_sales is null");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesIsNotNull() {
            addCriterion("refund_product_sales is not null");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales =", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesNotEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales <>", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesGreaterThan(BigDecimal value) {
            addCriterion("refund_product_sales >", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales >=", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesLessThan(BigDecimal value) {
            addCriterion("refund_product_sales <", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales <=", value, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesIn(List<BigDecimal> values) {
            addCriterion("refund_product_sales in", values, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesNotIn(List<BigDecimal> values) {
            addCriterion("refund_product_sales not in", values, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_product_sales between", value1, value2, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_product_sales not between", value1, value2, "refundProductSales");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxIsNull() {
            addCriterion("refund_product_sales_tax is null");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxIsNotNull() {
            addCriterion("refund_product_sales_tax is not null");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales_tax =", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxNotEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales_tax <>", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxGreaterThan(BigDecimal value) {
            addCriterion("refund_product_sales_tax >", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales_tax >=", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxLessThan(BigDecimal value) {
            addCriterion("refund_product_sales_tax <", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_product_sales_tax <=", value, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxIn(List<BigDecimal> values) {
            addCriterion("refund_product_sales_tax in", values, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxNotIn(List<BigDecimal> values) {
            addCriterion("refund_product_sales_tax not in", values, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_product_sales_tax between", value1, value2, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundProductSalesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_product_sales_tax not between", value1, value2, "refundProductSalesTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsIsNull() {
            addCriterion("refund_shipping_credits is null");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsIsNotNull() {
            addCriterion("refund_shipping_credits is not null");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits =", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsNotEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits <>", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsGreaterThan(BigDecimal value) {
            addCriterion("refund_shipping_credits >", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits >=", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsLessThan(BigDecimal value) {
            addCriterion("refund_shipping_credits <", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits <=", value, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsIn(List<BigDecimal> values) {
            addCriterion("refund_shipping_credits in", values, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsNotIn(List<BigDecimal> values) {
            addCriterion("refund_shipping_credits not in", values, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_shipping_credits between", value1, value2, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_shipping_credits not between", value1, value2, "refundShippingCredits");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxIsNull() {
            addCriterion("refund_shipping_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxIsNotNull() {
            addCriterion("refund_shipping_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax =", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax <>", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax >", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax >=", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxLessThan(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax <", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_shipping_credits_tax <=", value, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("refund_shipping_credits_tax in", values, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("refund_shipping_credits_tax not in", values, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_shipping_credits_tax between", value1, value2, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundShippingCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_shipping_credits_tax not between", value1, value2, "refundShippingCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsIsNull() {
            addCriterion("refund_gift_wrap_credits is null");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsIsNotNull() {
            addCriterion("refund_gift_wrap_credits is not null");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits =", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsNotEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits <>", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsGreaterThan(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits >", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits >=", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsLessThan(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits <", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits <=", value, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsIn(List<BigDecimal> values) {
            addCriterion("refund_gift_wrap_credits in", values, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsNotIn(List<BigDecimal> values) {
            addCriterion("refund_gift_wrap_credits not in", values, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_gift_wrap_credits between", value1, value2, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_gift_wrap_credits not between", value1, value2, "refundGiftWrapCredits");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxIsNull() {
            addCriterion("refund_gift_wrap_credits_tax is null");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxIsNotNull() {
            addCriterion("refund_gift_wrap_credits_tax is not null");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax =", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxNotEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax <>", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxGreaterThan(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax >", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax >=", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxLessThan(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax <", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_gift_wrap_credits_tax <=", value, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxIn(List<BigDecimal> values) {
            addCriterion("refund_gift_wrap_credits_tax in", values, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxNotIn(List<BigDecimal> values) {
            addCriterion("refund_gift_wrap_credits_tax not in", values, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_gift_wrap_credits_tax between", value1, value2, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundGiftWrapCreditsTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_gift_wrap_credits_tax not between", value1, value2, "refundGiftWrapCreditsTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesIsNull() {
            addCriterion("refund_promotional_rebates is null");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesIsNotNull() {
            addCriterion("refund_promotional_rebates is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates =", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesNotEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates <>", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesGreaterThan(BigDecimal value) {
            addCriterion("refund_promotional_rebates >", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates >=", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesLessThan(BigDecimal value) {
            addCriterion("refund_promotional_rebates <", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates <=", value, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesIn(List<BigDecimal> values) {
            addCriterion("refund_promotional_rebates in", values, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesNotIn(List<BigDecimal> values) {
            addCriterion("refund_promotional_rebates not in", values, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_promotional_rebates between", value1, value2, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_promotional_rebates not between", value1, value2, "refundPromotionalRebates");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxIsNull() {
            addCriterion("refund_promotional_rebates_tax is null");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxIsNotNull() {
            addCriterion("refund_promotional_rebates_tax is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax =", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxNotEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax <>", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxGreaterThan(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax >", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax >=", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxLessThan(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax <", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_promotional_rebates_tax <=", value, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxIn(List<BigDecimal> values) {
            addCriterion("refund_promotional_rebates_tax in", values, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxNotIn(List<BigDecimal> values) {
            addCriterion("refund_promotional_rebates_tax not in", values, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_promotional_rebates_tax between", value1, value2, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundPromotionalRebatesTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_promotional_rebates_tax not between", value1, value2, "refundPromotionalRebatesTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxIsNull() {
            addCriterion("refund_marketplace_withheld_tax is null");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxIsNotNull() {
            addCriterion("refund_marketplace_withheld_tax is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxEqualTo(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax =", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxNotEqualTo(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax <>", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxGreaterThan(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax >", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax >=", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxLessThan(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax <", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_marketplace_withheld_tax <=", value, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxIn(List<BigDecimal> values) {
            addCriterion("refund_marketplace_withheld_tax in", values, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxNotIn(List<BigDecimal> values) {
            addCriterion("refund_marketplace_withheld_tax not in", values, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_marketplace_withheld_tax between", value1, value2, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundMarketplaceWithheldTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_marketplace_withheld_tax not between", value1, value2, "refundMarketplaceWithheldTax");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesIsNull() {
            addCriterion("refund_selling_fees is null");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesIsNotNull() {
            addCriterion("refund_selling_fees is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesEqualTo(BigDecimal value) {
            addCriterion("refund_selling_fees =", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesNotEqualTo(BigDecimal value) {
            addCriterion("refund_selling_fees <>", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesGreaterThan(BigDecimal value) {
            addCriterion("refund_selling_fees >", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_selling_fees >=", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesLessThan(BigDecimal value) {
            addCriterion("refund_selling_fees <", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_selling_fees <=", value, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesIn(List<BigDecimal> values) {
            addCriterion("refund_selling_fees in", values, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesNotIn(List<BigDecimal> values) {
            addCriterion("refund_selling_fees not in", values, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_selling_fees between", value1, value2, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundSellingFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_selling_fees not between", value1, value2, "refundSellingFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesIsNull() {
            addCriterion("refund_fba_fees is null");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesIsNotNull() {
            addCriterion("refund_fba_fees is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesEqualTo(BigDecimal value) {
            addCriterion("refund_fba_fees =", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesNotEqualTo(BigDecimal value) {
            addCriterion("refund_fba_fees <>", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesGreaterThan(BigDecimal value) {
            addCriterion("refund_fba_fees >", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_fba_fees >=", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesLessThan(BigDecimal value) {
            addCriterion("refund_fba_fees <", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_fba_fees <=", value, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesIn(List<BigDecimal> values) {
            addCriterion("refund_fba_fees in", values, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesNotIn(List<BigDecimal> values) {
            addCriterion("refund_fba_fees not in", values, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_fba_fees between", value1, value2, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundFbaFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_fba_fees not between", value1, value2, "refundFbaFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesIsNull() {
            addCriterion("refund_other_transaction_fees is null");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesIsNotNull() {
            addCriterion("refund_other_transaction_fees is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesEqualTo(BigDecimal value) {
            addCriterion("refund_other_transaction_fees =", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesNotEqualTo(BigDecimal value) {
            addCriterion("refund_other_transaction_fees <>", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesGreaterThan(BigDecimal value) {
            addCriterion("refund_other_transaction_fees >", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_other_transaction_fees >=", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesLessThan(BigDecimal value) {
            addCriterion("refund_other_transaction_fees <", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_other_transaction_fees <=", value, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesIn(List<BigDecimal> values) {
            addCriterion("refund_other_transaction_fees in", values, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesNotIn(List<BigDecimal> values) {
            addCriterion("refund_other_transaction_fees not in", values, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_other_transaction_fees between", value1, value2, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherTransactionFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_other_transaction_fees not between", value1, value2, "refundOtherTransactionFees");
            return (Criteria) this;
        }

        public Criteria andRefundOtherIsNull() {
            addCriterion("refund_other is null");
            return (Criteria) this;
        }

        public Criteria andRefundOtherIsNotNull() {
            addCriterion("refund_other is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOtherEqualTo(BigDecimal value) {
            addCriterion("refund_other =", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherNotEqualTo(BigDecimal value) {
            addCriterion("refund_other <>", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherGreaterThan(BigDecimal value) {
            addCriterion("refund_other >", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_other >=", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherLessThan(BigDecimal value) {
            addCriterion("refund_other <", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_other <=", value, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherIn(List<BigDecimal> values) {
            addCriterion("refund_other in", values, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherNotIn(List<BigDecimal> values) {
            addCriterion("refund_other not in", values, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_other between", value1, value2, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundOtherNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_other not between", value1, value2, "refundOther");
            return (Criteria) this;
        }

        public Criteria andRefundTotalIsNull() {
            addCriterion("refund_total is null");
            return (Criteria) this;
        }

        public Criteria andRefundTotalIsNotNull() {
            addCriterion("refund_total is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTotalEqualTo(BigDecimal value) {
            addCriterion("refund_total =", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalNotEqualTo(BigDecimal value) {
            addCriterion("refund_total <>", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalGreaterThan(BigDecimal value) {
            addCriterion("refund_total >", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_total >=", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalLessThan(BigDecimal value) {
            addCriterion("refund_total <", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_total <=", value, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalIn(List<BigDecimal> values) {
            addCriterion("refund_total in", values, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalNotIn(List<BigDecimal> values) {
            addCriterion("refund_total not in", values, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_total between", value1, value2, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andRefundTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_total not between", value1, value2, "refundTotal");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionIsNull() {
            addCriterion("sellerPayments_report_fee_subscription is null");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionIsNotNull() {
            addCriterion("sellerPayments_report_fee_subscription is not null");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionEqualTo(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription =", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionNotEqualTo(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription <>", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionGreaterThan(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription >", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription >=", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionLessThan(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription <", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellerPayments_report_fee_subscription <=", value, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionIn(List<BigDecimal> values) {
            addCriterion("sellerPayments_report_fee_subscription in", values, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionNotIn(List<BigDecimal> values) {
            addCriterion("sellerPayments_report_fee_subscription not in", values, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellerPayments_report_fee_subscription between", value1, value2, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andSellerpaymentsReportFeeSubscriptionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellerPayments_report_fee_subscription not between", value1, value2, "sellerpaymentsReportFeeSubscription");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeIsNull() {
            addCriterion("lightning_deal_fee is null");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeIsNotNull() {
            addCriterion("lightning_deal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeEqualTo(BigDecimal value) {
            addCriterion("lightning_deal_fee =", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeNotEqualTo(BigDecimal value) {
            addCriterion("lightning_deal_fee <>", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeGreaterThan(BigDecimal value) {
            addCriterion("lightning_deal_fee >", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lightning_deal_fee >=", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeLessThan(BigDecimal value) {
            addCriterion("lightning_deal_fee <", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lightning_deal_fee <=", value, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeIn(List<BigDecimal> values) {
            addCriterion("lightning_deal_fee in", values, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeNotIn(List<BigDecimal> values) {
            addCriterion("lightning_deal_fee not in", values, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lightning_deal_fee between", value1, value2, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andLightningDealFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lightning_deal_fee not between", value1, value2, "lightningDealFee");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingIsNull() {
            addCriterion("cost_of_advertising is null");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingIsNotNull() {
            addCriterion("cost_of_advertising is not null");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingEqualTo(BigDecimal value) {
            addCriterion("cost_of_advertising =", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingNotEqualTo(BigDecimal value) {
            addCriterion("cost_of_advertising <>", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingGreaterThan(BigDecimal value) {
            addCriterion("cost_of_advertising >", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_of_advertising >=", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingLessThan(BigDecimal value) {
            addCriterion("cost_of_advertising <", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_of_advertising <=", value, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingIn(List<BigDecimal> values) {
            addCriterion("cost_of_advertising in", values, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingNotIn(List<BigDecimal> values) {
            addCriterion("cost_of_advertising not in", values, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_of_advertising between", value1, value2, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andCostOfAdvertisingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_of_advertising not between", value1, value2, "costOfAdvertising");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnIsNull() {
            addCriterion("fba_inventory_reimbursement_customer_return is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnIsNotNull() {
            addCriterion("fba_inventory_reimbursement_customer_return is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return =", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return <>", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return >", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return >=", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return <", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_return <=", value, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_customer_return in", values, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_customer_return not in", values, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_customer_return between", value1, value2, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerReturnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_customer_return not between", value1, value2, "fbaInventoryReimbursementCustomerReturn");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseIsNull() {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseIsNotNull() {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse =", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse <>", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse >", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse >=", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse <", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse <=", value, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse in", values, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse not in", values, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse between", value1, value2, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementDamagedWarehouseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_damaged_warehouse not between", value1, value2, "fbaInventoryReimbursementDamagedWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueIsNull() {
            addCriterion("fba_inventory_reimbursement_customer_service_issue is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueIsNotNull() {
            addCriterion("fba_inventory_reimbursement_customer_service_issue is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue =", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue <>", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue >", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue >=", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue <", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue <=", value, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue in", values, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue not in", values, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue between", value1, value2, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementCustomerServiceIssueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_customer_service_issue not between", value1, value2, "fbaInventoryReimbursementCustomerServiceIssue");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionIsNull() {
            addCriterion("fba_inventory_reimbursement_fee_correction is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionIsNotNull() {
            addCriterion("fba_inventory_reimbursement_fee_correction is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction =", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction <>", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction >", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction >=", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction <", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_fee_correction <=", value, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_fee_correction in", values, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_fee_correction not in", values, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_fee_correction between", value1, value2, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementFeeCorrectionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_fee_correction not between", value1, value2, "fbaInventoryReimbursementFeeCorrection");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentIsNull() {
            addCriterion("fba_inventory_reimbursement_general_adjustment is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentIsNotNull() {
            addCriterion("fba_inventory_reimbursement_general_adjustment is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment =", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment <>", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment >", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment >=", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment <", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_general_adjustment <=", value, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_general_adjustment in", values, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_general_adjustment not in", values, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_general_adjustment between", value1, value2, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementGeneralAdjustmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_general_adjustment not between", value1, value2, "fbaInventoryReimbursementGeneralAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundIsNull() {
            addCriterion("fba_inventory_reimbursement_lost_inbound is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundIsNotNull() {
            addCriterion("fba_inventory_reimbursement_lost_inbound is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound =", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound <>", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound >", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound >=", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound <", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_inbound <=", value, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_lost_inbound in", values, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_lost_inbound not in", values, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_lost_inbound between", value1, value2, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostInboundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_lost_inbound not between", value1, value2, "fbaInventoryReimbursementLostInbound");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseIsNull() {
            addCriterion("fba_inventory_reimbursement_lost_warehouse is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseIsNotNull() {
            addCriterion("fba_inventory_reimbursement_lost_warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse =", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse <>", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse >", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse >=", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseLessThan(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse <", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse <=", value, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse in", values, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse not in", values, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse between", value1, value2, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryReimbursementLostWarehouseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_reimbursement_lost_warehouse not between", value1, value2, "fbaInventoryReimbursementLostWarehouse");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentIsNull() {
            addCriterion("non_subscription_fee_adjustment is null");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentIsNotNull() {
            addCriterion("non_subscription_fee_adjustment is not null");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentEqualTo(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment =", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentNotEqualTo(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment <>", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentGreaterThan(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment >", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment >=", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentLessThan(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment <", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_subscription_fee_adjustment <=", value, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentIn(List<BigDecimal> values) {
            addCriterion("non_subscription_fee_adjustment in", values, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentNotIn(List<BigDecimal> values) {
            addCriterion("non_subscription_fee_adjustment not in", values, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_subscription_fee_adjustment between", value1, value2, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andNonSubscriptionFeeAdjustmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_subscription_fee_adjustment not between", value1, value2, "nonSubscriptionFeeAdjustment");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeIsNull() {
            addCriterion("fba_inventory_placement_service_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeIsNotNull() {
            addCriterion("fba_inventory_placement_service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee =", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee <>", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee >", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee >=", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeLessThan(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee <", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_placement_service_fee <=", value, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_placement_service_fee in", values, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_placement_service_fee not in", values, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_placement_service_fee between", value1, value2, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryPlacementServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_placement_service_fee not between", value1, value2, "fbaInventoryPlacementServiceFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeIsNull() {
            addCriterion("fba_customer_return_per_unit_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeIsNotNull() {
            addCriterion("fba_customer_return_per_unit_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeEqualTo(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee =", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeNotEqualTo(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee <>", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeGreaterThan(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee >", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee >=", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeLessThan(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee <", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_customer_return_per_unit_fee <=", value, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeIn(List<BigDecimal> values) {
            addCriterion("fba_customer_return_per_unit_fee in", values, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeNotIn(List<BigDecimal> values) {
            addCriterion("fba_customer_return_per_unit_fee not in", values, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_customer_return_per_unit_fee between", value1, value2, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaCustomerReturnPerUnitFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_customer_return_per_unit_fee not between", value1, value2, "fbaCustomerReturnPerUnitFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeIsNull() {
            addCriterion("fba_inventory_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeIsNotNull() {
            addCriterion("fba_inventory_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee =", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee <>", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee >", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee >=", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeLessThan(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee <", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_inventory_storage_fee <=", value, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_storage_fee in", values, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("fba_inventory_storage_fee not in", values, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_storage_fee between", value1, value2, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaInventoryStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_inventory_storage_fee not between", value1, value2, "fbaInventoryStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeIsNull() {
            addCriterion("fba_long_term_storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeIsNotNull() {
            addCriterion("fba_long_term_storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeEqualTo(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee =", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeNotEqualTo(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee <>", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeGreaterThan(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee >", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee >=", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeLessThan(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee <", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_long_term_storage_fee <=", value, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeIn(List<BigDecimal> values) {
            addCriterion("fba_long_term_storage_fee in", values, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeNotIn(List<BigDecimal> values) {
            addCriterion("fba_long_term_storage_fee not in", values, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_long_term_storage_fee between", value1, value2, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaLongTermStorageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_long_term_storage_fee not between", value1, value2, "fbaLongTermStorageFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeIsNull() {
            addCriterion("fba_removal_order_disposal_fee is null");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeIsNotNull() {
            addCriterion("fba_removal_order_disposal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeEqualTo(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee =", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeNotEqualTo(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee <>", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeGreaterThan(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee >", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee >=", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeLessThan(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee <", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fba_removal_order_disposal_fee <=", value, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeIn(List<BigDecimal> values) {
            addCriterion("fba_removal_order_disposal_fee in", values, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeNotIn(List<BigDecimal> values) {
            addCriterion("fba_removal_order_disposal_fee not in", values, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_removal_order_disposal_fee between", value1, value2, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andFbaRemovalOrderDisposalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fba_removal_order_disposal_fee not between", value1, value2, "fbaRemovalOrderDisposalFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeIsNull() {
            addCriterion("coupon_redemption_fee is null");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeIsNotNull() {
            addCriterion("coupon_redemption_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeEqualTo(BigDecimal value) {
            addCriterion("coupon_redemption_fee =", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeNotEqualTo(BigDecimal value) {
            addCriterion("coupon_redemption_fee <>", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeGreaterThan(BigDecimal value) {
            addCriterion("coupon_redemption_fee >", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_redemption_fee >=", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeLessThan(BigDecimal value) {
            addCriterion("coupon_redemption_fee <", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_redemption_fee <=", value, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeIn(List<BigDecimal> values) {
            addCriterion("coupon_redemption_fee in", values, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeNotIn(List<BigDecimal> values) {
            addCriterion("coupon_redemption_fee not in", values, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_redemption_fee between", value1, value2, "couponRedemptionFee");
            return (Criteria) this;
        }

        public Criteria andCouponRedemptionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_redemption_fee not between", value1, value2, "couponRedemptionFee");
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

        public Criteria andEarlyReviewerProgramFeeEqualTo(BigDecimal value) {
            addCriterion("early_reviewer_program_fee =", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotEqualTo(BigDecimal value) {
            addCriterion("early_reviewer_program_fee <>", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeGreaterThan(BigDecimal value) {
            addCriterion("early_reviewer_program_fee >", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("early_reviewer_program_fee >=", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeLessThan(BigDecimal value) {
            addCriterion("early_reviewer_program_fee <", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("early_reviewer_program_fee <=", value, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeIn(List<BigDecimal> values) {
            addCriterion("early_reviewer_program_fee in", values, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotIn(List<BigDecimal> values) {
            addCriterion("early_reviewer_program_fee not in", values, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("early_reviewer_program_fee between", value1, value2, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andEarlyReviewerProgramFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("early_reviewer_program_fee not between", value1, value2, "earlyReviewerProgramFee");
            return (Criteria) this;
        }

        public Criteria andMoneyBackIsNull() {
            addCriterion("money_back is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBackIsNotNull() {
            addCriterion("money_back is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBackEqualTo(BigDecimal value) {
            addCriterion("money_back =", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackNotEqualTo(BigDecimal value) {
            addCriterion("money_back <>", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackGreaterThan(BigDecimal value) {
            addCriterion("money_back >", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_back >=", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackLessThan(BigDecimal value) {
            addCriterion("money_back <", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_back <=", value, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackIn(List<BigDecimal> values) {
            addCriterion("money_back in", values, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackNotIn(List<BigDecimal> values) {
            addCriterion("money_back not in", values, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_back between", value1, value2, "moneyBack");
            return (Criteria) this;
        }

        public Criteria andMoneyBackNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_back not between", value1, value2, "moneyBack");
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

        public Criteria andTotalEffectiveReceiptsIsNull() {
            addCriterion("total_effective_receipts is null");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsIsNotNull() {
            addCriterion("total_effective_receipts is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsEqualTo(BigDecimal value) {
            addCriterion("total_effective_receipts =", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsNotEqualTo(BigDecimal value) {
            addCriterion("total_effective_receipts <>", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsGreaterThan(BigDecimal value) {
            addCriterion("total_effective_receipts >", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_effective_receipts >=", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsLessThan(BigDecimal value) {
            addCriterion("total_effective_receipts <", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_effective_receipts <=", value, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsIn(List<BigDecimal> values) {
            addCriterion("total_effective_receipts in", values, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsNotIn(List<BigDecimal> values) {
            addCriterion("total_effective_receipts not in", values, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_effective_receipts between", value1, value2, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveReceiptsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_effective_receipts not between", value1, value2, "totalEffectiveReceipts");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityIsNull() {
            addCriterion("sellable_requested_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityIsNotNull() {
            addCriterion("sellable_requested_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityEqualTo(Integer value) {
            addCriterion("sellable_requested_quantity =", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityNotEqualTo(Integer value) {
            addCriterion("sellable_requested_quantity <>", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityGreaterThan(Integer value) {
            addCriterion("sellable_requested_quantity >", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellable_requested_quantity >=", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityLessThan(Integer value) {
            addCriterion("sellable_requested_quantity <", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("sellable_requested_quantity <=", value, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityIn(List<Integer> values) {
            addCriterion("sellable_requested_quantity in", values, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityNotIn(List<Integer> values) {
            addCriterion("sellable_requested_quantity not in", values, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("sellable_requested_quantity between", value1, value2, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableRequestedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("sellable_requested_quantity not between", value1, value2, "sellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andSellableCostIsNull() {
            addCriterion("sellable_cost is null");
            return (Criteria) this;
        }

        public Criteria andSellableCostIsNotNull() {
            addCriterion("sellable_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSellableCostEqualTo(BigDecimal value) {
            addCriterion("sellable_cost =", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostNotEqualTo(BigDecimal value) {
            addCriterion("sellable_cost <>", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostGreaterThan(BigDecimal value) {
            addCriterion("sellable_cost >", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellable_cost >=", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostLessThan(BigDecimal value) {
            addCriterion("sellable_cost <", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellable_cost <=", value, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostIn(List<BigDecimal> values) {
            addCriterion("sellable_cost in", values, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostNotIn(List<BigDecimal> values) {
            addCriterion("sellable_cost not in", values, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellable_cost between", value1, value2, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andSellableCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellable_cost not between", value1, value2, "sellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityIsNull() {
            addCriterion("unsellable_requested_quantity is null");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityIsNotNull() {
            addCriterion("unsellable_requested_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityEqualTo(Integer value) {
            addCriterion("unsellable_requested_quantity =", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityNotEqualTo(Integer value) {
            addCriterion("unsellable_requested_quantity <>", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityGreaterThan(Integer value) {
            addCriterion("unsellable_requested_quantity >", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("unsellable_requested_quantity >=", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityLessThan(Integer value) {
            addCriterion("unsellable_requested_quantity <", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("unsellable_requested_quantity <=", value, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityIn(List<Integer> values) {
            addCriterion("unsellable_requested_quantity in", values, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityNotIn(List<Integer> values) {
            addCriterion("unsellable_requested_quantity not in", values, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("unsellable_requested_quantity between", value1, value2, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableRequestedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("unsellable_requested_quantity not between", value1, value2, "unsellableRequestedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostIsNull() {
            addCriterion("unsellable_cost is null");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostIsNotNull() {
            addCriterion("unsellable_cost is not null");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostEqualTo(BigDecimal value) {
            addCriterion("unsellable_cost =", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostNotEqualTo(BigDecimal value) {
            addCriterion("unsellable_cost <>", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostGreaterThan(BigDecimal value) {
            addCriterion("unsellable_cost >", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unsellable_cost >=", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostLessThan(BigDecimal value) {
            addCriterion("unsellable_cost <", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unsellable_cost <=", value, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostIn(List<BigDecimal> values) {
            addCriterion("unsellable_cost in", values, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostNotIn(List<BigDecimal> values) {
            addCriterion("unsellable_cost not in", values, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unsellable_cost between", value1, value2, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andUnsellableCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unsellable_cost not between", value1, value2, "unsellableCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostIsNull() {
            addCriterion("procurement_cost is null");
            return (Criteria) this;
        }

        public Criteria andProcurementCostIsNotNull() {
            addCriterion("procurement_cost is not null");
            return (Criteria) this;
        }

        public Criteria andProcurementCostEqualTo(BigDecimal value) {
            addCriterion("procurement_cost =", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostNotEqualTo(BigDecimal value) {
            addCriterion("procurement_cost <>", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostGreaterThan(BigDecimal value) {
            addCriterion("procurement_cost >", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("procurement_cost >=", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostLessThan(BigDecimal value) {
            addCriterion("procurement_cost <", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("procurement_cost <=", value, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostIn(List<BigDecimal> values) {
            addCriterion("procurement_cost in", values, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostNotIn(List<BigDecimal> values) {
            addCriterion("procurement_cost not in", values, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("procurement_cost between", value1, value2, "procurementCost");
            return (Criteria) this;
        }

        public Criteria andProcurementCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("procurement_cost not between", value1, value2, "procurementCost");
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

        public Criteria andHeadDeductionFeeIsNull() {
            addCriterion("head_deduction_fee is null");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeIsNotNull() {
            addCriterion("head_deduction_fee is not null");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeEqualTo(BigDecimal value) {
            addCriterion("head_deduction_fee =", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeNotEqualTo(BigDecimal value) {
            addCriterion("head_deduction_fee <>", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeGreaterThan(BigDecimal value) {
            addCriterion("head_deduction_fee >", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("head_deduction_fee >=", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeLessThan(BigDecimal value) {
            addCriterion("head_deduction_fee <", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("head_deduction_fee <=", value, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeIn(List<BigDecimal> values) {
            addCriterion("head_deduction_fee in", values, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeNotIn(List<BigDecimal> values) {
            addCriterion("head_deduction_fee not in", values, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_deduction_fee between", value1, value2, "headDeductionFee");
            return (Criteria) this;
        }

        public Criteria andHeadDeductionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("head_deduction_fee not between", value1, value2, "headDeductionFee");
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

        public Criteria andGrossMarginOnSalesIsNull() {
            addCriterion("gross_margin_on_sales is null");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesIsNotNull() {
            addCriterion("gross_margin_on_sales is not null");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesEqualTo(BigDecimal value) {
            addCriterion("gross_margin_on_sales =", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesNotEqualTo(BigDecimal value) {
            addCriterion("gross_margin_on_sales <>", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesGreaterThan(BigDecimal value) {
            addCriterion("gross_margin_on_sales >", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_margin_on_sales >=", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesLessThan(BigDecimal value) {
            addCriterion("gross_margin_on_sales <", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_margin_on_sales <=", value, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesIn(List<BigDecimal> values) {
            addCriterion("gross_margin_on_sales in", values, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesNotIn(List<BigDecimal> values) {
            addCriterion("gross_margin_on_sales not in", values, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_margin_on_sales between", value1, value2, "grossMarginOnSales");
            return (Criteria) this;
        }

        public Criteria andGrossMarginOnSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_margin_on_sales not between", value1, value2, "grossMarginOnSales");
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

        public Criteria andInitialQuantityIsNull() {
            addCriterion("initial_quantity is null");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityIsNotNull() {
            addCriterion("initial_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityEqualTo(Integer value) {
            addCriterion("initial_quantity =", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityNotEqualTo(Integer value) {
            addCriterion("initial_quantity <>", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityGreaterThan(Integer value) {
            addCriterion("initial_quantity >", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("initial_quantity >=", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityLessThan(Integer value) {
            addCriterion("initial_quantity <", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("initial_quantity <=", value, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityIn(List<Integer> values) {
            addCriterion("initial_quantity in", values, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityNotIn(List<Integer> values) {
            addCriterion("initial_quantity not in", values, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityBetween(Integer value1, Integer value2) {
            addCriterion("initial_quantity between", value1, value2, "initialQuantity");
            return (Criteria) this;
        }

        public Criteria andInitialQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("initial_quantity not between", value1, value2, "initialQuantity");
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

        public Criteria andFinalQuantityIsNull() {
            addCriterion("final_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityIsNotNull() {
            addCriterion("final_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityEqualTo(Integer value) {
            addCriterion("final_quantity =", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityNotEqualTo(Integer value) {
            addCriterion("final_quantity <>", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityGreaterThan(Integer value) {
            addCriterion("final_quantity >", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_quantity >=", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityLessThan(Integer value) {
            addCriterion("final_quantity <", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("final_quantity <=", value, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityIn(List<Integer> values) {
            addCriterion("final_quantity in", values, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityNotIn(List<Integer> values) {
            addCriterion("final_quantity not in", values, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityBetween(Integer value1, Integer value2) {
            addCriterion("final_quantity between", value1, value2, "finalQuantity");
            return (Criteria) this;
        }

        public Criteria andFinalQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("final_quantity not between", value1, value2, "finalQuantity");
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

        public Criteria andNewProductIsNull() {
            addCriterion("new_product is null");
            return (Criteria) this;
        }

        public Criteria andNewProductIsNotNull() {
            addCriterion("new_product is not null");
            return (Criteria) this;
        }

        public Criteria andNewProductEqualTo(Integer value) {
            addCriterion("new_product =", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductNotEqualTo(Integer value) {
            addCriterion("new_product <>", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductGreaterThan(Integer value) {
            addCriterion("new_product >", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_product >=", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductLessThan(Integer value) {
            addCriterion("new_product <", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductLessThanOrEqualTo(Integer value) {
            addCriterion("new_product <=", value, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductIn(List<Integer> values) {
            addCriterion("new_product in", values, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductNotIn(List<Integer> values) {
            addCriterion("new_product not in", values, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductBetween(Integer value1, Integer value2) {
            addCriterion("new_product between", value1, value2, "newProduct");
            return (Criteria) this;
        }

        public Criteria andNewProductNotBetween(Integer value1, Integer value2) {
            addCriterion("new_product not between", value1, value2, "newProduct");
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

        public Criteria andProductMonthIsNull() {
            addCriterion("product_month is null");
            return (Criteria) this;
        }

        public Criteria andProductMonthIsNotNull() {
            addCriterion("product_month is not null");
            return (Criteria) this;
        }

        public Criteria andProductMonthEqualTo(Integer value) {
            addCriterion("product_month =", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthNotEqualTo(Integer value) {
            addCriterion("product_month <>", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthGreaterThan(Integer value) {
            addCriterion("product_month >", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_month >=", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthLessThan(Integer value) {
            addCriterion("product_month <", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthLessThanOrEqualTo(Integer value) {
            addCriterion("product_month <=", value, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthIn(List<Integer> values) {
            addCriterion("product_month in", values, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthNotIn(List<Integer> values) {
            addCriterion("product_month not in", values, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthBetween(Integer value1, Integer value2) {
            addCriterion("product_month between", value1, value2, "productMonth");
            return (Criteria) this;
        }

        public Criteria andProductMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("product_month not between", value1, value2, "productMonth");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNull() {
            addCriterion("exchange_rate is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNotNull() {
            addCriterion("exchange_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateEqualTo(BigDecimal value) {
            addCriterion("exchange_rate =", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <>", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThan(BigDecimal value) {
            addCriterion("exchange_rate >", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate >=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThan(BigDecimal value) {
            addCriterion("exchange_rate <", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIn(List<BigDecimal> values) {
            addCriterion("exchange_rate in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotIn(List<BigDecimal> values) {
            addCriterion("exchange_rate not in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate not between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIsNull() {
            addCriterion("currency_name is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIsNotNull() {
            addCriterion("currency_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameEqualTo(String value) {
            addCriterion("currency_name =", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotEqualTo(String value) {
            addCriterion("currency_name <>", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameGreaterThan(String value) {
            addCriterion("currency_name >", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("currency_name >=", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLessThan(String value) {
            addCriterion("currency_name <", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLessThanOrEqualTo(String value) {
            addCriterion("currency_name <=", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLike(String value) {
            addCriterion("currency_name like", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotLike(String value) {
            addCriterion("currency_name not like", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIn(List<String> values) {
            addCriterion("currency_name in", values, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotIn(List<String> values) {
            addCriterion("currency_name not in", values, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameBetween(String value1, String value2) {
            addCriterion("currency_name between", value1, value2, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotBetween(String value1, String value2) {
            addCriterion("currency_name not between", value1, value2, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNull() {
            addCriterion("cost_price is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceEqualTo(BigDecimal value) {
            addCriterion("cost_price =", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("cost_price <>", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThan(BigDecimal value) {
            addCriterion("cost_price >", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price >=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThan(BigDecimal value) {
            addCriterion("cost_price <", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price <=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceIn(List<BigDecimal> values) {
            addCriterion("cost_price in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("cost_price not in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price not between", value1, value2, "costPrice");
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

        public Criteria andDevelopmentLevelIsNull() {
            addCriterion("development_level is null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelIsNotNull() {
            addCriterion("development_level is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelEqualTo(Integer value) {
            addCriterion("development_level =", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotEqualTo(Integer value) {
            addCriterion("development_level <>", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelGreaterThan(Integer value) {
            addCriterion("development_level >", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("development_level >=", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelLessThan(Integer value) {
            addCriterion("development_level <", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("development_level <=", value, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelIn(List<Integer> values) {
            addCriterion("development_level in", values, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotIn(List<Integer> values) {
            addCriterion("development_level not in", values, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelBetween(Integer value1, Integer value2) {
            addCriterion("development_level between", value1, value2, "developmentLevel");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("development_level not between", value1, value2, "developmentLevel");
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

        public Criteria andDisplayAdvertisingEqualTo(BigDecimal value) {
            addCriterion("display_advertising =", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotEqualTo(BigDecimal value) {
            addCriterion("display_advertising <>", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingGreaterThan(BigDecimal value) {
            addCriterion("display_advertising >", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("display_advertising >=", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingLessThan(BigDecimal value) {
            addCriterion("display_advertising <", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("display_advertising <=", value, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingIn(List<BigDecimal> values) {
            addCriterion("display_advertising in", values, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotIn(List<BigDecimal> values) {
            addCriterion("display_advertising not in", values, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("display_advertising between", value1, value2, "displayAdvertising");
            return (Criteria) this;
        }

        public Criteria andDisplayAdvertisingNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andBrandAdvertisingEqualTo(BigDecimal value) {
            addCriterion("brand_advertising =", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotEqualTo(BigDecimal value) {
            addCriterion("brand_advertising <>", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingGreaterThan(BigDecimal value) {
            addCriterion("brand_advertising >", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("brand_advertising >=", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingLessThan(BigDecimal value) {
            addCriterion("brand_advertising <", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("brand_advertising <=", value, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingIn(List<BigDecimal> values) {
            addCriterion("brand_advertising in", values, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotIn(List<BigDecimal> values) {
            addCriterion("brand_advertising not in", values, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brand_advertising between", value1, value2, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andBrandAdvertisingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brand_advertising not between", value1, value2, "brandAdvertising");
            return (Criteria) this;
        }

        public Criteria andLiquidationsIsNull() {
            addCriterion("liquidations is null");
            return (Criteria) this;
        }

        public Criteria andLiquidationsIsNotNull() {
            addCriterion("liquidations is not null");
            return (Criteria) this;
        }

        public Criteria andLiquidationsEqualTo(BigDecimal value) {
            addCriterion("liquidations =", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsNotEqualTo(BigDecimal value) {
            addCriterion("liquidations <>", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsGreaterThan(BigDecimal value) {
            addCriterion("liquidations >", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("liquidations >=", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsLessThan(BigDecimal value) {
            addCriterion("liquidations <", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("liquidations <=", value, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsIn(List<BigDecimal> values) {
            addCriterion("liquidations in", values, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsNotIn(List<BigDecimal> values) {
            addCriterion("liquidations not in", values, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("liquidations between", value1, value2, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("liquidations not between", value1, value2, "liquidations");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsIsNull() {
            addCriterion("liquidations_adjustments is null");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsIsNotNull() {
            addCriterion("liquidations_adjustments is not null");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsEqualTo(BigDecimal value) {
            addCriterion("liquidations_adjustments =", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsNotEqualTo(BigDecimal value) {
            addCriterion("liquidations_adjustments <>", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsGreaterThan(BigDecimal value) {
            addCriterion("liquidations_adjustments >", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("liquidations_adjustments >=", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsLessThan(BigDecimal value) {
            addCriterion("liquidations_adjustments <", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("liquidations_adjustments <=", value, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsIn(List<BigDecimal> values) {
            addCriterion("liquidations_adjustments in", values, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsNotIn(List<BigDecimal> values) {
            addCriterion("liquidations_adjustments not in", values, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("liquidations_adjustments between", value1, value2, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andLiquidationsAdjustmentsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("liquidations_adjustments not between", value1, value2, "liquidationsAdjustments");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentIsNull() {
            addCriterion("tbyb_order_payment is null");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentIsNotNull() {
            addCriterion("tbyb_order_payment is not null");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentEqualTo(BigDecimal value) {
            addCriterion("tbyb_order_payment =", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentNotEqualTo(BigDecimal value) {
            addCriterion("tbyb_order_payment <>", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentGreaterThan(BigDecimal value) {
            addCriterion("tbyb_order_payment >", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tbyb_order_payment >=", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentLessThan(BigDecimal value) {
            addCriterion("tbyb_order_payment <", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tbyb_order_payment <=", value, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentIn(List<BigDecimal> values) {
            addCriterion("tbyb_order_payment in", values, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentNotIn(List<BigDecimal> values) {
            addCriterion("tbyb_order_payment not in", values, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tbyb_order_payment between", value1, value2, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybOrderPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tbyb_order_payment not between", value1, value2, "tbybOrderPayment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentIsNull() {
            addCriterion("tbyb_trial_shipment is null");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentIsNotNull() {
            addCriterion("tbyb_trial_shipment is not null");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentEqualTo(BigDecimal value) {
            addCriterion("tbyb_trial_shipment =", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentNotEqualTo(BigDecimal value) {
            addCriterion("tbyb_trial_shipment <>", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentGreaterThan(BigDecimal value) {
            addCriterion("tbyb_trial_shipment >", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tbyb_trial_shipment >=", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentLessThan(BigDecimal value) {
            addCriterion("tbyb_trial_shipment <", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tbyb_trial_shipment <=", value, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentIn(List<BigDecimal> values) {
            addCriterion("tbyb_trial_shipment in", values, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentNotIn(List<BigDecimal> values) {
            addCriterion("tbyb_trial_shipment not in", values, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tbyb_trial_shipment between", value1, value2, "tbybTrialShipment");
            return (Criteria) this;
        }

        public Criteria andTbybTrialShipmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tbyb_trial_shipment not between", value1, value2, "tbybTrialShipment");
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