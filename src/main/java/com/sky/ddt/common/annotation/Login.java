package com.sky.ddt.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

	/**
	 * 执行动作
	 * {@link Action}
	 */
	Action action() default Action.Normal;
	
}