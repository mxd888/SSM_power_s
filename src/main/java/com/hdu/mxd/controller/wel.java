package com.hdu.mxd.controller;

import com.hdu.mxd.entity.User_m;
import com.hdu.mxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DELL(mxd) on 2020/12/8 23:05
 */
@Controller
public class wel {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String WEL(){
        return "redirect:/mxd/index";
    }

    @GetMapping("/insertUser")
    public String insertUser(){
        return "admin/insertUser";
    }

    @GetMapping("/modifyUser")
    public String modifyUser(@RequestParam("username") Integer username, HttpServletRequest request){
        User_m userById = userService.findUserById(username);
        request.setAttribute("user",userById);
        return "admin/modifyUser";
    }

}
