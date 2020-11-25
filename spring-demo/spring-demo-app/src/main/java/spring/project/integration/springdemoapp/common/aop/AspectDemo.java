package spring.project.integration.springdemoapp.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:28 2020/11/20
 */
@Aspect
@Component
public class AspectDemo {

    @Pointcut("execution(* spring.project.integration.springdemoapp.service.*.*(..))")
    public void order(){}

    @Before("order()")
    public void beforeOrder() {
        System.out.println("before order do some thing");
    }

}
