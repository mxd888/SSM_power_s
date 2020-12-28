package com.hdu.mxd.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdu.mxd.entity.Course;
import com.hdu.mxd.entity.Sclass;
import com.hdu.mxd.entity.User;
import com.hdu.mxd.mapper.CourseMapper;
import com.hdu.mxd.mapper.SclassMapper;
import com.hdu.mxd.mapper.UserMapper;
import com.hdu.mxd.service.UserService_jhs;
import com.hdu.mxd.vo.CourseVO;
import com.hdu.mxd.vo.DataVO;
import com.hdu.mxd.vo.SclassVO;
import com.hdu.mxd.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService_jhs {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SclassMapper sclassMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public DataVO<UserVO> findData(Integer page, Integer limit) {
        DataVO dataVO=new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        IPage<User> userIPage=new Page<>(page,limit);
        IPage<User> result=userMapper.selectPage(userIPage,null);
        dataVO.setCount(result.getTotal());
        List<User> list=result.getRecords();
        List<UserVO> UserVOList=new ArrayList<>();
        for (User user:list){
            UserVO userVO=new UserVO();
            BeanUtils.copyProperties(user,userVO);
            UserVOList.add(userVO);
        }
        dataVO.setData(UserVOList);
        return dataVO;
    }

    @Override
    public DataVO<SclassVO> findDataclass(Integer page, Integer limit) {
        DataVO dataVO=new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        IPage<Sclass> userIPage=new Page<>(page,limit);
        IPage<Sclass> result=sclassMapper.selectPage(userIPage,null);
        dataVO.setCount(result.getTotal());
        List<Sclass> list=result.getRecords();
        List<SclassVO > SclassVOList=new ArrayList<>();
        for (Sclass sclass:list){
            SclassVO sclassVO=new SclassVO();
            BeanUtils.copyProperties(sclass,sclassVO);
            SclassVOList.add(sclassVO);
        }
        dataVO.setData(SclassVOList);
        return dataVO;
    }

    @Override
    public DataVO<CourseVO> findDatacourse(Integer page, Integer limit) {
        DataVO dataVO=new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        IPage<Course> userIPage=new Page<>(page,limit);
        IPage<Course> result=courseMapper.selectPage(userIPage,null);
        dataVO.setCount(result.getTotal());
        List<Course> list=result.getRecords();
        List<CourseVO > CourseVOList=new ArrayList<>();
        for (Course course:list){
            CourseVO courseVO=new CourseVO();
            BeanUtils.copyProperties(course,courseVO);
            CourseVOList.add(courseVO);
        }
        dataVO.setData(CourseVOList);
        return dataVO;
    }
}
