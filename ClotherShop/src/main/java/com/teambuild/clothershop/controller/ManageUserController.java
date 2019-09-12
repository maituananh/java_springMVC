package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.serviceimpl.ManageUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ManageUserController {
    @Autowired
    ManageUserServiceImpl manageUserServiceImpl;

    @GetMapping("admin-listAllUser")
    public String listAllUser(ModelMap modelMap) {
        List<User> getAllUser = manageUserServiceImpl.listAllUser();
        modelMap.addAttribute("getAllUser", getAllUser);
        return "listUser";
    }

    @PostMapping("admin-editRole")
    public RedirectView editRole(@RequestParam boolean role, @RequestParam boolean oldRole, @RequestParam int id) {
        if (role == true && oldRole == true || role == false && oldRole == false) {
            return new RedirectView("admin-listAllUser");
        } else {
            int newRole;
            if (role) {
                newRole = 1;
            } else {
                newRole = 2;
            }
            manageUserServiceImpl.editRoleUser(id, newRole);
            return new RedirectView("admin-listAllUser");
        }
    }

    @GetMapping("admin-editProfile")
    public String editProfile(@RequestParam int id, ModelMap modelMap) {
        User profileUser = manageUserServiceImpl.findID(id);
        modelMap.addAttribute("profileUser", profileUser);
        modelMap.addAttribute("user", new User());
        return "profileAdmin";
    }

    @PostMapping("admin-updateProfile")
    public RedirectView updateProfileAdmin(@ModelAttribute User user) {
        System.out.println("userName = " + user.getUserName());
        System.out.println("getName = " + user.getName());
        System.out.println("getEmail = " + user.getEmail());
        System.out.println("getPassword = " + user.getPassword());
        System.out.println("getAge = " + user.getAge());
        return new RedirectView("admin-listAllUser");
    }
}
