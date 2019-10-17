package com.lottery.mylottery.dao.dao1;

import com.lottery.mylottery.dao.entity.db1.TFile;
import java.util.List;

public interface TFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TFile record);

    TFile selectByPrimaryKey(Integer id);

    List<TFile> selectAll();

    int updateByPrimaryKey(TFile record);

}