package com.lottery.mylottery.handler;

import com.alibaba.fastjson.JSONException;
import com.lottery.mylottery.common.BaseResponse;
import com.lottery.mylottery.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 全局捕获异常和自定义全局捕获异常
 * @Date: 11:21 2019-08-06
 * @Author: YuanPeng
 * @Modifier:
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefultExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);

    /**
     * @Description: 业务异常捕获
     * @Date: 11:38 2019-08-06
     * @Author: YuanPeng
     */
    @ExceptionHandler(value = BizException.class)
    public BaseResponse bizExceptionHandler(BizException bex) {
        BaseResponse response = new BaseResponse(bex.getCode(), bex.getMsg(), "");
        logger.error("业务异常：" + BizException.getExceptionDetail(bex));
        return response;
    }

    /**
     * @Description: 系统异常捕获
     * @Date: 13:35 2019-08-06
     * @Author: YuanPeng
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse bizExceptionHandler(HttpServletRequest request, Exception ex) {
        logWrite(request, ex);
        if (ex instanceof NullPointerException) {
            return BaseResponse.error("空指针异常");
        } else if (ex instanceof JSONException) {
            return BaseResponse.error("Json解析失败");
        } else if (ex instanceof IOException) {
            return BaseResponse.error("文件读写异常");
        } else if (ex instanceof ArrayIndexOutOfBoundsException) {
            return BaseResponse.error("数组下标越界异常");
        } else if (ex instanceof ClassCastException) {
            return BaseResponse.error("类型强制转换异常");
        } else {
            return BaseResponse.error("系统内部异常");
        }
    }

    /**
     * @Description: 异常详细记录
     * @Date: 16:53 2019-08-06
     * @Author: YuanPeng
     */
    private void logWrite(HttpServletRequest request, Exception e) {
        StringBuilder sb = new StringBuilder("\n---Exception Log Begin---\n");
        sb.append("url:").append(request.getRequestURL()).append("\n");
        sb.append("Method:").append(request.getMethod()).append("\n");
        sb.append("Exception Type:").append(e.getClass().getName()).append("\n");
        sb.append("Exception Details:");
        logger.error(sb.toString(), e);
    }

}
