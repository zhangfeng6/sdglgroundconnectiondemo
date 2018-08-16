package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.AccountTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.service.AccountTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 账户类型业务实现
 **/
@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeMapper accountTypeMapper;

    /**
     *账户类型分页模糊查询
     * @param pageNo 当前页码
     * @param PageSize 每页显示记录数
     * @return
     */
    @Override
    public PageInfo<AccountType> listAccountType(Integer pageNo, Integer PageSize) {
        PageHelper.startPage(pageNo,PageSize);
        PageInfo<AccountType>pageInfo=new PageInfo<>(accountTypeMapper.selectAll());
        return pageInfo;
    }

    /**
     * 删除账户类型
     * @param accountTypeId账户类型ID
     * @return
     */
    @Override
    public Integer removeAccountType(Integer accountTypeId) {
        Integer remove=0;
        try {
            remove=accountTypeMapper.removeAccountType(accountTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remove;
    }
}
