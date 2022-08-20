package com.maizi.demo5.aop.annotation.annotation;

import java.lang.annotation.*;

/**
 * 作用在方法上，在运行时通过反射获取信息、将注解加到javadoc中、允许子类继承
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 23:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLoginPermiss {
}
