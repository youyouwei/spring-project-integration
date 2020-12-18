package spring.project.integration.springdemoapp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Description: 获取spring 容器
 * @Author: jiahuiyang
 * @Date: Created in 17:39 2020/11/18
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        Assert.notNull(applicationContext, "SpringApplicationContext applicationContext is null");
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public <T> T getBeanOrNull(String beanName) {
        return applicationContext.containsBean(beanName) ? (T) applicationContext.getBean(beanName) : null;
    }
}