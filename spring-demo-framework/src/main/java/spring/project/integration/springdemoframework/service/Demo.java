package spring.project.integration.springdemoframework.service;

import spring.project.integration.springdemoframework.service.convert.UserMapper;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:10 2020/7/8
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(UserMapper.INSTANCE.getName());
    }
}


