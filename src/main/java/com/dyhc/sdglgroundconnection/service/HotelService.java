package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店业务接口
 **/
public interface HotelService {

    PageInfo<Hotel> listHotels(Integer pageNo,Integer PageSize) throws Exception;

    /**
     * 获取所有酒店信息 张枫
     * @return
     * @throws Exception
     */
    List<Hotel> listHotelNoPage() throws Exception;

    /**
     * 根据id获取指定的酒店信息 张枫
     * @param id
     * @return
     * @throws Exception
     */
    Hotel getHotelById(Integer id) throws Exception;
}
