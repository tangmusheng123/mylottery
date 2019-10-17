package com.lottery.mylottery.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@Description ip工具类
 *@Author  guosh
 *@Date  2018/9/11 0011 上午 10:56
 */
public class IPUtil {

    private static final Logger logger = LoggerFactory.getLogger(IPUtil.class);
    /** 接口超时时间 */
    private static final Integer TIME_OUT = 1000;

    public static String INTRANET_IP = getIntranetIp(); // 内网IP
    public static String INTERNET_IP = getV4IP(); // 外网IP

    /**
     * 检查IP是否合法
     * @param ip
     * @return
     */
    public static boolean ipValid(String ip) {
        String regex0 = "(2[0-4]\\d)" + "|(25[0-5])";
        String regex1 = "1\\d{2}";
        String regex2 = "[1-9]\\d";
        String regex3 = "\\d";
        String regex = "(" + regex0 + ")|(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")";
        regex = "(" + regex + ").(" + regex + ").(" + regex + ").(" + regex  + ")";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);
        return m.matches();
    }
    //外网地址
    public static String getLocalIP1() {
        return INTERNET_IP;
    }
    /**
     * 获取本地ip 适合windows与linux
     * @return
     */

    public static String getLocalIP() {
        String localIP = "127.0.0.1";
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                InetAddress ip = ni.getInetAddresses().nextElement();;
                if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    localIP = ip.getHostAddress();
                    break;
                }
            }
        } catch (Exception e) {
            try {
                localIP = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }
        }
        return localIP;
    }

    /**
     * 获取客户机的ip地址
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    /**
     *@Description 获取当前ip地址是测试环境还是正式环境
     * true正式。false:測試
     *@Author  guosh
     *@Date  2018/9/11 0011 上午 11:00
     *@return
     */
    public static boolean getIpReal(){
        boolean localIP = true;
        try {
            String ip = getLocalIP();
            //测试环境
            if(ip.startsWith("10.0.5.") || ip.startsWith("10.0.1.") || ip.startsWith("192.168.") || "127.0.0.1".equals(ip) || "localhost".equalsIgnoreCase(ip)){
                localIP = false;
            }else if("47.110.235.181".equals(ip)){
                localIP = true;//pms正式环境
            }
            logger.info(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localIP;
    }

    public static String getHttpIp(Integer port){
        String url="";
        try {
            if(getIpReal()){
                url="https://"+IPUtil.getLocalIP()+":"+port;
            }else{
                url="http://"+IPUtil.getLocalIP()+":"+port;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 判断是linux系统还是其他系统
     * 如果是Linux系统，返回true，否则返回false
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;
    }


    /***************************获取ip地址：内网和外网*************************************/

    /**
     * 获得内网IP
     * @return 内网IP
     */
    protected static String getIntranetIp(){
        try{
            return InetAddress.getLocalHost().getHostAddress();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得外网IP
     * @return 外网IP
     */
    private static String getV4IP(){
        String ip = "";
        String chinaz = "http://ip.chinaz.com";
        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(TIME_OUT);
                urlConnection.setReadTimeout(TIME_OUT);
                in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            } catch (Exception e) {
                //如果超时，则返回内网ip
                return INTRANET_IP;
            }
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ip = ipstr;
        }
        if ("".equals(ip)) {
            // 如果没有外网IP，就返回内网IP
            return INTRANET_IP;
        }
        return ip;
    }



    public static void main1(String[] args) {
        logger.info(getLocalIP());
    }
    public static void main(String[] args) {
        logger.info(getV4IP());
    }

}
