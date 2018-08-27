package com.dyhc.sdglgroundconnection.web;
import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import com.dyhc.sdglgroundconnection.service.ReportrestaurantService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账餐厅 控制层
 **/
@RequestMapping("Reportrestaurant")
@RestController
public class ReportrestaurantController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportrestaurantController.class);

    @Autowired
    private ReportrestaurantService reportrestaurantService;

    /**
     * 导游报账住宿新增
     * @param
     * @return0.
     */
    @LogNotes(operationType="导游餐厅明细",content="餐厅新增")
    @RequestMapping("/saveStaurant")
    public ReponseResult savereportrestaurant(
           @RequestParam("LuncheonName") String LuncheonName,
           @RequestParam("lunchMeal")Double lunchMeal,
           @RequestParam("lunchEatNum")  Integer lunchEatNum,
           @RequestParam("lunchother") Double lunchother,
           @RequestParam("lunchPayMethods")  String lunchPayMethods,
           @RequestParam("dinnerName")  String dinnerName,
           @RequestParam("dinnerMeal")  Double dinnerMeal,
           @RequestParam("dinnerEatNum")  Integer dinnerEatNum,
           @RequestParam("dinnerother") Double dinnerother,
           @RequestParam("dinnerPayMethods")  String dinnerPayMethods
          ){
        Reportrestaurant reportrestaurant =new Reportrestaurant();
        reportrestaurant.setLunchDate(new Date());
        reportrestaurant.setDinnerName(dinnerName);
        reportrestaurant.setLuncheonName(LuncheonName);
        reportrestaurant.setLunchMeal(lunchMeal);
        reportrestaurant.setLunchEatNum(lunchEatNum);
        reportrestaurant.setLunchother(lunchother);
        reportrestaurant.setLunchPayMethods(lunchPayMethods);
        reportrestaurant.setDinnerDate(new Date());
        reportrestaurant.setDinnerMeal(dinnerMeal);
        reportrestaurant.setDinnerPayMethods(dinnerPayMethods);
        reportrestaurant.setDinnerEatNum(dinnerEatNum);
        reportrestaurant.setDinnerother(dinnerother);
            try {
            Integer num=reportrestaurantService.saveReportrestaurant(reportrestaurant);
            logger.info("method:savereportaccommodation 导游餐馆明细新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("餐馆新增成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游餐馆明细新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
}
