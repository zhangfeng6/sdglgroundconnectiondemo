package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TourismtemplateService {
    /**
     * 查询全部旅游模板
     * @return
     */
    List<Tourismtemplate> selectTourismtemplate();

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
    Tourismtemplate selectByName(String tourismtemplateName) throws Exception;
}
