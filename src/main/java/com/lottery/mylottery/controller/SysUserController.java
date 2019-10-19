package com.lottery.mylottery.controller;

import com.lottery.mylottery.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "系统管理相关接口", description = "提供用户相关的 Rest API")
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @ApiOperation(value = "swagger")
    @RequestMapping(value = "/swagger")
    @ResponseBody
    public BaseResponse swagger(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (Exception e) {
            LOGGER.error("登陆异常："+e.getMessage());
        }
        return BaseResponse.success("操作成功");
    }

}
