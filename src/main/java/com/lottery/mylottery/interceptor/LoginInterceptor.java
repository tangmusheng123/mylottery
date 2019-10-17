package com.lottery.mylottery.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("拦截器MyInterceptor------->1、请求之前调用，也就是Controller方法调用之前。"+sessionId);
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//不能使用通配符*
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //response.setStatus(300);
        PrintWriter printWriter = response.getWriter();
        printWriter.write("{code:300,msg:\"not login!\",data:\"\"}");
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // String sessionId = request.getSession().getId();
        // System.out.println("拦截器MyInterceptor------->2、请求之后调用，在视图渲染之前，也就是Controller方法调用之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //  String sessionId = request.getSession().getId();
        // System.out.println("拦截器MyInterceptor------->3、请求结束之后被调用，主要用于清理工作。");
    }


}
