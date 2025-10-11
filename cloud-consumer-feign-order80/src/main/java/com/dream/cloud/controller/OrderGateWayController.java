package com.dream.cloud.controller;

import com.dream.cloud.apis.PayFeignApi;
import com.dream.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-10-11 12:14
 **/
@RestController
public class OrderGateWayController {

    @Resource
    private PayFeignApi feignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id) {
        return feignApi.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return feignApi.getGatewayInfo();
    }


}
