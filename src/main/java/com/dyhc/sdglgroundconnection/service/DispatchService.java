package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度业务接口
 **/
public interface DispatchService {
    /**
     * 根据条件查询调度信息并返回分页信息  张枫
     * @param pageNo        当前页数
     * @param pageSize      每页显示量
     * @param djsth         地接社团号
     * @param dyname        导游名称
     * @param state         调度信息状态
     * @return
     * @throws Exception
     */
    PageInfo<Dispatch> listDispatch(Integer pageNo, Integer pageSize, String djsth, String dyname, Integer state) throws Exception;

    /**
     * 获取调度页面资源信息
     * @return
     * @throws Exception
     */
    Map<String,Object> getresource()throws Exception;
}
