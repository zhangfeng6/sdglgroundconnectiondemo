package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店
 **/
@Mapper
@Component
public interface HotelMapper extends CommonMapper<Hotel>{
    /**
     * 查询酒店信息表贾晓亮
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Hotel> HotelShowAll(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize, @Param("hotelName")String hotelName);


    /**
     * 删除酒店信息
     * @param hotelId
     * @return
     * @throws Exception
     */
    Integer removeHoter(Integer hotelId)throws  Exception;

    /**
     * 房间修改赋值
     * @param typeId
     * @return
     */
    RoomType fuzhiRoomType(Integer  typeId);

    /**
     * 修改酒店进行赋值操作：贾晓亮
     * @param hotelId
     * @return
     * @throws Exception
     */
    Hotel fuzhiHotel(Integer hotelId)throws Exception;
}
