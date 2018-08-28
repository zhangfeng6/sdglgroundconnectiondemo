package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.service.BillService;
import com.dyhc.sdglgroundconnection.service.BillTypeService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据 控制层
 **/
@RestController
@RequestMapping("bill")
public class BillController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillTypeService billTypeService;
    @Autowired
    private BillService billService;


    /**
     * 获取所有单据类型
     * @return
     */
    @RequestMapping("listBillAll")
    public ReponseResult listBillAll(){
        try {
            ReponseResult data=ReponseResult.ok(billTypeService.listBillAll(),"获取单据类型成功");
            logger.info("method:listBillAll 获取单据类型成功");
            return data;
        }catch (Exception e){
            logger.error("method:listBillAll 获取单据类型失败");
            e.printStackTrace();
            return ReponseResult.err("获取单据类型失败");
        }
    }


    /**
     * 获取单据图片
     * @param dispatchId
     * @param billTypeId
     * @return
     */
    @RequestMapping("selectBillByDispatchIdAndBillTypeId")
    public ReponseResult selectBillByDispatchIdAndBillTypeId(Integer dispatchId,Integer billTypeId){
        try {
            Bill bill=billService.selectBillByDispatchIdAndBillTypeId(dispatchId,billTypeId);
            ReponseResult data=ReponseResult.ok(bill,"获取失败");
            logger.info("method:selectBillByDispatchIdAndBillTypeId 获取成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:selectBillByDispatchIdAndBillTypeId 获取失败");
            return ReponseResult.err("获取失败");
        }
    }
}
