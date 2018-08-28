package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.github.pagehelper.PageInfo;
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

    /**
     *
     * 添加信息
     * @param travel
     * @return
     * @throws Exception
     */
    Integer getAddTravel(Travel travel) throws Exception;
    /**
     * 修改信息
     * @param travel
     * @return
     */
    Integer getTravelUpd(Travel travel) throws Exception;

    /**
     * a按条件模糊查看
     * @param pageNo
     * @param PageSize
     * @return
     * @throws Exception
     */
    PageInfo<Travel> listTravelLike(Integer pageNo, Integer PageSize, String travelName) throws Exception;

    /**
     * 按条件查看
     * @param travelId
     * @return
     * @throws Exception
     */
    Integer getselectById(Integer travelId) throws Exception;


    /**
     * 删除    修改
     * @param travelId
     * @return
     */
    Integer getUpdTrave(Integer travelId);

    /**
     * 修改查看
     * @param travelId
     * @return
     */
    Travel getupdBytravelId(Integer travelId);


    /**
     * 修改 第二次
     * @return
     */
    Integer getupdlala(Travel travel);

}
