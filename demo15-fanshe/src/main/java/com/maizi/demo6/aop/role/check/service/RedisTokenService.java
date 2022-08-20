package com.maizi.demo6.aop.role.check.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模拟从redis中获取用户角色信息
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 06:37
 */

@Service
public class RedisTokenService {


    public String getRole() {

        //Map<String, List<String>> DB = new HashMap<>();
        //DB.put("zhangsan", Arrays.asList("admin", "user"));
        //DB.put("lisi", Arrays.asList("user"));

        //先拿到Request请求体
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getParameter("role");


    }
}
