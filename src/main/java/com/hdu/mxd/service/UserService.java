package com.hdu.mxd.service;


import com.hdu.mxd.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {



    List<User_m> findAllUser();

    Course CourseAllStudent(int cid);

    List<User_m> getUserClass();

    User_m studentAllClass(int uid);

    Sclass getClassStudent(int sid);

    // 课程增删  未写SQL  课程信息的添加、修改和删除
    int insertCourseById(Course course);

    int deleteCourseById(int cid);

    int modifyCourseById(Course course);

    // 班级的 增删 未写 SQL 班级信息的添加、修改和删除
    int insertClassById(Sclass sclass);

    int deleteClassById(int sId);

    int modifyClassById(Sclass sclass);

    int findUserIdByUserName(String username);
    // 学生选课信息的修改和删除 未写 SQL
    int deleteCourseWithUserById(int id);

    int modifyCourseWithUserById(CourseWithUserToUser courseWithUser);

    // 用户增删  学生信息的添加修改和删除
    int insertUserById(User user);

    int deleteUserById(int id);



    User_m findUserById(int id);

    int modifyUserById(User_m user);

    // 未写SQL
    List<Course> findCourseByUserId(String username);

    List<CourseAndUserName> findCourseAll();

    int insertCourseWithUserById(CourseWithUserToUser courseWithUser);



}
