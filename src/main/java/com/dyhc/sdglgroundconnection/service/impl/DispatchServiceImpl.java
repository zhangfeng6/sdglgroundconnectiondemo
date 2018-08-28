package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.*;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.dyhc.sdglgroundconnection.service.ReportdetailService;
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

    @Autowired
    private GuidescheduleMapper guidescheduleMapper;

    @Autowired
    private ReportdetailService reportdetailService;

    //报价用车表对象
    @Autowired
    private OffercarMapper offercarMapper;

    //报价表
    @Autowired
    private OfferMapper offerMapper;
    //报价模板信息表
    @Autowired
    private OfferlineMapper offerlineMapper;
    //报价酒店信息表
    @Autowired
    private OfferHotelMapper offerHotelMapper;
    //报价餐厅信息表
    @Autowired
    private OfferrestaurantMapper offerrestaurantMapper;
    //报价其他表
    @Autowired
    private OfferotherMapper offerotherMapper;
    //报价景点表
    @Autowired
    private OfferscenicMapper offerscenicMapper;
    //车辆类型表
    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;
    //餐厅类型表
    @Autowired
    private MealTypeMapper mealTypeMapper;
    /**
     * 根据报价表id获取该报价的所有信息
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getofferinfoById(Integer oid) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        Offercar offercar=offercarMapper.selectOffercarByOfferId(oid);
        Dictionaries dictionaries=dictionariesMapper.selectByPrimaryKey(offercar.getDictionariesId());
        map.put("car",dictionaries.getValueId());
        map.put("offer",offerMapper.selectOfferByOfferId(oid));
        map.put("line",offerlineMapper.selectOfferlineByOfferId(oid));
        map.put("hotel",offerHotelMapper.selectOfferHotelByOfferId(oid));
        List<Offerrestaurant> offerrestaurant=offerrestaurantMapper.selectOfferRestaurantByOfferId(oid);
        List<Dictionaries> wan = new ArrayList<>();
        List<Dictionaries> wu = new ArrayList<>();
        for (Offerrestaurant offerrestaurant1: offerrestaurant) {
            Integer house = offerrestaurant1.getHavemealsdate();
            Dictionaries dictionaries1=dictionariesMapper.selectByPrimaryKey(offerrestaurant1.getDictionariesId());
            if (house==2){
                wu.add(dictionaries1);
            }
            if (house==3){
                wan.add(dictionaries1);
            }
        }
        map.put("wu",wu);
        map.put("wan",wan);
        map.put("other",offerotherMapper.selectOfferotherByOfferId(oid));
        map.put("scenic",offerscenicMapper.selectOfferscenicByOfferId(oid));
        return map;
    }

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
            list=mealTypeMapper.listinfoByvalueId(valueId);
        }else if(type.equals("cartype")){
            list=vehicleTypeMapper.listinfoByvalueId(valueId);
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

    @Override
    public Dispatch getDispatchById(Integer reportDetailId) throws Exception {
        Reportdetail reportdetail=reportdetailService.getReportdetailById(reportDetailId);
        return dispatchMapper.selectByPrimaryKey(reportdetail.getDispatchId());
    }
}
