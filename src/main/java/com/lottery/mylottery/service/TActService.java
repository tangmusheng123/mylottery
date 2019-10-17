package com.lottery.mylottery.service;

import com.lottery.mylottery.dao.entity.db1.TAct;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

public interface TActService {
    /*关于更新缓存@Cacheable 的key 要和 @CachePut 的key 一致，否则会报类型转换异常*/

    @Cacheable(value = "SystemCache", key = "#platformType")
    List<TAct> getActInfo(String platformType);

    @CachePut(value = "SystemCache", key = "#record.platformType")
    List<TAct> updateByPrimaryKey(TAct record);
}
