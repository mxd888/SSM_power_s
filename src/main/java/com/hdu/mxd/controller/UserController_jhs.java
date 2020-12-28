package com.hdu.mxd.controller;


import com.hdu.mxd.service.UserService;
import com.hdu.mxd.service.UserService_jhs;
import com.hdu.mxd.vo.CourseVO;
import com.hdu.mxd.vo.DataVO;
import com.hdu.mxd.vo.SclassVO;
import com.hdu.mxd.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController_jhs {


    @Qualifier("userServiceImpl")
    @Autowired
    private UserService_jhs userService;


    @RequestMapping("/userlist")
//    把上面换成Controller后这里请求的是视图就不行了所以要加上@ResponsrBody
    @ResponseBody
//    有次注解返json数据
    public DataVO<UserVO> userlist(Integer page, Integer limit){

        return userService.findData(page,limit);
    }
    @GetMapping("/{url}")
//    前端把请求传过来这里映射到后端，通过配置的视图解析器找到目标请求
    public String redirect(@PathVariable("url") String url){
        url = "admin/"+url;
        return url;
    }

    @RequestMapping("/sclasslist")
//    把上面换成Controller后这里请求的是视图就不行了所以要加上@ResponsrBody
    @ResponseBody
//    有次注解返json数据
    public DataVO<SclassVO> sclasslist(Integer page, Integer limit){

        return userService.findDataclass(page,limit);
    }
    @RequestMapping("/courselist")
//    把上面换成Controller后这里请求的是视图就不行了所以要加上@ResponsrBody
    @ResponseBody
//    有次注解返json数据
    public DataVO<CourseVO> courselist(Integer page, Integer limit){

        return userService.findDatacourse(page,limit);
    }
}
