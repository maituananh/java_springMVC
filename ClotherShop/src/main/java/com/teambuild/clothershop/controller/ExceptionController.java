package com.teambuild.clothershop.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class ExceptionController {

    @GetMapping("404")
    public String error404page () {
        return "";
    }

    @GetMapping("500")
    public String error500page () {
        return "";
    }
}
