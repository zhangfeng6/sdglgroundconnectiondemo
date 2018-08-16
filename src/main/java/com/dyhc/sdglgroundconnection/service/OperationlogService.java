package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 操作日志业务接口
 **/
public interface OperationlogService {
    /**
     * 添加操作日志数据     张枫
     * @param operationlog   日志对象
     * @return          受影响行数
     */
    int saveOperationlog(Operationlog operationlog)throws Exception;
}
