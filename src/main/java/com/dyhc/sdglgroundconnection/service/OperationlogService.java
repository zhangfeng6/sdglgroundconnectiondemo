package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     *根据条件返回pageinfo
     * @param theUserName  操作人账户
     * @param createDate   操作时间
     * @param pageNo       当前页
     * @param PageSize     每页显示量
     * @return
     */
    PageInfo<Operationlog> listOperationlog(String theUserName,String createDate,Integer pageNo, Integer PageSize)throws Exception;

    /**
     *根据Id主键删除日志信息   张枫
     * @param id   日志信息主键id
     * @return     受影响行数
     */
    int removeOperationlogById(Operationlog operationlog)throws Exception;
}
