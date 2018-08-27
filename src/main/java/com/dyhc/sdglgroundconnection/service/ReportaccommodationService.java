package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账住宿业务接口
 **/
public interface ReportaccommodationService {
    /**
     * 导游报账住宿：贾晓亮
     * @param reportaccommodation
     * @return
     */
   Integer saveReportaccommodation(Reportaccommodation reportaccommodation);
}
