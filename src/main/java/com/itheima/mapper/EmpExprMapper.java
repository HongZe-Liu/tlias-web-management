package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    // 批量保存员工的工作经历
    void insetBatch(List<EmpExpr> exprList);

    // 批量删除员工的工作经历
    void deleteByEmpIds(List<Integer> empIds);
}