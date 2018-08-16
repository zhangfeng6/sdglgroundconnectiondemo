package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ScenicspotMapper;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
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

    @Override
    public PageInfo<Scenicspot> listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer whetherDel, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Scenicspot> list1=scenicspotMapper.listScenicspots(typeId,scenicSpotName,scenicSpotAddress,whetherDel);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    @Override
    public PageInfo<Scenicspot> getScenicspotByParentId(Integer parentId) {
        List<Scenicspot> list1=scenicspotMapper.getScenicspotByParentId(parentId);
        PageInfo<Scenicspot> pageInfo=new PageInfo<Scenicspot>(scenicspotMapper.getScenicspotByParentId(parentId));
        return pageInfo;
    }
}
