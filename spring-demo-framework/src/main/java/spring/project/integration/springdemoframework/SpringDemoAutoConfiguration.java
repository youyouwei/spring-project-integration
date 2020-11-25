package spring.project.integration.springdemoframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.project.integration.springdemoframework.config.DemoAutoConfigurationCondition;
import spring.project.integration.springdemoframework.service.IUserService;
import spring.project.integration.springdemoframework.service.impl.UserServiceImpl;

/**
 * @Description:
 * @Import
 * 加载一个被@Configuration修饰的class。
 *
 * EnableAutoConfiguration注解中使用@Import(AutoConfigurationImportSelector.class)
 * 就是根据spring.factories加载对应的configuration类
 *
 * @Author: jiahuiyang
 * @Date: Created in 12:02 2020/5/29
 */
@Configuration
//@Conditional可以和 spring.factories中的EnableAutoConfiguration 结合使用，限制自动注入的条件，如必须要加载某些包或则其他bean注入成功才能完成自动配置
@Conditional(DemoAutoConfigurationCondition.class)
public class SpringDemoAutoConfiguration {

    @Bean
    public IUserService getUser() {
        return new UserServiceImpl();
    }

}
