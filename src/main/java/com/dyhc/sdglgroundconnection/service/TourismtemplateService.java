package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TourismtemplateService {

    /**
     * 根据模板名称和创建人查询符合条件的模板信息    张枫
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    PageInfo<Tourismtemplate> listtemplate(String tempName,String username,Integer pageNo,Integer pageSize)throws Exception;

    /**
     * 根据模板id删除模板和 派生表信息
     * @param tid
     * @return
     * @throws Exception
     */
    int removetourismtemplate(Integer tid)throws Exception;
}
