package  com.zhangbin.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncDemo {
    @Async("asyncServiceExecutor1")
    public void asyncAysnc1() {
       log.info("asyncAysnc1 start,"  + "," + new Date()+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        log.info("asyncAysnc1 Finished,"+ "," + new Date() + Thread.currentThread().getName() );

    }


    /**
     * 指定线程池，让该方法能够重复利用线程。否则每次新开一个线程
     * @param x
     * @return
     */
    @Async("asyncServiceExecutor2")
    public Future<Integer> asyncAysnc2(int x) {
       log.error("asyncAysnc2 start"  + "," + new Date()+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.error("asyncAysnc2 Finished,"+ "," + new Date() + Thread.currentThread().getName());
        return new AsyncResult<Integer>(x*x);
    }
}