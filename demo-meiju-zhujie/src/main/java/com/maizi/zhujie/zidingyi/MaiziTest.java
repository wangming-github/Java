package com.maizi.zhujie.zidingyi;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/17 06:04
 */
public class MaiziTest {

    public static void main(String[] args) {
        MyPerson p = new MyStudent();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        @SuppressWarnings("unused") int num = 10;

        //System.out.println(num);

        @SuppressWarnings({"unused", "rawtypes"}) ArrayList list = new ArrayList();
    }


    /**
     * 获取类注解 测试@Inherited的继承性
     */
    @Test
    public void testGetAnnotation() {
        Class<MyStudent> clazz = MyStudent.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
