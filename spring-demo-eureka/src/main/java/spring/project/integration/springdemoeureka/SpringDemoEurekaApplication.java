package spring.project.integration.springdemoeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 注册中心
 * @description
 * @author jia
 * @date 2020/7/11
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@EnableEurekaServer
public class SpringDemoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoEurekaApplication.class, args);
    }

}
