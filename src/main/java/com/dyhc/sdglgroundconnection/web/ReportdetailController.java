package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.service.ReportdetailService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细 控制层
 **/
@RestController
@RequestMapping("reportdetail")
public class ReportdetailController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportdetailController.class);

    @Autowired
    private ReportdetailService reportdetailService;


    /**
     * 获取所有的导游报账明细
     * @param pageNo
     * @param pageSize
     * @param groupNumber
     * @param states
     * @return
     */
    @RequestMapping("showInfoAll")
    public ReponseResult showInfoAll(Integer pageNo,Integer pageSize,Integer groupNumber,Integer states){
        try{
            PageInfo pageInfo=reportdetailService.showInfoAll(groupNumber,states,pageNo,pageSize);
            ReponseResult data=ReponseResult.ok(pageInfo,"获取报账列表成功");
            logger.info("method:showInfoAll 获取报账列表成功");
            return data;
        }catch (Exception e){
            logger.error("method:showInfoAll 获取报账列表失败");
            e.printStackTrace();
            return ReponseResult.err("获取报账列表失败");
        }
    }



    /**
     * 获取导游报账明细信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("getReportdetailById")
    public ReponseResult getReportdetailById(Integer reportDetailId){
        try{
            ReponseResult data=ReponseResult.ok(reportdetailService.getReportdetailById(reportDetailId),"获取成功");
            logger.info("method:getReportdetailById 获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:getReportdetailById 获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }


    /**
     * 获取导游报账明细信息:贾晓亮
     * @return
     */
    @RequestMapping("/reportdetail")
    public ReponseResult reportdetail(Integer dispatchId){
        dispatchId=1;
        try{
            System.out.println("进来了");
            ReponseResult data=ReponseResult.ok(reportdetailService.reportdetail(dispatchId),"获取获取导游报账明细信息成功");
            logger.info("method:reportdetail 获取获取导游报账明细信息成功");
            return data;
        }catch (Exception e){
            logger.error("method:reportdetail 获取获取导游报账明细信息失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }
}
