package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.StaffService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员 控制层
 **/
@RequestMapping("/Staff")
@RestController
public class StaffController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    /**
     * 查询人员全部信息
     * @return
     */
    @LogNotes(operationType="用户信息",content="查询账户")
    @RequestMapping("/showAllstaff")
    public ReponseResult showAllstaff(){
        try {
            ReponseResult<List<Staff>> data =ReponseResult.ok(staffService.idAccountType(),"查询成功");
            logger.info("method:showAccountType 人员查询成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 人员查询失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return error;
        }
    }


    /**
     * 赵伟伟
     * @param theUserName
     * @param password
     * @return
     */
    @RequestMapping("login")
    public ReponseResult login(String theUserName,String password){
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象

        Staff staff = new Staff();
        try {
            staff = staffService.login(theUserName,password);
            if(staff==null){
                ReponseResult<Integer> err = ReponseResult.ok(-1,"用户名和密码不存在！");
                System.out.println(err);
                return err;
            }else{
                session.setAttribute("staff",staff);
                logger.info(staff.getStaffname()+"登陆成功！");
                int role = staff.getRoleId();
                ReponseResult<Integer> info = ReponseResult.ok(role,"登陆成功！");
                System.out.println(info);
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("method:login  登陆失败！");
            ReponseResult<Integer> err = ReponseResult.ok(-1,"登录失败！");
            System.out.println(err);
            return err;
        }
    }
}
