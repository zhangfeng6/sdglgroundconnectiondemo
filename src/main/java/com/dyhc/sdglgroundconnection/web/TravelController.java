package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import com.dyhc.sdglgroundconnection.pojo.Disrestaurant;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.service.TravelService;
import com.dyhc.sdglgroundconnection.utils.DateDifference;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社 控制层
 **/
@RestController
@RequestMapping("Travel")
public class TravelController{

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TravelController.class);

    @Autowired
    private TravelService travelService;

    @RequestMapping("/selectTravel")
    public ReponseResult selectTravel() {
        try {
            List<Travel> list = travelService.selectTravel();
            ReponseResult<Object> data = ReponseResult.ok(list, "查询成功！");
            logger.info(" method:selectTravel  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTravel  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
    /**
     * 修改信息
     * @param travel
     * @return
     */
    @RequestMapping("/showTravelUpd.html")
    public ReponseResult<Integer> showTravelUpd(Travel travel){
        System.out.println(travel);
        try{
            Integer data=0;
            Integer travel1=travelService.getupdlala(travel);
            if(travel1>0){
                data=1;
            }
            logger.info(" method:showTravelDel  修改组团社成功！");
            return ReponseResult.ok(data,"修改取组团社成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelDel  修改组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     *添加信息
     * @param travel
     * @return
     */
    @RequestMapping("/showTravelAdd.html")
    public ReponseResult<Integer> showTravelAdd(Travel travel){
        System.out.println(travel);
        try{
            travel.setWhetherDel(0);
            Integer result=0;
            Integer data=0;
            result=travelService.getAddTravel(travel);
            if(result>0){
                data=1;
            }
            logger.info(" method:showTravelAdd  添加组团社成功！");
            return ReponseResult.ok(data,"添加取组团社成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelAdd  添加组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 按条件查看分页显示
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/showtravellike.html")
    public ReponseResult TravelLike(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize, @RequestParam("travelName")String travelName){
        try{
            System.out.println("..."+travelName+"...");
            PageInfo<Travel> pageInfoTravel=travelService.listTravelLike(pageNo,pageSize,travelName);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取组团社成功！");
            logger.info(" method:TravelLike  分页获取组团社成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:TravelLike  获取组团社数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    @RequestMapping("/selectTravelById")
    public ReponseResult selectTravelById(Integer travelId) {
        try {
            Travel travel = travelService.selectTravelById(travelId);
            ReponseResult<Object> data = ReponseResult.ok(travel,"查询成功！");
            logger.info(" method:selectTravelById  查询组团社成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTravelById  查询组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }

    /**
     * 按条件查看
     * @param travelId
     * @return
     */
    @RequestMapping("/showTravelselectbyid.html")
    public ReponseResult<Integer> showTravelselectbyid(Integer travelId){
        try{
            Integer result=0;
            Integer data=0;
            result=travelService.getselectById(travelId);
            if(result>0){
                data=1;
            }
            logger.info(" method:showTravelselectbyid  添加组团社成功！");
            return ReponseResult.ok(data,"添加取组团社成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelselectbyid  添加组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 删除   修改
     * @param travelId
     * @return
     */
    @RequestMapping("/showTravelupdlala.html")
    public ReponseResult<Integer> showTravelupdlala(Integer travelId){
        try{
            Integer result=0;
            Integer data=0;
            result=travelService.getUpdTrave(travelId);
            if(result>0){
                data=1;
            }
            logger.info(" method:showTravelupdlala  添加组团社成功！");
            return ReponseResult.ok(data,"添加取组团社成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelupdlala  添加组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 修改   chakan
     * @param travelId
     * @return
     */
    @RequestMapping("/findTravelupdlala.html")
    public ReponseResult findTravelupdlala(Integer travelId){
        try{
            Travel travel=travelService.getupdBytravelId(travelId);
            logger.info(" method:showTravelupdlala  查看组团社成功！");
            return ReponseResult.ok(travel,"查看取组团社成功！");
        }catch (Exception e) {
            logger.error(" method:showTravelupdlala  查看组团社失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 根据组团社号获取组团社名称
     * @param groupNumber
     * @return
     */
    @RequestMapping("getTravelName")
    public ReponseResult getTravelName(Integer groupNumber){
        try {
            ReponseResult data=ReponseResult.ok(travelService.getTravelName(groupNumber),"获取成功");
            logger.info("method:getTravelName  获取组团社名称成功");
            return data;
        }catch (Exception e){
            logger.error("method:getTravelName  获取组团社名称失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectGuideByTravelId")
    public ReponseResult selectGuideByTravelId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectGuideByTravelId(travelId),"获取成功");
            logger.info("method:selectGuideByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectGuideByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectStaffByTraveId")
    public ReponseResult selectStaffByTraveId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectStaffByTraveId(travelId),"获取成功");
            logger.info("method:selectStaffByTraveId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectStaffByTraveId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }


    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectDispatchByTravelId")
    public ReponseResult selectDispatchByTravelId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectDispatchByTravelId(travelId),"获取成功");
            logger.info("method:selectDispatchByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectDispatchByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }



    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectReportrestaurantByTravelId")
    public ReponseResult selectReportrestaurantByTravelId(Integer travelId){
        try {
            List<Disrestaurant> disrestaurants = travelService.selectReportrestaurantByTravelId(travelId);
            List<Dispatchhotel> dispatchhotels = travelService.selectReportaccommodationByTravelId(travelId);
            List<Disrestaurant> disrestaurants1 = travelService.selectReportrestaurantByTravelId1(travelId);
            List list = new ArrayList();
            list.add(disrestaurants);
            list.add(dispatchhotels);
            list.add(disrestaurants1);
            ReponseResult data=ReponseResult.ok(list,"获取成功");
            logger.info("method:selectReportrestaurantByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectReportrestaurantByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }


    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectOfferByTravelId")
    public ReponseResult selectOfferByTravelId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectOfferByTravelId(travelId),"获取成功");
            logger.info("method:selectOfferByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectOfferByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectReportfareByTravelId")
    public ReponseResult selectReportfareByTravelId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectReportfareByTravelId(travelId),"获取成功");
            logger.info("method:selectReportfareByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectReportfareByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 根据组团社号获取
     * @param
     * @return
     */
    @RequestMapping("selectReportticketByTravelId")
    public ReponseResult selectReportticketByTravelId(Integer travelId){
        try {
            ReponseResult data=ReponseResult.ok(travelService.selectReportticketByTravelId(travelId),"获取成功");
            logger.info("method:selectReportfareByTravelId  获取成功");
            return data;
        }catch (Exception e){
            logger.error("method:selectReportfareByTravelId  获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

}
