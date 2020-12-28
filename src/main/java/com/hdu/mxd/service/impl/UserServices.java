package com.hdu.mxd.service.impl;

import com.hdu.mxd.entity.*;
import com.hdu.mxd.mapper.UserAndAuthor;
import com.hdu.mxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/11 16:24
 */
@Service
public class UserServices implements UserService {

    @Autowired
    private UserAndAuthor userAndAuthor;

    @Override
    public List<User_m> findAllUser() {
        return null;
    }

    @Override
    public Course CourseAllStudent(int cid) {
        return null;
    }

    @Override
    public List<User_m> getUserClass() {
        return null;
    }

    @Override
    public User_m studentAllClass(int uid) {
        return null;
    }

    @Override
    public Sclass getClassStudent(int sid) {
        return null;
    }

    @Override
    public int insertCourseById(Course course) {
        int i = userAndAuthor.insertCourseById(course);
        return i;
    }

    @Override
    public int deleteCourseById(int cid) {
        return userAndAuthor.deleteCourseById(cid);
    }

    @Override
    public int modifyCourseById(Course course) {
        return userAndAuthor.modifyCourseById(course);
    }

    @Override
    public int insertClassById(Sclass sclass) {
        return userAndAuthor.insertClassById(sclass);
    }

    @Override
    public int deleteClassById(int sId) {
        return userAndAuthor.deleteClassById(sId);
    }

    @Override
    public int modifyClassById(Sclass sclass) {
        return userAndAuthor.modifyClassById(sclass);
    }

    @Override
    public int findUserIdByUserName(String username) {
        return userAndAuthor.findUserIdByUserName(username);
    }

    @Override
    public int deleteCourseWithUserById(int id) {
        return userAndAuthor.deleteCourseWithUserById(id);
    }

    @Override
    public int modifyCourseWithUserById(CourseWithUserToUser courseWithUser) {
        return userAndAuthor.modifyCourseWithUserById(courseWithUser);
    }

    @Override
    public int insertUserById(User user) {
        return userAndAuthor.insertUserById(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userAndAuthor.deleteUserById(id);
    }

    @Override
    public User_m findUserById(int id) {
        return userAndAuthor.findUserById(id);
    }

    @Override
    public int modifyUserById(User_m user) {
        return userAndAuthor.modifyUserById(user);
    }

    @Override
    public List<Course> findCourseByUserId(String username) {
        return userAndAuthor.findCourseByUserId(username);
    }

    @Override
    public List<CourseAndUserName> findCourseAll() {
        return userAndAuthor.findCourseAll();
    }

    @Override
    public int insertCourseWithUserById(CourseWithUserToUser courseWithUser) {
        return userAndAuthor.insertCourseWithUserById(courseWithUser);
    }
}
