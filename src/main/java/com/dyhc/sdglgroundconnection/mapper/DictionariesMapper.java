package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
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
     * 根据类型id查询车辆类型
     * @return
     */
    Dictionaries getDictionaries(@Param("valueId") Integer valueId)throws Exception;
}
