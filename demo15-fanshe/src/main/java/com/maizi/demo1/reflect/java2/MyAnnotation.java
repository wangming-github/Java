package com.maizi.demo1.reflect.java2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author shkstart
 * @create 2019 下午 3:19
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)//只有在运行时，类才能加载到内存中，通过反射获取运行时对象
public @interface MyAnnotation {
    String value() default "hello";

}
