package com.wisely.highlight_spring4.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 组合注解
 * 组合后的注解会覆盖元注解的值
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1
@ComponentScan //2
public @interface WiselyConfiguration {

	// 覆盖@ComponentScan value参数
	String[] value() default {}; //3

}
