package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TravelMapper;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.service.TravelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社业务实现
 **/
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public List<Travel> selectTravel() {
        return travelMapper.selectAll();
    }

    @Override
    public Travel selectTravelById(Integer travelId) {
        return travelMapper.selectTravelById(travelId);
    }
<<<<<<< HEAD

=======
>>>>>>> origin/master
    /**
     * 添加信息
     * @param travel
     * @return
     */
    @Override
    public Integer getAddTravel(Travel travel) {
        System.out.println(travel);
        return travelMapper.insert(travel);
    }
    /**
     * 修改信息
     * @param travel
     * @return
     */
    @Override
    public Integer getTravelUpd(Travel travel) {
        System.out.println(travel);
        return travelMapper.updateByPrimaryKey(travel);
    }

    /**
     * 按条件模糊分页
     * @param pageNo
     * @param PageSize
     * @param travelName
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Travel> listTravelLike(Integer pageNo, Integer PageSize, String travelName) throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<Travel> travel1=new PageInfo<>(travelMapper.listTravelLike(travelName));
        return travel1;
    }

    /**
     * 按条件查看修改
     * @param travelId
     * @return
     * @throws Exception
     */
    @Override
    public Integer getselectById(Integer travelId) throws Exception {
        return null;
    }

    /**
     * 删除    修改
     * @param travelId
     * @return
     */
    @Override
    public Integer getUpdTrave(Integer travelId) {
        return travelMapper.getUpdTrave(travelId);
    }

    /**
     * 修改   查看
     * @param travelId
     * @return
     */
    @Override
    public Travel getupdBytravelId(Integer travelId) {
        return travelMapper.getupdBytravelId(travelId);
    }

    /**
     * 修改 第二次
     * @return
     */
    @Override
    public Integer getupdlala(Travel travel) {
        return travelMapper.getupdlala(travel);
    }
}
