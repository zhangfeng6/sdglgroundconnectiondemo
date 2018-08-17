package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 餐馆
 **/
@Mapper
@Component
public interface RestaurantMapper extends CommonMapper<Restaurant>{
    /**
     * 赵伟伟
     * 模糊查询饭店
     * @param restaurantName
     * @param restaurantAddress
     * @param whetherDel
     * @return
     */
    List<Restaurant> selectByEx(@Param("restaurantName") String restaurantName,@Param("restaurantAddress") String restaurantAddress,@Param("whetherDel") Integer whetherDel);

    /**
     * 赵伟伟
     * 按照id删除饭店
     * @param restaurantId
     * @return
     */
    int delRestaurantById(@Param("restaurantId") int restaurantId) throws Exception;


    /**
     * 赵伟伟
     * 修改饭店
     * @param restaurant
     * @return
     */
    int updateRestaurantById(Restaurant restaurant);
}
