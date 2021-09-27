package com.sky.ddt.common.annotation;

/**
 * @author sky
 * @Description NotLessThanZeroValidator
 * @date 2021/9/24 20:26
 */

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotLessThanZeroValidator implements ConstraintValidator<NotLessThanZero, Object> {

    @Override
    public void initialize(NotLessThanZero notLessThanZero) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        if (value instanceof Number) {
            if (((Number) value).intValue() > 0) {
                return true;
            }
        }
        return false;
    }

}