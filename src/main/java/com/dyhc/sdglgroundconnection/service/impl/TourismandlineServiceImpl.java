package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TemplateScenicspotMapper;
import com.dyhc.sdglgroundconnection.mapper.TourismandlineMapper;
import com.dyhc.sdglgroundconnection.service.TourismandlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourismandlineServiceImpl implements TourismandlineService {
    @Autowired
    private TourismandlineMapper tourismandlineMapper;
}
