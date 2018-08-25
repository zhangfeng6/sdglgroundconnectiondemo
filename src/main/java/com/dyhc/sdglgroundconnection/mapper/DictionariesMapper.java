package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典
 **/
@Mapper
@Component
public interface DictionariesMapper extends CommonMapper<Dictionaries>{


    /**
     * 查询所有的景点等级
     * @return
     */
    List<Dictionaries> listDictionaries();

    /**
     * 查询所有的车辆类型
     * @return
     */
    List<VehicleType> listVehicletype();



    /**
     * 按id查詢
     * @param valueId
     * @return
     */
    Dictionaries selectById(@Param("valueId")int valueId);


    /**
     * 按id查詢
     * @param
     * @return
     */
    Dictionaries selectByDictionariesId(@Param("dictionariesId")int dictionariesId);

}
