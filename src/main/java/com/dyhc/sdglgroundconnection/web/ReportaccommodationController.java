package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import com.dyhc.sdglgroundconnection.service.ReportaccommodationService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账住宿 控制层
 **/
@RestController
@RequestMapping("Reportaccommodation")
public class ReportaccommodationController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportaccommodationController.class);

    @Autowired
    private ReportaccommodationService reportaccommodationService;

    /**
     * 导游报账住宿新增
     * @param reportaccommodation
     * @return
     */
    @LogNotes(operationType="导游报账",content="住宿新增")
    @RequestMapping("/savereportaccommodation")
    public ReponseResult saveAccountType(Reportaccommodation reportaccommodation){
        try {
            Integer num=reportaccommodationService.saveReportaccommodation(reportaccommodation) ;
            logger.info("method:savereportaccommodation 导游报账住宿新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("住宿报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游报账住宿新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }


    /**
     * 获取导游住宿报账信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("listReportAccommodationById")
    public ReponseResult listReportAccommodationById(Integer reportDetailId){
        try {
            ReponseResult data=ReponseResult.ok(reportaccommodationService.listReportaccommodationByreportDetailId(reportDetailId),"获取导游住宿报账明细成功");
            logger.info("mothod:listReportAccommodationById 获取导游住宿报账明细成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:listReportAccommodationById 获取导游住宿报账明细失败");
            return ReponseResult.err("获取导游住宿报账明细失败");
        }
    }
}
