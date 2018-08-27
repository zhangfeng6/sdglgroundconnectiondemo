package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.MealType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 饮食类型业务接口
 **/
public interface MealTypeService {

    /**
     * 赵伟伟
     * 按照餐馆id查询餐馆类型
     * @return
     */
    List<MealType> selectMealTypeByRestaurantId(int restaurantId);

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
     * 新增餐馆
     * @param mealType
     * @return
     */
    int insertMealType(MealType mealType);

    /**
     * 查询餐馆类型
     * @return
     */
    List<Dictionaries> selectDic();

    /**
     * 按主键查询
     * @return
     */
    MealType selectById(int typeId);

    /**
     * 赵伟伟
     * 查询所有类型
     * @return
     */
    List<Dictionaries> selectMealType();
}
