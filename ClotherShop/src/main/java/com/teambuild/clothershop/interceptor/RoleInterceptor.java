package com.teambuild.clothershop.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession httpSession = request.getSession();
//        String getServletPath = request.getServletPath().trim() + java.time.LocalDate.now();
//        String subStringURL = getServletPath.substring(0, 7).trim();
//        System.out.println("session = " + httpSession.getAttribute("role"));
//        if(subStringURL.equals("/admin-")) {
//            if(httpSession.getAttribute("role") != "admin") {
//                response.sendRedirect("error403");
//            }
//        } else {
//            if(httpSession.getAttribute("role") == "admin") {
//                httpSession.invalidate();
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
