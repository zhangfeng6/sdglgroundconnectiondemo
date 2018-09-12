package com.dyhc.sdglgroundconnection.web;


import com.dyhc.sdglgroundconnection.service.ScenicspotService;
import com.dyhc.sdglgroundconnection.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 进入页面-控制器
 **/
@Controller
@RequestMapping("/countAdjust")
public class EnterCountAdjustPageController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(EnterGeneralControlPageController.class);

    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private ScenicspotService scenicspotService;



    /**
     *进入确认单页面
     * @return
     */
    @RequestMapping("Confirmation")
    public  String Confirmation(){
        return "voucher/Confirmation";
    }

    /**
     *进入报价单页面
     * @return
     */
    @RequestMapping("quotation")
    public  String quotation(){
        return "voucher/quotation";
    }


    /**
     *进入修改酒店页面
     * @return
     */
    @RequestMapping("hotel-update")
    public  String abcdefg(Integer hotelId,HttpServletRequest request){
        request.setAttribute("hotelId",hotelId);
        return "countAdjust/index/hotel-update";
    }


    /**
     *进入新增酒店跳页面
     * @return
     */
    @RequestMapping("hotel-add")
    public  String hotelUpdate(){
     return "countAdjust/index/hotel-add";
    }
    /**
     *进入新增酒店
     * @return
     */
    @RequestMapping("hotel-roomType-add")
    public  String addRoomType(Integer hotelId,HttpServletRequest request){
        request.setAttribute("hotelId",hotelId);
        return "countAdjust/index/hotel-roomType-add";
    }
    /**
     *进入修改酒店
     * @return
     */
    @RequestMapping("hotel-roomType-update")
    public  String UpdateRoomType(Integer typeId,Integer hotelId,HttpServletRequest request){
        request.setAttribute("typeId",typeId);
        request.setAttribute("hotelId",hotelId);
        return "countAdjust/index/hotel-roomType-update";
    }

    /**
     * 进入计调首页
     * @return
     */
    @RequestMapping("/count-Adjust-Index.html")
    public String  countAdjustIndex() {
        return "countAdjust/index/count-Adjust-Index";
    }
    /**
     * 进入类型管理单据类型管理页面
     * @return
     */
    @RequestMapping("/BillType-manage.html")
    public String  BillTypemanage() {
        return "countAdjust/index/BillType-manage";
    }
    /**
     * 进入类型管理单据类型管理页面新增
     * @return
     */
    @RequestMapping("/BillType-Save.html")
    public String  BillTySave() {
        System.out.println("进入新增页面");
        return "countAdjust/index/BillType-Save";
    }
    /**
     * 进入类型管理单据类型管理页面修改
     * @return
     */
    @RequestMapping("/BillType-Update.html")
    public String  BillTypeUpdate(Integer billTypeId,HttpServletRequest request) {
        request.setAttribute("billTypeId",billTypeId);
        return "countAdjust/index/BillType-Update";
    }

    /**
     * 进入管理信息
     * @return
     */
    @RequestMapping("/admin-info.html")
    public String  admininfo() {
        return "countAdjust/index/admin-info";
    }
    /**
     * 进入article-add页
     * @return
     */
    @RequestMapping("/article-add.html")
    public String  articleadd() {
        return "countAdjust/index/article-add";
    }
    /**
     * 进入article-detail页
     * @return
     */
    @RequestMapping("/article-detail.html")
    public String  articledetail() {
        return "countAdjust/index/article-detail";
    }
    /**
     * 进入article-detail页
     * @return
     */
    @RequestMapping("/article-list.html")
    public String  articlelist() {
        return "countAdjust/index/article-list";
    }
    /**
     * 进入article-detail页
     * @return
     */
    @RequestMapping("/article-list1.html")
    public String  articlelist1() {
        return "countAdjust/index/article-list1";
    }
    /**
     * 进入用車页
     * @return
     */
    @RequestMapping("/carRental_add.html")
    public String  carRentaladd(HttpServletRequest request) {
        String carRentalId= request.getParameter("carRentalId");
        request.setAttribute("carRentalId",carRentalId);
        return "countAdjust/index/carRental_add";
    }
    /**
     * 进入用車页
     * @return
     */
    @RequestMapping("/carRental_list.html")
    public String  carRentallist() {
        return "countAdjust/index/carRental_list";
    }
    /**
     * 进入column-danye-detail页
     * @return
     */
    @RequestMapping("/column-danye-detail.html")
    public String  columndanyedetail() {
        return "countAdjust/index/column-danye-detail";
    }
    /**
     * 进入danye-detail页
     * @return
     */
    @RequestMapping("/danye-detail.html")
    public String  danyedetail() {
        return "countAdjust/index/danye-detail";
    }
    /**
     * 进入danye-list页
     * @return
     */
    @RequestMapping("/danye-list.html")
    public String  danyelisthtml() {
        return "countAdjust/index/danye-list";
    }
    /**
     * 进入email页
     * @return
     */
    @RequestMapping("/email.html")
    public String  email() {
        return "countAdjust/index/email";
    }
    /**
     * 进入email-write页
     * @return
     */
    @RequestMapping("/email-write.html")
    public String  emailwrite() {
        return "countAdjust/index/email-write";
    }
    /**
     * 进入email-write页
     * @return
     */
    @RequestMapping("/hotel-add.html")
    public String  hoteladd() {
        return "countAdjust/index/hotel-add";
    }
    /**
     * 进入email-write页
     * @return
     */
    @RequestMapping("/hotel-list.html")
    public String  hotellist() {
        return "countAdjust/index/hotel-list";
    }
    /**
     * 进入email-write页
     * @return
     */
    @RequestMapping("/hotelroom-add.html")
    public String  hotelroomadd() {
        return "countAdjust/index/hotelroom-add";
    }
    /**
     * 进入login页
     * @return
     */
    @RequestMapping("/login.html")
    public String  login() {
        return "countAdjust/index/login";
    }
    /**
     * 进入menu1页
     * @return
     */
    @RequestMapping("/menu1.html")
    public String  menu1() {
        return "countAdjust/index/menu1";
    }
    /**
     * 进入menu2页
     * @return
     */
    @RequestMapping("/menu2.html")
    public String  menu2() {
        return "countAdjust/index/menu2";
    }
    /**
     * 进入menu-add页
     * @return
     */
    @RequestMapping("/menu-add.html")
    public String  menuadd() {
        return "countAdjust/index/menu-add";
    }
    /**
     * 进入menu-add2页
     * @return
     */
    @RequestMapping("/menu-add2.html")
    public String  menuadd2() {
        return "countAdjust/index/menu-add2";
    }
    /**
     * 进入rbac-admin页
     * @return
     */
    @RequestMapping("/rbac-admin.html")
    public String  rbacadmin() {
        return "countAdjust/index/rbac-admin";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/rbac-user-list.html")
    public String  rbacuserlist() {
        return "countAdjust/index/rbac-user-list";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/Restaurant-add.html")
    public String  Restaurantadd() {
        return "countAdjust/index/Restaurant-add";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/Restaurant-list.html")
    public String  Restaurantlist() {
        return "countAdjust/index/Restaurant-list";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/Restaurantroom-add.html")
    public String  Restaurantroomadd() {
        return "countAdjust/index/Restaurantroom-add.html";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/shopping-list.html")
    public String  shoppinglist() {
        return "countAdjust/index/shopping-list";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/spot-add.html")
    public String  spotadd(HttpServletRequest request) {
        try {

            String id=request.getParameter("id");
            Integer spotId=Integer.parseInt(id);
            request.setAttribute("jdId",spotId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "countAdjust/index/spot-add";



    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/spot-list.html")
    public String  spotlist() {
        return "countAdjust/index/spot-list";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
    @RequestMapping("/spotshopping-add.html")
    public String  spotshoppingadd(HttpServletRequest request) {
        String scenicSpotId= request.getParameter("scenicSpotId");
        request.setAttribute("scenicSpotId",scenicSpotId);
        request.setAttribute("shoppingId",0);
        return "countAdjust/index/spotshopping-add";
    }
    /**
     * 进入rbac-user-list页
     * @return
     */
   @RequestMapping("/spotshopping-update.html")
    public String  spotshoppingupdate(HttpServletRequest request) {
        String shoppingId= request.getParameter("shoppingId");
        request.setAttribute("shoppingId",shoppingId);
       request.setAttribute("scenicSpotId","");
        return "countAdjust/index/spotshopping-add";
    }

    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/system.html")
    public String  system() {
        return "countAdjust/index/system";
    }
    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/traffic_add.html")
    public String  trafficadd() {
        return "countAdjust/index/traffic_add";
    }
    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/traffic_list.html")
    public String  trafficlist() {
        return "countAdjust/index/traffic_list";
    }

    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/vehicleType_add.html")
    public String  vehicleType_add(HttpServletRequest request) {
        String carRentalId= request.getParameter("carRentalId");
        String typeId= request.getParameter("typeId");
        request.setAttribute("typeId",typeId);
        request.setAttribute("carRentalId",carRentalId);
        return "countAdjust/index/vehicleType_add";
    }
    /**
     * 进入welcome页
     * @return
     */
    @RequestMapping("/welcome.html")
    public String  welcome() {
        return "countAdjust/index/welcome";
    }

    /**
     * 进入allScheduling页
     * @return
     */
    @RequestMapping("/allScheduling.html")
    public String  allScheduling() {
        return "countAdjust/index/allScheduling";
    }

    /**
     * 进入Quotation页
     * @return
     */
    @RequestMapping("/Quotation.html")
    public String  EnterQuotation() {
        return "countAdjust/index/Quotation";
    }

    /**
     * 进入Scheduling-detail页
     * @return
     */
    @RequestMapping("/Scheduling-detail.html")
    public String  SchedulingDetail() {
        return "countAdjust/index/Scheduling-detail";
    }

    /**
     * 进入Quotation-detail.html页
     * @return
     */
    @RequestMapping("/Quotation-detail.html")
    public String  QuotationDetail(@RequestParam(value = "id",required = false)Integer id,
                                   @RequestParam(value = "did",required = false)Integer did,
                                   @RequestParam(value = "offer",required = false)String offer,
                                   @RequestParam(value = "zhidu",required = false)Integer zhidu,
                                   Model model) {
        if(id!=null&&id!=0){
            model.addAttribute("id",id);
        }
        if(did!=null&&did!=0){
            model.addAttribute("did",did);
        }
        if(offer!=null&&!offer.equals("")){
            model.addAttribute("offer",offer);
        }
        if(zhidu!=null&&zhidu!=0){
            model.addAttribute("zhidu",zhidu);
        }
        return "countAdjust/index/Quotation-detail";
    }

    /**
     * 进入line-template.html页
     * @return
     */
    @RequestMapping("/line-template.html")
    public String  linetemplate() {
        return "countAdjust/index/line-template";
    }

    /**
     * 进入line-template.html页
     * @return
     */
    @RequestMapping("/savetemplate.html")
    public String  savetemplate(@RequestParam(value = "mid",required = false)Integer mid,Model model) {
        if(mid!=null){
            model.addAttribute("mid",mid);
        }
        return "countAdjust/index/savetemplate";
    }

    @RequestMapping("/total-template.html")
    public String  totaltemplate() {
        return "countAdjust/index/total-template";
    }

    /**
     * 进入line-template.html页
     * @return
     */
    @RequestMapping("/saveTourism.html")
    public String  saveTourism(@RequestParam(value = "mid",required = false)Integer mid,Model model) {
        if(mid!=null){
            model.addAttribute("mid",mid);
        }
        return "countAdjust/index/saveTourism";
    }


    /**
     * 进入CanType-list.html页 刘跃云
     * @return
     */
    @RequestMapping("/CanType-list.html")
    public String  CanType() {
        return "countAdjust/index/CanType-list";
    }

    /**
     * 进入CanType-upd.html页 刘跃云
     * @return
     */
    @RequestMapping("/CanType-upd.html")
    public String  CanType(Integer dictionariesId,HttpServletRequest request) {
        request.setAttribute("dictionariesId",dictionariesId);
        System.out.println(123);
        return "countAdjust/index/CanType-upd";
    }


    /**
     * 进入CarType-list.html页 刘跃云
     * @return
     */
    @RequestMapping("/CarType-list.html")
    public String  CarType() {
        return "countAdjust/index/CarType-list";
    }

    /**
     * 进入CarType-upd.html页 刘跃云
     * @return
     */
    @RequestMapping("/CarType-upd.html")
    public String  CarType(Integer dictionariesId,HttpServletRequest request) {
        request.setAttribute("dictionariesId",dictionariesId);
        System.out.println(123);
        return "countAdjust/index/CarType-upd";
    }
    /**
     * 进入HotelType-list.html页 刘跃云
     * @return
     */
    @RequestMapping("/HotelType-list.html")
    public String  HotelType() {
        return "countAdjust/index/HotelType-list";
    }

    /**
     * 进入HotelType-upd.html页  刘跃云
     * @return
     */
    @RequestMapping("/HotelType-upd.html")
    public String  HotelType1(Integer dictionariesId,HttpServletRequest request) {
        request.setAttribute("dictionariesId",dictionariesId);
        System.out.println(123);
        return "countAdjust/index/HotelType-upd";
    }


    /**
     * 进入findDisguide.html页面 刘跃云
     * @return
     */
    @RequestMapping("/findDisguide.html")
    public String findDisguide(){
        return "voucher/TravelPlan";

    }


    /**
     * 进入ptd.html页面 刘跃云
     * @return
     */
    @RequestMapping("/ptd.html")
    public String findDisguidexxx(){
        return "voucher/ptd";

    }
}
