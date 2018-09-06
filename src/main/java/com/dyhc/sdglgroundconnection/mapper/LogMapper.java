package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.HoteroomType;
import com.dyhc.sdglgroundconnection.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 带团日志
 **/
@Mapper
@Component
public interface LogMapper extends CommonMapper<Log>{
    /**
     * 单团日志
     * @return
     */
    Log ShowAllLog(@Param("guideId")Integer guideId,@Param("dispatchId")Integer dispatchId,@Param("creationDate")String creationDate)throws Exception;
}
