package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型
 **/
@Mapper
@Component
public interface RoomTypeMapper extends CommonMapper<RoomType>{

    /***
     * 按照酒店编号查询酒店下的房间贾晓亮
     * @param hotelId
     * @return
     */
    List<RoomType> RoomTypeShowAll(Integer hotelId);


}
