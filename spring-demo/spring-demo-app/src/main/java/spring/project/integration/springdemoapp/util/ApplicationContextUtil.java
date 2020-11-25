package spring.project.integration.springdemoapp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import spring.project.integration.springdemoscenario.config.MyInterceptor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:39 2020/11/18
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    public static volatile ApplicationContext APPLICATION_CONTEXT;

    /**
     * 默认是0
     */
    public static AtomicInteger count = new AtomicInteger();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() throws InterruptedException {
        if (APPLICATION_CONTEXT != null) {
            return APPLICATION_CONTEXT;
        }
        TimeUnit.SECONDS.sleep(1);
        if (count.incrementAndGet() > 5) {
            throw new RuntimeException("application launch error!!!");
        }
        return getApplicationContext();
    }

    public static void checkApplicationContext() {
        Assert.notNull(ApplicationContextUtil.APPLICATION_CONTEXT, "SpringContestUtil applicationContext is null");
    }

    public static <T> T getBean(String beanName) {
        checkApplicationContext();
        return (T) APPLICATION_CONTEXT.getBean(beanName);
    }

    public static <T> T getBeanOrNull(String beanName) {
        checkApplicationContext();
        try {
            return (T) APPLICATION_CONTEXT.getBean(beanName);
        } catch (BeansException e) {
            return null;
        }
    }

    public static <T> T getBean(Class<T> tClass) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBean(tClass);
    }


}
