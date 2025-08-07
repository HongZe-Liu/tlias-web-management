package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 * 使用pagehelper 进行分页
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    private EmpExprMapper empExprMapper;

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

    @Override
    public void save(Emp emp) {
        // 1.保存员工基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        // 2. 保存员工工作经历
        List<EmpExpr> exprList = emp.getEmpList();
            // 判断是否为空
             if(!CollectionUtils.isEmpty(exprList)){
                 // 遍历集合，为empId赋值
                 exprList.forEach(empExpr -> {
                     empExpr.setEmpId(emp.getId());
                 });
                 // Batch后缀表示批量保存
                empExprMapper.insetBatch(exprList);
             }
    }
}