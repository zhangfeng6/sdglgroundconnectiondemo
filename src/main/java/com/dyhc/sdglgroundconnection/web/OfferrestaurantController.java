package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Offerrestaurant;
import com.dyhc.sdglgroundconnection.service.OfferrestaurantService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价餐厅 控制层
 **/
@RestController
@RequestMapping("Offerrestaurant")
public class OfferrestaurantController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferrestaurantController.class);

    @Autowired
    private OfferrestaurantService offerrestaurantService;


    /**
     * 赵伟伟
     * 查询午餐报价
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferRestaurantByOfferId")
    public ReponseResult selectOfferRestaurantByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            List<Offerrestaurant> offerrestaurant = offerrestaurantService.selectOfferRestaurantByOfferId(offerId);
            List<Offerrestaurant> wu = new ArrayList<>();
            for (Offerrestaurant offerrestaurant1: offerrestaurant) {
                Integer house = offerrestaurant1.getHavemealsdate();
                if (house==2){
                    wu.add(offerrestaurant1);
                }
            }
            ReponseResult<Object> data = ReponseResult.ok(wu,"获取餐厅报价成功！");
            logger.info(" method:selectOfferHotelByOfferId  获取餐厅报价成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferHotelByOfferId  酒店餐厅数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 赵伟伟
     * 查询晚餐报价
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferRestaurantByOfferId1")
    public ReponseResult selectOfferRestaurantByOfferId1(@RequestParam("offerId") Integer offerId) {
        try {
            List<Offerrestaurant> offerrestaurant = offerrestaurantService.selectOfferRestaurantByOfferId(offerId);
            List<Offerrestaurant> wan = new ArrayList<>();
            for (Offerrestaurant offerrestaurant1: offerrestaurant) {
                Integer house = offerrestaurant1.getHavemealsdate();
                if (house==3){
                    wan.add(offerrestaurant1);
                }
            }
            ReponseResult<Object> data = ReponseResult.ok(wan,"获取餐厅报价成功！");
            logger.info(" method:selectOfferHotelByOfferId  获取餐厅报价成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferHotelByOfferId  酒店餐厅数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
