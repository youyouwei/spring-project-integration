package spring.project.integration.springdemoscenario.config.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 13:43 2020/11/20
 */
@Aspect
public class LogOperateAspect {

    //定义切点 可重复使用
    //表达式表示 第一个* 表示所有方法 还可以换成public表示任何公共方法
    @Pointcut("execution(* spring.project.integration.springdemoscenario.Demo.*(..))")
    public void performance() {}


    //获取被切方法的入参
    @Pointcut("execution(* spring.project.integration.springdemoscenario.Demo.add(int ))&&args(i)")
    public void getAddNum(int i) {}

    //定义切面行为
    @Before("performance()")
    public void beforeDemo() {
        System.out.println("before demo do some things");
    }

    @Before("getAddNum(i)")
    public void beforeAdd(int i) {
        System.out.println("aspect point cut add " + i);
    }

    //也可以在建言中直接使用切点表达式
    @After("execution(* spring.project.integration.springdemoscenario.Demo.*(..))")
    public void afterDemo() {

    }


    @Pointcut("execution(* spring.project.integration.springdemoscenario.config.PersonServiceImpl.eat())")
    public void person() {}

    @Before("person()")
    public void beforeEat() {
        System.out.println("before person eat some thing...");
    }



}
