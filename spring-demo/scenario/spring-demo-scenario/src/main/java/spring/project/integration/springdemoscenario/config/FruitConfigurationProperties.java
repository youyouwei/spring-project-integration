package spring.project.integration.springdemoscenario.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 19:26 2020/11/19
 */
@Data
@ConfigurationProperties(prefix = FruitConfigurationProperties.FRUIT)
//需要注入到bean容器中才生效  或则通过@EnableConfigurationProperties加载到java配置类中，其中@Enablexxx 通常是和Import一起使用，可以跳过自动扫描直接加载对应的bean或则配置类
@Component
public class FruitConfigurationProperties {
    static final String FRUIT = "fruit";

    private String name;

    private String type;

}
