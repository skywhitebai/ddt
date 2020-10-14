package com.sky.ddt.common.annotation;

import java.lang.annotation.*;

/**
 * @author baixueping
 * @description 功能权限校验
 * @date 2019/8/7 9:42
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RightAnnotation {
    String value() default "";
}
