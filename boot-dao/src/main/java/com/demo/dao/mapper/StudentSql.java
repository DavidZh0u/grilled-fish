package com.demo.dao.mapper;

import com.demo.model.entity.StudentSelectCmd;
import org.springframework.util.StringUtils;

public class StudentSql {

    public String getAllStudent(StudentSelectCmd studentSelectCmd){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from student where 1=1 ");
        Boolean status = studentSelectCmd.getStatus();
        String stuName = studentSelectCmd.getStuName();
        if(StringUtils.hasText(stuName)){
            sql.append(" and name like '%").append(stuName).append("%' ");
        }
        if(!StringUtils.isEmpty(status)){
            sql.append(" and status = #{status}");
        }
        sql.append(" order by id desc");
        System.out.println(sql.toString());
        return  sql.toString();
    }

}
