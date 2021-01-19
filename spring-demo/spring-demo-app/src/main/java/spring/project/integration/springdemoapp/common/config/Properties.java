package spring.project.integration.springdemoapp.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Description:  yml配置文件通过Map读取
 * @Author: jiahuiyang
 * @Date: Created in 19:48 2021/1/18
 */
@ConfigurationProperties(prefix = "user-map")
@Data
@Configuration(value = "demoProperties" )
public class Properties {
    private Map<String,User> maps;
}

@Data
class User {
    private String username;

    private String password;

    private Integer nodeId;

    private String nodeName;
}
