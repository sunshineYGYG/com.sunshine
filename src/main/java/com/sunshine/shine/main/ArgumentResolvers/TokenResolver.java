package com.sunshine.shine.main.ArgumentResolvers;

import com.sunshine.shine.common.Annotations.UserToken;
import com.sunshine.shine.dao.UserMapper;
import com.sunshine.shine.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.hasParameterAnnotation(UserToken.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            return null;
        }
        User user = userMapper.selectOneUser(Integer.parseInt(token));
        return user;
    }
}
