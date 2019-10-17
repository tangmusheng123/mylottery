package com.lottery.mylottery.service;

import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.dao.entity.db1.TFile;
import com.lottery.mylottery.dao.entity.db1.TPrize;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TFileService {

    /**通过username查找用户信息;*/
    //List<TPrize> findByObject(String target);

    BaseResponse uploadFile(MultipartFile file,HttpServletRequest request);

}
