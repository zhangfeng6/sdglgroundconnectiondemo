package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.service.ScenicspotService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点 控制层
 **/
@RestController
@RequestMapping("/Scenicspot")
public class ScenicspotController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ScenicspotController.class);

    @Autowired
    private ScenicspotService scenicspotService;


    /**
     * 根据条件查询景点
     * @param typeId
     * @param scenicSpotName
     * @param scenicSpotAddress
     * @param whetherDel
     * @param pageNo
     * @return
     */
    @RequestMapping("/listScenicspots")
    public ReponseResult listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer whetherDel, Integer pageNo) {
        try {
            PageInfo<Scenicspot> scenicspotPageInfo = scenicspotService.listScenicspots(typeId, scenicSpotName, scenicSpotAddress, whetherDel, pageNo, 2);
            ReponseResult<List> data = ReponseResult.ok(scenicspotPageInfo.getList(), scenicspotPageInfo.getTotal(), "分页获取景点成功！");
            logger.info(" method:showHotel  分页获取景点成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取景点数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    @RequestMapping("/getScenicspotByParentId")
    public ReponseResult getScenicspotByParentId(Integer parentId){
        try {
            PageInfo<Scenicspot> scenicspotPageInfo = scenicspotService.getScenicspotByParentId(parentId);
            ReponseResult<List> data = ReponseResult.ok(scenicspotPageInfo.getList(), scenicspotPageInfo.getTotal(), "分页获取景点成功！");
            logger.info(" method:showHotel  分页获取景点成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取景点数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

}
