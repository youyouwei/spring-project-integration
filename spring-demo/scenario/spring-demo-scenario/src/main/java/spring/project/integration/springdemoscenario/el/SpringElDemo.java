package spring.project.integration.springdemoscenario.el;

import lombok.Data;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Description: spring el demo
 *
    Type	Operators
    Arithmetic	+, -, *, /, %, ^, div, mod
    Relational	<, >, ==, !=, <=, >=, lt, gt, eq, ne, le, ge
    Logical	and, or, not, &&, ||, !
    Conditional	?:
    Regex	matches
 *
 *
 * spring el 每次执行parseExpression都会创建一个 SpelExpression
 * SpelExpression  getValue方法中 compiledAst属性 会执行 compile 编译表达式类
 * compile 会判断每次是否有已编译的方法
 *
 * InternalSpelExpressionParse 通过eatXXX 解析不同类型的表达式，然后调用对应的表达式处理类
 *
 * 注：
 * spring el 不支持位操作
 *
 * 主要流程 SpelExpressionParser ->
 *
 * @Author: jiahuiyang
 * @Date: Created in 11:37 2020/12/29
 */
public class SpringElDemo {

    public static void main(String[] args) {


        claimElDemo();



    }


    public static void claimElDemo() {
        ExpressionEngine engine = new ClaimExpressionEngine();

//        System.out.println(engine.evaluate("(100>99) and (1==1)", Boolean.class));
//
//        System.out.println(engine.evaluate("(0.99*100+0.001)", BigDecimal.class));
//        System.out.println(engine.evaluate("(0.99*100+0.001)", Double.class));
//        System.out.println(engine.evaluate("(0.06+0.01)", Double.class));

//        System.out.println(engine.evaluate("(0.06+0.01)", BigDecimal.class));

        System.out.println(engine.evaluate("new java.math.BigDecimal('0.06') + new java.math.BigDecimal('0.01')", String.class));


    }


    public static void elDemo() {
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("'T' eq 'T'");



        System.out.println(expression.getValue(Boolean.class));


        System.out.println(parser.parseExpression("1+1").getValue());
        System.out.println(parser.parseExpression("(1+1)*2").getValue());
        System.out.println(parser.parseExpression("((1+1)*2)+1").getValue());
        System.out.println(parser.parseExpression("(((1+1)*2)+1)%2").getValue());
        System.out.println(parser.parseExpression("1>2").getValue());
        System.out.println(parser.parseExpression("1<2 and 2<1").getValue());
        //多条件处理
        System.out.println(parser.parseExpression("(1<2 and 2<1) or (1==1)").getValue());
        System.out.println(parser.parseExpression("true and true and true").getValue());








        Inventor inventor = new Inventor();
        inventor.setName("tom");
        inventor.setId(1L);
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(inventor);
        context.setVariable("value", true);
        System.out.println(parser.parseExpression("#value and (1==1)").getValue(context));


        System.out.println(parser.parseExpression("name").getValue(context, String.class));

        System.out.println(parser.parseExpression("name").getValue(inventor));

        System.out.println(parser.parseExpression("name eq 'tom'").getValue(inventor));
    }

    public static void method() {
        if (true || true || false) {

        }

        int i;

        System.out.println(i = 1);



    }

    @Data
    static class Inventor {

        private String name;

        private Long id;



    }

}
