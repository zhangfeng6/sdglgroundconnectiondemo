package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Carrental;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 *汽车租赁公司
 **/
@Mapper
@Component
public interface CarrentalMapper extends CommonMapper<Carrental>{

    /**
     * 根据公司名称模糊查询公司信息
     * @param carRentalName
     * @return
     */
    List<Carrental> listCarRentals(@Param("carRentalName") String carRentalName)throws Exception;

}
