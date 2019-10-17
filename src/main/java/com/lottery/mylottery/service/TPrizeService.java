package com.lottery.mylottery.service;

import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.dao.entity.db1.TPrize;

import java.util.List;

public interface TPrizeService {


    /**通过username查找用户信息;*/
    BaseResponse findByObject(String target,String platformType);

    BaseResponse receivePrize(TPrize record);


}
