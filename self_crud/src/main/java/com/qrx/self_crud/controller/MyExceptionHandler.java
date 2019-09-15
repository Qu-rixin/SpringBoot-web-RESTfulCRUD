package com.qrx.self_crud.controller;

import com.qrx.self_crud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


    //第一种方法：浏览器和客户端返回的都是json数据（无自适应）
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "UserNotExist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    //方法2：转发到/error，进行自适应响应效果处理
//    @ExceptionHandler(UserNotExistException.class)
//    public String handleException(Exception e, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "UserNotExist");
//        map.put("message", e.getMessage());
//        //传入我们自己的错误状态码4xx、5xx，否则就不会进入错误页面的解析流程
//        /*
//        *在BasicErrorController.java中getStatus()（AbstractErrorController.java实现）
//        * Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
//        * */
//        request.setAttribute("javax.servlet.error.status_code", 400);
//        //转发到/error
//        return "forward:/error";
//    }

    //方法3：将我们定制的数据携带出去
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "UserNotExist");
        map.put("message", e.getMessage());
        //传入我们自己的错误状态码4xx、5xx，否则就不会进入错误页面的解析流程
        /*
         *在BasicErrorController.java中getStatus()（AbstractErrorController.java实现）
         * Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
         * */
        request.setAttribute("javax.servlet.error.status_code", 400);
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
