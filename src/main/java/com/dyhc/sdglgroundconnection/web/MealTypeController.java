package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.MealType;
import com.dyhc.sdglgroundconnection.service.MealTypeService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 饮食类型 控制层
 **/
@RequestMapping("MealType")
@RestController
public class MealTypeController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(MealTypeController.class);

    @Autowired
    private MealTypeService mealTypeService;

    /**
     * 赵伟伟
     * @param restaurantId
     * @return
     */
    @RequestMapping("/selectMealTypeByRestaurantId")
    public ReponseResult selectMealTypeByRestaurantId(Integer restaurantId) {
        try {
            ReponseResult<List> data = ReponseResult.ok(mealTypeService.selectMealTypeByRestaurantId(restaurantId), "获取饭店类型成功！");
            logger.info(" method:selectMealTypeByRestaurantId  获取饭店类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectMealTypeByRestaurantId  饭店类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    @RequestMapping("/selectById")
    public ReponseResult selectById(Integer typeId) {
        try {
            ReponseResult<MealType> data = ReponseResult.ok(mealTypeService.selectById(typeId), "获取饭店类型成功！");
            logger.info(" method:selectById  获取饭店类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectById  饭店类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 赵伟伟
     * @param
     * @return
     */
    @RequestMapping("/updateMealType")
    @LogNotes(operationType="饭店类型",content="保存")
    public ReponseResult updateMealType(Integer costprice,Integer offer,Integer valueId,Integer typeId,Integer restaurantId) {
        MealType mealType = new MealType();
        mealType.setCostprice(costprice.doubleValue());
        mealType.setOffer(offer.doubleValue());
        mealType.setValueId(valueId);
        mealType.setRestaurantId(restaurantId);
        mealType.setTypeId(typeId);
        int i=0;
        try {
            if (mealType.getTypeId()==0){
                i = mealTypeService.insertMealType(mealType);
            }else{
                i = mealTypeService.updateMealType(mealType);
            }
            ReponseResult<Object> data = ReponseResult.ok("保存饭店类型成功！");
            logger.info(" method:updateMealType  保存类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:updateMealType  保存饭店类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    @RequestMapping("/delMealTypeById")
    @LogNotes(operationType="饭店类型",content="删除")
    public ReponseResult delMealTypeById(Integer restaurantId) {
        MealType mealType = new MealType();
        mealType.setTypeId(restaurantId);
        try {
            Integer i = mealTypeService.delMealTypeById(mealType);
            ReponseResult<Object> data = ReponseResult.ok("删除成功！");
            logger.info(" method:delMealTypeById  删除饭店类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:delMealTypeById  删除饭店类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("删除失败！");
            return err;
        }
    }

    @RequestMapping("/selectDic")
    public ReponseResult selectDic() {
        try {
            ReponseResult<List> data = ReponseResult.ok(mealTypeService.selectDic(), "获取饭店类型成功！");
            logger.info(" method:selectDic  获取饭店类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectDic  饭店类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    @RequestMapping("/selectMealType")
    public ReponseResult selectMealType() {
        try {
            List<Dictionaries> list = mealTypeService.selectMealType();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectMealType  查询餐馆类型成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectMealType  查询餐馆类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
}
