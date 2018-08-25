package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社
 **/
@Mapper
@Component
public interface TravelMapper extends CommonMapper<Travel> {
    /**
     * 赵伟伟
     * 查询组团社
     * @param travelId
     * @return
     */
    Travel selectTravelById(@Param("travelId") Integer travelId);
}
