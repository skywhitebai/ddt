package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopSenderAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopSenderAddressExample() {
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

        public Criteria andShipToCountryIsNull() {
            addCriterion("ship_to_country is null");
            return (Criteria) this;
        }

        public Criteria andShipToCountryIsNotNull() {
            addCriterion("ship_to_country is not null");
            return (Criteria) this;
        }

        public Criteria andShipToCountryEqualTo(String value) {
            addCriterion("ship_to_country =", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryNotEqualTo(String value) {
            addCriterion("ship_to_country <>", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryGreaterThan(String value) {
            addCriterion("ship_to_country >", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryGreaterThanOrEqualTo(String value) {
            addCriterion("ship_to_country >=", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryLessThan(String value) {
            addCriterion("ship_to_country <", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryLessThanOrEqualTo(String value) {
            addCriterion("ship_to_country <=", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryLike(String value) {
            addCriterion("ship_to_country like", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryNotLike(String value) {
            addCriterion("ship_to_country not like", value, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryIn(List<String> values) {
            addCriterion("ship_to_country in", values, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryNotIn(List<String> values) {
            addCriterion("ship_to_country not in", values, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryBetween(String value1, String value2) {
            addCriterion("ship_to_country between", value1, value2, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andShipToCountryNotBetween(String value1, String value2) {
            addCriterion("ship_to_country not between", value1, value2, "shipToCountry");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNull() {
            addCriterion("address_name is null");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNotNull() {
            addCriterion("address_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddressNameEqualTo(String value) {
            addCriterion("address_name =", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotEqualTo(String value) {
            addCriterion("address_name <>", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThan(String value) {
            addCriterion("address_name >", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("address_name >=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThan(String value) {
            addCriterion("address_name <", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThanOrEqualTo(String value) {
            addCriterion("address_name <=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLike(String value) {
            addCriterion("address_name like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotLike(String value) {
            addCriterion("address_name not like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameIn(List<String> values) {
            addCriterion("address_name in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotIn(List<String> values) {
            addCriterion("address_name not in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameBetween(String value1, String value2) {
            addCriterion("address_name between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotBetween(String value1, String value2) {
            addCriterion("address_name not between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneIsNull() {
            addCriterion("address_field_one is null");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneIsNotNull() {
            addCriterion("address_field_one is not null");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneEqualTo(String value) {
            addCriterion("address_field_one =", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneNotEqualTo(String value) {
            addCriterion("address_field_one <>", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneGreaterThan(String value) {
            addCriterion("address_field_one >", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneGreaterThanOrEqualTo(String value) {
            addCriterion("address_field_one >=", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneLessThan(String value) {
            addCriterion("address_field_one <", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneLessThanOrEqualTo(String value) {
            addCriterion("address_field_one <=", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneLike(String value) {
            addCriterion("address_field_one like", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneNotLike(String value) {
            addCriterion("address_field_one not like", value, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneIn(List<String> values) {
            addCriterion("address_field_one in", values, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneNotIn(List<String> values) {
            addCriterion("address_field_one not in", values, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneBetween(String value1, String value2) {
            addCriterion("address_field_one between", value1, value2, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldOneNotBetween(String value1, String value2) {
            addCriterion("address_field_one not between", value1, value2, "addressFieldOne");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoIsNull() {
            addCriterion("address_field_two is null");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoIsNotNull() {
            addCriterion("address_field_two is not null");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoEqualTo(String value) {
            addCriterion("address_field_two =", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoNotEqualTo(String value) {
            addCriterion("address_field_two <>", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoGreaterThan(String value) {
            addCriterion("address_field_two >", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoGreaterThanOrEqualTo(String value) {
            addCriterion("address_field_two >=", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoLessThan(String value) {
            addCriterion("address_field_two <", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoLessThanOrEqualTo(String value) {
            addCriterion("address_field_two <=", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoLike(String value) {
            addCriterion("address_field_two like", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoNotLike(String value) {
            addCriterion("address_field_two not like", value, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoIn(List<String> values) {
            addCriterion("address_field_two in", values, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoNotIn(List<String> values) {
            addCriterion("address_field_two not in", values, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoBetween(String value1, String value2) {
            addCriterion("address_field_two between", value1, value2, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressFieldTwoNotBetween(String value1, String value2) {
            addCriterion("address_field_two not between", value1, value2, "addressFieldTwo");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNull() {
            addCriterion("address_city is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNotNull() {
            addCriterion("address_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityEqualTo(String value) {
            addCriterion("address_city =", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotEqualTo(String value) {
            addCriterion("address_city <>", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThan(String value) {
            addCriterion("address_city >", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("address_city >=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThan(String value) {
            addCriterion("address_city <", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThanOrEqualTo(String value) {
            addCriterion("address_city <=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLike(String value) {
            addCriterion("address_city like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotLike(String value) {
            addCriterion("address_city not like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityIn(List<String> values) {
            addCriterion("address_city in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotIn(List<String> values) {
            addCriterion("address_city not in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityBetween(String value1, String value2) {
            addCriterion("address_city between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotBetween(String value1, String value2) {
            addCriterion("address_city not between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeIsNull() {
            addCriterion("address_country_code is null");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeIsNotNull() {
            addCriterion("address_country_code is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeEqualTo(String value) {
            addCriterion("address_country_code =", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeNotEqualTo(String value) {
            addCriterion("address_country_code <>", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeGreaterThan(String value) {
            addCriterion("address_country_code >", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("address_country_code >=", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeLessThan(String value) {
            addCriterion("address_country_code <", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("address_country_code <=", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeLike(String value) {
            addCriterion("address_country_code like", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeNotLike(String value) {
            addCriterion("address_country_code not like", value, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeIn(List<String> values) {
            addCriterion("address_country_code in", values, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeNotIn(List<String> values) {
            addCriterion("address_country_code not in", values, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeBetween(String value1, String value2) {
            addCriterion("address_country_code between", value1, value2, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressCountryCodeNotBetween(String value1, String value2) {
            addCriterion("address_country_code not between", value1, value2, "addressCountryCode");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionIsNull() {
            addCriterion("address_state_or_region is null");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionIsNotNull() {
            addCriterion("address_state_or_region is not null");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionEqualTo(String value) {
            addCriterion("address_state_or_region =", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionNotEqualTo(String value) {
            addCriterion("address_state_or_region <>", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionGreaterThan(String value) {
            addCriterion("address_state_or_region >", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionGreaterThanOrEqualTo(String value) {
            addCriterion("address_state_or_region >=", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionLessThan(String value) {
            addCriterion("address_state_or_region <", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionLessThanOrEqualTo(String value) {
            addCriterion("address_state_or_region <=", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionLike(String value) {
            addCriterion("address_state_or_region like", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionNotLike(String value) {
            addCriterion("address_state_or_region not like", value, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionIn(List<String> values) {
            addCriterion("address_state_or_region in", values, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionNotIn(List<String> values) {
            addCriterion("address_state_or_region not in", values, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionBetween(String value1, String value2) {
            addCriterion("address_state_or_region between", value1, value2, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressStateOrRegionNotBetween(String value1, String value2) {
            addCriterion("address_state_or_region not between", value1, value2, "addressStateOrRegion");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeIsNull() {
            addCriterion("address_postal_code is null");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeIsNotNull() {
            addCriterion("address_postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeEqualTo(String value) {
            addCriterion("address_postal_code =", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeNotEqualTo(String value) {
            addCriterion("address_postal_code <>", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeGreaterThan(String value) {
            addCriterion("address_postal_code >", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("address_postal_code >=", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeLessThan(String value) {
            addCriterion("address_postal_code <", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("address_postal_code <=", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeLike(String value) {
            addCriterion("address_postal_code like", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeNotLike(String value) {
            addCriterion("address_postal_code not like", value, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeIn(List<String> values) {
            addCriterion("address_postal_code in", values, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeNotIn(List<String> values) {
            addCriterion("address_postal_code not in", values, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeBetween(String value1, String value2) {
            addCriterion("address_postal_code between", value1, value2, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressPostalCodeNotBetween(String value1, String value2) {
            addCriterion("address_postal_code not between", value1, value2, "addressPostalCode");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictIsNull() {
            addCriterion("address_district is null");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictIsNotNull() {
            addCriterion("address_district is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictEqualTo(String value) {
            addCriterion("address_district =", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictNotEqualTo(String value) {
            addCriterion("address_district <>", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictGreaterThan(String value) {
            addCriterion("address_district >", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("address_district >=", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictLessThan(String value) {
            addCriterion("address_district <", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictLessThanOrEqualTo(String value) {
            addCriterion("address_district <=", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictLike(String value) {
            addCriterion("address_district like", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictNotLike(String value) {
            addCriterion("address_district not like", value, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictIn(List<String> values) {
            addCriterion("address_district in", values, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictNotIn(List<String> values) {
            addCriterion("address_district not in", values, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictBetween(String value1, String value2) {
            addCriterion("address_district between", value1, value2, "addressDistrict");
            return (Criteria) this;
        }

        public Criteria andAddressDistrictNotBetween(String value1, String value2) {
            addCriterion("address_district not between", value1, value2, "addressDistrict");
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