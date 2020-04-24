package spring.project.integration.springdemoapp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:37 2020/4/24
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //把拦截器注册到拦截器列表中 并且匹配所有路径
        registry.addInterceptor(getResponseResultInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getResponseResultInterceptor() {
        return new ResponseResultInterceptor();
    }

}
