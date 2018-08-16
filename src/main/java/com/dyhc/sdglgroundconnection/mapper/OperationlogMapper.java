package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 日志操作
 **/
@Mapper
@Component
public interface OperationlogMapper extends CommonMapper<Operationlog>{
    /**
     * 添加操作日志数据     张枫
     * @param operationlog   日志对象
     * @return          受影响行数
     */
    int saveOperationlog(Operationlog operationlog)throws Exception;

    /**
     * 根据用户传入参数进行条件查询  张枫
     * @param theUserName  操作人账户
     * @param createDate   操作时间
     * @return   返回符合条件的数据集合
     * @throws Exception
     */
    List<Operationlog> listOperationLog(@Param("theUserName")String theUserName,@Param("createDate")String createDate)throws Exception;
}
