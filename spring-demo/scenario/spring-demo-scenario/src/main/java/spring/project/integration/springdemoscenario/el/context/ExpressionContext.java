package spring.project.integration.springdemoscenario.el.context;

import lombok.Builder;
import lombok.Getter;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:00 2020/12/30
 */
@Builder
@Getter
public class ExpressionContext {

    @NonNull
    private String expression;

    @Nullable
    private StandardEvaluationContext evaluationContext;

    @Nullable
    private ParserContext parserContext;

}
