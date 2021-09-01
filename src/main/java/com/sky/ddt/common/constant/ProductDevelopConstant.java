package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author sky
 * @Description 产品开发静态类
 * @date 2021/9/1 22:43
 */
public class ProductDevelopConstant {
    @Getter
    public enum ProductDevelopStatusEnum {
        UNDER_DEVELOPMENT(1, "开发中"),
        DEVELOPMENT_COMPLETED(2, "开发完成"),
        CONFIRM_PRODUCTION(3, "确认生产"),
        DEVELOPMENT_FAILURE(4, "开发失败"),;
        Integer value;
        String label;

        ProductDevelopStatusEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }
        public static boolean contains(Integer value) {
            for (ProductDevelopConstant.ProductDevelopStatusEnum item : ProductDevelopConstant.ProductDevelopStatusEnum.values()) {
                if (item.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }
}
