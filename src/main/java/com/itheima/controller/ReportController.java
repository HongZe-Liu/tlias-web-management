package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import com.itheima.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
public class ReportController {
    // 创建日志对象
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private ReportService reportService;
    @Autowired
    private StudentService studentService;

    /**
     * 统计员工职位
     */

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工职位人数");
        JobOption jobOption =  reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     * 统计员工性别
     */
    @GetMapping("/empGenderData")
    public Result getGenderData(){
        log.info("统计员工性别");
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 学员学历统计
     */
    @GetMapping("/studentDegreeData")
    public Result getDegreeData(){
        log.info("学员学历统计");
        List<Map<String,Object>> degreeList = reportService.getStudentDegree();
        return Result.success(degreeList);
    }

    /**
     * 班级人数统计
     */
    @GetMapping("studentCountData")
    public Result getClassCountData(){
        log.info("统计班级人数");
        List<Map<String,Object>> classCountDataList = reportService.getClassCountData();
        return Result.success(classCountDataList);
    }
}
