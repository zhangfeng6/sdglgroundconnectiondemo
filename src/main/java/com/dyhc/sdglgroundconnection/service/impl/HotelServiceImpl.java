package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.HotelMapper;
import com.dyhc.sdglgroundconnection.mapper.RoomTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
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
    /**
     * 房间类型信息
     */
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    /**
     *获取酒店线面房间的信息
     * @param hotelId
     * @return
     * @throws Exception
     */
    public  List<RoomType> roomTypeList(Integer hotelId)throws Exception{
        return roomTypeMapper.RoomTypeShowAll(hotelId);
    }
    /**
     * 查询酒店标的数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Hotel> hotelShowAll(Integer pageNo, Integer pageSize,String hotelName,Integer costpriceOne,Integer costpriceTwo)throws  Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Hotel> hotels=hotelMapper.HotelShowAll(pageNo,pageSize,hotelName,costpriceOne,costpriceTwo);
        for (Hotel h :hotels) {
            Integer as =h.getHotelId();
           h.setRoomTypesList(roomTypeMapper.RoomTypeShowAll(h.getHotelId()));
        }
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotels);
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
    public PageInfo<Hotel> listHotels(Integer pageNo, Integer PageSize) {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotelMapper.selectAll());
        return pageInfo;
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
