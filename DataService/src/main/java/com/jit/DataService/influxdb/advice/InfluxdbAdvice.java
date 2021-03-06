package com.jit.DataService.influxdb.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Log4j2
public class InfluxdbAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        String method = methodParameter.getMethod().getName();
        String returnType = methodParameter.getMethod().getReturnType().getName();
        log.info("return info == Method:{}, returnType:{}", method, returnType);
        if (null == o) {
            log.warn("return is null");
        } else {
            if (!methodParameter.getMethod().getName().equals("selectHistory")) {
                methodParameter.getMethod().getReturnType().getName();
                log.info("return:{}", o.toString());
            } else {
                log.info("return is not null");
            }
        }
        return o;
    }
}
