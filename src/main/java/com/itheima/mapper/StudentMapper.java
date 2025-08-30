package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 分页查询学生列表
     */

    List<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学生信息
     */
    void DeleteStudentById(@Param("ids") List<Integer> ids);

    /**
     * 添加学员信息
     */
    void AddStudent(Student student);
}
