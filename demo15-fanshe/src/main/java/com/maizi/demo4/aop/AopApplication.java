package com.maizi.demo4.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringbootAOP将【某一个包下所有类的所有方法】作为切入点
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 21:22
 */
//@EnableAspectJAutoProxy Springboot无需配置 Spring则需添加
@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}
