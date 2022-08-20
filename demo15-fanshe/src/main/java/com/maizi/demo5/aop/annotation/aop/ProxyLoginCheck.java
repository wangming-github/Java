package com.maizi.demo5.aop.annotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 23:41
 */


@Slf4j
@Aspect
@Component
public class ProxyLoginCheck {


    /**
     * 切入点：controller包下的每个类的每个方法
     */
    @Pointcut("within(com.maizi.demo5.aop.annotation.controller.*)")
    public void point() {
    }

    /**
     * 切入点：为自定义注解 @MyLoginAnnotation
     */
    @Pointcut("@annotation(com.maizi.demo5.aop.annotation.annotation.MyLoginPermiss)")
    public void pointAnnotation() {
    }


    /**
     * 凡是添加了注解@MyLoginAnnotation的地方都会执行此前置通知
     */
    @Before("pointAnnotation()")
    public String add() {
        log.info("通过session或者redis获取登录的用户token");
        log.info("通过token解析出用户id");
        log.info("再去查询是否有权限");
        return "add";
    }
}
