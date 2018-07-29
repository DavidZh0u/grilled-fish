package com.demo.model.db;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminUser {

    private String loginNo;
    private String password;
    private String nickname;
    private String sex;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String remark;

}
