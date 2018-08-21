package com.dyhc.sdglgroundconnection.web;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.dyhc.sdglgroundconnection.utils.FileUploadUtil;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 酒店分页显示
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/hotelShowAll")
    public ReponseResult hotelShowAll(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,@RequestParam("hotelName") String hotelName,@RequestParam("costpriceOne")Integer costpriceOne,@RequestParam("costpriceTwo") Integer costpriceTwo) {
        try {
            PageInfo<Hotel> pageInfo = hotelService.hotelShowAll(pageNo,pageSize,hotelName,costpriceOne,costpriceTwo);
            ReponseResult<List> data = ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(), "分页获取酒店成功！");
            System.out.println(data);
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
     * 酒店房间删除
     * @return
     */
    @RequestMapping("/removeRoomType")
    public ReponseResult removeRoomType(@RequestParam("hotelId") Integer hotelId) {
        try {
            Integer  num =hotelService.removeRoomType(hotelId);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店房间删除成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店房间删除成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店房间删除失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 酒店房间修改
     * @return
     */
    @RequestMapping("/updateRoomType")
    public ReponseResult updateRoomType(RoomType roomType) {
        try {
            Integer  num =hotelService.updateRoomType(roomType);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店房间修改成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店房间修改成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店房间修改失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 酒店房间新增
     * @return
     */
    @RequestMapping("/saveRoomType")
    public ReponseResult saveRommType(RoomType roomType) {
        try {
            Integer  num =hotelService.saveRommType(roomType);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店房间新增成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店房间新增成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店房间新增失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 酒店房间修改赋值
     * @return
     */
    @RequestMapping("/fuzhiRoomType")
    public ReponseResult fuzhiRoomType(Integer typeId) {
        try {
            RoomType  num =hotelService.fuzhiRoomType(typeId);
            ReponseResult<RoomType> data = ReponseResult.ok(num,"酒店房间修改赋值成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店房间修改赋值成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店房间修改赋值失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 酒店修改赋值
     * @return
     */
    @RequestMapping("/fuzhiHotel")
    public ReponseResult fuzhiHotel(Integer hotelId) {
        try {
            Hotel  num =hotelService.fuzhiHotel(hotelId);
            ReponseResult<Hotel> data = ReponseResult.ok(num,"酒店房间修改赋值成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店房间修改赋值成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店房间修改赋值失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }



    /**
     * 酒店新增:贾晓亮
     * @return
     */
    @RequestMapping("/saveHotel")
    public ReponseResult saveHotel(HttpServletRequest request,@RequestParam("picturePath") MultipartFile picturePath,@RequestParam("savePath") String savePath) {
        try {
            String form =request.getParameter("form");
            //创建对象
            ObjectMapper objectMapper =new ObjectMapper();
            // 创建酒店对象
            Hotel hotel =objectMapper.readValue(form,Hotel.class);
            String uploa=FileUploadUtil.uploadImage(picturePath,savePath,".jpg");
            hotel.setPicturePath(picturePath+savePath);
            Integer  num =hotelService.saveHotel(hotel);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店新增成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店新增成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店新增失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }



    /**
     * 酒店修改:贾晓亮
     * @return
     */
    @RequestMapping("/updatHotel")
    public ReponseResult updateHotel(HttpServletRequest request,@RequestParam("picturePath") MultipartFile picturePath,@RequestParam("savePath") String savePath) {
        try {
            String form =request.getParameter("form");
            //创建对象
            ObjectMapper objectMapper =new ObjectMapper();
            // 创建酒店对象
            Hotel hotel =objectMapper.readValue(form,Hotel.class);
            String uploa=FileUploadUtil.uploadImage(picturePath,savePath,".jpg");
            hotel.setPicturePath(picturePath+savePath);
            Integer  num =hotelService.updateHotel(hotel);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店修改成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店修改成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店修改失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 酒店删除
     * @return
     */
    @RequestMapping("/removeHoter")
    public ReponseResult removeHotel(@RequestParam("hotelId") Integer hotelId) {
        try {
            Integer  num =hotelService.removeHotel(hotelId);
            ReponseResult<Integer> data = ReponseResult.ok(num,"酒店删除成功");
            System.out.println(data);
            logger.info(" method:showHotel  酒店删除成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  酒店删除失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


















    /**
     * 分页张峰
     * @param pageNo
     * @param pageSize
     * @return
     */
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
