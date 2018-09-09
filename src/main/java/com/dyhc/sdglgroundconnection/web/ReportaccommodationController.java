package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.dyhc.sdglgroundconnection.service.ReportaccommodationService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账住宿 控制层
 **/
@RestController
@RequestMapping("/Reportaccommodation")
public class ReportaccommodationController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportaccommodationController.class);

    @Autowired
    private ReportaccommodationService reportaccommodationService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ReportdetailMapper reportdetailMapper;
    /**
     * 导游报账住宿新增
     * @param
     * @return
     *//*
    @LogNotes(operationType="导游报账",content="住宿新增")
    @RequestMapping("/save_Reportaccommodation")
    public ReponseResult saveAccountType(
            @RequestParam("hotelName")String hotelName,
            @RequestParam("typeId")Integer typeId,
            @RequestParam("housePrice")Double housePrice,
            @RequestParam("roomNum")Integer roomNum,
            @RequestParam("accompanyingBed")Integer accompanyingBed,
            @RequestParam("accompanyingPrice")Double accompanyingPrice,
            @RequestParam("subtotal")Double subtotal,
            @RequestParam("payMethods")String payMethods){
        //创建总报账表的对象
        Reportdetail reportdetail =reportdetailMapper.All_dispatchId(1);
        //创建报账住宿
        Reportaccommodation reportaccommodation =new Reportaccommodation();
        reportaccommodation.setReportDetailId(reportdetail.getReportDetailId());
        reportaccommodation.setHotelName(hotelName);
        reportaccommodation.setTypeId(typeId);
        reportaccommodation.setHousePrice(housePrice);
        reportaccommodation.setRoomNum(roomNum);
        reportaccommodation.setAccompanyingBed(accompanyingBed);
        reportaccommodation.setAccompanyingPrice(accompanyingPrice);
        reportaccommodation.setSubtotal(subtotal);
        reportaccommodation.setPayMethods(payMethods);
        reportaccommodation.setLiveDate(new Date());
        reportaccommodation.setStatus(0);
        try {
            Integer num=reportaccommodationService.saveReportaccommodation(reportaccommodation) ;
            logger.info("method:savereportaccommodation 导游报账住宿新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("住宿报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游报账住宿新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }*/


    /**
     *  查询全部酒店
     * @return
     */
    @LogNotes(operationType="酒店查询成功",content="酒店查询成功")
    @RequestMapping("/jiudianquanbu")
    public ReponseResult Reportaccommodation(){
        System.out.println("进来酒店查询了！");
        try {
            List<Hotel> num=hotelService.selectAllHotel();
            logger.info("method:savereportaccommodation 酒店查询成功");
            ReponseResult<Object> data =ReponseResult.ok(num,"酒店查询成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 酒店查询失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    /**
     * 获取导游住宿报账信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("listReportAccommodationById")
    public ReponseResult listReportAccommodationById(Integer reportDetailId){
        try {
            ReponseResult data=ReponseResult.ok(reportaccommodationService.listReportaccommodationByreportDetailId(reportDetailId),"获取导游住宿报账明细成功");
            logger.info("mothod:listReportAccommodationById 获取导游住宿报账明细成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:listReportAccommodationById 获取导游住宿报账明细失败");
            return ReponseResult.err("获取导游住宿报账明细失败");
        }
    }
}
