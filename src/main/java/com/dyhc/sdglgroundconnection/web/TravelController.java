package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.service.TravelService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社 控制层
 **/
@RestController
@RequestMapping("Travel")
public class TravelController{

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TravelController.class);

    @Autowired
    private TravelService travelService;

    @RequestMapping("/selectTravel")
    public ReponseResult selectTravel() {
        try {
            List<Travel> list = travelService.selectTravel();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectTravel  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTravel  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }


    @RequestMapping("/selectTravelById")
    public ReponseResult selectTravelById(Integer travelId) {
        try {
            Travel travel = travelService.selectTravelById(travelId);
            ReponseResult<Object> data = ReponseResult.ok(travel,"查询成功！");
            logger.info(" method:selectTravelById  查询组团社成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTravelById  查询组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
}
