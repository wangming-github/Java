package com.maizi.demo3.proxy;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/19 21:36
 */
public class JdkProxyUserDaoTest {


    /**
     * 通过代理的方式对原对象进行增强
     */
    public static void main(String[] args) {
        final UserDaoImpl impl = new UserDaoImpl();
        //根据要增强的对象，创建出要增强对象的代理对象，用代理对象的接口类型接收
        final UserDao proxyInstance = (UserDao) JdkProxyUtil.getJdkProxyInstance(impl);
        proxyInstance.add(1, 2);
        System.out.println("==============================");
        proxyInstance.update("id=111");
    }
}
