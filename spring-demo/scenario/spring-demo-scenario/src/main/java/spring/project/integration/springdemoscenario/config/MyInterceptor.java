package spring.project.integration.springdemoscenario.config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:  自定义拦截器 Spring 拦截器的接口为HandlerInterceptor，HandlerInterceptorAdapter抽象类
 * 这种Spring的interceptor需要配置spring-mvc.xml
 *     <mvc:interceptors>
 *         <mvc:interceptor>
 *             <mvc:mapping path="/**"/>
 *             <mvc:exclude-mapping path="/user/index"/>
 *             <bean class="com.springmvc.intercepter.MyInterceptor"/>
 *         </mvc:interceptor>
 *     </mvc:interceptors>
 * @Author: jiahuiyang
 * @Date: Created in 16:05 2020/11/16
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("进入拦截器了");
        //中间写逻辑代码，比如判断是否登录成功，失败则返回false
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
        System.out.println("controller 执行完了");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("我获取到了一个返回的结果："+response);
        System.out.println("请求结束了");
    }

}
