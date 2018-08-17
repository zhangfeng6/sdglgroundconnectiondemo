package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ShoppingMapper;
import com.dyhc.sdglgroundconnection.pojo.Shopping;
import com.dyhc.sdglgroundconnection.service.ShoppingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 购物业务实现
 **/
@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper;


    @Override
    public Integer insertShopping(Shopping shopping) throws  Exception{
        Integer re=shoppingMapper.insert(shopping);
        return re;
    }

    @Override
    public Integer updateShopping(Shopping shopping,String shoppingSite) throws Exception {
        Integer re=shoppingMapper.updateByPrimaryKeySelective(shopping);
        return re;
    }

    @Override
    public Shopping getShoppingById(Integer shoppingId) throws Exception {
        return shoppingMapper.selectByPrimaryKey(shoppingId);
    }

    @Override
    public int deleteShoppingById(Integer shoppingId) throws Exception {
        return shoppingMapper.deleteByPrimaryKey(shoppingId);
    }
}
