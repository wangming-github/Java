package com.maizi.demo6.aop.role.check.controller;

import com.maizi.demo6.aop.role.check.annotation.MyLog;
import com.maizi.demo6.aop.role.check.annotation.MyRole;
import com.maizi.demo6.aop.role.check.service.AopRoleCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 01:36
 */

@Slf4j
@RestController
public class AopRoleCheckController {


    @Resource
    AopRoleCheckService service;


    /**
     * http://localhost:8080/log/123
     * http://localhost:8080/log/abc
     */
    @GetMapping("/log/{content}")
    public String list1(@PathVariable("content") String log) {
        return service.list();
    }


    /**
     * http://localhost:8080/find?role=user OK
     * http://localhost:8080/find 你的请求信息中没有包含角色信息
     * http://localhost:8080/find?role=user1  你的角色不能访问此方法
     * http://localhost:8080/find?role=admin 你的角色不能访问此方法
     */
    @MyRole("user")
    @GetMapping("/find")
    public String find2() {
        return service.find();
    }


    /**
     * http://localhost:8080/delete?role=admin OK
     * http://localhost:8080/delete 你的请求信息中没有包含角色信息
     * http://localhost:8080/delete?role=user 你的角色不能访问此方法
     * http://localhost:8080/delete?role=admin12  你的角色不能访问此方法
     */
    @MyRole(value = "admin")
    @GetMapping("/delete")
    public String find3() {
        return service.find();
    }

}
