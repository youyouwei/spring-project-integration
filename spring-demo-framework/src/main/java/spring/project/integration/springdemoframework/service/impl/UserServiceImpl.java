package spring.project.integration.springdemoframework.service.impl;

import spring.project.integration.springdemoframework.service.IUserService;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:24 2020/5/29
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void getUser() {
        System.out.println("get user=================");
    }
}
