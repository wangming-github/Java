package com.maizi.demo4.aop.controller;

import com.maizi.demo4.aop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 21:55
 */


@RestController
public class AopController {


    @Resource
    UserService userService;

    @GetMapping("/aop")
    public String testAop() {
        return userService.gitName();
    }
}
