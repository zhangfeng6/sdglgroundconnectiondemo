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
    List<Dictionaries> listDictionaries()throws Exception;

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
<<<<<<< HEAD

   /**
=======
    /*
>>>>>>> origin/master
     * 根据类型id查询车辆类型
     * @return
     */
    Dictionaries getDictionaries(@Param("valueId") Integer valueId)throws Exception;


    /**
     * 查询所有的车辆类型
     * @return
     */
    List<Dictionaries> listDictionaries1()throws Exception;

    /**
     * 根据code获取字典表信息
     * @param code
     * @return
     * @throws Exception
     */
    List<Dictionaries> listdictionarieslBycode(@Param("code")String code)throws Exception;
<<<<<<< HEAD
=======

>>>>>>> origin/master
}
