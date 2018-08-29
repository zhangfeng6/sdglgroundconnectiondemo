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

    /*origin/master
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


    /**
     * 分页查看餐厅类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesCan(@Param("valueContent1") String valueContent1);

    /**
     * 分页查车辆厅类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesCar(@Param("valueContent1") String valueContent1);
    /**
     * 分页查看酒店类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesHotel(@Param("valueContent1") String valueContent1);

    /**
     * 餐厅类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByOne(String valueContent1);

    /**
     * 车辆类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByDel(String valueContent1);
    /**
     * 酒店类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesHotelDel(String valueContent1);

    /**
     * 餐厅修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesByUpd(Dictionaries dictionaries);
    /**
     * 车辆修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariescarUpd(Dictionaries dictionaries);
    /**
     * 酒店修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesHotelByUpd(Dictionaries dictionaries);

    /**
     * 餐厅类型修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesSelect(Integer dictionariesId);
    /**
     * 车辆修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesCarSelect(Integer dictionariesId);
    /**
     * 酒店修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesHotelSelect(Integer dictionariesId);

}
