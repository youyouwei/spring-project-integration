package spring.project.integration.springdemoapp.service.impl;

import org.springframework.stereotype.Service;
import spring.project.integration.springdemoapp.domain.base.Order;
import spring.project.integration.springdemoapp.service.OrderService;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:39 2020/4/24
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setDesc("phone");
        return order;
    }
}
