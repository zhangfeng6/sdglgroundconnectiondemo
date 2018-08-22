package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员
 **/
@Mapper
@Component
public interface StaffMapper extends CommonMapper<Staff>{

    /**
     * 赵伟伟
     * 用户登录
     * @param theUserName
     * @param password
     * @return
     * @throws Exception
     */
    Staff login(@Param("theUserName") String theUserName,@Param("password") String password) throws Exception;
    /**
     * 分页查看全部
     * @param staffname
     * @return
     */
    List<Staff> getStaffAll(@Param("staffname") String staffname);

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
