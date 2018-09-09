package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Disattr;
import com.dyhc.sdglgroundconnection.pojo.Discar;
import com.dyhc.sdglgroundconnection.service.DisattrService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度景点 控制层
 **/
@RequestMapping("/disattr")
@RestController
public class DisattrController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DisattrController.class);

    @Autowired
    private DisattrService disattrService;


    /**
     * 查看调度景点
     * @return
     */
    @RequestMapping("/DisattrController")
    public ReponseResult CompanyList(HttpServletRequest request){
        Integer offerId;
        HttpSession session = request.getSession();
        offerId=Integer.parseInt(session.getAttribute("dispatchId").toString());
        try{
            List<Disattr> disattr =disattrService.disattr(offerId);
            ReponseResult<List> data= ReponseResult.ok(disattr,"调度景点查询成功！");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
