package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import com.dyhc.sdglgroundconnection.service.TemplateScenicspotService;
import com.dyhc.sdglgroundconnection.service.TourismandlineService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Tourismandline")
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Tourismandline")
>>>>>>> origin/master
public class TourismandlineController {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismandlineService tourismandlineService;


    @RequestMapping("/selectTourismandlineAll")
    public ReponseResult selectTourismandlineAll(Integer tourismId) {
        try {
            List<Tourismandline> tourismandline = tourismandlineService.selectTourismandlineAll(tourismId);
            ReponseResult<Object> data = ReponseResult.ok(tourismandline,"查询成功！");
            logger.info(" method:selectTemplateAll  查询模板中的线路全部信息成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTemplateAll  查询模板中的线路全部信息失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
}
