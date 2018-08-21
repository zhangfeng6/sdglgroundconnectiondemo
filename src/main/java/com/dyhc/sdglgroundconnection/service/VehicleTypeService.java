package com.dyhc.sdglgroundconnection.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型业务接口
 **/
public interface VehicleTypeService {

    /**
     * 根据公司id删除公司下的车辆类型
     * @param carRentalId
     */
    Integer deleteVehicleTypesBycarRentalId(Integer carRentalId)throws Exception;
}
