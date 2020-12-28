package com.hdu.mxd.controller;

import com.hdu.mxd.entity.Course;
import com.hdu.mxd.entity.CourseWithUser;
import com.hdu.mxd.entity.CourseWithUserToUser;
import com.hdu.mxd.entity.User_m;
import com.hdu.mxd.service.UserService;
import com.hdu.mxd.vo.DataVO;
import com.hdu.mxd.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/8 23:05
 */

@Controller
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/selectMyself")
    @Secured({"ROLE_admin","ROLE_user"})
    public String myself(HttpSession session, HttpServletRequest request){
        String username = session.getAttribute("username").toString();
        int userIdByUserName = userService.findUserIdByUserName(username);
        User_m userById = userService.findUserById(userIdByUserName);
        request.setAttribute("user",userById);
        return "user/myself";
    }

    @GetMapping("/modifyMyself")
    @Secured({"ROLE_admin","ROLE_user"})
    public String modifyMyself(HttpSession session, HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password){
        String usernames = session.getAttribute("username").toString();
        int userIdByUserName = userService.findUserIdByUserName(usernames);
        User_m user_m = new User_m();
        user_m.setId(userIdByUserName);
        user_m.setUsername(username);
        user_m.setPassword(password);
        userService.modifyUserById(user_m);
        User_m userById = userService.findUserById(userIdByUserName);
        request.setAttribute("user",userById);
        return "user/myself";
    }





    @GetMapping("/selectCourseById")
    @Secured({"ROLE_admin","ROLE_user"})
    @ResponseBody
    public DataVO<Course> selectCourseById(HttpSession session){

        String username = session.getAttribute("username").toString();
        List<Course> courseByUserId = userService.findCourseByUserId(username);


        DataVO<Course> dataVO = new DataVO<Course>();
        dataVO.setCode(0);
        dataVO.setData(courseByUserId);
        return dataVO;
    }



    @GetMapping("/modifyCourseClass")
    @Secured({"ROLE_admin","ROLE_user"})
    public String modifyCourseClass(HttpSession session,@RequestParam("cid") int cid,@RequestParam("id") int id){

        int i =userService.modifyCourseWithUserById(new CourseWithUserToUser(id,cid));
        DataVO<String> dataVO = new DataVO<>();
        if (i>0)
            dataVO.setCode(0);
        dataVO.setCode(1);
        return "redirect:/user/chooseClassById";
    }

    @GetMapping("/deleteCourseClass")
    @Secured({"ROLE_admin","ROLE_user"})
    public String deleteCourseClass(@RequestParam("cid") int cid,HttpSession session){
        DataVO<String> dataVO = new DataVO<>();
        int i = userService.deleteCourseWithUserById(cid);
        if (i>0)
            dataVO.setCode(0);
        dataVO.setCode(1);
        return "redirect:/user/chooseClassById";
    }

    @GetMapping("/insertChooseClass")
    @Secured({"ROLE_admin","ROLE_user"})
    public String insertChooseClass(HttpSession session, @RequestParam("cid") int cid){
        String username = session.getAttribute("username").toString();
        int userIdByUserName = userService.findUserIdByUserName(username);
        userService.insertCourseWithUserById(new CourseWithUserToUser(userIdByUserName,cid));
        return "redirect:/user/chooseClassById";
    }




    @GetMapping("/chooseCourseById")
    @Secured({"ROLE_admin","ROLE_user"})
    public String chooseCourseById(HttpSession session){
        String username = session.getAttribute("username").toString();
        return "user/chooseClass";
    }

    @GetMapping("/chooseClassById")
    @Secured({"ROLE_admin","ROLE_user"})
    public String chooseClassById(HttpSession session){
        return "user/chooseClass";
    }

}
