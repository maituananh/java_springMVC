package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.serviceimpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @PostMapping(path = "findByUsernameAndPassword")
    @ResponseBody
    public String findByUsernameAndPassword(ModelMap modelMap, @RequestParam String userName, @RequestParam String password) {
        if (!userName.equals("") && !password.equals("")) {
            User userLogin = loginServiceImpl.findByUsernameAndPassword(userName.trim(), password.trim());
            if (userLogin != null) {
                modelMap.addAttribute("userSession", userLogin);
                modelMap.addAttribute("role", userLogin.getRole().getIdRole());
                return "" + userLogin.getIdUser();
            } else {
                return "false";
            }
        }
        return null;
    }

    @GetMapping("logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "true";
    }
}
