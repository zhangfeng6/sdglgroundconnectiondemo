package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 总模板
 **/
@Mapper
@Component
public interface TourismtemplateMapper extends CommonMapper<Tourismtemplate>{

    /**
     * 赵伟伟
     * 添加模板
     * @return
     */
    int addTourismtemplate(Tourismtemplate tourismtemplate) throws Exception;


    /**
     * 赵伟伟
     * 按名称查询模板
     * @return
     */
    Tourismtemplate selectByName(@Param("tourismtemplateName") String tourismtemplateName) throws Exception;
}
