package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Color;
import com.teambuild.clothershop.model.Kind;
import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.model.Size;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.validate.CodesValidate;
import com.teambuild.clothershop.validate.DescribeValidate;
import com.teambuild.clothershop.validate.PriceValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // check main product
    @PostMapping("checkInfoProduct")
    @ResponseBody
    public String checkInfoProduct(@RequestParam String code, @RequestParam String name, @RequestParam String price,
                                 @RequestParam String describe) {
        boolean check = false;
        if (CodesValidate.codesValidate(code)) {
            List<Product> productList = manageProductServiceImpl.productList();
            for (int i = 0; i < productList.size(); i++) {
                if(productList.get(i).getCodesProduct().equals(code)) {
                    return "Code already exists";
                } else {
                    if (productList.get(i).getName().equals(name)) {
                        return "Name already exists";
                    } else {
                        check = true;
                    }
                }
            }// end for
            if (check) {
                if (PriceValidate.priceValidate(price)) {
                    if (CodesValidate.codesValidate(name)) {
                        return "Wrong format Name of product";
                    } else {
                        return "true";
//                        if (DescribeValidate.describeValidate(describe)) {
//                            // đã vượt qua all điều kiện
//
//                        } else {
//                            return "Wrong format Describe of product";
//                        }
                    }
                } else {
                    return "Wrong format Price of product";
                }
            }
        } else {
            return "Wrong format Code of product";
        }
        return "false";
    }
}
