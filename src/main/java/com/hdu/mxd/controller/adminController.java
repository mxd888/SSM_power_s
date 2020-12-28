package com.hdu.mxd.controller;

import com.hdu.mxd.entity.*;
import com.hdu.mxd.service.UserService;
import com.hdu.mxd.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/11 22:32
 */
@Controller
@RequestMapping(value = "/admin")
public class adminController {

    @Autowired
    private UserService userService;


    @GetMapping("/insertUser")
    @Secured({"ROLE_admin"})
    public void insertUser(HttpSession session, HttpServletRequest request,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("cid") Integer cid){

        userService.insertUserById(new User(0,username,password,cid));

    }


    @GetMapping("/deleteUser")
    @Secured({"ROLE_admin"})
    public String deleteUser(HttpSession session, HttpServletRequest request,
                           @RequestParam("id") Integer id){

        userService.deleteUserById(id);

        return "admin/user";

    }

    @GetMapping("/modifyUser")
    @Secured({"ROLE_admin"})
    public String modify(HttpSession session, HttpServletRequest request,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password,
                           @RequestParam("id") Integer id){


        User_m userById = userService.findUserById(id);
        request.setAttribute("user",userById);
        userService.modifyUserById(new User_m(id,username,password,0,null,null));

        return "redirect:/modifyUser?username=" + id;

    }



    // 课程增删  未写SQL  课程信息的添加、修改和删除
    @GetMapping("/insertCourseById")
    @Secured({"ROLE_admin"})
    public String insertCourseById(@RequestParam("cId") int cId,@RequestParam("cName") String cName){

        Course course = new Course(cId,cName);
        userService.insertCourseById(course);
        return "admin/course";
    };

    @GetMapping("/deleteCourseById")
    @Secured({"ROLE_admin"})
    public String deleteCourseById(int cid){
        userService.deleteCourseById(cid);
        return "admin/course";
    };

    @GetMapping("/modifyCourseById")
    @Secured({"ROLE_admin"})
    public String modifyCourseById(@RequestParam("cId") int cId,@RequestParam("cName") String cName){
        Course course = new Course(cId,cName);
        userService.modifyCourseById(course);
        return "admin/course";
    };

    // 班级的 增删 未写 SQL 班级信息的添加、修改和删除
    @GetMapping("/insertClassById")
    @Secured({"ROLE_admin"})
    public String insertClassById(@RequestParam("sId") int sId,@RequestParam("sName") String sName){

        Sclass sclass = new Sclass(sId,sName,null);
        userService.insertClassById(sclass);
        return "admin/sclass";
    };

    @GetMapping("/deleteClassById")
    @Secured({"ROLE_admin"})
    public String deleteClassById(int sId){
        userService.deleteClassById(sId);
        return "admin/sclass";
    };

    @GetMapping("/modifyClassById")
    @Secured({"ROLE_admin"})
    public String modifyClassById(@RequestParam("sId") int sId,@RequestParam("sName") String sName){
        Sclass sclass = new Sclass(sId,sName,null);
        userService.modifyClassById(sclass);
        return "admin/sclass";
    };




    @GetMapping("/selectCourseAll")
    @Secured({"ROLE_admin"})
    @ResponseBody
    public DataVO<CourseAndUserName> selectCourseAll(){
        List<CourseAndUserName> courseAndUserName = userService.findCourseAll();
        DataVO<CourseAndUserName> dataVO = new DataVO<CourseAndUserName>();
        dataVO.setCode(0);
        dataVO.setData(courseAndUserName);
        return dataVO;
    }

    @GetMapping("/insertChoose")
    @Secured({"ROLE_admin"})
    public String insertChooseClass(@RequestParam("uid") int uid, @RequestParam("cid") int cid){
        userService.insertCourseWithUserById(new CourseWithUserToUser(uid,cid));
        return "admin/chooseCourse";
    }

    @GetMapping("/modifyCourseClass")
    @Secured({"ROLE_admin"})
    public String modifyCourseClass(HttpSession session,@RequestParam("cid") int cid,@RequestParam("id") int id){

        int i =userService.modifyCourseWithUserById(new CourseWithUserToUser(id,cid));
        DataVO<String> dataVO = new DataVO<>();
        if (i>0)
            dataVO.setCode(0);
        dataVO.setCode(1);
        return "admin/chooseCourse";
    }

    @GetMapping("/deleteCourseClass")
    @Secured({"ROLE_admin"})
    public String deleteCourseClass(@RequestParam("cid") int cid,HttpSession session){
        DataVO<String> dataVO = new DataVO<>();
        int i = userService.deleteCourseWithUserById(cid);
        if (i>0)
            dataVO.setCode(0);
        dataVO.setCode(1);
        return "admin/chooseCourse";
    }

}
