package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.CarrentalMapper;
import com.dyhc.sdglgroundconnection.mapper.DictionariesMapper;
import com.dyhc.sdglgroundconnection.mapper.VehicleTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Carrental;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.CarrentalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 汽车租赁公司业务实现
 **/
@Service
public class CarrentalServiceImpl implements CarrentalService {

    @Autowired
    private CarrentalMapper carrentalMapper;

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Autowired
    private VehicleTypeMapper VehicleTypeMapper;

    @Override
    public PageInfo<Carrental> listCarRentals(String carRentalName, Integer costprice1, Integer costprice2, Integer passengervolume, Integer pageNo, Integer pageSize) throws  Exception{
        PageHelper.startPage(pageNo, pageSize, true);
        List<Carrental> list1=carrentalMapper.listCarRentals(carRentalName);
        List<VehicleType> list2=VehicleTypeMapper.listVehicleTypes(costprice1,costprice2,passengervolume);

        for (Carrental c:list1) {
            List<VehicleType> a=new ArrayList<VehicleType>();
            for (VehicleType v:list2){
                if (c.getCarRentalId()==v.getCarRentalId()){
                    a.add(v);
                    c.setVehicleTypes(a);
                    Dictionaries dictionaries=dictionariesMapper.getDictionaries(v.getValueId());
                    v.setDictionaries(dictionaries);
                }
            }
        }
        return new PageInfo<>(list1);
    }

    @Override
    public Integer insertCarRental(Carrental carrental)throws Exception {
        try {
            carrentalMapper.insertCarRental(carrental);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Carrental getCarRentalById(Integer carRentalId) throws Exception {
        return carrentalMapper.selectByPrimaryKey(carRentalId);
    }

    @Override
    public Integer updateCarRental(Carrental carrental) throws Exception {
        return carrentalMapper.updateByPrimaryKeySelective(carrental);
    }

    @Override
    public Integer deleteCarRentalBycarRentalId(Integer carRentalId) throws Exception {
        try {
            carrentalMapper.deleteCarRentalBycarRentalId(carRentalId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
