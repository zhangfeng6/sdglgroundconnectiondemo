package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Reportfare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账车费
 **/
@Mapper
@Component
public interface ReportfareMapper extends CommonMapper<Reportfare>{

    /**
     * 获取导游车费报账明细
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    Reportfare listReportfareById(@Param("reportDetailId") Integer reportDetailId)throws Exception;
}
