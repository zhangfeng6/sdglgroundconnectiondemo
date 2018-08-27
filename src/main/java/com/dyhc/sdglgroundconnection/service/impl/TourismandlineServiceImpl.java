package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TemplateScenicspotMapper;
import com.dyhc.sdglgroundconnection.mapper.TourismandlineMapper;
import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
<<<<<<< HEAD
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TourismandlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======


import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;

import com.dyhc.sdglgroundconnection.service.TourismandlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

>>>>>>> origin/master

@Service
public class TourismandlineServiceImpl implements TourismandlineService {
    @Autowired
    private TourismandlineMapper tourismandlineMapper;

<<<<<<< HEAD

=======
>>>>>>> origin/master
    @Override
    public List<Tourismandline> selectTourismandlineAll(int tourismId) {
        return tourismandlineMapper.selectTourismandlineAll(tourismId);
    }
<<<<<<< HEAD
=======

>>>>>>> origin/master
}
