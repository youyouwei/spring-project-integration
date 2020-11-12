package spring.project.integration.springdemoframework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.project.integration.springdemoframework.service.convert.UserMapper;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:10 2020/7/8
 */
public class Demo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        LOGGER.info(UserMapper.INSTANCE.getName());
    }
}


