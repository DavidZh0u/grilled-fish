package com.demo.dao.mapper;

import com.demo.model.db.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "studentDaoMapper")
public interface StudentDaoMapper {

    @Results(id = "student", value = {
            @Result(property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="stuGrade",column="stu_grade"),
            @Result(property="stuClass",column="stu_class"),
            @Result(property="course",column="course"),
            @Result(property="score",column="score"),
            @Result(property="status",column="status"),
            @Result(property="updateTime",column="update_time"),
    })
    @Select("SELECT * FROM student ORDER BY update_time")
    List<Student> selectAll();

    @Update("UPDATE student SET " +
            "name = #{name}," +
            "stuGrade = #{stu_grade}," +
            "stuClass = #{stu_class}," +
            "course = #{course}," +
            "score = #{score}," +
            "status = #{status}," +
            "update_time = sysdate() " +
            "WHERE id = #{id}")
    int update(Student data);

    @Insert("insert into student (" +
            "name, " +
            "stu_grade, " +
            "stu_class, " +
            "course, " +
            "score, " +
            "status, " +
            "update_time) " +
            "values (" +
            "#{name}, " +
            "#{stuGrade}, " +
            "#{stuClass}, " +
            "#{course}, " +
            "#{score}, " +
            "#{status}, " +
            "sysdate())")
    int insert(Student data);

    @Delete("DELETE student WHERE id = #{id}")
    int delete(Integer id);
}
