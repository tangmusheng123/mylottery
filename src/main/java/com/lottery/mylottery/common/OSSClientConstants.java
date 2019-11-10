package com.lottery.mylottery.common;


import com.lottery.mylottery.util.IPUtil;

public class OSSClientConstants {
    //阿里云API的外网域名
    public static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    //阿里云API的密钥Access Key ID
    public static final String ACCESS_KEY_ID = "你的ACCESS_KEY_ID";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "你的ACCESS_KEY_SECRET";
    //阿里云API的bucket名称
    public static final String BACKET_NAME = "你的bucket名称";
    public static final String BACKET_GOOSDNAME = "你的bucket2名称";
    //阿里云API的文件夹名称
    public static final String FOLDER="user/";
    public static String USER_ID = IPUtil.getIpReal() ? "zhengshi": "ceshi";
    public static final String FOLDER_VIDEO="video/";
}
