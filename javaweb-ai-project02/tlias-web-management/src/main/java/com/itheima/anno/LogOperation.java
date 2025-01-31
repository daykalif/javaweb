package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切入点表达式-Annotation
 */
@Target(ElementType.METHOD)    // @Target：表示该注解只能用于方法上
@Retention(RetentionPolicy.RUNTIME)    // @Retention：表示该注解在什么阶段起作用
public @interface LogOperation {
}
