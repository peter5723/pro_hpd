package com.zju666.pro_hpd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zju666.pro_hpd.pojo.DocUser;
import com.zju666.pro_hpd.service.DocUserService;

@Controller
public class SigninController {
    @Autowired
    private DocUserService docUserService;

    @RequestMapping({ "/", "/signin" })
    public String signin() {
        return "signin";
    }

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        List<DocUser> list1 = docUserService.selectAllUser();
        for (DocUser user : list1) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "redirect:/files";
            }
        }
        model.addAttribute("msg", "用户名或者密码错误");
        return "/signin";
    }
}
