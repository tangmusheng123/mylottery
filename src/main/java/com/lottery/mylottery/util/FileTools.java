package com.lottery.mylottery.util;

import com.lottery.mylottery.common.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTools {

    private static final Logger logger = LoggerFactory.getLogger(FileTools.class);

    public static final Integer maxSize = 100;//文件最大上传限制100M


    /**
     *@Description 验证文件是否存在、大小、类型
     *@Author  guosh
     *@Date  2019-06-26 上午 10:30
     */
    public static BaseResponse validFile(MultipartFile file) {
        if(file==null){
            return BaseResponse.error("文件不能为空");
        }
        if(file.getSize() > 1024 * 1024 * maxSize){
            return BaseResponse.error("文件容量最大不能超过"+maxSize+"M");
        }
        //获取原始文件名
        String filename = file.getOriginalFilename();
        String contentType = FileTools.getContentType(filename);
        String fileType="jpeg;jpg;png;gif;pdf;txt;ppt;pptx;doc;docx;mp4;xlsx;xls;rar;zip;rp;bmp;html;vsd;xml;";
        if(StringUtils.isEmpty(contentType)){
            return BaseResponse.error("不支持此文件类型！支持文件类型格式如："+fileType);
        }
        //String path = file.getAbsolutePath()+file.separator+file.getName();
        return BaseResponse.success("");
    }

    /*判断是不是目录*/
    public static boolean isDir(String path) {
        File dirFile = new File(path);
        //判断上传文件的保存目录是否存在
        if (!dirFile.exists() && !dirFile.isDirectory()) {
            logger.info(path+"目录不存在，需要创建");
            return false;
            //dirFile.mkdir();//创建目录
        }
        return true;
    }

    /**
     * 检测文件大小
     *
     * @param file 文件
     * @param kb 限制大小
     * @return true 超过限制
     */
    public static boolean checkFileSize(File file, int kb) {
        long size = (file.length())/1024;//单位：KB
        if (size > 1024 * kb) {
            return true;
        }
        return false;
    }
    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName
     *            文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String fileType="jpeg;jpg;png;gif;pdf;txt;ppt;pptx;doc;docx;mp4;xlsx;xls;rar;zip;rp;bmp;html;vsd;xml;";
        if (fileType.toLowerCase().contains(fileExtension.toLowerCase())) {
            return "text/txt";
        }
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || ".pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || ".docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        if (".xlsx".equalsIgnoreCase(fileExtension) || ".xls".equalsIgnoreCase(fileExtension)) {
            return "text/xls";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".rar".equalsIgnoreCase(fileExtension) || ".zip".equalsIgnoreCase(fileExtension)) {
            return "text/rar";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/txt";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".pdf".equalsIgnoreCase(fileExtension)) {
            return "text/pdf";
        }
        if (".rp".equalsIgnoreCase(fileExtension)) {
            return "text/rp";
        }
        return null;
    }

    /**
     *@Description 文件后缀是不是图片格式
     *@Author  guosh
     *@Date  2018/11/26 0026 下午 12:00
     */
    public static boolean fileIsPicture(String fileName){
        boolean file = false;
        if(StringUtils.isNotBlank(fileName)){
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
                file = true;
            }
        }
        return file;
    }

    /**
     *@Description 支持可以预览的文件格式
     *@Author  guosh
     *@Date  2019-06-21 下午 4:17
     */
    public static boolean fileType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return true;
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return true;
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return true;
        }
        return false;
    }
    /**
     *@Description  文件上传创建文件
     *@Author  guosh
     *@Date  2019-06-21 上午 11:02
     * 根据文件名获取 toPrefix，toSuffix。
     * java 解决文件名重复问题,1.如果文件名不存在，不修改文件名；如果存在在文件名。在文件名后面加数字，1，2，3 。。。
     * 根据 directory，toPrefix，toSuffix 判断文件是否存在，如果存在，toPrefix + ‘(’ + i + ‘)’，直到文件不存在。
     */
    public static File createOrRenameFile(File from){
        String[] fileInfo = getFileInfo(from);
        String toPrefix=fileInfo[0];
        String toSuffix=fileInfo[1];
        File file = createOrRenameFile(from, toPrefix, toSuffix);
        return file;

    }

    /**
     * sdcard/pic/tanyang.jpg
     *
     * toPrefix: tanyang
     * toSuffix: tanyang.jpg
     * @param from
     * @param toPrefix
     * @param toSuffix
     * @return
     */
    public static File createOrRenameFile(File from, String toPrefix, String toSuffix) {
        File directory = from.getParentFile();
        if (!directory.exists()) {
            if (directory.mkdir()) {
                logger.info("create dir " + directory.getAbsolutePath());
            }
        }
        File newFile = new File(directory, toPrefix + toSuffix);
        for (int i = 1; newFile.exists() && i < Integer.MAX_VALUE; i++) {
            newFile = new File(directory, toPrefix + '(' + i + ')' + toSuffix);
        }
        if (from.getName().equals(newFile.getName())) {
            return from;
        }
        return newFile;
    }

    /**
     *
     * @param from
     * fileInfo[0]: toPrefix;
     * fileInfo[1]:toSuffix;
     * @return
     */
    public static String[] getFileInfo(File from){
        String fileName=from.getName();
        int index = fileName.lastIndexOf(".");
        String toPrefix="";
        String toSuffix="";
        if(index==-1){
            toPrefix=fileName;
        }else{
            toPrefix=fileName.substring(0,index);
            toSuffix=fileName.substring(index,fileName.length());
        }
        return new String[]{toPrefix,toSuffix};
    }

    /**
     *@Description 过滤特殊字符
     *@Author  guosh
     *@Date  2019/1/5 0005 下午 12:02
     */
    public static String StringFilter(String str){
        // 清除掉所有特殊字符
        String prefix = str.substring(0,str.lastIndexOf("."));
        String sufffix = str.substring(str.lastIndexOf("."),str.length());
        String regEx="[`~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、   ？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(prefix.replaceAll(" ", ""));
        return   m.replaceAll("").trim()+sufffix;
    }
}
