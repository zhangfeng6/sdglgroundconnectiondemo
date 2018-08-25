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

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 日志 控制层
 **/
@RestController
@RequestMapping("log")
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
}
