package com.lottery.mylottery.common;


import com.lottery.mylottery.util.IPUtil;

public class OSSClientConstants {
    //阿里云API的外网域名
    public static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    //阿里云API的密钥Access Key ID
    public static final String ACCESS_KEY_ID = IPUtil.getIpReal() ? "LTAINcmV8av7ao2A":"LTAIvZRrSH0xRwa0";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = IPUtil.getIpReal() ? "mZ9xr8Sw3YZ3N2J2YBYn7ghYTGfdf7":"30BEs5dt5AiRKBVgTCrVn1XIxZd87N";
    //阿里云API的bucket名称
    public static final String BACKET_NAME = IPUtil.getIpReal() ? "baho-pms":"baho";
    public static final String BACKET_GOOSDNAME = IPUtil.getIpReal() ? "baho-pms-goods":"baho-goods";
    //阿里云API的文件夹名称
    public static final String FOLDER="user/";
    public static String USER_ID = IPUtil.getIpReal() ? "zhengshi": "ceshi";
    public static final String FOLDER_VIDEO="video/";
}
