package com.lottery.mylottery.dao.dao1;

import com.lottery.mylottery.dao.entity.db1.TPrize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPrizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPrize record);

    TPrize selectByPrimaryKey(Integer id);

    List<TPrize> selectAll();

    int updateByPrimaryKey(TPrize record);
    /*业务开始*/
    List<TPrize> findByObject(@Param("target") String target,@Param("platformType") String platformType);

    Integer receivePrize(TPrize tPrize);
    List<TPrize> selectByPrimaryIds(TPrize tPrize);
}