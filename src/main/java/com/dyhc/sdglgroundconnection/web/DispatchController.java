package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.dyhc.sdglgroundconnection.service.DispatchService;
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

import javax.xml.ws.Response;
import java.util.*;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度 控制层
 **/
@RequestMapping("/dispatch")
@RestController
public class DispatchController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DispatchController.class);

    @Autowired
    private DispatchService dispatchService;

    /**
     * 返回所有调度信息
     * @param pageNo
     * @param pageSize
     * @param djsth
     * @param dyname
     * @param state
     * @return
     */
    @RequestMapping("/listDispatch")
    public ReponseResult listDispatch(@RequestParam("pageNo")Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize,
                                      @RequestParam("djsth")String djsth,
                                      @RequestParam("dyname")String dyname,
                                      @RequestParam("state")Integer state){
        try {
            PageInfo<Dispatch> pageInfo=dispatchService.listDispatch(pageNo, pageSize, djsth, dyname, state);
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"分页获取调度信息成功！");
            logger.info("method:listDispatch 分页获取调度信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listDispatch 系统出现异常！");
            ReponseResult<Object> err=ReponseResult.err("系统出现异常");
            return err;
        }

    }

    /**
     * 订房通知单： 贾晓亮
     * @param dispatchId
     * @return
     */
    @RequestMapping("/dispatchSelectAll")
    public  ReponseResult dispatchSelectAll(Integer dispatchId){
        dispatchId=1;
        try {
            ReponseResult<Dispatch> data =ReponseResult.ok(dispatchService.dispatchSelectAll(dispatchId),"查询计调订房通知单成功");
            logger.info("method:getresource 查询计调订房通知单成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("method:getresource 查询计调订房通知单失败！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    @RequestMapping("/getresource")
    public ReponseResult getresource(){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getresource(),"获取资源数据成功！");
            logger.info("method:getresource 获取资源数据成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getresource 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    @RequestMapping("/listinfoByvalueId")
    public ReponseResult listinfoByvalueId(@RequestParam("type")String type,@RequestParam("valueId")Integer valueId){
        try {
            ReponseResult<List> data=ReponseResult.ok(dispatchService.listinfoByvalueId(type,valueId),"根据类型获取资源！");
            logger.info("method:listinfoByvalueId 根据类型获取资源！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            logger.debug("method:listinfoBycalueId 系统异常");
            return err;
        }
    }


    /**
     * 根据导游id查询调度信息
     * @param guideId 导游id
     * @return
     */
    @RequestMapping("getDispatchByguideId")
    public ReponseResult getDispatchByguideId(Integer guideId){
        try {
            Dispatch dispatch=dispatchService.getDispatchByguideId(guideId);
            Integer date=DateDifference.differentDays(dispatch.getTravelStartTime(),dispatch.getTravelEndTime());
            List<Integer> list=new  ArrayList<Integer>();
            list.add(date);
            list.add(dispatch.getDispatchId());
            ReponseResult data=ReponseResult.ok(list,"获取调度对象成功");
            logger.info("method:getDispatchByguideId 获取调度对象成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getDispatchByguideId 系统异常");
            return ReponseResult.err("获取调度对象失败");
        }
    }




    /**
     *根据导游报账明细id获取调度信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("getDispatchById")
    public ReponseResult getDispatchById(Integer reportDetailId){
        try {
            Dispatch dispatch=dispatchService.getDispatchById(reportDetailId);
            Integer cha=DateDifference.differentDays(dispatch.getTravelStartTime(),dispatch.getTravelEndTime());
            List<Object> list=new ArrayList<>();
            list.add(0,dispatch);
            list.add(1,cha);
            ReponseResult data=ReponseResult.ok(list,"获取成功");
            logger.info("mothed:getDispatchById 获取调度信息成功");
            return data;
        }catch (Exception e){
            logger.error("mothed:getDispatchById 获取调度信息失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    @RequestMapping("/listDispatchlike")
    public ReponseResult listDispatchlike(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize, @RequestParam("guideName")String guideName, @RequestParam("groundConnectionNumber")String groundConnectionNumber){
        try{
            System.out.println("..."+groundConnectionNumber+"...");
            PageInfo<Dispatch> pageInfoTravel=dispatchService.ListDispatchLike(pageNo,pageSize,guideName,groundConnectionNumber);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取调度信息成功！");
            logger.info(" method:TravelLike  分页获取调度信息成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:TravelLike  获取调度信息数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    @RequestMapping("/updatestateById")
    public ReponseResult updatestateById(@RequestParam("did")Integer did,
                                         @RequestParam("gid")Integer gid,
                                         @RequestParam("travelStartTime")String travelStartTime,
                                         @RequestParam("travelEndTime")String travelEndTime){
        try {
            ReponseResult<Integer> data=ReponseResult.ok(dispatchService.updatestateById(did, gid, travelStartTime, travelEndTime),"审核成功！");
            logger.info("method:updatestateById 审核成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     *根据报价单Id获取报价信息 张枫
     * @param oid
     * @return
     */
    @RequestMapping("/getofferinfoById")
    public ReponseResult getofferinfoById(@RequestParam("oid")Integer oid){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getofferinfoById(oid),"获取报价信息成功！");
            logger.info("method:getofferinfoById 获取报价信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getofferinfoById 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }
}
