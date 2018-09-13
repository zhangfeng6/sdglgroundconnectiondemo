package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.service.BillService;
import com.dyhc.sdglgroundconnection.service.BillTypeService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
            ReponseResult data=ReponseResult.ok(billTypeService.listBillType(),"获取单据类型成功");
            return data;
        }catch (Exception e){
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
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 添加行程
     * @param request
     * @return
     */
    @RequestMapping("savebillBianGeng")
    @LogNotes(operationType = "添加",content = "行程变更单据")
    public ReponseResult savebillBianGeng(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        Integer did=Integer.parseInt(request.getParameter("dispatchId"));
        try {
            ReponseResult<Integer> data=ReponseResult.ok(billService.savebillBianGeng(files,did),"添加单据！");
            logger.info("method:savebillBianGeng 上传变更行程的单据！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:savebillBianGeng 上传变更行程的单据出现错误！");
            ReponseResult<Object> err=ReponseResult.err("上传行程变更的单据出现错误");
            return err;
        }
    }

}
