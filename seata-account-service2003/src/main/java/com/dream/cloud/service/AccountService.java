package com.dream.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author huzejun
 * @Date 2025-10-21 17:44
 **/
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId,@Param("money") Long money);
}
