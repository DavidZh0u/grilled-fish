/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: AdminUserDaoMapper
 * Author:   雷声正
 * Date:     2018-03-20 18:08
 */
package com.demo.dao.mapper;

import com.demo.model.db.AdminUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "adminUserDaoMapper")
public interface AdminUserDaoMapper {

    @Results(id = "adminUser", value = {
            @Result(property="loginNo",column="login_no"),
            @Result(property="password",column="password"),
            @Result(property="nickname",column="nickname"),
            @Result(property="sex",column="sex"),
            @Result(property="createTime",column="create_time"),
            @Result(property="updateTime",column="update_time"),
            @Result(property="remark",column="remark"),
    })
    @Select("SELECT * FROM admin_user ORDER BY create_time DESC")
    List<AdminUser> getAdminUserAllByDesc();

    @ResultMap("adminUser")
    @Select("SELECT * FROM admin_user where nickname = #{nickname} limit 1;")
    AdminUser getAdminUserByName(@Param("nickname") String nickname);

    @Insert("insert into admin_user (" +
            "login_no, " +
            "password, " +
            "nickname, " +
            "sex, " +
            "create_time, " +
            "update_time, " +
            "remark) " +
            "values (" +
            "#{loginNo}, " +
            "#{password}, " +
            "#{nickname}, " +
            "'man', " +
            "sysdate(), " +
            "sysdate(), " +
            "#{remark})")
    int insert(AdminUser data);

    @Update("UPDATE admin_user SET " +
            "password = #{password}," +
            "update_time = sysdate() " +
            "WHERE nickname = #{nickname}")
    void update(AdminUser data);

    @Update("delete admin_user WHERE nickname=#{nickname}")
    void delete(String nickname);

}