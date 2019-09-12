package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class VerificationController {

    @GetMapping("admin-verification")
    public String verification() {
        return "verification";
    }

    @PostMapping("admin-findCode")
    public String findCode(ModelMap modelMap, @RequestParam String codes, @SessionAttribute("userSession") User userSession) {
        String code = userSession.getVerification().getCodes();
        if(code.equals(codes)) {
            return "adminHome";
        }
        modelMap.addAttribute("notification", "Wrong validation code");
        return "verification";
    }
}
