package com.maizi.demo5.aop.annotation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/20 23:39
 */


@Slf4j
@Service
public class UserAopAnnotationService {

    public String find() {
        log.info("find .....");
        return "find";
    }


    public String add() {
        log.info("add .....");
        return "add";
    }


    public String delete() {
        log.info("delete .....");
        return "delete";
    }

    public String update() {
        log.info("update .....");
        return "update";
    }
}
