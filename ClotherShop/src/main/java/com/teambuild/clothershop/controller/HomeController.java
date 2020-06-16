package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.utils.GetTimeAndDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class HomeController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    private int getSizeRealOfProduct() {
        return manageProductServiceImpl.getAllProduct().size();
    }

    @GetMapping("home")
    public String home(ModelMap modelMap) {
        List<Product> productList = manageProductServiceImpl.productList(0, 8);
        modelMap.addAttribute("listProduct", productList);
        float sizeOfProduct = (float) Math.ceil(getSizeRealOfProduct() / 8.0f);
        modelMap.addAttribute("sizeOfProduct", (int) sizeOfProduct);
        List<Integer> idProductNew = GetTimeAndDay.compareDate(productList);
        modelMap.addAttribute("idProductNew", idProductNew);
        return "pageHome";
    }

    @GetMapping("home-page")
    public String paging(ModelMap modelMap, @RequestParam String page) {
        int parseIntPage = Integer.parseInt(page);
        // thuật toán sử lý lấy ra dữ liệu
        int pageNext = (getSizeRealOfProduct() * parseIntPage) - (parseIntPage * 4);
        System.out.println(pageNext);
        List<Product> productList = manageProductServiceImpl.productList(pageNext, 8);
        modelMap.addAttribute("listProduct", productList);
        float sizeOfProduct = (float) Math.ceil(getSizeRealOfProduct() / 8.0f);
        modelMap.addAttribute("sizeOfProduct", (int) sizeOfProduct);
        return "pageHome";
    }
}
