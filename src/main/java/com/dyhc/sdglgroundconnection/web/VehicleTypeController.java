package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.VehicleTypeService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型 控制层
 **/
@RestController
@RequestMapping("Vehicletype")
public class VehicleTypeController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(VehicleTypeController.class);

    @Autowired
    private VehicleTypeService vehicleTypeService;


    /**
     *给指定公司添加车辆类型
     * @param vehicleType
     * @return
     */
    @RequestMapping("insertVehicletype")
    @LogNotes(operationType="车辆类型",content="添加")
    public ReponseResult insertVehicletype(VehicleType vehicleType){
        try {
            vehicleType.setWhetherDel(0);
            vehicleType.setCreateBy(1);
            vehicleType.setCreateDate(new Date());
            Integer result=vehicleTypeService.insertVehicleType(vehicleType);
            ReponseResult data=null;
            if (result==1){
                logger.info("method:insertVehicletype  添加车辆类型成功");
                data=ReponseResult.ok(result,"添加成功");
            }else if(result==3){
                logger.info("method:insertVehicletype  该公司已有该种类型的车辆，无须添加");
                data=ReponseResult.ok(result,"该公司已有该种类型的车辆，无须添加");
            }
            return data;
        }catch (Exception e){
            logger.error("method:insertVehicletype  添加车辆类型成功");
            e.printStackTrace();
            return ReponseResult.err("添加失败");
        }
    }

    /**
     * 根据车辆id查询车辆信息
     * @return
     */
    @RequestMapping("getVehicletypeByTypeId")
    public ReponseResult getVehicletypeByTypeId(Integer typeId){
        try {
            ReponseResult data=ReponseResult.ok(vehicleTypeService.getVehicletypeByTypeId(typeId),"查询车辆信息成功");
            logger.info("method:getVehicletypeByTypeId  查询车辆信息成功");
            return data;
        }catch (Exception e){
            logger.error("method:getVehicletypeByTypeId  查询车辆信息失败");
            e.printStackTrace();
            return ReponseResult.err("查询车辆信息失败");
        }
    }


    /**
     *给指定公司修改车辆类型
     * @param vehicleType
     * @return
     */
    @RequestMapping("updateVehicletype")
    @LogNotes(operationType="车辆类型",content="修改")
    public ReponseResult updateVehicletype(VehicleType vehicleType){
        try {
            vehicleType.setUpdateBy(1);
            vehicleType.setUpdateDate(new Date());
            Integer result=vehicleTypeService.updateVehicleType(vehicleType);
            ReponseResult data=null;
            if (result==1){
                logger.info("method:updateVehicletype  修改车辆类型成功");
                data=ReponseResult.ok(result,"修改成功");
            }else if(result==3){
                logger.info("method:insertVehicletype  该公司已有该种类型的车辆，无须修改");
                data=ReponseResult.ok(result,"该公司已有该种类型的车辆，无须修改");
            }
            return data;
        }catch (Exception e){
            logger.error("method:updateVehicletype  修改车辆类型成功");
            e.printStackTrace();
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 根据车辆id删除该车辆类型
     */
    @RequestMapping("deleteVehicleTypeById")
    @LogNotes(operationType="车辆类型",content="删除")
    public ReponseResult deleteVehicleTypeById(Integer typeId){
        try {
            Integer result=vehicleTypeService.deleteVehicleTypeById(typeId);
            ReponseResult data=null;
            if (result==1){
                logger.info("method:deleteVehicleTypeById  删除车辆类型成功");
                data=ReponseResult.ok(result,"删除成功");
            }else {
                logger.error("method:deleteVehicleTypeById  删除车辆类型失败");
                data=ReponseResult.err("删除失败");
            }
            return data;
        }catch (Exception e){
            logger.error("method:deleteVehicleTypeById  删除车辆类型失败");
            e.printStackTrace();
            return ReponseResult.err("删除失败");
        }
    }

    /**
     * 查看同一公司下是否有同种类型的车辆
     * @param valueId
     * @param carRentalId
     * @return
     */
    @RequestMapping("chaTypeByValueId")
    public ReponseResult listVehicleTypeByValueId(Integer valueId,Integer carRentalId){
        try {
            ReponseResult data=ReponseResult.ok(vehicleTypeService.listVehicleTypeByValueId(valueId,carRentalId),"获取同一公司的车辆类型成功");
            logger.info("获取同一公司的车辆类型成功");
            return data;
        }catch (Exception e){
            logger.info("获取同一公司的车辆类型失败");
            e.printStackTrace();
            return ReponseResult.err("获取同一公司的车辆类型失败");
        }
    }
}
