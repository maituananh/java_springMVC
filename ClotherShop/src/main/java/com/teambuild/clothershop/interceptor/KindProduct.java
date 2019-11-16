package com.teambuild.clothershop.interceptor;

import com.teambuild.clothershop.model.Color;
import com.teambuild.clothershop.model.Kind;
import com.teambuild.clothershop.model.Producer;
import com.teambuild.clothershop.model.Size;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class KindProduct implements HandlerInterceptor {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Color> colorList = manageProductServiceImpl.getAllColor();
        List<Size> sizeList = manageProductServiceImpl.getAllSize();
        List<Kind> kindList = manageProductServiceImpl.getAllKind();
        List<Producer> producerList = manageProductServiceImpl.getAllProducer();
        request.setAttribute("colorList", colorList);
        request.setAttribute("sizeList", sizeList);
        request.setAttribute("kindList", kindList);
        request.setAttribute("producerList", producerList);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
