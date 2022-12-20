package com.zju666.pro_hpd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zju666.pro_hpd.pojo.DocUser;
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

    // 同样的，signup和adduser要分开的，一个是展示的网页，一个是用于操作的
    @GetMapping("/signup")
    public String showSignUpForm(DocUser user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Validated DocUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        docUserService.insertDocUser(user);
        return "redirect:/signin";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        DocUser user = docUserService.selectUserByID((int) id);
        
        model.addAttribute("docUser", user);
        return "update-user";

        
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated DocUser user,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId((int)id);
            return "update-user";
        }

        docUserService.updateUser(user);
        return "redirect:/user_index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        docUserService.deleteUser((int) id);
        return "redirect:/user_index";
    }
}