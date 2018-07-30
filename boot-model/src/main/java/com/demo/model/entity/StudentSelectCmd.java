package com.demo.model.entity;

import lombok.Data;

@Data
public class StudentSelectCmd {
    private String stuName;
    private Boolean status = null;
}
