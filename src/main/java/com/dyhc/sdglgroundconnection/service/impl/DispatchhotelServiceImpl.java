package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DispatchhotelMapper;
import com.dyhc.sdglgroundconnection.mapper.HotelMapper;
import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.service.DispatchhotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店业务实现
 **/
@Service
public class DispatchhotelServiceImpl implements DispatchhotelService {

    @Autowired
    private DispatchhotelMapper dispatchhotelMapper;
    @Autowired
    private HotelMapper hotelMapper;


    /**
     *  查询调度酒店信息：贾晓亮
     * @param offerId
     * @return
     */
    public List<Dispatchhotel> dispatchhotelSelectAll(Integer offerId){
        List<Dispatchhotel> dispatchhotelSelectAll=null;
        try {
             dispatchhotelSelectAll=dispatchhotelMapper.dispatchhotelSelectAll(offerId);
            for (Dispatchhotel s:dispatchhotelSelectAll) {
                s.setHotel(hotelMapper.selectByHotelId(s.getHotelId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispatchhotelSelectAll;
    }
}
