package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     */
    List<Dept> findAll();

    /**
     * 根据id进行部门删除
     */
    void deleteById(Integer id);

    /**
     * 添加部门
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     */
    Dept getbyId(Integer id);

    /**
     *  修改部门
     */

    void update(Dept dept);
}