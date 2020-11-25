package spring.project.integration.springdemoscenario.config;

import org.springframework.aop.SpringProxy;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:30 2020/11/20
 */
public interface PersonService extends SpringProxy {
    void eat();
}
