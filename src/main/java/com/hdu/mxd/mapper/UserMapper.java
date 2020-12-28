package com.hdu.mxd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.mxd.entity.Course;
import com.hdu.mxd.entity.StuInCourseAll;
import com.hdu.mxd.entity.User;
import com.hdu.mxd.entity.User_m;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper extends BaseMapper<User> {

    // 一对多  一个学生选好多课
    List<StuInCourseAll> getAllStuInCourse();

    List<StuInCourseAll> getAllStuInCourseById(Integer id);

    // 一对一  一个学生属于一个班级
    User_m getUserM(Integer id);

    //多对多  一个课程下好多学生，一个学生可以选好多课
    // 获取学生所选课程
    List<Course> getStuInCourse(Integer id);
    // 获取课程下的所有学生
    List<User> getCourseInStu(Integer id);
}
