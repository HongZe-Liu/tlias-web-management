package com.itheima.controller;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生相关接口
 */
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学员列表分页查询
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("进行学员列表分页查询");
        PageResult<Student> pageResult =  studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 批量删除学员信息
     */
    @DeleteMapping("{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {
        log.info("删除对应id的学员信息{}",ids);
        studentService.DeleteStudentById(ids);
        return Result.success();
    }

    /**
     * 添加学员
     */
    @PostMapping()
    public Result AddStudent(@RequestBody Student student){
        log.info("添加学员{}",student);
        studentService.AddStudent(student);
        return Result.success();
    }
}
