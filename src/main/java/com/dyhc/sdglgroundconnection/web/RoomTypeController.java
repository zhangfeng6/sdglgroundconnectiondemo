package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.service.RoomTypeService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型 控制层
 **/
@RequestMapping("/RoomType")
@RestController
public class RoomTypeController{

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(RoomTypeController.class);

    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping("/judgeTypeName")
    public ReponseResult judgeTypeName(@RequestParam("hotelId")Integer hotelId,@RequestParam("valueId")Integer valueId){
        try {
            System.out.println("..."+roomTypeService.judgeTypeName(hotelId, valueId)+"...");
            ReponseResult<Boolean> data=ReponseResult.ok(roomTypeService.judgeTypeName(hotelId, valueId),"判断成功！");
            logger.info("method:judgeTypeName 判断成功!");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:judgeTypeName 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     * 查询酒店房间类型名称（贾晓亮）
     * @return
     */
    @RequestMapping("/roomType_All")
    public ReponseResult roomType_All(@RequestParam("hotelId")Integer hotelId){
        try {
            ReponseResult<Object> data=ReponseResult.ok(roomTypeService.roomType_All(hotelId),"查询成功成功！");
            logger.info("method:judgeTypeName 查询成功成功!");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:judgeTypeName 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }
}
