package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Carrental;
import com.dyhc.sdglgroundconnection.service.CarrentalService;
import com.dyhc.sdglgroundconnection.service.VehicleTypeService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
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

import java.util.Date;
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

    @Autowired
    private VehicleTypeService vehicleTypeService;

    /**
     * 查询汽车公司及旗下的车辆类型信息
     * @return
     */
    @RequestMapping("listCarRentals")
    public ReponseResult listCarRentals(String carRentalName, Integer pageNo, Integer pageSize){
        try{
            PageInfo<Carrental> pageInfo=carrentalService.listCarRentals(carRentalName,pageNo,pageSize);
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"查询汽车公司及旗下的车辆类型成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return ReponseResult.err("查询汽车公司及旗下的车辆类型失败");
        }
    }

    /**
     * 根据条件添加公司
     */
    @RequestMapping("insertCarRental")
    @LogNotes(operationType="车队公司",content="添加")
    public ReponseResult insertCarRental(Carrental carrental){
        try {
            carrental.setWhetherDel(0);
            carrental.setCreateBy(1);
            carrental.setCreateDate(new Date());
            Integer result=carrentalService.insertCarRental(carrental);
            ReponseResult data=null;
            if (result==1){
                data=ReponseResult.ok(result,"添加公司成功");
                logger.info("method:insertCarRental  添加车队公司信息成功！");
            }
            return data;

        }catch (Exception e){
            logger.info("method:insertCarRental  添加车队公司信息失败！");
            e.printStackTrace();
            return  ReponseResult.err("添加公司失败");
        }
    }



    /**
     * 根据条件修改公司信息
     */
    @RequestMapping("updateCarRental")
    @LogNotes(operationType="车队公司",content="修改")
    public ReponseResult updateCarRental(Carrental carrental){
        try {
            carrental.setWhetherDel(0);
            carrental.setUpdateBy(1);
            carrental.setUpdateDate(new Date());

            Integer result=carrentalService.updateCarRental(carrental);
            ReponseResult data=null;
            if (result==1){
                data=ReponseResult.ok(result,"修改公司信息成功");
                logger.info("method:insertCarRental  修改车队公司信息成功！");
            }else if (result==0){
                data=ReponseResult.ok(result,"修改公司信息失败");
                logger.info("method:insertCarRental  修改公司信息失败！");
            }

            return data;

        }catch (Exception e){
            logger.info("method:insertCarRental  修改车队公司信息失败！");
            e.printStackTrace();
            return  ReponseResult.err("修改公司信息失败");
        }
    }


    /**
     * 根据公司id查询公司信息
     */
    @RequestMapping("getCarRentalById")
    public ReponseResult getCarRentalById(Integer carRentalId){
        try {
            ReponseResult data=ReponseResult.ok(carrentalService.getCarRentalById(carRentalId),"查询公司信息成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return  ReponseResult.err("查询修改公司信息失败");
        }
    }

    /**
     * 根据公司id删除公司及下面的车辆类型
     * @param carRentalId
     * @return
     */
    @RequestMapping("deleteCarRentals")
    @LogNotes(operationType="车队公司",content="删除")
    public ReponseResult deleteCarRentals(Integer carRentalId){
        try {
            Integer result1=vehicleTypeService.deleteVehicleTypesBycarRentalId(carRentalId);
            ReponseResult data=null;
            if (result1==1){
                Integer result2=carrentalService.deleteCarRentalBycarRentalId(carRentalId);
                if (result2==1){
                    logger.info("method:deleteCarRentals  删除车队公司成功！");
                    data=ReponseResult.ok("删除成功");
                }else {
                    logger.error("method:deleteCarRentals  删除车队公司失败！");
                    data=ReponseResult.err("删除失败");
                }
            }else {
                logger.error("method:deleteCarRentals  删除车队公司失败！");
                data=ReponseResult.err("删除失败");
            }
            return data;
        }catch (Exception e){
            logger.error("method:deleteCarRentals  删除车队公司失败！");
            e.printStackTrace();
            return ReponseResult.err("删除失败");
        }
    }

    /**
     * 查询是否有相同名称的公司
     * @param carRentalName
     * @return
     */
    @RequestMapping("getCarrentalByName")
    public ReponseResult getCarrentalByName(String carRentalName){
        try {
            ReponseResult data=ReponseResult.ok(carrentalService.getCarrentalByName(carRentalName),"获取相同名称的公司成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return ReponseResult.err("获取相同名称的公司失败");
        }
    }

}
