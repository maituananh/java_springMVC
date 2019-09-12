package com.maituananh.controller;

import com.maituananh.model.Role;
import com.maituananh.model.User;
import com.maituananh.serviceimpl.ManageUserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageUserController {

    @Autowired
    ManageUserServiceImpl manageUserServiceImpl;

    @GetMapping(path = "/listUser")
    public String getALLUser(ModelMap modelMap) {
        List<User> userList = manageUserServiceImpl.getAllUser();
        modelMap.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping(path = "/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        manageUserServiceImpl.deleteUser(id);
        return "redirect:/listUser";
    }

    @GetMapping(path = "/viewUpdate/{id}")
    public String viewUpdateUser(ModelMap modelMap, @PathVariable int id) {
        User inForEditUser = manageUserServiceImpl.inForEditUser(id);
        modelMap.addAttribute("inForEditUser", inForEditUser);
        return "viewUpdateUser";
    }

    @PostMapping(path = "/Update")
    public String updateUser(@RequestParam int id, @RequestParam int role,
                             @RequestParam String name, @RequestParam String username,
                             @RequestParam int age, @RequestParam String password, @RequestParam String repeatPassword) {
        User userUpdate= setUser(role, name, username, age, password, repeatPassword, id);
        manageUserServiceImpl.saveUser(userUpdate);
        return "redirect:/listUser";
    }

    @GetMapping(path = "/viewAdd")
    public String viewAdd() {
        return "viewAddUser";
    }

    @PostMapping(path = "/add")
    public String addUser(@RequestParam int role, @RequestParam String name, @RequestParam String username,
                             @RequestParam int age, @RequestParam String password, @RequestParam String repeatPassword) {
        int id = 0; // tạo id giả để làm chung hàm với update.
        User userAdd = setUser(role, name, username, age, password, repeatPassword, id);
        manageUserServiceImpl.addUser(userAdd);
        return "redirect:/listUser";
    }

    private User setUser(int role, String name, String username, int age, String password, String repeatPassword, int id) {
        Role roleUser = new Role();
        roleUser.setIdrole(role);
        User user = new User();
        user.setIduser(id);
        user.setName(name);
        user.setUsername(username);
        user.setAge(age);
        user.setPassword(password);
        user.setRole(roleUser);
        return user;
    }

    @PostMapping(path = "/search")
    public String searchUser(ModelMap modelMap, @RequestParam String name) {
        List<User> userList = manageUserServiceImpl.searchUser(name);
        modelMap.addAttribute("userList", userList);
        return "userList";
    }
}
