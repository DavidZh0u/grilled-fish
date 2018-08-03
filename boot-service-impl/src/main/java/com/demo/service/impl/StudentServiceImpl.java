package com.demo.service.impl;

import com.demo.dao.mapper.StudentDaoMapper;
import com.demo.model.base.Page;
import com.demo.model.db.Student;
import com.demo.model.entity.StudentSelectCmd;
import com.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDaoMapper studentDaoMapper;

    @Override
    public List<Student> getAllStudent(Page page,StudentSelectCmd stuCmd){
        PageHelper.startPage(page.getNum(), page.getSize());
        List<Student> list = studentDaoMapper.selectAll(stuCmd);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        page.setPages(pageInfo.getPages());
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Override
    public Student findStuById(int id){
        return  studentDaoMapper.findStuById(id);
    }

    @Override
    public int addStudent(Student stu){
        return studentDaoMapper.insert(stu);
    }

    @Override
    public int updateStudent(Student stu){
        return  studentDaoMapper.update(stu);
    }

    @Override
    public int deleteStudent(int id){
        return studentDaoMapper.delete(id);
    }

}
