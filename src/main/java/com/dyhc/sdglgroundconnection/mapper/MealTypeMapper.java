package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Log;
import com.dyhc.sdglgroundconnection.pojo.MealType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 饮食类型
 **/
@Mapper
@Component
public interface MealTypeMapper extends CommonMapper<MealType> {

    /**
     * 赵伟伟
     * 按照餐馆id查询餐馆类型
     * @return
     */
    List<MealType> selectMealTypeByRestaurantId(@Param("restaurantId") int restaurantId);

    /**
     * 赵伟伟
     * 修改餐馆类型
     * @param mealType
     * @return
     */
    int updateMealType(MealType mealType);

    /**
     * 删除餐馆类型
     * @param mealType
     * @return
     */
    int delMealTypeById(MealType mealType);

    /**
     * 查询餐馆类型
     * @return
     */
    List<Dictionaries> selectDic();

    /**
     * 新增餐馆
     * @param mealType
     * @return
     */
    int insertMealType(MealType mealType);

    /**
     * 按id查询
     * @param typeId
     * @return
     */
    MealType selectById(Integer typeId);
}
