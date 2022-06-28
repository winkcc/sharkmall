package com.wink.controller;

import com.wink.domain.User;
import com.wink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService us;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    //登录
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){
        System.out.println("=======================================");
        System.out.println(user);
        try {
            user = us.login(user);
            //登录成功  保存用户信息到session中
            session.setAttribute("user", user);
            //跳转页面
            return "redirect:/";
        }catch (Exception e) {
            e.printStackTrace();
            //登录失败
            model.addAttribute("error", e.getMessage());
            //回到登录页面
            return "user/login";
        }
    }

    //登出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        System.out.println(session.getAttribute("user"));
        return "redirect:/";
    }

}
