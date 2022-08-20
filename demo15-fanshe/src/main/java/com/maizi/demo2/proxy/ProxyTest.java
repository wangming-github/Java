package com.maizi.demo2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//要想实现动态代理，需要解决的问题？
//问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
//问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
class ProxyFactoryUtil {

    /**
     * 调用此方法，返回一个代理类的对象。
     *
     * @param obj 被代理的对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxyInstance(Object obj) {

        InvocationHandler handler = (proxy, method, args) -> method.invoke(obj, args);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

/**
 * 动态代理
 * @author maizi
 */
public class ProxyTest {

    public static void main(String[] args) {

        //这里使用Human接口类型去接受
        final Human human = (Human) ProxyFactoryUtil.getProxyInstance(new SuperMan());
        //当通过代理类执行方法时，会自动调用被代理类同名方法
        human.eat("螺蛳粉");
        System.out.println(human.getBelief());
        /*
         * 我喜欢吃螺蛳粉
         * I believe I can fly!
         */

        final ClothFactory clothFactory = (ClothFactory) ProxyFactoryUtil.getProxyInstance(new NikeClothFactory());
        clothFactory.produceCloth();
        /*
         * Nike工厂生产一批运动服
         */
    }
}
