package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Offer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价信息
 **/
@Mapper
@Component
public interface OfferMapper extends CommonMapper<Offer>{
    /**
     * 赵伟伟
     * 查询报价单
     * @param travelName
     * @return
     */
    List<Offer> selectOffer(@Param("travelName") String travelName);

    /**
     * 赵伟伟
     * 新增报价单信息
     * @param offer
     * @return
     */
    int insertOffer(Offer offer) throws Exception;
}
