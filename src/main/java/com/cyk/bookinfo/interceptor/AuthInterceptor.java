package com.cyk.bookinfo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行登录、注册
        if (request.getRequestURI().endsWith("/user/login") || request.getRequestURI().endsWith("/user/reg")) {
            return true;
        }

        //如果用户没有登录，让你到登陆界面，不再执行下面的代码
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
        }

        return true;
    }
}
