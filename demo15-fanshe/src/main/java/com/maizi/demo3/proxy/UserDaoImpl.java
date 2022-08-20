package com.maizi.demo3.proxy;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/19 21:25
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        final int sum = a + b;
        System.out.println("add===========>" + sum);
        return sum;
    }

    @Override
    public String update(String id) {
        System.out.println("update=========>" + id);
        return id;
    }
}
