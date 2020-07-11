package spring.project.integration.springdemoapp.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import spring.project.integration.springdemoapp.common.constant.CommonConstantParam;
import spring.project.integration.springdemoapp.common.enums.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:42 2020/4/24
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();
        //获取 注解
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(CommonConstantParam.RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        log.info("进入 返回体 重写格式 处理中 。。。。。");
//        如果做全局异常处理可以在这里包装处理返回结果
//        if(body instanceof )
        //todo 全局异常处理 ErrorResult

        return Result.success(body);
    }


}
