package com.demo;

import com.demo.dao.mapper.AdminUserDaoMapper;
import com.demo.dao.mapper.StudentDaoMapper;
import com.demo.model.db.AdminUser;
import com.demo.model.db.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    public AdminUserDaoMapper adminUserDaoMapper;

    @Autowired
    public StudentDaoMapper studentDaoMapper;

    @Test
    public void insert(){
        AdminUser user = new AdminUser();
        user.setLoginNo("admin");
        user.setPassword("123456");
        user.setNickname("daxia");
        user.setSex("man");
        user.setRemark("测试数据库访问。。。");
        adminUserDaoMapper.insert(user);
    }

    @Test
    public  void select(){
        adminUserDaoMapper.getAdminUserByName("daxia");
    }

    @Test
    public void insertStu(){
        Student student = new Student();
        student.setName("jack");
        student.setStuClass(2);
        student.setStuGrade(1);
        student.setCourse("pe");
        student.setScore(60);
        student.setStatus(true);
        studentDaoMapper.insert(student);
    }
}
