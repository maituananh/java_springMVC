package com.maituananh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(path = "/trang1")
    public String trang1() {
        return "trang1";
    }

    @GetMapping(path = "/trang2")
    public String trang2() {
        return "trang2";
    }
}
