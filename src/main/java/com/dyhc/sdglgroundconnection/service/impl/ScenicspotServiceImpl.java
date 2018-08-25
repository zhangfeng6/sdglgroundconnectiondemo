package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ScenicspotMapper;
import com.dyhc.sdglgroundconnection.mapper.ShoppingMapper;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.pojo.Shopping;
import com.dyhc.sdglgroundconnection.service.ScenicspotService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点业务实现
 **/
@Service
public class ScenicspotServiceImpl implements ScenicspotService {

    @Autowired
    private ScenicspotMapper scenicspotMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public PageInfo<Scenicspot> listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer whetherDel, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Scenicspot> list1=scenicspotMapper.listScenicspots(typeId,scenicSpotName,scenicSpotAddress,whetherDel);
        for (Scenicspot s:list1) {
            List<Shopping> list2=shoppingMapper.listShoppingByScenicSpotId(s.getScenicSpotId());
            s.setShoppings(list2);
        }
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    @Override
    public PageInfo<Scenicspot> getScenicspotByParentId(Integer parentId) throws Exception{
        List<Scenicspot> list1=scenicspotMapper.getScenicspotByParentId(parentId);
        PageInfo<Scenicspot> pageInfo=new PageInfo<Scenicspot>(scenicspotMapper.getScenicspotByParentId(parentId));
        return pageInfo;
    }

    @Override
    public Integer insertScenicspot(Scenicspot scenicspot)throws Exception {

        return scenicspotMapper.insertSelective(scenicspot);
    }

    @Override
    public Scenicspot getScenicspotById(Integer scenicSpotId) {
        return scenicspotMapper.selectByPrimaryKey(scenicSpotId);
    }

    @Override
    public Integer updateScenicspot(Scenicspot scenicspot) throws Exception {
        try {
            scenicspotMapper.updateScenicspot(scenicspot);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Integer deleteScenicspotById(Integer scenicSpotId) {
        try {
            scenicspotMapper.deleteScenicspotById(scenicSpotId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有景点信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Scenicspot> listScenicspotAll() throws Exception {
        return scenicspotMapper.selectAll();
    }

    @Override
    public Scenicspot selectByScenicSpotId(Integer scenicSpotId) {
        return scenicspotMapper.selectByScenicSpotId(scenicSpotId);
    }


}
