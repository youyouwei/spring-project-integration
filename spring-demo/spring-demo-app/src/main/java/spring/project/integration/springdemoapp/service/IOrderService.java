package spring.project.integration.springdemoapp.service;

import spring.project.integration.springdemoapp.domain.base.Order;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:34 2020/4/24
 */
public interface IOrderService {
    Order getOrderById(Integer id);

}
