package com.teambuild.clothershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckOutController {

    @GetMapping("checkOut")
    public String checkOut() {
        return "checkOut";
    }
}
