package com.maizi.demo6.aop.role.check.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Override
    public void addLog(String str) {
        log.info("保存日志信息:{}", JSON.toJSONString(log));
    }

}
