package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DisattrMapper;
import com.dyhc.sdglgroundconnection.pojo.Disattr;
import com.dyhc.sdglgroundconnection.service.DisattrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度景点业务实现
 **/
@Service
public class DisattrServiceImpl implements DisattrService {

    @Autowired
    private DisattrMapper disattrMapper;

    @Autowired
    private  ScenicspotServiceImpl scenicspotService;
    @Autowired
    private  DispatchServiceImpl dispatchService;//调度表

    /**
     * 查询调度景点信息
     * @param offerId
     * @return
     */
    @Override
    public List<Disattr> disattr(Integer offerId)throws Exception {
        List<Disattr> d=disattrMapper.disattr(offerId);
        for (Disattr s:d) {
            s.setScenicspot(scenicspotService.ShowScenicSpotId(s.getScenicSpotId()));
            s.setDispatch(dispatchService.dispatchSelectAll(s.getOfferId()));
        }
        return d;
    }
}
