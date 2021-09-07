package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDevelopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDevelopExample() {
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameIsNull() {
            addCriterion("chinese_product_name is null");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameIsNotNull() {
            addCriterion("chinese_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameEqualTo(String value) {
            addCriterion("chinese_product_name =", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameNotEqualTo(String value) {
            addCriterion("chinese_product_name <>", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameGreaterThan(String value) {
            addCriterion("chinese_product_name >", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_product_name >=", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameLessThan(String value) {
            addCriterion("chinese_product_name <", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameLessThanOrEqualTo(String value) {
            addCriterion("chinese_product_name <=", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameLike(String value) {
            addCriterion("chinese_product_name like", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameNotLike(String value) {
            addCriterion("chinese_product_name not like", value, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameIn(List<String> values) {
            addCriterion("chinese_product_name in", values, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameNotIn(List<String> values) {
            addCriterion("chinese_product_name not in", values, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameBetween(String value1, String value2) {
            addCriterion("chinese_product_name between", value1, value2, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andChineseProductNameNotBetween(String value1, String value2) {
            addCriterion("chinese_product_name not between", value1, value2, "chineseProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameIsNull() {
            addCriterion("english_product_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameIsNotNull() {
            addCriterion("english_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameEqualTo(String value) {
            addCriterion("english_product_name =", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameNotEqualTo(String value) {
            addCriterion("english_product_name <>", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameGreaterThan(String value) {
            addCriterion("english_product_name >", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_product_name >=", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameLessThan(String value) {
            addCriterion("english_product_name <", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameLessThanOrEqualTo(String value) {
            addCriterion("english_product_name <=", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameLike(String value) {
            addCriterion("english_product_name like", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameNotLike(String value) {
            addCriterion("english_product_name not like", value, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameIn(List<String> values) {
            addCriterion("english_product_name in", values, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameNotIn(List<String> values) {
            addCriterion("english_product_name not in", values, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameBetween(String value1, String value2) {
            addCriterion("english_product_name between", value1, value2, "englishProductName");
            return (Criteria) this;
        }

        public Criteria andEnglishProductNameNotBetween(String value1, String value2) {
            addCriterion("english_product_name not between", value1, value2, "englishProductName");
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

        public Criteria andDevelopmentTimeIsNull() {
            addCriterion("development_time is null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeIsNotNull() {
            addCriterion("development_time is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeEqualTo(Date value) {
            addCriterion("development_time =", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeNotEqualTo(Date value) {
            addCriterion("development_time <>", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeGreaterThan(Date value) {
            addCriterion("development_time >", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("development_time >=", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeLessThan(Date value) {
            addCriterion("development_time <", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("development_time <=", value, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeIn(List<Date> values) {
            addCriterion("development_time in", values, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeNotIn(List<Date> values) {
            addCriterion("development_time not in", values, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeBetween(Date value1, Date value2) {
            addCriterion("development_time between", value1, value2, "developmentTime");
            return (Criteria) this;
        }

        public Criteria andDevelopmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("development_time not between", value1, value2, "developmentTime");
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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