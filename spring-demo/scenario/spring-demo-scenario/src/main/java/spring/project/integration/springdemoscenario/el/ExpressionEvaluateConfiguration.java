package spring.project.integration.springdemoscenario.el;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:17 2020/12/31
 */
@Configuration
public class ExpressionEvaluateConfiguration {

    @Bean
    public ExpressionEngine expressionEngine() {
        return new ClaimExpressionEngine();
    }



}
