package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DictionariesMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.DictionariesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典业务实现
 **/
@Service
public class DictionariesServiceImpl implements DictionariesService {

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Override
    public PageInfo<Dictionaries> listDictionaries()throws Exception {

        return new PageInfo<Dictionaries>(dictionariesMapper.listDictionaries());
    }

    @Override
    public List<VehicleType> listVehicletype() {
        return dictionariesMapper.listVehicletype();
    }

    @Override
    public Dictionaries selectByDictionariesId(int dictionariesId) {
        return dictionariesMapper.selectByDictionariesId(dictionariesId);
    }
<<<<<<< HEAD

=======
>>>>>>> origin/master
    public PageInfo<Dictionaries> listDictionaries1()throws Exception {
        return new PageInfo<Dictionaries>(dictionariesMapper.listDictionaries1());
    }

    @Override
    public List<Dictionaries> listhoteltype() throws Exception {
        return dictionariesMapper.listdictionarieslBycode("THEROOM");
    }
}
