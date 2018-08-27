package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Offercar;
import com.dyhc.sdglgroundconnection.service.OffercarService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价用车 控制层
 **/
@RestController
@RequestMapping("Offercar")
public class OffercarController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OffercarController.class);

    @Autowired
    private OffercarService offercarService;


    /**
     * 赵伟伟
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferByOfferId")
    public ReponseResult selectOfferByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            Offercar offercar = offercarService.selectOffercarByOfferId(offerId);
            ReponseResult<Object> data = ReponseResult.ok(offercar,"获取汽车报价成功！");
            logger.info(" method:selectOfferByOfferId  获取汽车报价成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferByOfferId  汽车报价数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

}
