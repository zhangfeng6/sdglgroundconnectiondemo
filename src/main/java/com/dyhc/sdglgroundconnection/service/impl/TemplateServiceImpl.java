package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TemplateHotelMapper;
import com.dyhc.sdglgroundconnection.mapper.TemplateMapper;
import com.dyhc.sdglgroundconnection.mapper.TemplateScenicspotMapper;
import com.dyhc.sdglgroundconnection.parameterentity.TemplateParameter;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.pojo.TemplateHotel;
import com.dyhc.sdglgroundconnection.pojo.TemplateScenicspot;
import com.dyhc.sdglgroundconnection.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板业务实现
 **/
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateScenicspotMapper templateScenicspotMapper;

    @Autowired
    private TemplateHotelMapper templateHotelMapper;

    /**
     * 查询模板信息   张枫
     * @param tempName  模板名称
     * @param userName  创建人名称
     * @param pageNo    当前页
     * @param pageSize  每页显示量
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Template> listtemplate(String tempName, String userName, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<Template> listtemplate = templateMapper.listtemplate(tempName, userName);
        PageInfo<Template> pageInfo=new PageInfo<Template>(listtemplate);
        return pageInfo;
    }

    @Override
    public Template gettemplateByName(String templateName) throws Exception {
        return templateMapper.gettemplateByName(templateName);
    }

    @Override
    @Transactional()
    public int savetemplate(TemplateParameter template) throws Exception {
        try {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            Template tem=new Template();
            tem.setTemplateName(template.getTemplateName());
            tem.setTemplateContent(template.getTemplateContent());
            tem.setCreater(1);
            tem.setCreationDate(d);
            tem.setWhetherDel(0);
            templateMapper.insert(tem);

            Template gettem=templateMapper.gettemplateByName(template.getTemplateName());
            System.out.println("..."+gettem.getTemplateId()+"...");
            TemplateHotel temhotel=new TemplateHotel();
            temhotel.setTemplateHotelId(1);
            temhotel.setTemplateId(gettem.getTemplateId());
            temhotel.setHotelId(template.getHotelId());
            temhotel.setCostPrice(template.getCostprice());
            temhotel.setOffer(template.getOffer());
            temhotel.setCreater(1);
            temhotel.setCreationDate(d);
            temhotel.setWhetherDel(0);
            templateHotelMapper.insert(temhotel);
            List<TemplateScenicspot> temlist=new ArrayList<TemplateScenicspot>();

            if(template.getCostprice1()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setTemplateId(gettem.getTemplateId());
                temscenicspot.setScenicSpotId(template.getScenicSpotId1());
                temscenicspot.setCostPrice(template.getCostprice1());
                temscenicspot.setOffer(template.getOffer1());
                temscenicspot.setCreater(1);
                temscenicspot.setCreationDate(d);
                temscenicspot.setWhetherDel(0);
                temlist.add(temscenicspot);
            }
            if(template.getCostprice2()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setTemplateId(gettem.getTemplateId());
                temscenicspot.setScenicSpotId(template.getScenicSpotId2());
                temscenicspot.setCostPrice(template.getCostprice2());
                temscenicspot.setOffer(template.getOffer2());
                temscenicspot.setCreater(1);
                temscenicspot.setCreationDate(d);
                temscenicspot.setWhetherDel(0);
                temlist.add(temscenicspot);
            }
            if(template.getCostprice3()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setTemplateId(gettem.getTemplateId());
                temscenicspot.setScenicSpotId(template.getScenicSpotId3());
                temscenicspot.setCostPrice(template.getCostprice3());
                temscenicspot.setOffer(template.getOffer3());
                temscenicspot.setCreater(1);
                temscenicspot.setCreationDate(d);
                temscenicspot.setWhetherDel(0);
                temlist.add(temscenicspot);
            }
            if(template.getCostprice4()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setTemplateId(gettem.getTemplateId());
                temscenicspot.setScenicSpotId(template.getScenicSpotId4());
                temscenicspot.setCostPrice(template.getCostprice4());
                temscenicspot.setOffer(template.getOffer5());
                temscenicspot.setCreater(1);
                temscenicspot.setCreationDate(d);
                temscenicspot.setWhetherDel(0);
                temlist.add(temscenicspot);
            }
            if(template.getCostprice5()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setTemplateId(gettem.getTemplateId());
                temscenicspot.setScenicSpotId(template.getScenicSpotId5());
                temscenicspot.setCostPrice(template.getCostprice5());
                temscenicspot.setOffer(template.getOffer5());
                temscenicspot.setCreater(1);
                temscenicspot.setCreationDate(d);
                temscenicspot.setWhetherDel(0);
                temlist.add(temscenicspot);
            }
            templateScenicspotMapper.insertList(temlist);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}
