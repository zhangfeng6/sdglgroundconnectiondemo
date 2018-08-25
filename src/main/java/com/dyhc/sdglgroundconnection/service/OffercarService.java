package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Offercar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价用车业务接口
 **/
public interface OffercarService {

    /**
     * 赵伟伟
     * 新增汽车报价
     * @param offercar
     * @return
     */
    int insertOffercar(Offercar offercar);
}
