package com.dream.cloud.apis;

import com.dream.cloud.resp.ResultData;
import com.dream.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Author huzejun
 * @Date 2025-10-19 18:02
 **/
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi {

    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级/(ㄒoㄒ)/~~" );
    }
}
