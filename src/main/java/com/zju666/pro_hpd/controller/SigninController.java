package com.zju666.pro_hpd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
    @RequestMapping({ "/", "/signin" })
    public String signin() {
        return "signin";
    }

}
