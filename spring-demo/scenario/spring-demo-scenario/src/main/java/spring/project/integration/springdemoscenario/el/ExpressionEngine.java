package spring.project.integration.springdemoscenario.el;


import spring.project.integration.springdemoscenario.el.context.ExpressionContext;

/**
 * @Description: expression execute engine
 * @Author: jiahuiyang
 * @Date: Created in 16:02 2020/12/29
 */
public interface ExpressionEngine {

    /**
     * evaluate by expression context
     */
    <V> V evaluate(ExpressionContext context, Class<V> type);

    /**
     * evaluate by expression string
     */
    <V> V evaluate(String expression, Class<V> type);


}
