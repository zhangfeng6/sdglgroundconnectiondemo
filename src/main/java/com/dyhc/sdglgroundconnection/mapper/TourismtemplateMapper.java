package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 根据模板名称和创建人查询符合条件的模板信息    张枫
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    List<Tourismtemplate> listtemplate(@Param("tempName")String tempName, @Param("username")String username)throws Exception;

    /**
     * 根据模板名称查找信息
     * @param tempName
     * @return
     */
    Tourismtemplate gettemplateByName(@Param("tempName")String tempName)throws Exception;

}
