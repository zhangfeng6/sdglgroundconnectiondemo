package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TourismtemplateMapper;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourismtemplateServiceImpl  implements TourismtemplateService {
    @Autowired
    private TourismtemplateMapper tourismtemplateMapper;

    /**
     * 赵伟伟
     * 查询全部模板
     * @return
     */
    @Override
    public List<Tourismtemplate> selectTourismtemplate() {
        return tourismtemplateMapper.selectAll();
    }

    /**
     * 赵伟伟
     * 添加线路
     * @param tourismtemplate
     * @return
     * @throws Exception
     */
    @Override
    public int addTourismtemplate(Tourismtemplate tourismtemplate) throws Exception {
        return tourismtemplateMapper.addTourismtemplate(tourismtemplate);
    }

    /**
     * 按名称查询
     * @param tourismtemplateName
     * @return
     * @throws Exception
     */
    @Override
    public Tourismtemplate selectByName(String tourismtemplateName) throws Exception {
        return tourismtemplateMapper.selectByName(tourismtemplateName);
    }
}
