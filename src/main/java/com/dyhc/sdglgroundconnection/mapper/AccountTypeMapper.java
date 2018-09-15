package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
    Integer saveAccountType(AccountType accountType)throws Exception;

    /*
      账户类型模糊查询分页接口
     */
    List<AccountType> listAccountType(@Param(value = "pageNo")Integer pageNo, @Param(value = "PageSize")Integer PageSize, @Param(value = "bank")String bank) throws Exception;

    /**
     * 修改账户类别信息
     * @param accountType
     * @return
     * @throws Exception
     */
    Integer updateAccountType(AccountType accountType)throws Exception;

    List<AccountType> selectStatusOne()throws Exception;

    List<AccountType> selectStatusTwo()throws Exception;

}