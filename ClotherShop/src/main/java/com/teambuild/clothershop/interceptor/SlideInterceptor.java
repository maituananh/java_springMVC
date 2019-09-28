package com.teambuild.clothershop.interceptor;

import com.teambuild.clothershop.model.Slide;
import com.teambuild.clothershop.serviceimpl.SlideInterceptorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
// cấu hình quét class trong xml
public class SlideInterceptor implements HandlerInterceptor {

    @Autowired
    SlideInterceptorServiceImpl slideInterceptorServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath();
        switch (url) {
            case "/home": case "/home-page":
                List<Slide> slideList = slideInterceptorServiceImpl.loadMenu();
                request.setAttribute("slideList", slideList);
                break;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
