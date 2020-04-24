package spring.project.integration.springdemoapp.common.config;

import java.lang.annotation.*;

/**
 * @author jiahuiyang
 * @date
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {

}
