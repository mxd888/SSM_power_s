package com.hdu.mxd.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdu.mxd.entity.Course;
import com.hdu.mxd.entity.StuInCourseAll;
import com.hdu.mxd.entity.User;
import com.hdu.mxd.entity.User_m;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * Created by DELL(mxd) on 2020/12/28 8:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 增
     */
    @Test
    public void testInsert() {
        User user = new User("mxd","mxd1",null);
        int i = userMapper.insert(user);
        userMapper.insert(user);
        System.out.println(i);
    }

    /**
     * 删
     * Collection<? extends Serializable> idList
     */
    @Test
    public void testDelete() {

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("username","mxd");
        wrapper.eq("password","mxd1");
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }

    @Test
    public void testDeleteById() {
        int delete = userMapper.deleteById(45);
        System.out.println(delete);
    }
    // 根据 columnMap 条件，删除记录  DELETE FROM user WHERE password = ? AND username = ?  相当于and
    @Test
    public void testDeleteByMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("username","jkl");
        map.put("password","jhs");
        int delete = userMapper.deleteByMap(map);
        System.out.println(delete);
    }

    // 删除（根据ID 批量删除）
    @Test
    public void testDeleteBatchIds() {
        Collection<Integer> idList = new ArrayList<>();
        idList.add(41);
        idList.add(43);
        idList.add(44);
        int delete = userMapper.deleteBatchIds(idList);
        System.out.println(delete);
    }


    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        // 只修改 所设置的新字段
        User user = new User("mxd","mxd100",null);

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("username","mxd32");
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void testUpdateById() {
        // 只修改 所设置的新字段
        User user = new User(44,"mxd","mxd100",null);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    /**
     * 查所有
     */
    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(10, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectById(40);
        System.out.println(user);
    }

    /**
     * Map<String, Object> map = new HashMap<>();
     *         map.put("username","jkl");
     *         map.put("password","jhs");
     *         作用一样
     *
     *         相当于and
     */
    @Test
    public void testSelectOne() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","m");
        wrapper.eq("password","1");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        Collection<Integer> idList = new ArrayList<>();
        idList.add(38);
        idList.add(46);
        idList.add(48);
        List<User> user = userMapper.selectBatchIds(idList);
        System.out.println(user);
    }

    /**
     * like查询
     * 无条件，即查所有
     * userMapper.selectList(null);
     *
     * SELECT id,username,password,s_id FROM user WHERE username = ? AND password = ?
     * wrapper.eq("username","ju");
     * wrapper.eq("password","ser");
     *
     * SELECT id,username,password,s_id FROM user WHERE username LIKE ?
     * wrapper.like("username","j");
     *
     *SELECT id,username,password,s_id FROM user WHERE username = ? OR password = ?
     * wrapper.eq("username","ju");
     * wrapper.or();
     * wrapper.eq("password","root");
     */
    @Test
    public void testSelectListByWrapper() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","ju");
        wrapper.or();
        wrapper.eq("password","root");
//        wrapper.like("username","j");
        List<User> user = userMapper.selectList(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","m");

        int user = userMapper.selectCount(wrapper);
        System.out.println(user);
    }


    @Test
    public void testSelectPage() {
        System.out.println(("----- selectAll method test ------"));
        IPage<User> userIPage=new Page<>(2,5);
        IPage<User> result=userMapper.selectPage(userIPage,null);
        List<User> list=result.getRecords();
        System.out.println(result.getTotal());
        System.out.println(list);
    }


    /**
     * 王牌！！
     * mybatis-plus 联合查询 、 多对一 、 一对多 、 多对多 。
     */

    // 一对多  一个学生选好多课
    @Test
    public void testGetAllStuInCourse() {
        System.out.println(("----- 王牌测试 ------"));
        List<StuInCourseAll> allStuInCourse = userMapper.getAllStuInCourse();
        System.out.println(allStuInCourse);
    }
    @Test
    public void testGetAllStuInCourseById() {
        System.out.println(("----- 王牌测试 ------"));
        List<StuInCourseAll> allStuInCourse = userMapper.getAllStuInCourseById(2);
        System.out.println(allStuInCourse);
    }


    // 一对一  一个学生属于一个班级
    @Test
    public void testGetUserM() {
        System.out.println(("----- 王牌测试 ------"));
        User_m userM = userMapper.getUserM(2);
        System.out.println(userM);
    }

    //多对多  一个课程下好多学生，一个学生可以选好多课
    // 获取学生所选课程
    @Test
    public void testGetStuInCourse() {
        System.out.println(("----- 王牌测试 ------"));
        List<Course> stuInCourse = userMapper.getStuInCourse(2);
        stuInCourse.forEach(System.out::println);
    }

    // 获取课程下的所有学生
    @Test
    public void testGetCourseInStu() {
        System.out.println(("----- 王牌测试 ------"));
        List<User> courseInStu = userMapper.getCourseInStu(1001);
        courseInStu.forEach(System.out::println);
    }
}