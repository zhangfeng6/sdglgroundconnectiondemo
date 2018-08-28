package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.*;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度业务实现
 **/
@Service
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchMapper dispatchMapper;

    @Autowired
    private DispatchhotelMapper dispatchhotelMapper;

    @Autowired
    private  DispatchhotelServiceImpl dispatchhotelService;

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Autowired
    private TravelMapper travelMappere;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private ScenicspotMapper scenicspotMapper;

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Autowired
    private GuideMapper guideMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private CarrentalMapper carrentalMapper;
    /**
     * 根据条件查询调度信息 并分页返回
     * @param pageNo        当前页数
     * @param pageSize      每页显示量
     * @param djsth         地接社团号
     * @param dyname        导游名称
     * @param state         调度信息状态
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Dispatch> listDispatch(Integer pageNo, Integer pageSize, String djsth, String dyname, Integer state) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Dispatch> pageInfo=new PageInfo<Dispatch>(dispatchMapper.listdispatch(djsth, dyname, state));
        return pageInfo;
    }

    /**
     * 获取信息资源
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getresource() throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("travel",travelMappere.selectAll());
        map.put("template",templateMapper.selectAll());
        map.put("scenicspot",scenicspotMapper.selectAll());
        map.put("shopping",shoppingMapper.selectAll());
        map.put("guide",guideMapper.selectAll());
        map.put("vehicle",dictionariesMapper.listdictionarieslBycode("VEHICLE"));
        map.put("traffic",dictionariesMapper.listdictionarieslBycode("TRAFFIC"));
        map.put("theroom",dictionariesMapper.listdictionarieslBycode("THEROOM"));
        map.put("diet",dictionariesMapper.listdictionarieslBycode("DIET"));
        return map;
    }

    @Override
    public List listinfoByvalueId(String type, Integer valueId) throws Exception {
        List list=null;
        if(type.equals("hoteltype")){
            list= hotelMapper.listhotelByvalueId(valueId);
        }else if(type.equals("fantype")){
            list=restaurantMapper.listrestaurantByvalueId(valueId);
        }else if(type.equals("cartype")){
            list=carrentalMapper.listcarrentalByvalueId(valueId);
        }
        return list;
    }

    /**
     * 调度表的信息：贾晓亮
     * @param dispatchId
     * @return
     */
    public  Dispatch dispatchSelectAll(Integer dispatchId){
        Dispatch dispatch=null;
        try {
             dispatch =dispatchMapper.dispatchSelectAll(dispatchId);
             Travel travel =travelMappere.selectTravelById(dispatch.getGroupNumber());
             String A ="";
             if (travel.getTravelName()==null){
                 A="无组团名称";
                 travel.setTravelName(A);
             }
             dispatch.setTravel(travel);
             List<Dispatchhotel> dispatchhotels =dispatchhotelService.dispatchhotelSelectAll(dispatchId);
             /* dispatchhotelMapper.dispatchhotelSelectAll(dispatchId);*/
             dispatch.setDispatchhotel(dispatchhotels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispatch;
    }

    @Override
    public Dispatch getDispatchByguideId(Integer guideId)throws Exception {
        return dispatchMapper.getDispatchByguideId(guideId);
    }
}
