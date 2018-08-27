package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportticket;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账门票业务接口
 **/
public interface ReportticketService {
    /**
     *导游报账门票：贾晓亮
     * @param reportticket
     * @return
     */
    Integer saveReportticket(Reportticket reportticket);
}
