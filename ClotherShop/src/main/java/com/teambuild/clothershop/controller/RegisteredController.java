package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.Gender;
import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.serviceimpl.ManageUserServiceImpl;
import com.teambuild.clothershop.validate.EmailValidate;
import com.teambuild.clothershop.validate.PasswordValidate;
import com.teambuild.clothershop.validate.UserNameValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegisteredController {

    @Autowired
    ManageUserServiceImpl manageUserServiceImpl;

    @GetMapping("registered")
    public String registered(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "registered";
    }

    @PostMapping("registered")
    @ResponseBody
    public String addUser(@RequestParam String nameUser, @RequestParam String userName, @RequestParam String birthday,
                          @RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword,
                          @RequestParam String gender) {
        boolean check = false;
        if (password.equals(confirmPassword)) {
            if (!PasswordValidate.passwordValidate(password)) {
                return "Wrong format password";
            } else {
                if (!EmailValidate.validateEmail(email)) {
                    return "Wrong format Email";
                } else {
                    if (UserNameValidate.UserNamevalidate(userName)) {
                        List<User> userList = manageUserServiceImpl.listAllUser();
                        for (User us : userList) {
                            if (email.equals(us.getEmail())) {
                                return "This email already exists";
                            }
                            if (userName.equals(us.getUserName())) {
                                return "This UserName already exists";
                            }
                            check = true;
                        }
                    } else {
                        return "Wrong format Username";
                    }
                }
                if (check) {
                    if (birthday == "") {
                        return "Wrong format Birthday";
                    } else {
                        User user = new User();
                        user.setName(nameUser);
                        user.setUserName(userName);
                        user.setBirthday(birthday);
                        user.setEmail(email);
                        user.setPassword(password);

                        Gender genderAdd = new Gender();
                        genderAdd.setIdGender(Integer.parseInt(gender.trim()));

                        user.setGender(genderAdd);
                        manageUserServiceImpl.addUser(user);
                        return "true"; // true
                    }
                } else {
                    return "Registration not successful"; // false
                }
            }
        } else {
            return "Wrong ConfirmPassword";
        }
    }
}
