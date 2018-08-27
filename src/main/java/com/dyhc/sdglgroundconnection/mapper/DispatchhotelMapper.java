package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店
 **/
@Mapper
@Component
public interface DispatchhotelMapper extends CommonMapper<Dispatchhotel>{


    /**
     * 根据调度id获取调度酒店信息
     * @param dispatchId
     * @return
     */
    Dispatchhotel getDispatchHotel(@Param("dispatchId") Integer dispatchId, @Param("weight")Integer weight);
}
