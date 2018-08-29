package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度
 **/
@Mapper
@Component
public interface DispatchMapper extends CommonMapper<Dispatch>{

    /**
     * 根据条件获取调度信息
     * @param djsth        地接社团号
     * @param dyname       导游名称
     * @param state         状态
     * @return
     */
    List<Dispatch> listdispatch(@Param("djsth")String djsth,@Param("dyname")String dyname,@Param("state")Integer state);


    /**
     * 根据导游id查询调度信息     陈庆武
     * @param guideId 导游id
     * @return
     */
    Dispatch getDispatchByguideId(Integer guideId) throws Exception;
    /**
     *查询计调的全部信息：贾晓亮
     * @param dispatchId
     * @return
     */
    Dispatch dispatchSelectAll(Integer dispatchId);
    /*
     * 分页查看调度信息                 刘跃云
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    List<Dispatch> getDispatchLike(@Param("guideName") String guideName, @Param("groundConnectionNumber") String groundConnectionNumber);

    /**
     * 根据主键id修改调度表信息
     * @param did
     * @return
     */
    int updateDispatchstate(@Param("did")Integer did)throws Exception;

    /**
     * 查看车辆联系人
     * @param dispatchId
     * @return
     */
    Dispatch listDispatch(Integer dispatchId);
}
