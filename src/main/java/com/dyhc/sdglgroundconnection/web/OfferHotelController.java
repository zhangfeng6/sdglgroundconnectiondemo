package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.OfferHotel;
import com.dyhc.sdglgroundconnection.service.OfferHotelService;
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
 * 报价酒店 控制层
 **/
@RestController
@RequestMapping("OfferHotel")
public class OfferHotelController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferHotelController.class);

    @Autowired
    private OfferHotelService offerHotelService;


    /**
     * 赵伟伟
     * 获取酒店报价
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferHotelByOfferId")
    public ReponseResult selectOfferHotelByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            List<OfferHotel> offerhotel = offerHotelService.selectOfferHotelByOfferId(offerId);
            ReponseResult<Object> data = ReponseResult.ok(offerhotel,"获取酒店报价成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
