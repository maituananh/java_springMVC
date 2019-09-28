package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailsController {

    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @GetMapping("productDetails")
    public String productDetails(@RequestParam int id, ModelMap modelMap) {
        modelMap.addAttribute("infoProduct", detailsProduct(id));
        return "pageDetails";
    }

    @GetMapping("admin-details-product")
    public String adminDetailProduct(ModelMap modelMap ) {
//        modelMap.addAttribute("infoProduct", detailsProduct(id));@RequestParam int id
        return "editProductAdmin";// cần tạo trang chi tiết sản phẩm ở bên admin
    }

    private Product detailsProduct(int id) {
        Product productDetails = manageProductServiceImpl.selectProductById(id);
        return productDetails;
    }
}
