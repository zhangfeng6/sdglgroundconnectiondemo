package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.service.AccountTypeService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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


    @RequestMapping("/showAllAccountType")
    public ReponseResult showAccountType(@RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize")Integer pageSize){
        try {
            PageInfo<AccountType> pageInfo=accountTypeService.listAccountType(pageNo,pageSize);
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

}
