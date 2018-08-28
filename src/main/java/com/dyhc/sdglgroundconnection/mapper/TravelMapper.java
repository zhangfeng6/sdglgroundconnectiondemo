package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.*;
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

    /**
     * 赵伟伟
     * 查询组团社
     * @param travelId
     * @return
     */
    Travel selectTravelById(@Param("travelId") Integer travelId);


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


    /**
     * 根据组团社查询导游
     * @param travelId
     * @return
     */
    Guide selectGuideByTravelId(@Param("travelId") Integer travelId);


    /**
     * 根据组团社id查询司机
     * @param travelId
     * @return
     */
    Dispatch selectDispatchByTravelId(@Param("travelId") Integer travelId);

    /**
     * genju组团社id查询计调员
     * @param travelId
     * @return
     */
    Staff selectStaffByTraveId(@Param("travelId") Integer travelId);

    /**
     * 根据组团社id查询线路
     * @param travelId
     * @return
     */
    Offer selectOfferByTravelId(@Param("travelId") Integer travelId);

}
