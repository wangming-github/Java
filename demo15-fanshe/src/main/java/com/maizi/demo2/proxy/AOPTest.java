package com.maizi.demo2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface AOPHuman {
    String getBelief();

    void eat(String food);
}

//被代理类
class AOPSuperMan implements AOPHuman {
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}


class AOPHumanUtil {
    public void method1() {
        System.out.println("------方法1-----");
    }

    public void method2() {
        System.out.println("------方法2-----");
    }
}

//要想实现动态代理，需要解决的问题？
//问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
//问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
class AOPProxyFactoryUtil {

    /**
     * 调用此方法，返回一个代理类的对象。
     *
     * @param obj 被代理的对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxyInstance(Object obj) {

        //方式2
        InvocationHandler handler = (proxy, method, args) -> {
            AOPHumanUtil util = new AOPHumanUtil();
            util.method1();
            final Object invoke = method.invoke(obj, args);
            util.method2();
            return invoke;
        };

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

//方式1
class AOPInvocationHandler implements InvocationHandler {

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        AOPHumanUtil util = new AOPHumanUtil();
        util.method1();

        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return returnValue;
    }
}


/**
 * 动态代理与AOP
 * @author maizi
 */
public class AOPTest {

    public static void main(String[] args) {

        //这里使用Human接口类型去接受
        final AOPHuman human = (AOPHuman) AOPProxyFactoryUtil.getProxyInstance(new AOPSuperMan());
        //当通过代理类执行方法时，会自动调用被代理类同名方法
        human.eat("螺蛳粉");
        /*
         * ------方法1-----
         * 我喜欢吃螺蛳粉
         * ------方法2-----
         */
    }
}
