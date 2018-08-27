package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.OfferHotel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价酒店业务接口
 **/
public interface OfferHotelService {

    /**
     * 赵伟伟
     * 新增酒店报价
     * @param offerHotel
     * @return
     */
    int insertOfferHotel(OfferHotel offerHotel);
}
