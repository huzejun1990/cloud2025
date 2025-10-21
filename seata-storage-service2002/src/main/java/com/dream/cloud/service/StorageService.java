package com.dream.cloud.service;

/**
 * @Author huzejun
 * @Date 2025-10-21 17:19
 **/
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
