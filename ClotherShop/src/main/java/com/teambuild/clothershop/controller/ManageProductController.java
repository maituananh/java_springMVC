package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.daoimpl.ManageProductDaoImpl;
import com.teambuild.clothershop.model.Color;
import com.teambuild.clothershop.model.Kind;
import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.model.Size;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.serviceimpl.ManageUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManageProductController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @GetMapping("admin-getAllProduct")
    public String getAllProduct(ModelMap modelMap) {
        List<Product> productList = manageProductServiceImpl.productList();
        modelMap.addAttribute("getAllProduct", productList);
        return "listProduct";
    }

    @GetMapping("admin-addProduct")
    public String addProduct(ModelMap modelMap) {
        List<Color> colorList = manageProductServiceImpl.getAllColor();
        List<Size> sizeList = manageProductServiceImpl.getAllSize();
        List<Kind> kindList = manageProductServiceImpl.getAllKind();
        modelMap.addAttribute("colorList", colorList);
        modelMap.addAttribute("sizeList", sizeList);
        modelMap.addAttribute("kindList", kindList);
        return "addProduct";
    }

    @PostMapping("saveNewProduct")
    @ResponseBody
    public String saveNewProduct() {
        return "true";
    }
}
