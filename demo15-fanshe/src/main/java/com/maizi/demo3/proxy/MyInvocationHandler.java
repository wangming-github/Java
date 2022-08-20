package com.maizi.demo3.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/19 21:49
 */
public class MyInvocationHandler implements InvocationHandler {


    /**
     * 需要代理的对象
     */
    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在方法之前前面....");
        final Object invoke = method.invoke(object, args);
        System.out.println("在方法之前后面....");
        return invoke;
    }

    /**
     * 通过构造方法将需要代理的对象注入进来
     *
     * @param object 要代理的对象
     */
    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
