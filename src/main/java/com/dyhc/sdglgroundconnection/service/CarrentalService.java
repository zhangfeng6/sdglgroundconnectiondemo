package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Carrental;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 汽车租赁公司业务接口
 **/
public interface CarrentalService {

    /**
     * 查询汽车公司及旗下的车辆类型信息
     * @param carRentalName
     * @param costprice1
     * @param costprice2
     * @param passengervolume
     * @return
     */
    PageInfo<Carrental> listCarRentals(String carRentalName,Integer costprice1,Integer costprice2,Integer passengervolume,Integer pageNo,Integer pageSize)throws Exception;

}
