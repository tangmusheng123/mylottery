
package com.lottery.mylottery.api;

import com.alibaba.druid.util.StringUtils;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.lottery.mylottery.common.OSSClientConstants;
import com.lottery.mylottery.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 阿里云OSS上传文件模块
 * @Author guosh
 * @Date 2018/11/8 0008 下午 3:23
 */
public class AliyunOSSClientUtil {
    // log日志
    private static Logger logger = LoggerFactory.getLogger(AliyunOSSClientUtil.class);
    // 阿里云API的内或外网域名
    private static String ENDPOINT = OSSClientConstants.ENDPOINT;
    // 阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID = OSSClientConstants.ACCESS_KEY_ID;
    // 阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET = OSSClientConstants.ACCESS_KEY_SECRET;
    // 阿里云API的bucket名称
    //public static String BACKET_NAME = OSSClientConstants.BACKET_NAME;
    // 阿里云API的文件夹名称
    private static String FOLDER = OSSClientConstants.FOLDER;
    public static String FORMAT = new SimpleDateFormat(DateUtil.SHOW_FORMAT_DATE3).format(new Date());//文件夹名称
    public static String YYMMDD = new SimpleDateFormat(DateUtil.SHOW_FORMAT_DATE).format(new Date());//文件夹名称
    public static String FORMATS = new SimpleDateFormat(DateUtil.SHOW_FORMAT_DATE10).format(new Date());//文件名
    private static String FOLDER_VIDEO = OSSClientConstants.FOLDER_VIDEO;

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    public static OSSClient getOSSClient() {
        return new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    /**
     * 创建存储空间
     *
     * @param ossClient  OSS连接
     * @param bucketName 存储空间
     * @return
     */
    public static String createBucketName(OSSClient ossClient, String bucketName) {
        // 存储空间
        final String bucketNames = bucketName;
        if (!ossClient.doesBucketExist(bucketName)) {
            // 创建存储空间
            Bucket bucket = ossClient.createBucket(bucketName);
            logger.info("创建存储空间成功");
            return bucket.getName();
        }
        return bucketNames;
    }

    /**
     * 删除存储空间buckName
     *
     * @param ossClient  oss对象
     * @param bucketName 存储空间
     */
    public static void deleteBucket(OSSClient ossClient, String bucketName) {
        ossClient.deleteBucket(bucketName);
        logger.info("删除" + bucketName + "Bucket成功");
    }

    /**
     * 创建模拟文件夹
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名如"qj_nanjing/"
     * @return 文件夹名
     */
    public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
            // 创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            return fileDir;
        }
        return keySuffixWithSlash;
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @param key        Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
     */
    public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
        logger.info("删除" + bucketName + "下的文件" + folder + key + "成功");
    }

    /**
     * 上传图片至OSS 文件流
     *
     * @param ossClient  oss连接
     * @param file       上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName 存储空间
     * @param user_id    模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public static String[] uploadObject2OSS(OSSClient ossClient, File file, String bucketName, String user_id) {
        String resultStr = null;
        String[] fo = new String[]{"", "", ""};
        try {
            // 以输入流的形式上传文件
            String folder = "";
            folder = FOLDER + user_id + "/" + FORMAT + "/" + YYMMDD + "/";
            InputStream is = new FileInputStream(file);
            // 文件名
            String timefile = new SimpleDateFormat(DateUtil.SHOW_FORMAT_DATE10).format(new Date());
            String fileName = file.getName();
            fileName = timefile + fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传到阿里云的路径" + folder + fileName);
            // 文件大小
            Long fileSize = file.length();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = folder + fileName;
            fo[0] = resultStr;
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return fo;
    }

    //上传路径返回地址，图片视频都可以
    //需要改变上传那文件位置FOLDER
    public static String[] uploadObjectOSS(OSSClient ossClient, String file, String bucketName, String user_id) {
        String resultStr = null;
        String[] fo = new String[]{"", ""};
        try {
            // 以输入流的形式上传文件
            String folder = "";
            folder = FOLDER + user_id + "/" + FORMAT + "/";
//            InputStream is = new FileInputStream(file);
            // 文件名
            String timefile = FORMATS;
//            String fileName = file.getName();
            file = timefile + file.substring(file.lastIndexOf("."));
            logger.info("上传到路径" + folder + file);
            // 文件大小
            Integer fileSize = file.length();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
//            // 上传的文件的长度
//            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(file));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + file + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + file, new ByteArrayInputStream(file.getBytes("UTF-8")), metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = folder + file;
            fo[0] = resultStr;

            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return fo;
    }


    //上传视频
    public static String uploadByteVideoOSS(OSSClient ossClient, byte[] b, String bucketName, String user_id) {

        // byte[] content = "Hello OSS".getBytes();

        // 以输入流的形式上传文件
        String folder = "";
        folder = FOLDER_VIDEO + user_id + "/" + FORMAT + "/";
        // 文件名
        String timefile = FORMATS;// 文件名
        String fileName = ".MP4";// 后缀扩展名
        fileName = timefile + fileName;
        logger.info("上传到路径" + folder + fileName);

        Long fileSize = (long) b.length;

        // 创建上传Object的Metadata
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileSize);
        // 指定该Object被下载时的网页的缓存行为
        metadata.setCacheControl("no-cache");
        // 指定该Object下设置Header
        metadata.setHeader("Pragma", "no-cache");
        // 指定该Object被下载时的内容编码格式
        metadata.setContentEncoding("utf-8");
        // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
        // 如果没有扩展名则填默认值application/octet-stream
        metadata.setContentType(getContentType(fileName));
        // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
        metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");

        PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, new ByteArrayInputStream(b),
                metadata);
        ossClient.shutdown();
        String filepath = folder + fileName;
        return filepath;
    }

    //上传图片
    public static String uploadByteOSS(OSSClient ossClient, byte[] b, String bucketName, String user_id) {

        // byte[] content = "Hello OSS".getBytes();

        // 以输入流的形式上传文件
        String folder = "";
        folder = FOLDER + user_id + "/" + FORMAT + "/";
        // 文件名
        String timefile = FORMATS;// 文件名
        String fileName = ".jpg";// 后缀扩展名
        fileName = timefile + fileName;
        logger.info("上传到路径" + folder + fileName);

        Long fileSize = (long) b.length;
//        String timefile = FORMATS;
////        String fileName = file.getName();
//        file = timefile + file.substring(file.lastIndexOf("."));
        // 创建上传Object的Metadata
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileSize);
        // 指定该Object被下载时的网页的缓存行为
        metadata.setCacheControl("no-cache");
        // 指定该Object下设置Header
        metadata.setHeader("Pragma", "no-cache");
        // 指定该Object被下载时的内容编码格式
        metadata.setContentEncoding("utf-8");
        // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
        // 如果没有扩展名则填默认值application/octet-stream
        metadata.setContentType(getContentType(fileName));
        // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
        metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");

        PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, new ByteArrayInputStream(b),
                metadata);
        ossClient.shutdown();
        String filepath = folder + fileName;
        return filepath;
    }

    public static byte[] image2Bytes(String imgSrc) throws Exception {
        FileInputStream fin = new FileInputStream(new File(imgSrc));
        // 可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
        byte[] bytes = new byte[fin.available()];
        // 将文件内容写入字节数组，提供测试的case
        fin.read(bytes);

        fin.close();
        return bytes;
    }

    //图片转化为byte数组
    public static byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || ".pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || ".docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        if (".xlsx".equalsIgnoreCase(fileExtension) || ".xls".equalsIgnoreCase(fileExtension)) {
            return "text/xls";
        }
        if (".rar".equalsIgnoreCase(fileExtension) || ".zip".equalsIgnoreCase(fileExtension)) {
            return "text/rar";
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
     * 获得url链接
     *
     * @param fileName
     * @return
     */
    public static String getUrl(OSSClient ossClient, String bucketName, String fileName) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
        if (url != null) {
            return url.toString();
        }
        return "获网址路径出错";
    }

    public static String[] urlpath(String user_id, String files, String bucketName) {
        String endpoint = OSSClientConstants.ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = OSSClientConstants.ACCESS_KEY_ID;
        String accessKeySecret = OSSClientConstants.ACCESS_KEY_SECRET;
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //backetName是否存在
        //backetName = AliyunOSSClientUtil.createBucketName(ossClient, backetName);
        String[] file = files.split(",");
        String s[] = new String[]{"", "", ""};
        for (String filename : file) {
            File filess = new File(filename);
            //oss普通上传
            s = AliyunOSSClientUtil.uploadObject2OSS(ossClient, filess, bucketName, user_id);
            /*//oss断点续传
            String key = FOLDER + user_id + "/" + FORMAT + "/" + YYMMDD + "/";
            key = key+filess.getName().substring(filess.getName().lastIndexOf("."));
            String tag = AliyunOSSClientUtil.multipartUploadObject(bucketName,key,filess);
            s[0]=tag;s[1]=key;*/
            logger.info("上传后的文件MD5数字唯一签名:" + s[0]);
            logger.info("文件路径:" + s[1]);
            String url = AliyunOSSClientUtil.getUrl(ossClient, bucketName, s[1]);
            logger.info("访问网址路径:" + url);
            s[2] = url;
            filess.delete();
        }
        return s;
    }

    public static String uploadFile(String url, String backetName) {
        OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
        //backetName是否存在
        backetName = AliyunOSSClientUtil.createBucketName(ossClient, backetName);
        String user_id = OSSClientConstants.USER_ID;
        String[] urllist = AliyunOSSClientUtil.uploadObject2OSS(ossClient, new File(url), backetName, user_id);
        String c = urllist[1];
        return c;
    }

    /**
     *@Description   java实现oss断点续传
     *@Author  guosh
     *@Date  2019-06-19 下午 3:42
     */
    public static String multipartUploadObject(String bucketName, String key,File partFile) {
        String tag = null;
        String uploadid = null;
        int j = 0;
        // 初始化一个OSSClient
        String endpoint = OSSClientConstants.ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = OSSClientConstants.ACCESS_KEY_ID;
        String accessKeySecret = OSSClientConstants.ACCESS_KEY_SECRET;

        // 创建OSSClient实例。
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ListMultipartUploadsRequest lmur = new ListMultipartUploadsRequest(bucketName);

        // 获取Bucket内所有上传事件
        MultipartUploadListing listing = client.listMultipartUploads(lmur);
        // 新建一个List保存每个分块上传后的ETag和PartNumber
        List<PartETag> partETags = new ArrayList<PartETag>();

        // 遍历所有上传事件  设置UploadId
        for (MultipartUpload multipartUpload : listing.getMultipartUploads()) {
            if (multipartUpload.getKey().equals(key)) {
                uploadid = multipartUpload.getUploadId();
                break;
            }
        }

        if (StringUtils.isEmpty(uploadid)) {
            // 开始Multipart Upload,InitiateMultipartUploadRequest 来指定上传Object的名字和所属Bucke
            InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(bucketName, key);
            InitiateMultipartUploadResult initiateMultipartUploadResult = client.initiateMultipartUpload(initiateMultipartUploadRequest);
            uploadid = initiateMultipartUploadResult.getUploadId();
        } else {
            ListPartsRequest listPartsRequest = new ListPartsRequest(bucketName, key, uploadid);
            //listParts 方法获取某个上传事件所有已上传的块
            PartListing partListing = client.listParts(listPartsRequest);
            // 遍历所有Part
            for (PartSummary part : partListing.getParts()) {
                partETags.add(new PartETag(part.getPartNumber(), part.getETag()));
                j++;
            }
        }
        // 设置每块为 5M（最小支持5M）
        final int partSize = 1024 * 1024 * 5;
        // 计算分块数目
        int partCount = (int) (partFile.length() / partSize);
        if (partFile.length() % partSize != 0) {
            partCount++;
        }
        try {
            for (int i = j; i < partCount; i++) {
                // 获取文件流
                FileInputStream fis = new FileInputStream(partFile);
                // 跳到每个分块的开头
                long skipBytes = partSize * i;
                fis.skip(skipBytes);
                // 计算每个分块的大小
                long size = partSize < partFile.length() - skipBytes ? partSize : partFile.length() - skipBytes;
                // 创建UploadPartRequest，上传分块
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(bucketName);
                uploadPartRequest.setKey(key);
                uploadPartRequest.setUploadId(uploadid);
                uploadPartRequest.setInputStream(fis);
                uploadPartRequest.setPartSize(size);
                uploadPartRequest.setPartNumber(i + 1);
                UploadPartResult uploadPartResult = client.uploadPart(uploadPartRequest);
                // 将返回的PartETag保存到List中。
                partETags.add(uploadPartResult.getPartETag());
                // 关闭文件
                fis.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(bucketName, key, uploadid, partETags);
        // 完成分块上传
        CompleteMultipartUploadResult completeMultipartUploadResult = client.completeMultipartUpload(completeMultipartUploadRequest);
        // 打印Object的ETag（返回的ETag不是md5.具体是什么不详）
        tag = completeMultipartUploadResult.getETag();
        return tag;
    }

    // 测试
    public static void main(String[] args) throws Exception {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = OSSClientConstants.ACCESS_KEY_ID;
        String accessKeySecret = OSSClientConstants.ACCESS_KEY_SECRET;
        String bucketName = OSSClientConstants.BACKET_NAME;
        String objectName = "user/ceshi/2019-06/2019-06-24/ceshi.zip";
        //测试断点续传
        multipartUploadObject(bucketName,objectName,new File("D:\\upload\\ceshi\\PMS_20181106.zip"));
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        /*try {
            // 带进度条的上传。
            ossClient.putObject(new PutObjectRequest(bucketName, objectName, new File("D:\\upload\\ceshi\\222.docx")).
                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        // 关闭OSSClient。
        ossClient.shutdown();

        /*AliyunOSSClientUtil t = new AliyunOSSClientUtil();
        //String url = t.uploadvideo("g:\\余杰的avi小视频.mp4");
        String url = t.uploadFile("D:\\upload\\hahaha.txt");
        //String url1 = t.urlpath("ceshi", "D:\\upload\\hahaha.txt");
        /************************************* 阶段性测试*************************************/
        // 初始化OSSClient
        //OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
        //t.deleteFile(ossClient,BACKET_NAME,"","user/ceshi/20181121/20181121190832.txt");
        // 上传文件
        /*String files = "D:\\1.jpg";files="D:\\upload\\abc.jpg";
        String[] file = files.split(",");
        String user_id = OSSClientConstants.USER_ID;

        for (String filename : file) {
            File filess = new File(filename);
            String[] s = AliyunOSSClientUtil.uploadObject2OSS(ossClient, filess, BACKET_NAME, user_id);
            logger.info("上传后的文件MD5数字唯一签名:" + s[0]);
            logger.info("文件路径:" + s[1]);
            String url3 = AliyunOSSClientUtil.getUrl(ossClient,BACKET_NAME, s[1]);
            logger.info("访问网址路径:" + url3);
            //上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A }

            byte[] b1 = AliyunOSSClientUtil.image2byte("D:\\upload\\abc.jpg");

            String str = "";
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(str);
            //URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);

//        String path = AliyunOSSClientUtil.uploadByteVideoOSS(ossClient, b1, BACKET_NAME, user_id);
            String path = AliyunOSSClientUtil.uploadByteOSS(ossClient, b1, BACKET_NAME, user_id);
//        String path = AliyunOSSClientUtil.uploadObjectOSS(ossClient, b1, BACKET_NAME, user_id);
            logger.info("文件路径:" + path);
            String url2 = AliyunOSSClientUtil.getUrl(ossClient, BACKET_NAME, path);
            logger.info("访问网址路径:" + url2);
        }*/
    }
}