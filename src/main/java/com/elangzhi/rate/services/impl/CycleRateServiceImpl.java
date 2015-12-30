package com.elangzhi.rate.services.impl;

import com.elangzhi.rate.dao.CycleRateMapper;
import com.elangzhi.rate.model.CycleRate;
import com.elangzhi.rate.services.CycleRateService;
import com.elangzhi.rate.tools.UUIDFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2015/12/29 0029.
 */
@Service("cycleRateService")
public class CycleRateServiceImpl implements CycleRateService{

    @Resource
    private CycleRateMapper cycleRateMapper;


    public Long insertSelective(CycleRate cycleRate) {
        cycleRate.setId(UUIDFactory.getLongId());
        return cycleRateMapper.insertSelective(cycleRate);
    }


    public Integer deleteByPrimaryKey(Long id) {
        return null;
    }


    public CycleRate selectByPrimaryKey(Long id) {
        return cycleRateMapper.selectByPrimaryKey(id);
    }


    public Integer updateByPrimaryKeySelective(CycleRate cycleRate) {
        return null;
    }


    @Override
    public void saveAll(String rate, String time, String appId) {
        String[] rates = rate.split(",");
        String[] times = time.split(",");
        if(rates.length >= 1 && rates.length == times.length){
            for(int i = 0 ; i < rates.length;i++){
                CycleRate cr = new CycleRate(times[i],rates[i],appId);
                cr.setId(UUIDFactory.getLongId());
                cycleRateMapper.insertSelective(cr);
            }
        }
    }

    @Override
    public List<CycleRate> list(String appId, Date begin, Date end) {

        return cycleRateMapper.findByTime(appId,begin,end);
    }

    @Override
    public CycleRate findByDate(Long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<CycleRate> list = cycleRateMapper.findByDate(simpleDateFormat.format(date));
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

}
