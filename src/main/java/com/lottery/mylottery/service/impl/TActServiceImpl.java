package com.lottery.mylottery.service.impl;

import com.lottery.mylottery.dao.dao1.TActMapper;
import com.lottery.mylottery.dao.entity.db1.TAct;
import com.lottery.mylottery.service.TActService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TActServiceImpl implements TActService {

    @Autowired
    TActMapper tActMapper;

    public List<TAct> getActInfo(String platformType){
        if(StringUtils.isBlank(platformType)){
            platformType="kub";
        }
        List<TAct> act = tActMapper.selectAll(platformType);
        return act;
    }

    public List<TAct> updateByPrimaryKey(TAct record){
         tActMapper.updateByPrimaryKey(record);
        return this.getActInfo(record.getPlatformType());
    }
}
