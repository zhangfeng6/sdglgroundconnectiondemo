package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账餐厅
 **/
@Mapper
@Component
public interface ReportrestaurantMapper extends CommonMapper<Reportrestaurant>{
    /**
     * 获取导游餐厅报账明细信息
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    List<Reportrestaurant> listReportrestaurantById(@Param("reportDetailId") Integer reportDetailId)throws Exception;
}
