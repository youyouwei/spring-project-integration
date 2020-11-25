package spring.project.integration.springdemoscenario.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:  bean注入的条件类
 * @Author: jiahuiyang
 * @Date: Created in 16:22 2020/11/19
 */
public class FruitCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


        //match 返回true才能注入容器成功
        return true;
    }
}
