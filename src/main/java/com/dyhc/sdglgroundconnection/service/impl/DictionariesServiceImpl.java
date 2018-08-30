package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DictionariesMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.DictionariesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典业务实现
 **/
@Service
public class DictionariesServiceImpl implements DictionariesService {

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Override
    public PageInfo<Dictionaries> listDictionaries()throws Exception {

        return new PageInfo<Dictionaries>(dictionariesMapper.listDictionaries());
    }

    @Override
    public List<VehicleType> listVehicletype() {
        return dictionariesMapper.listVehicletype();
    }

    @Override
    public Dictionaries selectByDictionariesId(int dictionariesId) {
        return dictionariesMapper.selectByDictionariesId(dictionariesId);
    }

    public PageInfo<Dictionaries> listDictionaries1()throws Exception {
        return new PageInfo<Dictionaries>(dictionariesMapper.listDictionaries1());
    }

    @Override
    public List<Dictionaries> listhoteltype() throws Exception {
        return dictionariesMapper.listdictionarieslBycode("THEROOM");
    }

    /**
     * 分页查看餐厅类型
     *
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @param valueContent1
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Dictionaries> listDictionariesCan(Integer pageNo, Integer PageSize, String valueContent1) throws Exception {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Dictionaries> dictionaries = new PageInfo<>(dictionariesMapper.getDictionariesCan(valueContent1));
        return dictionaries;
    }

    /**
     * 分页查看车辆类型
     *
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @param valueContent1
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Dictionaries> listDictionariesCar(Integer pageNo, Integer PageSize, String valueContent1) throws Exception {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Dictionaries> dictionaries = new PageInfo<>(dictionariesMapper.getDictionariesCar(valueContent1));
        return dictionaries;
    }

    /**
     * 分页查看酒店类型
     *
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @param valueContent1
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Dictionaries> listDictionariesHotel(Integer pageNo, Integer PageSize, String valueContent1) throws Exception {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Dictionaries> dictionaries = new PageInfo<>(dictionariesMapper.getDictionariesHotel(valueContent1));
        return dictionaries;
    }

    /**
     * 删除  修改
     *
     * @param valueContent1
     * @return
     */
    @Override
    public Integer getDictionariesByOne(String valueContent1) {
        return dictionariesMapper.getDictionariesByOne(valueContent1);
    }

    /**
     * 餐厅类型删除  修改
     *
     * @param valueContent1
     * @return
     */
    @Override
    public Integer getDictionariesByDel(String valueContent1) {
        return dictionariesMapper.getDictionariesByDel(valueContent1);
    }

    /**
     * 酒店类型删除  修改
     *
     * @param valueContent1
     * @return
     */
    @Override
    public Integer getDictionariesHotelByDel(String valueContent1) {
        return dictionariesMapper.getDictionariesHotelDel(valueContent1);
    }

    /**
     * 餐厅类型添加信息
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariesAdd(Dictionaries dictionaries) {
        return dictionariesMapper.insert(dictionaries);
    }

    /**
     * 车辆类型添加信息
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariescarAdd(Dictionaries dictionaries) {
        return dictionariesMapper.insert(dictionaries);
    }

    /**
     * 酒店类型添加信息
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariesHotelAdd(Dictionaries dictionaries) {
        return dictionariesMapper.insert(dictionaries);
    }


    /**
     * 餐厅类型修改
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariesByUpd(Dictionaries dictionaries) {
        return dictionariesMapper.getDictionariesByUpd(dictionaries);
    }

    /**
     * 车辆类型修改
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariesHotelUpd(Dictionaries dictionaries) {
        return dictionariesMapper.getDictionariescarUpd(dictionaries);
    }

    /**
     * 酒店类型修改
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Integer getDictionariesCarUpd(Dictionaries dictionaries) {
        return dictionariesMapper.getDictionariesHotelByUpd(dictionaries);
    }

    /**
     * 餐厅类型修改  查看
     *
     * @param dictionariesId
     * @return
     */
    @Override
    public Dictionaries getgetDictionariesSelect(Integer dictionariesId) {
        return dictionariesMapper.getgetDictionariesSelect(dictionariesId);
    }

    /**
     * 车辆类型修改  查看
     *
     * @param dictionariesId
     * @return
     */
    @Override
    public Dictionaries getgetDictionariesCarSelect(Integer dictionariesId) {
        return dictionariesMapper.getgetDictionariesCarSelect(dictionariesId);
    }

    /**
     * 酒店类型修改  查看
     *
     * @param dictionariesId
     * @return
     */
    @Override
    public Dictionaries getgetDictionariesHotelSelect(Integer dictionariesId){
        return dictionariesMapper.getgetDictionariesHotelSelect(dictionariesId);
    }


    /**
     *判断餐厅类型是否存在
     * @param valueContent1
     * @return
     */
    @Override
    public Dictionaries getDictionariesByNameTypecan(String valueContent1) {
        return dictionariesMapper.getDictionariesByNameTypecan(valueContent1);
    }

    /**
     *判断车辆类型是否存在
     * @param valueContent1
     * @return
     */
    @Override
    public Dictionaries getDictionariesByNameTypecar(String valueContent1) {
        return dictionariesMapper.getDictionariesByNameTypecar(valueContent1);
    }

    /**
     * 判断酒店类型是否存在
     * @param valueContent1
     * @return
     */
    @Override
    public Dictionaries AAA(String valueContent1) {
        return dictionariesMapper.getDictionariesByNameType(valueContent1);
    }
    /**
     * 添加餐厅编号
     * @param
     * @return
     */
    @Override
    public Dictionaries DictionariesCanMax() {
        return dictionariesMapper.DictionariesCanMax();
    }
    /**
     * 添加车辆编号
     * @param
     * @return
     */
    @Override
    public Dictionaries DictionariesCarMax() {
        return dictionariesMapper.DictionariesCarMax();
    }
    /**
     * 添加酒店编号
     * @param
     * @return
     */
    @Override
    public Dictionaries DictionariesHotelMax() {
        return dictionariesMapper.DictionariesHotelMax();
    }
}
