package com.dream.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author huzejun
 * @Date 2025-10-17 17:24
 **/
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common() {
        System.out.println("----------FlowLimitService come in");
    }
}
