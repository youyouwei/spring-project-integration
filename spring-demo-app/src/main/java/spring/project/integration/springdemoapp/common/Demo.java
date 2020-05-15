package spring.project.integration.springdemoapp.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:01 2020/4/28
 */
@Slf4j
public class Demo {
    public static void main(String[] args) throws InterruptedException {

        log.info("sss");

    }

    public static void method() throws InterruptedException {
        int messageSize = 1000000;
        int threadSize = 50;
        final int everySize = messageSize / threadSize;
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        long startTime = System.currentTimeMillis();
        for (int ts = 0; ts < threadSize; ts++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int es = 0; es < everySize; es++) {
                        log.info("========info");
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("logback:messageSize = " + messageSize + " ,threadSize = " + threadSize + " ,costTime = " + (endTime - startTime) + "ms");
    }

    @Data
    static class App {
        private String name;
    }


}
