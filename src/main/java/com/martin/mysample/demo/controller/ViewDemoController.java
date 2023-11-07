package com.martin.mysample.demo.controller;

import com.martin.mysample.demo.bean.UserLoginDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

/**
 * ViewDemoController
 *
 * @author Martin
 * @since 2023-10-30 14:21
 **/

@Controller
public class ViewDemoController {

    @GetMapping(value = {"/", "login"})
    public String index() {

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody(required = false) UserLoginDTO user, HttpSession session, Model model) {
        if (StringUtils.equals(user.getUsername(), "admin") && StringUtils.equals(user.getPassword(), "admin")) {
            session.setAttribute("username", user.getUsername());
            return "redirect:/index.html";
        }

        model.addAttribute("用户名或密码输入错误！");

        // return "redirect:/login";
        return "login";
    }

    @GetMapping("/demo111")
    public String demo(Model model){


        model.addAttribute("msg","Martin says hello");
        model.addAttribute("link","https://www.baidu.com");

        return "success";
    }
}
