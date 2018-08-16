package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OperationlogMapper;
import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import com.dyhc.sdglgroundconnection.service.OperationlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 操作日志业务实现
 **/
@Service
public class OperationlogServiceImpl implements OperationlogService {

    @Autowired
    private OperationlogMapper operationlogMapper;

    /**
     * 重写接口   添加日志数据  张枫
     * @param operationlog   日志对象
     * @return 受影响行数
     * @throws Exception   错误信息
     */
    @Override
    public int saveOperationlog(Operationlog operationlog) throws Exception {
        return operationlogMapper.saveOperationlog(operationlog);
    }
}
