package com.maizi.demo3.proxy;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/19 21:27
 */
public class JdkProxyUtil {

    /**
     * 获取代理类对象
     *
     * @param object 需要代理的对象
     * @return
     */
    public static @NotNull Object getJdkProxyInstance(Object object) {

        ////方式1 java8lambda表达式声明接口
        //InvocationHandler handler = (proxy, method, args) -> {
        //    System.out.println("在方法之前执行....");
        //    final Object invoke = method.invoke(o, args);
        //    System.out.println("在方法之前后....");
        //    return invoke;
        //};

        //方式2 实现接口
        MyInvocationHandler handler = new MyInvocationHandler(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}

