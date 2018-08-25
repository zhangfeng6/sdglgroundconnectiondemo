package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.parameterentity.TemplateParameter;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.dyhc.sdglgroundconnection.service.ScenicspotService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ScenicspotService scenicspotService;


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

    /**
     * 获取添加信息的资源信息  张枫
     * @return
     */
    @RequestMapping("/getResource")
    public ReponseResult getResource(){
        try {
            List<Hotel> hotelList=hotelService.listHotelNoPage();
            List<Scenicspot> scenicspotList=scenicspotService.listScenicspotAll();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("hotel",hotelList);
            map.put("scenicspot",scenicspotList);
            ReponseResult<Map> data=ReponseResult.ok(map,"获取模板资源成功");
            logger.info("method:getResource  获取模板资源成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getResource 获取资源数据失败，系统出现异常！");
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }

    }

    /**
     * 判断模板名称是否可用
     * @param templateName  模板名称
     * @return
     */
    @RequestMapping("/judgeTemplateName")
    public ReponseResult judgeTemplateName(@RequestParam("templateName")String templateName){
        try {
            Boolean flag=true;
            Template template=templateService.gettemplateByName(templateName);
            if(template==null){ flag=true; }else{flag=false;}
            ReponseResult<Boolean> data=ReponseResult.ok(flag,"获取数据成功！");
            logger.info("method:judgeTemplateName 调用判断模板名称！");
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:judgeTemplateName 系统出现异常！");
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    @RequestMapping("/saveTemplate")
    public ReponseResult  saveTemplate(TemplateParameter templateParameter){
        try {
            ReponseResult<Integer> data=ReponseResult.ok(templateService.savetemplate(templateParameter),"添加数据成功！");
            logger.info("method:saveTemplate 添加模板数据！");
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:saveTemplate 系统出现异常！");
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }



    @RequestMapping("/selectTemplate")
    public ReponseResult selectTemplate() {
        try {
            List<Template> list = templateService.selectTemplate();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectTemplate  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTemplate  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }

    @RequestMapping("/selectTemplateAll")
    public ReponseResult selectTemplateAll(Integer templateId) {
        try {
            Template template = templateService.selectTemplateAll(templateId);
            ReponseResult<Object> data = ReponseResult.ok(template,"查询成功！");
            logger.info(" method:selectTemplateAll  查询线路全部信息成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTemplateAll  查询线路全部信息失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
}
