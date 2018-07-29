package com.demo.web.entity;

import lombok.Data;

@Data
public class Smsg {
    private String uuid;
    private String phone;
    private String msgID;
    private String submitTime;
    private String state;
    private String name;
}
