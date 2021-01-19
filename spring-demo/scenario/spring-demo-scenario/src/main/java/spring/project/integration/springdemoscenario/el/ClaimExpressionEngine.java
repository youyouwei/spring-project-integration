package spring.project.integration.springdemoscenario.el;


import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import spring.project.integration.springdemoscenario.el.context.ExpressionContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:42 2020/12/29
 */
public class ClaimExpressionEngine implements ExpressionEngine {



    @Override
    public <V> V evaluate(ExpressionContext context, Class<V> type) {
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(context.getExpression(), context.getParserContext()).getValue(context.getEvaluationContext(), type);
    }

    @Override
    public <V> V evaluate(String expression, Class<V> type) {
        return evaluate(ExpressionContext.builder().expression(expression).build(), type);
    }

}
