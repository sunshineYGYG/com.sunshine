package com.sunshine.shine.common.Advices;

import com.sunshine.shine.Util.JsonData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;

@ControllerAdvice
public class ResponseModifierAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
//        ServletServerHttpResponse ssresp = (ServletServerHttpResponse) response;
//        HttpServletRequest req = ssreq.getServletRequest();
//        HttpServletResponse resp = ssresp.getServletResponse();
//        resp.setHeader("token",req.getHeader("token"));
//        JsonData jsonData = (JsonData) body;
//        System.out.println(jsonData.toString());
        return body;
    }
}
