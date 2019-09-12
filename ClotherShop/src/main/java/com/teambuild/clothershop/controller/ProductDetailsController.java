package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.daoimpl.ManageProductDaoImpl;
import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class ProductDetailsController {

    @Autowired
    ManageProductDaoImpl manageProductDaoImpl;

    @GetMapping("productDetails")
    public String productDetails(@RequestParam int id, ModelMap modelMap) {
        Product product = manageProductDaoImpl.selectProductById(id);
        modelMap.addAttribute("infoProduct", product);
        Set<ProductDetails> setProductDetails = product.getProductDetails();
        modelMap.addAttribute("productDetail", setProductDetails);
        return "pageDetails";
    }
}
