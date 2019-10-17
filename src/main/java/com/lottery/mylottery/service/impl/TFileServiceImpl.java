package com.lottery.mylottery.service.impl;

import com.lottery.mylottery.api.AliyunOSSClientUtil;
import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.common.OSSClientConstants;
import com.lottery.mylottery.dao.dao1.TFileMapper;
import com.lottery.mylottery.dao.entity.db1.TFile;
import com.lottery.mylottery.service.TFileService;
import com.lottery.mylottery.util.FileTools;
import com.lottery.mylottery.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Service
public class TFileServiceImpl implements TFileService {

    @Autowired
    TFileMapper tFileMapper;

    public BaseResponse uploadFile(MultipartFile multipartFile,HttpServletRequest request){
        //验证文件
        FileTools.validFile(multipartFile);
        //获取原始文件名
        String filename = multipartFile.getOriginalFilename();
        String originalFilename = multipartFile.getOriginalFilename();
        String newFileName = StringUtil.createUUID() + originalFilename.substring(originalFilename.lastIndexOf(".") - 1);
        File file = null;
        try{
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsolutePath(), "static"+File.separator+"upload"+ File.separator);
            if (!upload.exists()){
                upload.mkdirs();
            }
            String uploadPath = upload + File.separator;
            file = new File(uploadPath + newFileName);
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String thePath=file.getAbsolutePath();//完整路径名
        String[] s = AliyunOSSClientUtil.urlpath(OSSClientConstants.USER_ID, thePath,OSSClientConstants.BACKET_NAME);
        String previewUrl = s[2];
        String realUrl = s[1];
        TFile tFile = new TFile();
        tFile.setShowName(filename);
        tFile.setPreviewUrl(previewUrl);
        tFile.setRealUrl(realUrl);
        Integer in = tFileMapper.insert(tFile);
        file.delete();
        return BaseResponse.success(in);
    }
}
