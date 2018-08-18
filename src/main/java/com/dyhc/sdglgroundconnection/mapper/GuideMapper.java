package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游
 **/
@Mapper
@Component
public interface GuideMapper extends CommonMapper<Guide>{
    /**
     * 分页查询导游信息表
     * @param pageNo
     * @param PageSize
     * @param guideName
     * @return
     */
    List<Guide> listGuide(@Param("pageNo") Integer pageNo, @Param("PageSize") Integer PageSize,@Param("guideName")  String guideName);
}
