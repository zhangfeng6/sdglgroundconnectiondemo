package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.pojo.BillType;
import com.dyhc.sdglgroundconnection.service.BillTypeService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据类型 控制层
 **/
@RequestMapping("/billType")
@RestController
public class BillTypeController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(BillTypeController.class);

    @Autowired
    private BillTypeService billTypeService;

    /**
     * 账户模糊分页
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @RequestMapping("/showAllBillType")
    public ReponseResult showAccountType(@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize, @RequestParam("typeName")String typeName){
        try {
            PageInfo<BillType> pageInfo=billTypeService.ShowAllBillType(pageNo,pageSize,typeName);
            ReponseResult<List> data =ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"单据类型分页成功!");
            System.out.println(data);
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    @LogNotes(operationType="单据表",content="单据删除")
    @RequestMapping("/removeBillType")
    public  ReponseResult removeBillType(@RequestParam("billTypeId")Integer billTypeId){
        try {
            Integer removeBillType=billTypeService.removeBillType(billTypeId);
            logger.info("method:showAccountType 单据删除成功");
            ReponseResult<Integer> data =ReponseResult.ok(removeBillType,"单据删除成功");
            System.out.println(data+"删除");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 单据删除失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

    @LogNotes(operationType="单据表",content="单据新增")
    @RequestMapping("/saveBillType")
    public  ReponseResult saveBillType(BillType billType){
        try {
            Integer removeBillType=billTypeService.saveBillType(billType);
            logger.info("method:showAccountType 单据新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(removeBillType,"单据新增成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 单据新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

    @RequestMapping("/equalBillType")
    public  ReponseResult equalBillType(@RequestParam("typeName")String  typeName){
        System.out.println(typeName);
        try {
            BillType billType=billTypeService.equalBillType(typeName);
            System.out.println(billType);
            if (billType==null){
                billType=new BillType();
                billType.setTypeName("no");
            }
            ReponseResult<BillType> data =ReponseResult.ok(billType,"单据类型名称判断查询成功!");
            System.out.println(data);
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }


    @LogNotes(operationType="单据表",content="单据修改")
    @RequestMapping("/updateBillType")
    public  ReponseResult updateBillType(BillType billType){
        try {
            Integer removeBillType=billTypeService.updateBillType(billType);
            logger.info("method:showAccountType 单据修改成功");
            ReponseResult<Integer> data =ReponseResult.ok(removeBillType,"单据修改成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 单据修改失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
    /**
     * 贾晓亮单据修改赋值
     * @param
     * @return
     */
    @LogNotes(operationType="单据修改赋值",content="单据修改赋值信息")
    @RequestMapping("/updateBillTypeFuzhi")
    public  ReponseResult equalBillType(@RequestParam("billTypeId") Integer billTypeId){
        try {
            BillType billType =billTypeService.fuzhiBillType(billTypeId);
            ReponseResult<BillType> data =ReponseResult.ok(billType,"单据修改赋值信息成功");
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }


}
