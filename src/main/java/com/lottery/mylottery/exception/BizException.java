package com.lottery.mylottery.exception;


public class BizException extends RuntimeException {

    /**
     * 请求参数异常code
     */
    public static final int REQUEST_PARAM_ERROR = 301;
    /**
     * sqlserver查询异常code
     */
    public static final int SQLSERVER_SELECT_ERROR = 302;
    /**
     * mysql查询异常code
     */
    public static final int MYSQL_SELECT_ERROR = 303;

    private Integer code;

    private String msg;

    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    /**
     * @Description: 打印详细异常信息
     * @Date: 11:05 2018-09-12
     * @Author: YuanPeng
     */
    public static String getExceptionDetail(Exception e) {
        StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        int length = messages.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\t" + messages[i].toString() + "\n");
        }
        return stringBuffer.toString();
    }
}
