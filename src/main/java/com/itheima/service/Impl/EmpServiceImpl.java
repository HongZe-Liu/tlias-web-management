package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 员工管理
 * 使用pagehelper 进行分页
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogMapper empLogMapper;
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult page(EmpQueryParam empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        //3. 封装结果
        Page<Emp> p = (Page<Emp>) empList; // 转换为page，之后调用page的方法完成封装
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 新增员工
     */
    @Transactional(rollbackFor = {Exception.class} ) // 事务管理注解
    @Override
    public void save(Emp emp) {
        try {
            // 1.保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 2. 保存员工工作经历
            List<EmpExpr> exprList = emp.getEmpList();
            // 判断是否为空
            if (!CollectionUtils.isEmpty(exprList)) {
                // 遍历集合，为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                // Batch后缀表示批量保存
                empExprMapper.insetBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),emp.toString());
                // 创建日志对象用于保存操作日志
            empLogService.insertLog(empLog);
                // 调用方法将日志插入到对象中
        }
    }


    /**
     * 删除员工
     */
    @Transactional(rollbackFor = {Exception.class} )
    @Override
    public void delete(List<Integer> ids) {
        // 1. 批量删除员工基本信息
        empMapper.deleteByIds(ids);
        // 2，批量删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }



    /***
     * 根据查询的id返回员工信息
     */
    @Override
    public Emp getInfo(Integer id) {

        return empMapper.getById(id);
    }
    @Transactional(rollbackFor = {Exception.class} )
    @Override
    public void update(Emp emp) {
        // 1.根据id修改员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 2.根据员工修改员工工作经历
        // 2.1 先根据员工id删除原有的工作经历
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        // 设计成List 因为可能传递一个或者多个id进行删除查询，之后根据id删除

        // 2.2 再添加员工新的工作经历
        List<EmpExpr> exprList = emp.getEmpList();
        // 判断集合是否为空
        if(!CollectionUtils.isEmpty(exprList)){
            // 遍历每个工作经历，设置员工ID
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()) );
            // 批量插入所有工作经历到数据库
            empExprMapper.insetBatch(exprList);
        }
    }

}