package com.qrx.self_crud.controller;

import com.qrx.self_crud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionTestController {

    @ResponseBody
    @RequestMapping("/exc")
    public String testexception(@RequestParam("user") String  user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "test";
    }
}
