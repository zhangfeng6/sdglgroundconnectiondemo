package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Log;
import com.dyhc.sdglgroundconnection.service.LogService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 日志 控制层
 **/
@RestController
@RequestMapping("/log")
public class LogController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    /**
     * 添加带团日志
     * @param log
     * @return
     */
    @RequestMapping("insertLog")
    @LogNotes(operationType="日志",content="添加")
    public ReponseResult insertLog(Log log){
        try {
            log.setWhetherDel(0);
            log.setCreater(1);
            log.setCreationDate(new Date());
            Integer result=logService.inserLog(log);
            ReponseResult data=null;
            if (result==1){
                logger.info("Mothod:insertLog  上传日志成功");
                data=ReponseResult.ok(result,"上传日志成功");
            }else {
                logger.info("Mothod:insertLog  上传日志失败");
                data=ReponseResult.ok(result,"上传日志失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Mothod:insertLog  上传日志失败");
            return ReponseResult.err("上传日志失败");
        }
    }

    /**
     * 导游日志表
     * @return
     */
    @RequestMapping("/log")
    @LogNotes(operationType="日志",content="显示")
    public  ReponseResult logShowAll(Integer guideId,Integer dispatchId,String creationDate){
        guideId=1;
        dispatchId=1;
        creationDate="2018-04-14";
        try {
             Log log=logService.ShowAllLog(guideId,dispatchId,creationDate);
             ReponseResult<Log> data=ReponseResult.ok(log,"日志显示成功");
            logger.info("Mothod:insertLog  日志显示成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Mothod:insertLog  显示日志失败");
            return ReponseResult.err("显示失败");
        }
    }
}
