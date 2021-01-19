package spring.project.integration.springdemoscenario.el.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:20 2020/12/31
 */
@Data
@ConfigurationProperties(prefix = ExpressionProperties.EXPRESSION)
public class ExpressionProperties {

    public static final String EXPRESSION = "el";

    private Boolean enable;

    private String module;


}
