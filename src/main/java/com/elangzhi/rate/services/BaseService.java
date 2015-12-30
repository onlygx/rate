package com.elangzhi.rate.services;

/**
 * Created by GaoXiang on 2015/9/29 0029.
 */
public interface BaseService<T> {

    public Long insertSelective(T t);

    public Integer deleteByPrimaryKey(Long id);

    public T selectByPrimaryKey(Long id);

    public Integer updateByPrimaryKeySelective(T t);


}
