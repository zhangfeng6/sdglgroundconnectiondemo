package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.BillMapper;
import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据业务实现
 **/
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public Bill selectBillByDispatchIdAndBillTypeId(Integer dispatchId, Integer billTypeId) throws Exception {
        return billMapper.selectBillByDispatchIdAndBillTypeId(dispatchId,billTypeId);
    }

    @Override
    public Integer insertBill(Bill bill) throws Exception {
        try {
            billMapper.insertBill(bill);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer updateBillById(Bill bill) throws Exception {
        try {
            billMapper.updateBillById(bill);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

}
