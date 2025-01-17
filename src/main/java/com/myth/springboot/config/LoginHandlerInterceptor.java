package com.myth.springboot.config;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登陆拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username=request.getAttribute("user");
        System.out.println("拦截器工作");
        Object user = request.getSession().getAttribute("user");
        System.out.println(user);
        if (user==null){
            //request.getRequestDispatcher("/").forward(request,response);
            System.out.println("拦截成功");
            request.getRequestDispatcher("/").forward(request,response);

            return false;
        }else {
            System.out.println("放行");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
