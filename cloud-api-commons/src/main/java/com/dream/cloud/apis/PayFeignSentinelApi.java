package com.dream.cloud.apis;

import com.dream.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author huzejun
 * @Date 2025-10-19 17:57
 **/
@FeignClient(value = "nacos-payment-provider",fallback = PayFeignSentinelApiFallback.class)
public interface PayFeignSentinelApi {

    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
