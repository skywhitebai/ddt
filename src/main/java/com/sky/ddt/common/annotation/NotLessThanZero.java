package com.sky.ddt.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sky
 * @Description NotLessThanZero
 * @date 2021/9/24 20:25
 */

@Constraint(validatedBy = {NotLessThanZeroValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLessThanZero {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}