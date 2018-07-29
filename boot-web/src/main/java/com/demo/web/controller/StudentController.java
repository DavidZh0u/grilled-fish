package com.demo.web.controller;

import com.demo.web.entity.Course;
import com.demo.web.entity.Smsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @PostMapping(value = "/test/msg", produces = "application/json")
    @ResponseBody
    public void smsStatusReport(@RequestBody Course request) {
        System.out.println(request);
        for(Smsg smsg : request.getDataList()){
            System.out.println(smsg);
        }
    }



}
