package com.zhangbin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {


    /**
     * 取决于tomcat服务器的线程数
     */
    @GetMapping("/hello")
    public void hello(){
        log.info("---------"+Thread.currentThread().getName()+"------------");
    }
}
