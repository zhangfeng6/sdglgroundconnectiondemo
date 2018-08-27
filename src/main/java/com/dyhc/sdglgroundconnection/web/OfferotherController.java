package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Offerother;
import com.dyhc.sdglgroundconnection.service.OfferotherService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价其他 控制层
 **/
@RestController
@RequestMapping("Offerother")
public class OfferotherController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferotherController.class);

    @Autowired
    private OfferotherService offerotherService;

    /**
     * 赵伟伟
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferotherByOfferId")
    public ReponseResult selectOfferotherByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            Offerother offerother = offerotherService.selectOfferotherByOfferId(offerId);
            ReponseResult<Offerother> data = ReponseResult.ok(offerother,"获取其他报价成功！");
            logger.info(" method:selectOfferotherByOfferId  获取其他报价成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferotherByOfferId  获取其他报价数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
