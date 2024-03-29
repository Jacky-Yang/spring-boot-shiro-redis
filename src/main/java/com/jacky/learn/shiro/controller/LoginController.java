package com.jacky.learn.shiro.controller;

import com.jacky.learn.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            final Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            User user = new User();
            user.setUserName(username);

            subject.getSession().setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            return "500.html";
        }
        return "/home";
    }

    @GetMapping("/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }
}
