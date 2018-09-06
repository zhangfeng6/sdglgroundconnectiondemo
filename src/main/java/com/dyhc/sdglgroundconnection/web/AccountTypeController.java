package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.service.AccountTypeService;
import com.dyhc.sdglgroundconnection.service.StaffService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 账户类型 控制层
 **/
@RequestMapping("/AccountType")
@RestController
public class AccountTypeController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(AccountTypeController.class);

    @Autowired
    private AccountTypeService accountTypeService;

    /**
     * 账户模糊分页
     * @param pageNo
     * @param pageSize
     * @param bank
     * @return
     */
    @LogNotes(operationType="账户分类",content="模糊分页查询")
    @RequestMapping("/showAllAccountType")
    public ReponseResult showAccountType(@RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize")Integer pageSize,@RequestParam("bank")String bank){
        try {
            PageInfo<AccountType> pageInfo=accountTypeService.listAccountType(pageNo,pageSize,bank);
            ReponseResult<List> data =ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"账户类型分页成功!");
            logger.info("method:showAccountType 账户类型分页成功");
            System.out.println(data);
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 账户类型分页失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

    @LogNotes(operationType="账户修改",content="修改账户")
    @RequestMapping("/updateAccountType")
    public  ReponseResult updateAccounts(AccountType accountType)throws Exception{
        try {
            Integer pageInfo=accountTypeService.updateAccountType(accountType);
            ReponseResult<Integer> data =ReponseResult.ok(pageInfo,"修改账户信息");
            logger.info("method:showAccountType 修改账户信息成功");
            System.out.println(data);
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 修改账户信息成功");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    /**
     * 删除账户类型信息
     * @param accountTypeId
     * @return
     */
    @LogNotes(operationType="账户分类",content="删除账户")
    @RequestMapping("/removeAccountType")
   public  ReponseResult removerAccountType(@RequestParam("accountTypeId")Integer accountTypeId){
    try {
        Integer removeAccountType=accountTypeService.removeAccountType(accountTypeId);
        logger.info("method:showAccountType 删除账户类型成功");
        ReponseResult<Integer> data =ReponseResult.ok(removeAccountType,"删除成功");
        return  data;
    } catch (Exception e) {
        logger.info("method:showAccountType 删除账户类型失败");
        e.printStackTrace();
        ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
        return  error;
    }
}

    /**
     * 贾晓亮账户类型修改
     * @param accountTypeId
     * @return
     */
@LogNotes(operationType="账目修改赋值",content="查询账目修改信息")
@RequestMapping("/updateShowAllAccountType")
public  ReponseResult updateShowAll(@RequestParam("accountTypeId") Integer accountTypeId){
    try {
        AccountType accountType =accountTypeService.updateShowAll(accountTypeId);
        logger.info("method:showAccountType 修改信息查询成功");
        ReponseResult<AccountType> data =ReponseResult.ok(accountType,"查询成功");
        return  data;
    } catch (Exception e) {
        logger.info("method:showAccountType 修改信息查询失败");
        e.printStackTrace();
        ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
        return  error;
    }
}

 @LogNotes(operationType="账户新增",content="新增账户")
 @RequestMapping("/saveAccountType")
 public  ReponseResult saveAccountType(AccountType accountType){
     System.out.println("新增账户");
     try {
         Integer saveAccountType=accountTypeService.saveAccountType(accountType);
         logger.info("method:saveAccountType 新增账户类型成功");
         ReponseResult<Integer> data =ReponseResult.ok(saveAccountType,"保存成功");
         return  data;
     } catch (Exception e) {
         logger.info("method:saveAccountType 新增账户类型失败");
         e.printStackTrace();
         ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
         return  error;
     }
 }

}
