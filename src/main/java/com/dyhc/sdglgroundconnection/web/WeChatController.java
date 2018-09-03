package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.service.*;
import com.dyhc.sdglgroundconnection.utils.DateDifference;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.dyhc.sdglgroundconnection.utils.WechatFileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Controller
@RequestMapping("/WeChat")
public class WeChatController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(GuideController.class);

    @Autowired
    private GuideService guideService;
    @Autowired
    private LogService logService;
    @Autowired
    private DispatchService dispatchService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private DispatchhotelService dispatchhotelService;
    @Autowired
    private DisrestaurantService disrestaurantService;
    @Autowired
    private MealTypeService mealTypeService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DisshoppService disshoppService;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private HoteroomTypeService hoteroomTypeService;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private BillService billService;



    /**
     * 微信登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/guideLogin")
    @ResponseBody
    public ReponseResult guideLogin(String username,String password){
        try {
            System.out.println(password);
            Guide guide=guideService.login(username,password);
            if (guide!=null){
                if(password.equals(guide.getPassword())){
                    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                    HttpSession session=request.getSession();//创建session对象
                    session.setAttribute("staff",guide);
                    logger.info("method:login 微信登录成功");
                    return ReponseResult.ok(guide,"登录成功");
                }else {
                    logger.error("method:login 微信登录失败");
                    return ReponseResult.err("登录失败");
                }
            }else {
                logger.error("method:login 微信登录失败");
                return ReponseResult.err("登录失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:login 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }


    /**
     * 上传单据
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    @LogNotes(operationType="单据",content="添加")
    public synchronized ReponseResult upload(HttpServletRequest request){
        try {
            Integer dispatchId=Integer.parseInt(request.getParameter("dispatchId"));
            Integer billTypeId=Integer.parseInt(request.getParameter("billTypeId"));
            String path= WechatFileUploadUtil.uploadImage(request,".jpg");
            Bill bill=billService.selectBillByDispatchIdAndBillTypeId(dispatchId,billTypeId);
            if (bill==null){
                bill.setDispatchId(dispatchId);
                bill.setBillTypeId(billTypeId);
                bill.setPicturePath(path);
                bill.setWhetherDel(0);
                bill.setCreateBy(1);
                bill.setCreateDate(new Date());
                Integer result=billService.insertBill(bill);
                if (result==1){
                    logger.info("mothod:upload 上传成功");
                    return ReponseResult.ok(result,"上传成功");
                }else {
                    logger.error("mothod:upload 上传失败");
                    return ReponseResult.err("上传失败");
                }
            }else {
                String lujing=bill.getPicturePath();
                lujing+=","+path;
                bill.setPicturePath(lujing);
                Integer result=billService.updateBillById(bill);
                if (result==1){
                    logger.info("mothod:upload 上传成功");
                    return ReponseResult.ok(result,"上传成功");
                }else {
                    logger.error("mothod:upload 上传失败");
                    return ReponseResult.err("上传失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:upload 上传失败");
            return ReponseResult.err("上传失败");
        }
    }

    /**
     * 微信小程序之判断旧密码是否输入正确
     * @param password
     * @return
     */
    @RequestMapping("/pdOldPassword")
    @ResponseBody
    public ReponseResult pdOldPassword(String password,Integer guideId){
        try {
            Guide guide=guideService.assignmentGuide(guideId);
            if (guide!=null){
                if(password.equals(guide.getPassword())){
                    logger.info("method:pdOldPassword 旧密码输入正确");
                    return ReponseResult.ok(1,"旧密码输入正确");
                }else {
                    logger.error("method:pdOldPassword 旧密码输入失败");
                    return ReponseResult.err("旧密码输入失败");
                }
            }else {
                logger.error("method:pdOldPassword 旧密码输入失败");
                return ReponseResult.err("旧密码输入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:pdOldPassword 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }

    /**
     * 微信小程序之修改密码
     * @return
     */
    @RequestMapping("/updateGuideByPassword")
    @LogNotes(operationType="微信小程序密码",content="修改")
    @ResponseBody
    public ReponseResult updateGuideByPassword(Guide guide){
        try {
            Integer result=guideService.updateGuideByPassword(guide);
            if (result==1){
                logger.info("method:updateGuideByPassword 修改密码成功");
                return ReponseResult.ok(result,"修改成功");
            }else {
                logger.error("method:updateGuideByPassword 修改密码失败");
                return ReponseResult.err("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:updateGuideByPassword 修改密码失败");
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 添加带团日志
     * @param log
     * @return
     */
    @RequestMapping("/insertLog")
    @LogNotes(operationType="日志",content="添加")
    @ResponseBody
    public ReponseResult insertLog(Log log){
        try {
            log.setWhetherDel(0);
            log.setCreater(1);
            log.setCreationDate(new Date());
            Integer result=logService.inserLog(log);
            ReponseResult data=null;
            if (result==1){
                logger.info("Mothod:insertLog  上传日志成功");
                data=ReponseResult.ok(result,"上传日志成功");
            }else {
                logger.info("Mothod:insertLog  上传日志失败");
                data=ReponseResult.ok(result,"上传日志失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Mothod:insertLog  上传日志失败");
            return ReponseResult.err("上传日志失败");
        }
    }


    /**
     * 根据导游id查询调度信息
     * @param guideId 导游id
     * @return
     */
    @RequestMapping("/getDispatchByguideId")
    @ResponseBody
    public ReponseResult getDispatchByguideId(Integer guideId){
        try {
            Dispatch dispatch=dispatchService.getDispatchByguideId(guideId);
            Integer date=DateDifference.differentDays(dispatch.getTravelStartTime(),dispatch.getTravelEndTime());
            List<Integer> list=new ArrayList<Integer>();
            list.add(date);
            list.add(dispatch.getDispatchId());
            ReponseResult data=ReponseResult.ok(list,"获取调度对象成功");
            logger.info("method:getDispatchByguideId 获取调度对象成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getDispatchByguideId 系统异常");
            return ReponseResult.err("获取调度对象失败");
        }
    }


    /**
     * 修改导游信息
     * @param guideId
     * @return
     */
    @RequestMapping("/assignmentGuide")
    @ResponseBody
    @LogNotes(operationType="导游表",content="导游修改赋值 ")
    public  ReponseResult assignmentGuide(@RequestParam("guideId") Integer guideId){
        try {
            ReponseResult<Guide> data =ReponseResult.ok(guideService.assignmentGuide(guideId),"导游信息修改赋值成功!");
            logger.info("method:showAccountType 导游信息修改赋值成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息修改赋值失败");
            e.printStackTrace();
            return  ReponseResult.err("系统出现异常请联系管理员");
        }
    }

    /**
     * 获取酒店名称:陈庆武
     * @param dispatchId
     * @return
     */
    @RequestMapping("/getHoterById")
    @ResponseBody
    public ReponseResult getHoterById(Integer dispatchId,Integer weight){
        try {
            Dispatchhotel dispatchhotel=dispatchhotelService.getDispatchHotel(dispatchId,weight);
            Hotel hotel=hotelService.getHotelById(dispatchhotel.getHotelId());
            logger.info("method:getHoterById  获取酒店名称成功！");
            return ReponseResult.ok(hotel,"获取酒店名称成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getHoterById  获取酒店名称失败！");
            return ReponseResult.err("获取酒店名称失败");
        }
    }

    /**
     * 获取餐厅信息
     * @param dispatchId
     * @param weight
     * @return
     */
    @RequestMapping("/getRestaurantById")
    @ResponseBody
    public ReponseResult getRestaurantById(Integer dispatchId,Integer weight){
        try {
            Disrestaurant disrestaurant=disrestaurantService.getDisrestaurantById(dispatchId,weight);

            MealType mealType=mealTypeService.selectById(disrestaurant.getTypeId());
            Restaurant restaurant=restaurantService.selectRestaurantById(mealType.getRestaurantId());
            logger.info(" method:getRestaurantById  获取餐厅信息成功！");
            return ReponseResult.ok(restaurant,"获取餐厅信息成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(" method:getRestaurantById  获取餐厅信息失败！");
            return ReponseResult.err("获取餐厅信息失败");
        }
    }

    /**
     *微信小程序之获取购物地点
     * @param dispatchId
     * @param weight
     * @return
     */
    @RequestMapping("/getShoppingByIdWX")
    @ResponseBody
    public ReponseResult getShoppingByIdWX(Integer dispatchId,Integer weight){
        try {
            Disshopp disshopp=disshoppService.getDisshoppById(dispatchId,weight);
            Shopping shopping=shoppingService.getShoppingById(disshopp.getScenicSpotId());
            logger.info("method:getShoppingByIdWX  获取购物信息成功！");
            return ReponseResult.ok(shopping,"获取购物地点成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getShoppingByIdWX  获取购物信息失败！");
            return ReponseResult.err("获取购物地点失败");
        }
    }

    /**
     * 微信小程序之获取行程内容
     * @param weight
     * @return
     */
    @RequestMapping("/getTemplateById")
    @ResponseBody
    public ReponseResult getTemplateById(Integer dispatchId,Integer weight){
        try {
            HoteroomType hoteroomType=hoteroomTypeService.getHoteroomTypeById(dispatchId,weight);
            Template template=templateService.selecctNameById(hoteroomType.getTemplateId());
            logger.error("method:getTemplateById  获取行程内容成功");
            return ReponseResult.ok(template,"获取行程内容成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getTemplateById  获取行程内容失败");
            return ReponseResult.err("获取行程内容失败");
        }
    }
}
