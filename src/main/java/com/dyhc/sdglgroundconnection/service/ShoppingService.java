package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Shopping;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.base.select.SelectByPrimaryKeyMapper;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 购物业务接口
 **/
public interface ShoppingService {

    /**
     *给景点附近添加购物地点
     * @param shopping
     * @return
     */
    Integer insertShopping(Shopping shopping) throws  Exception;


    /**
     * 根据购物di修改购物地点
     * @return
     * @throws Exception
     */
    Integer updateShopping(Shopping shopping,String shoppingSite)throws  Exception;


    /**
     * 根据购物id查询购物地点
     * @param shoppingId
     * @return
     * @throws Exception
     */
    Shopping getShoppingById(Integer shoppingId)throws Exception;


    /**
     * 根据购物id删除该购物信息
     * @param shoppingId
     * @return
     * @throws Exception
     */
    int deleteShoppingById(Integer shoppingId)throws Exception;


    /**
     * 根据景点id删除购物地点
     * @param scenicSpotId
     * @throws Exception
     */
    Integer deleteShoppingsByscenicSpotId(Integer scenicSpotId)throws Exception;
}
