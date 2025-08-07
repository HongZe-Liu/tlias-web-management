package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询的方法
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工方法
     */
    void save(Emp emp);
}
