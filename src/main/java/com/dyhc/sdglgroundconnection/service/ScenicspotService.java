package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.mapper.CommonMapper;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点业务接口
 *
 **/
public interface ScenicspotService {

    /**
     * 根据名称、地址、等级状态查询景点
     * @param typeId
     * @return
     */
    PageInfo<Scenicspot> listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer whetherDel, Integer pageNo, Integer pageSize) throws Exception;



    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    PageInfo<Scenicspot> getScenicspotByParentId(Integer parentId)throws Exception;
}
