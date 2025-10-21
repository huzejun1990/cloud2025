package com.dream.cloud.service.impl;

import com.dream.cloud.mapper.StorageMapper;
import com.dream.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author huzejun
 * @Date 2025-10-21 17:20
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
