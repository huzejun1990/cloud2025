package com.dream.cloud.service;

import com.dream.cloud.entities.Pay;

import java.util.List;

/**
 * @Author huzejun
 * @Date 2025-09-21 20:28
 **/
public interface PayService {

    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
