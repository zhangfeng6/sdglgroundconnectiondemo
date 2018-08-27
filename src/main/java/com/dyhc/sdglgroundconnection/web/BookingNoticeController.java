package com.dyhc.sdglgroundconnection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookingNoticeController {
    /**
     * 跳入调度酒店页面
     * @return
     */
    @RequestMapping("BookingNotice")
    public  String BookingNotice(){
        return  "voucher/BookingNotice";
    }
}
