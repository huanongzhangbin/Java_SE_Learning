package com.zhangbin;

import com.zhangbin.component.AsyncDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@SpringBootApplication
public class ThreadAsyncApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConfigurableApplicationContext context=  SpringApplication.run(ThreadAsyncApplication.class, args);
        AsyncDemo asyncDemo = context.getBean(AsyncDemo.class);
         log.info(new Date()+"ThreadMain--------------------"+Thread.currentThread().getName());
        asyncDemo.asyncAysnc1();


        /**
         * 如果不指定线程池，只使用@Async注解，那么就会每次都新开一个线程来执行方法，
         *
         */
        for(int i=0;i<20;i++){
            asyncDemo.asyncAysnc1();
            Future<Integer> res= asyncDemo.asyncAysnc2(i);
        }

        //防止主进程立即运行完毕，延迟10秒退出主进程
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
