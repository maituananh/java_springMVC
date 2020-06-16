package com.teambuild.clothershop.interceptor;

import com.teambuild.clothershop.contains.LangKeyCommon;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        String getServletPath = request.getServletPath().trim() + java.time.LocalDate.now();
        String subStringURL = getServletPath.substring(0, 7).trim();
        if (httpSession.getAttribute(LangKeyCommon.KEY_ROLE) != null) {
            if(subStringURL.equals(LangKeyCommon.KEY_API_ADMIN)) {
                if(!httpSession.getAttribute(LangKeyCommon.KEY_ROLE).toString().equals("1")) {
                    response.sendRedirect("error403");
                }
//            } else {
//                if(httpSession.getAttribute(LangKeyCommon.KEY_ROLE).equals("1")) {
//                    System.out.println("admin");
//                    httpSession.invalidate();
//                }
            }
        } else {
            if(subStringURL.equals(LangKeyCommon.KEY_API_ADMIN)) {
                response.sendRedirect("error403");
            }
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
