package com.hdu.mxd.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL(mxd) on 2020/12/8 23:05
 */

@Controller
@RequestMapping("/mxd")
public class testMyController {


    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

//    @GetMapping("login")
//    public String login(){
//        return "login";
//    }

    @GetMapping("index")
    @Secured({"ROLE_admin","ROLE_user"})
    public String index(){
        return "user/index";
    }

    @GetMapping("update")
    @Secured({"ROLE_admin"})
    public String update(){
        return "hello update";
    }
}
