package com.sky.ddt.common.constant;

import lombok.Getter;

public class ShopConstant {

    public static final String USER_NO_SHOP_RIGHT ="用户没有店铺操作权限" ;
    public static final String LOGIN_TOKEN_EMPTY = "用户LoginToken为空";
    public static final String USER_HAS_NO_SHOP = "用户没有店铺";
    public static final String CLIENT_IS_EXISTS_OTHER_SHOP = "客户端已登录过其他店铺，不允许当前店铺登录";
    public static final String USER_ID_EMPTY = "用户id不能为空";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String SELLER_ID_EXIST = "卖家id已存在";
    public static final String SHOP_MARKETPLACE_ID_EXIST = "商城编号已存在";
    public static final String SHOP_NAME_EXIST = "店铺名称已存在";
    public static final String MAC_ADDRESS_MUST_EQUAL = "店铺不允许换电脑登录";
    public static final String SHOP_ID_EMPTY = "店铺id不能为空";
    public static final String USER_ID_EXIST = "用户已存在，请选择其他用户";
    public static final String TYPE_ERRO ="类型错误" ;
    public static final String TYPE_NOT_ALLOW_CHANGE ="类型不允许修改，请联系管理员" ;
    public static final String SELLER_ID_EMPTY ="卖家ID不能为空" ;
    public static final String SHOP_MARKETPLACE_ID_EMPTY= "商城编号不能为空";

    @Getter
    public enum TypeEnum {
        SHOP(1, "店铺"),
        WAREHOUSE(2, "仓库"),;
        Integer type;
        String TypeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            TypeName = typeName;
        }

        public static boolean contains(Integer type) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.type.equals(type)) {
                    return true;
                }
            }
            return false;
        }
    }
}
