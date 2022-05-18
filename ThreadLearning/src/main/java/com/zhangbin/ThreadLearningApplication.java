package com.zhangbin;


import com.zhangbin.procucer.Producer1;
import com.zhangbin.procucer.Producer2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class ThreadLearningApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run= SpringApplication.run(ThreadLearningApplication.class, args);
       Producer1 producer1= (Producer1) run.getBean("producer1");
        Producer2 producer2= (Producer2) run.getBean("producer2");
        producer1.printSelf();
        producer2.printSelf();

    }

}
