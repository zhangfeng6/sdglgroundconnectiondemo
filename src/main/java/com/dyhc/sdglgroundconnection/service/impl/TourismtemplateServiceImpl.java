package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TourismtemplateMapper;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourismtemplateServiceImpl  implements TourismtemplateService {
    @Autowired
    private TourismtemplateMapper tourismtemplateMapper;

}
