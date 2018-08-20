package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import com.dyhc.sdglgroundconnection.service.TemplateScenicspotService;
import com.dyhc.sdglgroundconnection.service.TourismandlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourismandlineController {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismandlineService tourismandlineService;
}
