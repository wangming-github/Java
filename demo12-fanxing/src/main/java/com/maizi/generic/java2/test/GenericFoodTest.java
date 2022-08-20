package com.maizi.generic.java2.test;

import com.maizi.generic.java2.Person;
import com.maizi.generic.java2.Student;
import org.junit.Test;

import java.util.ArrayList;
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
public class GenericFoodTest {


    @Test
    public void test() {

        List<? extends Fruit> maxFrult; //最大为Fruit
        List<? super Fruit> minFrult; //最小为Fruit

        List<Object> object = new ArrayList<>();
        List<Food> food = new ArrayList<>();
        List<Fruit> fruit = new ArrayList<>();
        List<Banana> banana = new ArrayList<>();
        List<Apple> apple = new ArrayList<>();
        List<RedApple> redApple = new ArrayList<>();
        List<GreenApple> greenApple = new ArrayList<>();

        //====================<? extends Fruit>赋值=========================
        //<? extends Fruit>赋值 可以放下最小到最大（Fruit）之间
        maxFrult = greenApple;//最小
        maxFrult = redApple;
        maxFrult = apple;
        maxFrult = banana;
        maxFrult = fruit;//最大
        //maxFrult = food;//X
        //maxFrult = object;//X

        //====================<? super Fruit>赋值=========================
        //<? super Fruit> 可以放下最小（Fruit）到最大（object）之间
        //minFrult = greenApple;//X
        //minFrult = redApple;//X
        //minFrult = apple;//X
        //minFrult = banana;//X
        minFrult = fruit;//最小
        minFrult = food;
        minFrult = object;//最大

        //======================<? extends Fruit>接收=======================
        maxFrult = greenApple;//最小
        maxFrult = redApple;
        maxFrult = apple;
        maxFrult = banana;
        maxFrult = fruit;//最大
        //接收对象范围: 上面任意一个子类的父类才能将上面这些子类囊括其中
        Object fruit0 = maxFrult.get(0);
        Food fruit1 = maxFrult.get(0);
        Fruit fruit2 = maxFrult.get(0);
        //Banana fruit3 = maxFrult.get(0);//X
        //Apple fruit4 = maxFrult.get(0);//X
        //RedApple fruit5 = maxFrult.get(0);//X

        //====================<? super Fruit>接收=========================
        //minFrult = greenApple;//X
        //minFrult = redApple;//X
        //minFrult = apple;//X
        //minFrult = banana;//X
        minFrult = fruit;//最小
        minFrult = food;
        minFrult = object;//最大
        //<? super Fruit>
        // 接收对象范围: 上面任意一个子类的父类才能将上面这些子类囊括其中,只有Object
        Object fruit_0 = minFrult.get(0);
        //Food fruit_1 = minFrult.get(0);//X
        //Fruit fruit_2 = minFrult.get(0);//X
        //Banana fruit_3 = minFrult.get(0);//X

        //====================<? extends Fruit>添加=========================
        // 对于List<?>就不能向其内部添加数据。除了NULL。
        // 添加要是所有子类的子类即最小子类，这样任意一个父类才能接收它。
        maxFrult = greenApple;//最小
        maxFrult = redApple;
        maxFrult = apple;
        maxFrult = banana;
        maxFrult = fruit;//最大
        //接收对象范围: 上面任意一个子类的父类才能将上面这些子类囊括其中,但是最小子类未知。
        //maxFrult.add(new Food());//X
        //maxFrult.add(new fruit());//X
        //maxFrult.add(new apple());//X
        //maxFrult.add(new greenApple());//X
        //maxFrult.add(new greenApple());//X
        maxFrult.add(null);


        //====================<? super Fruit> 添加=========================
        //最小子类的任意子类即可
        minFrult = fruit;//最小
        minFrult = food;
        minFrult = object;//最大
        //minFrult.add(new Food());//X
        //minFrult.add(new Meat());//X
        //minFrult.add(new Pork());//X
        minFrult.add(new Fruit());//定义的最小子类已知。
        minFrult.add(new Banana());
        minFrult.add(new Apple());
        minFrult.add(new RedApple());
        minFrult.add(new GreenApple());
        minFrult.add(null);

    }

}
