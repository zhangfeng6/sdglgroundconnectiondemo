package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Offerother;
import com.dyhc.sdglgroundconnection.pojo.Offerscenic;
import com.dyhc.sdglgroundconnection.service.OfferscenicService;
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
 * 报价景点 控制层
 **/
@RestController
@RequestMapping("Offerscenic")
public class OfferscenicController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferscenicController.class);

    @Autowired
    private OfferscenicService offerscenicService;


    /**
     * 赵伟伟
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferscenicByOfferId")
    public ReponseResult selectOfferscenicByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            List<Offerscenic> offerscenic = offerscenicService.selectOfferscenicByOfferId(offerId);
            ReponseResult<Object> data = ReponseResult.ok(offerscenic,"获取景点报价成功！");
            logger.info(" method:selectOfferotherByOfferId  获取景点报价成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferotherByOfferId  获取景点报价数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
