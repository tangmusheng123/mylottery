package com.lottery.mylottery.dao.dao1;

import com.lottery.mylottery.dao.entity.db1.TAct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TActMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAct record);

    TAct selectByPrimaryKey(Integer id);

    List<TAct> selectAll(@Param("platformType") String platformType);

    int updateByPrimaryKey(TAct record);
}