package com.zhangbin.procucer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;

@Slf4j
@Component
public class Producer1{

    /**
     *  @Resource(),默认是按照byName注入，如果指定name,只会根据name进行注入，如果没有指定name注入，先根据name查找bean,找不到在按byType注入
     * @Autowired只能根据byType注入，如果向搭配byName注入，可以搭配@Quilifer注解一起使用
     */
    @Resource()
    ConcurrentHashMap<String,String> concurrentHashMap;

    public void printSelf(){
        log.info(concurrentHashMap.toString());
    }

    public ConcurrentHashMap<String, String> getConcurrentHashMap() {
        return concurrentHashMap;
    }
}
