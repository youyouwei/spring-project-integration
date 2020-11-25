package spring.project.integration.springdemoscenario.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:07 2020/11/19
 */
// bean 注入时的条件控制
@Conditional(FruitCondition.class)
@Component
@Data
public class FruitProperties {

    @Value("${fruit.name}")
    private String name;

}
