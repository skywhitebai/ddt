package com.sky.ddt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShopUrlIsNull() {
            addCriterion("shop_url is null");
            return (Criteria) this;
        }

        public Criteria andShopUrlIsNotNull() {
            addCriterion("shop_url is not null");
            return (Criteria) this;
        }

        public Criteria andShopUrlEqualTo(String value) {
            addCriterion("shop_url =", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotEqualTo(String value) {
            addCriterion("shop_url <>", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThan(String value) {
            addCriterion("shop_url >", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThanOrEqualTo(String value) {
            addCriterion("shop_url >=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThan(String value) {
            addCriterion("shop_url <", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThanOrEqualTo(String value) {
            addCriterion("shop_url <=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLike(String value) {
            addCriterion("shop_url like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotLike(String value) {
            addCriterion("shop_url not like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlIn(List<String> values) {
            addCriterion("shop_url in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotIn(List<String> values) {
            addCriterion("shop_url not in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlBetween(String value1, String value2) {
            addCriterion("shop_url between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotBetween(String value1, String value2) {
            addCriterion("shop_url not between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdIsNull() {
            addCriterion("shop_marketplace_id is null");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdIsNotNull() {
            addCriterion("shop_marketplace_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdEqualTo(String value) {
            addCriterion("shop_marketplace_id =", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdNotEqualTo(String value) {
            addCriterion("shop_marketplace_id <>", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdGreaterThan(String value) {
            addCriterion("shop_marketplace_id >", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_marketplace_id >=", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdLessThan(String value) {
            addCriterion("shop_marketplace_id <", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdLessThanOrEqualTo(String value) {
            addCriterion("shop_marketplace_id <=", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdLike(String value) {
            addCriterion("shop_marketplace_id like", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdNotLike(String value) {
            addCriterion("shop_marketplace_id not like", value, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdIn(List<String> values) {
            addCriterion("shop_marketplace_id in", values, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdNotIn(List<String> values) {
            addCriterion("shop_marketplace_id not in", values, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdBetween(String value1, String value2) {
            addCriterion("shop_marketplace_id between", value1, value2, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andShopMarketplaceIdNotBetween(String value1, String value2) {
            addCriterion("shop_marketplace_id not between", value1, value2, "shopMarketplaceId");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenIsNull() {
            addCriterion("mws_auth_token is null");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenIsNotNull() {
            addCriterion("mws_auth_token is not null");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenEqualTo(String value) {
            addCriterion("mws_auth_token =", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenNotEqualTo(String value) {
            addCriterion("mws_auth_token <>", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenGreaterThan(String value) {
            addCriterion("mws_auth_token >", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("mws_auth_token >=", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenLessThan(String value) {
            addCriterion("mws_auth_token <", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("mws_auth_token <=", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenLike(String value) {
            addCriterion("mws_auth_token like", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenNotLike(String value) {
            addCriterion("mws_auth_token not like", value, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenIn(List<String> values) {
            addCriterion("mws_auth_token in", values, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenNotIn(List<String> values) {
            addCriterion("mws_auth_token not in", values, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenBetween(String value1, String value2) {
            addCriterion("mws_auth_token between", value1, value2, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andMwsAuthTokenNotBetween(String value1, String value2) {
            addCriterion("mws_auth_token not between", value1, value2, "mwsAuthToken");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyIsNull() {
            addCriterion("amazon_access_key is null");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyIsNotNull() {
            addCriterion("amazon_access_key is not null");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyEqualTo(String value) {
            addCriterion("amazon_access_key =", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyNotEqualTo(String value) {
            addCriterion("amazon_access_key <>", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyGreaterThan(String value) {
            addCriterion("amazon_access_key >", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("amazon_access_key >=", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyLessThan(String value) {
            addCriterion("amazon_access_key <", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyLessThanOrEqualTo(String value) {
            addCriterion("amazon_access_key <=", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyLike(String value) {
            addCriterion("amazon_access_key like", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyNotLike(String value) {
            addCriterion("amazon_access_key not like", value, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyIn(List<String> values) {
            addCriterion("amazon_access_key in", values, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyNotIn(List<String> values) {
            addCriterion("amazon_access_key not in", values, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyBetween(String value1, String value2) {
            addCriterion("amazon_access_key between", value1, value2, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonAccessKeyNotBetween(String value1, String value2) {
            addCriterion("amazon_access_key not between", value1, value2, "amazonAccessKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyIsNull() {
            addCriterion("amazon_secret_key is null");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyIsNotNull() {
            addCriterion("amazon_secret_key is not null");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyEqualTo(String value) {
            addCriterion("amazon_secret_key =", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyNotEqualTo(String value) {
            addCriterion("amazon_secret_key <>", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyGreaterThan(String value) {
            addCriterion("amazon_secret_key >", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyGreaterThanOrEqualTo(String value) {
            addCriterion("amazon_secret_key >=", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyLessThan(String value) {
            addCriterion("amazon_secret_key <", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyLessThanOrEqualTo(String value) {
            addCriterion("amazon_secret_key <=", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyLike(String value) {
            addCriterion("amazon_secret_key like", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyNotLike(String value) {
            addCriterion("amazon_secret_key not like", value, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyIn(List<String> values) {
            addCriterion("amazon_secret_key in", values, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyNotIn(List<String> values) {
            addCriterion("amazon_secret_key not in", values, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyBetween(String value1, String value2) {
            addCriterion("amazon_secret_key between", value1, value2, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andAmazonSecretKeyNotBetween(String value1, String value2) {
            addCriterion("amazon_secret_key not between", value1, value2, "amazonSecretKey");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressIsNull() {
            addCriterion("client_mac_address is null");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressIsNotNull() {
            addCriterion("client_mac_address is not null");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressEqualTo(String value) {
            addCriterion("client_mac_address =", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressNotEqualTo(String value) {
            addCriterion("client_mac_address <>", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressGreaterThan(String value) {
            addCriterion("client_mac_address >", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressGreaterThanOrEqualTo(String value) {
            addCriterion("client_mac_address >=", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressLessThan(String value) {
            addCriterion("client_mac_address <", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressLessThanOrEqualTo(String value) {
            addCriterion("client_mac_address <=", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressLike(String value) {
            addCriterion("client_mac_address like", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressNotLike(String value) {
            addCriterion("client_mac_address not like", value, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressIn(List<String> values) {
            addCriterion("client_mac_address in", values, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressNotIn(List<String> values) {
            addCriterion("client_mac_address not in", values, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressBetween(String value1, String value2) {
            addCriterion("client_mac_address between", value1, value2, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andClientMacAddressNotBetween(String value1, String value2) {
            addCriterion("client_mac_address not between", value1, value2, "clientMacAddress");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterIsNull() {
            addCriterion("order_last_updated_after is null");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterIsNotNull() {
            addCriterion("order_last_updated_after is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterEqualTo(Date value) {
            addCriterion("order_last_updated_after =", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterNotEqualTo(Date value) {
            addCriterion("order_last_updated_after <>", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterGreaterThan(Date value) {
            addCriterion("order_last_updated_after >", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterGreaterThanOrEqualTo(Date value) {
            addCriterion("order_last_updated_after >=", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterLessThan(Date value) {
            addCriterion("order_last_updated_after <", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterLessThanOrEqualTo(Date value) {
            addCriterion("order_last_updated_after <=", value, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterIn(List<Date> values) {
            addCriterion("order_last_updated_after in", values, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterNotIn(List<Date> values) {
            addCriterion("order_last_updated_after not in", values, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterBetween(Date value1, Date value2) {
            addCriterion("order_last_updated_after between", value1, value2, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andOrderLastUpdatedAfterNotBetween(Date value1, Date value2) {
            addCriterion("order_last_updated_after not between", value1, value2, "orderLastUpdatedAfter");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeIsNull() {
            addCriterion("inventory_query_start_date_time is null");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeIsNotNull() {
            addCriterion("inventory_query_start_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeEqualTo(Date value) {
            addCriterion("inventory_query_start_date_time =", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeNotEqualTo(Date value) {
            addCriterion("inventory_query_start_date_time <>", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeGreaterThan(Date value) {
            addCriterion("inventory_query_start_date_time >", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inventory_query_start_date_time >=", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeLessThan(Date value) {
            addCriterion("inventory_query_start_date_time <", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("inventory_query_start_date_time <=", value, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeIn(List<Date> values) {
            addCriterion("inventory_query_start_date_time in", values, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeNotIn(List<Date> values) {
            addCriterion("inventory_query_start_date_time not in", values, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeBetween(Date value1, Date value2) {
            addCriterion("inventory_query_start_date_time between", value1, value2, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andInventoryQueryStartDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("inventory_query_start_date_time not between", value1, value2, "inventoryQueryStartDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityIsNull() {
            addCriterion("order_syn_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityIsNotNull() {
            addCriterion("order_syn_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityEqualTo(Integer value) {
            addCriterion("order_syn_quantity =", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityNotEqualTo(Integer value) {
            addCriterion("order_syn_quantity <>", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityGreaterThan(Integer value) {
            addCriterion("order_syn_quantity >", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_syn_quantity >=", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityLessThan(Integer value) {
            addCriterion("order_syn_quantity <", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("order_syn_quantity <=", value, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityIn(List<Integer> values) {
            addCriterion("order_syn_quantity in", values, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityNotIn(List<Integer> values) {
            addCriterion("order_syn_quantity not in", values, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityBetween(Integer value1, Integer value2) {
            addCriterion("order_syn_quantity between", value1, value2, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("order_syn_quantity not between", value1, value2, "orderSynQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteIsNull() {
            addCriterion("order_syn_interval_minute is null");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteIsNotNull() {
            addCriterion("order_syn_interval_minute is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteEqualTo(Integer value) {
            addCriterion("order_syn_interval_minute =", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteNotEqualTo(Integer value) {
            addCriterion("order_syn_interval_minute <>", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteGreaterThan(Integer value) {
            addCriterion("order_syn_interval_minute >", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_syn_interval_minute >=", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteLessThan(Integer value) {
            addCriterion("order_syn_interval_minute <", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("order_syn_interval_minute <=", value, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteIn(List<Integer> values) {
            addCriterion("order_syn_interval_minute in", values, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteNotIn(List<Integer> values) {
            addCriterion("order_syn_interval_minute not in", values, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteBetween(Integer value1, Integer value2) {
            addCriterion("order_syn_interval_minute between", value1, value2, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andOrderSynIntervalMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("order_syn_interval_minute not between", value1, value2, "orderSynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteIsNull() {
            addCriterion("inventory_syn_interval_minute is null");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteIsNotNull() {
            addCriterion("inventory_syn_interval_minute is not null");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteEqualTo(Integer value) {
            addCriterion("inventory_syn_interval_minute =", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteNotEqualTo(Integer value) {
            addCriterion("inventory_syn_interval_minute <>", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteGreaterThan(Integer value) {
            addCriterion("inventory_syn_interval_minute >", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory_syn_interval_minute >=", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteLessThan(Integer value) {
            addCriterion("inventory_syn_interval_minute <", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("inventory_syn_interval_minute <=", value, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteIn(List<Integer> values) {
            addCriterion("inventory_syn_interval_minute in", values, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteNotIn(List<Integer> values) {
            addCriterion("inventory_syn_interval_minute not in", values, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteBetween(Integer value1, Integer value2) {
            addCriterion("inventory_syn_interval_minute between", value1, value2, "inventorySynIntervalMinute");
            return (Criteria) this;
        }

        public Criteria andInventorySynIntervalMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory_syn_interval_minute not between", value1, value2, "inventorySynIntervalMinute");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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