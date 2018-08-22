package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.dyhc.sdglgroundconnection.service.GuideService;
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

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游 控制层
 **/
@RequestMapping("/Guide")
@RestController
public class GuideController{

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(GuideController.class);

    @Autowired
    private GuideService guideService;


    @LogNotes(operationType="导游表",content="导游模糊查询")
    @RequestMapping("/guideShowAll")
    public ReponseResult showGuide(@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize, @RequestParam("guideName")String guideName){
        try {
            PageInfo<Guide> pageInfo=guideService.listGuide(pageNo,pageSize,guideName);
            ReponseResult<List> data =ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"导游信息分页成功!");
            logger.info("method:showAccountType 导游信息成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息分页失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    @LogNotes(operationType="导游表",content="导游删除")
    @RequestMapping("/guideRemove")
    public  ReponseResult removeGuide(@RequestParam("guideId") Integer guideId){
        try {
            ReponseResult<Integer> data =ReponseResult.ok(guideService.removeGuide(guideId),"导游信息删除成功!");
            logger.info("method:showAccountType 导游删除成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游删除分页失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    @LogNotes(operationType="导游表",content="导游新增")
    @RequestMapping("/guideSave")
    public  ReponseResult saveGuide(Guide guide){
        try {
            ReponseResult<Integer> data =ReponseResult.ok(guideService.saveGuide(guide),"导游信息新增成功!");
            logger.info("method:showAccountType 导游信息新增成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    @LogNotes(operationType="导游表",content="导游修改")
    @RequestMapping("/guideUpdate")
    public  ReponseResult updateGuide(Guide guide){
        try {
            ReponseResult<Integer> data =ReponseResult.ok(guideService.updateGuide(guide),"导游信息修改成功!");
            logger.info("method:showAccountType 导游信息修改成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息修改失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    @LogNotes(operationType="导游表",content="导游修改赋值 ")
    @RequestMapping("/assignmentGuide")
    public  ReponseResult assignmentGuide(@RequestParam("guideId") Integer guideId){
        try {
            ReponseResult<Guide> data =ReponseResult.ok(guideService.assignmentGuide(guideId),"导游信息修改赋值成功!");
            logger.info("method:showAccountType 导游信息修改赋值成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息修改赋值失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

    /**
     * 微信登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("guideLogin")
    public ReponseResult guideLogin(String username,String password){
        try {
            Guide guide=guideService.login(username,password);
            if (guide==null){
                logger.error("method:login 微信登录失败");
                return ReponseResult.err("登录失败");
            }else {
                logger.info("method:login 微信登录成功");
                return ReponseResult.ok(guide,"登录成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:login 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }


}
