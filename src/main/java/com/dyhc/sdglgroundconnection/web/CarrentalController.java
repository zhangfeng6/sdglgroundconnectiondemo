package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Carrental;
import com.dyhc.sdglgroundconnection.service.CarrentalService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 汽车租赁公司 控制层
 **/
@RestController
@RequestMapping("CarRental")
public class CarrentalController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(CarrentalController.class);

    @Autowired
    private CarrentalService carrentalService;


    /**
     * 查询汽车公司及旗下的车辆类型信息
     * @return
     */
    @RequestMapping("listCarRentals")
    public ReponseResult listCarRentals(String carRentalName, @RequestParam("costprice1") Integer costprice1,@RequestParam("costprice2") Integer costprice2, @RequestParam("passengervolume") Integer passengervolume, Integer pageNo, Integer pageSize){
        try{

            PageInfo<Carrental> pageInfo=carrentalService.listCarRentals(carRentalName,costprice1,costprice2,passengervolume,pageNo,pageSize);
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"查询汽车公司及旗下的车辆类型成功");
            logger.info(" method:listCarRentals  查询汽车公司及旗下的车辆类型成功！");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(" method:listCarRentals  查询汽车公司及旗下的车辆类型失败！");
            return ReponseResult.err("查询汽车公司及旗下的车辆类型失败");
        }
    }
}
