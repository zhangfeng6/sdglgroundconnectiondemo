package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OperationlogMapper;
import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import com.dyhc.sdglgroundconnection.service.OperationlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    /**
     *根据条件返回pageinfo
     * @param theUserName  操作人账户
     * @param createDate   操作时间
     * @param pageNo       当前页
     * @param PageSize     每页显示量
     * @return
     */
    @Override
    public PageInfo<Operationlog> listOperationlog(String theUserName, String createDate, Integer pageNo, Integer PageSize)throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<Operationlog> pageInfo = new PageInfo<Operationlog>(operationlogMapper.listOperationLog(theUserName,createDate));
        return pageInfo;
    }

    /**
     *根据Id主键删除日志信息   张枫
     * @param operationlog   日志信息  包含主键以及状态
     * @return     受影响行数
     */
    @Override
    public int removeOperationlogById(Operationlog operationlog) throws Exception {
        return operationlogMapper.updateByPrimaryKeySelective(operationlog);
    }

}
