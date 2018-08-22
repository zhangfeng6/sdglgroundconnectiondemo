package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.RoomTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.dyhc.sdglgroundconnection.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型业务实现
 **/
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public Boolean judgeTypeName(Integer hotelId, Integer valueId) throws Exception {
        RoomType roomType=roomTypeMapper.getroomtypeByName(hotelId, valueId);
        boolean flag=true;
        if(roomType!=null){
            flag=false;
        }
        return  flag;
    }
}
