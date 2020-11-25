package spring.project.integration.springdemoscenario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.project.integration.springdemoscenario.Demo;

/**
 * @Description: Configuration Java配置类默认扫描路径是本包路径下的bean，也可以设置ComponentScan来配置需要扫描的包路径，或则是直接在类中定义配置@Bean
 * @Author: jiahuiyang
 * @Date: Created in 12:18 2020/11/19
 */
@Configuration
public class TestConfig {

    @Bean
    public Demo demo() {
        return new Demo();
    }

}
