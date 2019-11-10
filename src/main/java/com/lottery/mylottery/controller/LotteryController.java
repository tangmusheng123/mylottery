package com.lottery.mylottery.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.dao.entity.db1.TAct;
import com.lottery.mylottery.dao.entity.db1.TPrize;
import com.lottery.mylottery.service.TActService;
import com.lottery.mylottery.service.TPrizeService;
import com.lottery.mylottery.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Api(tags = "中奖查询相关接口", description = "提供中奖相关的 Rest API")
@RestController
@RequestMapping(value = "/lottery")
public class LotteryController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TPrizeService tPrizeService;
    @Autowired
    TActService tActService;

    @ApiOperation(value = "根据订单号和昵称查询是否中奖")
    @ResponseBody
    @RequestMapping(value = "/queryByObject")
    public BaseResponse queryByObject(@RequestParam(required = false) String target,@RequestParam(required = false) String platformType) {
        if(StringUtils.isBlank(target)){
            return BaseResponse.error("参数不能为空");
        }
        BaseResponse obj = tPrizeService.findByObject(target,platformType);
        return obj;
    }

    @ApiOperation(value = "领取奖品")
    @ResponseBody
    @RequestMapping(value = "/receivePrize")
    public BaseResponse receivePrize(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        JSONArray record = jsonParam.getJSONArray("idList");
        if(jsonParam==null || record==null || record.size()==0){
            return BaseResponse.error("参数不能为空");
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < record.size(); i++) {
            JSONObject jsonObject = record.getJSONObject(i);
            list.add(jsonObject.getInteger("id"));
        }
        String dd = request.getHeader("user-agent");
        String ipAddress = StringUtil.getIpAddr(request);
        String deviceInfo = "【"+dd+"】,【"+ipAddress+"】";
        TPrize tPrize = new TPrize();
        tPrize.setDeviceInfo(deviceInfo);
        tPrize.setReceiveDt(new Date());
        tPrize.setPrizeStatus(1);
        tPrize.setIdList(list);
        BaseResponse response = tPrizeService.receivePrize(tPrize);
        return response;
    }

    @ApiOperation(value = "查询活动内容")
    @ResponseBody
    @RequestMapping(value = "/getActInfo")
    public BaseResponse getActInfo(@RequestParam(value="platformType",required = false) String platformType) {
        if(StringUtils.isBlank(platformType)){
            return BaseResponse.error("参数不能为空");
        }
        List<TAct> obj = tActService.getActInfo(platformType);
        return BaseResponse.success(obj);
    }

    @ApiOperation(value = "更新活动内容")
    @ResponseBody
    @RequestMapping(value = "/updateActInfo")
    public BaseResponse updateActInfo(TAct record) {
        if(record==null || record.getId()==null || StringUtils.isBlank(record.getPlatformType())){
            return BaseResponse.error("参数不能为空");
        }
        List<TAct> in=tActService.updateByPrimaryKey(record);
        return BaseResponse.success(in);
    }


}
