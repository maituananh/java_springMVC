package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @GetMapping("home")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("listProduct", manageProductServiceImpl.productList());
        return "pageHome";
    }
}
