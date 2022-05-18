package com.zhangbin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.concurrent.ConcurrentHashMap;


@Configuration
public class JarBeanConfig {

    /**
     * 向容器中注入concurrentHashMap对象，然后分别放在两个生产者中，让他们进行生产数据，并放入其中
     * @return
     */
    @Bean(name ="concurrentHashMap")
    public ConcurrentHashMap<String,String> concurrentHashMap(){
         ConcurrentHashMap<String,String> concurrentHashMap=  new ConcurrentHashMap<String,String>();
         concurrentHashMap.put("hello","hi");
         return concurrentHashMap;
    }

    /**
     * 主要是为了验证Autowired和@Resource注解
     * @return
     */
    @Bean(name ="concurrentHashMap1")
    public ConcurrentHashMap<String,String> concurrentHashMap1(){
        ConcurrentHashMap<String,String> concurrentHashMap=  new ConcurrentHashMap<String,String>();
        concurrentHashMap.put("hi","hello");
        return concurrentHashMap;
    }
}
