package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.TemplateHotel;
import com.dyhc.sdglgroundconnection.pojo.TemplateScenicspot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板景点
 **/
@Mapper
@Component
public interface TemplateScenicspotMapper extends CommonMapper<TemplateScenicspot> {

    /**
     * 获取指定模板id的模板景点信息
     * @param mid
     * @return
     * @throws Exception
     */
    List<TemplateScenicspot> listscenicspot(@Param("mid")Integer mid)throws Exception;

    /**
     * 根据模板id删除信息
     * @param mid
     * @return
     */
    int removescenicspot(@Param("mid")Integer mid)throws Exception;
}
