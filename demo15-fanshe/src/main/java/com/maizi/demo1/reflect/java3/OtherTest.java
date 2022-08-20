package com.maizi.demo1.reflect.java3;

import com.maizi.demo1.reflect.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author shkstart
 * @create 2019 下午 4:19
 */
public class OtherTest {


    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        final Constructor<?>[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        //public com.maizi.java2.Person()

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);
        //public com.maizi.java2.Person()
        //private com.maizi.java2.Person(java.lang.String)
        //com.maizi.java2.Person(java.lang.String,int)
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //class com.maizi.java2.Creature
    }

    /*
    获取运行时类的带泛型的父类

     */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //com.maizi.java2.Creature<java.lang.String>
    }

    /*
    获取运行时类的带泛型的父类的泛型
    代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        //System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class<?>) actualTypeArguments[0]).getName());
        //java.lang.String

    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5() {
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
        //interface java.lang.Comparable
        //interface com.maizi.java2.MyInterface

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        Arrays.stream(interfaces1).forEach(System.out::println);
        //interface java.io.Serializable
    }

    /*
        获取运行时类所在的包

     */
    @Test
    public void test6() {
        Class<Person> clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
        获取运行时类声明的注解

     */
    @Test
    public void test7() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
        //@com.maizi.java2.MyAnnotation(value=hi)

    }

}
