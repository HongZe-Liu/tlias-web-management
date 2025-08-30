package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 学员列表分页查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学员信息
     */
    void DeleteStudentById(List<Integer> ids);

    /**
     * 添加学员
     */
    void AddStudent(Student student);
}
