package com.dyhc.sdglgroundconnection.web;

import com.alibaba.fastjson.JSON;
import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.dyhc.sdglgroundconnection.service.GuideService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.dyhc.sdglgroundconnection.utils.WechatFileUploadUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Vector;


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
            System.out.println(password);
            Guide guide=guideService.login(username,password);
            if (guide!=null){
                if(password.equals(guide.getPassword())){
                    logger.info("method:login 微信登录成功");
                    return ReponseResult.ok(guide,"登录成功");
                }else {
                    logger.error("method:login 微信登录失败");
                    return ReponseResult.err("登录失败");
                }
            }else {
                logger.error("method:login 微信登录失败");
                return ReponseResult.err("登录失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:login 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }

    @RequestMapping("/listguidescheduleBygid")
    public ReponseResult listguidescheduleBygid(@RequestParam("year")String year,
                                                @RequestParam("month")String month){
        try {
            ReponseResult<List> data=ReponseResult.ok(guideService.listguidescheduleBygid(year, month),"获取导游安排信息成功！");
            logger.info("method:listguidescheduleBygid   获取导游安排信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listguidescheduleBygid 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }

    }
    /**
     * 上传单据
     * @return
     */
    @RequestMapping("upload")
    public ReponseResult upload(HttpServletRequest request,@RequestParam("multipartFile") MultipartFile multipartFile){
        try {
            Vector<String> list= WechatFileUploadUtil.uploadImage(request,".jpg");
            String aa= request.getParameter("guideId");
            System.out.println(aa);
            return ReponseResult.ok(list,"上传成功");
        }catch (Exception e){
            e.printStackTrace();
            return ReponseResult.err("上传失败");
        }
    }

    /**
     * 微信小程序之判断旧密码是否输入正确
     * @param password
     * @return
     */
    @RequestMapping("pdOldPassword")
    public ReponseResult pdOldPassword(String password,Integer guideId){
        try {
            Guide guide=guideService.assignmentGuide(guideId);
            if (guide!=null){
                if(password.equals(guide.getPassword())){
                    logger.info("method:pdOldPassword 旧密码输入正确");
                    return ReponseResult.ok(1,"旧密码输入正确");
                }else {
                    logger.error("method:pdOldPassword 旧密码输入失败");
                    return ReponseResult.err("旧密码输入失败");
                }
            }else {
                logger.error("method:pdOldPassword 旧密码输入失败");
                return ReponseResult.err("旧密码输入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:pdOldPassword 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }

    /**
     * 微信小程序之修改密码
     * @return
     */
    @RequestMapping("updateGuideByPassword")
    public ReponseResult updateGuideByPassword(Guide guide){
        try {
            Integer result=guideService.updateGuideByPassword(guide);
            if (result==1){
                logger.info("method:updateGuideByPassword 修改密码成功");
                return ReponseResult.ok(result,"修改成功");
            }else {
                logger.error("method:updateGuideByPassword 修改密码失败");
                return ReponseResult.err("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:updateGuideByPassword 修改密码失败");
            return ReponseResult.err("修改失败");
        }
    }


    /**
     * 获取导游名称
     * @param guideId
     * @return
     */
    @RequestMapping("guideId")
    public ReponseResult getGuideById(Integer guideId){
        try {
            Guide guide=guideService.getGuideById(guideId);
            logger.info("method:updateGuideByPassword 获取成功");
            return ReponseResult.ok(guide,"获取成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:updateGuideByPassword 获取失败");
            return ReponseResult.err("获取失败");
        }
    }
    /**
     * 获取所有导游名称
     * @return
     */
    @RequestMapping("listGuideName")
    public ReponseResult listGuideName(){
        try {
            List<Guide> guide=guideService.listGuideName();
            logger.info("method:listGuideName 获取成功");
            return ReponseResult.ok(guide,"获取成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:listGuideName 获取失败");
            return ReponseResult.err("获取失败");
        }
    }

}
