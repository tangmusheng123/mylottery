package com.lottery.mylottery.service.impl;


import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.common.DictConstant;
import com.lottery.mylottery.dao.dao1.TPrizeMapper;
import com.lottery.mylottery.dao.dao2.TSdTbsobillMapper;
import com.lottery.mylottery.dao.entity.db1.TPrize;
import com.lottery.mylottery.dao.entity.db2.TSdTbsobill;
import com.lottery.mylottery.service.TPrizeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TPrizeServiceImpl implements TPrizeService {

    @Autowired
    TPrizeMapper tPrizeMapper;
    @Autowired
    TSdTbsobillMapper tSdTbsobillMapper;

    @Override
    public BaseResponse findByObject(String target,String platformType) {
        List<TPrize> list = tPrizeMapper.findByObject(target,platformType);
        if(list!=null && list.size()>0){
            for (TPrize tPrize : list) {
                TSdTbsobill tSdTbsobill = new TSdTbsobill();
                String billNum = tPrize.getBillNum();
                if(StringUtils.isNotBlank(billNum)){
                    tSdTbsobill = tSdTbsobillMapper.selectByTradeNum(billNum);
                    if(tSdTbsobill!=null){
                        String fstatus=tSdTbsobill.getFstatus();
                        tPrize.setBillNumStatus(DictConstant.tradeNumStatus.getByValue(fstatus));
                    }
                }
            }
        }
        return BaseResponse.success(list);
    }

    @Override
    public BaseResponse receivePrize(TPrize record){
        List<TPrize> unCount = tPrizeMapper.selectByPrimaryIds(record);
        if(unCount==null || unCount.size()==0){
            return BaseResponse.error("您的奖品已经领取过了");
        }
        //验证当前交易订单状态是否为“TRADE_FINISHED”,交易成功
        for (TPrize tPrize : unCount) {
            String billNum = tPrize.getBillNum();
            TSdTbsobill tSdTbsobill = tSdTbsobillMapper.selectByTradeNum(billNum);
            String fstatus=tSdTbsobill.getFstatus();
            if(tSdTbsobill==null || StringUtils.isBlank(fstatus) ){
                return BaseResponse.error("查无此订单");
            }else if(!"TRADE_FINISHED".equalsIgnoreCase(fstatus)){
                return BaseResponse.error("非交易成功状态不能领取,交易单号:"+billNum,DictConstant.tradeNumStatus.getByValue(fstatus));
            }
        }
        Integer receiveCount = tPrizeMapper.receivePrize(record);
        if(receiveCount!=null && receiveCount>0){
            return BaseResponse.success("成功领取"+receiveCount.toString()+"个奖品");
        }else{
            return BaseResponse.error("领取失败");
        }
    }

}
