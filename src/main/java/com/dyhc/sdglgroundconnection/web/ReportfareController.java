package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Reportfare;
import com.dyhc.sdglgroundconnection.service.ReportfareService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账车费 控制层
 **/
@RequestMapping("Reportfare")
@RestController
public class ReportfareController{

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportfareController.class);

    @Autowired
    private ReportfareService reportfareService;

    /**
     * 导游报账住宿新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游车费",content="车费新增")
    @RequestMapping("/savereportaccommodation")
    public ReponseResult savereportfare(@RequestParam("tolls")Double tolls,@RequestParam("parkingFee")Double parkingFee,@RequestParam("PrepaidFare")Double PrepaidFare) {
        System.out.println(tolls);
        System.out.println(parkingFee);
        System.out.println(PrepaidFare);
        Reportfare reportfare=new Reportfare();
        reportfare.setParkingFee(parkingFee);
        reportfare.setTolls(tolls);
        reportfare.setPrepaidFare(PrepaidFare);
        reportfare.setStatus(0);
        reportfare.setCreateBy(1);
        reportfare.setCreateDate(new Date());
        reportfare.setUpDate(new Date());
        reportfare.setUpdateBy(2);
        reportfare.setValue1("");
        reportfare.setValue2("");
        reportfare.setValue3("");
        try {
            Integer num=reportfareService.saveReportfare(reportfare);
            logger.info("method:reportfareService 导游车费新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("登陆成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:reportfareService 导游车费新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
}

