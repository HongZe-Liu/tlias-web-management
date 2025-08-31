package com.itheima.service.Impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 1. 调用mapper接口查询
        List<Map<String,Object>> list = empMapper.countEmpJobData();// map：pos 教学主管，num 1
        // 2，组装结果并查询
       List<Object> jobList =  list.stream().map(dataMap -> dataMap.get("pos")).toList();
       // 获取职位名称
        List<Object> jobNumber =  list.stream().map(dataMap -> dataMap.get("num")).toList();
        // 获取职位数量
        return new JobOption(jobList,jobNumber);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegree() {return studentMapper.countStudentDegree() ;
    }

    @Override
    public List<Map<String, Object>> getClassCountData() {
        return studentMapper.getClassCount();
    }
}
