package com.yetao.blog.interceptor;

import com.yetao.blog.utils.CookieUtil;
import com.yetao.blog.utils.RedisUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/13 14:17
 */

public class JwtInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }
}
