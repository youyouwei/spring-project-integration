package spring.project.integration.springdemoscenario.config;

import org.springframework.context.annotation.*;
import spring.project.integration.springdemoscenario.config.aop.LogOperateAspect;

/**
 * @Description:  可以作为一个总的Java配置类组合，也可以在自己内部配置Bean
 * @Author: jiahuiyang
 * @Date: Created in 12:07 2020/11/19
 */


@Configuration
@ComponentScan
//Spring 需要启动AspectJ自动代理，另外设置proxyTargetClass=true或则vm变量proxy-target-class = "true"可以强制所有切面的动态代理使用CGLIB
@EnableAspectJAutoProxy
//组合java配置类
@Import({WebMvcConfig.class, TestConfig.class})
public class SpringDemoConfig {

    @Bean
    public PersonService person() {
        return new PersonServiceImpl();
    }

    @Bean
    public LogOperateAspect logOperateAspect() {
        return new LogOperateAspect();
    }


}
