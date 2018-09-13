package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.BillMapper;
import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.service.BillService;
import com.dyhc.sdglgroundconnection.utils.ClientFileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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

    @Override
    public int savebillBianGeng(List<MultipartFile> list, Integer did) throws Exception {
        try {
            for (int i = 0; i < list.size(); i++) {
                Bill bill = new Bill();
                bill.setUpdateBy(1);
                bill.setDispatchId(did);
                bill.setBillTypeId(i + 1);
                bill.setWhetherDel(0);
                bill.setCreateBy(1);
                bill.setCreateDate(new Date());
                String uploadResult = ClientFileUploadUtil.uploadImage(list.get(i), ".jpg");
                bill.setPicturePath(uploadResult);
                billMapper.insert(bill);
            }
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }

    }

}
