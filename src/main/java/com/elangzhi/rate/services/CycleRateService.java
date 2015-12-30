package com.elangzhi.rate.services;

import com.elangzhi.rate.model.CycleRate;

import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2015/12/29 0029.
 */
public interface CycleRateService extends BaseService<CycleRate> {

    /**
     * 保存批量上传的数据
     * @param rates
     * @param times
     * @param appId
     */
    void saveAll(String rates,String times,String appId);

    /**
     * 分时间段获取用户数据
     * @param appId
     * @param begin
     * @param end
     * @return
     */
    List<CycleRate> list(String appId,Date begin,Date end);

    /**
     * 根据之间戳获取数据 有数据代表重复
     * @param time
     * @return
     */
    CycleRate findByDate(Long time);
}
