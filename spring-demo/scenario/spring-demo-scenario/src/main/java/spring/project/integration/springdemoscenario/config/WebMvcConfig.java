package spring.project.integration.springdemoscenario.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: web mvn config 配置拦截器
 * @Author: jiahuiyang
 * @Date: Created in 16:52 2020/11/18
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Bean
//    public FilterRegistrationBean timeFilter() {
//        return null;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean permissionListener() {
//        return null;
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器 可以直接new 也可以通过spring bean注入
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        //按照注册顺序进行拦截
        registry.addInterceptor(getMyInterceptorNew()).addPathPatterns("/**");
        // 添加拦截所有请求路径配置 也可以排除拦截excludePathPatterns
//        registration.addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getMyInterceptorNew() {
        return new MyInterceptorNew();
    }



}
