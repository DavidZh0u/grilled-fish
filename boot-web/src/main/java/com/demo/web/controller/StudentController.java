package com.demo.web.controller;

import com.demo.model.base.Page;
import com.demo.model.db.Student;
import com.demo.model.entity.StudentSelectCmd;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/allStu")
    public String getAllStudent(ModelMap modelMap , StudentSelectCmd stu, Page page){
        List<Student> studentList = studentService.getAllStudent(page,stu);
        modelMap.addAttribute("stulist",studentList);
        modelMap.addAttribute("stu",stu);
        modelMap.addAttribute("page",page);
        return "student";
    }

}
