package com.demo.model.db;

import com.demo.model.base.Page;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student extends Page {

    private int id;
    private String name;
    private int stuGrade;
    private int stuClass;
    private String course;
    private int score;
    private boolean status;
    private Timestamp updateTime;

}
