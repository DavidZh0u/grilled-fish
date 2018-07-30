package com.demo.model.base;

import lombok.Data;

@Data
public class Page {
    private long total;
    private int pages;
    private int num;
    private int size;
    public Page(){
        this.num = 1;
        this.size = 10;
    }
}
