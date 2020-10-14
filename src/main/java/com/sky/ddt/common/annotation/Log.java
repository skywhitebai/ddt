package com.sky.ddt.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 操作描述
     */
    String value() default "";
}
