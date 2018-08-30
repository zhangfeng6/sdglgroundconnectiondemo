package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Disother;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度其他
 **/
@Mapper
@Component
public interface DisotherMapper extends CommonMapper<Disother>{
    /**
     * 根据调度id获取调度其他表信息
     * @param Did
     * @return
     * @throws Exception
     */
    Disother getDisotherByDid(@Param("Did")Integer Did)throws Exception;
}
