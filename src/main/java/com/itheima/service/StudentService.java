package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过id查询学员信息
     */
    Student ReqStudent(Integer id);


    /**
     * 更新学生信息
     */
    void UpDateStudent(Student student);

    /**
     * 学生违纪信息
     */
    void ViolationScore(Integer id, Integer score);

}
