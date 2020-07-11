package spring.project.integration.springdemoapp.common.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 一个商品下架的事件
 * @Author: jiahuiyang
 * @Date: Created in 11:25 2020/5/19
 */
public class SoldOutEvent extends ApplicationEvent {

    public SoldOutEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "This is sold out.";
    }

}
