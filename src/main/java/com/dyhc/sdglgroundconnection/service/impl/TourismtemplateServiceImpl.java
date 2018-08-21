package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TourismandlineMapper;
import com.dyhc.sdglgroundconnection.mapper.TourismtemplateMapper;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class TourismtemplateServiceImpl  implements TourismtemplateService {
    @Autowired
    private TourismtemplateMapper tourismtemplateMapper;
    @Autowired
    private TourismandlineMapper tourismandlineMapper;

    /**
     * 获取指定符合查询条件的模板信息
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Tourismtemplate> listtemplate(String tempName, String username,Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Tourismtemplate> pageInfo=new PageInfo<Tourismtemplate>(tourismtemplateMapper.listtemplate(tempName,username));
        return pageInfo;
    }

    @Override
    @Transactional()
    public int removetourismtemplate(Integer tid) throws Exception {
        try {
            tourismtemplateMapper.deleteByPrimaryKey(tid);
            tourismandlineMapper.removeTourismandline(tid);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

}
