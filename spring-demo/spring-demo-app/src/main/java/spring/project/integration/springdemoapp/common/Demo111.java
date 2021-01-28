package spring.project.integration.springdemoapp.common;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.project.integration.springdemoapp.common.config.DemoConfig;
import spring.project.integration.springdemoapp.common.listener.EventPublisher;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:01 2020/4/28
 */
@Slf4j
public class Demo111 {

    public static void main(String[] args) {
//        method1();
        method3();
    }

    public static void method1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
        EventPublisher publisher = applicationContext.getBean(EventPublisher.class);
        publisher.publish();

    }

    public static void method() throws InterruptedException {
        int messageSize = 1000000;
        int threadSize = 50;
        final int everySize = messageSize / threadSize;
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        long startTime = System.currentTimeMillis();
        for (int ts = 0; ts < threadSize; ts++) {
            new Thread(() -> {
                    for (int es = 0; es < everySize; es++) {
                        log.info("========info");
                    }
                    countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        log.info("logback:messageSize = " + messageSize + " ,threadSize = " + threadSize + " ,costTime = " + (endTime - startTime) + "ms");
    }

    @Data
    static class App {
        private String name;
    }


    public static void method3() {
        //创建集合 使用工厂方法
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        //集合转换 泛型类型转换
        List<Integer> integerList = Lists.transform(list, Integer::valueOf);










    }

}
