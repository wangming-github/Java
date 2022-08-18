package com.maizi.zhujie.zidingyi;


/**
 * @author maizi
 */
@Maizis({@Maizi(value = "A"), @Maizi(value = "B")})
public class MyPerson {

    private String name;
    private int age;

    public MyPerson() {
    }


    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Maizi(value = "小张")
    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}