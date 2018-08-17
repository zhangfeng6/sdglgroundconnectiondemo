package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.StaffMapper;
import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员业务实现
 **/
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 赵伟伟
     * 登录
     * @param theUserName
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Staff login(String theUserName, String password) throws Exception {
        return staffMapper.login(theUserName,password);
    }

    /**
     * 根据账户类型ID查询人员信息
     * @param
     * @return
     */
    @Override
    public List<Staff> idAccountType() throws Exception{
        return staffMapper.selectAll();
    }
}
