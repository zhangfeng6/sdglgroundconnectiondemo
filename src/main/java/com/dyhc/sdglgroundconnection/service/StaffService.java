package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员业务接口
 **/
public interface StaffService {

    /**
     * 赵伟伟
     * 用户登录
     * @param theUserName
     * @param password
     * @return
     * @throws Exception
     */
    Staff login(String theUserName, String password) throws Exception;
}
