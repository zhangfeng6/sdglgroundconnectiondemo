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
    public ReponseResult CompanyList(Integer disCarId){
        disCarId=1;
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
}
