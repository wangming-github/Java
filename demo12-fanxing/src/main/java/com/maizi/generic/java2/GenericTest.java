package com.maizi.generic.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 * <p>
 * <p>
 * 2. 通配符的使用
 *
 * @author shkstart
 * @create 2019 下午 2:13
 */
public class GenericTest {

    /*
    1. 泛型在继承方面的体现

      虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。

       补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1() {

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //编译不通过
        // Date date = new Date();
        // str = date;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
        // list1 = list2;
        /*
         *  反证法：
         *  假设list1 = list2;
         *  list1.add(123);
         *  导致混入非String的数据。出错。
         */
        show(list1);
        show1(list2);

    }

    public void show1(List<String> list) {
    }

    public void show(List<Object> list) {
    }

    @Test
    public void test2() {

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }

            /*
            2. 通配符的使用
               通配符：?

               类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>


             */

    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
        // print(list1);
        // print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
        // list.add("DD");
        // list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);


    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用。
        ? extends A:
                G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

        ? super A:
                G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test4() {

        List<? extends Person> list1; //最大为Person  Student ===>Person --->Object
        List<? super Person> list2; //最小为Person    Student --->Person ===>Object

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        //list1 = list3;
        //list1 = list4;
        //list1 = list5; //X

        //list2 = list3; //X
        //list2 = list4;
        //list2 = list5;

        //读取数据：接收对象范围 extends A ~ ∞（Object）
        List<? extends Person> list001 = new ArrayList<Student>();
        Object var1 = list001.get(0); //extends A ~ ∞
        Person var2 = list001.get(0); //最大为Person以上父类接收
        //Student var3 = list1.get(0);//必须声明其子类接收报错，因为若结果是其父类

        //读取数据：接收对象范围 extends ∞（Object）
        List<? super Person> list002 = new ArrayList<Person>();
        Object obj = list002.get(0);//最大为Object
        //编译不通过
        //Person obj = list2.get(0);//最大为Object

        //写入数据：
        //编译不通过
        //list001.add(new Student());

        //编译通过
        //list2.add(new Person());
        //list2.add(new Student());

    }

}
