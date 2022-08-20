package com.maizi.demo1.reflect.java1;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/18 01:58
 */
public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test1() {
        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);
        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
        //调用公共方法
        p1.show();
        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }


    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {

        //0.获取Class反射源头
        Class clazz = Person.class;

        //1.通过反射，创建Person类的对象
        final Constructor constructor = clazz.getConstructor(String.class, int.class);
        final Object maizi = constructor.newInstance("Maizi", 25);
        Person person = (Person) maizi;
        System.out.println(person);

        //2.通过反射，调用对象指定的属性、方法
        //修改age
        final Field age = clazz.getDeclaredField("age");
        age.set(person, 20);
        //修改name报错 name为private
        //final Field name = clazz.getDeclaredField("name");
        //name.set(person, "Maizi-Field");
        System.out.println(person);

        //方法
        final Method show = clazz.getMethod("show");//方法名，参数类型列表
        show.invoke(person);//对象名，参数列表

        //私有构造方法
        final Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);//Declared adj. 正式宣布的，公开声明的
        declaredConstructor.setAccessible(true); //Accessible adj. 可到达的，可进入的；
        final Person instance1 = (Person) declaredConstructor.newInstance("私有构造方法-麦子酱");
        System.out.println(instance1);

        //私有属性
        final Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);//Accessible adj. 可到达的，可进入的；
        name.set(person, "私有的属性-麦子酱");
        System.out.println(person);

        //私有方法：
        final Method declaredMethod = clazz.getDeclaredMethod("showNation", String.class);//Declared adj. 正式宣布的，公开声明的
        declaredMethod.setAccessible(true);//Accessible adj. 可到达的，可进入的；
        final Object invoke = declaredMethod.invoke(person, "中国");
        System.out.println((String) invoke);
    }

    //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
    //建议：直接new的方式。
    //什么时候会使用：反射的方式。 反射的特征：动态性
    //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {

        //方式一：调用运行时类的属性：.class
        final Class<Person> clazz1 = Person.class;
        System.out.println("方式一:" + clazz1);
        //方式一:class com.maizi.Person

        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        final Class<? extends Person> clazz2 = person.getClass();
        System.out.println("方式二:" + clazz2);
        //方式二:class com.maizi.Person

        //方式三：调用Class的静态方法：forName(String classPath)
        final Class<?> clazz3 = Class.forName("com.maizi.java1.Person");
        final Class<?> clazz4 = Class.forName("java.lang.reflect.Array");
        System.out.println("方式三:" + clazz4);
        //方式三:class java.lang.reflect.Array

        //判断下他们是否都是同一个对象
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz2 == clazz3);//true

        //方式四：使用类的加载器：ClassLoader
        final ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        final Class<?> clazz5 = classLoader.loadClass("com.maizi.java1.Person");
        System.out.println("方式四:" + clazz5);
        //方式四:class com.maizi.Person
        System.out.println(clazz2 == clazz5);//true

    }

    //Class实例可以是哪些结构的说明：
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}
