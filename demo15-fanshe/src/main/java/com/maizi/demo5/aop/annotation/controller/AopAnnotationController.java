package com.maizi.demo5.aop.annotation.controller;

import com.maizi.demo5.aop.annotation.annotation.MyLoginPermiss;
import com.maizi.demo5.aop.annotation.service.UserAopAnnotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 23:38
 */

@Slf4j
@RestController
public class AopAnnotationController {


    @Resource
    private UserAopAnnotationService userService;

    @MyLoginPermiss
    @GetMapping("/aop/add")
    public String aopAnnotationApi1() {
        log.info("add Controller...");
        return userService.add();
    }

    @MyLoginPermiss
    @GetMapping("/aop/update")
    public String aopAnnotationApi2() {
        log.info("update Controller...");
        return userService.update();
    }

    @MyLoginPermiss
    @GetMapping("/aop/delete")
    public String aopAnnotationApi3() {
        log.info("delete Controller...");
        return userService.delete();
    }


    @GetMapping("/aop/find")
    public String aopAnnotationApi4() {
        log.info("find Controller...");
        return userService.find();
    }
}
