package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.TemplateHotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板酒店
 **/
@Mapper
@Component
public interface TemplateHotelMapper extends CommonMapper<TemplateHotel>{

    /**
     * 根据模板id获取指定的模板酒店信息
     * @param temid
     * @return
     * @throws Exception
     */
    TemplateHotel gettemplatehotelbytemid(@Param("temid")Integer temid)throws Exception;

    /**
     * 修改酒店信息
     * @param temhotel
     * @return
     * @throws Exception
     */
    int updatetemhotel(@Param("temhotel")TemplateHotel temhotel)throws Exception;

    /**
     * 删除线路酒店信息
     * @param mid
     * @return
     * @throws Exception
     */
    int removehotel(@Param("mid")Integer mid)throws Exception;
}
