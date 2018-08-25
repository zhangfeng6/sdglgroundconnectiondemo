package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TravelMapper;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社业务实现
 **/
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public List<Travel> selectTravel() {
        return travelMapper.selectAll();
    }

    @Override
    public Travel selectTravelById(Integer travelId) {
        return travelMapper.selectTravelById(travelId);
    }
}
