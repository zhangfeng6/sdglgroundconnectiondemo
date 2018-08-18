package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型
 **/
@Mapper
@Component
public interface VehicleTypeMapper extends CommonMapper<VehicleType> {

    /**
     * 根据价格和载客量查询车辆类型
     * @param costprice1
     * @param costprice2
     * @param passengervolume
     * @return
     */
    List<VehicleType> listVehicleTypes(@Param("costprice1") Integer costprice1,@Param("costprice2")  Integer costprice2, @Param("passengervolume") Integer passengervolume);

}
