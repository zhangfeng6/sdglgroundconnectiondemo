package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportqutsubsidy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账出团补助业务接口
 **/
public interface ReportqutsubsidyService {
    /**
     * 导游报账出团补助：贾晓亮
     * @param reportqutsubsidy
     * @return
     */
    Integer saveReportqutsubsidy(Reportqutsubsidy reportqutsubsidy);
}
