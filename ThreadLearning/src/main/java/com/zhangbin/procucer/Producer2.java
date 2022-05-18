package com.zhangbin.procucer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class Producer2{

    @Resource(name = "concurrentHashMap1")
    ConcurrentHashMap concurrentHashMap1;

    public ConcurrentHashMap getConcurrentHashMap() {
        return concurrentHashMap1;
    }

    public void printSelf(){
        log.info(concurrentHashMap1.toString());
    }
}
