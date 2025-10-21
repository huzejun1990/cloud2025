package com.dream.cloud.apis;

import com.dream.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author huzejun
 * @Date 2025-10-20 21:43
 **/
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {

    //扣减账户余额
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
