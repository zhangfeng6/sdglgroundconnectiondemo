package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账餐厅业务接口
 **/
public interface ReportrestaurantService {
    /**
     * 导游报账餐厅：贾晓亮
     * @param reportrestaurant
     * @return
     */
    Integer saveReportrestaurant(Reportrestaurant reportrestaurant);
}
