package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Offerline;
import com.dyhc.sdglgroundconnection.service.OfferlineService;
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
 * 报价线路信息记录 控制层
 **/
@RestController
@RequestMapping("Offerline")
public class OfferlineController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferlineController.class);

    @Autowired
    private OfferlineService offerlineService;

    @RequestMapping("/selectofferline")
    public ReponseResult selectofferline() {
        try {
            List<Offerline> list = offerlineService.selectOfferline();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectofferline  查询旅游线路成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectofferline  查询旅游线路失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }


    /**
     * 获取线路
     * @return
     */
    @RequestMapping("selectByofferLineRecordId")
    public ReponseResult selectByofferLineRecordId(Integer offerLineRecordId){
        try {
            Offerline offer=offerlineService.selectByofferLineRecordId(offerLineRecordId);
            ReponseResult<Object> data=ReponseResult.ok(offer,"获取线路成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取线路失败");
            e.printStackTrace();
            return  data;
        }
    }


    /**
     * 赵伟伟
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferlineByOfferId")
    public ReponseResult selectOfferlineByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            List<Offerline> offerline = offerlineService.selectOfferlineByOfferId(offerId);
            ReponseResult<Object> data = ReponseResult.ok(offerline,"获取汽车报价成功！");
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
