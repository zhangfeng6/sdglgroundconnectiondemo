package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
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

    /**
     * 根据类型和类型id获取指定的信息资源
     * @param type
     * @param valueId
     * @return
     * @throws Exception
     */
    List listinfoByvalueId(String type,Integer valueId)throws Exception;



    /**
     * 根据导游id查询调度信息     陈庆武
     * @param guideId 导游id
     * @return
     */
    Dispatch getDispatchByguideId(Integer guideId)throws Exception;
    /**
     * 分页查看调用信息         刘跃云
     * @param pageNo
     * @param pageSize
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    PageInfo<Dispatch> ListDispatchLike(Integer pageNo, Integer pageSize, String guideName, String groundConnectionNumber);
}
