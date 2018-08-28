package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Reportingotherexpenses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账其他支出
 **/
@Mapper
@Component
public interface ReportingotherexpensesMapper extends CommonMapper<Reportingotherexpenses>{

    /**
     * 获取导游报账其他支出明细信息
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    Reportingotherexpenses listReportingotherexpensesById(@Param("reportDetailId") Integer reportDetailId)throws Exception;
}
