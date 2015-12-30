package com.elangzhi.rate.dao;

import com.elangzhi.rate.model.CycleRate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CycleRateMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(CycleRate record);

    Long insertSelective(CycleRate record);

    CycleRate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CycleRate record);

    int updateByPrimaryKey(CycleRate record);

    List<CycleRate> findByTime(@Param("appId") String appId,
                               @Param("begin") Date begin,
                               @Param("end") Date end);

    List<CycleRate> findByDate(@Param("time") String time);


}