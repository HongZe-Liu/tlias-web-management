package com.itheima.service.Impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 1. 补全基础属性 - createtime / updatetime
          dept.setCreateTime(LocalDateTime.now());
          dept.setUpdateTime(LocalDateTime.now());
        // 2. 调用mapper接口插入数据
        deptMapper.insert(dept);
    }

    @Override
    public Dept getbyId(Integer id) {
        return deptMapper.getById(id) ;
    }

    @Override
    public void update(Dept dept) {
        // 1.补全基础信息
        dept.setUpdateTime(LocalDateTime.now());
        // 2.调用mapper接口方法更新部门
        deptMapper.updateDept(dept);
    }


}