package spring.project.integration.springdemoapp;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import spring.project.integration.springdemoscenario.config.SpringDemoConfig;
import spring.project.integration.springlogmodule.EnableLogOperate;

/**
 * @Description:
 * ApplicationRunner 或则 CommandLineRunner 都是容器启动完成后执行run方法，用于处理一些附件功能，区别主要是run方法入参不同。如读取文件配置，数据库连接等
 * @Author: jiahuiyang
 * @Date: Created in 12:05 2020/4/24
 */
//排除SpringBoot自动配置会引入的Configuration Java配置类
@SpringBootApplication(scanBasePackages = {"spring.project.integration"},exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
//引入三方或则二方包中的Java配置类
@EnableLogOperate
//也可以直接通过@Import引入三方或则二方包的Java配置类
@Import(SpringDemoConfig.class)
public class SpringDemoAppApplication implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoAppApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        this.getClass().getName();

    }
}
