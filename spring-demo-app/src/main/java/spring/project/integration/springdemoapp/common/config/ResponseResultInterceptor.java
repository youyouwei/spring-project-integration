package spring.project.integration.springdemoapp.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spring.project.integration.springdemoapp.common.constant.CommonConstantParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description: 处理方法拦截器 在servlet请求到方法之前的拦截处理（或其他时间）
 * 需要注册到InterceptorRegistry拦截器列表中
 * @Author: jiahuiyang
 * @Date: Created in 16:09 2020/4/24
 */
@Slf4j
public class ResponseResultInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

        //处理请求的方法
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //判断是否在类对象或则方法上加了ResponseResult注解
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                //设置请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                request.setAttribute(CommonConstantParam.RESPONSE_RESULT_ANN, clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(CommonConstantParam.RESPONSE_RESULT_ANN, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }

}
