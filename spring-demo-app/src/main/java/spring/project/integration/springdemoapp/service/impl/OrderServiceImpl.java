package spring.project.integration.springdemoapp.service.impl;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import spring.project.integration.springdemoapp.domain.base.Order;
import spring.project.integration.springdemoapp.service.IOrderService;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:39 2020/4/24
 */
@Service
@Data
public class OrderServiceImpl implements IOrderService, BeanNameAware {

    private String name;

    @Override
    public Order getOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setDesc("phone");
        return order;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
