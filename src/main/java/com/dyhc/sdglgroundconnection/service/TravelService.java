package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社业务接口
 **/
public interface TravelService {
    /**
     * 赵伟伟
     * 查询全部组团社
     * @return
     */
    List<Travel> selectTravel();

    /**
     * 赵伟伟
     * 查询组团社
     * @param travelId
     * @return
     */
    Travel selectTravelById(Integer travelId);
}
