package com.maizi.demo6.aop.role.check.aop;

import com.alibaba.fastjson.JSON;
import com.maizi.demo6.aop.role.check.annotation.MyRole;
import com.maizi.demo6.aop.role.check.service.RedisTokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 01:37
 */

@Slf4j
@Component
@Aspect
public class MyRoleAopAspect {

    @Resource
    RedisTokenService redis;

    @Pointcut("@annotation(com.maizi.demo6.aop.role.check.annotation.MyRole)")
    public void roleCheck() {
    }


    /**
     * 环绕增强，验证权限 非admin角色禁止访问
     */
    @Around(value = "roleCheck()&& @annotation(sysRole)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, MyRole sysRole) throws Throwable {


        final String role = redis.getRole();
        if (role == null) {
            log.info("你的请求信息中没有包含角色信息!!!");
            return JSON.toJSONString("{message:你的请求信息中没有包含角色信息!!!, code:403}");
        }


        if (sysRole == null) {
            log.info("你没有配置此方法所需权限...");
            return JSON.toJSONString("{message:你没有配置此方法所需权限, code:403}");
        }

        //如果传的参数值不是当前方法所需权限，则驳回请求
        if ((!role.equals(sysRole.value()))) {
            log.info("无权访问此方法...");
            return JSON.toJSONString("{message:你的角色不能访问此方法, code:403}");
        }

        log.info("可以访问此方法...");
        return proceedingJoinPoint.proceed();
    }
}
