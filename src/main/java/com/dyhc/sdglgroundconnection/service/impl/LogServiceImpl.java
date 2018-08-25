package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.LogMapper;
import com.dyhc.sdglgroundconnection.pojo.Log;
import com.dyhc.sdglgroundconnection.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 带团日志业务实现
 **/
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Integer inserLog(Log log) throws Exception {
        return logMapper.insertSelective(log);
    }
}
