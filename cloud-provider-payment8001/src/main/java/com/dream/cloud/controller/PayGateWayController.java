package com.dream.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.dream.cloud.entities.Pay;
import com.dream.cloud.resp.ResultData;
import com.dream.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-10-11 11:13
 **/
@RestController
public class PayGateWayController {

    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test: "+ IdUtil.simpleUUID());
    }

}
