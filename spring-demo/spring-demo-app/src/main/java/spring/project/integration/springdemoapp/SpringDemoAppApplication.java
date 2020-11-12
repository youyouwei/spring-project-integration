package spring.project.integration.springdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.project.integration.springlogoperate.EnableLogOperate;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:05 2020/4/24
 */
@SpringBootApplication
@EnableLogOperate
public class SpringDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoAppApplication.class, args);
    }



}
