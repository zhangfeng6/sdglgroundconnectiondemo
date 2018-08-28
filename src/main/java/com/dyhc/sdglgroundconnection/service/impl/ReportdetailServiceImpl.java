package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.service.ReportdetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细业务实现
 **/
@Service
public class ReportdetailServiceImpl implements ReportdetailService {

    @Autowired
    private ReportdetailMapper reportdetailMapper;

    @Override
    public PageInfo showInfoAll(Integer groupNumber, Integer states,Integer pageNo,Integer pageSize)throws Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Reportdetail> list=reportdetailMapper.showInfoAll(groupNumber,states);
        PageInfo<Reportdetail> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Reportdetail getReportdetailById(Integer reportDetailId) throws Exception {
        return reportdetailMapper.selectByPrimaryKey(reportDetailId);
    }
}
