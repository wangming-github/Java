package com.maizi.demo6.aop.role.check.annotation;

import java.lang.annotation.*;

/**
 * Aop + 自定义注解@MyLog 实现日志记录
 *
 * @author maizi
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value() default "";
}
