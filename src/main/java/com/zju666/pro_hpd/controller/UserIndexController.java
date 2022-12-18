package com.zju666.pro_hpd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zju666.pro_hpd.service.DocUserService;

@Controller
public class UserIndexController {
    @Autowired
    private DocUserService docUserService;


    @RequestMapping("user_index")
    public String userIndex(Model model) {
        model.addAttribute("users", docUserService.selectAllUser());
        return "user_index";
    }
}