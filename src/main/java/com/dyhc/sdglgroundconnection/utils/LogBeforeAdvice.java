package com.dyhc.sdglgroundconnection.utils;

import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.OperationlogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 定义切入面类   用于自定义日志注解  张枫
 */
@Component
@Aspect
public class LogBeforeAdvice{

    @Autowired
    private OperationlogService operationlogService;

    private Logger logger = LoggerFactory.getLogger(LogBeforeAdvice.class);


    @AfterReturning(value = "@annotation(com.dyhc.sdglgroundconnection.utils.LogNotes)")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String className = signature.getDeclaringTypeName();
        String methodName = method.getName();
        LogNotes logNotes = method.getAnnotation(LogNotes.class);
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            Staff staff = new Staff();
            staff.setRoleId(1);
            session.setAttribute("user", staff);
        }
        Staff user = (Staff) session.getAttribute("user");
        Operationlog operationlog = new Operationlog();
        operationlog.setOperationType(logNotes.operationType());
        operationlog.setOperationContent(logNotes.content());
        operationlog.setStatus(0);
        operationlog.setCreateBy(user.getRoleId());
        operationlog.setCreateDate(new Date());
        // 执行添加日志
        try {
            operationlogService.saveOperationlog(operationlog);
            logger.debug("目标类：" + className + " 目标方法：" + methodName +
                    " 操作人：" + user.getStaffId() + " 操作类型：" + logNotes.operationType() + " 操作内容：" + logNotes.content() + "  添加日志成功！");
        } catch (Exception e) {
            logger.error("目标类：" + className + " 目标方法：" + methodName +
                    " 操作人：" + user.getStaffId() + " 操作类型：" + logNotes.operationType() + " 操作内容：" + logNotes.content() + "  添加日志失败！");
            e.printStackTrace();
        }
    }

}
