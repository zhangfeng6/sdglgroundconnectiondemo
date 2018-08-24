package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 按账户类型ID查询人员信息
     * @param
     * @return
     */
    List<Staff> idAccountType()throws  Exception;

    /**
     * 分页查看全部
     * @param pageNo
     * @param PageSize
     * @param staffname
     * @return
     * @throws Exception
     */
    PageInfo<Staff> listStaffLike(Integer pageNo, Integer PageSize, String staffname) throws Exception;
    /**
     * 删除 修改
     * @param staff
     * @return
     */
    Integer getStaffUpd(Staff staff);

    /**
     * 修改
     * @param staff
     * @return
     */
    Integer getStaffUpdTwo(Staff staff);

    /**
     * 添加
     * @param staff
     * @return
     */
    Integer getStaffAdd(Staff staff);

    /**
     * 修改  查看
     * @param staffId
     * @return
     */
    Staff getStaffUpdTwoById(Integer staffId);

    /**
     * 判断用户是否存在
     * @return
     */
    Staff getserlectBy();
}
