package spring.project.integration.springlogmodule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:31 2020/11/12
 */
@Configuration
public class LogOperateConfiguration {

    @Bean
    public LogOperateService logOperateService() {
        return new LogOperateService();
    }


}
