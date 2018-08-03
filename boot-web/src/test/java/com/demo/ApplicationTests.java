package com.demo;

import com.demo.dao.mapper.AdminUserDaoMapper;
import com.demo.dao.mapper.StudentDaoMapper;
import com.demo.model.base.Page;
import com.demo.model.db.AdminUser;
import com.demo.model.db.Student;
import com.demo.model.entity.StudentSelectCmd;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
        Random rom = new Random(47);
        for(int i = 1 ;i <= 97; i++){
            Student student = new Student();
            student.setName("David-"+rom.nextInt(100));
            student.setStuClass("2");
            student.setStuGrade("3");
            student.setCourse("eng");
            int grades = rom.nextInt(100)+1;
            student.setScore(grades);
            student.setStatus(grades>=60?true:false);
            studentDaoMapper.insert(student);
        }
    }

    @Test
    public void selectStu(){
        StudentSelectCmd stu = new StudentSelectCmd();
        //stu.setName("David");
        stu.setStatus(true);
        //使用PageHelper进行分页
        Page page = new Page();
        page.setNum(0);
        page.setSize(10);
        for(int k = 0; k < 5; k++){
            page.setNum(k+1);
            PageHelper.startPage(page.getNum(),page.getSize());
            List<Student> studentList = studentDaoMapper.selectAll(new StudentSelectCmd());
            PageInfo<Student> pageInfo =new PageInfo<Student>(studentList);
            for(Student student : studentList)
                System.out.println(student);
            System.out.println("总页数："+pageInfo.getPages());
            System.out.println("=======================================================");
        }

    }
}
