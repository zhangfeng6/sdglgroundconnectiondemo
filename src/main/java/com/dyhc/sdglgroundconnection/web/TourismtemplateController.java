package com.dyhc.sdglgroundconnection.web;

<<<<<<< HEAD
import com.dyhc.sdglgroundconnection.pojo.Restaurant;
=======
>>>>>>> origin/master
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TemplateScenicspotService;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
<<<<<<< HEAD
=======
import com.github.pagehelper.PageInfo;
>>>>>>> origin/master
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Tourismtemplate")
=======
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Tourismtemplate")
>>>>>>> origin/master
public class TourismtemplateController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismtemplateService tourismtemplateService;

<<<<<<< HEAD
    @RequestMapping("/selectTourismtemplate")
    public ReponseResult selectTourismtemplate() {
        try {
            List<Tourismtemplate> list = tourismtemplateService.selectTourismtemplate();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectTourismtemplate  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTourismtemplate  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
=======
    /**
     * 获取所有模板信息
     * @param tempname
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
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
>>>>>>> origin/master
            return err;
        }
    }

<<<<<<< HEAD
=======
    /**
     * 删除模板信息
     * @param tid
     * @return
     */
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

    /**
     * 判断该模板名称是否存在
     * @param temName
     * @return
     */
    @RequestMapping("/jumptempName")
    public ReponseResult jumptempName(@RequestParam("temName")String temName){
        try {
            ReponseResult<Boolean> data=ReponseResult.ok(tourismtemplateService.getinfoBytemName(temName),"获取判断结果成功！");
            logger.info("method:removetourism 获取判断信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }


    @RequestMapping("/saveorupdate")
    public ReponseResult saveorupdate(@RequestParam("temName")String temName,
                                      @RequestParam("info[]")Integer[] info,
                                      @RequestParam("id")Integer id){
        try {
            if(id==null){
                id=0;
            }
            ReponseResult<Integer> data=ReponseResult.ok(tourismtemplateService.savetourismtermplate(temName,info,id),"操作成功！");
            logger.info("method:saveorupdate 执行添加或修改操作成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:saveorupdate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }

    }

    @RequestMapping("/listtandlById")
    public ReponseResult listtandlById(@RequestParam("tid")Integer tid){
        try {
            ReponseResult<Map> data=ReponseResult.ok(tourismtemplateService.listtandlBytid(tid),"根据id获取线路信息成功！");
            logger.info("methor:listtandlById 根据id获取线路信息成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:removeTemplate 系统出现异常！");
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
>>>>>>> origin/master
}
