package spring.project.integration.springdemoapp;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
import spring.project.integration.springdemoapp.common.config.Properties;
import spring.project.integration.springdemoscenario.config.SpringDemoConfig;
import spring.project.integration.springlogmodule.EnableLogOperate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

    //@Autowired是按byType自动注入  而@Resource默认是按照byName自动注入
    //构造注入只能通过@Autowired，不过spring4.0之后可以不用在构造函数中声明@Autowired注解
    //Spring5.0之后也支持方法或则构造函数入参标识@Autowired注解

    //@Resource 是JSR-250规范定义的注解 该规范中还有@PostConstruct和@PreDestroy两个注解
    //@Resource 中包含name和type两个属性，这两个属性如果都没设置或则都设置会优先通过name来获取，如果都没有设置就先找和属性名相同的bean name，否则找跟属性类型相同的bean type

    //@Autowired没有name和type属性，只有一个required属性默认是true，如果没必要传就设置false，否则启动过程中会报错
    //@Autowired如果需要按照name来注入bean，可以和Qualifier结合使用

    //@Resource如果注入为null容器启动会报错，@Autowired可以通过required来控制是否必须注入，默认是true


    //字段注入推荐使用@Resource因为@Autowired是通过type进行注入的，耦合比较大

    @Autowired
    private ApplicationContext context;

    @Resource(name = "demoProperties")
    private Properties properties;

   



    public static void main(String[] args) {
        SpringApplication.run(SpringDemoAppApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        this.getClass().getName();

    }
}
