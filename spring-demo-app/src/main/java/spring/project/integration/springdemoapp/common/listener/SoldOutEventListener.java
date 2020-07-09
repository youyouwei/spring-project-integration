package spring.project.integration.springdemoapp.common.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 事件监听器 Listener
 * @Author: jiahuiyang
 * @Date: Created in 11:03 2020/7/9
 */
@Component
public class SoldOutEventListener implements ApplicationListener<SoldOutEvent>, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void onApplicationEvent(SoldOutEvent event) {
        //事件源通常是Publisher Publisher在发布的事件的时候把自己this当成事件源传输，事件源可以是任意一个普通对象
        System.out.println("SoldOutEvent事件触发，接收到事件源Source:" + event.getSource());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
