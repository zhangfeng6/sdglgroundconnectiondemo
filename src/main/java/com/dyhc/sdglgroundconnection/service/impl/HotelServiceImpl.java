package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.HotelMapper;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店业务实现
 **/
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    public PageInfo<Hotel> listHotels(Integer pageNo, Integer PageSize) {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotelMapper.selectAll());
        return pageInfo;
    }

    /**
     * 获取所有酒店信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Hotel> listHotelNoPage() throws Exception {
        return hotelMapper.selectAll();
    }

    /**
     * 根据id获取指定的酒店信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Hotel getHotelById(Integer id) throws Exception {
        return hotelMapper.selectByPrimaryKey(id);
    }
}
