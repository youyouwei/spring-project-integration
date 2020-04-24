package spring.project.integration.springdemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.integration.springdemoapp.common.enums.Result;
import spring.project.integration.springdemoapp.common.enums.ResultCode;
import spring.project.integration.springdemoapp.domain.base.Order;
import spring.project.integration.springdemoapp.service.OrderService;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:05 2020/4/24
 */
@RestController
@RequestMapping("/orders")
public class DemoController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    public Result<Order> getOrder(@PathVariable("id")Integer  id) {
        //对返回接口方法进行优化处理 主要处理业务 抽出包装返回对象单独处理
        //1、定义一个注解@ResponseResult，表示这个接口返回的值需要包装一下
        //2、拦截请求，判断此请求是否需要被@ResponseResult注解
        //3、核心步骤就是实现接口ResponseBodyAdvice和@ControllerAdvice，判断是否需要包装返回值，如果需要，就把Controller接口的返回值进行重写。
        if (id == null) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        Order order = orderService.getOrderById(id);
        return Result.success(order);
    }
}
