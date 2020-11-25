package spring.project.integration.springdemoframework.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 19:11 2020/11/19
 */
public class DemoAutoConfigurationCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //todo check 如果满足某些条件 bean组件才能添加成功

        return true;
    }
}
