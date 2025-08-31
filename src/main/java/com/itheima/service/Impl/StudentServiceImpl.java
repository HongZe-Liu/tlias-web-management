package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {



    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学员列表分页查询
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // 设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        // 执行查询，将结果保存到StudentList
        List<Student> StudentList = studentMapper.page(studentQueryParam);

        // 转换为page类型
        Page<Student> p = (Page<Student>) StudentList;

        // 获取总记录数 + 当前页面数据 并封装到PageResult 中返回前端
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 批量删除学员信息
     */
    @Override
    public void DeleteStudentById(List<Integer> ids) {
        studentMapper.DeleteStudentById(ids);
    }

    /**
     * 添加学员
     */
    @Override
    public void AddStudent(Student student) {
        studentMapper.AddStudent(student);
    }

    /**
     * 通过id查询学员信息
     */
    @Override
    public Student ReqStudent(Integer id) {
        return studentMapper.ReqStudent(id);
    }


    /**
     * 更新学生信息
     */
    @Override
    public void UpDateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.UpdateStudent(student);
    }

    /**
     * 更新违纪信息
     */
    @Override
    public void ViolationScore(Integer id, Integer score) {
        studentMapper.violationScore(id,score);
    }


}
