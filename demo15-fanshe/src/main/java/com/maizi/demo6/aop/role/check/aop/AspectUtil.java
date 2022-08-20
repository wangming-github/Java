package com.maizi.demo6.aop.role.check.aop;

import com.maizi.demo6.aop.role.check.annotation.MyRole;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 02:23
 */
@Slf4j
public class AspectUtil {


    /**
     * 功能描述:通过JoinPoint获取注解MyRoleAnnotation
     * <p>
     * 访问目标方法参数,有三种方法(实际有四种):
     * 1.joinPoint.getArgs():获取带参方法的参数
     * 2.joinPoint.getTarget():.获取他们的目标对象信息
     * 3.joinPoint.getSignature():(signature是信号,标识的意思):获取被增强的方法相关信息
     */
    public static MyRole getRoleCheckJoinPoint(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (null == method) {
            return null;
        }
        final MyRole annotation = method.getAnnotation(MyRole.class);

        log.info("通过JoinPoint获取注解MyRoleAnnotation:{}", annotation);
        return annotation;
    }

    /**
     * 获取注解@MyRole信息
     *
     * @param joinPoint joinPoint
     * @return 注解信息
     */
    public static String getAspectRoleValue(JoinPoint joinPoint) {
        StringBuilder value = new StringBuilder();
        String targetName = joinPoint.getTarget().getClass().getName();//获取代理类的全名
        String methodName = joinPoint.getSignature().getName();// 获取切入点方法名
        Object[] arguments = joinPoint.getArgs();// 获取切点方法入参列表
        try {
            Class<?> proxyClass = Class.forName(targetName);//根据全名创建代理类
            Method[] methods = proxyClass.getMethods();//获取代理类的所有方法列表
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {//方法名相同
                    Class<?>[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {//参数列表数量也相当
                        final MyRole myRole = method.getAnnotation(MyRole.class);
                        if (myRole != null) {
                            value.append(myRole.value());
                            break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return value.toString();
    }


    /**
     * 解析方法上注解中的值
     *
     * @param method method
     * @return 是空返回指定字符 不为空返回结果
     */
    public static String parseAnnotation(Method method) {

        final MyRole role = method.getAnnotation(MyRole.class);
        //采用Optional进行空值判断 是空返回指定字符 不为空返回结果
        final String s = Optional.ofNullable(role.value()).orElse("改注解没有注入数据");
        log.info("解析方法上注解中的权限:{}", s);
        return s;
    }


}
