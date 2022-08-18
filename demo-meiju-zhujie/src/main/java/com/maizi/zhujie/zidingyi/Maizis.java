package com.maizi.zhujie.zidingyi;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * JDK8之前如何重复使用注解
 *
 * @author maizi
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface Maizis {

    /**
     * 声明注解数组
     */
    Maizi[] value();
}
