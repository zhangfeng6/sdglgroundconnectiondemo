package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Reportticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账门票
 **/
@Mapper
@Component
public interface ReportticketMapper extends CommonMapper<Reportticket> {

    /**
     * 获取导游门票报账明细信息
     * @param reportDetailId
     * @return
     */
    List<Reportticket> listReportticketById(@Param("reportDetailId")Integer reportDetailId)throws Exception;

    /**
     * 获取导游门票报账明细信息
     * @param reportDetailId
     * @return
     */
    List<Reportticket> getMenPiaoById(@Param("reportDetailId") Integer reportDetailId, @Param("liveDate") String liveDate)throws Exception;
}
