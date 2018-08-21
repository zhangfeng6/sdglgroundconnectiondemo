package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TemplateScenicspotService;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Tourismtemplate")
public class TourismtemplateController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismtemplateService tourismtemplateService;

    @RequestMapping("/listtourismtemplate")
    public ReponseResult listtourismtemplate(@RequestParam("tempname")String tempname,
                                             @RequestParam("username")String username,
                                             @RequestParam("pageNo")Integer pageNo,
                                             @RequestParam("pageSize")Integer pageSize){
        try {
            PageInfo<Tourismtemplate> page=tourismtemplateService.listtemplate(tempname, username, pageNo, pageSize);
            ReponseResult<List> data=ReponseResult.ok(page.getList(),page.getTotal(),"分页获取模板信息成功！");
            logger.info("method:listtourismtemplate 分页获取模板信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    @RequestMapping("/removetourism")
    @LogNotes(operationType = "删除",content = "模板")
    public ReponseResult removetourism(@RequestParam("tid")Integer tid){
        try {
            int result=tourismtemplateService.removetourismtemplate(tid);
            ReponseResult<Integer> data=ReponseResult.ok(result,"删除模板信息成功！");
            logger.info("method:removetourism 删除模板信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

}
