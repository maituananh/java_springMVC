package com.maituananh.interceptor;

import com.maituananh.model.Menu;
import com.maituananh.serviceimpl.InterceptorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class Interceptor implements HandlerInterceptor {

    @Autowired
    InterceptorServiceImpl interceptorServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List <Menu> menu = interceptorServiceImpl.loadMenu();
        request.setAttribute("menu", menu);
        System.out.println("load menu");
        return true; // sử dụng phương thức này
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
