package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.model.ProductDetails;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ProductDetailsController {

    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @GetMapping("productDetails")
    public String productDetails(@RequestParam int id, ModelMap modelMap) {
        Product product = manageProductServiceImpl.selectProductById(id);
        modelMap.addAttribute("infoProduct", product);
        Set<ProductDetails> setProductDetails = product.getProductDetails();
        modelMap.addAttribute("productDetail", setProductDetails);
        return "pageDetails";
    }
}
