package com.demo.model.db;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {

    private Integer id;
    private String name;
    private String stuGrade;
    private String stuClass;
    private String course;
    private int score;
    private boolean status;
    private Timestamp updateTime;

}
