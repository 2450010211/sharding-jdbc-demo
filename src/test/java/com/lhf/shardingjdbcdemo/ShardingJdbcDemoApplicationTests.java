package com.lhf.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lhf.shardingjdbcdemo.entity.Course;
import com.lhf.shardingjdbcdemo.entity.DicInfo;
import com.lhf.shardingjdbcdemo.entity.User;
import com.lhf.shardingjdbcdemo.mapper.CourseMapper;
import com.lhf.shardingjdbcdemo.mapper.DicInfoMapper;
import com.lhf.shardingjdbcdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.jar.JarOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShardingJdbcDemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DicInfoMapper dicInfoMapper;

    @Test
    public void addCourse() {
        for (int i = 1; i <= 10; i++) {
            courseMapper.insert(new Course((long) i, "Java入门" + i, "Normal" + i,new Date()));
        }
    }

    @Test
    public void selectCourse(){
        Course course = courseMapper.selectById(1280522805808525313L);
        System.out.println(course);
    }

    /*****************************垂直分库测试*********************************/

    @Test
    public void addUser(){
        userMapper.insert(new User("Kobe","0"));
    }

    @Test
    public void selectUser(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",487773593585844225L);
        //userMapper.selectById();//针对主键是id
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }


    /*****************************公共表测试*********************************/
    @Test
    public void addDicInfo(){
        dicInfoMapper.insert(new DicInfo("1","success"));
    }

    @Test
    public void selectDicInfo(){
        DicInfo dicInfo = dicInfoMapper.selectById(1280907786808569858L);
        System.out.println(dicInfo);
    }

    @Test
    public void updateDicInfo() {
        dicInfoMapper.updateById(new DicInfo(1280907786808569858L,"0","fail"));
    }

    @Test
    public void deleteDicInfo() {
        dicInfoMapper.deleteById(1280907786808569858L);
    }


    /*****************************读写分离*********************************/
    @Test
    public void addRW(){
        userMapper.insert(new User("KD","1"));
    }

    @Test
    public void updateOrSelectRW(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("user_name","Durant");
        updateWrapper.set("status","1");
        updateWrapper.eq("user_id",488665023376261121L);    //查询条件
        userMapper.update(new User(),updateWrapper);
        //查询使用的是从库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",488665023376261121L); //查询条件
        User user = userMapper.selectOne(queryWrapper);
        log.info(user.toString());
    }

}
