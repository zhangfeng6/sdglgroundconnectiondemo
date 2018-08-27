package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.*;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度业务实现
 **/
@Service
@Transactional
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchMapper dispatchMapper;

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

    @Autowired
    private GuidescheduleMapper guidescheduleMapper;
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

    @Override
    public Dispatch getDispatchByguideId(Integer guideId)throws Exception {
        return dispatchMapper.getDispatchByguideId(guideId);
    }

    /**
     * 分页查看调度信息
     * @param pageNo
     * @param pageSize
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    @Override
    public PageInfo<Dispatch> ListDispatchLike(Integer pageNo, Integer pageSize, String guideName, String groundConnectionNumber) {
        PageHelper.startPage(pageNo,pageSize,true);
        PageInfo<Dispatch> dispatch=new PageInfo<>(dispatchMapper.getDispatchLike(guideName,groundConnectionNumber));
        return dispatch;
    }

    @Override
    @Transactional()
    public int updatestateById(Integer did, Integer gid, String travelStartTime, String travelEndTime) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin=sdf.parse(travelStartTime);
        Date end=sdf.parse(travelEndTime);
        try {
            List<Date> list=getBetweenDates(begin,end);
            for (Date day:list) {
                String date=sdf.format(day);
                String[] array=date.split("-");
                Guideschedule guideschedule=new Guideschedule();
                guideschedule.setGuideId(gid);
                guideschedule.setArrangetype(2);
                guideschedule.setWhetherDel(0);
                guideschedule.setCreateBy(1);
                guideschedule.setCreateDate(new Date());
                guideschedule.setArrangeyear(array[0]);
                guideschedule.setArrangemonth(array[1]);
                guideschedule.setArrangeday(array[2]);
                guidescheduleMapper.insert(guideschedule);
            }
            dispatchMapper.updateDispatchstate(did);
            return 1;
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取两个日期之间的所有日期（yyyy-MM-dd）
     * @Description TODO
     * @param begin
     * @param end
     * @return
     */
    private List<Date> getBetweenDates(Date begin, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(begin);
        while(begin.getTime()<=end.getTime()){

            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;
    }
}
