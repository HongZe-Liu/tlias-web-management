package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClassService {

    /**
     * 分页查询
     */

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);


    /**
     * 删除班级
     */

    void DeleteClass(Long id);

    /**
     * 添加班级
     */
    void AddClass(Clazz clazz);

    /**
     * 根据id查询班级信息
     */
    Clazz ReqClass(Long id);

    /**
     * 修改班级信息
     */
    void UpdateClass(Clazz clazz);


    /**
     *  查询全部班级列表
     */
    List<Clazz> FindAllClass();
}
