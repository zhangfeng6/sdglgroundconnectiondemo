package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.service.TemplateService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板 控制层
 **/
@RequestMapping("/Template")
@RestController
public class TemplateController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;


    /**
     * 根据条件分页获取模板数据     张枫
     * @param pageNo        当前页
     * @param pageSize      每页显示量
     * @param tempName      模板名称
     * @param username      创建人账户
     * @return               ReponseResult对象
     */
    @RequestMapping("/listTemplate")
    public ReponseResult listTemplate(@RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize,
                               @RequestParam("tempName")String tempName,
                               @RequestParam("username")String username){
        try {
            PageInfo<Template> pageInfo=templateService.listtemplate(tempName,username,pageNo,pageSize);
            ReponseResult<List<Template>> data=ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(),"获取模板信息分页成功");
            logger.info("methor:listTemplate 获取模板数据成功");
            return data;
        } catch (Exception e) {
            logger.debug("method:listTemplate  获取模板数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }

    }
}
