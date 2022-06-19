package com.xu.controller.utils;

//作为SpringMVC的异常处理器

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){

        ex.printStackTrace();
        return new R("服务器异常，请稍后再试");
    }
}
