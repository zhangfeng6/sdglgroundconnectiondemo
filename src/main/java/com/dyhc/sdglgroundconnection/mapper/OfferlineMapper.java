package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Offer;
import com.dyhc.sdglgroundconnection.pojo.Offerline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价线路信息记录
 **/
@Mapper
@Component
public interface OfferlineMapper extends CommonMapper<Offerline>{

    /**
     * 赵伟伟
     * 查询线路
     * @param offerLineRecordId
     * @return
     */
    Offerline selectByofferLineRecordId(@Param("offerLineRecordId") Integer offerLineRecordId);

    /**
     * 新增报价线路信息
     * @param offerline
     * @return
     */
    int insertOfferline(Offerline offerline);
}
