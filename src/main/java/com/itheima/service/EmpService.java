package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface EmpService {
    /**
     * 分页查询的方法
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工方法
     */
    void save(Emp emp);

    /**
     * 删除员工信息
     */

    void delete(List<Integer> ids);

    /**
     * 根据id查询员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     */

    void update(Emp emp);

    /**
     * 员工登录
     */
    LoginInfo login(Emp emp);

}
