package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Company;
import com.dyhc.sdglgroundconnection.service.CompanyService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 公司信息 控制层
 **/
@RequestMapping("/CompanyController")
@RestController
public class CompanyController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    /**
     * 查看公司
     * @return
     */
    @RequestMapping("/CompanyList")
    public ReponseResult CompanyList(){
        try{
            Company company=companyService.getCompany();
            ReponseResult<Company> data= ReponseResult.ok(company,"查看取组团社成功！");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    @RequestMapping("/companyupd.html")
    @LogNotes(operationType="公司信息",content="修改")
    public ReponseResult<Integer> getcompanyupd(Company company){
        System.out.println(company.getCompanyName());
        try{
            Integer data=0;
            Integer result=0;
            result=companyService.getUpdCompany(company);
            if(result>0){
                data=1;
            }
            logger.info(" method:getcompanyupd  修改公司信息成功！");
            return ReponseResult.ok(data,"修改公司信息成功！");
        }catch (Exception e) {
            logger.error(" method:getcompanyupd  修改公司信息失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
