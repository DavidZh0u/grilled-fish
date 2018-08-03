package com.demo.web.controller;

import com.demo.model.base.Page;
import com.demo.model.db.Student;
import com.demo.model.entity.StudentSelectCmd;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/editPage")
    public String gotoEditPage(ModelMap map,Student stu){

        if(stu.getId() != null){
            stu = studentService.findStuById(stu.getId());
        }
        System.out.println(stu);
        map.addAttribute("stu",stu);
        return "student-edit";
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public String editStudent(Student stu){
        String result = "falie";
        int flag = studentService.updateStudent(stu);
        if(flag>=1){
            result = "success";
        }

       return result;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String addStudent(Student stu){
        String result = "falie";
        int flag = studentService.addStudent(stu);
        if(flag>=1){
            result = "success";
        }

        return result;
    }
}
