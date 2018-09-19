package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细
 **/
@Mapper
@Component
public interface ReportdetailMapper extends CommonMapper<Reportdetail>{

    /**
     * 获取所有导游报账明细
     * @param groupNumber
     * @param states
     * @return
     */
    List<Reportdetail> showInfoAll(@Param("groupNumber") Integer groupNumber, @Param("states")Integer states)throws Exception;

    /**
     * 查询地接导游报账明细：贾晓亮
     * @param dispatchId
     * @return
     */
    Reportdetail reportdetail(@Param("dispatchId")Integer dispatchId)throws Exception;

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    void tgShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    void bhShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 结算导游报账
     * @param reportDetailId
     * @return
     */
    void jsShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;
    /**
     * 查询报账类型
     * @return
     */
    List<Dictionaries> baozhangType()throws Exception;

    /**
     * 报账字表插入总表的报账ID
     * @param dispatchId
     * @return
     */
    Reportdetail All_dispatchId(@Param("dispatchId")Integer dispatchId)throws Exception;


    Dispatch selectDispatchById(@Param("groupNumber") Integer groupNumber)throws Exception;

    /**
     * 查看门票
     * @param dispatchId
     * @return
     */
    Reportdetail getReportticket(@Param("dispatchId")Integer dispatchId) throws Exception;

    /**
     * 查看住宿
     * @param dispatchId
     * @return
     */
    Reportaccommodation getHotel(@Param("dispatchId")Integer dispatchId)throws Exception;

    /**
     * 查看其它
     * @param dispatchId
     * @return
     */
    Reportingotherexpenses getReportingotherexpenses(@Param("dispatchId")Integer dispatchId)throws Exception;


    /**
     * 查看结算
     * @param
     * @return
     */
    Travel showJieSuan(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 查看结算
     * @param
     * @return
     */
    Dispatch showJieSuan1(@Param("reportDetailId") Integer reportDetailId)throws Exception;
}
