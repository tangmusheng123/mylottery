package com.lottery.mylottery.controller;


import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.service.TFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "文件上传相关接口", description = "提供文件相关的 Rest API")
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TFileService tFileService;


    @ApiOperation(value = "文件上传")
    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public BaseResponse uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        tFileService.uploadFile(file,request);
        return BaseResponse.success("文件上传成功");
    }
}
