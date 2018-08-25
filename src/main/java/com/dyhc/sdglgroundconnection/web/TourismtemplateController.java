package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TemplateScenicspotService;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Tourismtemplate")
public class TourismtemplateController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismtemplateService tourismtemplateService;

    @RequestMapping("/selectTourismtemplate")
    public ReponseResult selectTourismtemplate() {
        try {
            List<Tourismtemplate> list = tourismtemplateService.selectTourismtemplate();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectTourismtemplate  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTourismtemplate  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }

}
