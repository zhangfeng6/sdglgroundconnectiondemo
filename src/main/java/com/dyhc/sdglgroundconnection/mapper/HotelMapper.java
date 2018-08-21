package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
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
    List<Hotel> HotelShowAll(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize, @Param("hotelName")String hotelName, @Param("costpriceOne")Integer costpriceOne, @Param("costpriceTwo")Integer costpriceTwo);

}
