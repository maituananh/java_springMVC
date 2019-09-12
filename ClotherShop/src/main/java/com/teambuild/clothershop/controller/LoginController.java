package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.serviceimpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes({"userSession", "role"})
@Controller
public class LoginController {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @GetMapping("login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("findByUsernameAndPassword")
    @ResponseBody
    public String findByUsernameAndPassword(ModelMap modelMap, @RequestParam String userName, @RequestParam String password) {
        if (!userName.equals("") && !password.equals("")) {
            List<User> userLogin = loginServiceImpl.singleUserList(userName, password);
            for (User ul: userLogin) {
                if (!ul.getUserName().equals("") && !ul.getPassword().equals("")) {
                    modelMap.addAttribute("userSession", userLogin);
                    modelMap.addAttribute("role", ul.getRole().getNameRole());
                    if (ul.getRole().getIdRole() == 1) {
                        return "admin";
                    }
                    return "user";
                } else {
                    return "false";
                }
            }
        } else {
            return "null";
        }
        return "false";
    }

    @GetMapping("logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:home";
    }
}
