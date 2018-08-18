package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TemplateMapper;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板业务实现
 **/
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;


    /**
     * 查询模板信息   张枫
     * @param tempName  模板名称
     * @param userName  创建人名称
     * @param pageNo    当前页
     * @param pageSize  每页显示量
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Template> listtemplate(String tempName, String userName, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<Template> listtemplate = templateMapper.listtemplate(tempName, userName);
        PageInfo<Template> pageInfo=new PageInfo<Template>(listtemplate);
        return pageInfo;
    }
}
