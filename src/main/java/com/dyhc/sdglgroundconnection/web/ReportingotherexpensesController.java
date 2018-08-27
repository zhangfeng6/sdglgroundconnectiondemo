package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Reportingotherexpenses;
import com.dyhc.sdglgroundconnection.service.ReportingotherexpensesService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账其他支出 控制层
 **/
@RequestMapping("Reportingotherexpenses")
@RestController
public class ReportingotherexpensesController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportingotherexpensesController.class);

    @Autowired
    private ReportingotherexpensesService reportingotherexpensesService;

    /**
     * 导游报账其他新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游其他明细",content="其他新增")
    @RequestMapping("/saveReportingotherexpenses")
    public ReponseResult saveReportingotherexpenses(
            @RequestParam("Remarks")String Remarks,
            @RequestParam("GuidedTour")Double GuidedTour,
            @RequestParam("Signing")Double Signing,
            @RequestParam("total")Double total){
        Reportingotherexpenses reportingotherexpenses=new Reportingotherexpenses();
        reportingotherexpenses.setCreateBy(1);
        reportingotherexpenses.setCreateDate(new Date());
        reportingotherexpenses.setStatus(0);
        reportingotherexpenses.setRemarks(Remarks);
        reportingotherexpenses.setGuidedTour(GuidedTour);
        reportingotherexpenses.setSigning(Signing);
        reportingotherexpenses.setTotal(total);
        try {
            Integer num=reportingotherexpensesService.saveReportingotherexpenses(reportingotherexpenses);
            logger.info("method:savereportaccommodation 导游其他新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("报账其他成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游其他明细新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

}
