package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型业务接口
 **/
public interface RoomTypeService {

    /**
     * 判断该酒店下是否存在该类型
     * @param hotelId
     * @param valueId
     * @return
     */
    Boolean judgeTypeName(Integer hotelId,Integer valueId)throws Exception;
    
}
