package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店
 **/
@Mapper
@Component
public interface DispatchhotelMapper extends CommonMapper<Dispatchhotel>{

    /***
     * 调度酒店表信息：贾晓亮
     * @param offerId
     * @return
     */
    List<Dispatchhotel> dispatchhotelSelectAll(@Param("offerId")Integer offerId);
}
