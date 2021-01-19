package spring.project.integration.springdemoscenario.el;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:08 2020/12/31
 */
@Component
public class ExpressionEvaluate {

    @Resource
    private ExpressionEngine claimExpressionEngine;

    public <T> T evaluate(String expression, Class<T> type) {
        return null;
    }

    public <T> T evaluate(String expression) {
        return null;
    }

    public <T> T evaluateOrDefault(String expression) {
        return null;
    }

    public <T> T evaluateOrException(String expression) {
        return null;
    }

}
