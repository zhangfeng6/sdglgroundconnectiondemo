package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Bill;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据业务接口
 **/
public interface BillService {

    /**
     * 获取单据图片
     * @param dispatchId
     * @param billTypeId
     * @return
     */
    Bill selectBillByDispatchIdAndBillTypeId(Integer dispatchId, Integer billTypeId)throws Exception;

    /**
     * 添加单据
     * @param bill
     * @throws Exception
     */
    Integer insertBill(Bill bill)throws Exception;


    /**
     * 修改单据
     * @throws Exception
     */
    Integer updateBillById(Bill bill)throws Exception;

    /**
     * 添加单据信息
     * @param list  所有图片 集合
     * @param did   调度id
     * @return
     * @throws Exception
     */
    int savebillBianGeng(List<MultipartFile> list,Integer did)throws Exception;

}
