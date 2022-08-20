package com.maizi.demo4.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 21:25
 */

@Aspect
@Slf4j
@Configuration
public class UserServiceProxy {

    /**
     * 切入点 com.maizi.demo4.springboot.aop.service.UserService下所有方法
     */
    //@Pointcut(value = "execution(public * com.maizi.demo4.springboot.aop.service.UserService.*(..))")
    //等同于
    @Pointcut("within(com.maizi.demo4.aop.service.UserService)")
    public void userServicePointcut() {
    }

    @Around(value = "userServicePointcut()", argNames = "proceedingJoinPoint")
    public String userServiceAfter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around 环绕之前.........");
        proceedingJoinPoint.proceed();
        System.out.println("Around 环绕之后.........");
        return "Before";
    }

    @Before("userServicePointcut()")
    public String userServiceBefore(JoinPoint joinPoint) {
        System.out.println("Before 正在执行的目标方法是: " + joinPoint.getSignature().getName());
        return "Before";
    }


    @After("userServicePointcut()")
    public String userServiceAfter(JoinPoint joinPoint) {

        System.out.println("After 正在执行的目标方法是: " + joinPoint.getSignature().getName());
        return "Before";
    }


}
