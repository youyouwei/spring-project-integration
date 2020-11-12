package spring.project.integration.springlogoperate;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 通过该注解实现三方jar包的容器注入
 * @author jiahuiyang
 * @date 2020/11/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogOperateConfiguration.class)
@Documented
public @interface EnableLogOperate {

}
