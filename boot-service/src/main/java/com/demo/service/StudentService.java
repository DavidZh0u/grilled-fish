package com.demo.service;

import com.demo.model.base.Page;
import com.demo.model.db.Student;
import com.demo.model.entity.StudentSelectCmd;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(Page page, StudentSelectCmd stuCmd);

    Student findStuById(int id);

    int addStudent(Student stu);

    int updateStudent(Student stu);

    int deleteStudent(int id);

}
