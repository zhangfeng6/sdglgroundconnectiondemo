package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OfferlineMapper;
import com.dyhc.sdglgroundconnection.pojo.Offer;
import com.dyhc.sdglgroundconnection.pojo.Offerline;
import com.dyhc.sdglgroundconnection.service.OfferlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价线路信息记录业务实现
 **/
@Service
public class OfferlineServiceImpl implements OfferlineService {

    @Autowired
    private OfferlineMapper offerlineMapper;

    /**
     * 赵伟伟
     * 查询线路
     * @return
     */
    @Override
    public List<Offerline> selectOfferline() {
        return offerlineMapper.selectAll();
    }

    /**
     * 赵伟伟
     * 查询线路
     * @param offerLineRecordId
     * @return
     */
    @Override
    public Offerline selectByofferLineRecordId(Integer offerLineRecordId) {
        return offerlineMapper.selectByofferLineRecordId(offerLineRecordId);
    }

    @Override
    public int insertOfferline(Offerline offerline) {
        return offerlineMapper.insertOfferline(offerline);
    }

    @Override
    public List<Offerline> selectOfferlineByOfferId(int offerId) {
        return offerlineMapper.selectOfferlineByOfferId(offerId);
    }
}
