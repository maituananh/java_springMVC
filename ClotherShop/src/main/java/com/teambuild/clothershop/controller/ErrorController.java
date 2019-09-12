package com.teambuild.clothershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("error403")
    public String error403() {
        return "error403";
    }

    @GetMapping("adminError403")
    public String adminError403() {
        return "adminError403";
    }
}
