package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 账户类型
 **/
@Mapper
@Component
public interface AccountTypeMapper extends CommonMapper<AccountType>{
    /**
     * 删除账户类型
     * @param accountTypeId
     * @return
     * @throws Exception
     */
    Integer removeAccountType(Integer accountTypeId)throws  Exception;

    /**
     * 新增账户类型
     * @param accountType
     * @return
     */
    Integer saveAccountType(AccountType accountType);
}
