package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 餐馆业务接口
 **/
public interface RestaurantService {
    PageInfo<Restaurant> listRestaurants(Integer pageNo, Integer PageSize,String restaurantName, String restaurantAddress,Integer whetherDel) throws Exception;

    /**
     * 赵伟伟
     * 按照id删除饭店
     * @param restaurantId
     * @return
     */
    int delRestaurantById(int restaurantId) throws Exception;


    /**
     * 赵伟伟
     * 新增饭店
     * @param restaurant
     * @return
     */
    int insertRestaurant(Restaurant restaurant);

    /**
     * 赵伟伟
     * 根据id查询
     * @return
     */
    Restaurant selectRestaurantById(int restaurantId);

    /**
     * 赵伟伟
     * 修改饭店
     * @param restaurant
     * @return
     */
    int updateRestaurantById(Restaurant restaurant);
}
