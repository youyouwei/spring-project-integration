package spring.project.integration.springdemoframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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
@Scope
public class SpringDemoAutoConfiguration {

    @Bean
    public IUserService getUser() {
        return new UserServiceImpl();
    }

}
