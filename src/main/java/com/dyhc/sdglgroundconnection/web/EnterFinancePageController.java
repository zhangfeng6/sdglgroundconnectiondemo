package com.dyhc.sdglgroundconnection.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/finance")
public class EnterFinancePageController {

    /**
     * 进入计调首页
     * @return
     */
    @RequestMapping("/finance-Index.html")
    public String  financeIndex() {
        return "finance/index/finance-Index";
    }

    /**
     * 进入addQuotationInfo-add页面
     * @return
     */
    @RequestMapping("/addQuotationInfo-add.html")
    public String  addQuotationInfoAdd() {
        return "finance/index/addQuotationInfo-add";
    }

    /**
     * 进入showQuotationInfo页面
     * @return
     */
    @RequestMapping("/showQuotationInfo.html")
    public String  showQuotationInfo() {
        return "finance/index/showQuotationInfo";
    }

    /**
     * 进入showQuotationInfo页面
     * @return
     */
    @RequestMapping("/welcome.html")
    public String  Enterwelcome() {
        return "finance/index/welcome";
    }

    /**
     * 进入article-list.html页面
     * @return
     */
    @RequestMapping("/article-list.html")
    public String  articleList() {
        return "finance/index/article-list";
    }

    /**
     * 进入article-list.html页面
     * @return
     */
    @RequestMapping("/detail.html")
    public String  showQuotationdetail(HttpServletRequest request) {
        String reportDetailId= request.getParameter("reportDetailId");
        request.setAttribute("reportDetailId",reportDetailId);
        return "finance/index/detail";
    }

    /**
     * 进入预览图片界面
     * @return
     */
    @RequestMapping("/viewPictures.html")
    public String EnterViewPictures(HttpServletRequest request){
        String dispatchId=request.getParameter("dispatchId");
        String billTypeId=request.getParameter("billTypeId");
        request.setAttribute("dispatchId",dispatchId);
        request.setAttribute("billTypeId",billTypeId);
        return "finance/index/viewPictures";
    }

    /**
     * 进入article-list.html页面
     * @return
     */
    @RequestMapping("/admin-info.html")
    public String  admininfo() {
        return "finance/index/admin-info";
    }
}
