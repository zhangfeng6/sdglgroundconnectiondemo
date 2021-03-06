package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Reportingotherexpenses;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.dyhc.sdglgroundconnection.service.ReportdetailService;
import com.dyhc.sdglgroundconnection.service.ReportticketService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细 控制层
 **/
@RestController
@RequestMapping("/reportdetail")
public class ReportdetailController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportdetailController.class);

    @Autowired
    private ReportdetailService reportdetailService;
    @Autowired
    private ReportdetailMapper reportdetailMapper;
    @Autowired
    private DispatchService dispatchService;

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
            PageInfo<Reportdetail> pageInfo=reportdetailService.showInfoAll(groupNumber,states,pageNo,pageSize);
            ReponseResult data=ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"获取报账列表成功");
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
    public ReponseResult reportdetail(HttpServletRequest request, Integer dispatchId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        try{
            ReponseResult data=ReponseResult.ok(reportdetailService.reportdetail(dispatchId),"获取获取导游报账明细信息成功");
            logger.info("method:reportdetail 获取获取导游报账明细信息成功");
            return data;
        }catch (Exception e){
            logger.error("method:reportdetail 获取获取导游报账明细信息失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    @RequestMapping("tgShenHe")
    @LogNotes(operationType="导游报账",content="修改审核状态")
    public ReponseResult tgShenHe(Integer reportDetailId){
        try {
            Integer result=reportdetailService.tgShenHe(reportDetailId);
            ReponseResult data=ReponseResult.ok(result,"报账审核成功");
            logger.info("mothod:tgShenHe 报账审核成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:tgShenHe 报账审核失败");
            return ReponseResult.err("报账审核失败");
        }
    }


    /**
     * 驳回导游报账的审核
     * @param reportDetailId
     * @return
     */
    @RequestMapping("bhShenHe")
    @LogNotes(operationType="导游报账",content="修改审核状态")
    public ReponseResult bhShenHe(Integer reportDetailId){
        try {
            Integer result=reportdetailService.bhShenHe(reportDetailId);
            ReponseResult data=ReponseResult.ok(result,"报账驳回审核成功");
            logger.info("mothod:bhShenHe 报账驳回审核成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:bhShenHe 报账驳回审核失败");
            return ReponseResult.err("报账驳回审核失败");
        }
    }




    /**
     * 查询调度Id
     * @param
     * @return
     */
    @RequestMapping("/selectDispatchById")
    public ReponseResult selectDispatchById(HttpServletRequest request, Integer groupNumber){
        try {
            ReponseResult data=ReponseResult.ok("查询成功");
            HttpSession session = request.getSession();
            session.setAttribute("dispatchId",groupNumber);
            logger.info("mothod:selectDispatchById 查询成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:selectDispatchById 查询失败");
            return ReponseResult.err("查询失败");
        }
    }

    /**
     * 查询调度Id
     * @param
     * @return
     */
    @RequestMapping("selectReportdetail")
    public ReponseResult selectReportdetail(HttpServletRequest request, Integer reportDetailId){
        try {
            HttpSession session = request.getSession();
            session.setAttribute("reportDetailId",reportDetailId);
            logger.info("mothod:selectDispatchById 查询成功");
            ReponseResult data=ReponseResult.ok("查询成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:selectDispatchById 查询失败");
            return ReponseResult.err("查询失败");
        }
    }



    /**
     * 结算导游报账的审核
     * @param reportDetailId
     * @return
     */
    @RequestMapping("jsShenHe")
    @LogNotes(operationType="导游报账",content="修改审核状态")
    public ReponseResult jsShenHe(Integer reportDetailId){
        try {
            Integer result=reportdetailService.jsShenHe(reportDetailId);
            ReponseResult data=null;
            if (result==1){
                Integer result1=dispatchService.updateState(reportdetailService.getReportdetailById(reportDetailId).getDispatchId());
                if (result1==1){
                    data=ReponseResult.ok(result,"报账结算成功");
                    logger.info("mothod:jsShenHe 报账结算成功");
                }else {
                    data=ReponseResult.err("报账结算失败");
                    logger.error("mothod:jsShenHe 报账结算失败");
                }
            }else {
                data=ReponseResult.err("报账结算失败");
                logger.error("mothod:jsShenHe 报账结算失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:jsShenHe 报账结算失败");
            return ReponseResult.err("报账结算失败");
        }
    }
    /**
     * 查看门票
     * @param dispatchId
     * @return
     */
    @RequestMapping("/wx_getReportticket")
    public ReponseResult<Object> getReportticket(@RequestParam("dispatchId")Integer dispatchId){
        System.out.println(dispatchId);
        try{
            Reportdetail reportdetail =reportdetailMapper.All_dispatchId(dispatchId);
            Reportdetail reportticket=reportdetailService.getReportticket(dispatchId);
            ReponseResult<Object> date=ReponseResult.ok(reportticket,"操作成功");
            logger.info("method:getReportticket 查看门票成功");
            return date;
        }catch (Exception e){
            logger.error("method:getReportticket 查看门票失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }
    /**
     * 查看住宿
     * @param dispatchId
     * @return
     */
    @RequestMapping("/wx_getHotel")
    public ReponseResult<Object> getHotel(Integer dispatchId){
        try{
            Integer data=0;
            Reportaccommodation reportticket=reportdetailService.getHotel(dispatchId);
            ReponseResult<Object> date=ReponseResult.ok(reportticket,"操作成功");
            logger.info("method:getHotel 查看住宿成功");
            return date;
        }catch (Exception e){
            logger.error("method:getHotel 查看住宿失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }
    /**
     * 查看其它
     * @param dispatchId
     * @return
     */
    @RequestMapping("/wx_getReportingotherexpenses")
    public ReponseResult<Object> getReportingotherexpenses(Integer dispatchId){
        try{
            Integer data=0;
            Reportingotherexpenses reportticket=reportdetailService.getReportingotherexpenses(dispatchId);
            ReponseResult<Object> date=ReponseResult.ok(reportticket,"操作成功");
            logger.info("method:getReportingotherexpenses 查看其它成功");
            return date;
        }catch (Exception e){
            logger.error("method:getReportingotherexpenses 查看其它失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }
}
