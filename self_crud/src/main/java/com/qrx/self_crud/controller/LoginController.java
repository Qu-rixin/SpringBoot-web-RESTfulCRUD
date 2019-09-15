package com.qrx.self_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可重定向到主页
            session.setAttribute("loginuser", username);
            return "redirect:/showallemps";
        } else {
            map.put("msg", "用户密码错误");
            return "login";
        }
    }
}
