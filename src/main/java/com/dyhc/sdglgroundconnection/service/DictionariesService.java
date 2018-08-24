package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典业务接口
 **/
public interface DictionariesService {

    /**
     * 获取所有的景点等级
     * @return
     */
    PageInfo<Dictionaries> listDictionaries()throws Exception;


    /**
     * 查询所有的车辆类型
     * @return
     */
    PageInfo<Dictionaries> listDictionaries1()throws Exception;


    /**
     * 查询所有房间类型
     * @return
     */
    List<Dictionaries> listhoteltype()throws Exception;
}
