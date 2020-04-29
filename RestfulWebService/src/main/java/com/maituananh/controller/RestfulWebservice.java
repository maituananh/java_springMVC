package com.maituananh.controller;

import com.maituananh.model.User;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestfulWebservice {
    @RequestMapping("/api")
    public @ResponseBody
    List user() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("mai tuấn anh");

        User user2 = new User();
        user2.setId(2);
        user2.setName("nguyễn tuấn anh");

        userList.add(user2);
        userList.add(user1);
        System.out.println(userList);
        return userList;
    }

    @RequestMapping("signIn")
    public String sign_in() {
        return "sign_in";
    }

    @RequestMapping("restful")
    public String restful() {
        return "Restful";
    }

    @PostMapping("getApiUser")
    public @ResponseBody
    User getUser(@RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "abc");

        return user;
    }
}
