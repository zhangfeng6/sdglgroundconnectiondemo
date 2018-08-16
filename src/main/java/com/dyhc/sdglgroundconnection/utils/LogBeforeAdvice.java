package com.dyhc.sdglgroundconnection.utils;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 定义切入面类   用于自定义日志注解
 */
@Component
@Aspect
public class LogBeforeAdvice{

    @Pointcut("execution(public * com.dyhc.sdglgroundconnection.utils.LogNotes*.*(..))")
    public void webLog(){}

    @AfterReturning(returning="ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }

}
