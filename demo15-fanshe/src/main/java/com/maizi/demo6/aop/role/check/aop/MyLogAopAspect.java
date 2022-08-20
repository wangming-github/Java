package com.maizi.demo6.aop.role.check.aop;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 03:23
 */
@Aspect
@Slf4j
@Component
public class MyLogAopAspect {


    private static final String LINE_SEPARATOR = System.lineSeparator();


    /**
     * 日志打印切入点controller包下公开所有方法
     */
    @Pointcut("execution(public  * com.maizi.demo6.aop.role.check.controller.*.*(..))")
    public void pointcut() {
    }


    @Before("pointcut()")
    public void doBefore(JoinPoint point) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        final String roleValue = AspectUtil.getAspectRoleValue(point); // 获取自定义注解@MyOperationLog
        // 请求相关信息
        log.info(LINE_SEPARATOR);
        log.info("========================== START ==========================");
        log.info("请求IP         : {}", request.getRemoteAddr());
        log.info("请求地址        : {}", request.getRequestURL());
        log.info("请求方式        : {}", request.getMethod());
        log.info("类名#方法名     : {}#{}()", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
        log.info("方法参数列表     : {}", JSON.toJSONString(point.getArgs()));
        log.info("注解角色信息     : {}", roleValue);
        log.info("请求角色信息     : {}", request.getParameter("role"));
    }


    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        TimeInterval timer = DateUtil.timer();
        Object result = proceedingJoinPoint.proceed();  // 执行切入点
        log.info("方式2 返回值为：{}", JSON.toJSONString(result)); // 出参
        log.info("业务花费时间:{} ms", timer.interval());  // 执行耗时
        log.info("========================== END ==========================");
        log.info(LINE_SEPARATOR);
        return result;
    }

    /**
     * 另一种获取方法业务返回的方式
     */
    @AfterReturning(value = "pointcut()", returning = "returnValue")
    public void doAfterReturning(JoinPoint point, Object returnValue) {
        log.info("方式1 返回值为：{}", JSON.toJSONString(returnValue));
    }


}
