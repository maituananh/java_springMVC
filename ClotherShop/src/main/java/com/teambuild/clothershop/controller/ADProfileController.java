package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.serviceimpl.ManageUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ADProfileController {
    @Autowired
    ManageUserServiceImpl manageUserServiceImpl;

    @GetMapping("admin-profile")
    public String profile(ModelMap modelMap, @RequestParam int id) {
        User user = manageUserServiceImpl.findID(id);
        modelMap.addAttribute("profileUser", user);
        return "profile";
    }
}
