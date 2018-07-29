package com.demo.service;

import com.demo.model.base.Page;
import com.demo.model.db.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(Page page);

    int addStudent(Student stu);

    int updateStudent(Student stu);

    int deleteStudent(int id);

}
