package com.teambuild.clothershop.interceptor;

import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EventProductInterceptor implements HandlerInterceptor {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath();
        switch (url) {
            case "/productDetails": case "/home": case "/home-page":
                int start = 4;
                int end = 4;
                List<Product> recentProducts = getNewProduct(start, end);
                request.setAttribute("recentProducts", recentProducts);

                start += start;
                List<Product> recentProductsBonus = getNewProduct(start, end);
                request.setAttribute("recentProductsBonus", recentProductsBonus);
                break;
            // lấy sản phẩm bán chạy nhất 4-8 cái
        }
        // lấy sản phẩm có trong giỏ hàng
        List<Product> getAllCart = manageProductServiceImpl.getAllCart();
        request.setAttribute("getAllCart", getAllCart);
        return true;
    }

    private List getNewProduct (int start, int end) {
        return manageProductServiceImpl.recentProducts(start, end);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
