package com.maizi.demo5.aop.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringbootAOP将【注解】作为切入点
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 23:36
 */
@SpringBootApplication
public class AopAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopAnnotationApplication.class, args);
    }
}
