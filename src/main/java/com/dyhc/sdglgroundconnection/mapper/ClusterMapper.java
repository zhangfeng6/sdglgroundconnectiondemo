package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Cluster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ClusterMapper  extends CommonMapper<Cluster>{
    /**
     * 查看接团信息
     * @param dispatchId
     * @return
     */
    Cluster ClusterById(Integer dispatchId);
}
