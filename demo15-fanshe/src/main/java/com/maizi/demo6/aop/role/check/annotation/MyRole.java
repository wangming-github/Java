package com.maizi.demo6.aop.role.check.annotation;

import java.lang.annotation.*;

/**
 * Aop + 自定义注解@MyRole 实现权限限定
 * 在需要鉴权的方法上添加此注解，当Redis中无此用户的配置将无法访问
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 01:39
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MyRole {
    //角色名称（示例，不按照RBAC模型设计）
    String value() default "user";
}
