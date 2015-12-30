package com.elangzhi.rate.model;

import java.sql.Time;
import java.util.Date;

public class CycleRate {
    private Long id;

    private Date time;

    private Integer rate;

    private String appId;

    public CycleRate(){}

    public CycleRate(String time,String rate,String appId){
        this.time = new Date(Long.parseLong(time));
        this.rate = Integer.parseInt(rate);
        this.appId = appId;
    }

    public CycleRate(Long time,Integer rate,String appId){
        this.time = new Date(time);
        this.rate = rate;
        this.appId = appId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}