package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点
 **/
@Mapper
@Component
public interface ScenicspotMapper extends CommonMapper<Scenicspot>{

    /**
     * 根据名称、地址、等级状态查询景点
     * @param typeId
     * @return
     */
    List<Scenicspot> listScenicspots(@Param("typeId") Integer typeId, @Param("scenicSpotName")String scenicSpotName, @Param("scenicSpotAddress") String scenicSpotAddress, @Param("whetherDel")Integer whetherDel)throws Exception;

    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    List<Scenicspot> getScenicspotByParentId(@Param("parentId") Integer parentId);
}
