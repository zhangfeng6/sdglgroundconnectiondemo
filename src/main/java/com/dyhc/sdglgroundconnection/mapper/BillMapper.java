package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据
 **/
@Mapper
@Component
public interface BillMapper extends CommonMapper<Bill>{

    /**
     * 获取单据图片
     * @param dispatchId
     * @param billTypeId
     * @return
     */
    Bill selectBillByDispatchIdAndBillTypeId(@Param("dispatchId") Integer dispatchId, @Param("billTypeId") Integer billTypeId)throws Exception;


    /**
     * 添加单据
     * @param bill
     * @throws Exception
     */
    void insertBill(Bill bill)throws Exception;

    /**
     * 修改单据
     * @throws Exception
     */
    void updateBillById(Bill bill)throws Exception;

    /**
     * 根据typeID和DispatchId获取单据信息    张枫
     * @return
     * @throws Exception
     */
    Bill getBillBtTypeId(@Param("typeId")Integer typeId,@Param("dispatchId")Integer dispatchId)throws Exception;

    /**
     * 根据调度Id删除单据表信息    张枫
     * @param dispatchId
     * @return
     * @throws Exception
     */
    int  removeBillBydispatchId(@Param("dispatchId")Integer dispatchId)throws Exception;
}
