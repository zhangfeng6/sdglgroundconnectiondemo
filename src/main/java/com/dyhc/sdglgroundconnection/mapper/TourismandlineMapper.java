package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * 模板与线路表关联表
 **/
@Mapper
@Component
public interface TourismandlineMapper extends CommonMapper<Tourismandline>{
}
