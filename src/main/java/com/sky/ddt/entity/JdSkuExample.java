package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JdSkuExample() {
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

        public Criteria andJdSkuIsNull() {
            addCriterion("jd_sku is null");
            return (Criteria) this;
        }

        public Criteria andJdSkuIsNotNull() {
            addCriterion("jd_sku is not null");
            return (Criteria) this;
        }

        public Criteria andJdSkuEqualTo(String value) {
            addCriterion("jd_sku =", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuNotEqualTo(String value) {
            addCriterion("jd_sku <>", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuGreaterThan(String value) {
            addCriterion("jd_sku >", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuGreaterThanOrEqualTo(String value) {
            addCriterion("jd_sku >=", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuLessThan(String value) {
            addCriterion("jd_sku <", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuLessThanOrEqualTo(String value) {
            addCriterion("jd_sku <=", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuLike(String value) {
            addCriterion("jd_sku like", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuNotLike(String value) {
            addCriterion("jd_sku not like", value, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuIn(List<String> values) {
            addCriterion("jd_sku in", values, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuNotIn(List<String> values) {
            addCriterion("jd_sku not in", values, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuBetween(String value1, String value2) {
            addCriterion("jd_sku between", value1, value2, "jdSku");
            return (Criteria) this;
        }

        public Criteria andJdSkuNotBetween(String value1, String value2) {
            addCriterion("jd_sku not between", value1, value2, "jdSku");
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

        public Criteria andJdPopCodeIsNull() {
            addCriterion("jd_pop_code is null");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeIsNotNull() {
            addCriterion("jd_pop_code is not null");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeEqualTo(String value) {
            addCriterion("jd_pop_code =", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeNotEqualTo(String value) {
            addCriterion("jd_pop_code <>", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeGreaterThan(String value) {
            addCriterion("jd_pop_code >", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeGreaterThanOrEqualTo(String value) {
            addCriterion("jd_pop_code >=", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeLessThan(String value) {
            addCriterion("jd_pop_code <", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeLessThanOrEqualTo(String value) {
            addCriterion("jd_pop_code <=", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeLike(String value) {
            addCriterion("jd_pop_code like", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeNotLike(String value) {
            addCriterion("jd_pop_code not like", value, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeIn(List<String> values) {
            addCriterion("jd_pop_code in", values, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeNotIn(List<String> values) {
            addCriterion("jd_pop_code not in", values, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeBetween(String value1, String value2) {
            addCriterion("jd_pop_code between", value1, value2, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andJdPopCodeNotBetween(String value1, String value2) {
            addCriterion("jd_pop_code not between", value1, value2, "jdPopCode");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andCriteriaIsNull() {
            addCriterion("criteria is null");
            return (Criteria) this;
        }

        public Criteria andCriteriaIsNotNull() {
            addCriterion("criteria is not null");
            return (Criteria) this;
        }

        public Criteria andCriteriaEqualTo(String value) {
            addCriterion("criteria =", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaNotEqualTo(String value) {
            addCriterion("criteria <>", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaGreaterThan(String value) {
            addCriterion("criteria >", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaGreaterThanOrEqualTo(String value) {
            addCriterion("criteria >=", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaLessThan(String value) {
            addCriterion("criteria <", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaLessThanOrEqualTo(String value) {
            addCriterion("criteria <=", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaLike(String value) {
            addCriterion("criteria like", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaNotLike(String value) {
            addCriterion("criteria not like", value, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaIn(List<String> values) {
            addCriterion("criteria in", values, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaNotIn(List<String> values) {
            addCriterion("criteria not in", values, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaBetween(String value1, String value2) {
            addCriterion("criteria between", value1, value2, "criteria");
            return (Criteria) this;
        }

        public Criteria andCriteriaNotBetween(String value1, String value2) {
            addCriterion("criteria not between", value1, value2, "criteria");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesIsNull() {
            addCriterion("security_categories is null");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesIsNotNull() {
            addCriterion("security_categories is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesEqualTo(String value) {
            addCriterion("security_categories =", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesNotEqualTo(String value) {
            addCriterion("security_categories <>", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesGreaterThan(String value) {
            addCriterion("security_categories >", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesGreaterThanOrEqualTo(String value) {
            addCriterion("security_categories >=", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesLessThan(String value) {
            addCriterion("security_categories <", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesLessThanOrEqualTo(String value) {
            addCriterion("security_categories <=", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesLike(String value) {
            addCriterion("security_categories like", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesNotLike(String value) {
            addCriterion("security_categories not like", value, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesIn(List<String> values) {
            addCriterion("security_categories in", values, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesNotIn(List<String> values) {
            addCriterion("security_categories not in", values, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesBetween(String value1, String value2) {
            addCriterion("security_categories between", value1, value2, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andSecurityCategoriesNotBetween(String value1, String value2) {
            addCriterion("security_categories not between", value1, value2, "securityCategories");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIsNull() {
            addCriterion("quality_grade is null");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIsNotNull() {
            addCriterion("quality_grade is not null");
            return (Criteria) this;
        }

        public Criteria andQualityGradeEqualTo(String value) {
            addCriterion("quality_grade =", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotEqualTo(String value) {
            addCriterion("quality_grade <>", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeGreaterThan(String value) {
            addCriterion("quality_grade >", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeGreaterThanOrEqualTo(String value) {
            addCriterion("quality_grade >=", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeLessThan(String value) {
            addCriterion("quality_grade <", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeLessThanOrEqualTo(String value) {
            addCriterion("quality_grade <=", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeLike(String value) {
            addCriterion("quality_grade like", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotLike(String value) {
            addCriterion("quality_grade not like", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIn(List<String> values) {
            addCriterion("quality_grade in", values, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotIn(List<String> values) {
            addCriterion("quality_grade not in", values, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeBetween(String value1, String value2) {
            addCriterion("quality_grade between", value1, value2, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotBetween(String value1, String value2) {
            addCriterion("quality_grade not between", value1, value2, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNull() {
            addCriterion("inspector is null");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNotNull() {
            addCriterion("inspector is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorEqualTo(String value) {
            addCriterion("inspector =", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotEqualTo(String value) {
            addCriterion("inspector <>", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThan(String value) {
            addCriterion("inspector >", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThanOrEqualTo(String value) {
            addCriterion("inspector >=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThan(String value) {
            addCriterion("inspector <", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThanOrEqualTo(String value) {
            addCriterion("inspector <=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLike(String value) {
            addCriterion("inspector like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotLike(String value) {
            addCriterion("inspector not like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorIn(List<String> values) {
            addCriterion("inspector in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotIn(List<String> values) {
            addCriterion("inspector not in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorBetween(String value1, String value2) {
            addCriterion("inspector between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotBetween(String value1, String value2) {
            addCriterion("inspector not between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIsNull() {
            addCriterion("production_address is null");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIsNotNull() {
            addCriterion("production_address is not null");
            return (Criteria) this;
        }

        public Criteria andProductionAddressEqualTo(String value) {
            addCriterion("production_address =", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotEqualTo(String value) {
            addCriterion("production_address <>", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressGreaterThan(String value) {
            addCriterion("production_address >", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressGreaterThanOrEqualTo(String value) {
            addCriterion("production_address >=", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLessThan(String value) {
            addCriterion("production_address <", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLessThanOrEqualTo(String value) {
            addCriterion("production_address <=", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLike(String value) {
            addCriterion("production_address like", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotLike(String value) {
            addCriterion("production_address not like", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIn(List<String> values) {
            addCriterion("production_address in", values, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotIn(List<String> values) {
            addCriterion("production_address not in", values, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressBetween(String value1, String value2) {
            addCriterion("production_address between", value1, value2, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotBetween(String value1, String value2) {
            addCriterion("production_address not between", value1, value2, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateIsNull() {
            addCriterion("print_template is null");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateIsNotNull() {
            addCriterion("print_template is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateEqualTo(Integer value) {
            addCriterion("print_template =", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateNotEqualTo(Integer value) {
            addCriterion("print_template <>", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateGreaterThan(Integer value) {
            addCriterion("print_template >", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateGreaterThanOrEqualTo(Integer value) {
            addCriterion("print_template >=", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateLessThan(Integer value) {
            addCriterion("print_template <", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateLessThanOrEqualTo(Integer value) {
            addCriterion("print_template <=", value, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateIn(List<Integer> values) {
            addCriterion("print_template in", values, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateNotIn(List<Integer> values) {
            addCriterion("print_template not in", values, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateBetween(Integer value1, Integer value2) {
            addCriterion("print_template between", value1, value2, "printTemplate");
            return (Criteria) this;
        }

        public Criteria andPrintTemplateNotBetween(Integer value1, Integer value2) {
            addCriterion("print_template not between", value1, value2, "printTemplate");
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