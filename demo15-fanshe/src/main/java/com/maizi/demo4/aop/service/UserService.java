package com.maizi.demo4.aop.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 21:23
 */
@Service
public class UserService {

    public String gitName() {

        System.out.println("这里是原始方法MaiziSan");
        return "do UserService";
    }
}
