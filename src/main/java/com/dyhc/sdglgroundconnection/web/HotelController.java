package com.dyhc.sdglgroundconnection.web;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店 控制层
 **/
@RequestMapping("/Hotel")
@RestController
public class HotelController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/showAllHotels")
    public ReponseResult showHotel(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize) {
        try {
            PageInfo<Hotel> pageInfo = hotelService.listHotels(pageNo,pageSize);
            ReponseResult<List> data = ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(), "分页获取酒店成功！");
            logger.info(" method:showHotel  分页获取酒店成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取酒店数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 根据id获取指定的酒店信息    张枫
     * @param id
     * @return
     */
    @RequestMapping("/getHotelById")
    public ReponseResult getHotelById(@RequestParam("id") Integer id) {
        try {
            ReponseResult<Hotel> data = ReponseResult.ok(hotelService.getHotelById(id),"获取指定的酒店信息");
            logger.info(" method:showHotel  获取酒店信息成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取酒店数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
