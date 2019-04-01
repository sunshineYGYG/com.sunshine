package com.sunshine.shine.common.Interceptors;

import com.alibaba.fastjson.JSONObject;
import com.sunshine.shine.Util.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class TokenInterceptor implements HandlerInterceptor {
    public static final Logger LOGGER=LoggerFactory.getLogger(TokenInterceptor.class);

    @Autowired
    private ResponseBodyAdvice responseBodyAdvice;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle");
        System.out.println("token已过期");
        System.out.println("---");
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRemoteAddr());
        System.out.println("---");
//        sendNoLogin(response);
        return true;
    }

    private void sendNoLogin(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter out = response.getWriter()) {
            out.append(JSONObject.toJSONString(JsonData.error("token已过期，请重新登录", 401)));
        } catch (IOException var17) {
            var17.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        String token = request.getHeader("token");
        System.out.println(token);
//        response.addHeader("token",token);
//        response.setHeader("token",token);
//        response.setStatus(201);
//        System.out.println("--------");
//        Collection<String> headers = response.getHeaderNames();
//        headers.forEach(h->{
//            System.out.print(h);
//            System.out.println(" = "+response.getHeader(h));
//        });
//        System.out.println("--------");
//        System.out.println(response.getStatus());
//        System.out.println(handler.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("pafterCompletion");
    }
}
