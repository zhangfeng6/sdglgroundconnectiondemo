package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Discar;
import com.dyhc.sdglgroundconnection.service.DiscarService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度用车 控制层
 **/
@RequestMapping("/Discar")
@RestController
public class DiscarController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DiscarController.class);

    @Autowired
    private DiscarService discarService;


    /**
     * 查看调度车辆
     * @return
     */
    @RequestMapping("/DiscarController")
    public ReponseResult CompanyList(HttpServletRequest request){
        Integer disCarId;
        HttpSession session = request.getSession();
        disCarId=Integer.parseInt(session.getAttribute("disCarId").toString());
        try{
            Discar discar=discarService.discar(disCarId);
            logger.info(" method:CompanyList  调度车辆查询成功！");
            ReponseResult<Discar> data= ReponseResult.ok(discar,"调度车辆查询成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:CompanyList  调度车辆查询失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 查看车辆公司
     * @param dispatchId
     * @return
     */
    @RequestMapping("/findDiscar.html")
    public ReponseResult findDiscar(Integer dispatchId){
        try{
            Discar discar=discarService.listDiscar(dispatchId);
            logger.info(" method:findDiscar  查看车辆公司成功！");
            return ReponseResult.ok(discar,"查看车辆公司成功！");
        }catch (Exception e) {
            logger.error(" method:findDiscar  查看车辆公司失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
