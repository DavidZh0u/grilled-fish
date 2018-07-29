package com.demo.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String type;
    private String total;
    private List<Smsg> dataList;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
}
