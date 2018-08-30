package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.GuideScheduleService;
import com.dyhc.sdglgroundconnection.service.impl.DispatchServiceImpl;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游 控制层
 **/
@RequestMapping("/GuideSchedule")
@RestController
public class GuideScheduleController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(GuideController.class);

    @Autowired
    private GuideScheduleService guideScheduleService;
    @Autowired
    private DispatchServiceImpl dispatchService;


    /**
     * 添加导游请假信息
     * @param guideId
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("insertGuideSchedule")
    public ReponseResult insertGuideSchedule(Integer guideId,String startDate,String endDate,Integer arrangetype){
        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date1=dateFormat.parse(startDate);
            Date date2=dateFormat.parse(endDate);
            List<Date> dates=dispatchService.getBetweenDates(date1,date2);
            List<Guideschedule> list=new ArrayList<>();
            for (Date date:dates) {
                String aa=dateFormat.format(date);
                String[] bb=aa.split("-");
                Guideschedule guideschedule=new Guideschedule();
                guideschedule.setGuideId(guideId);
                guideschedule.setArrangeyear(bb[0]);
                guideschedule.setArrangemonth(bb[1]);
                guideschedule.setArrangeday(bb[2]);
                guideschedule.setArrangetype(arrangetype);
                guideschedule.setCreateBy(1);
                guideschedule.setCreateDate(new Date());
                guideschedule.setWhetherDel(0);
                list.add(guideschedule);
            }
            Integer result=guideScheduleService.insertGuideSchedule(list);
            ReponseResult data=ReponseResult.ok(result,"添加成功");
            logger.info("mothod:insertGuideSchedule");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:insertGuideSchedule 添加失败");
            return ReponseResult.err("添加失败");
        }
    }

}
