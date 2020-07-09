package spring.project.integration.springdemoapp.common.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:08 2020/7/9
 */
@Component
public class EventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void publish() {
        if (context == null) {
            throw new RuntimeException("Application context is not init!");
        }
        context.publishEvent(new SoldOutEvent(this));
    }

}
