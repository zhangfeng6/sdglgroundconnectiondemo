package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Disguide;
import com.dyhc.sdglgroundconnection.service.DisguideService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度导游 控制层
 **/
@RestController
public class DisguideController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DisguideController.class);

    @Autowired
    private DisguideService disguideService;

    /**
     * 查看行程计划
     * @param dispatchId
     * @return
     */
    @RequestMapping("/findDisguide.html")
    public ReponseResult findDisguide(Integer dispatchId){
        try{
            Disguide disguide=disguideService.DisguideAll(dispatchId);
            logger.info(" method:showTravelupdlala  查看行程计划成功！");
            return ReponseResult.ok(disguide,"查看行程计划成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelupdlala  查看行程计划失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

}
