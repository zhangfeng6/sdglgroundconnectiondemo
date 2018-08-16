package com.dyhc.sdglgroundconnection.web;

import com.alibaba.fastjson.JSON;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.Operationlog;
import com.dyhc.sdglgroundconnection.service.OperationlogService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 操作日志 控制层
 **/
@RequestMapping("/Operationlog")
@RestController
public class OperationlogController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OperationlogController.class);

    @Autowired
    private OperationlogService operationlogService;

    /**
     * 获取指定的日志信息
     * @param pageNo         当前页
     * @param pageSize       每页显示量
     * @param theUserName    操作人账户
     * @param createDate     操作日期
     * @return
     */
    @RequestMapping("/listOperationlog")
    public ReponseResult listOperationlog(@RequestParam("page") Integer pageNo,
                                   @RequestParam("limit") Integer pageSize,
                                   @RequestParam("theUserName")String theUserName,
                                   @RequestParam("createDate")String createDate) {
        try {
            PageInfo<Operationlog> pageInfo = operationlogService.listOperationlog(theUserName,createDate,pageNo,pageSize);
            ReponseResult<List> data = ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(), "分页获取日志成功！");
            logger.info(" method:listOperationlog  分页获取日志成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:listOperationlog  获取日志数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    @RequestMapping("/removeOperationlog")
    @LogNotes(operationType = "日志",content = "删除")
    public ReponseResult removeOperationlog(@RequestParam("id") Integer id) {
        try {
            Operationlog operationlog=new Operationlog();
            operationlog.setOperationLogId(id);
            operationlog.setStatus(1);
            ReponseResult<Integer> data = ReponseResult.ok(operationlogService.removeOperationlogById(operationlog),"删除日志成功！");
            logger.info(" method:removeOperationlog  删除日志数据成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:removeOperationlog  删除日志数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
