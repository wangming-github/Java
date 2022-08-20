package com.maizi.demo6.aop.role.check.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/21 01:37
 */
@Service
public class AopRoleCheckService {


    public String find() {
        return JSON.toJSONString("OK");
    }


    public String list() {
        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> dataMapOne = new HashMap<>();
        dataMapOne.put("name", "张三");
        dataMapOne.put("age", 25);
        dataMapOne.put("sex", 0);

        Map<String, Object> dataMapTwo = new HashMap<>();
        dataMapTwo.put("name", "李四");
        dataMapTwo.put("age", 23);
        dataMapTwo.put("sex", 1);

        mapList.add(dataMapOne);
        mapList.add(dataMapTwo);
        return JSON.toJSONString(mapList);
    }
}
