package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @GetMapping("home")
    public String home(ModelMap modelMap) {
        List<Product> productList = manageProductServiceImpl.productList();
        modelMap.addAttribute("listProduct", productList);
        return "pageHome";
    }
}
