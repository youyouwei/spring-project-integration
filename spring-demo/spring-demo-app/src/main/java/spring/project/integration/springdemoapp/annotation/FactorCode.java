package spring.project.integration.springdemoapp.annotation;

import java.lang.annotation.*;

/**
 * factor code
 * todo 在容器加载后检查注解value是否重复
 *
 * @author jiahuiyang
 * @date 2020/12/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FactorCode {

    /**
     * code
     *
     * @return
     */
    String value() default "";

}
