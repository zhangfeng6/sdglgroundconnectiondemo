package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Reportqutsubsidy;
import com.dyhc.sdglgroundconnection.pojo.Reportticket;
import com.dyhc.sdglgroundconnection.service.ReportticketService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
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
 * 导游报账门票 控制层
 **/
@RequestMapping("Reportticket")
@RestController
public class ReportticketController {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportticketController.class);
    @Autowired
    private ReportticketService reportticketService;

    /**
     * 导游报账住宿新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游门票明细",content="门票新增")
    @RequestMapping("/saveReportticket")
    public ReponseResult saveReportqutsubsidy(
            @RequestParam("attrName") String attrName,@RequestParam("price") Double price,
            @RequestParam("nums")Integer nums, @RequestParam("payMethods")String payMethods){
        Reportticket reportticket =new Reportticket();
        reportticket.setCreateBy(1);
        reportticket.setCreateDate(new Date());
        reportticket.setStatus(0);
        reportticket.setAttrName(attrName);
        reportticket.setPrice(price);
        reportticket.setNums(nums);
        reportticket.setPayMethods(payMethods);
        try {
            Integer num=reportticketService.saveReportticket(reportticket);
            logger.info("method:saveReportqutsubsidy 导游门票明细新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("门票报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:saveReportqutsubsidy 导游门票明细新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
}