package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社
 **/
@Mapper
@Component
public interface TravelMapper extends CommonMapper<Travel> {
    List<Travel> listTravelLike(@Param("travelName") String travelName);
    /**
     * 删除
     * @param travelId
     * @return
     */
    Integer getUpdTrave(Integer travelId);

    /**
     * 修改条件查
     * @param travelId
     * @return
     */
    Travel getupdBytravelId(Integer travelId);

    /**
     * 修改
     * @return
     */

    Integer getupdlala(Travel travel);
}
