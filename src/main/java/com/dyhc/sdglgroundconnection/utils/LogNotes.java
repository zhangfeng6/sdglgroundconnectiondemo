package com.dyhc.sdglgroundconnection.utils;

import java.lang.annotation.*;

/**
 * 自定义操作日志注解接口类
 * @author Dream
 *
 */
//表示在什么级别保存该注解信息
//SOURCE：注解将被编译器丢弃
//CLASS：注解在class文件中可用，但会被VM丢弃
//RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息
@Retention(RetentionPolicy.RUNTIME)
/*表示该注解可以用于什么地方，可能的ElementType参数有：
CONSTRUCTOR：构造器的声明
FIELD：域声明（包括enum实例）
LOCAL_VARIABLE：局部变量声明
METHOD：方法声明
PACKAGE：包声明
PARAMETER：参数声明
TYPE：类、接口（包括注解类型）或enum声明*/
@Target(ElementType.METHOD)
@Documented
public @interface LogNotes {
    //操作类型
    String operationType();
    //操作内容
    String content();

}
