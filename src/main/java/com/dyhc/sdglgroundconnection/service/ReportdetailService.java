package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细业务接口
 **/
public interface ReportdetailService {

    /**
     * 获取所有导游报账明细
     * @param groupNumber
     * @param states
     * @return
     */
    PageInfo showInfoAll(Integer groupNumber,Integer states,Integer pageNo,Integer pageSize)throws Exception;


    /**
     * 根据id获取导游报账明细信息：陈庆武
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    Reportdetail getReportdetailById(Integer reportDetailId)throws Exception;
}
